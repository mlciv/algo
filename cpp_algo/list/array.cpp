#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
#include <string>
#include <vector>
#include <bitset>
#include <algorithm>
#define N 100
#define M 1000
using namespace std;

//
//1. using arr to record bitmap or other purpose
//2. using arr to simulate the queue or stack, and other advanced struct
//TODO 
//
//
//
//



//prime number
void primeselect(int n)
{
    char *flagarr = (char *)malloc(sizeof(char)*(n+1));    
    if(flagarr==NULL) exit(-1);
    std::memset(flagarr,1,sizeof(char)*100);
    for(int i =2;i<=n;i++)
    {
        if(flagarr[i]){
            for(int j =2;j<=n/i;j++)
                flagarr[i*j] = 0;
        }   
    }
    for(int k = 2;k<=n;k++)
    {
        if(flagarr[k]) printf("%4d ",k);
    }
    printf("\n");            
}

void prime_bitset(){
    bitset<N+1> pset;
    pset.set();
    for(int i=2;i<=N;i++){
        if(pset.test(i)){
            for(int j =2;j<=N/i;j++) pset[i*j] = 0;
        }
    }

    for(int k=2; k<=N;k++){
        if(pset.test(k)){
            printf("%4d ",k);
        }
    }

    cout<<endl;


}

//roll a coin N times, propabation is N/2,M times experience.
//print the ball graph of i times head

int head(){
    return rand()<RAND_MAX/2;
}

void coin(int n, int m){
    int *farr = (int*)malloc(sizeof(int)*(n+1));
    for(int i=0;i<=n;i++)
    {
        farr[i] =0;
    }
    int cnt =0,k=0 ;
    for(int j = 0;j<m;j++,farr[cnt]++)
    {
        for(cnt=0,k=0;k<n;k++)
        {
            if(head()){
                cnt++;
            }
        }
    }
    
    for(int j =0;j<=n;j++)
    {
        printf("%2d ", j);
        for (int i =0;i<farr[j];i+=10)
        {
            printf("*");
        }
        printf("\n");
    }

}
//STL Vector
//复制和赋值是容器元素的基本要求
void testvector(){
    vector<string> sentence;
    //sentence.reserve(5); // capacity =5, 为重新分配空间之前的元素的最大值
    //不写sentence.reserve capacity 会为5
    cout<< "capacity():"<< sentence.capacity()<<endl;
    sentence.push_back("Hello");
    sentence.push_back("World,");
    sentence.push_back("How");
    sentence.push_back("you");
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    cout<< "capacity():"<< sentence.capacity()<<endl;
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");// push_back 和插入的时候会自动扩展
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    sentence.insert(find(sentence.begin(),sentence.end(),"you"),"are");
    cout<< "capacity():"<< sentence.capacity()<<endl;
    cout<< "capacity():"<< sentence.capacity()<<endl;
    sentence.push_back("1234");
    cout<<sentence.back();
    sentence.back() = "!";
    copy(sentence.begin(),sentence.end(),ostream_iterator<string>(cout," "));
    cout <<endl;
    cout<< "max_size():"<< sentence.max_size()<<endl;
    cout<< "capacity():"<< sentence.capacity()<<endl;
    cout<< "size():"<< sentence.size()<<endl;
    cout<<endl;


    //iterate 
    vector<string>::iterator fit = sentence.begin();//尽量不要保存iterator值，因为插入等丑姑娘犀牛分配控件的操作，将失效
    vector<string>::iterator eit= sentence.end();//end不是指的最后一个元素，而是最后一个元素的下一个
    cout<< *fit<<endl;
    cout<< *eit <<endl;
    for(vector<string>::iterator it = fit;it<eit;it++)
    {
        cout<<*it;// const_iterator is readonly
    }
    cout<<endl;
    for (vector<string>::size_type i=0;i<sentence.size();i++)
    {
        cout<<sentence[i];
    }
    cout<<endl;

}


int main(int argc, char *argv[]){
    //int N = atoi(argv[1]);
    //int M = atoi(argv[2]);
    coin(N,M);
    primeselect(100);
    prime_bitset();
    testvector();
    return 0;
}
