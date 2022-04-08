#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <stack>
using namespace std;

int total, N;

bool check(vector<int>& v, int col, int row) {
	for (int i = 0; i < col; i++) {
		if ((abs(col - i) == abs(row - v[i])) || (v[i] == row)) return false;
	}
	return true;
}


void Queen(vector<int>& v, int col) {
	if (col == N) {
		total++; 
		/*for (int k = 0; k < N; k++) printf("%d ", v[k]);
		printf("\n");*/
		return;
	}
	for (int row = 0; row < N; row++) {
		if (check(v, col, row)) {
			v[col] = row;
			Queen(v, col+1);
			v[col] = -1;
		}
	}

}

int main() {

	scanf("%d", &N);
	vector<int> v(N, -1);
	
	Queen(v, 0);

	printf("%d", total);

}