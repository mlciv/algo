#include<cstdio>
#include<cstdlib>
#include<algorithm>
#define MAX 100
int arr[MAX] = {0,4,5,1,2,3,8,1,12,3,5,12,90};
int N = 13;

//TODO graph search: DFS, BFS, DIJKSTRA,BEN FLOYD

int cmp(const void *a, const void *b)
{
    return *((int*)a)- *((int*)b);
}


void* bsearch(void *key,void *arr,int N, size_t size, int cmp(const void*,const void*)){
    if(N==0) return NULL;
    int middle_index = (N-N%2)/2;
    void *middle= (void *)((char*)arr+size*middle_index);
    int find = cmp(key,middle);
    if(find==0)
    {
        return middle;
    }else if(find<0) 
    {
        return bsearch(key,arr,middle_index+1,size,cmp);
    }
    else if(find>0) 
    {
        return bsearch(key,middle,N-middle_index-1,size,cmp);
    }
    return NULL;
}



int main()
{
    int key = 1;
    std::qsort(arr,N,sizeof(int),cmp);
    int *index = (int*)std::bsearch(&key,arr,N,sizeof(int),cmp);
    if(index!=NULL)
    {
        printf("find key = %d\n",*index);
    }

    int *bkey = (int*)bsearch(&key,arr,N,sizeof(int),cmp);
    if(bkey!=NULL)
    {
        printf("find bkey = %d\n",*bkey);
    }
    return 0;
}
