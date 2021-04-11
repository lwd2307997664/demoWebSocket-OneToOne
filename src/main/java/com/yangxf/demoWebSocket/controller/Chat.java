/**
 * FileName: Chat
 * Author:   linwd
 * Date:     2021/4/5 14:02
 * Description: 点对点封装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangxf.demoWebSocket.controller;

/**
 * 〈一句话功能简述〉<br> 
 * 〈点对点封装类〉
 *
 * @author linwd
 * @create 2021/4/5
 * @since 1.0.0
 */
public class Chat {
    private String to;

    private String from;

    private String context;

    public Chat() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
