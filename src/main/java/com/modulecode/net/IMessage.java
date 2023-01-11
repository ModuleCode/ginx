package com.modulecode.net;

/**
 * 提供消息的基本方法
 */
public interface IMessage {
    int getDataLen();  //获取消息数据段长度

    int getMsgID();    //获取消息ID

    byte[] getData();     //获取消息内容

    void setMsgID(int id);   //设计消息ID

    void setData(byte[] data);    //设计消息内容

    void setDataLen(int len); //设置消息数据段长度
}
