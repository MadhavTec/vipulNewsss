import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by vipul pachauri on 26/10/17.
 */
public class BuyingShowTickets {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Find total no of buyers
        int noOfBuyers = sc.nextInt();

        //Create an array to store each buyer's tickets
        int[] tickets = new int[noOfBuyers];

        //Store value of each tickets
        for(int i =0;i<noOfBuyers;i++) {
            tickets[i] = sc.nextInt();
        }

        //Find Jesse position
        int position = sc.nextInt();

        //Call waiting function and pass tickets array and Jesse position
        int t = waitingTime(tickets,position);
        System.out.println(t);
    }


    private static int waitingTime(int[] tickets, int position) {

        //Create an empty Linked List to store modifiable values
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Put initial values in Linked list
        for (int i = 0;i<tickets.length;i++){
            list.add(tickets[i]);
        }

        //Find no of tickets Jesse has to buy
        int element = list.get(position);

        //Take a variable to track current position of Jesse
        int current_pointer = position;

        //Take a variable to track if a person is on first position or not
        int first_pointer = 0;

        //Take a variable to track last or max position
        int last_pointer = list.size()-1;

        //Take a variable to count time
        int time = 0;

        /*Current Pointer and Last pointer will change according to
        * buyers ticket value changes*/

        //Jesse will buy tickets until his ticket value will become zero
        //Use a while loop to track Jesse current ticket values
        while (element != 0){
            //Take a variable X to store ticket value at first position
            int x = list.get(0);

            //Now remove node from first positon
            list.remove(0);

            //Take a variable N to get remaining tickets of current buyer
            int n = x-1;

            //If Remaining tickets is not equal to zero , Add value N at last Node
            if(n != 0) list.add(n);

            /*
            * Now, we have to take care about Jesse position,for which
            * we will check following conditions
            * */

           /* To check if tickets are left to buy for the buyer at
            first position , we will use condition N !=0  and ,
            To check if Current buyer is jesse or not, we will compare
            Current pointer (Jesse position) with First pointer
            (Position of Buyer standing at first position), If Current buyer is not Jesse
            we will only decrement by one in current position of Jesse As Current
            buyer will go to the Last position after purchasing ticket*/

           if(n != 0 && current_pointer > first_pointer) {
                current_pointer--;

            /*If Current buyer has purchased his all tickets and He is not Jessy
            * so to move Jesse position decrement current pointer by one, and Now current buyer
            * will quit the row so Last pointer will also be decremented by one as Last
            * Pointer denotes How many buyers are left we can say :
            * NoOfBuyers = Last_Pointer + 1*/

            }else if (n == 0 && current_pointer > first_pointer) {
                current_pointer --;
                last_pointer--;

            /*If current buyers is Jesse Decrement element value (Jesse ticket)
             * and now Jesse will move to last position, so Last poniter will denote his current position */

            }else{
                element--;
                current_pointer = last_pointer;
            }
            //Increment count by one
            time++;
        }
        return time;
    }

    /*The case in which Jesse will stand on first position an it will be his last ticket
    * in this case condition would be (n ==0 and current_pointer == last pointer), Loop will
    * not be executed **/
}
