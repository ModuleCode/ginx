package com.modulecode.net.funcs;

import java.io.IOException;
import java.net.Socket;

@FunctionalInterface
public interface HandleFunc {
    void handle(Socket socket, byte[] bytes, int len) throws IOException;
}
