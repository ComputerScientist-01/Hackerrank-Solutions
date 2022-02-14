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
    return m not in [1, 59]

# quarter dont include past or to !! 
def have_quarter_or_half(m):
    return m%30==15 or m==30



def timeInWords(h, m):
    if m==0: 
        text= str(numbers[h] + " o' clock")
    elif 0<m<=30:
        if have_quarter_or_half(m):
            text = str(f'{numbers[m]} past {numbers[h]}')

        elif have_pluralsuffix(m):
            text = str(f'{numbers[m]} minutes past {numbers[h]}')
        else:
            text = str(f'{numbers[m]} minute past {numbers[h]}')


    elif have_quarter_or_half(m):  

        text = str(f'{numbers[(30-m)%30]} to {numbers[h+1]}')



    elif have_pluralsuffix(m):
        text = str(f'{numbers[(30-m)%30]} minutes to {numbers[h+1]}')
    else:
        text = str(f'{numbers[(30-m)%30]} minute to {numbers[h+1]}')

    print(text)
    return text




if __name__ == '__main__':
    with open(os.environ['OUTPUT_PATH'], 'w') as fptr:
        h = int(input().strip())

        m = int(input().strip())

        result = timeInWords(h, m)

        fptr.write(result + '\n')
