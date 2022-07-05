#include <iostream>
#include <cstring>
using namespace std;

int arr[10001];

int main() {
    int n = 0;
    scanf("%d", &n);
    char s[10];
    int f = 0;

    while(n--){
        scanf("%s", &s);
        if(strcmp(s, "push") == 0){
            int num = 0;
            scanf("%d", &num);
            arr[f] = num;
            f++;
        }
        else if(strcmp(s, "pop") == 0){
            if(f == 0) printf("-1\n");
            else{
                printf("%d\n", arr[f-1]);
                arr[f-1] = 0;
                f--;
            }
        }
        else if(strcmp(s, "size") == 0) printf("%d\n", f);
        else if(strcmp(s, "empty") == 0){
            if(f == 0) printf("1\n");
            else printf("0\n");
        }
        else if(strcmp(s, "top") == 0){
            if(f == 0) printf("-1\n");
            else printf("%d\n", arr[f-1]);
        }
    }


}

