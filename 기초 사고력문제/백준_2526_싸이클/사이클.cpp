#include <iostream>

using namespace std;

int main() {
    int n, p;
    scanf("%d %d", &n, &p);
    int arr[1001] = {0};
    int m = n;
    int cnt = 0;
    while(1){
        int i = (n*m)%p;
        if(arr[i] > 2) break;
        arr[i]++;
        m = i;
    }
    for(int i = 0; i< 1001; i++){
        if(arr[i] > 1) cnt++;
    }
    printf("%d", cnt);
}
