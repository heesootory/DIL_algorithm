#include <iostream>
#include <cmath>
using namespace std;

int count_zero(int n, int k)
{
    int cnt = 0;

    for (long long i = k; i <= n; i *= k)
    {
        cnt += (n / i);
    }

    return cnt;
}

int main()
{
    int n, m;
    scanf("%d %d", &n, &m);

    int f = count_zero(n, 5) - count_zero(m, 5) - count_zero(n - m, 5);
    int t = count_zero(n, 2) - count_zero(m, 2) - count_zero(n - m, 2);

    printf("%d", min(f, t));
}
