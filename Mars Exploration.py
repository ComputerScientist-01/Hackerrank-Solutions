#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'marsExploration' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#

def marsExploration(s):
    iterations, cntViolations = len(s)//3, 0
    for iteration in range(iterations):
        subStr = s[(iteration*3):(iteration*3+3)]
        print(subStr)
        if subStr[0]!='S':
            cntViolations += 1
        if subStr[1] != 'O':
            cntViolations += 1
        if subStr[2] != 'S':
            cntViolations += 1
    return cntViolations

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = marsExploration(s)

    fptr.write(str(result) + '\n')

    fptr.close()
