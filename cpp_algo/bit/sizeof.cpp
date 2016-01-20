#include <stdio.h>

int main(){
    char a[10];
    int c[10];
    char* b;
    int* d;
    d = c;
    b = a;
    printf("sizeof(array)=%d,sizeof(c)=%d,sizeof(d)=%d,sizeof(b)=%d,sizeof(*b)=%d\n",sizeof(a),sizeof(c),sizeof(d),sizeof(b),sizeof(*b));
    return 0;    
}
