package src.main.java.com.example.demo.designquestions.ATM.states;

import src.main.java.com.example.demo.designquestions.ATM.ATM;
import src.main.java.com.example.demo.designquestions.ATM.ATMState;
import src.main.java.com.example.demo.designquestions.ATM.Card;
import src.main.java.com.example.demo.designquestions.ATM.processors.CashWithdrawProcessor;
import src.main.java.com.example.demo.designquestions.ATM.processors.FiveHundredWithdrawProcessor;
import src.main.java.com.example.demo.designquestions.ATM.processors.OneHundredWithdrawProcessor;
import src.main.java.com.example.demo.designquestions.ATM.processors.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        if(atm.getAtmBalance()<withdrawAmount){
            System.out.println("Insufficient fund in atm!!");
            exit(atm);
        }else if(card.getBankBalance()<withdrawAmount){
            System.out.println("Insufficient fund in bank account!!");
            exit(atm);
        }else{
            card.deductBankBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);
            CashWithdrawProcessor cashWithdrawProcessor=
                    new TwoThousandWithdrawProcessor(
                            new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            cashWithdrawProcessor.withdraw(atm,withdrawAmount);
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
