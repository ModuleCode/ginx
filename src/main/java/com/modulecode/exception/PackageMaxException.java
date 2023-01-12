package com.modulecode.exception;

public class PackageMaxException extends RuntimeException {
    public PackageMaxException() {
        super("发送的包字节数过大");
    }
}
