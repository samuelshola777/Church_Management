package com.example.churchmanagement.appConfig;

import com.restfb.DefaultFacebookClient;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.Version;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacebookConfig {
    @Value("${facebook.appId}")
    private String appId;

    @Value("${facebook.appSecret}")
    private String appSecret;

    @Bean
    public FacebookClient facebookClient() {
        return new DefaultFacebookClient(Version.LATEST);
    }

//    @Bean
//    public Facebook facebook(FacebookClient facebookClient) {
//        return new FacebookTemplate(appId + "|" + appSecret, Version.LATEST);
//    }
}
