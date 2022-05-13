#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int N;
    scanf("%d", &N);
    int x, y;
    int first_x = 0, first_y = 0;
    int past_x = 0;
    int past_y = 0;
    long long sum1 = 0;
    long long sum2 = 0;

    for (int i = 0; i < N; i++)
    {
        scanf("%d %d", &x, &y);
        if (i == 0)
        {
            first_x = x;
            first_y = y;
        }

        sum1 += ((long long)past_x * y);
        sum2 += ((long long)past_y * x);
        past_x = x;
        past_y = y;
    }
    sum1 += ((long long)past_x * first_y);
    sum2 += ((long long)past_y * first_x);

    long long max_sum = max(sum1, sum2);
    long long min_sum = min(sum1, sum2);
    double ans = (double)(max_sum - min_sum) / 2;
    ans = round(ans * 10) / 10;
    printf("%.1f", ans);
}
