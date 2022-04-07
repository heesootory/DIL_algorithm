#include <iostream>
#include <algorithm>

using namespace std;

int d[50];

int dp(int n) {
	//1. base check
	if (n <= 1) return n;

	//2. memoization
	if (d[n] > 0) return d[n];

	//3. recurrence relation
	d[n] = dp(n - 1) + dp(n - 2);

	return d[n];
}


int main() {

	int N;
	scanf("%d", &N);
	printf("%d", dp(N));
}