#include <iostream>
using namespace std;

bool is_prime(int n)
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
    int a = 0;

    while (true)
    {
        scanf("%d", &n);
        if (n == 0)
            break;

        for (int i = 3; i < n; i += 2)
        { //홀수만
            if (is_prime(i) && is_prime(n - i))
            { //소수만
                a = i;
                break;
            }
        }

        if (a != 0)
            printf("%d = %d + %d\n", n, a, n - a);
        else
            printf("Goldbach's conjecture is wrong.");
    }
}
