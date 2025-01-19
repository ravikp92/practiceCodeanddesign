package src.main.java.com.example.demo.designquestions.splitwise.Expense.Split;


import src.main.java.com.example.demo.designquestions.splitwise.Expense.ExpenseSplitType;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
