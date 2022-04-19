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

    public int kmp(String m, String n){
        int[] next = getNext(m);
        int i = 0;
        int j = 0;
        while (i < n.length() && j < m.length()){
            if (j == -1 || n.charAt(i) == m.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return j == m.length() ? i-j: -1;
    }

    private int[] getNext(String m) {
        int[] next = new int[m.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int j = 0;
        while (i < m.length()){
            if (m.charAt(i-1) == m.charAt(j)){
                next[i++] = ++j;
            }else if (j == 0){
                next[i++] = 0;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    private int[] getNextArr2(char[] m) {
        if (m.length == 1) {
            return new int[]{-1};
        }
        int[] nexArr = new int[m.length];
        nexArr[0] = -1;
        nexArr[1] = 0;
        int x = 2;
        int cn = 0;
        while (x < m.length) {
            if (m[x-1] == m[cn]) {
                nexArr[x++] = ++cn;
            }else if (cn == 0) {
                nexArr[x++] = 0;
            }else {
                cn = nexArr[cn];
            }
        }
        return nexArr;
    }

    public int kmp2(String m, String n){
        if (m == null || n == null || m.length() == 0 ||m.length() < n.length()){
            return -1;
        }
        char[] charm = m.toCharArray();
        char[] charn = n.toCharArray();
        int[] nextArr2 = getNextArr2(charn);
        int x =0;
        int y =0;
        while (x < m.length() && y < n.length()){
            if (charm[x] == charn[y]){
                x++;
                y++;
            }else if (y==0){
                x++;
            }else {
                y=nextArr2[y];
            }
        }
        return y==n.length()? x-y:-1;
    }
}
