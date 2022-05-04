#include <iostream>
using namespace std;

bool is_prime_number(int n)
{
    for (int i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main()
{
    int n;
    while (1)
    {
        scanf("%d", &n);
        if (n == 0)
            break;

        int count = 0;
        for (int i = n + 1; i <= 2 * n; i++)
        {
            if (is_prime_number(i))
                count++;
        }
        printf("%d\n", count);
    }
}
