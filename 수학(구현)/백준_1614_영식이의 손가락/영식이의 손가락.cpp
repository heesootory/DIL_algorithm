#include <iostream>
using namespace std;

int main()
{

    long long sick_finger, can_count;
    scanf("%lld", &sick_finger);
    scanf("%lld", &can_count);

    long long num_count = 0;

    if (can_count == 0)
    {
        for (int i = 1; i < sick_finger; i++)
        {
            num_count++;
        }
    }
    else
    {
        if (sick_finger == 1 || sick_finger == 5)
        {
            num_count += (4 * 2 * can_count);
            for (int i = 1; i < sick_finger; i++)
            {
                num_count++;
            }
        }
        else
        {
            num_count += (4 * can_count);
            if (can_count % 2 == 0)
            {
                for (int i = 1; i < sick_finger; i++)
                {
                    num_count++;
                }
            }
            else
            {
                for (int i = 5; i > sick_finger; i--)
                {
                    num_count++;
                }
            }
        }
    }
    printf("%lld", num_count);
}
