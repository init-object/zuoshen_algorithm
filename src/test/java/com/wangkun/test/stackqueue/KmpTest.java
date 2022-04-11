package com.wangkun.test.stackqueue;

import com.wangkun.algorithm.great.Kmp;

/**
 * @author wk
 * @Date: 2022/4/9
 * @Description:
 */
public class KmpTest {

    public static void main(String[] args) {
        String s = "bca";
        String m = "a";
        System.out.println(Kmp.getSubIndex(s,m));
    }
}
