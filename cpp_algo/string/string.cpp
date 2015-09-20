#include<cstdio>
#include<cstdlib>
#include<cassert>
#include<cstring>
#include<climits>
//通常推荐直接使用string C++ 标准库

using namespace std;
#define MAX_LEN 1024
char str[MAX_LEN];
char des[2*MAX_LEN];
int next[2*MAX_LEN];
size_t strlen(const char* str);
char* strcpy(char *to , const char *from);
char* strstr(const char* haystack,const char* needle);
int atoi(const char* src);
void getNextval(char *p, int next[]);
int kmpSearch(const char *haystack, const char* needle);

int main(){
    scanf("%s",str);
    printf("%ld\n", strlen(str));
    strcpy(des,str);
    printf("%s",des);
    memset(des,0,sizeof(des));
    memset(str,0,sizeof(str));
    printf("please input the source string\n");
    scanf("%s",des);
    printf("%s\n",des);
    printf("please input the target string\n");
    scanf("%s",str);
    printf("%s\n",str);
    if(strstr(des,str)!=NULL)
        printf("find\n");
    getNextval(str,next);
    if(kmpSearch(des,str)!=-1){
        printf("find kmp\n");
    }
    
    
    printf("input number");
    memset(str,0,sizeof(str));
    scanf("%s",str);
    printf("%d",atoi(str));
    return 0;
}


size_t strlen(const char* str){
    const char* end= str;
    while(*end) end++;
    return end -str;
}

char *strcpy(char *to, const char *from){
    assert(to!=NULL&&from!=NULL);
    char *p = to;
    while(((*p++)=(*from++))!='\0')
    { 
        ;
    }
    return to;
}

//Naive String Match O((n-m-1)m),m为pattern长度
char* strstr(const char* haystack, const char* needle){
    //TODO string match algorithm
    //1.暴力的
    const char* p = haystack;
    const char* start= haystack;
    const char* target= needle;
    size_t n_len = strlen(needle);
    size_t h_len = strlen(haystack);
    printf("%ld,%ld\n",n_len,h_len);
    while(*start!='\0'&&(haystack+h_len)-start>=n_len)
    {
       //TODO
       //printf("%ld,%c\n",start-haystack,*start);
       p = start;
       target = needle;
       //printf("start:%c,%c\n",*p,*target);
       while((*p)==(*target)&&(target-needle<=n_len))
       {
           printf("%c,%c\n",*p,*target);
           p++;
           target++;
       }
       //if(*target=='\0') 
       //{
       //    printf("%s\n",start);
       //    //return (char*)start;
       //}
       start = start+1;
    }
    return NULL;
}

int atoi(const char *src){
    int sign =1;
    int num =0;
    const int len = std::strlen(src);
    int i =0;
    while(i<len&&src[i]==' ') i++;
    if(src[i]=='+') 
    {
        sign = 1;
        i++;
    }
    if(src[i]=='-') 
    {
        sign = -1;
        i++;
    }
    //no number
    if(i==len){
        printf("no number\n");
        return 0;
    }
    
    if(src[i]=='0'&&len-i>1){
        printf("more than one lead 0\n");
        return 0;
    }
    while(i<len){
        if(src[i]<'0'||src[i]>'9') {
            break;
        }
        if(num> INT_MAX/10||(num==INT_MAX/10&&(src[i]-'0'>INT_MAX%10))){
            printf("beyond bound");
            return sign==-1?INT_MIN:INT_MAX;
        } 
        num = num*10 + src[i]-'0';
        i++;
    }
    return num*sign;
}

//Get next array
void getNextval(char *p,int next[]){
    int pLen = std::strlen(p);
    next[0] = -1;
    int k = -1;
    int j=0;
    while(j<pLen -1)
    {
        //p[k] is prefix, p[j] is suffix
        if(k==-1||p[j]==p[k]){
            ++j;
            ++k;
            if(p[j]!=p[k]){
                next[j] = k;
            }
            else{
                next[j]=next[k];//相同的有错，这前面的K也往前递归到更小的串
            }
        }
        else{
            k = next[k];//k匹配失败，寻找递归寻找之前更短的前缀
        }
    }
    for(int m=0;m<pLen;m++){
        printf("%d,",next[m]);
    }
    printf("\n");
}

int kmpSearch(const char *s, const char *p)
{
    int i=0;
    int j=0;
    int sLen = strlen(s);
    int pLen = strlen(p);
    while(i<sLen&&j<pLen){
        if(j==-1||s[i]==p[j]) // j ==-1 刚开始匹配的时候
        {
            ++i;
            ++j;
        }else{
            j = next[j]; //已经匹配的部分复用，i不变，j跳到next（更短的公共前缀）进行比较
        }
    }
    if(j==pLen){
        return i-j;//返回下标
    }else{
        return -1;
    }
}


