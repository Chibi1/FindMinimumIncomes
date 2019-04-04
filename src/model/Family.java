package model;

public class Family {

    private int familyNumber;
    private int familyIncome;

    public Family(int number, int income) {
        this.familyNumber = number;
        this.familyIncome = income;
    }

    public int getFamilyNumber() { return this.familyNumber; }
    public int getFamilyIncome() { return this.familyIncome; }

}
