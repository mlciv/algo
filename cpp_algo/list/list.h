#include <cstdio>
#include <cstdlib>
#include <algorithm>

template< class Type> class ListItem{
    template<class T> friend class List;
    Type item;
    ListItem *next;
    ListItem *pri;
    ListItem<Type>(Type &t):item(t),next(0),pri(0){}
    ListItem<Type>(){next = NULL;pri = NULL;}
};

template <class Type> class List{
public:
    List<Type>():count(0){head = tail = new ListItem<Type>();}
    int size() {return count;}
    void push_back(Type item);
    void pop_back();
    int empty();
    void clear();
    void insert(int pos,Type t);
    void remove(int pos);
    Type& operator[](int index);
private:
    ListItem<Type> *head;
    ListItem<Type> *tail;
    void destory();
    void copy_elemes();
    int count;
};
