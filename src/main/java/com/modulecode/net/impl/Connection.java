package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IDataPack;
import com.modulecode.net.IMessage;
import com.modulecode.net.IRouter;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Connection implements IConnection {
    private static final Logger logger = LogManager.getLogger(Connection.class);
    Socket conn;
    int connid;
    boolean isClosed;


    //告诉当前连接已经退出/停止
    boolean exitChan;

    //当前处理的router
    IRouter router;
    @Getter
    @Setter
    IDataPack dataPack;

    @Override
    public void start() {
        logger.info("one player join in connid= {}", connid);
        //启动当前连接的读数据业务
        new Thread(() -> {
            try {
                startReader();
            } catch (IOException e) {
                System.out.println(e);
                logger.error(e.getMessage());
            }
        }).start();


    }

    private void startReader() throws IOException {
        //循环读取
        //读取一个int的长度
        DataInputStream dataInputStream = new DataInputStream(conn.getInputStream());
        for (; ; ) {
            if (dataInputStream.available() > 0) {
                //如果这个包不存在 就创建
                if (this.dataPack == null) {
                    this.dataPack = new DataPack();
                }
                //从路由，找到绑定的对应 router
                IDataPack dataPack = this.dataPack;
                IMessage iMessage = dataPack.unPack(dataInputStream);
                Request request = new Request(this, iMessage);
                //执行注册的路由方法
                this.router.preHandle(request);
                this.router.handle(request);
                this.router.postHandle(request);
            }

        }


    }

    @Override
    public void stop() throws IOException {
        logger.info("Conn stop().. connid= {}", connid);
        //如果连接已经关闭
        if (isClosed) {
            return;
        }
        isClosed = true;

        //关闭socket连接
        conn.close();
    }

    @Override
    public Socket getTCPSocket() {
        return conn;
    }

    @Override
    public int getConnID() {
        return connid;
    }

    @Override
    public InetAddress remoteAddr() {
        return conn.getInetAddress();
    }

    @Override
    public void sendMsg(int msgid, byte[] data) {

        try {
            byte[] binaryMsg = dataPack.pack(new Message(msgid, data.length, data));
            conn.getOutputStream().write(binaryMsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setProperty(String key, Object value) {

    }

    @Override
    public Object getProperty(String key) {
        return null;
    }

    @Override
    public void removeProperty(String key) {

    }

    public Connection(Socket conn, int connid, IRouter router) {
        this.conn = conn;
        this.connid = connid;
        this.router = router;
        this.isClosed = false;
        this.exitChan = false;
    }
}

