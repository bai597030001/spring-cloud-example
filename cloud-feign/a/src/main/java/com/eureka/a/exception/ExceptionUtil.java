package com.lj.a.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public final class ExceptionUtil {

    public static String handleException(int startIndex, int endIndex, BlockException ex) {
        System.out.println("异常发生: " + startIndex + ", " + endIndex);
        ex.printStackTrace();
        return "Oops, error occurred at " +  + startIndex + ", " + endIndex;
    }
}
