import java.util.ArrayList;

public class InheritedStack<E> extends ArrayList<E> {

    // Метод для добавления элемента на вершину стека
    public void push(E value) {
        add(value); // Добавляем элемент в список
    }

    // Метод для удаления элемента с вершины стека
    public E pop() {
        return remove(size() - 1); // Удаляем и возвращаем верхний элемент
    }

    // Метод для получения элемента с вершины стека без удаления
    public E peek() {
        return get(size() - 1); // Возвращаем верхний элемент без удаления
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
