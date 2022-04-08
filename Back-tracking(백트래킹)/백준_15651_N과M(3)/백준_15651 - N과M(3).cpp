#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <stack>
using namespace std;

void info(vector<int> v) {
	for (int i = 0; i < v.size(); i++) {
		printf("%d ", v[i]);
	}
	printf("\n");
}

void dynamic(int n, int m, vector<int>& v) {
	if (m == 0) {
		info(v); return;
	}
	for (int i = 1; i <= n; i++) {
		v.push_back(i);
		dynamic(n, m - 1, v);
		v.pop_back();
	}
}

int main() {
	vector<int> v;
	int n, m;
	scanf("%d %d", &n, &m);
	dynamic(n, m, v);
	
	
}