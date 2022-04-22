#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long long arr[1000] = { 0,1,2 };

int main() {
	int n = 0;
	scanf("%d", &n);

	for (int i = 3; i <= n; i++) {
		int m = arr[i - 1] + arr[i - 2];
		arr[i] = (m >= 10007) ? (m % 10007) : (m);
	}
	printf("%d", arr[n]);
	

	// 피보나치 -> 계차도 피보나치
	//			-> 나머지도 피보나치
}