package ru.dolgov;

import java.util.Random;
import java.util.Scanner;

public class Work3 {
    public static Scanner scanner = new Scanner(System.in); //Обращение к классу Scanner
    public static Random random = new Random(); //Обращение к классу Random
    public static int X; // Поле для записи ввода с консоли в числовой игре
    public static String SAY; //Поле для ввода с консоли в игре слово
    public static int RND;// Поле для генерации случайного числа

    public static void main(String[] args) {
        String message = "Выбери игру введя 1 угадай чиcло, 2 угадай слово: ";
        startGame(1, 2, message); //Вызов метода для старта игры с 3 параметрами
    }

    /**
     * Запуск игры и перезапуск
     *
     * @param min     Принимаем целое число
     * @param max     Принимаем целое число
     * @param message принимаем сообщение
     */
    public static void startGame(int min, int max, String message) {
        do {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                X = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Вы ввели некоректное число");
                scanner.nextLine();
            }
        } while (X > max || X < min);
        if (X == 1) { //Выбор игры, перезапуск или выход
            guessNumber(3, 0, 9);
        } else if (X == 2) {
            guessWord();
        } else {
            System.out.println("До встречи!");
            scanner.close();
            return;

        }
    }

    /**
     * Игра в угадай число
     *
     * @param life прием переменной количестго попыток
     * @param min  принимаем минимальное число
     * @param max  принимаем максимальное число
     */
    public static void guessNumber(int life, int min, int max) {
        RND = random.nextInt(max); //Генирация рандомного числа от 0 до max
        for (int i = 0; i < life; i++) {
            if (i <= 1) { // Вывод количества попыток
                System.out.println("У вас осталось " + (life - i) + " попытки!");
            } else {
                System.out.println("У вас осталось " + (life - i) + " попытка!");
            }
            System.out.println("Угадай число от " + min + " до " + max);
            if (scanner.hasNextInt()) {
                X = scanner.nextInt();
                scanner.nextLine(); // Запрос числа с консоли
                if (RND < X) { //Сравниваем число больше или меньше введенного
                    System.out.println("Число меньше " + X);
                } else if (RND > X) {
                    System.out.println("Число больше " + X);
                } else { //Перезапуск игры если выйграли
                    startGame(0, 1, "Вы выграли поздравляю!!! Повторить игру еще раз? 1 – да / 0 – нет");
                }
            } else {
                System.out.println("Вы ввели некоректное число");
                scanner.nextLine();
            }
        }
        System.out.println("У вас не осталось попыток(");//Перезапуск игры если проиграли
        startGame(0, 1, "Вы проиграли!!! Повторить игру еще раз? 1 – да / 0 – нет");
    }

    /**
     * В процессе
     */
    public static void guessWord() {
      /*  String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        char pc;
        char user;
        String str;
        RND = random.nextInt(words.length);
        str = words[RND];
        System.out.println(words[RND]);
        do {
            SAY = scanner.next();
            for (int i = 0; i < 15; i++) {
                System.out.print("#");
            }
        } while (str != SAY);*/
    }
}
