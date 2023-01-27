package com.sdut.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Projectname: Cloud
 * @Filename: TokenFilter
 * @Author: SpringForest
 * @Data:2023/1/8 20:42
 * @Description:
 */

@Component
public class TokenFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //从请求头中获取Token
        //String token = exchange.getRequest().getHeaders().getFirst("Token");
        //if (StringUtils.isEmpty(token)) {
        //    //若没有token则为登陆，拦截请求
        //    //设置未登陆状态码
        //    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //    //拦截请求
        //    return exchange.getResponse().setComplete();
        //}

        //放行
        return chain.filter(exchange);
    }

    //定义过滤器的优先级
    @Override
    public int getOrder() {
        return -1;
    }
}
