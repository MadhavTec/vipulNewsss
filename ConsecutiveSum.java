import java.util.Scanner;

/**
 * Created by vipul pachauri on 26/10/17.
 */
public class ConsecutiveSum {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //read a given Number
        int num = sc.nextInt();

        //Call function consecutive() and pass given num as parameter
        System.out.println(consecutive(num));
    }

    private static int consecutive(int num) {


        /*
        * One important fact is we can not find consecutive
         * numbers above N/2 that adds up to N, because
         * N/2 + (N/2 + 1) would be more than N. So we start from
         * start = 1 till end = N/2 and check for every consecutive
          * sequence whether it adds up to N or not. If it is then
           * we print that sequence and start looking for the next
            * sequence by incrementing start point.
        * */


        /*
        * 1) Take a variable FIRST as starting point of sum,
         * 2) LAST variable as last point upto sum,
          * 3) TEMP variable to track current sum, and
          * 4) COUNT to store no of ways.
        * */
        int first = 1, last = 1, temp = 1, count = 0;

        /*We will loop since FIRST is less than or equal to (NUM/2)
        * because [NUM/2 + (NUM/2 + 1)] > NUM i.e. NUM = 16,
         * 8+9 > 16 */

        while (first <= num/2)
        {

            /*Keep incrementing last variable by one and adding it's value in temp
            * till temp variable is less than given Number
            * When temp value will be equal to given number ,now we have to move
            * our start position by one and decrement temp value as we have moved
            * our start position
            * In the case, when when temp will be greater than given num we have to do same thing except
            * count increment*/
            if (temp < num)
            {
                last += 1;
                temp += last;
            }
            else if (temp > num)
            {
                temp -= first;
                first += 1;
            }
            else if (temp == num)
            {
                count++;
                temp -= first;
                first += 1;
            }
        }
        return count;
    }
}
