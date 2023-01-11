package com.modulecode.net.impl;

import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

/**
 * 实现 IRouter   嵌入BaseRouter基类 ，这样可以有选择的重写某些方法
 */
public abstract class BaseRouter implements IRouter {
    @Override
    public void preHandle(IRequest request) {

    }

    @Override
    public void handle(IRequest request) {

    }

    @Override
    public void postHandle(IRequest request) {

    }
}
