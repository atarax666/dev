public class StackOnQueueTest {
    public static void main(String[] args) {
        System.out.println();
        // Создаем первый стек.
        StackOnQueue stack1 = new StackOnQueue();

        // Добавляем элементы в первый стек.
        stack1.push(10); // Добавляем элемент 10.
        stack1.push(20); // Добавляем элемент 20.

        // Выводим изначальное содержимое первого стека.
        System.out.println("Изначальное содержимое первого стека: " + stack1);

        // Тестируем методы первого стека.
        System.out.println("Элемент на вершине первого стека: " + stack1.top()); // Выводим элемент на вершине.
        System.out.println("Удаленный элемент из первого стека: " + stack1.pop()); // Удаляем и выводим верхний элемент.
        System.out.println("Первый стек пуст? " + stack1.empty()); // Проверяем, пуст ли стек.
        System.out.println("Содержимое первого стека после операций: " + stack1); // Выводим текущее содержимое стека.

        System.out.println(); // Пустая строка для разделения вывода.

        // Создаем второй пустой стек.
        StackOnQueue stack2 = new StackOnQueue();

        // Выводим изначальное содержимое второго стека (он пуст).
        System.out.println("Изначальное содержимое второго стека: " + stack2);

        // Проверяем, пуст ли второй стек.
        System.out.println("Второй стек пуст? " + stack2.empty()); // Должен вернуть true.

        // Пробуем вызвать методы top() и pop() на пустом стеке. Обрабатываем исключения.
        try {
            System.out.println("Попытка получить вершину второго стека: " + stack2.top());
        } catch (IllegalStateException e) {
            // Выводим сообщение об ошибке, если стек пуст.
            System.out.println("Ошибка при вызове top() на пустом стеке: " + e.getMessage());
        }

        try {
            System.out.println("Попытка удалить элемент из второго стека: " + stack2.pop());
        } catch (IllegalStateException e) {
            // Выводим сообщение об ошибке, если стек пуст.
            System.out.println("Ошибка при вызове pop() на пустом стеке: " + e.getMessage());
        }
    }
}
