import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vipul pachauri on 28/10/17.
 */
public class PsychometricTesting {

    static int noOfCandidates = 0;

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Read no of candidates
        noOfCandidates = sc.nextInt();

        //Create an array of candidate's score
        int[] scores = new int[noOfCandidates];
        for(int i =0;i<noOfCandidates;i++){
            scores[i] = sc.nextInt();
        }

        //Read size lower limits
        int lowerlimit = sc.nextInt();

        //Create an array of lower limits
        int[] llArray = new int[lowerlimit];
        for(int i =0;i<lowerlimit;i++){
            llArray[i] = sc.nextInt();
        }

        //Read size upper limits
        int upperlimit = sc.nextInt();

        //Create an array of upper limits
        int[] ulArray = new int[upperlimit];
        for(int i =0;i<upperlimit;i++){
            ulArray[i] = sc.nextInt();
        }

        //Call jobOffers() function by passing scores Array,llArray and ulArray

        int[] offers = jobOffers(scores,llArray,ulArray);
        System.out.println(Arrays.toString(offers));
    }

    private static int[] jobOffers(int[] scores, int[] lowerlimits, int[] upperlimits) {
        //Take variable to find No of queries
        int noOfQuery = lowerlimits.length;

        //Create an empty output array
        int[] output = new int[noOfQuery];

        //Iterate over no of query
        for(int i =0;i<noOfQuery;i++){
            //Take a temp count
            int count = 0;
            //Iterate over all scores
            for(int j = 0;j<noOfCandidates;j++){
                //Find score which lies between lower limit and upper limit
                if(scores[j] >= lowerlimits[i] && scores[j] <= upperlimits[i]){
                    count++;
                }
            }
            //Insert value of count in array
            output[i] = count;
        }
        return output;
    }
}
