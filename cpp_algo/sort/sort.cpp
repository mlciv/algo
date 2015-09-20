#include<cstdio>
#include<cstdlib>
#include<algorithm>
#include<iostream>

#define MAX 100
#define LEFT(i) 2*(i)
#define RIGHT(i) 2*(i)+1
#define PARENT(i) ((i)-(i)%2)/2

using namespace std;

typedef struct Node{
    int value;
    unsigned int ori_index;
}*pNode;

int arr[MAX] = {1,3,2,5,0,1,-1,8,9,10,11,12,13,14,15,16,17,18,19,20,1,23,45,11};
int N = 24;
int heap_size = N-1;
int cmp(const void *a, const void *b)
{
    return ((pNode)a)->value-((pNode)b)->value;
}

void display(pNode narr,int n)
{
    for(int i=0;i<n;i++){
        printf("%d[%u] ",narr[i].value,narr[i].ori_index);
    }
    printf("\n end \n");
}

void display(pNode narr,int start,int end)
{
    for(int i=start;i<=end;i++){
        printf("%d[%u] ",narr[i].value,narr[i].ori_index);
    }
    printf("\n end \n");
}


void wrapper(int *arr, int n, pNode narr){
    for(int i=0;i<n;i++){
        narr[i].value = arr[i];
        narr[i].ori_index = i;
    }
    //display(narr,n);
}

void insertsort(pNode narr,int n){
    pNode key = (pNode) malloc(sizeof(Node));
    for (int i =1; i<n;i++){
        key->value = narr[i].value;
        key->ori_index = narr[i].ori_index;
        int j = i-1;
        while(j>=0&&narr[j].value> key->value)
        {
            narr[j+1].value = narr[j].value; 
            narr[j+1].ori_index = narr[j].ori_index;
            j--;
        }
        narr[j+1].value = key->value;
        narr[j+1].ori_index = key->ori_index;
    }
    if(key!=NULL) free(key);
}

void swap(pNode a, pNode b){
    int temp_value = a->value;
    unsigned int temp_index = a->ori_index;
    a->value = b->value;
    a->ori_index = b->ori_index;
    b->value = temp_value;
    b->ori_index = temp_index;
}

void selectsort(pNode narr, int n)
{
    pNode min = (pNode) malloc(sizeof(Node));
    int min_index =0;
    for(int i = 0;i<n;i++){
        min->value = 0xffff;//max
        min->ori_index = 0;
        for(int j=i;j<n;j++){   
           if(narr[j].value<min->value){
                min->value= narr[j].value;
                min->ori_index= narr[j].ori_index;
                min_index = j;
           } 
        }
        swap(&narr[i],&narr[min_index]);//  这里的交换会导致不稳定的发生
    }
}


//稳定的，如果比较的时候该外>=，则会出现不稳定的情况，即先出现的相等值在后面
void bubblesort(pNode narr, int n)
{
    for(int i=n-1;i>0;i--)
    {
        for(int j = 0; j< i;j++)
        {
            if(narr[j].value>narr[j+1].value)
            {
                swap(&narr[j],&narr[j+1]);
            }
        }
    }
    
}


int partition(pNode narr, int left, int right){
    
    int p = left;
    int value = narr[p].value;
    int i=left+1,j=right;
    int position = left;
    while(i<j)
    {
        while(i<j&&narr[i].value <= value) 
        {
            i++;
        }
        while(j>i&&narr[j].value > value) 
        {
            j--;
        }
        if(i!=j) swap(&narr[i],&narr[j]);
    }

    if(narr[i].value <= value)  position = i;
    else position = i-1;
    i = position;
    while(i>left)
    {
        swap(&narr[left],&narr[i]);
        i--;
    }
    return position;
}

int qsort(pNode narr, int left, int right)
{
   if(left>=right) return 0;
   int position = partition(narr,left,right);
   qsort(narr,left, position-1);
   qsort(narr,position+1, right);
   return 0;
}

