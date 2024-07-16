package ccvalidator.src;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);    //  Create new scanner object
        System.out.print("CC Number: ");   //  Print out the prompt
        String creditNumber = input.nextLine();    //  Take input
        input.close();

        int len = creditNumber.length();   //  Get the input length
        int doubleEvenSum = 0;

        // LUHNS ALGORITHM

        // Step 1 is to double every second digit, starting from the right. If it
        // results in a two digit number, add both the digits to obtain a single
        // digit number. Finally, sum all the answers to obtain 'doubleEvenSum'.   

        for (int i = len - 2; i >= 0; i = i - 2) {
            int dbl = ((creditNumber.charAt(i) - 48) * 2);
            if (dbl > 9) {
                dbl = (dbl / 10) + (dbl % 10);
            }
            doubleEvenSum += dbl;
        }

        // Step 2 is to add every odd placed digit from the right to the value
        // 'doubleEvenSum'.
            
        for (int i = len - 1; i >= 0; i = i - 2) {
            doubleEvenSum += (creditNumber.charAt(i) - 48);
        }
        System.out.println(doubleEvenSum % 10 == 0 ? "Valid" : "Invalid");
    }
}
