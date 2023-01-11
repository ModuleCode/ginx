package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

import java.net.Socket;

public class Request implements IRequest {
    //已经和客户端建立好的连接
    private IConnection conn;
    private byte[] data;

    //得到当前连接
    @Override
    public IConnection getConnection() {

        return conn;
    }

    //获取数据
    @Override
    public byte[] GetData() {
        return data;
    }

    @Override
    public int GetMsgID() {
        return 0;
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
