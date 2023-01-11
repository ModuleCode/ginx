package com.modulecode.net.impl;

import com.modulecode.net.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements IServer {
    private static final Logger logger = LogManager.getLogger(Server.class);
    private String name;
    private String ipVersion;
    private String ip;
    private int port;
    //当前Server的消息管理模块，用来绑定MsgID和对应的处理方法
    private IMsgHandle msgHandler;


    //当前Server的链接管理器
    private IConnManager ConnMgr;
    private IDataPack packet;

    //TODO:不知道怎么去模拟go中的函数
    //该Server的连接创建时Hook函数

    void onConnStart(IConnection conn) {

    }
    //该Server的连接断开时的Hook函数

    void onConnStop(IConnection conn) {

    }

    public Server() {
        this.name = "SERVER";
        this.ipVersion = "ipv4";
        this.ip = "0.0.0.0";
        this.port = 8999;
    }

    public Server(String name, String ipVersion, String ip, int port) {
        this.name = name;
        this.ipVersion = ipVersion;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void start() {
        logger.info("[START] Server name: {},listenner at IP: {}, Port {} is starting", name, ip, port);
        try {
            ServerSocket listener = new ServerSocket(port, 50, Inet4Address.getByName(ip));
            for (; ; ) {
                //如果有客户端进入则会返回
                Socket conn = listener.accept();
                new Thread(() -> {
                    for (; ; ) {
                        byte[] buf = new byte[5];
                        try {
                            conn.getInputStream().read(buf);
                            conn.getOutputStream().write(buf);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void serve() {
        start();
    }

    @Override
    public void addRouter(int msgID, IRouter router) {

    }

    @Override
    public IConnManager getConnMgr() {
        return null;
    }

    @Override
    public void setOnConnStart(Runnable runnable) {

    }

    @Override
    public void setOnConnStop(Runnable runnable) {

    }

    @Override
    public void callOnConnStart(IConnection conn) {

    }

    @Override
    public void callOnConnStop(IConnection conn) {

    }

    @Override
    public IDataPack packet() {
        return null;
    }

}
