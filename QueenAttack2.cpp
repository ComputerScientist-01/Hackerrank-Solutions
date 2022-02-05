#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;
typedef pair < int, int > ii;
int di[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dj[] = {-1, 0, 1, 1, 1, 0, -1, -1};
set < ii > obstacles;
int n, k;
int rQueen;
int cQueen;
long long answer;
void dfs(int r, int c, int dir) {
    if (r < 1 || r > n || c < 1 || c > n) return;
    if (obstacles.find(ii(r, c)) != obstacles.end()) return;
    answer ++;
    if (r == rQueen && c == cQueen) answer --;
    dfs(r+di[dir], c+dj[dir], dir);
}
int main(){
    cin >> n >> k;
    cin >> rQueen >> cQueen;
    for(int a0 = 0; a0 < k; a0++){
        int rObstacle;
        int cObstacle;
        cin >> rObstacle >> cObstacle;
        obstacles.insert(ii(rObstacle, cObstacle));
    }
    
    for (int i=0; i<8; i++) {
        dfs(rQueen, cQueen, i);
    }
    
    cout << answer << endl;
    
    return 0;
}
