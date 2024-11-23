import java.util.LinkedList; // Импортируем LinkedList для использования в качестве очереди.
import java.util.Queue;      // Импортируем интерфейс Queue.

public class StackOnQueue {
    // Первая очередь для хранения элементов стека.
    private Queue<Integer> queue1 = new LinkedList<>();
    // Вторая вспомогательная очередь для пересортировки элементов.
    private Queue<Integer> queue2 = new LinkedList<>();

    // Метод для добавления элемента x на вершину стека.
    public void push(int x) {
        // Добавляем новый элемент в queue2.
        queue2.add(x);
        // Перемещаем все элементы из queue1 в queue2.
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll()); // Удаляем элемент из queue1 и добавляем его в queue2.
        }
        // Меняем местами queue1 и queue2. Теперь queue1 снова становится основной.
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Метод для удаления элемента с вершины стека и возврата его значения.
    public int pop() {
        // Проверяем, пуста ли очередь (стек). Если да, выбрасываем исключение.
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Стек пуст.");
        }
        // Удаляем и возвращаем верхний элемент из queue1.
        return queue1.poll();
    }

    // Метод для получения элемента на вершине стека без его удаления.
    public int top() {
        // Проверяем, пуста ли очередь (стек). Если да, выбрасываем исключение.
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Стек пуст.");
        }
        // Возвращаем верхний элемент из queue1.
        return queue1.peek();
    }

    // Метод для проверки, пуст ли стек.
    public boolean empty() {
        // Возвращаем true, если queue1 пуста, иначе false.
        return queue1.isEmpty();
    }

    // Метод для получения строкового представления всех элементов стека.
    @Override
    public String toString() {
        // Возвращаем строковое представление содержимого queue1.
        return queue1.toString();
    }
}
