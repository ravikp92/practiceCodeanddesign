package src.main.java.com.example.demo.behaviorialdp.Interpretordp;

public class MultiTerminalExpression implements AbstractExpression{

    AbstractExpression left;
    AbstractExpression right;

    public MultiTerminalExpression(NumberTerminalExpression a, NumberTerminalExpression b) {
        this.left=a;
        this.right=b;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context)*right.interpret(context);
    }
}
