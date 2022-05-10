#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int N, k;
	scanf("%d %d", &N, &k);
	
	int norm = 1;
	long long norm_cnt = 9;
	long long all_cnt = 0;
	
	while (N > norm_cnt) {
		N -= norm_cnt;
		all_cnt += (norm * norm_cnt);
		norm++;
		norm_cnt *= 10;
	}
	all_cnt += ((long long)N * norm);

	norm = 1;
	norm_cnt = 9;
	int cnt = 0;

	while (k > cnt + (norm * norm_cnt)) {
		cnt += (norm * norm_cnt);
		norm++;
		norm_cnt *= 10;
	}
	
	int cal = k - (cnt + 1);
	int quotient = cal / norm;
	int remainder = cal % norm;
	int i = norm - remainder;
	int num = pow(10, norm-1) + quotient;
	
	int ans = 0;
	while (i--) {
		ans = num % 10;
		num /= 10;
	}
	
	if (k > all_cnt) printf("-1");
	else printf("%d", ans);

}