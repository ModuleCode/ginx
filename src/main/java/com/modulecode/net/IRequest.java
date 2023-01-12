package com.modulecode.net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 提供连接请求全部接口声明,把请求的连接信息和请求数据包装到了 Request 中
 */
public interface IRequest {
    IConnection getConnection();  //获取请求连接信息

    byte[] getData();            //获取请求消息的数据

    int getMsgID();           //获取请求的消息ID

    String getString(String charsetName) throws UnsupportedEncodingException; //获取请求消息字符串
//
//    void bindRouter(IRouter router); //绑定这次请求由哪个路由处理
//
//    void next();                     //转进到下一个处理器开始执行 但是调用此方法的函数会根据先后顺序逆序执行
//
//    void abort();                    //终止处理函数的运行 但调用此方法的函数会执行完毕

}
