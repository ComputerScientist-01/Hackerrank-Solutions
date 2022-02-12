#include <cstdio>
#include <cmath>
#include <iostream>
#include <set>
#include <algorithm>
#include <vector>
#include <map>
#include <cassert>
#include <string>
#include <cstring>
#include <queue>

using namespace std;

#define rep(i,a,b) for(int i = a; i < b; i++)
#define S(x) scanf("%d",&x)
#define S2(x,y) scanf("%d%d",&x,&y)
#define P(x) printf("%d\n",x)
#define all(v) v.begin(),v.end()
#define FF first
#define SS second
#define pb push_back
#define mp make_pair

typedef long long int LL;
typedef pair<int, int > pii;
typedef vector<int > vi;

const int mod = 1000000007;
const int N = 100005;

LL F[N], IF[N];

LL _pow(LL a, LL b) {
  if(!b) return 1;
  if(b == 1) return a;
  if(b == 2) return a * a % mod;
  if(b & 1) {
    return a * _pow(a,b-1) % mod;
  }
  return _pow(_pow(a,b/2),2);
}

void pre() {
  F[0] = 1;
  rep(i,1,N) {
    F[i] = i * F[i-1] % mod;
  }
  IF[N - 1] = _pow(F[N - 1], mod - 2);
  for(int i = N - 2; i >= 0; i--) {
    IF[i] = IF[i + 1] * (i + 1) % mod;
  }
}

int X[26][N];

int main() {
  pre();
  string s;
  cin >> s;
  int n = s.size();
  rep(i,0,n) {
    rep(j,0,26) X[j][i+1] = X[j][i];
    X[s[i]-'a'][i+1]++;
  }
  int q;
  S(q);
  while(q--) {
    int l,r;
    S2(l,r);
    int tot = 0;
    LL ans = 1;
    int odd = 0;
    rep(i,0,26) {
      int x = X[i][r] - X[i][l-1];
      odd += (x&1);
      ans *= IF[x / 2];
      ans %= mod;
      tot += x / 2;
    }
    ans *= F[tot];
    ans %= mod;
    if(odd) ans = ans * odd % mod;
    printf("%lld\n",ans);
  }
  return 0;
}
