import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vipul pachauri on 26/10/17.
 */
public class BalancedOrNot {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        // size of expression
        int noOfExpression = sc.nextInt();

        //creating an array of expression to check
        String[] expArray = new String[noOfExpression];
        for(int i = 0; i<noOfExpression;i++) {
            expArray[i] = sc.next();
        }

        //size of max replacement
        int noOfReplacement = sc.nextInt();

        //creating an array of max Replacements
        int[] repArray = new int[noOfReplacement];
        for(int i = 0; i<noOfReplacement;i++){
            repArray[i] = sc.nextInt();
        }

        //Calling balancedOrNot function
        int[] result = balancedOrNot(expArray,repArray);
        System.out.println(Arrays.toString(result));
    }

    private static int[] balancedOrNot(String[] expressionArray, int[] repArray) {

        //Create an array to store value 1 or 0
        int[] output = new int[expressionArray.length];

        //Iterate through expression array for each expression

        for(int i = 0;i<expressionArray.length;i++){

            //Split expression string and create an array to store "<" and ">"
            String[] symbolArray = expressionArray[i].split("");

            // Take a count to find no of balanced pair i.e. "<>"
            int count = 0;

            //Iterate through array of symbols (<,>)
            for (int k = 1;k<symbolArray.length;k++){

                //To compare symbols (<,>) store current and next symbol
                String current = symbolArray[k-1];
                String next = symbolArray[k];

                //if current matches with "<" and next matches with ">",so it is balanced
                //and increment value of symbol count by 2 because
                if(current != null && next != null && current.equals("<") && next.equals(">")) {
                    count +=2;
                }
            }
            //Now, we have total no of symbols and no of symbols which are in balanced pair
            //i.e total no of symbols = 6 in {<,>,>,<,<,>} array denoted by "symbolArray.length"
            // and no of symbols which are in balanced pair = 4 {<,>,<,>} so count = 4

            // Now take a temp value = total no of symbols - no of symbols which are in balanced pair
            //It denotes no of symbols which need to be balanced
            //i.e. temp = 6-4 = 2
            int temp = symbolArray.length - count;

            //If temp = 0 , means All symbols are in balanced pair
            if(temp == 0){
                output[i] = 1;
                //if temp is less than provided maxReplacement i.e
                // temp = 2, noOfMaxReplacement = 3 ,so unbalanced symbols can be balanced
            }else if(temp <= repArray[i]){
                output[i] = 1;
                //if temp is greater than provided maxReplacement i.e
                // temp = 2, noOfMaxReplacement = 1 ,so unbalanced symbols can't be balanced
            }else{
                output[i] = 0;
            }

            // By ternary operator
            //output[i] = (temp == 0) ? 1 : (temp <= repArray[i]) ? 1 : 0;
        }
        return output;
    }
}
