#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector<int> edge[1001];
bool check[1001];

void DFS(int n) {		//재귀함수로 해결
	if (check[n] == true) return;

	check[n] = true;
	cout << n << " ";
	for (auto i : edge[n]) DFS(i);

}

void BFS(int n) {			//큐를 이용
	queue<int> q;
	q.push(n);
	check[n] = true;

	while (q.empty() == false) {
		int f = q.front();
		cout << f << " ";
		q.pop();
		for (int i : edge[f]) {
			if (check[i] == false) {
				q.push(i); check[i] = true;
			}
		}
	}
}


int main() {
	
	int n = 0, m = 0, v = 0;
	cin >> n >> m >> v;

	int a, b;

	while (m--) {
		cin >> a >> b;
		edge[a].push_back(b);
		edge[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) sort(edge[i].begin(), edge[i].end());
	DFS(v);
	for (int i = 1; i <= n; i++) check[i] = false;
	cout << "\n";
	BFS(v);
	
}