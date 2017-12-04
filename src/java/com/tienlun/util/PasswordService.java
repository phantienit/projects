/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.util;

import java.security.MessageDigest;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author tienpv
 */
public class PasswordService {

    private static final Logger logger = Logger.getLogger(PasswordService.class);

    public static String encryption(String str) {
        byte[] defaultBytes = str.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            str = hexString + "";
        } catch (Exception ex) {
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
        }
        return str;
    }
}
