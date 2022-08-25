#include <iostream>

using namespace std;

int main() {
    int arr[42] = {0};
    int n = 10;
    int a = 0;
    while(n--){
        scanf("%d", &a);
        arr[a%42]++;
    }
    int cnt = 0;
    for(int i = 0; i< 42; i++){
        if(arr[i] > 0) cnt++;
    }
    printf("%d", cnt);
}

