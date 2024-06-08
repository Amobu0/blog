package first.blog.controller;

import first.blog.domain.Article;
import first.blog.dto.AddArticleRequest;
import first.blog.dto.ArticleResponse;
import first.blog.dto.UpdateArticleRequest;
import first.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    //HTTP 메서드가 POST 일 때 전달받은 URL 이 돌일하면 메서드로 매핑
    @PostMapping("/api/articles")
    // @RequestBody 로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request, Principal principal) {
        Article saveArticle = blogService.save(request, principal.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.status(HttpStatus.OK)
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable("id") long id) {
        Article article = blogService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Long> deleteArticle(@PathVariable("id") long id) {
        long deletedID = blogService.delete(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(deletedID);
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticles(@PathVariable("id") long id,
                                                  @RequestBody UpdateArticleRequest request) {
        Article updateArticle = blogService.update(id, request);

        return ResponseEntity.status(HttpStatus.OK)
                .body(updateArticle);
    }
}
