package com.modulecode.net;

public interface IConnManager {
    void add(IConnection conn);                   //添加链接

    void remove(IConnection conn);                //删除连接

    IConnection get(int connID);                  //利用ConnID获取链接

    int len();                                    //获取当前连接

    void clearConn();                             //删除并停止所有链接


}
