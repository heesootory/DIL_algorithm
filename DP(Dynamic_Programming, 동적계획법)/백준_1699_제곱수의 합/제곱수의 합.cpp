#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// bottom-up방식: 앞에 나온 경우들을 잘 이용해야함.

int arr[100001];

int main() {

	int n = 0;
	scanf("%d", &n);
	
	for (int i = 1; i <= n; i++)	 
		arr[i] = i;					//모두 1^2으로 채웠을때의 값으로 맞추기(최대의 개수)

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j * j <= i; j++) {
			arr[i] = min(arr[i], arr[i - j * j] + 1);
		}
	}

	printf("%d", arr[n]);




}