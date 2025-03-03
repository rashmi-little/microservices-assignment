package com.mindfire.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {
    /**
     * Description: Defines route configurations for API Gateway, mapping request
     * paths to their respective microservices and applying rate limiting filters.
     *
     * @param builder The RouteLocatorBuilder used to define routes.
     * @return A configured RouteLocator with defined service routes.
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("employee-management-service",
                        r -> r.path("/api/v1/employees/**")
                                .filters(f -> f.requestRateLimiter().configure(c -> c.setRateLimiter(redisRateLimiter())))
                                .uri("lb://EMPLOYEE-MANAGEMENT-SERVICE"))

                .route("performance-and-feedback",
                        r -> r.path("/api/v1/feedbacks/**").filters(
                                        f -> f.requestRateLimiter().configure(c -> c.setRateLimiter(redisRateLimiter())))
                                .uri("lb://PERFORMANCE-AND-FEEDBACK"))

                .build();
    }

    /**
     * Description: Configures a Redis-based rate limiter to restrict the number of
     * requests per second to protect services from excessive traffic.
     *
     * @return A RedisRateLimiter instance with defined limits.
     */
    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 2);
    }

    /**
     * Description: Defines a key resolver for rate limiting, using the client's IP
     * address as the key to track request counts.
     *
     * @return A KeyResolver that extracts the client IP address for rate limiting.
     */
    @Bean
    public KeyResolver keyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}

