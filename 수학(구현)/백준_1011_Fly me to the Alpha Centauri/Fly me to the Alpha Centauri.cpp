#include <iostream>
#include <cmath>
using namespace std;


int main()
{
	int n;
	scanf("%d", &n);
	long long start, end;
	long long term = 0;
	while (n--) {
		scanf("%d %d", &start, &end);
		term = end - start;
		
		if (term == 1) printf("1\n");
		else if (term == 2) printf("2\n");
		else {
			long long num1 = 2;
			long long num_plus = 1;
			long long num2 = 3;
			long long cnt = 2;

			while (1) {
				cnt++;
				num1 += num_plus;
				num_plus++;
				num2 += num_plus;
				if (num1 <= term && term < num2) break;
				
				cnt++;
				num1 += num_plus;
				num2 += num_plus;
				if (num1 <= term && term < num2) break;
			}
			printf("%lld\n", cnt);
		}
	}
	

}
