/*
    You have a  ve quart jug and a three quart jug, and an unlimited supply of
    water (but no measuring cups).   How would you come up with exactly four  
    quarts of water? NOTE: The jugs are oddly shaped, such that  lling up
    exactly ‘half’ of the jug would be impossible.
 */

Action 1  pour  5(full)   pour into     3(empty)
State  1        5(load 2)               3(load 3)
Action 2  empty 5(load 2)               3(empty)
Action 3  pour  5(load 2) pour into     3(empty)
State  2        5(empty)                3(load 2)
Action 4  load  5(full)                 3(load 2)
Action 5  pour  5(full)   pour into     3(load 2)
State  3        5(load 4)               3(load 3)  

/*
Many brain teasers have a math / CS root to them—this is one of them! Note that
as long as the two jug   sizes are relatively prime (i.e., have no common prime
factors), you can find a pour sequence for any value between 1 and the sum of
the jug sizes.
 */   
