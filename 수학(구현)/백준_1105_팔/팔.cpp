#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int L, R;
    scanf("%d %d", &L, &R);
    int min_cnt = 10;
    for (int i = L; i <= R; i++)
    {
        int n = i;
        int cnt = 0;
        while (n > 0)
        {
            if (n % 10 == 8)
                cnt++;
            n /= 10;
        }
        if (cnt < min_cnt)
            min_cnt = cnt;
        if (min_cnt == 0)
            break;
    }
    printf("%d", min_cnt);
}
