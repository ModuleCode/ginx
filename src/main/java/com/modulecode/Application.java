package com.modulecode;

import com.modulecode.net.IRequest;
import com.modulecode.net.impl.BaseRouter;
import com.modulecode.net.impl.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        var server = new Server("ginx.json");
        //3 Start the service
        server.serve();
    }

}


