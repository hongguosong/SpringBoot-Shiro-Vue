package com.heeexy.example.config.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 注册一个STOMP的endpoint,并指定使用SockJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").setHandshakeHandler(new DefaultHandshakeHandler() {

            @Override
            protected void handleInvalidUpgradeHeader(ServerHttpRequest request, ServerHttpResponse response) throws IOException {
                super.handleInvalidUpgradeHeader(request, response);
            }

            @Override
            protected void handleInvalidConnectHeader(ServerHttpRequest request, ServerHttpResponse response) throws IOException {
                super.handleInvalidConnectHeader(request, response);
            }

            @Override
            protected boolean isWebSocketVersionSupported(WebSocketHttpHeaders httpHeaders) {
                return super.isWebSocketVersionSupported(httpHeaders);
            }

            @Override
            protected String[] getSupportedVersions() {
                return super.getSupportedVersions();
            }

            @Override
            protected void handleWebSocketVersionNotSupported(ServerHttpRequest request, ServerHttpResponse response) {
                super.handleWebSocketVersionNotSupported(request, response);
            }

            @Override
            protected boolean isValidOrigin(ServerHttpRequest request) {
                return super.isValidOrigin(request);
            }

            @Override
            protected String selectProtocol(List<String> requestedProtocols, WebSocketHandler webSocketHandler) {
                return super.selectProtocol(requestedProtocols, webSocketHandler);
            }

            @Override
            protected List<WebSocketExtension> filterRequestedExtensions(ServerHttpRequest request, List<WebSocketExtension> requestedExtensions, List<WebSocketExtension> supportedExtensions) {
                return super.filterRequestedExtensions(request, requestedExtensions, supportedExtensions);
            }

            @Override
            protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                return super.determineUser(request, wsHandler, attributes);
            }


        }).addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理(Message Broker)
     * @param config
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
}
