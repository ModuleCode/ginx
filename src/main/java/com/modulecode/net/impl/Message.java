package com.modulecode.net.impl;

import com.modulecode.net.IMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements IMessage {
    int id; //消息ID
    int dataLen; //消息长度
    byte[] data; //消息内容

    @Override
    public int getDataLen() {
        return dataLen;
    }

    @Override
    public int getMsgID() {
        return id;
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public void setMsgID(int id) {
        this.id = id;
    }

    @Override
    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public void setDataLen(int len) {
        this.dataLen = len;
    }
}
