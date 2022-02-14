#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeInWords' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER h
#  2. INTEGER m
#
numbers = ['','one','two','three','four','five','six','seven','eight','nine','ten','eleven','twelve', 'thirteen','fourteen','quarter','sixteen','seventeen','eighteen','nineteen','twenty','twenty one','twenty two','twenty three','twenty four','twenty five','twenty six','twenty seven','twenty eight','twenty nine','half']


text=""
# Difference minutes / minute
def have_pluralsuffix(m):
    if m== 1 or m == 59 : 
        return False
    return True

# quarter dont include past or to !! 
def have_quarter_or_half(m):
    if m%30==15 or m==30 : 
        return True
    return False

    

def timeInWords(h, m):
    if m==0 : 
        text= str(numbers[h] + " o' clock")
    elif 0<m<=30:
        if   not have_quarter_or_half(m) : 
            if have_pluralsuffix(m):
                text=str(numbers[m] +" minutes past " + numbers[h])
            else:
                text=str(numbers[m] +" minute past " + numbers[h])

            
        else:
            text=str(numbers[m] +" past " + numbers[h])

    else:
        if not have_quarter_or_half(m) : 
            if have_pluralsuffix(m):
                text= str(numbers[(30-m)%30] +" minutes to " + numbers[h+1])
            else :
                text= str(numbers[(30-m)%30] +" minute to " + numbers[h+1])

        else:  

            text= str(numbers[(30-m)%30] +" to " + numbers[h+1])
        
        
        
    print(text)
    return text
        
    
    
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    h = int(input().strip())

    m = int(input().strip())

    result = timeInWords(h, m)

    fptr.write(result + '\n')

    fptr.close()
