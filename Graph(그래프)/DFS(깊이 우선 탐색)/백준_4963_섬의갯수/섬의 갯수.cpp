#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

bool arr[51][51];

void DFS(int i, int j) {
	if (arr[i][j] == false) return;

	arr[i][j] = false;
	DFS(i + 1, j);
	DFS(i + 1, j - 1);
	DFS(i + 1, j + 1);
	DFS(i, j - 1);
	DFS(i, j + 1);
	DFS(i - 1, j);
	DFS(i - 1, j - 1);
	DFS(i - 1, j + 1);
}

int main() {
	int w;
	int h;
	
	while (1) {
		cin >> w >> h;
		if (w == 0 && h == 0) break;
		int count = 0;
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				cin >> arr[i][j];
			}
		}

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				if (arr[i][j]) {
					count++;
					DFS(i, j);
				}
			}
		}
		
		cout << count << '\n';
	}


}