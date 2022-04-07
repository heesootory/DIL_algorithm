#include <iostream>
#include <algorithm>

using namespace std;

long long d[100];

long long dp(int n) {
	//1. base check
	if (n <= 1) return n;

	//2. memoization
	if (d[n] > 0) return d[n];

	//3. recurrence relation
	d[n] = dp(n - 1) + dp(n - 2);
	
	//printf("%d: %lld\n",n,d[n]);
	return d[n];
}


int main() {

	int N;
	scanf("%d", &N);
	printf("%lld", dp(N));
}