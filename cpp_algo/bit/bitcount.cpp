#include <cstdio>
#include <iostream>
#include <cstdlib>

int and_count(int a , int b){
    int c = a&b;
    int count =0;
    while(c!=0){
        if(c%2==1) count++;
        c=c>>1;
    }
    return count;
}

int main()
{
    int a = 3;
    int b = 7;
    std::cout<<and_count(a,b);
}
