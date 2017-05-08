# Bit Wise Operators

    public class Test {

       public static void main(String args[]) {
          int a = 60;   /* 60 = 0011 1100 */
          int b = 13;   /* 13 = 0000 1101 */
          int c = 0;

          /* and */
          c = a & b;        /* 12 = 0000 1100 */
          System.out.println("a & b = " + c );

          /* or */
          c = a | b;        /* 61 = 0011 1101 */
          System.out.println("a | b = " + c );

          /* Xor is 1 only when they are different*/
          c = a ^ b;        /* 49 = 0011 0001 */
          System.out.println("a ^ b = " + c );

          /* not */
          c = ~a;           /*-61 = 1100 0011 */
          System.out.println("~a = " + c );

          x << y means x shifted y bits to the left. If you start shifting and you run out of space, the bits just drop off.
          /* left shift means multiply 2 * 2 */
          c = a << 2;       /* 240 = 1111 0000 */
          System.out.println("a << 2 = " + c );


          x >> y means x shifted y bits to the right. If you start shifting and you run out of space, the bits just drop off.
          /* right shift divide by 2 * 2 */
          c = a >> 2;       /* 15 = 1111 */
          System.out.println("a >> 2  = " + c );

          /* lgoical shit right preserve the sign value */
          c = a >>> 2;      /* 15 = 0000 1111 */
          System.out.println("a >>> 2 = " + c );
       }
    }