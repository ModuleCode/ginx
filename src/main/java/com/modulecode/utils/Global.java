package com.modulecode.utils;

import com.modulecode.entity.GinxConfig;
import com.modulecode.net.IServer;

import java.io.*;
import java.net.URISyntaxException;

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

    public GinxConfig reloadGinxConfig(String url) {
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(url);
            DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
            byte[] bytes = dataInputStream.readAllBytes();
            System.out.println(new String(bytes, "utf-8"));
            GinxConfig ginxConfig = JacksonUtils.json2Bean(new String(bytes, "utf-8"), GinxConfig.class);
            ginxConfig.setConfigUrl(url);
            return ginxConfig;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GinxConfig reloadGinxConfig() {
        return this.reloadGinxConfig("ginx.json");
    }
}
