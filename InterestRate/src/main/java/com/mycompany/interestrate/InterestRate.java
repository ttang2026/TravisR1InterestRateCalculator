/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestrate;
import java.util.Scanner; // importing Scanner class


/**
 *
 * @author TTang2026
 */
public class InterestRate {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Asking user to input a financial amount
        System.out.println("Input a financial amount (ex. $1,000,000): ");
        double amount = scan.nextDouble();
        
        // Created an instance of InterestRateCalculator
        InterestRateCalculator calculator = new InterestRateCalculator();
        
        // Calculate the amount after adding interest
        double totalAmountWithInterest = calculator.calculateTotalWithInterest(amount);
        System.out.printf("Total amount after adding interest: $%.2f%n", totalAmountWithInterest);
        
        // Ask for number of months of repayment
        System.out.print("Enter the number of months for repayment: ");
        int months = scan.nextInt();
        
        // Calcualte and display monthly payments
        double totalPaid = calculator.calculateMonthlyPayment(totalAmountWithInterest, months);
        System.out.printf("Total amount paid over %d months: $%.2f%n", months, totalPaid);
        System.out.printf("Original amount borrowed: $%.2f%n", amount);
    }
}

class InterestRateCalculator {
    public static final double RATE = 0.035;
    
    private double remainingAmount;
    private double monthlyPayment;
    
    // Method to calculate total amount with interest
    public double calculateTotalWithInterest(double amount) {
        remainingAmount = amount + (amount*RATE);
        return remainingAmount;
    }
    
    // Method to calculate monthly payments and display the payments of each month
    public double calculateMonthlyPayment(double totalAmount, int months) {
        double totalPaid = 0.0;
        double remaining = totalAmount;
        
        for (int month = 1; month <= months; month++) {
            monthlyPayment = remaining / (months - month + 1) + (remaining * RATE/12);
            totalPaid += monthlyPayment;
            
            System.out.printf("Month %d Payment = $%.2f%n", month, monthlyPayment);
            remaining -= (monthlyPayment - (remaining * RATE/12));
        }
        return totalPaid;
    }
}