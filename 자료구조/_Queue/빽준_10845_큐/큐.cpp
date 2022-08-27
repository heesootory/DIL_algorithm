#include <iostream>
#include <cstring>
using namespace std;

int arr[10001];

int main() {
    int n = 0;
    scanf("%d", &n);
    char s[10];
    int f = 0;
    int b = 0;

    while(n--){
        scanf("%s", &s);
        if(strcmp(s, "push") == 0){
            int num = 0;
            scanf("%d", &num);
            arr[b] = num;
            b++;
        }
        else if(strcmp(s, "pop") == 0){
            if(f == b) printf("-1\n");
            else{
                printf("%d\n", arr[f]);
                arr[f] = 0;
                f++;
            }
        }
        else if(strcmp(s, "size") == 0) printf("%d\n", b-f);
        else if(strcmp(s, "empty") == 0){
            if(f == b) printf("1\n");
            else printf("0\n");
        }
        else if(strcmp(s, "front") == 0){
            if(f == b) printf("-1\n");
            else printf("%d\n", arr[f]);
        }
        else if(strcmp(s, "back") == 0){
            if(f == b) printf("-1\n");
            else printf("%d\n", arr[b-1]);
        }
    }
}

