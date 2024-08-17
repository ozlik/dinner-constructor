package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu; //String - типы блюд. Список - название типов блюд.
    Random random;

    public DinnerConstructor() {
        this.menu = new HashMap<>();
        this.random = new Random();
    }

    void addNewDish(String dishType, String dishName) { //наполняем Меню
        ArrayList<String> dishesName = new ArrayList<>();
        if (menu.containsKey(dishType)) { //если меню не пустое, выполняем проверку на наличие такого типа блюд
            dishesName = menu.get(dishType); //получаем названия блюд для типа, сохраняем в список
            if (dishesName.contains(dishName)) { //если блюдо уже есть, список не обновляем
                System.out.println("Блюдо " + dishName + " не было добавлено. " + "Для категории " +
                        dishType + " оно уже есть в меню!");
                return;
            }
            dishesName.add(dishName); //если блюда нет, добавляем его в список
            menu.put(dishType, dishesName); //обновляем список в таблице в соответствии с типом

        } else { //если такого типа блюд пока нет
            dishesName.add(dishName);
            menu.put(dishType, dishesName);
        }
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typeItems) { //метод для генерации меню
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));//количество наборов
            for (String type : typeItems) {
                ArrayList<String> dishes = menu.get(type);
                int index = random.nextInt(dishes.size()); //случайным образом готовим комбо, ограниченные размером списка блюд и типом блюд
                System.out.println(menu.get(type).get(index));
            }
        }
    }

    public boolean checkType(String nextItem) {
        return menu.containsKey(nextItem);
    }
}