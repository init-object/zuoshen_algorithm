package com.wangkun.algorithm.great;

/**
 * @author wk
 * @Date: 2022/4/9
 * @Description: kmp 算法
 */
public class Kmp {
    public static int getSubIndex(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return  -1;
        }
        char[] chars = s.toCharArray();
        char[] charm = m.toCharArray();
        int[] nextArr = getNextArr(charm);
        int x = 0;
        int y = 0;
        while (x < s.length() && y < m.length()) {
            if (chars[x] == charm[y]) {
                x++;
                y++;
            }else if (y==0){
                x++;
            }else {
                y=nextArr[y];
            }
        }
        return y == m.length() ? x-y: -1;
    }

    private static int[] getNextArr(char[] charm) {
        if (charm.length == 1) {
            return new int[] {-1};
        }
        int[] nextArr = new int[charm.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int cn = 0;
        int x = 2;
        while (x<charm.length){
            if (charm[x-1] == charm[cn]){
                nextArr[x++] = ++cn;
            }else if (cn == 0) {
                nextArr[x++] = 0;
            }else {
                cn = nextArr[cn];
            }
        }
        return nextArr;
    }
}
