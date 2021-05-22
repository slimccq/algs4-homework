package exercise.chapter1;

public interface UnionFind {
    // 添加一条连接
    void union(int p, int q);

    // 查找所在分量的标识符
    int find(int p);

    // p,q是否在同一分量中
    boolean connected(int p, int q);

    //
    int count();
}
