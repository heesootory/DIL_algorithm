#include <iostream>

using namespace std;

int main() {
    int n = 0;
    scanf("%d", &n);
    int arr[10] ={0};
    while(n >=1){
        int i = n %10;
        if(i == 9) i = 6;
        arr[i]++;
        n/=10;
    }
    arr[6] = (arr[6] % 2 == 0) ? arr[6]/2 : arr[6]/2+1;
    int max = 0;
    for(int i = 0; i< 10; i++) if(arr[i] > max) max = arr[i];
    printf("%d", max);

}

