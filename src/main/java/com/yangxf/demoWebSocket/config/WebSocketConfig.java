package com.yangxf.demoWebSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈WebSocket的配置类〉
 *
 * @author linwd
 * @create 2021/4/5
 * @since 1.0.0
 */
@Configuration
@EnableWebSocketMessageBroker//开启WebSocket的消息代理
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * 设置消息代理的前缀
         * 即如果消息前缀是/topic，就会将消息转给消息代理，再有消息代理广播给当前连接的客户端；
         */
        registry.enableSimpleBroker("/topic","/queue");//分别对群和对点发送
        /**
         * 表示配置一个或多个前缀，通过这些前缀过滤出需要被注解处理的消息
         */
        registry.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 定义一个前缀为“/chat”的endPoint
         */
        registry.addEndpoint("/endpointChat").setAllowedOrigins("*").withSockJS();
    }

}
