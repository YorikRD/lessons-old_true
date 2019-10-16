package lesson2;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
//        /*цикл while*/
//
//        /*while (условие) {
//            тело цикла;
//            if (условие) break; позволяет выйти из цикла
//            if (условие) continue; позволяет перейти на следующую итерацию
//        }*/
////        int a = 1;
//        while (a <= 15){
//            a += 3;
//            System.out.printf("a = %d\n", a);
//        }
//        // Программа загадывает число в диапазоне [1;5]
//        /*Пользователь вводит число
//        * Программа в зависимости от ввода пользователя
//        * выводит следующее:
//        * 1. загаданное число меньше
//        * 2. загаданное число больше
//        * 3. Вы угадали
//        * 0 - для выхода из программы
//        * */
//
//        int programNum = (int) (Math.random() * ((5 - 1) + 1)) + 1;
//        System.out.printf("Программа загадала число %d\n", programNum);


        int programNum = (int) (Math.random() * 5 )+1;
        Scanner in = new Scanner(System.in);
        while (true) {
            int scan = in.nextInt();
            if (scan == 0) {
                System.out.println("Вы выходите из прогаммы");
                break;
            } else if (scan < programNum) {
                System.out.println("Вы ввели меньшее значение");
            } else if (scan > programNum) {
                System.out.println("Вы ввели большее значние");
            } else {
                System.out.println("Вы угадали");
                break;
            }

        }

        /*loopName: while (condition) {
            while (condition2) {
                break loopName;
            }
        }*/


        /*Цикл do while*/
       /* do {
            тело цикла
        } while (условие);*/

       do {
           System.out.println("Итерация цикла do while");
       } while (false);

       /*Цикл for*/
        int n = 5;
        int res = 1;
        for (int i = 1; i < n; i++) { // fori
            res *= i;
        }
        System.out.println(res);

        // наибольший общий делитель НОД
    }
}
