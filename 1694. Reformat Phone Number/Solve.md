# 解題思路

 利用一個迴圈，__digits__ 紀錄數字，__index__ 紀錄位置，全先分為三個一組

```c
int len = strlen(number);
char p[len+(len/3)];
int digits = 0;
int index = 0;

    for (int i = 0; i < len; i++){
        if (number[i]-'0'< 0 || number[i]-'0' > 9) continue;
        digits++; 
        p[index] = number[i];
        index += 1;
        if(digits%3 == 0 && digits != 0) p[index++] = '-';
    }
    p[index] = '\0';
```
然後依照 __digits__ 紀錄去判斷是否是否為一個數字的組合，或者需要移除 __-__ 

```c
if(digits%3 ==0) p[index-1] = '\0';

    if(digits%3 == 1){
        char tmp;
        tmp = p[index-3];
        p[index-3] = p[index-2];
        p[index-2] = tmp;
    }
    char *ptr = p;

    // printf("ans: %s\n", ptr); test

    return ptr;
```

