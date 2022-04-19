package com.wangkun.algorithm.great;

/**
 * @author wk
 * @Date: 2022/4/19
 * @Description:
 */
public class SegmentTree {
    private int[] tree;
    private int[] lazy;
    private boolean[] update;
    private int[] change;

    private int[] data;
    private Merger merger;
    public SegmentTree(int[] data, Merger merger){
        this.data = data;
        this.merger = merger;
        tree = new int[4 * data.length];
        lazy = new int[4 * data.length];
        update = new boolean[4 * data.length];
        change = new int[4 * data.length];
        buildSegmentTree(1, 0, data.length - 1);
    }
    public void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int mid = (l + r) >> 1;
        buildSegmentTree(treeIndex << 1, l, mid);
        buildSegmentTree(treeIndex << 1 | 1, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[treeIndex << 1], tree[treeIndex << 1 | 1]);
    }

    public void  update(int l, int r, int value){
        update(l, r, value, 1, 1, data.length - 1);
    }
    public void add(int l, int r, int value){
        add(l, r, value, 1, 1, data.length - 1);
    }

    private void add(int l, int r, int value, int treeIndex, int L, int R) {
        if (l <= L && r >= R) {
            tree[treeIndex] += value * (r - l + 1);
        }
        int mid = (L + R) >> 1;
        pushDown(treeIndex, mid - l + 1, r - mid);
        if (l < mid) {
            add(l, r, value, treeIndex << 1, L, mid);
        }
        if (r > mid) {
            add(l, r, value, treeIndex << 1 | 1, mid + 1, R);
        }
        tree[treeIndex] = merger.merge(tree[treeIndex << 1], tree[treeIndex << 1 | 1]);

    }

    public int query(int l, int r){
        return query(l, r, 1, 1, data.length - 1);
    }

    private int query(int l, int r, int treeIndex, int L, int R) {
        if (l <= L && r >= R) {
            return tree[treeIndex];
        }
        int mid = (L + R) >> 1;
        pushDown(treeIndex, mid - l + 1, r - mid);
        int ans = 0;
        if (l < mid) {
            ans += query(l, r, treeIndex << 1, L, mid);
        }
        if (r > mid) {
            ans += query(l, r, treeIndex << 1 | 1, mid + 1, R);
        }
        return ans;
    }

    private void update(int l,
                        int r,
                        int value,
                        int treeIndex,
                        int L,
                        int R) {
        if ( l <= L && r >= R){
            update[treeIndex] = true;
            change[treeIndex] = value;
            lazy[treeIndex] = 0;
            tree[treeIndex] = value * (r - l + 1);
            return;
        }
        int mid = (L + R) >> 1;
        pushDown(treeIndex, mid - l + 1, r - mid);
        if (l < mid) {
            update(l, r, value, treeIndex << 1, L, mid);
        }
        if (r > mid) {
            update(l, r, value, treeIndex << 1 | 1, mid + 1, R);
        }
        tree[treeIndex] = merger.merge(tree[treeIndex << 1], tree[treeIndex << 1 | 1]);
    }

    private void pushDown(int treeIndex,
                          int l,
                          int r) {
        if (update[treeIndex]) {
            update[treeIndex << 1] = true;
            update[treeIndex << 1 | 1] = true;
            change[treeIndex << 1] = change[treeIndex];
            change[treeIndex << 1 | 1] = change[treeIndex];
            lazy[treeIndex << 1] = 0;
            lazy[treeIndex << 1 | 1] = 0;
            tree[treeIndex << 1] = change[treeIndex] * l;
            tree[treeIndex << 1 | 1] = change[treeIndex] * r;
            update[treeIndex] = false;
        }
        if (lazy[treeIndex] != 0) {
            lazy[treeIndex << 1] += lazy[treeIndex];
            lazy[treeIndex << 1 | 1] += lazy[treeIndex];
            tree[treeIndex << 1] += lazy[treeIndex] * l;
            tree[treeIndex << 1 | 1] += lazy[treeIndex] * r;
            lazy[treeIndex] = 0;
        }
    }

    public class Merger{
        public int merge(int a, int b){
            return a + b;
        }
    }
}
