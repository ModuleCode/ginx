package com.modulecode.net.impl;

import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

import java.io.IOException;

/**
 * 实现 IRouter   嵌入BaseRouter基类 ，这样可以有选择的重写某些方法
 */
public abstract class BaseRouter implements IRouter {
    @Override
    public void preHandle(IRequest request) throws IOException {

    }

    @Override
    public void handle(IRequest request) throws IOException {

    }

    @Override
    public void postHandle(IRequest request) throws IOException {

    }
}
