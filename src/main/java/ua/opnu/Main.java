package ua.opnu;

import src.main.java.ua.opnu.MyOptional;

import java.util.Arrays;

import static ua.opnu.Contains.contains;
import static ua.opnu.Filter.filter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        BookData book = new BookData("Kobzar", "Shevchenko", 5, 100);
        BookData book2 = new BookData("Backrooms", "Author", 90, 1950);

        book.Comparison(book2);


        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);


        String[] wordsArray = {"apple", "banana", "cat", "apricot", "dog"};
        String[] filteredWords = filter(wordsArray, s -> s.startsWith("a"));
        System.out.println("Відфільтровані слова (на 'a'): " + Arrays.toString(filteredWords));


        Integer[] numbers = {10, 20, 30, 40, 50};
        boolean found = contains(numbers, 30);
        System.out.println("Чи містить масив 30? " + found);

        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Кирило", 95);
        System.out.println("Двомісний кортеж: " + student);
        System.out.println("Ім'я: " + student.first + ", Оцінка: " + student.second);


        GenericThreeTuple<String, Integer, String> studentDetails = new GenericThreeTuple<>("Микита", 95, "Здано");
        System.out.println("Тримісний кортеж: " + studentDetails);
        System.out.println("Студент: " + studentDetails.twoTuple.first + " Бали: " + studentDetails.twoTuple.second + " Статус: " + studentDetails.third);
    }
}


class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}


class GenericThreeTuple<T, V, S> {
    public final GenericTwoTuple<T, V> twoTuple;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + twoTuple.first + "," + twoTuple.second + "," + third + ")";
    }
}
