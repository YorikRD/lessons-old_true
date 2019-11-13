package lesson13;

import java.util.Comparator;

public class ExceptionLesson {
    public static void main(String[] args)  {
        int a = 9;
        int b = 0;
        // System.out.println(a / b); // ArithmeticException

        int[] arr = new int[3];
        // arr[10] = 44; ArrayIndexOutOfBoundsException

        String string = null;
        // string.equals("str"); NullPointerException
//        "str".equals(string);

//        Integer.parseInt("string"); NumberFormatException

        Object someData = "123";
//        Integer someInt = (Integer) someData; ClassCastException

        // try catch
        try {
            Integer someInt = (Integer) someData;
            System.out.println("код после ClassCastException");
        } catch (ClassCastException e){
            System.out.println("catch ClassCastException");
            e.printStackTrace();
        }
        System.out.println("код после try catch");


        // объединение catch блоков
        // 1 вариант
        try {

        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        // 2 вариант
        try {

        } catch (ClassCastException | ArithmeticException e) {
            e.printStackTrace();
        }
        finally {
            // блок кода выполнится в слючае любого исключения
        }

        System.out.println("код после try catch");
        // 3 вариант
        try {
            Integer someInt = (Integer) someData;
            string.equals("ioio");
        } catch (ClassCastException | ArithmeticException e){
            System.out.println("ClassCastException");
        } catch (RuntimeException e) { // общий родитель
            System.out.println("RuntimeException");
        }


        Message message = null;
        try {
            message = new Message("Тема", "Текст");
        } catch (CheckedException e) {
            e.printStackTrace();
//            try {
//                throw new CheckedException("CheckedException");
//            } catch (CheckedException e1) {
//                e1.printStackTrace();
//                System.out.println("cause: " + e1.getCause());
//            }
        }

        System.out.println(message);

//        CheckedException (Exception);
//        UncheckedException (RuntimeException);

    }
}
