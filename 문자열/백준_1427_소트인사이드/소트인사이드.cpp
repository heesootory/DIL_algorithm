#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool down(int i, int j){
    return i > j;
}

int main() {
    int n = 0;
    scanf("%d", &n);
    vector<int> v;
    int i = 0;
    while(n >= 1){
        v.push_back(n%10);
        i++;
        n/=10;
    }
    sort(v.begin(), v.end(), down);
    for(auto& i : v) printf("%d", i);

}

