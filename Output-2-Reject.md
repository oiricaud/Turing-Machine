Input: 10101011 
 Rules:
Rule 1) start, _ -> inNumber, R
Rule 2) inNumber, _ -> state1, R
Rule 8) state1, _ -> state0, R
Rule 5) state0, 1 -> state1, R
Rule 8) state1, 1 -> state0, R
Rule 5) state0, 0 -> state1, R
Rule 8) state1, 0 -> state0, R
Rule 5) state0, _ -> state1, R
Rule 7) state1, _ -> state1, R
Rule 9) state1, _ -> reject

Process finished with exit code 0