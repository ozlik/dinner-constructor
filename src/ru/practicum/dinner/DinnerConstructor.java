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
        if (menu.get(dishType) != null) { //если меню не пустое, выполняем проверку на наличие такого типа блюд
            //"Лучше заменить на menu.containsKey(dishtype), это как раз проверяет наличие ключа в мапе и возвращает boolean-значение"
            //Нет, не лучше, потому что на вебинаре рекомендовали не использовать эту команду, а использовать гет,
            // иначе бы я не ломала голову, чтобы настроить это всё под гет, мне этот гемор был не нужен :)
            ArrayList<String> dishesName = menu.get(dishType); //получаем названия блюд для типа, сохраняем в список
            for (String value : dishesName) { //выполняем проверку на наличие названия блюда в меню
                //"Это всё тоже лучше заменить на dishesName.contains(dishName), результат будет тот же, а код меньше)"
                //Здесь аналогично, советовали не использовать метод contains для списков, поэтому это выглядит так как выглядит.
                if (value.equals(dishName)) { //если блюдо уже есть, список не обновляем
                    System.out.println("Блюдо " + dishName + " не было добавлено. " + "Для категории " +
                            dishType + " оно уже есть в меню!");
                    return;
                }
            }
            dishesName.add(dishName); //если блюда нет, добавляем его в список
            menu.put(dishType, dishesName); //обновляем список в таблице в соответствии с типом

        } else { //если такого типа блюд пока нет
            ArrayList<String> dishesName = new ArrayList<>();
            dishesName.add(dishName);
            menu.put(dishType, dishesName);
        }
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typeItems) { //метод для генерации меню
        for (int i = 0; i < numberOfCombos; i++) {//количество наборов
            System.out.println("Комбо " + (i + 1));
            for (String type : typeItems) {
                ArrayList<String> dishes = menu.get(type);
                int index = random.nextInt(dishes.size()); //случайным образом готовим комбо, ограниченные размером списка блюд и типом блюд
                System.out.println(menu.get(type).get(index));
                //"Лучше отдельно выше список вынести ArrayList<String> dishes = menu.get(type), так как он потом и при печати используется"
                //если написать через список не будет больше времени тратиться на выполнение метода? потому что на создание списка будут ресурсы выделяться
                //спрашиваю, потому что изначально писала со списком, но потом поправила по примеру наставника
            }
        }
    }

    public boolean checkType(String nextItem) {
        return menu.get(nextItem) != null;
    }
}