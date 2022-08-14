#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int a, b;
queue<int> q;
vector<int> _move;
bool check[100001];
int seconds[100001];

void BFS(int n)
{
    q.push(n);
    check[n] = true;

    while (q.empty() == false)
    {
        int f = q.front();
        q.pop();
        _move.push_back(f - 1);
        if (f < b) // 목적지 보다 클때 굳이 더 크게 갈필요 없음.
        {
            _move.push_back(f + 1);
            _move.push_back(f * 2);
        }
        for (int i : _move)
        {
            if (i >= 0 && i <= 100000) //조사 범위 한정
            {
                if (check[i] == false)
                {
                    q.push(i);
                    check[i] = true;
                    seconds[i] = seconds[f] + 1;
                    if (i == b)
                        return;
                }
            }
        }
        _move.clear();
    }
}

int main()
{
    scanf("%d %d", &a, &b);

    BFS(a);

    cout << seconds[b];
}
