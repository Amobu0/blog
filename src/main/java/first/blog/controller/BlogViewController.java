package first.blog.controller;

import first.blog.domain.Article;
import first.blog.dto.ArticleViewResponse;
import first.blog.service.BlogService;
import first.blog.dto.ArticleListViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<Article> all = blogService.findAll();
        List<ArticleListViewResponse> articles = all
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles);

        return "/articleList";
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable("id") long id, Model model) {
        Article findArticle = blogService.findById(id);
        ArticleViewResponse article = new ArticleViewResponse(findArticle);
        model.addAttribute("article", article);

        return "/article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false, name = "id") Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "/newArticle";
    }
}
