package src.main.java.com.example.demo.designquestions.splitwise.Expense.Split;


import src.main.java.com.example.demo.designquestions.splitwise.BalanceSheetController;
import src.main.java.com.example.demo.designquestions.splitwise.Expense.Expense;
import src.main.java.com.example.demo.designquestions.splitwise.Expense.ExpenseSplitType;
import src.main.java.com.example.demo.designquestions.splitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

          ExpenseSplit expenseSplit=SplitFactory.getSplitObject(splitType);
          expenseSplit.validateSplitRequest(splitDetails,expenseAmount);
          Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);
          balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount);
          return expense;

    }
}
