package lesson16;

public class LambdaAndVars {
    static int a = 12;
    static int b = 22;

    public static void main(String[] args) {
        int n = 10, m = 20;
        Message message = new Message("message");
        SomeInterface someInterface = (x, y)->{ // (n, m)->{ не можем использовать
                                                    // в качестве аргументов
//            a = 100;
//            return a + b;
//            n = 100; // не можем изменить значение
//            message = new Message("message in lambda");
            message.setText("new message");
            return n + m;
        };
        System.out.println(someInterface.doSomething(3, 6));
    }
}

@FunctionalInterface
interface SomeInterface{
    int doSomething(int a, int b);
}
class Message{
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}



