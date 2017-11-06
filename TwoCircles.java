import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by vipul pachauri on 28/10/17.
 */
public class TwoCircles {

    private static final BufferedReader input = new BufferedReader (new InputStreamReader(System.in));

    //Take variable to store no of test cases
    private  static  int n;
    public static void main(String[] args) {

        try {
            //Read no of test cases
            n = Integer.parseInt(input.readLine());

            //Create an info array to store  strings
            String[] info = new String[n];
            for(int i =0;i<n;i++){
                info[i] = input.readLine();
            }

            //Call circles() function by passing info array
            String[] output  = circles(info);

            //Print output values
            for(String  str : output){
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] circles(String[] array) {
        //Create an empty output array
        String[] output = new String[n];
        for(int i =0;i<array.length;i++){
            //Split String to get six values contained in String
            int[] tempArray = Arrays.stream(array[i].split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = tempArray[0];
            int y1 = tempArray[1];
            int r1 = tempArray[2];
            int x2 = tempArray[3];
            int y2 = tempArray[4];
            int r2 = tempArray[5];

            /*Calculate distance between two centers by
            * d = square root of (square of point1 + square of point2)
             * as we know either circle will lie on x axis or on y axis
             * we will not consider third axis Z value*/

            double d = Math.pow((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5);

            /*Two circle will touch each other if radius of on circle is equal or less
            than other circle and distance is equal or less than the difference
             of their radius*/
            if (r2 >= r1 && d <= (r2 - r1)) {
                output[i] = "Touching";
            }

            /*Circle having radius r2 will lie in circle having
             radius r2 without touching if r1 >= r2 and distance is
              equal or less than the difference
             of r1-r2 */
            else if (r1 >= r2 && d <= (r1 - r2) ) {
                output[i] = "Disjoint-Inside";
            }
            /*If distance of two circles point is greater than sum of their
            radius, circle will definitely will be in Disjoint outside condition*/
            else if (d > (r1 + r2)){
                output[i] = "Disjoint-outside.";
            }
            else{
                output[i] = "Intersecting";
            }

        }
       return output;
    }
}
