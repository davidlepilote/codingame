import sys
import math


road = int(raw_input())  # the length of the road before the gap.
gap = int(raw_input())  # the length of the gap.
platform = int(raw_input())  # the length of the landing platform.
slowDown = False

# game loop
while 1:
    speed = int(raw_input())  # the motorbike's speed.
    coord_x = int(raw_input())  # the position on the road of the motorbike.
    if slowDown :
        print "SLOW"
    elif speed < gap + 1 :
        print "SPEED"
    elif speed > gap + 1 :
        print "SLOW"
    elif coord_x == road - 1:
        print "JUMP"
        slowDown = True
    else :
        print "WAIT"
