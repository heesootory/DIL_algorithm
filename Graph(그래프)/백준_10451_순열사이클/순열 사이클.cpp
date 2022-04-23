#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int arr[1001];
bool check[1001];

int cycle(int n) {
	int count = 0;
	for (int i = 1; i <= n; i++) {
		if (check[i] == false) {
			count++;
			int start = i;
			int end = arr[i];
			while (start != end) {
				check[end] = true;
				end = arr[end];
			}
		}
	}
	return count;
}

int main() {
	int T = 0;
	cin >> T;
	int n = 0;
	while (T--) {
		cin >> n;
		for (int i = 1; i <= n; i++) {
			cin >> arr[i];
			check[i] = false;
		}
		cout << cycle(n) << "\n";
	}

}