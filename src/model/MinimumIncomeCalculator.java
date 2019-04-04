package model;

import java.util.Scanner;

public class MinimumIncomeCalculator {

    private int numberOfFamilies;
    private Family[] families;
    private int minimumIncome;
    private int incomeThreshold;
    private int numberHighEarners;
    private Family[] highEarners;

    private Scanner scanner = new Scanner(System.in);

    public void runProgram() {
        System.out.print("Enter the number of families to analyse: ");
        numberOfFamilies = scanner.nextInt();
        getFamilyIncomes();
        getMinimumIncome();
        generate20PercentThreshold();
        getHighEarners();
        printHighEarners();
    }

    private void getFamilyIncomes() {
        families = new Family[numberOfFamilies];
        for (int i = 0; i < families.length; i++) {
            System.out.printf("%s %d%s", "Enter the income for family", i+1, ": $");
            families[i] = new Family(i+1, scanner.nextInt());
        }
    }

    private void getMinimumIncome() {
        minimumIncome = families[0].getFamilyIncome();
        for (int i = 0; i < families.length; i++) {
            if (families[i].getFamilyIncome() < minimumIncome) {
                minimumIncome = families[i].getFamilyIncome();
            }
        }
    }

    private void generate20PercentThreshold() {
        incomeThreshold = (int)(minimumIncome*1.2);
    }

    private void getHighEarners() {
        for (int i = 0; i < families.length; i++) {
            if (families[i].getFamilyIncome() > incomeThreshold) {
                numberHighEarners++;
            }
        }
        highEarners = new Family[numberHighEarners];
        int highEarnerIndex = 0;
        for (int i = 0; i < families.length; i++) {
            if (families[i].getFamilyIncome() > incomeThreshold) {
                highEarners[highEarnerIndex] = families[i];
                highEarnerIndex++;
            }
        }
    }

    private void printHighEarners() {
        System.out.printf("\n%s%d%s\n\n", "The following families made 20% more than the minimum income "
            + "(i.e. over $", incomeThreshold, ")");
        for (int i = 0; i < highEarners.length; i++) {
            System.out.printf("%10s %d %s%d\n", "Family", highEarners[i].getFamilyNumber(), "made $", highEarners[i].getFamilyIncome());
        }
    }
}
