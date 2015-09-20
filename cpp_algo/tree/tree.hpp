#include <cstdio>
#include <iostream>
#include <cstdlib>
#include <vector>
template<typename T,int N> class TreeNode{
protected:
    T value;
    std::vector<TreeNode<T,N> * > childs;
    int childSize;
    int childCapacity;
public:
    TreeNode():childCapacity(N),childs(N),value(NULL),childSize(0){}//default construct?
    TreeNode(T value) { 
        this->value = value; 
        this->childs = std::vector<TreeNode<T,N> *> (N);
        for(int i =0;i<N;i++){
            this->childs[i] = NULL;
        }
        this->childCapacity = N;
        this->childSize = 0;
    }

    int getChildSize(){ return  childSize; }
    TreeNode<T,N> * getChilds(int i){
        if(i<this->childSize)
        return childs[i];
        else return NULL;
    }
    int getHeight();
    void insertChild(T value);
    void destory();
    
    void preOrder_r();
    void postOrder_r();
    virtual void midOrder_r();
    
    static void preorder(TreeNode *root);
    static void postOrder(TreeNode *root);
    static void midOrder(TreeNode *root);
};

template <typename T> class BinTreeNode:public TreeNode<T,2>{
public:
    BinTreeNode<T>():TreeNode<T,2>(){}
    BinTreeNode<T>(int value):TreeNode<T,2>(value){};
};
