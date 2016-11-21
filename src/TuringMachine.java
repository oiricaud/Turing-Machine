import java.util.Scanner;

/**
 Homework: I lost count.
 @author : Oscar Ivan Ricaud.
 @version 1.0
 Instructor: Vladik Kreinovich,
 TA: Angel Garcia Contreras
 TA: Sheikh Motahar Naim
 CS 3350: Automata, Computability, and Formal Languages
 Data of Last modification Nov. 21, 2016
 Program purpose:

 (Due November 22, for extra credit by November 15) Write a method that emulates a Turing machine. The input to this
 method should include:

 the number N of states q0, ..., qN − 1;

 we assume that q0 is the start state, that the last-but-one state qN − 2 is the accept state, and the last state qN − 1
 is the reject state;

 the number M of symbols s0, ... sM − 1; we assume that s0 is the blank state _;

 an integer array state[n][m] that describes to what state the Turing machine moves if it was in the state qn and
 sees the symbol sm;

 an integer array symbol[n][m] that describes what symbol should be written on the tape if the Turing Machine in the
 state qn sees the symbol sm;

 a character array lr[n][m] that describes, for each state qn and for each symbol sm, whether the Turing machine moves
 to the left (L), or to the right (R), or stays in place (blank symbol);

 the integer array of a large size describing the original contents of the tape, i.e., what symbols are written in each cell.

 This program needs to keep track of a current location of the head. Initially, this location is 0.
 Your program should emulate the work of the Turing machine step-by-step. Return the printout of the method, the printout
 of the program that you used to test this method, and the printout of the result of this testing.
 */

public class TuringMachine {

    public static void main(String[] args) {
        // Initialize turing machine.
        String input = "1010";
        intialize_Settings(input.length());
    }

    public static void intialize_Settings(int i) {
        // Get the name of the states from the user
        int[] num_of_states = new int[7];
        fill_up_da_states(num_of_states);

        // Get the name of the symbols from the user
        int[] num_of_m_symbols = new int[3];
        fill_up_da_symbols(num_of_m_symbols);

        int[][] what_to_do = new int[num_of_states.length][num_of_m_symbols.length];
        int[][] what_shall_we_write = new int[num_of_states.length][num_of_m_symbols.length];
        int[][] where_to_move = new int[num_of_states.length][num_of_m_symbols.length];
        int[] original_contents_of_tape = new int [100];
        int reader = 0;
    }

    /**
     * @param num_of_m_symbols is the number of M symbols.
     *  In this method the user will fill up the name of the symbols.
     */
    private static void fill_up_da_symbols(int[] num_of_m_symbols) {
    }

    /**
     * @param num_of_states is the number of states the state machine has
     *  In this method the user will fill up the name of the states.
     */
    private static void fill_up_da_states(int[] num_of_states) {
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < num_of_states.length; i++){
            System.out.println("for q" + i + ":" + input.next());
        }
    }
}