void merge(pNode narr, int left, int middle , int right){
    int n1 = middle -left +1;
    int n2 = right -middle;
    pNode larr = (pNode) malloc(sizeof(Node)*(n1+1));
    if(larr==NULL) exit(-1);
    pNode rarr = (pNode) malloc(sizeof(Node)*(n2+1));
    if(rarr==NULL) exit(-1);
    
    for(int i = 0; i< n1;i++){
        larr[i].value = narr[i+left].value;
        larr[i].ori_index = narr[i+left].ori_index;
    }
    for(int j = 0; j< n2;j++){
        rarr[j].value = narr[j+middle+1].value;
        rarr[j].ori_index = narr[j+middle+1].ori_index;
    }
    larr[n1].value = 0xffff;
    rarr[n2].value = 0xffff;
    int i =0, j =0;
    for(int k = left;k<=right;k++){
        if(larr[i].value<= rarr[j].value){
            narr[k].value = larr[i].value;
            narr[k].ori_index = larr[i].ori_index;
            i++;
        }else{
            narr[k].value = rarr[j].value;
            narr[k].ori_index = rarr[j].ori_index;
            j++;
        }
    }
    if(larr!=NULL) free(larr);
    if(rarr!=NULL) free(rarr);
}

void mergesort(pNode narr, int left ,int right){
    if(left>= right) return;
    int middle = (left+right-(left+right)%2)/2;
    mergesort(narr,left,middle);
    mergesort(narr,middle+1,right);
    merge(narr,left,middle,right);   
}

//left and right is max_heapified
//log N
void max_heapify(pNode narr,int root){
    int left = LEFT(root);
    int right = RIGHT(root);
    int largest = root;
    if(left<=heap_size&&narr[left].value>narr[largest].value){
        largest = left;
    }else
    {
        largest = root;
    }
    if(right<=heap_size&&narr[right].value>narr[largest].value){
        largest = right;   
    }
    if(largest != root){
        swap(&narr[largest],&narr[root]);
        max_heapify(narr,largest);
    }
}

//O(n)
void build_maxheap(pNode narr){
    for(int i =heap_size/2;i>=1;i--){
        max_heapify(narr,i);
    }
}


//不稳定的 n(logn)
void heapsort(pNode narr){
    build_maxheap(narr);
    for(int i = heap_size;i>=2;i--){
        swap(&narr[1],&narr[i]);
        heap_size = heap_size -1;
        max_heapify(narr,1);
    }
}

//priority Queue

int heap_max(pNode narr){
    return narr[1].value;
}

int heap_exact_max(pNode narr){
    if(heap_size<1){
        cout<<"heap err";
    }
    int max = narr[1].value;
    swap(&narr[1],&narr[heap_size]);
    heap_size = heap_size -1;
    max_heapify(narr,1);
    return max;
}

void heap_increase_key(pNode narr,int index, int key){
    if(key<narr[index].value){
        cout<<"heap err:value is small than ori";
    }
    narr[index].value = key;
    while(index>1 && narr[PARENT(index)].value<narr[index].value){
        swap(&narr[PARENT(index)],&narr[index]);
        index  = PARENT(index);
    }
}

void heap_insert(pNode narr,int key){
    heap_size= heap_size +1;
    narr[heap_size].value = -0xffff;
    narr[heap_size].ori_index = heap_size;
    heap_increase_key(narr,heap_size,key);    
}


int main()
{
    pNode narr = (pNode)malloc(sizeof(Node)*MAX);
    if(narr==NULL) {
        printf("wrong to alloc memory\n");
        exit(-1);
    }
    wrapper(arr,N,narr);
    //algorithm qsort
    std::qsort(narr,N,sizeof(struct Node),cmp); // O(nlogn) , 不稳定，两个1的位置发生了调换,注意std中的qsort在cutoff小于8的时候就不会再进行partition而是使用插入排序,因为有可能也是稳定的
    printf("std qsort:\n");
    display(narr,N);

    //insert sort 
    wrapper(arr,N,narr);
    insertsort(narr,N);
    printf("insertsort:\n");
    display(narr,N);

    // select sort
    wrapper(arr,N,narr);
    selectsort(narr,N);
    printf("selectsort:\n");
    display(narr,N);

    //bubblesort
    wrapper(arr,N,narr);
    bubblesort(narr,N);
    printf("bubblesort:\n");
    display(narr,N);

    

    //advanced sort
    
    //qsort 
    wrapper(arr,N,narr);
    qsort(narr,0,N-1);
    printf("qsort:\n");
    display(narr,N);

    //mergesort 
    wrapper(arr,N,narr);
    mergesort(narr,0,N-1);
    printf("mergesort:\n");
    display(narr,N);
    
    //heapsort
    wrapper(arr,N,narr);
    heapsort(narr);// TODO
    printf("heapsort:\n");
    display(narr,N);

    if(narr!=NULL) free(narr);
    return 0;
}
