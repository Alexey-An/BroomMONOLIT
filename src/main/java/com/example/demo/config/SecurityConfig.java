package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.userDetailsService.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                    .tokenEndpoint().accessTokenResponseClient(new RestOAuth2AccessTokenResponseClient(restOperations()))
                    .and()
                    .userInfoEndpoint()
                        .userService(new UserDetailService(userRepository, restOperations()));
    }

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    public static final String DISCORD_BOT_USER_AGENT = "DiscordBot (https://github.com/fourscouts/blog/tree/master/oauth2-discord)";
}
