#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[1000] = { 0,1,3 };

int main() {
	int n = 0;
	scanf("%d", &n);

	for (int i = 3; i <= n; i++) {
		int m = arr[i - 1] * 2;
		(i % 2 == 0) ? m += 1 : m -= 1;
		arr[i] = (m >= 10007) ? m % 10007 : m;
	}
	printf("%d", arr[n]);


}