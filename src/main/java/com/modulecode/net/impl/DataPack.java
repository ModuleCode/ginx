package com.modulecode.net.impl;

import com.modulecode.exception.PackageMaxException;
import com.modulecode.net.IDataPack;
import com.modulecode.net.IMessage;
import com.modulecode.utils.Global;

import java.io.*;

public class DataPack implements IDataPack {

    @Override
    public int getHeadLen() {
        return 8;
    }

    @Override
    public byte[] pack(IMessage msg) throws IOException {
        //创建一个输出缓冲区并写入
        ByteArrayOutputStream dataBuff = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(dataBuff);
        dataOutputStream.writeInt(msg.getDataLen());
        dataOutputStream.writeInt(msg.getMsgID());
        dataOutputStream.write(msg.getData());
        return dataBuff.toByteArray();
    }

    @Override
    public IMessage unPack(InputStream inputStream) throws IOException {
        //创建一个输入缓冲区并读取
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int len = dataInputStream.readInt();
        //读取的id
        int id = dataInputStream.readInt();
        //每次一次性读取多少字节
        byte[] bytesData = new byte[len];
        dataInputStream.read(bytesData);
        int maxPackageSize = Global.global.reloadGinxConfig().getMaxPackageSize();
        //判断长度
        if (len > maxPackageSize) {
            throw new PackageMaxException();
        }


        return new Message(id, len, bytesData);
    }
}
