/*
    There is a building of 100  oors. If an egg drops from the Nth  oor or above
    it will break. If it’s dropped from   any  oor below, it will not break.
    You’re   given 2 eggs. Find N, while minimizing the number of drops for the 
    worst case.

 */


/*
    Observation: Regardless of how we drop Egg1, Egg2 must do a linear search. i.e., if Egg1 breaks between  oor 10 and 15, 
    we have to check every  oor in between with the Egg2

    How to do the load balancing!!!

    The Approach:
    A First Try: Suppose we drop an egg from the 10th  oor, then the 20th, ...
    » If the  rst egg breaks on the  rst drop (Floor 10), then we have at most 10 drops total.
    » If the  rst egg breaks on the last drop (Floor 100), then we have at most 19 drops total ( oors 10, 20, ...,90, 100, then 91 through 99).
    » That’s pretty good, but all we’ve considered is the absolute worst case. We should do some “load balancing” to make those two cases more even.

    Goal: Create a system for dropping Egg1 so that the most drops required is consistent, whether Egg1 breaks on the  rst drop or the last drop.
    1. A perfectly load balanced system would be one in which Drops of Egg1 + Drops of Egg2 is always the same, regardless of where Egg1 broke.
    2. For that to be the case, since each drop of Egg1 takes one more step, Egg2 is allowed one fewer step.
    3. We must, therefore, reduce the number of steps potentially required by Egg2 by one drop each time. For example, if Egg1 is dropped on Floor 20 and then Floor 30, 
    Egg2 is potentially required to take 9 steps. When we drop Egg1 again, we must reduce potential Egg2 steps to only 8. That is, we must drop Egg1 at  oor 39.
    4. We know, therefore, Egg1 must start at Floor X, then go up by X-1  oors, then X-2, ..., until it gets to 100.
    5. Solve for X+(X-1)+(X-2)+...+1 = 100. X(X+1)/2 = 100 -> X = 14
    We go to Floor 14, then 27, then 39, ... This takes 14 steps maximum.

 */