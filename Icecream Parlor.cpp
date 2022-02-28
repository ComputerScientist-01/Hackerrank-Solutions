#include <vector> 
#include <list>
#include <queue>
#include <set>
#include <map>
#include <string>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <functional>
#include <numeric>
#include <cstdlib>
#include <cmath>
#include <cstdio>
#include <fstream>
#include <ctime>

using namespace std; 

int main()
{
    int T;
    cin >> T;
    for (int i = 0; i < T; ++i) {
        int C, L;
        cin >> C >> L;
        vector<int> v(L);
        map<int, int> M;
        for (int j = 0; j < L; ++j)
            cin >> v[j];
        
        for (int j = 0; j < L; ++j) {
            int diff = C - v[j];
            if (M.count(diff)) {
                cout << 1 + M[diff] << " " << 1 + j << endl;
                break;
            }
            M[v[j]] = j;
        }
    }


    return 0;
}
