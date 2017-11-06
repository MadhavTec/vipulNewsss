import java.util.Scanner;

/**
 * Created by vipul pachauri on 28/10/17.
 */
public class InTheFuture {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Reading problems per day solved by Asha
        int A = sc.nextInt();

        //Reading problems per day solved by Kelly
        int K = sc.nextInt();

        //Reading difference between Asha's and Kelly's problem
        int P = sc.nextInt();

        //Call minNum() function with param A,K,P
        System.out.println(minNum(A,K,P));
    }

    private static int minNum(int A, int K, int P) {

        /*If Asha can solve more or equal no of problems per day
         than Kelly ,so it is not possible for Kelly to go ahead*/
        if(A >= K) return -1;

        //Take variable d to represent no of days
        int d = 1;

        //Take a temp variable A to store total problems solved by Asha initially
        int tempA = A+P;

        //Take a temp variable K to store total problems solved by Kelly initially
        int tempK = K;

        /*If total problems solved by Asha is less than kelly,then
        kelly will go ahead with in a day*/
        if(tempA < K){
            return d;
        }else{
            /*If total problems solved by Asha is greater than or equal to kelly,
            then  increment problems solved by Asha by A (problem can be solved by asha in a day)
            and increment problems solved by increment problems solved by Asha by K (problem can be solved by asha in a day)
             by K (problem can be solved by kelly in a day),
              and increment day by one until kelly go ahead to asha*/
            while (tempA >= tempK){
                tempA += A;
                tempK += K;
                d++;
            }
            return d;
        }
    }
}
