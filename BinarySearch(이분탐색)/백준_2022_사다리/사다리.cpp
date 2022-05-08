#include <iostream>
#include <cmath>
using namespace std;

double mid_height(double x, double y, double m)
{
    double h1 = sqrt(pow(x, 2) - pow(m, 2));
    double h2 = sqrt(pow(y, 2) - pow(m, 2));

    return (h1 * h2) / (h1 + h2); //높이
}

int main()
{

    double x, y, c;
    scanf("%lf %lf %lf", &x, &y, &c);
    double max_len = min(x, y);
    double min_len = 0;
    double mid = 0;

    while (max_len - min_len > 0.000001)
    {
        mid = (max_len + min_len) / 2.0; //이분탐색
        double result = mid_height(x, y, mid);

        // cout << mid << endl;

        if (c <= result)
            min_len = mid;
        else
            max_len = mid;
    }

    printf("%.3lf", mid);
}
