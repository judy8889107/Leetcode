/**
 * Note: The returned array must be malloced, assume caller calls free().
 * 执行用时: 32ms, 内存消耗:5.8MB
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isPalindrome(int x)
{

    if (x < 0)
        return false;
    long int cus = 0;
    int num = x;
    while (num != 0)
    {   
        cus = cus*10 + num%10;
        num = num/10;
        printf("cus: %d, num: %d\n", cus, num);
    }
    
    return cus == x;
}
int main()
{
    printf("isPalindrome: %s\n", isPalindrome(121) ? "true" : "false");
    printf("isPalindrome: %s\n", isPalindrome(51215) ? "true" : "false");
    printf("isPalindrome: %s\n", isPalindrome(998765432) ? "true" : "false");
}