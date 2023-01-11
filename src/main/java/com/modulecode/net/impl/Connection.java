package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRouter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Arrays;

public class Connection implements IConnection {
    private static final Logger logger = LogManager.getLogger(Connection.class);
    Socket conn;
    int connid;
    boolean isClosed;


    //告诉当前连接已经退出/停止
    boolean exitChan;

    //当前处理的router
    IRouter router;

    @Override
    public void start() {
        logger.info("Conn start().. connid= {}", connid);
        //启动当前连接的读数据业务
        new Thread(() -> {
            try {
                startReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

    private void startReader() throws IOException {
        logger.info("Reader is running...");
        for (; ; ) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(conn.getInputStream().available());
            if (conn.getInputStream().available() == 0) {
                continue;
            }
            //每次一次性读取多少字节
            byte[] bytes = new byte[1024];
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes, "utf-8"));
            conn.getInputStream().read(bytes);
            //从路由，找到绑定的对应 router
            Request request = new Request(this, bytes);
            //执行注册的路由方法
            this.router.preHandle(request);
            this.router.handle(request);
            this.router.postHandle(request);
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
        return 0;
    }

    @Override
    public Inet4Address remoteAddr() {
        return null;
    }

    @Override
    public void sendMsg(int msgid, byte[] data) {

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

