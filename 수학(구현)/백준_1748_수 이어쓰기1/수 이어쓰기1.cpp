#include <iostream>
#include <vector>
#include <queue>
#include <cmath>
using namespace std;

int main()
{

    int N;
    scanf("%d", &N);

    long long sum = 0;
    int m = 9;
    int ten_mul = 10;
    int i = 1;
    int norm = m;

    while (N > norm)
    {
        N -= norm;
        sum += ((long long)norm * i);
        i++;
        norm = m * pow(ten_mul, i - 1);
    }
    sum += ((long long)N * i);
    printf("%lld", sum);
}

// long 과 long long의 차이점은???
