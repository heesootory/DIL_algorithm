#include <iostream>
#include <string.h>     //memset
using namespace std;

char arr[200][400];

void set(int n, int r, int idx){
    int row = 2*n-1;
    int col = 4*n-3;

    memset(arr[r], ' ', col + 1 - idx);

    if (r == 0 || r == row-1) {
        memset(arr[r], '*', n);
        memset(arr[r] + col - n, '*', n);
    }
    else {
        memset(arr[r] + idx, '*', 1);
        memset(arr[r] + idx + (n - 1), '*', 1);
        memset(arr[r] + col - idx - 1, '*', 1);
        memset(arr[r] + col - idx - n, '*', 1);
    }
}

int main() {
    int n = 0;
    scanf("%d", &n);
    int idx = 0;

    for(int i = 0; i< 2*n-1; i++){
        set(n, i, idx);
        if(i < n- 1) idx++;
        else idx--;
    }

    for(int i = 0; i< 2 * n - 1; i++ ) printf("%s\n", arr[i]);
    return 0;
}

