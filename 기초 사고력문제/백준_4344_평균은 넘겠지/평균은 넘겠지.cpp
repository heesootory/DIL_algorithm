#include <iostream>

using namespace std;


int main() {
    int t = 0;
    scanf("%d", &t);

    int stu_score[1001] = {0};

    int n = 0;
    float ever = 0;
    while(t--){
        scanf("%d", &n);
        int sum = 0;
        for(int i =0; i<n; i++) {
            scanf("%d", &stu_score[i]);
            sum += stu_score[i];
            ever = (float)sum/n;
        }
        int cnt = 0;
        for(int i =0; i< n; i++){
            if(stu_score[i] > ever) cnt++;
        }

        printf("%.3f%%\n", ((float)cnt*100/n));
    }




}

