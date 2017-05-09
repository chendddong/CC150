# Do companies really ask brain teasers?
While many companies, including Google and Microsoft, have policies banning
brain teas- ers, interviewers still sometimes ask these tricky questions. This is especially true since peo- ple have di erent de nitions of brain teasers.

# Advice on Approaching Brain Teasers
Don’t panic when you get a brain teaser. Interviewers want to see how you tackle a problem; they don’t expect you to immediately know the answer. Start talking, and show the inter- viewer how you approach a problem.

In many cases, you will also  nd that the brain teasers have some connection back to funda- mental laws or theories of computer science.

If you’re stuck, we recommend simplifying the problem. Solve it for a small number of items or a special case, and then see if you can generalize it.

# Example
You are trying to cook an egg for exactly  fteen minutes, but instead of a
timer, you are given two ropes which burn for exactly 1 hour each. The ropes, however, are of uneven densities - i.e., half the rope length-wise might take only two minutes to burn.

# The Approach
1. What is important? Numbers usually have a meaning behind them. The  fteen minutes and two ropes were picked for a reason.

2. Simplify! You can easily time one hour (burn just one rope).

3. Now, can you time 30 minutes? That’s half the time it takes to burn one rope. Can you burn the rope twice as fast? Yes! (Light the rope at both ends.)

4. You’ve now learned: (1) You can time 30 minutes. (2) You can burn a rope that takes X minutes in just X/2 minutes by lighting both ends.

5. Work backwards: if you had a rope of burn-length 30 minutes, that would let you time 15 minutes. Can you remove 30 minutes of burn-time from a rope?

6. You can remove 30 minutes of burn-time from Rope #2 by lighting Rope #1 at both ends and Rope #2 at one end.

7. Now that you have Rope #2 at burn-length 30 minutes, start cooking the egg and light Rope #2 at the other end. When Rope #2 burns up, your egg is done!