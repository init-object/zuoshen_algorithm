package com.wangkun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wk
 * @Date: 2022/4/20
 * @Description:
 * https://leetcode.com/problems/falling-squares/
 * https://leetcode-cn.com/problems/falling-squares/
 */
public class FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Integer> postionIndex = index(positions);
        int size = postionIndex.size();
        SegmentTree segmentTree = new SegmentTree(size);
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (int[] position : positions) {
            int l = postionIndex.get(position[0]);
            int r = postionIndex.get(position[0] + position[1] - 1);
            int height = segmentTree.queryHeight(l, r) + position[1];
            max = Math.max(max, height);
            ans.add(max);
            segmentTree.update(l ,r , height);
        }
        return ans;
    }

    private TreeMap<Integer, Integer> index(int[][] positions) {
        TreeSet<Integer> xSet = new TreeSet<>();
        for (int[] position : positions) {
            xSet.add(position[0]);
            xSet.add(position[0] + position[1] -1);
        }
        TreeMap<Integer, Integer> result = new TreeMap<>();
        int count = 0;
        for (Integer integer : xSet) {
            result.put(integer, ++count);
        }
        return result;
    }

    public class SegmentTree {
        private int[] height;
        private boolean[] update;
        private int[] change;
        private int n;

        public SegmentTree(int n) {
            this.n = n;
            this.height = new int[n <<2];
            this.update = new boolean[n <<2];
            this.change = new int[n <<2];

        }

        public int queryHeight(int l, int r){
            return queryHeight(l, r, 1,1, n);
        }

        private int queryHeight(int l,
                                 int r,
                                 int treeIndex,
                                 int L,
                                 int R) {
            if (l <= L && r >= R) {
                return height[treeIndex];
            }
            int mid = (L + R) >> 1;
            pushDown(treeIndex);
            int leftHeight = 0;
            int rightHeight = 0;
            if (l <= mid) {
                leftHeight = queryHeight(l, r, treeIndex << 1, L, mid);
            }
            if (r > mid) {
                rightHeight = queryHeight(l, r, treeIndex << 1 | 1, mid + 1, R);
            }
            return Math.max(leftHeight, rightHeight);
        }

        public void update(int l, int r, int value) {
            update(l, r, value, 1, 1, n);
        }

        private void update(int l,
                            int r,
                            int value,
                            int treeIndex,
                            int L,
                            int R) {
            if (l <= L && r >= R) {
                height[treeIndex] = value;
                update[treeIndex] = true;
                change[treeIndex] = value;
                return;
            }
            int mid = (L + R) >> 1;
            pushDown(treeIndex);
            if (l <= mid) {
                update(l, r, value, treeIndex << 1, L, mid);
            }
            if (r > mid) {
                update(l, r, value, treeIndex << 1 | 1, mid + 1, R);
            }

            height[treeIndex] = Math.max(height[treeIndex << 1], height[treeIndex << 1 | 1]);
        }

        private void pushDown(int treeIndex) {
            if (update[treeIndex]) {
                update[treeIndex << 1] = true;
                update[treeIndex << 1 | 1] = true;
                change[treeIndex << 1] = change[treeIndex];
                change[treeIndex << 1 | 1] = change[treeIndex];
                height[treeIndex << 1] = change[treeIndex];
                height[treeIndex << 1 | 1] = change[treeIndex];
                update[treeIndex] = false;
            }
        }
    }
}
