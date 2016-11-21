# Turing-Machine
Write a method that emulates a Turing machine.
The input to this method should include:

the number N of states q0, ..., qN − 1; we assume that q0 is the start state, that the last-but-one state qN − 2 is the accept state, and the last state qN − 1 is the reject state;

the number M of symbols s0, ... sM − 1; we assume that s0 is the blank state _;

an integer array state[n][m] that describes to what state the Turing machine moves if it was in the state qn and sees the symbol sm;

an integer array symbol[n][m] that describes what symbol should be written on the tape if the Turing Machine in the state qn sees the symbol sm;

a character array lr[n][m] that describes, for each state qn and for each symbol sm, whether the Turing machine moves to the left (L), or to the right (R), or stays in place (blank symbol);

the integer array of a large size describing the original contents of the tape, i.e., what symbols are written in each cell.
This program needs to keep track of a current location of the head. Initially, this location is 0.

Your program should emulate the work of the Turing machine step-by-step. Return the printout of the method, the printout of the program that you used to test this method, and the printout of the result of this testing.

Example: A Turing machine for checking whether a binary string is even (i.e., ends with 0) has the following rules:

start, _ --> inNumber, R

inNumber, 1 --> state1, R

inNumber, _ --> reject

inNumber, 0 --> state0, R

state0, 1 --> state1, R

state0, 0 --> state0, R

state1, 1 --> state1, R

state1, 0 --> state0, R

state1, _ --> reject

state0, _ --> accept

In this case:

we have N = 7 states:
  q0 = start, 
  q1 = inNumber, 
  q2 = state1,
  q4 = state0, 
  q5 = accept, and q6 = reject;
  
we have M = 3 symbols: s0 = _, s1 = 0, and s2 = 1;

Here:
The first rule start, _ --> inNumber,
  R means that state[0][0] = 1,
  symbol[0][0] = 0, and lr[0][0] = R.

The second rule inNumber, 1 --> state1, R means that state[1][2] = 2, symbol[1][2] = 2, and lr[1][2] = R, etc.
