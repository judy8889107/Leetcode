# **解題思路**

用 __digits__ 紀錄數字個數，迴圈中三個數字一組，後面都接上- ，__index__ 紀錄加入 __-__ 的字串多長  
之後會出現兩種情況：

* 123-456- ( 多一個 __-__ )
* 123-456-7 ( 只有一個數字的區塊 )  

針對這兩個情況，多一個-，只要用index去做消除
只有一個數字的區塊就是把6和-交換即可


```c
char p[len+(len/3)+1]
```
是因為若測資為1234，則len: 4  
123-4，len: 5  
保險起見，預設將 **number** 所有字元都當成數字，每三個一組，每組中間都要有 __-__ ，不足一組的+1

### **程式碼**
```c
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
```

