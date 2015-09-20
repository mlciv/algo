#include <cstdio>
#include <cstdlib>
#include <queue>

using namespace std;


template <typename Type> class QueueItem{
//private class, not public section
    template<class T> friend class Queue;
    QueueItem(const Type &t):item(t),next(0){}
    Type item;
    QueueItem *next;
};

template <typename Type> class Queue{
public:
    Queue():head(0),tail(0){}
    Queue(const Queue &Q): head(0),tail(0){
        copy_elems(Q);
    }
    
    Queue& operator=(const Queue&);
    ~Queue(){destory();}

    Type& front(){return head->item;}
    const Type &front() const {
        return head->item;
    }
    void enqueue(const Type &);
    Type& dequeue();
    bool empty()const {return head==0;}


private:
    QueueItem<Type> *head;
    QueueItem<Type> *tail;

    void destory();//delete all items
    void copy_elems(const Queue&);
};


