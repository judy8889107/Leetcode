/*
1694. 重新格式化电话号码
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char *reformatNumber(char *number)
{
    int len = strlen(number);
    char p[len+(len/3)];
    int digits = 0;
    int index = 0;

    for (int i = 0; i < len; i++){
        if (number[i]-'0'< 0 || number[i]-'0' > 9) continue;
        digits++;
        // printf("%c", number[i]);
        p[index] = number[i];
        index += 1;
        // printf("\np: %s\n",p);
        if(digits%3 == 0 && digits != 0) p[index++] = '-';
    }
    p[index] = '\0';

    // printf("\ndigits: %d\n", digits);
    // printf("index: %d\n", index);
    if(digits%3 ==0) p[index-1] = '\0';
    if(digits%3 == 1){
        char tmp;
        tmp = p[index-3];
        p[index-3] = p[index-2];
        p[index-2] = tmp;
    }
    // printf("p: %s\n", p);
    char *ptr = p;
    printf("ans: %s\n", ptr);

    return ptr;

}
int main()
{
    reformatNumber("1-23-45 6");
    reformatNumber("123 4-567");
    reformatNumber("123 4-5678");
    reformatNumber("12");
    reformatNumber("1234");
    reformatNumber("--17-5 229 35-39475 ");
    return 0;
}