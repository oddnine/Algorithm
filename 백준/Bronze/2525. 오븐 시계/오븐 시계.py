hour, min=map(int, input().split())
cook=int(input())

if (0<=hour and hour<=23) and (0<=min and min<=59) and (0<=cook and cook<=1000):
    min=min+cook
    if min>59:
        emp=min/60
        hour=hour+int(emp)
        min=min-(int(emp)*60)
    if hour>23:
        hour=hour-24

    print(hour, min)