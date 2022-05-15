#include <iostream>
#include <cmath>
using namespace std;

int external_product(long long a1, long long b1, long long a2, long long b2, long long a3, long long b3)
{
    long long ans = ((a1 - a2) * (b2 - b3)) - ((a2 - a3) * (b1 - b2));
    if (ans > 0)
        return 1;
    else if (ans < 0)
        return -1;
    else
        return 0;
}

int main()
{
    int x1, y1, x2, y2;
    int x3, y3, x4, y4;

    scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
    scanf("%d %d %d %d", &x3, &y3, &x4, &y4);

    int a = external_product(x1, y1, x2, y2, x3, y3);
    int b = external_product(x1, y1, x2, y2, x4, y4);
    int c = external_product(x3, y3, x4, y4, x1, y1);
    int d = external_product(x3, y3, x4, y4, x2, y2);

    if (a * b <= 0 && c * d <= 0)
        printf("1");
    else
        printf("0");
}
