#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
int main() {
    
    unsigned t;
    scanf ("%u", &t);
    while (t--) {
        unsigned n;
        scanf ("%u", &n);
        unsigned a[n];
        for (unsigned i = 0; i < n; i++) {
            scanf ("%u", a + i);
        }
        unsigned int num_inv = 0;
        for (unsigned i = 0; i < n ; i++) {
            for (unsigned j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    num_inv++;
                }
            }
        }
        if (num_inv % 2) {
            printf ("NO\n");
        } else {
            printf ("YES\n");
        }
    }
    return 0;
}
