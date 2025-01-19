package src.main.java.com.example.demo.designquestions.splitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {

    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
