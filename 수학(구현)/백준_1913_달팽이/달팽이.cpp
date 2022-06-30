#include <iostream>

using namespace std;

int main() {
    int n,m;
    scanf("%d\n%d", &n, &m);
    int arr[1000][1000] = {0};

    int k = 1;
    int i = n/2;
    int j = n/2;
    int num = 1;

    arr[i][j] = num;
    while(k <= n){
        if(k == n) {
            for(int r =0; r< k-1; r++){
                i--;
                num++;
                arr[i][j] = num;
            }
        }else if(k % 2 != 0){
            for(int r =0; r< k; r++){
                i--;
                num++;
                arr[i][j] = num;
            }
            for(int r =0; r< k; r++){
                j++;
                num++;
                arr[i][j] = num;
            }
        }else{
            for(int r =0; r< k; r++){
                i++;
                num++;
                arr[i][j] = num;
            }
            for(int r =0; r< k; r++){
                j--;
                num++;
                arr[i][j] = num;
            }
        }
        k++;
    }
    int ans_i = 0;
    int ans_j = 0;
    for(int i =0; i< n; i++){
        for(int j = 0; j < n; j++){
            printf("%d ", arr[i][j]);
            if(arr[i][j] == m){
                ans_i = i; ans_j = j;
            }
        }
        printf("\n");
    }
    printf("%d %d", ans_i+1, ans_j+1);
}

