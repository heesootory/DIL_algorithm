#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int sea[51][51];
int n, m;
int max_cnt = 0;

int mx[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
int my[8] = {-1, 0, 1, 1, 1, 0, -1, -1};

struct shark
{
    int x;
    int y;
};

queue<shark> q;

void BFS()
{
    while (q.empty() == false)
    {
        int sx = q.front().x;
        int sy = q.front().y;
        q.pop();
        for (int i = 0; i < 8; i++)
        {
            int new_x = sx + mx[i];
            int new_y = sy + my[i];
            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m)
            {
                if (sea[new_x][new_y] == 0)
                {
                    sea[new_x][new_y] = sea[sx][sy] + 1;
                    q.push({new_x, new_y});
                    if (sea[new_x][new_y] > max_cnt)
                        max_cnt = sea[new_x][new_y];
                }
            }
        }
    }
}

int main()
{
    scanf("%d %d", &n, &m);
    int inp = 0;
    shark s;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &inp);
            sea[i][j] = inp;
            if (inp == 1)
            {
                s.x = i;
                s.y = j;
                q.push(s);
            }
        }
    }

    BFS();

    printf("%d", max_cnt - 1);
}
