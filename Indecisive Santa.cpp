#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() 
{
    int N,M,g1x,g1y,g2x,g2y;
    scanf("%d%d%d%d%d%d",&N,&M,&g1x,&g1y,&g2x,&g2y);
    
    int min1,min2,indecisive_count=0;
    
    for(int i=1; i<=N; i++)
    {
        for(int j=1; j<=M; j++)
        {
            int x = abs(g1x - i);
            int y = abs(g1y - j);
            min1 = x + y;
            
            x = abs(g2x - i);
            y = abs(g2y - j);
            min2 = x + y;
            
            if(min1 == min2)
                indecisive_count++;
        }
    }
    printf("%d",indecisive_count);
    return 0;
}
