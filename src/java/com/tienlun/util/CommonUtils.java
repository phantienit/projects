/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.util;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author ict-os27
 */
public class CommonUtils implements Serializable {

    private static final long serialVersionUID = 1L;
    private static CommonUtils instance;
    private static final Logger logger = Logger.getLogger(CommonUtils.class);

    public CommonUtils() {
        logger.info("Singleton(): Initializing Instance");
    }

    public static CommonUtils getInstance() {
        synchronized (CommonUtils.class) {
            if (instance == null) {
                logger.info("getInstance(): First time getInstance was invoked!");
                instance = new CommonUtils();
            }
        }
        return instance;
    }

    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
