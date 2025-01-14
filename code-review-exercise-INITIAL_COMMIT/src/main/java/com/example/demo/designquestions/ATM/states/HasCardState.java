package src.main.java.com.example.demo.designquestions.ATM.states;

import src.main.java.com.example.demo.designquestions.ATM.ATM;
import src.main.java.com.example.demo.designquestions.ATM.ATMState;
import src.main.java.com.example.demo.designquestions.ATM.Card;

public class HasCardState extends ATMState {


    public HasCardState(){
        System.out.println("enter your card pin number");
    }


    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isPinCorrect=card.isCorrectPINEntered(pin);

        if(isPinCorrect){
            atm.setCurrentATMState(new SelectOperationState());
        }else {
            System.out.println("Invalid pin!!");
            exit(atm);
        }
    }
}
