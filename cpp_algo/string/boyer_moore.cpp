#include <cstdio>
#include <cstdlib>
#include <cstring>


#define ASIZE 256

//预处理每个字母最右的位置
static void pre_right(const char *pattern, int right[])
{
    int i=0;
    const int m = strlen(pattern);
    for(i=0;i<ASIZE;i++) right[i] = -1;
    for(i=0;i<m;i++)
    {
        right[(unsigned char)pattern[i]] = i; //记录每个字母最右的位置
    }
}


//http://blog.csdn.net/sealyao/article/details/4568167 算法改进和说明
//Suff数组的定义：suff[i] = 以i为i左边界,右边界都是m-1, 与模式串后缀匹配的最大长度，即s为长度
//P[i-s...i]=P[m-s…m]
static void suffixes(const char *pattern, int suff[]) {
    int i=0;//当前正准备计算的suff 下标，也是从头部开始和后缀相同的最后一个字符
    int f=0;//上一个成功进行匹配的起始位置（不是每个位置都能进行成功匹配的，  实际上能够进行成功匹配的位置并不多）
    int g =0; //上一次进行成功匹配的头部的失配位置
    const int m = strlen(pattern);
    suff[m - 1] = m;
    g = m - 1;
    for (i = m - 2; i >= 0; --i) {
        if (i > g && suff[i + m - 1 - f] < i - g) //如果i在g和f之间，那么一定有P[i]=P[m-1-f+i]，之前已经计算过，直接复用；并且如果suff[m-1-f+i]=i-g, suff[i]和suff[m-1-f+i]就没有直接关系了。
        {    
            suff[i] = suff[i + m - 1 - f];   //复用已经计算过的suff
        }
        else 
        {
            if (i < g)
            {   
                g = i;
            }
            f = i;// f为从头部开始匹配的与后缀相同的最后一个字符,g是从头部开始匹配后缀的头部，也就是失配位置
            while (g >= 0 && pattern[g] == pattern[g + m - 1 - f]) //后缀从尾部往前比较，计算起始位置，f-g为当前已经匹配相同的后缀长度，m-1-(f-g)为尾部后缀的左端点
                --g;
            suff[i] = f - g;//结束位置f与g的差值为长度suff[i]
        }
    } 
}


//计算好后缀后移位数
//后移位数 = 好后缀的位置（pattern中后缀最后一个字符为准） - 搜索词中的上一次出现位置（最后一个字符为准)
//出现多次的好后缀位置在头部
static void pre_gs(const char pattern[],int gs[]){
    int i,j;
    const int m = strlen(pattern);
    int *suff  = (int*)malloc(sizeof(int)*(m+1));

    suffixes(pattern, suff);
    for (i = 0; i < m; ++i) gs[i] = m;//初始化为后移整个pattern串 m-1-(-1)
    j = 0;
    for (i = m - 1; i >= 0; --i)
    {
        if (suff[i] == i + 1)//即表示从0到i都和后缀相等匹配
        {
            for (; j < m - 1 - i; ++j) //BM后缀匹配时的最左端，即失配点
            {    
                if (gs[j] == m) gs[j] = m - 1 - i;//移动距离为好后缀的位置（最后一个字符总是m-1）和上一次出现位置i的差
            }
        }
    }
    for (i = 0; i <= m - 2; ++i)
        gs[m - 1 - suff[i]] = m - 1 - i;
    free(suff);
}


int boyer_moore(const char *text,const char *pattern)
{
    int i,j=0;
    int right[ASIZE];
    const int n  = strlen(text);
    const int m = strlen(pattern);
    int *gs = (int *)malloc(sizeof(int)*(m+1)); // good suffix shift

    //Preprocessing
    pre_right(pattern,right);
    pre_gs(pattern,gs);

    //Searching
    // right to left
    while(j<=n-m){
        for(i=m-1;i>=0 && pattern[i]==text[i+j];--i) ;//i为模式串中从右往左比较的位子
        if (i<0) // find one
        {
            printf("find one at %d\n",j);
            //j+=gs[0];//为多次匹配使用
            free(gs);
            return j;
        }
        else{
            int bs = right[(unsigned char)text[i+j]] - m +1+i;  //坏字符的移动距离  也可以是i - right[(unsigned char)text[i+j]]
            const int max= gs[i]>bs?gs[i]:i- right[(unsigned char)text[i+j]]; //坏字符位置，减去上次字符在pattern中出现的位置    
            j+=max;
        }   
    }
    free(gs);
    return -1;
    
}


int main()
{
    const char *text = "HERE IS A SIMPLE EXAMPLE";
    const char *pattern = "EXAMPLE";
    const int pos = boyer_moore(text,pattern);
    printf("%d\n",pos);
    return 0;
}
