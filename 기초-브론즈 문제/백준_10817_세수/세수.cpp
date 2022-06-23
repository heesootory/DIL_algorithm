#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int arr[3] = {0};
    for(int i = 0; i< 3; i++) scanf("%d", &arr[i]);
    sort(arr, arr+3);
    printf("%d", arr[1]);
}
