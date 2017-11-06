import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vipul pachauri on 27/10/17.
 */
public class FindTheWinner {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Create Andrea's array
        int n1 = sc.nextInt();
        int[] andreaArray = new int[n1];
        for(int i =0;i<n1;i++){
            andreaArray[i] = sc.nextInt();
        }


        //Create Maria's array
        int n2 = sc.nextInt();
        int[] mariaArray = new int[n2];
        for(int i =0;i<n2;i++){
            mariaArray[i] = sc.nextInt();
        }

        //Read value of "Even" or "Odd"
        String s = sc.next();

        //Call winner function by passing Andrea's,Maria's array and Given S value
        String winnerName =  winner(andreaArray,mariaArray,s);
        System.out.println(winnerName);
    }

    private static String winner(int[] andreaArray, int[] mariaArray, String value) {

        int size = andreaArray.length;

        //Create two separate even and odd List
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();

        //Store even value in even List and odd value in odd list,
        // upto given no of elements in array of either Maria or Andrea
        for (int i = 0;i< size;i++){
            if(i%2==0)evenList.add(i);
            else oddList.add(i);
        }

        // Take two variables to store Andrea and Maria sum
        int andreaSum = 0, mariaSum = 0;

        /*If Given s is even we will go only for values
        at even indexs (i =0,2,4,6 etc)*/

        if ("Even".equals(value)){
            for (Integer i:evenList) {
                andreaSum += andreaArray[i] - mariaArray[i];
                mariaSum += mariaArray[i] - andreaArray[i];
            }
    /*If Given s is odd we will go only for values
     at odd indexs (i =1,3,5,7 etc)*/
        }else {
            for (Integer i:oddList) {
                andreaSum += andreaArray[i] - mariaArray[i];
                mariaSum += mariaArray[i] - andreaArray[i];
            }
        }

        return (andreaSum == mariaSum) ? "Tie" : (andreaSum > mariaSum) ? "Andrea" : "Maria";

    }
}
