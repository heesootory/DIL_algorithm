#include <iostream>
#include <string.h>
using namespace std;


int main() {
    int n = 0;
    scanf("%d", &n);
    int arr[100] = {0};

    for(int i = 0; i< n; i++) scanf("%d", &arr[i]);

    int sum = 0;
    for(int i = n - 1; i > 0; i--) {
        if(arr[i-1] >= arr[i]){
            sum += (arr[i-1] - (arr[i] - 1));
            arr[i-1] = arr[i] - 1;
        }
    }

    printf("%d", sum);
}

