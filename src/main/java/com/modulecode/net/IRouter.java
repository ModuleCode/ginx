package com.modulecode.net;

import java.io.IOException;

public interface IRouter {
    void preHandle(IRequest request) throws IOException;  //在处理conn业务之前的钩子方法

    void handle(IRequest request) throws IOException;     //处理conn业务的方法

    void postHandle(IRequest request) throws IOException; //处理conn业务之后的钩子方法
}
