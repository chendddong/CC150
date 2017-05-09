/*

A bunch of men are on an island. A genie comes down and gathers everyone to-
gether and places a magical hat on some   people’s heads (i.e., at least one
person has a hat). The hat is magical:   it can be seen by other people, but not
by the wearer of the hat himself.   To remove the hat, those (and only those who
have a hat) must dunk themselves   underwater at exactly midnight. If there are
n people and c hats, how long does   it take the men to remove the hats? The men
cannot tell each other   (in any way) that they have a hat.

FOLLOW UP
Prove that your solution is correct.

 */


/*
    Solution

    This problem seems hard, so let’s simplify it by looking at speci c cases.
    Case c = 1: Exactly one man is wearing a hat.
    Assuming all the men are intelligent, the man with the hat should look
    around and   realize that no one else is wearing a hat. Since the genie said
    that at   least one person is wearing a hat, he must conclude that he is wearing 
    a hat. Therefore, he would be able to remove it that night.
    
    Case c = 2: Exactly two men are wearing hats.
    The two men with hats see one hat, and are unsure whether c = 1 or c = 2. 
    They know, from the previous case, that if c = 1, the hats would be removed on Night #1. 
    Therefore, if the other man still has a hat, he must deduce that c = 2, which means that 
    he has a hat. Both men would then remove the hats on Night #2
    Case General: 

    If c = 3, then each man is unsure whether c = 2 or 3. If it were 2, the hats would be 
    removed on Night #2. If they are not, they must deduce that c = 3, and therefore they 
    have a hat. We can follow this logic for c = 4, 5, ...


                      
    Using induction to prove a statement P(n)
    » Condition 2 sets up an in nite deduction chain: P(1) implies P(2) implies P(3) implies ... P(n) 
    implies P(n+1) implies ...
    If (1)
    AND (2) THEN            
    P(1) = TRUE (e.g., the statement is true when n = 1)
    if P(n) = TRUE -> P(n+1) = TRUE (e.g., P(n+1) is true whenever P(2) is true). P(n) = TRUE for all n >= 1.

    » Condition one (P(1) is true) ignites this chain, with truth cascading o  into in nity.
    Base Case: c = 1 (See previous page).
    Assume true for c hats. i.e., if there are c hats, it will take c nights to remove all of them. Prove true 
    for c+1 hats.
    Each man with a hat sees c hat, and can not be immediately sure whether there are c hats or c+1 hats. However, 
    he knows that if there are c hats, it will take exactly c nights to remove them. Therefore, when c nights have 
    passed and everyone still has a hat, he can only con- clude that there are
    c+1 hats. He must know that he is wearing   a hat. Each man makes the same
    conclusion and simultaneously removes   the hats on night c+1.
    Therefore, we have met the principles of induction. We have proven that it will take c nights to remove c hats.
 */