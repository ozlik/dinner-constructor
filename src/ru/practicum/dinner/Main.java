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
                    String number = scanner.nextLine();
                    int numberOfCombos = Integer.parseInt(number);
                    System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
                    String nextItem = scanner.nextLine();
                    if (dc.checkType(nextItem)) {
                        typeItems.add(nextItem);
                    } else {
                        System.out.println("Такого типа блюда нет! Добавьте его в воду.");
                        break;
                    }
                    while (!nextItem.isEmpty()) {
                        nextItem = scanner.nextLine();
                        if (dc.checkType(nextItem)) {
                            typeItems.add(nextItem);
                        } else {
                            System.out.println("Такого типа блюда нет! Добавьте его в воду.");
                            break;
                        }
                    }
                    dc.generateDishCombo(numberOfCombos, typeItems);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Такой команды нет, попробуйте ещё раз, и всё получится.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
}

