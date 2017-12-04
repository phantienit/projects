/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.util;

/**
 *
 * @author ict-os27
 */
public final class Constants {

    public interface Status {

        public static final Long ACTIVE = 1L;
        public static final Long INACTIVE = 0L;
    }

    public interface Duplicate {

        public static final String OK = "1";
        public static final String ERROR = "0";
    }

    public interface AttachType {

        public static final String PRODUCT = "product";
    }
}
