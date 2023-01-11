package com.modulecode.net;

public interface IDataPack {
    int getHeadLen();                 //获取包头长度方法

    byte[] pack(IMessage msg);//封包方法

    IMessage Unpack(byte[] bytes);   //拆包方法
}
