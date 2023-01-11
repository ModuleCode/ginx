package com.modulecode.net;

public interface IRouter {
    void preHandle(IRequest request);  //在处理conn业务之前的钩子方法

    void handle(IRequest request);     //处理conn业务的方法

    void postHandle(IRequest request); //处理conn业务之后的钩子方法
}
