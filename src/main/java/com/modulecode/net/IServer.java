package com.modulecode.net;

public interface IServer {
    void start();        //启动服务器方法

    void stop();        //停止服务器方法

    void serve();    //开启业务服务方法

    void addRouter(int msgID, IRouter router); //路由功能：给当前服务注册一个路由业务方法，供客户端链接处理使用

    IConnManager getConnMgr();                //得到链接管理

    void setOnConnStart(Runnable runnable);        //设置该Server的连接创建时Hook函数

    void setOnConnStop(Runnable runnable);        //设置该Server的连接断开时的Hook函数

    void callOnConnStart(IConnection conn);    //调用连接OnConnStart Hook函数

    void callOnConnStop(IConnection conn);        //调用连接OnConnStop Hook函数

    IDataPack packet();
}
