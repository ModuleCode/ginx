package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

import java.io.UnsupportedEncodingException;


public class Request implements IRequest {
    //已经和客户端建立好的连接
    private IConnection conn;
    private byte[] data;

    public Request(IConnection conn, byte[] data) {
        this.conn = conn;
        this.data = data;
    }

    //得到当前连接
    @Override
    public IConnection getConnection() {
        return conn;
    }

    //获取数据
    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public int getMsgID() {
        return 0;
    }

    @Override
    public String getData(String charsetName) throws UnsupportedEncodingException {

        return new String(data,charsetName);
    }

    @Override
    public void bindRouter(IRouter router) {

    }

    @Override
    public void next() {

    }

    @Override
    public void abort() {

    }
}
