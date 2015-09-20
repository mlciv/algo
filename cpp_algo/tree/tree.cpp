#include "tree.hpp"

template <typename T,int N> void TreeNode<T,N>::insertChild(T value){
    int index = this->getChildSize();
    this->childs[index] = new TreeNode<T,N>(value);//TODO
    this->childSize++;
}

template <typename T, int N> int TreeNode<T,N>::getHeight(){
    int maxHeight = 1;
    for(int i=0;i<N;i++){
        int tempHeight = 0;
        if(this->childs[i]!=NULL){
            tempHeight = this->childs[i]->getHeight();   
        }
        if(tempHeight>maxHeight) maxHeight = this->childs[i]->getHeight();
    }
    return maxHeight+1;
}

template <typename T, int N> void TreeNode<T,N>::preOrder_r()
{
    std::cout<< this->value;
    int size = this->getChildSize();
    for(int i=0;i<size;i++){
        if(this->childs[i]!=NULL){
            this->childs[i]->preOrder_r();
        }
    }
}

template <typename T, int N> void TreeNode<T,N>::postOrder_r()
{
    int size = this->getChildSize();
    for(int i=0;i<size;i++){
        if(this->childs[i]!=NULL){
            this->childs[i]->postOrder_r();
        }
    }
    std::cout<< this->value;
}

template <typename T,int N> void TreeNode<T,N>::midOrder_r()
{
    if(N!=2) 
    {
        return ;
    }
    if(this->childs[0]!=NULL) this->childs[0]->midOrder_r();
    std::cout<<this->value;
    if(this->childs[1]!=NULL) this->childs[1]->midOrder_r();
}

//template <typename T> void BinTreeNode<T>::midOrder_r(){
//    if(this->childs[0]!=NULL) this->childs[0]->midOrder_r();
//    std::cout<<this->value;
//    if(this->childs[1]!=NULL) this->childs[1]->midOrder_r();
//}

int main(){
    BinTreeNode<int> *tree = new BinTreeNode<int>(0);
    tree->insertChild(1);
    tree->insertChild(2);
    tree->getChilds(0)->insertChild(3);
    tree->getChilds(0)->insertChild(4);

    tree->getChilds(1)->insertChild(5);
    tree->getChilds(1)->insertChild(6);
    tree->preOrder_r();
    std::cout<<std::endl;
    tree->postOrder_r();
    std::cout<<std::endl;
    tree->midOrder_r();
    
}

