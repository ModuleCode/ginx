package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IMessage;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

import java.io.UnsupportedEncodingException;


public class Request implements IRequest {
    //已经和客户端建立好的连接
    private IConnection conn;
    private IMessage message;

    public Request(IConnection conn, IMessage message) {
        this.conn = conn;
        this.message = message;
    }

    //得到当前连接
    @Override
    public IConnection getConnection() {
        return conn;
    }

    @Override
    public byte[] getData() {
        return this.message.getData();
    }

    @Override
    public int getMsgID() {
        return this.message.getMsgID();
    }

    @Override
    public String getString(String charsetName) throws UnsupportedEncodingException {
        return new String(this.message.getData(), charsetName);
    }

    //获取数据

}
