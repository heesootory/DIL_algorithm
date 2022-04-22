#include <iostream>
using namespace std;

int dp(int x, int count, int& min) {

	//1. base check
	if (x == 1) {
		if (count < min) min = count;
		return x;
	}

	//2. memoization
	count++;

	//3. recurrence relation
	if (x % 3 == 0) {
		if (count >= min) return x;
		else dp(x / 3, count, min);
	}
	if (x % 2 == 0) {
		if (count >= min) return x;
		else dp(x / 2, count, min);
	}
	if (count >= min) return x;
	else dp(x - 1, count, min);

	return x;

}


int main() {

	int x = 0;
	scanf("%d", &x);
	int count = 0;
	int m = 1000000;
	dp(x, count, m);

	printf("%d", m);
}