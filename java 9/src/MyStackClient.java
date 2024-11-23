import java.util.Scanner;

// Клиентский класс для работы со стеком MyStack
public class MyStackClient {
    public static void main(String[] args) {
        // Создаем объект Scanner для считывания ввода пользователя
        Scanner scanner = new Scanner(System.in);
        // Создаем экземпляр стека MyStack
        MyStack stack = new MyStack();

        // Просим пользователя ввести пять строк и добавляем их в стек
        System.out.println("Введите пять строк:");
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            // Добавляем строку на вершину стека
            stack.push(input);
        }

        // Выводим строки в обратном порядке
        System.out.println("\nСтроки в обратном порядке:");
        while (!stack.isEmpty()) {
            // Извлекаем и выводим каждую строку с вершины стека
            System.out.println(stack.pop());
        }
        // Закрываем объект Scanner для освобождения ресурсов
        scanner.close();
    }
}
