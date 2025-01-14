package src.main.java.com.example.demo.designquestions.ATM.states;

import src.main.java.com.example.demo.designquestions.ATM.ATM;
import src.main.java.com.example.demo.designquestions.ATM.ATMState;
import src.main.java.com.example.demo.designquestions.ATM.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted !!");
        atm.setCurrentATMState(new HasCardState());
    }
}
