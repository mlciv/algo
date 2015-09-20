#include "queue.hpp"
#include <iostream>
template <class Type> void Queue<Type>::enqueue(const Type &item){
    QueueItem<Type> *p = new QueueItem<Type>(item);
    if(empty()){
        head = tail = p;
    }else
    {
        tail->next = p;
        tail = p;
    }
}

template <class Type> Type& Queue<Type>::dequeue(){
    Type value = head->item;
    head = head->next;
    free(head);
    return value;
}

template <class Type> void  Queue<Type>::destory(){
    while(!empty())
        dequeue();
}


template <class Type> void Queue<Type>::copy_elems(const Queue<Type> &ori){
    for(QueueItem<Type> *pt = ori.head;pt;pt = pt->next)
    {
        enqueue(pt->item);
    }

}

int main(){
    Queue<int> qint;
    for(int i =0;i<10;i++)
        qint.enqueue(i);
    cout<<"front:"<<qint.front()<<endl;
    if(!qint.empty()) {
        cout<<"not empty"<<endl;
    }
    for(int i=0;i<10;i++)
    {
        cout<<qint.dequeue()<<" "<<endl;
    }
    if(qint.empty()) cout<<"empty"<<endl;
    return 0;
}
