package com.modulecode.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public interface IConnection {
    void start();            //启动连接，让当前连接开始工作

    void stop() throws IOException;                //停止连接，结束当前连接状态M

    Socket getTCPSocket();  //从当前连接获取原始的socket Socket

    int getConnID();                //获取当前连接ID

    InetAddress remoteAddr();            //获取远程客户端地址信息

    void sendMsg(int msgid, byte[] data);         //直接将Message数据发送数据给远程的TCP客户端(无缓冲)

    void setProperty(String key, Object value);        //设置链接属性

    Object getProperty(String key);    //获取链接属性

    void removeProperty(String key);                        //移除链接属性

}
