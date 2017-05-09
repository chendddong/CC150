/*

There is an 8x8 chess board in which two diagonally opposite corners have
been cut o . You are given 31 dominos, and a single domino can cover exactly two
squares. Can you use the 31 dominos to cover the entire board? Prove your answer
(by provid- ing an example, or showing why it’s impossible).
 
 */

/*
    Solution:

    Impossible. Here’s why: The chess board initially has 32 black and 32 white squares. By re- moving opposite corners (which must be the same color), we’re left with 30 of one color and 32 of the other color. Let’s say, for the sake of argument, that we have 30 black and 32 white squares.
    When we lay down each domino, we’re taking up one white and one black square. Therefore, 31 dominos will take up 31 white squares and 31 black squares exactly. On this board, how- ever, we must have 30 black squares and 32 white squares. Hence, it is impossible.
 */
