package MainPackage;

import java.util.Scanner;
import java.lang.Long;

public class CreditCard {
	
	public static void main(String[] args)
	{
		System.out.println("Please enter your 16 digit credit card number: ");
		Scanner input = new Scanner(System.in);
		long cardNumber = input.nextLong();
		input.close();
		
		//
//		System.out.println(cardNumber);
//		double[] cardDigits = new double[16];
//		long num = cardNumber;
//		for(int i=15; i>=0; i--) {
//			cardDigits[i] = num % 10;
//			num = num/10;
//		}
//		for (int i=0; i<cardDigits.length; i++) {
//			System.out.println(cardDigits[i]);
//		}
		//
		
		if(isValid(cardNumber) == true) {
			System.out.println("\nCard " + cardNumber + " is valid.");
		}
		else {
			System.out.println("\nCard " + cardNumber + " is invalid.");
		}
	}
	
	public static Boolean isValid(long number)
	{
		int total = sumOfEvenPlace(number) + sumOfOddPlace(number);
		
        if (total % 10 == 0) {
            return true;
        } else {
            return false;
        }
	}
	
    public static int sumOfEvenPlace(long number)
    {
        int sum = 0;
        long temp = 0;

        while (number > 0) {
            temp = number % 100;
            sum += getDigit((int) (temp / 10) * 2);
            number = number / 100;
        }
        return sum;
    }
    
    public static int sumOfOddPlace(long number)
	{
        int sum = 0;

        while (number > 0) {
            sum += (int) (number % 10);
            number = number / 100;
        }
        return sum;
    }

    public static int getDigit(int number)
    {
    	if (number < 10) {
    		return number;
    	}
    	else {
    		return (number / 10) + (number % 10);
    	}
    }
}
