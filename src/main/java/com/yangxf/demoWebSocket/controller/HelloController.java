/**
 * FileName: HelloController
 * Author:   linwd
 * Date:     2021/4/5 12:07
 * Description: 测试控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangxf.demoWebSocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试控制器〉
 *
 * @author linwd
 * @create 2021/4/5
 * @since 1.0.0
 */
@Controller
public class HelloController {
    Logger logger= LoggerFactory.getLogger(HelloController.class);
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;//通过SimpMessagingTemplate向浏览器发送消息


    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        String from = principal.getName();
        chat.setFrom(from);
        //通过convertAndSendToUser向用户发送消息
        //第1个参数：接收消息的用户
        //第2个参数：浏览器订阅的地址
        //第3个参数：消息本身
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
        logger.info("通过convertAndSendToUser向用户发送消息");
    }
}
