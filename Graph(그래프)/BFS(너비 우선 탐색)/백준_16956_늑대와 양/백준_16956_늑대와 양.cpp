#include <iostream>
using namespace std;
#define ROW 500
#define COL 500

char medow[ROW][COL];
char mx[4] = { 0, 1, 0, -1 };       //시계방향 조사
char my[4] = { 1, 0, -1, 0 };

void print(char arr[][COL], int r, int c) {
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cout << arr[i][j];
        }
        cout << "\n";
    }
}

int main() {
    int R = 0;
    int C = 0;
    scanf("%d %d\n", &R, &C);
    bool defense = true;

    for (int i = 0; i < R; i++) {
        cin >> medow[i];
    }

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (medow[i][j] == 'S') {
                for (int a = 0, b = 0; a < 4; a++, b++) {       //양 주위 시계 방향으로 조사
                    int new_i = i + mx[a];
                    int new_j = j + my[b];
                    if (new_i <0 || new_j <0 || new_i >R-1 || new_j >C-1) continue;         //범위 배열 넘을시.

                    if (medow[new_i][new_j] == 'W') defense = false;
                    else if (medow[new_i][new_j] == 'S' || medow[new_i][new_j] == 'D') continue;
                    else medow[new_i][new_j] = 'D';
                }
            }
        }
    }
    if (defense) cout << "1";
    else cout << "0";
    cout << "\n";
    print(medow, R, C);
}