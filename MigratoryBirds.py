#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'migratoryBirds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def migratoryBirds(arr):
    # Write your code here
    a=[]
    l=len(arr)
    v=0
    for i in range(1,10):
        v=0
        for j in range(0,l):
            if(i==arr[j]):
                v=v+1
        a.append(v)
    
    b=[]
    for i in a:
        b.append(i)
    for h in range(0,len(b)):
        for i in range(0,len(b)):
            for j in range(0,len(b)):
                if(i!=j):
                    if(b[i]<b[j]):
                        temp=b[i]
                        b[i]=b[j]
                        b[j]=temp
    value=b[len(b)-1]
    
    c=[]
    for i in range(0,len(a)):
        if(value==a[i]):
            c.append(i+1)
    return c[0]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
