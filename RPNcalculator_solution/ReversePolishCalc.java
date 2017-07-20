/**
 * Created by gilpratte on 7/14/17.
 */
public class ReversePolishCalc {

    private int top = 0;
    private String[] tokens;
    private String[] stack;

    public double calculate(String input) {
        tokens = input.split(",");

        // Allocate a stack which will be bigger than just the numbers but that's ok
        stack = new String[tokens.length];

        for(int i = 0; i < tokens.length; ++i) {
            String token = tokens[i];
            if ("+".equals(token)) {
                push(pop() + pop());
            } else if ("-".equals(token)) {
                double op2 = pop();
                double op1 = pop();
                push(op1 - op2);
            } else if ("*".equals(token)) {
                push(pop() * pop());
            } else if ("/".equals(token)) {
                double op2 = pop();
                double op1 = pop();
                push(op1 /   op2);
            } else {
                push(token);
            }
        }
        return pop();
    }

    private void push(String number) {
        stack[top++] = number;
    }

    private void push(double d) {
        stack[top++] = Double.toString(d);
    }

    private double pop() {
        return Double.parseDouble(stack[--top]);
    }
}
