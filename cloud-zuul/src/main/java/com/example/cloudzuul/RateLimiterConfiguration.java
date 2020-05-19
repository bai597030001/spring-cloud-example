package com.example.cloudzuul;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.DefaultRateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.repository.RateLimiterErrorHandler;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.DefaultRateLimitKeyGenerator;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class RateLimiterConfiguration {

    @Bean
    public RateLimiterErrorHandler rateLimitErrorHandler() {
        System.out.println("exec rateLimitErrorHandler().11111111111111");
        return new DefaultRateLimiterErrorHandler() {
            @Override
            public void handleSaveError(String key, Exception e) {
                System.out.println("have a error : handleSaveError()");
                System.out.println("error msg key : " + key);
            }

            @Override
            public void handleFetchError(String key, Exception e) {
                System.out.println("have a error : handleFetchError()");
                System.out.println("error msg key : " + key);
            }

            @Override
            public void handleError(String msg, Exception e) {
                System.out.println("have a error : handleError()");
                System.out.println("error msg : " + msg);
            }
        };
    }

    @Bean
    public RateLimitKeyGenerator ratelimitKeyGenerator(RateLimitProperties properties, RateLimitUtils rateLimitUtils) {
        return new DefaultRateLimitKeyGenerator(properties, rateLimitUtils) {
            @Override
            public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
                System.out.println("generate my own key");
                return super.key(request, route, policy) + ":" + request.getMethod();
            }
        };
    }
}
