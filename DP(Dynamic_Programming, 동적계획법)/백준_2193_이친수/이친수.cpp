#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

long arr[100] = { 0,1 };

int main() {

	int n = 0;
	scanf("%d", &n);
	for (int i = 2; i <= n; i++) arr[i] = arr[i - 1] + arr[i - 2];
	printf("%lld", arr[n]);

}