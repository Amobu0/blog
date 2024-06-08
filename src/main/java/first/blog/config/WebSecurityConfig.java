
/*

package first.blog.config;

import first.blog.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {
    private final UserDetailService userDetailService;

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring()
                .requestMatchers("/static/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/login", "/signup", "/user").permitAll()
                .anyRequest().authenticated());


        http.formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/articles"));
//                .failureUrl("/login?loginFail=200") // 로그인 실패 후 이동 페이지
//                .usernameParameter("email") //아이디 파라미터명 설정
//                .passwordParameter("password")// 패스워드 파라미터 설정);

        http.logout(logout -> logout
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login"));

        http.csrf(CsrfConfigurer::disable);

        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager (HttpSecurity http,
//                                                        BCryptPasswordEncoder bCryptPasswordEncoder,
//                                                        UserDetailService userDetailService) {
//        return http.getSharedObject(AuthenticationManager.class)
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
*/
