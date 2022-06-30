package com.example.demo.service.userDetailsService;

import com.example.demo.entity.User;
import com.example.demo.model.CustomOAuth2User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static com.example.demo.config.SecurityConfig.DISCORD_BOT_USER_AGENT;

@AllArgsConstructor
public class UserDetailService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final RestOperations restOperations;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String userInfoUrl = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", userRequest.getAccessToken().getTokenValue()));
        headers.set(HttpHeaders.USER_AGENT, DISCORD_BOT_USER_AGENT);

        ParameterizedTypeReference<Map<String, Object>> typeReference = new ParameterizedTypeReference<Map<String, Object>>() {};

        ResponseEntity<Map<String, Object>> responseEntity = restOperations.exchange(userInfoUrl, HttpMethod.GET, new HttpEntity<>(headers), typeReference);

        Map<String, Object> userAttributes = responseEntity.getBody();
        User user = new User();
        user.setUsername((String) userAttributes.get("username"));
        user.setId(Long.valueOf((String) userAttributes.get("id")));
        user.setAvatarUrl((String) userAttributes.get("avatar"));
        user.setEmail((String) userAttributes.get("email"));

        userRepository.saveAndFlush(user);

        Set<GrantedAuthority> authorities = Collections.singleton(new OAuth2UserAuthority(userAttributes));

        return new DefaultOAuth2User(authorities, userAttributes, userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName());
    }
}
