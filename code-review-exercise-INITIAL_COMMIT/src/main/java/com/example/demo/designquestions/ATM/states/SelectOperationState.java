package src.main.java.com.example.demo.designquestions.ATM.states;

import src.main.java.com.example.demo.designquestions.ATM.ATM;
import src.main.java.com.example.demo.designquestions.ATM.ATMState;
import src.main.java.com.example.demo.designquestions.ATM.Card;
import src.main.java.com.example.demo.designquestions.ATM.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState(){
        showOperations();
    }
    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }



    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType){
            case CASH_WITHDRAWAL -> atm.setCurrentATMState(new CashWithdrawalState());
            case BALANCE_CHECK -> atm.setCurrentATMState(new CheckBalanceState());
            default -> { System.out.println("Invalid option !!");
                exit(atm);
            }
        }
    }


    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
    }

    @Override
    public void returnCard() {
        System.out.println(
                "Please collect your card!!"
        );
    }

}
