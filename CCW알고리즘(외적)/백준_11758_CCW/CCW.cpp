#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int x1, y1, x2, y2, x3, y3;
    scanf("%d %d", &x1, &y1);
    scanf("%d %d", &x2, &y2);
    scanf("%d %d", &x3, &y3);

    if (x2 == x1)
    {
        if (x3 > x1)
            printf("-1");
        else if (x1 == x3)
            printf("0");
        else
            printf("1");
    }
    else
    {
        int denominator = x2 - x1; //분모
        int numerator = y2 - y1;   //분자
        int constant = y2 * denominator - x2 * numerator;

        if (denominator * y3 > numerator * x3 + constant)
            printf("1");
        else if (denominator * y3 == numerator * x3 + constant)
            printf("0");
        else
            printf("-1");
    }
}
