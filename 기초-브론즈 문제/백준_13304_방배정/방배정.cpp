#include <iostream>

using namespace std;

int n,k;
int arr[2][6];

void room(int& sum, int stu){
    sum += (stu/k);
    if(stu%k != 0) sum+=1;
}

int main() {
    scanf("%d %d", &n, &k);

    int a,b;
    while(n--)
    {
        scanf("%d %d", &a, &b);
        arr[a][b-1]++;
    }
    int s = arr[0][0] + arr[1][0] + arr[0][1] + arr[1][1];
    int mm = arr[1][2] + arr[1][3];
    int mw = arr[0][2] + arr[0][3];
    int hm = arr[1][4] + arr[1][5];
    int hw = arr[0][4] + arr[0][5];
    int sum = 0;
    room(sum, s);
    room(sum, mm);
    room(sum, mw);
    room(sum, hm);
    room(sum, hw);
    printf("%d", sum);

}

