#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int romanToInt(char *s)
{
    int len = strlen(s);
    // int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;
    int counter = 0;
    for (int i = 0; i < len; i++)
    {
        char tmp;
        if (i - 1 > -1)
            tmp = s[i - 1];
        switch (s[i])
        {
        case 'I':
            counter = counter + 1;
            break;
        case 'V':
            if (tmp == 'I')
            {
                counter = counter - 1 + 4;
            }
            else
            {
                counter = counter + 5;
            }
            break;
        case 'X':
            if (tmp == 'I')
            {
                counter = counter - 1 + 9;
            }
            else
            {
                counter = counter + 10;
            }
            break;
        case 'L':
            if (tmp == 'X')
            {
                counter = counter - 10 + 40;
            }
            else
            {
                counter = counter + 50;
            }
            break;
        case 'C':
            if (tmp == 'X')
            {
                counter = counter - 10 + 90;
            }
            else
            {
                counter = counter + 100;
            }
            break;
        case 'D':
            if (tmp == 'C')
            {
                counter = counter - 100 + 400;
            }
            else
            {
                counter = counter + 500;
            }
            break;
        case 'M':
            if (tmp == 'C')
            {
                counter = counter - 100 + 900;
            }
            else
            {
                counter = counter + 1000;
            }
            break;
        }
    }
    printf("counter: %d\n", counter);
    return counter;
}

int main()
{

    romanToInt("III");
    romanToInt("IV");
    romanToInt("IX");
    romanToInt("LVIII");
    romanToInt("MCMXCIV");
}