package src.main.java.com.example.demo.behaviorialdp.Interpretordp;

public class ClientInterpretor {
    public static void main(String[] args) {
        Context context= new Context();
        context.put("a",2);
        context.put("b",6);

        AbstractExpression expression1= new MultiTerminalExpression(new NumberTerminalExpression("a"),
                new NumberTerminalExpression("b"));
        System.out.println(expression1.interpret(context));
    }
}
