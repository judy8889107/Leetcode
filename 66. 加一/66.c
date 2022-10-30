/**
 * @file 66. 加一.c
 * @brief 
 * @version 0.1
 * @date 2022-10-22
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include<stdio.h>
#include<string.h>
#include<stdlib.h>


int* plusOne(int* digits, int digitsSize, int* returnSize){
    
    for(int i=digitsSize-1;i>=0;i--){
        if(digits[i] == 9){
            digits[i] = 0;

        }else{
            digits[i] += 1;
            *returnSize = digitsSize;
            return digits;
        }
    }

    int *ret = malloc(sizeof(int)*(digitsSize+1));
    ret[0] = 1;
    for(int i=1;i<digitsSize+1;i++){
        ret[i] = digits[i-1];
    }
    *returnSize = digitsSize+1;

    return ret;
   

    
}
