#include <cstdio>
#include <cstring>

const int R = 256; // R进制
const long Q = 0xfff1; //16位最大素数
//装换为数字比较，进一步转换为hash + 判断 解决大数字问题
static void rabin_carp_matcher(const char *T,const char *P,int d, long q)
{
    int N = strlen(T);
    int M = strlen(P);
    int i=0,j=0;
    int p=0;
    int t=0;
    int h=1;

    for(i =0;i<M-1;i++){
        h= (h*d)%q;
    }

    for(i=0;i<M;i++){
        p = (d*p+P[i])%q;
        t = (d*t+T[i])%q;
    }
    
    for(i=0;i<N-M;i++){
        if (p==t)
        {
            for (j=0;j<M;j++){
                if(T[i+j]!=P[j]) break;
            }    
            if(j==M)
                printf("find one %d\n",i);
        }

        if(i<N-M){
            t = (d*(t-T[i]*h)+T[i+M])%q;
            if(t<0) t+=q;
        }
    }
}



int main(int argc, char *argv[])
{
    char txt[] = "Test 123 TEXT";
    char pat[] = "123";
    rabin_carp_matcher(txt,pat,R,Q);
    return 0;
}
