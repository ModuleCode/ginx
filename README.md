
# <img width="200px" src="https://s1.ax1x.com/2023/01/13/pSK9n2t.png" />

Ginx 是一个基于Java的轻量级并发服务器框架，模仿Golang中的Zinx框架

[![License](https://img.shields.io/badge/License-GPL%203.0-black.svg)](LICENSE)
[![Discord](https://img.shields.io/badge/zinx-Discord在线社区-blue.svg)](https://discord.gg/mmxBAVDfQu)

## 一、写在前面的话
为什么我要开发这款Java服务器，目前Java在服务器方面的框架已经很丰富了，但没有一个面向游戏的简单清亮的服务器，开发这个框架初衷是想做一个简单的TCP游戏服务器，可能后续会加更多功能。这个服务器是模仿Golang的一个叫Zinx的服务器，很多API与他一致。
可能不会和Zinx太一致，欢迎大家一起来维护。

## 二、版本要求
###  1. Java：17
###  2. Maven：3.8.6

## 三、简单使用与运行
### 1.创建并运行服务器
```` java
    //1.create a Server
    var server = new Server("");
    //2 Configure user-defined routes and services
    server.addRouter(0, new PingRouter());
    //3 Start the service
    server.serve();
````
### 2.配置服务器
服务器本身的配置是在代码内的，可以在 #resources 文件夹下创建一个名为 #ginx.json 文件进行配置服务器参数，如：端口 服务器名称等。
``` json
{
  "name": "MyServer",
  "host": "127.0.0.1",
  "tcpPort": 5566
}
```
