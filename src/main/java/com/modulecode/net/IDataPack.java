package com.modulecode.net;

import java.io.IOException;
import java.io.InputStream;

public interface IDataPack {
    int getHeadLen();                 //获取包头长度方法

    byte[] pack(IMessage msg) throws IOException;//封包方法

    IMessage unPack(InputStream inputStream) throws IOException;   //拆包方法
}
