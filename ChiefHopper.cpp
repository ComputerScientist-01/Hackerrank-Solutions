#include <stdio.h>
#include <stdlib.h>

int main() {
  int n, *h, i;
  unsigned long long tot;
  
  scanf("%d",&n);
  h = malloc(n * sizeof(int));
  for (i=0; i<n; i++) scanf("%d",&h[i]);
  
  tot = 0;
  i--;
  while (i>=0) {
    tot += h[i];
    if (tot & 1) tot++;
    tot /= 2;
    i--;
  }
  
  printf("%lld\n",tot);
  
  return 0;
}
