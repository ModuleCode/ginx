package com.modulecode.net.impl;

import com.modulecode.entity.GinxConfig;
import com.modulecode.net.*;
import com.modulecode.net.funcs.HandleFunc;
import com.modulecode.utils.Global;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements IServer {
    private static final Logger logger = LogManager.getLogger(Server.class);
    private GinxConfig ginxConfig;

    private String configUrl; //配置文件路径

    //目前一个Server只能绑定一个 router
    private IRouter router;


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
        this.ginxConfig = new GinxConfig();
        this.ginxConfig.setHost("0.0.0.0");
        this.ginxConfig.setTcpPort(9090);
        this.ginxConfig.setName("SERVER");
        this.ginxConfig.setMaxConn(5);
        this.ginxConfig.setIpVersion("IPV4");
        printLogoImageStr();
        //如果默认配置文件存在 就直接去覆盖当前配置
        if (Global.global.reloadGinxConfig() != null) {
            this.ginxConfig = Global.global.reloadGinxConfig();

        }
    }

    //直接去读取指定的json文件
    public Server(String configUrl) {
        this.configUrl = configUrl;
        this.ginxConfig = Global.global.reloadGinxConfig(configUrl);
        printLogoImageStr();
    }

    public void printLogoImageStr() {
        System.out.println(ginxConfig.getLogoImageStr());
        System.out.printf("""
                 ===========================================================================
                 :: GINX ::                                                       (V%s)
                """, ginxConfig.getVersion());

    }

    @Override
    public void start() {
        logger.info("[START] Server name: {},listenner at IP: {}, Port {} is starting", ginxConfig.getName(), ginxConfig.getHost(), ginxConfig.getTcpPort());
        var cid = 0;
        try {
            ServerSocket listener = new ServerSocket(ginxConfig.getTcpPort(), 50, Inet4Address.getByName(ginxConfig.getHost()));
            for (; ; ) {
                //如果有客户端进入则会返回
                Socket client = listener.accept();
                Connection connection = new Connection(client, cid, router);
                connection.start();
                cid++;
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
        this.router = router;
        logger.info("添加路由{}成功", router);
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
