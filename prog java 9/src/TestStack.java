import java.util.Scanner;

public class TestStack {

    public static void main(String[] args) {
        InheritedStack<String> stack = new InheritedStack<>(); // Создаем объект стека
        Scanner scanner = new Scanner(System.in); // Создаем сканер для ввода

        System.out.println("Введите 5 строк:");
        for (int i = 0; i < 5; i++) {
            stack.push(scanner.nextLine()); // Добавляем введенные строки в стек
        }

        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) { // Выводим строки в обратном порядке, пока стек не пуст
            System.out.println(stack.pop()); // Удаляем и выводим верхний элемент
        }
    }
}
