#include <iostream>
#include <cmath>
using namespace std;

int GCD(int a, int b)
{
    int p = max(a, b);
    int q = min(a, b);
    int left = p % q;
    while (left != 0)
    {
        p = q;
        q = left;
        left = p % q;
    }
    return q;
}

int main()
{
    int g, l;
    scanf("%d %d", &g, &l);

    if (g == l)
    {
        printf("%d %d", g, g);
    }
    else
    {
        int p = l / g;
        int sum = p + 2;
        int a = 0, b = 0;

        for (int i = 1; i < p; i++)
        {
            if (p % i == 0)
            {
                int j = p / i;
                if (GCD(i, j) == 1)
                {
                    if (i + j < sum)
                    {
                        sum = i + j;
                        a = i;
                        b = j;
                    }
                    else
                        break;
                }
            }
        }

        if (a < b)
            printf("%d %d", a * g, b * g);
        else
            printf("%d %d", b * g, a * g);
    }
}
