import java.io.*;
import java.util.Scanner;

/**
 * Created by vipul pachauri on 28/10/17.
 */
public class LargeResponses {

    /*Take a variable to store no of responses which have
    more than 5000 bytes in response*/
    static int  count = 0;

    /*Take a variable for benchmark of 5000 bytes to compare each response bytes*/
    static int benchMark = 5000;

    /*Take a temp sum to add bytes having more than benchmark bytes */
    static int sum = 0;

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Read File name
        String inputFileName = sc.next();

        //Get the file from classPath
        File currFile = new File(LargeResponses.class.getClassLoader().getResource(inputFileName+".txt").getFile());

        //Call readFile() function by passing file
        readFile(currFile);

        //Take a variable to create output file location
        String outputFile = System.getProperty("user.dir") + "/" + "bytes_" + inputFileName + ".txt";

        //Call writeFile() function to create file by passing output file location
        writeFile(outputFile);
    }


    private static void readFile(File currFile) {
        // Read file by Buffered Reader line by line
        BufferedReader br = null;
        String strLine = "";
        try {
            br = new BufferedReader(new FileReader(currFile));
            while ((strLine = br.readLine()) != null) {
                //Create an temp array from each line,where each
                //element of array represents space separated values of String
                String[] array = strLine.split(" ");

                //Last element of temp array denotes number Of bytes in response
                String bytes = array[array.length - 1];

                //Check if Last element exists or not
                if (bytes != null && !bytes.trim().equals("")) {
                    try {
                        /*If it exists then compare it with benchmark
                        and increment count by one add bytes having value
                        more than benchmark*/
                        int n = Integer.parseInt(bytes);
                        if (n > benchMark) {
                            count++;
                            sum += n;
                        }
                    } catch (NumberFormatException ex) {
                        continue;
                    }

                }
            }
        } catch (IOException e) {
            System.err.println("Unable to find the file Or Read file");
        }
    }


    private static void writeFile(String outputFile) {
        FileWriter fw =  null;
        try{
            fw=new FileWriter(outputFile);
            fw.write(count+"\n"+sum);
            System.out.println("File created successfully");
        }catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
