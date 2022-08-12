#include <iostream>
#define N 15

using namespace std;

int apt[N][N];

int main() {
    int t = 0;
    scanf("%d", &t);
    int k,n;

    for(int i = 0; i< N; i++){
        for(int j = 0; j< N; j++){
            if(i == 0) apt[i][j] = j;
            else if(j == 1) apt[i][j] = 1;
            else if(j > 1){
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }
    }

    while(t--){
        scanf("%d\n%d", &k, &n);
        printf("%d\n", apt[k][n]);
    }


}
