#include <cstdio>
#include <list>
#include <cstdlib>
#include "list.h"
#include <iostream>
using namespace std;
//链表判环，用两个指针


template <class Type> int List<Type>::empty(){
    return count==0?1:0;
}

template <class Type> void List<Type>::push_back(Type item){
    ListItem<Type> *litem = new ListItem<Type>(item);
    tail->next = litem;
    litem->pri = tail;
    tail = litem;
    count++;
}

//移除最后一个元素，但是不返回
template <class Type> void List<Type>::pop_back(){
    ListItem<Type> *item = tail->pri;
    item->next = tail->next;
    delete(tail);
    tail = item;
    count --;
}

template <class Type> void List<Type>::clear()
{
    if(!empty()){
        pop_back();
    }    
}

template <class Type> void List<Type>::destory(){
    clear();
}

template <class Type> Type& List<Type>::operator[](int index){
    ListItem<Type> *it = head;
    int i =-1;
    while(it->next!=NULL&&i<index){
        it = it->next;
        i++;
    }
    return it->item;
}


template <class Type> void List<Type>::insert(int pos,Type t){
    if(pos>=count-1) return;
    ListItem<int> *newit= new ListItem<Type>(t);
    ListItem<Type> *it = head;
    ListItem<Type> *pri = head;
    for(int i =-1;i<pos;i++){
        pri = it;
        it = it->next;
    }
    pri->next = newit;
    newit->pri = pri;
    newit->next = it;
    it->pri = newit;
    count++;
}

template <class Type> void List<Type>::remove(int pos){
    if(pos>=count-1) return;
    ListItem<Type> *it = head;
    ListItem<Type> *pri = head;
    for(int i =-1;i<pos;i++){
        pri = it;
        it = it->next;
    }
    ListItem<Type> *p = it->next;
    pri->next = it->next;
    p->pri = pri;
    count--;
    delete(it);
}

int main()
{
    List<int> *list = new List<int>();
    list->push_back(1);
    list->push_back(2);
    list->push_back(3);
    list->push_back(4);
    list->push_back(6);
    list->pop_back();
    list->insert(2,7);
    list->remove(3);
    for(int i =0;i<list->size();i++){
        cout<<(*list)[i];
    }
    cout<<endl;

    return 0;
}
