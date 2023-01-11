package com.modulecode;

import com.modulecode.net.impl.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        //1 Create the server object
        var server = new Server();
        //2 Configure user-defined routes and services
        server.addRouter(0, new PingRouter());
        //3 Start the service
        server.serve();

//        logger.trace("trace level");
//        logger.debug("debug level");
//        logger.info("info level");
//        logger.warn("warn level");
//        logger.error("error level");
//        logger.fatal("fatal level");



    }
}

