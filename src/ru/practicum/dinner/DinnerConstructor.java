package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    Random random;

    public DinnerConstructor() {
        this.menu = new HashMap<>();
        this.random = new Random();
    }

    void addNewDish(String dishType, String dishName) {
        if (menu.get(dishType) != null) {
            ArrayList<String> dishesName = menu.get(dishType);
            for (String value : dishesName) {
                if (value.equals(dishName)) {
                    System.out.println("Блюдо " + dishName + " не было добавлено. " + "Для категории " + dishType + " оно уже есть в меню!");
                    return;
                }
            }
            dishesName.add(dishName); //добавляем блюдо в список
            menu.put(dishType, dishesName);

        } else { //если такого типа блюд пока нет
            ArrayList<String> dishesName = new ArrayList<>(); //создаем новый список
            dishesName.add(dishName);
            menu.put(dishType, dishesName);
        }
    }

    public void printAllDishesByType() { //todo убрать метод
        if (!menu.isEmpty()) {
            for (String key : menu.keySet()) {
                ArrayList<String> dishesName = menu.get(key);
                System.out.println(key);
                for (String di : dishesName) {
                    System.out.println(di);
                }
            }
        } else {
            System.out.println("Список пуст!");
        }
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typeItems) {
        for (int i = 0; i < numberOfCombos; i++) {//количество наборов
            System.out.println("Комбо " + (i + 1));
            for (String type : typeItems) {
                int index = random.nextInt(menu.get(type).size());
                System.out.println(type + ":" + menu.get(type).get(index));

            }
        }


    }
}