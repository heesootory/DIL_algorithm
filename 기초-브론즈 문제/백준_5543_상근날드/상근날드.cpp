#include <iostream>

using namespace std;

int main(){
    int set[5] = {0};

    for(int i = 0; i < 5; i++){
        scanf("%d", &set[i]);
    }

    int min = 2000;
    for(int i = 0; i<3; i++) {
        if(set[i] < min) min = set[i];
    }
    
    int min2 = (set[3] < set[4]) ? set[3] : set[4];

    printf("%d", min + min2 -50);

}
