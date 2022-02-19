# Purchasing supplies
def maximumContainers(scenarios):
    # Write your code here
    for i in scenarios:
        n,c,m = i.split()
        n = int(n)
        c = int(c)
        m = int(m)
        num = n//c
        count = 0
        while(num>=m):
            count+=1
            num = num - m + 1
    
        print(count+n//c)
