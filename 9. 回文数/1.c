/**
 * Note: The returned array must be malloced, assume caller calls free().
 执行用时: 80ms, 内存消耗:5.5MB
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isPalindrome(int x)
{

    if (x < 0)
        return false;
    int p[10];
    int digits;
    for (digits = 0; x != 0; digits++)
    {   
        p[digits] = x%10;
        x = x / 10; 
        printf("p: %d\n", p[digits]);
        
    }
    printf("digits: %d\n", digits);
    for(int i=0;i<digits;i++){
        printf("%d, %d\n", p[i], p[digits-1-i]);
        if(p[i] != p[digits-1-i]) return false;
    }
    
    return true;
}
int main()
{
    printf("isPalindrome: %s\n", isPalindrome(121) ? "true" : "false");
    printf("isPalindrome: %s\n", isPalindrome(51215) ? "true" : "false");
    printf("isPalindrome: %s\n", isPalindrome(10) ? "true" : "false");
}