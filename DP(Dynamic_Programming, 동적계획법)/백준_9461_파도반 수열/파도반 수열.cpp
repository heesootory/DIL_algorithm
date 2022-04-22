#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long arr[101] = { 1,1,1,2,2 };

int main() {
	int T = 0;
	scanf("%d", &T);

	while (T--) {
		int n = 0;
		scanf("%d", &n);
		if (n < 5) printf("%lld\n", arr[n-1]);
		else {
			for (int i = 5; i < n; i++) {
				arr[i] = arr[i - 1] + arr[i - 5];
			}
			printf("%lld\n", arr[n - 1]);
		}
	}

	
}