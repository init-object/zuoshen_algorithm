package com.wangkun.algorithm.great;


import com.wangkun.algorithm.nodelist.TreeNode;

/**
 * @author wk
 * @Date: 2022/4/13
 * @Description:
 */
public class Morris {

    public void morrisInorder2(TreeNode root) {
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.val);
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }


    public void morrisPreorder(TreeNode root) {
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if (cur.left != null) {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }


}
