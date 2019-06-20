# Mars Rovers

A squad of robotic rovers are to be landed by NASA on a plateau on
Mars. This plateau, which is curiously rectangular, must be navigated
by the rovers so that their on-board cameras can get a complete
view of the surrounding terrain to send back to Earth.
A rover’s position and location is represented by a combination of x
and y co- ordinates and a letter representing one of the four cardinal
compass points. The plateau is divided up into a grid to simplify
navigation. An example position might be 0, 0, N, which means the
rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The
possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin
90 degrees left or right respectively, without moving from its current
spot. ‘M’ means move forward one grid point, and maintain the same
Heading.

Assume that the square directly North from (x, y) is (x, y+1).

## Input / output format
The first line of input is the upper-right coordinates of the plateau, the
lower- left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have
been deployed. Each rover has two lines of input. The first line gives
the rover’s position, and the second line is a series of instructions
telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by
spaces, corresponding to the x and y co-ordinates and the rover’s
orientation.
Each rover will be finished sequentially, which means that the
second rover won’t start to move until the first one has finished
Moving.

The output for each rover should be its final co-ordinates and
heading.

### Test Input
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

### Expected Output
```
1 3 N
5 1 E
```

## Your task

Please write a program which interprets input files with the mentioned input format and produces the mentioned output.
Feel free to structure the program and code any way you want. You will be asked about the reasoning behind your solution.

Bonus points: make it work with multiple rovers in parallel (multi threaded).

## Remarks

- We do not expect that you find a sophisticated, optimal solution. A lightweight, simple algorithm is perfectly fine. However, we expect that you will be able to justify why the algorithm makes sense with respect to the given data.
- You are responsible for managing your time (e.g. if you want to invest 1 hour that's fine or if you want to invest 4 hours that's also fine)
- In a next video call, we would like to discuss your solution. Please send us your code before the call, to give us some time to go over it beforehand.
