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
        String message = "Выбери игру введя 1 угадай чиcло, 2 угадай слово. Для выхода введи 0: ";
        startGame(0, 2, message); //Вызов метода для старта игры с 3 параметрами
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
                System.out.println("Вы ввели некорректное число");
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
        }
    }

    /**
     * Игра в угадай число
     *
     * @param life прием переменной количество попыток
     * @param min  принимаем минимальное число
     * @param max  принимаем максимальное число
     */
    public static void guessNumber(int life, int min, int max) {
        RND = random.nextInt(max); //Генерация рандомно го числа от 0 до max
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
                } else {
                    break;
                }
            } else {
                System.out.println("Вы ввели некорректное число");
                scanner.nextLine();
            }
        }
        if (RND == X) {
            startGame(0, 2, "Вы выбрали поздравляю!!! Повторить игру еще раз? 1 – да / 0 – нет." +
                    " Может хотите запустить игру в слова тогда введите 2");
        } else {
            startGame(0, 2, "Вы проиграли!!! Повторить игру еще раз? 1 – да / 0 – нет." +
                    " Может хотите запустить игру в слова тогда введите 2");
        }
    }

    /*
     * Игра угадай слово
     */
    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"}; // Объявление массива слов
        char[] arr = {'#', '#', '#', '#', '#', '#', '#', '#', '#',
                '#', '#', '#', '#', '#', '#'};// Объявление массива для маскировки слова
        char pc; // Переменна для разбивки слова на символы компьютера
        char user;// Переменна для разбивки слова на символы человека
        int counter; //Переменная для запоминания короткого слова
        String str; //Переменная для запоминания слова пк
        for (String word : words) {
            System.out.print(word + ", ");
        }
        RND = random.nextInt(words.length + 1); // Выбор рандомно го числа от 0 до длины массива
        str = words[RND];//Запоминаем слово
        System.out.println("Я загадал одно слово угадай его!");
        do {
            SAY = scanner.next();//Запрос ввести слово
            /*
            Выбираем какое слово короче
             */
            counter = Math.min(str.length(), SAY.length());
            /*
            пробегаем по всем символам столько сколько символов в коротком слове
             */
            for (int i = 0; i < counter; i++) {
                pc = str.charAt(i);
                user = SAY.charAt(i);
                if (pc == user) {
                    arr[i] = user;
                }
            }
            /*
            Если слова не ровны, то выводим массив для маскировки слова
             */
            if (!str.equals(SAY)) {
                for (char c : arr) {
                    System.out.print(c);
                }
            }
            System.out.println();
        } while (!str.equals(SAY));
        startGame(0, 2, "Вы угадали поздравляю!!! слово " + SAY + " Повторить игру еще раз? 2 – да / 0 – нет." +
                " Может хотите запустить игру в угадай число тогда введите 1");
    }
}
