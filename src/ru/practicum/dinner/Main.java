package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);


        while (true) {
            printMenu();
            String command = scanner.nextLine();
            ArrayList<String> typeItems = new ArrayList<>();

            switch (command) {
                case "1":
                    System.out.println("Введите тип блюда:");
                    String dishType = scanner.nextLine();
                    System.out.println("Введите название блюда:");
                    String dishName = scanner.nextLine();
                    dc.addNewDish(dishType, dishName);
                    break;
                case "2":
                    System.out.println("Начинаем конструировать обед...");
                    System.out.println("Введите количество наборов, которые нужно сгенерировать:");
                    int numberOfCombos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                    String nextItem = scanner.nextLine();
                    while (!nextItem.isEmpty()) {
                        typeItems.add(nextItem);
                        nextItem = scanner.nextLine();
                    }
                    dc.generateDishCombo(numberOfCombos, typeItems);
                    break;
                case "3": //todo убрать кейс перед отправкой
                    dc.printAllDishesByType();
                    break;
                case "4":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Показать весь список блюд по категориям");
        System.out.println("4 - Выход");
    }


    // сгенерируйте комбинации блюд и выведите на экран

}

