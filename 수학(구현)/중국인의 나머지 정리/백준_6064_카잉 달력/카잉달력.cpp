#include <iostream>
#include <cmath>
using namespace std;

int GCD(int a, int b)
{
    int left = 0;
    while (1)
    {
        left = a % b;
        if (left == 0)
            break;
        a = b;
        b = left;
    }
    return b;
}

int LCD(int a, int b)
{
    int gcd = GCD(a, b);
    return (a / gcd * b / gcd * gcd);
}

int main()
{

    int _case;
    scanf("%d", &_case);
    int M, N, x, y;
    while (_case--)
    {
        scanf("%d %d %d %d", &M, &N, &x, &y);

        int i = x;
        bool is = false;
        int lcd = LCD(M, N);

        if (N == y)
            y = 0;
        while (i <= lcd)
        {
            if (i % N == y)
            {
                is = true;
                break;
            }
            i += M;
        }

        if (is)
            printf("%d\n", i);
        else
            printf("-1\n");
    }
}
