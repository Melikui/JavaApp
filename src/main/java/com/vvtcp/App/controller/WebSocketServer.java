package com.vvtcp.App.controller;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@ServerEndpoint("/websocket/{sid}")
public class WebSocketServer {
    // 接口路径 ws://localhost:8080/websocket/sid;
    // 连接会话
    private Session session;

    // WebSocket存储Map
    private static final ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    // 用户sid
    private String sid;

    /**
     * 链接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String sid) {
        this.session = session;
        this.sid = sid;
        webSocketMap.put(sid, this);
        log.info("【websocket连接】有新的连接，总数为: " + webSocketMap.size());
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketMap.remove(sid);
        log.info("【websocket连接】连接断开，总数为: " + webSocketMap.size());
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端" + sid + "消息: " + message);
    }

    /**
     * 发送错误时的处理
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("客户端" + sid + "错误, 原因: " + error.getMessage());
        // error.printStackTrace();
    }

    /**
     * 广播消息
     */
    public void sendAllMessage(String message) {
        log.info("【websocket消息】广播消息: " + message);
        for (WebSocketServer server : webSocketMap.values()) {
            if (server.session.isOpen()) {
                server.session.getAsyncRemote().sendText(message);
            }
        }
    }

    /**
     * 单点消息（单人）
     */
    public void sendOneMessage(String sid, String message) {
        Session session = webSocketMap.get(sid).session;
        log.info("【websocket消息】单点消息: " + message);
        session.getAsyncRemote().sendText(message);
    }

    /**
     * 单点消息（多人）
     */
    public void sendMoreMessage(String[] sids, String message) {
        for (String sid : sids) {
            Session session = webSocketMap.get(sid).session;
            log.info("【websocket消息】单点消息:" + message);
            session.getAsyncRemote().sendText(message);
        }
    }

}