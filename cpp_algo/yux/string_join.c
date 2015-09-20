#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char* stringJoin(char* s1, char* s2)
{
    int len1, len2, index;
    char * result; 

    if(s1 == NULL)
        len1 = 0;
    else len1 = strlen(s1);
    if(s2 == NULL)
        len2 = 0;
    else len2 = strlen(s2);
    
    if(s1 !=NULL || s2 != NULL)
        result = (char*)malloc((len1 + len2 + 1) * sizeof(char));
    else
        return NULL;

    if(result == NULL)
    {
        printf("malloc failed\n");
        exit(-1);
    }
 
    for(index = 0;index < len1; index++)
        result[index] = s1[index];
    for(int j = 0; j < len2; j++)
        result[index++] = s2[j];
    result[index] = '\0';

    return result;
}

int main()
{
 //   char* s1 = "return to 20";
    char* s1 = NULL;
    char* s2 = NULL;
    //   char* s2 = "tody is  Jan. 17";
    char* s_join =  stringJoin(s1, s2);
    
       
    printf("s1: %s\ns2: %s\njont string: %s\n", s1, s2, s_join);
    if(s_join != NULL)
    {
        free(s_join);
        s_join = NULL;
    }
    
//    int l = strlen(NULL);
   // printf("strlen("")=%lu, strlen(NULL)=%lu", strlen(""), strlen(NULL));

    return 0;
}
