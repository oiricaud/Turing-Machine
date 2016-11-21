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
import java.util.Scanner;
public class TuringMachine {

    public static void main(String[] args) {
        // Initialize turing machine.
        String input = "10101011";
        intialize_Settings(input);
    }

    public static void intialize_Settings(String text) {
        // Get the name of the states from the user
        String[] num_of_states = new String[7];
        fill_up_da_states(num_of_states);

        // Get the name of the symbols from the user
        String[] num_of_m_symbols = new String[3];
        fill_up_da_symbols(num_of_m_symbols);


        int[][] state = new int[num_of_states.length][num_of_m_symbols.length];
        readInput(text, num_of_states, num_of_m_symbols);
        int[][] symbol = new int[num_of_states.length][num_of_m_symbols.length];
        int[][] lr = new int[num_of_states.length][num_of_m_symbols.length];
        int[] original_contents_of_tape = new int [100];
    }

    /** This method reads the input from
     * @param text which gets the length of the user input
     * @param num_of_states number of states
     * @param num_of_m_symbols number of symbols
     */
    private static void readInput(String text, String[] num_of_states, String[] num_of_m_symbols) {
        String reader ="";
        int pointer = 0;
        String head = num_of_states[0];
        String [] input = new String[text.length() + 2];

        // Change input here
        input[0] = "_";
        input[1] = "1";
        input[2] = "0";
        input[3] = "1";
        input[4] = "0";
        input[5] = "1";
        input[6] = "0";
        input[7] = "1";
        input[8] = "1";
        input[9] = "_";

        System.out.println("Input: 10101011 \n Rules:");
        // Rules
        for(int i = 0 ; i < num_of_states.length; i++){
            for(int j = 0 ; j < num_of_m_symbols.length; j++){

                //Rule 1 = start, _ --> inNumber, R
                if((head.equals("start") && (input[pointer].equals("_")))){
                    reader = reader + num_of_states[0] + ", " + num_of_m_symbols[j] + " -> " + num_of_states[1] + "," +
                            " R";
                    System.out.println("Rule 1) " + num_of_states[0] + ", " + input[j] + " -> " +
                            num_of_states[1] + "," + " R");
                    pointer++;
                    head = num_of_states[1];
                }
                //Rule 2 = inNumber, 1 --> state1, R
                if((head.equals("inNumber") && (input[pointer].equals("1")))){
                    System.out.println("Rule 2) " +num_of_states[1] + ", " + input[j] + " -> " + num_of_states[2] +
                            "," + " R");
                    head = num_of_states[2];
                    pointer++;
                }
                //Rule 3 = inNumber, _ --> reject
                if((head.equals("inNumber") && (input[pointer].equals("_")))){
                    System.out.println("Rule 3) " + num_of_states[5]);
                    head = num_of_states[5];
                    pointer++;
                }
                //Rule 4 = inNumber, 0 --> state0, R
                if((head.equals("inNumber") && (input[pointer].equals("0")))){
                    System.out.println("Rule 4) " +  num_of_states[1] + ", " + input[j] + " -> " + num_of_states[3] +
                            "," + " R");
                    head = num_of_states[2];
                    pointer++;
                }
                //Rule 5 = state0, 1 --> state1, R
                if((head.equals("state0") && (input[pointer].equals("1")))){
                    System.out.println("Rule 5) " +  num_of_states[3] + ", " + input[j] + " -> " + num_of_states[2] +
                            "," + " R");
                    head = num_of_states[2];
                    pointer++;
                }
                //Rule 6 = state0, 0 --> state0, R
                if((head.equals("state0") && (input[pointer].equals("0")))){
                    System.out.println("Rule 6) " +  num_of_states[3] + ", " + input[j] + " -> " + num_of_states[3] +
                            "," + " R");
                    head = num_of_states[3];
                    pointer++;
                }
                //Rule 7 = state1, 1 --> state1, R
                if((head.equals("state1") && (input[pointer].equals("1")))){
                    System.out.println("Rule 7) " +  num_of_states[2] + ", " + input[j] + " -> " + num_of_states[2] +
                            "," + " R");
                    head = num_of_states[2];
                    pointer++;
                }
                //Rule 8 = state1, 0 --> state0, R
                if((head.equals("state1") && (input[pointer].equals("0")))){
                    System.out.println("Rule 8) " +  num_of_states[2] + ", " + input[j] + " -> " + num_of_states[3] +
                            "," + " R");
                    head = num_of_states[3];
                    pointer++;
                }
                //Rule 9 = state1, _ --> reject
                if((head.equals("state1") && (input[pointer].equals("_")))){
                    System.out.println("Rule 9) " +  num_of_states[2] + ", " + input[j] + " -> " + num_of_states[5]);
                    head = num_of_states[5];
                    pointer++;
                }
                //Rule 10 = state0, _ --> accept
                if((head.equals("state0") && (input[pointer].equals("_")))){
                    System.out.println("Rule 10) " +  num_of_states[3] + ", " + input[j] + " -> " + num_of_states[4]);
                    head = num_of_states[4];
                    pointer++;
                }
            }
        }
    }

    /**
     * @param num_of_m_symbols is the number of M symbols.
     *  In this method the user will fill up the name of the symbols.
     */
    private static String[] fill_up_da_symbols(String[] num_of_m_symbols) {
        num_of_m_symbols[0] = "_";
        num_of_m_symbols[1] = "0";
        num_of_m_symbols[2] = "1";
        return num_of_m_symbols;
    }
    /**
     * @param num_of_states is the number of states the state machine has
     *  In this method the user will fill up the name of the states.
     */
    private static String[] fill_up_da_states(String[] num_of_states) {
        Scanner input = new Scanner(System.in);
        num_of_states[0] = ("start");
        num_of_states[1] = ("inNumber");
        num_of_states[2] = ("state1");
        num_of_states[3] = ("state0");
        num_of_states[4] = ("accept");
        num_of_states[5] = ("reject");
        return num_of_states;
    }
}
