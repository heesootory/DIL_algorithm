#include <iostream>
#include <vector>
#include <queue>
using namespace std;

queue<int> q;
vector<int> edge[100001];
bool check[100001];
int parent_node[100001];

void BFS(int n)
{
    q.push(n);
    check[n] = true;

    while (q.empty() == false)
    {
        int f = q.front();
        q.pop();

        for (int i : edge[f])
        {
            if (check[i] == false)
            {
                check[i] = true;
                q.push(i);
                parent_node[i] = f;
            }
        }
    }
}

int main()
{
    int N = 0;
    cin >> N;
    int M = N - 1;

    while (M--)
    {
        int a, b;
        cin >> a >> b;
        edge[a].push_back(b);
        edge[b].push_back(a);
    }

    BFS(1);

    for (int i = 2; i < N + 1; i++)
    {
        cout << parent_node[i] << "\n";
    }
}
