#include <iostream>

using namespace std;

int main() {
    int arr[10] = {0};
    int a,b,c;
    scanf("%d\n%d\n%d", &a, &b, &c);
    int mul = a*b*c;
    while(mul >= 1){
        arr[mul % 10]++;
        mul /= 10;
    }
    for(int i = 0; i< 10; i++) printf("%d\n", arr[i]);
}
