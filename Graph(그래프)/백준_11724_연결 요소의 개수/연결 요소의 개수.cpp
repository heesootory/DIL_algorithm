#include <iostream>
#include <vector>
using namespace std;

bool check[1001];
vector<int> arr_list[1001];

void DFS(int n)
{
	for (int i = 0; i < arr_list[n].size(); i++)
	{
		int v = arr_list[n][i];

		if (check[v] == false)
		{
			check[v] = true;
			DFS(v);
		}
	}
}

int main()
{
	int N = 0, M = 0;
	scanf("%d %d", &N, &M);
	int count = 0;

	while (M--)
	{
		int a = 0, b = 0;
		scanf("%d %d", &a, &b);
		arr_list[a].push_back(b);
		arr_list[b].push_back(a);
	}

	for (int i = 1; i <= N; i++)
	{
		if (check[i] == false)
		{
			check[i] = true;
			count++;
			DFS(i);
		}
	}

	printf("%d", count);
}
