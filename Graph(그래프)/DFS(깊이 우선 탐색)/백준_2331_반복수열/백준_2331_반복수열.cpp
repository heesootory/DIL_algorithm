#include <iostream>
#define max 300000    //주의! 9의 5승이 4자리일때, 23만이 넘어감. 범위 조심!

int count_arr[max];

void DFS(int a, int p) {
    int new_a = 0;

    while (a > 0) {    // 새로운 수 만들기
        int left = a % 10;
        int leftSquare = 1;
        for (int i = 0; i < p; i++) leftSquare *= left;
        new_a += leftSquare;
        a /= 10;
    }

    count_arr[new_a]++;
    if (count_arr[new_a] > 2) return;    //2회까지 반복되는 수열 확인 후, return 
    DFS(new_a, p);
}


int main() {
    int A = 0, P = 0;

    scanf("%d %d", &A, &P);

    count_arr[A] ++;
    DFS(A, P);
    int count = 0;
    for (int i = 0; i < max; i++)
        if (count_arr[i] == 1) count++;

    printf("%d", count);



}