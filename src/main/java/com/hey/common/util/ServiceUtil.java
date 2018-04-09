package com.hey.common.util;

import com.hey.common.exception.ServiceException;

/**
 * Created by heer on 2018/3/29.
 */
public class ServiceUtil {

    public static void isTrue(boolean expression, String error){
        if(!expression) {
            throw new ServiceException(error);
        }
    }
}
