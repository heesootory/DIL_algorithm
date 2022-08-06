#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<int> user[101];
int friends[101];
bool check[101];
queue<int> q;
int min_count = 101;

void BFS(int n) {
	q.push(n);
	check[n] = true;

	while (q.empty() == false) {
		int f = q.front();
		q.pop();
		for (int i : user[f]) {
			if (check[i] == false) {
				friends[i] = friends[f] + 1;
				check[i] = true;
				q.push(i);
			}
		}
	}
}
int friends_init_sum() {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += friends[i];
		friends[i] = 0;
	}
	return sum;
}

void check_init() {
	for (int i = 1; i <= n; i++) check[i] = false;
}


int main() {
	scanf("%d %d", &n, &m);
	while (m--) {
		int a, b;
		scanf("%d %d", &a, &b);
		user[a].push_back(b);
		user[b].push_back(a);
	}
	int min_who = 0;
	for (int i = 1; i <= n; i++) {
		BFS(i);
		check_init();
		int sum_friends = friends_init_sum();
		if (sum_friends < min_count) {
			min_count = sum_friends;
			min_who = i;
		}
	}
	
	printf("%d", min_who);
	


}

