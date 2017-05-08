// Explain what the following code does: ((n & (n-1)) == 0).


// We can work backwards to solve this question.
// What does it mean if A & B == 0?
// pg 58
//  ItmeansthatAandBneverhavea1bitinthesameplace. Soifn&(n-1)==0,thennand n-1  
// never share a 1.
// What does n-1 look like (as compared with n)?
// Try doing subtraction by hand (in base 2 or 10). What happens?
// 1101011000 [base 2] 593100 [base 10] -1-1
// = 1101010111 [base 2] = 593099 [base 10]
// When you subtract 1 from a number, you look at the least signi cant bit. If  
// it’s a 1 you change it to zero and you are done. If it’s a zero, you must  
// “borrow” from a larger bit. So, you go to increasingly larger bits, changing 
// each bit from a 0 to a 1, until you  nd a 1. You  ip that one to a 0 and you are done.
// Thus, n-1 will look like n, except that n’s initial 0s will be 1’s in n-1,  
// and n’s least signi cant 1 will be a 0 in (n-1). That is:
// if n = abcde1000 then n-1 = abcde0111
// So what does n & (n-1) == 0 indicate?
// n and (n-1) must have no 1s in common. Given that they look like this:
// if n = abcde1000 then n-1 = abcde0111
// abcde must be all 0s, which means that n must look like this: 00001000. n is
// therefore   a power of two.
// So, we have our answer: ((n & (n-1)) == 0) checks if n is a power of 2 (or 0).