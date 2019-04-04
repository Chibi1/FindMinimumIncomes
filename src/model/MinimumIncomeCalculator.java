package model;

import java.util.Scanner;

public class MinimumIncomeCalculator {

    private int numberOfFamilies;
    private int[] familyIncomes;
    private int minimumIncome;
    private int incomeThreshold;
    private int[] highEarners;

    private Scanner scanner = new Scanner(System.in);

    public void runProgram() {
        System.out.print("Enter the number of families to analyse: ");
        numberOfFamilies = scanner.nextInt();
        getFamilyIncomes();
        getMinimumIncome();
        generate20PercentThreshold();
        printHighEarners();
    }

    private void getFamilyIncomes() {
        familyIncomes = new int[numberOfFamilies];
        for (int i = 0; i < familyIncomes.length; i++) {
            System.out.printf("%s %d%s", "Enter the income for family", i+1, ": $");
            familyIncomes[i] = scanner.nextInt();
        }
    }

    private void getMinimumIncome() {
        minimumIncome = familyIncomes[0];
        for (int i = 0; i < familyIncomes.length; i++) {
            if (familyIncomes[i] < minimumIncome) {
                minimumIncome = familyIncomes[i];
            }
        }
    }

    private void generate20PercentThreshold() {
        incomeThreshold = (int)(minimumIncome*1.2);
    }

    private void printHighEarners() {
        System.out.printf("%s%.2f %s\n\n", "The following families made 20% more than the minimum income "
            + "(i.e. over $", minimumIncome, ")");
    }
}
