import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

n = int(input())

for row in range (1, n+1):
    print("." * (row == 1) + " " * (row - (1 * (row==1)) + (n-row) * 2) + "*" * (row * 2 - 1))
for row in range (1, n+1):
    print(" " * (n-row) + "*" * (row * 2 - 1) + " " * ((n-row) * 2 + 1) + "*" * (row * 2 - 1))