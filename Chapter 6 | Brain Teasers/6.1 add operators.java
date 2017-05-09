// Add arithmetic operators (plus, minus, times, divide) to make the following
// expres- sion true: 3 1 3 6 = 8. You can use any parentheses you’d like.

    /* (3 + 1) / (3 / 6) = 8 */

// An interviewer is asking this problem to see how you think and approach
// problems—so   don’t just guess randomly.
// Try approaching this the following way: What sorts of operations would get us
// to 8?   I can think of a few:

    /* 4*2=8 16 / 2 = 8 4+4=8 */

// Let’s start with the  rst one. Is there any way to make 3 1 3 6 produce 4 *
// 2? We can easily noticethat3+1=4(the rsttwonumbers).
// Wecanalsonoticethat6/3=2.   Ifwehad“31 6 3”, we’d be done, since (3 + 1)*(6 /
// 3) = 8.   Although it seems a little unconventional to do this, we can, in
// fact,   just  ip the 6 and the 3 to get the solution:

    /* (( 3 + 1 ) / 3) * 6 = 8 *
