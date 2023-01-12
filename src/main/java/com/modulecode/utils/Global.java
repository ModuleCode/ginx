package com.modulecode.utils;

import com.modulecode.net.IServer;

/**
 * 存储一些关于 GINX 框架 的全局参数,供其他模块使用 用json配置
 */
public class Global {
    IServer server;
    String host;
    int tcpPort;
    String name;
    String version;
    int maxconn;
    int maxPackSize;
    public static Global global = new Global("0.0.0.0", 8990, "Server", "0.1", 3, 1024);


    public Global(String host, int tcpPort, String name, String version, int maxconn, int maxPackSize) {
        this.host = host;
        this.tcpPort = tcpPort;
        this.name = name;
        this.version = version;
        this.maxconn = maxconn;
        this.maxPackSize = maxPackSize;
    }

    public void reload() {
        java.net.URL uri = this.getClass().getResource("/ginx.json");
        System.out.println(uri);
    }
}
