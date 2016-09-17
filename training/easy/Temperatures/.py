import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(raw_input())  # the number of temperatures to analyse
tempsRaw = raw_input()  # the n temperatures expressed as integers ranging from -273 to 5526
temps = tempsRaw.split()
result = sys.maxsize
for i in range(0, n):
    temp = int(temps[i])
    if math.fabs(temp) < math.fabs(result):
        result = temp
    elif math.fabs(temp) == math.fabs(result) and temp >= 0 :
        result = temp
print result if result != sys.maxsize else 0