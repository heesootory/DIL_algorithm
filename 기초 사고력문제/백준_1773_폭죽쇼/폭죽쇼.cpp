#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, c;
    int time[101] = {0};
    bool firework[2000001] = {false};
    scanf("%d %d", &n, &c);
    for(int i = 0; i<n; i++) scanf("%d", &time[i]);

    int count = 0;
    for(int i = 0; i< n; i++){
        for(int j = time[i]; j<= c; j+=time[i]){
            if(firework[j]) continue;
            firework[j] = true;
            count++;
        }
    }
    printf("%d", count);
}



