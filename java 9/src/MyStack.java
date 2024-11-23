import java.util.ArrayList;

// Класс MyStack, который реализует интерфейс Cloneable для возможности клонирования
public class MyStack implements Cloneable {
    // Поле list типа ArrayList используется для хранения элементов стека
    private ArrayList<Object> list = new ArrayList<>();

    // Метод isEmpty проверяет, пуст ли стек, и возвращает true, если в стеке нет элементов
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Метод getSize возвращает количество элементов в стеке
    public int getSize() {
        return list.size();
    }

    // Метод peek возвращает элемент, находящийся на вершине стека, не удаляя его
    public Object peek() {
        // Если стек пуст, выбрасывается исключение
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Возвращаем последний элемент из списка (верхушку стека)
        return list.get(list.size() - 1);
    }

    // Метод pop удаляет и возвращает элемент, находящийся на вершине стека
    public Object pop() {
        // Если стек пуст, выбрасывается исключение
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Удаляем и возвращаем последний элемент из списка (верхушку стека)
        return list.remove(list.size() - 1);
    }

    // Метод push добавляет новый элемент на вершину стека
    public void push(Object o) {
        list.add(o);
    }

    // Метод clone выполняет глубокое копирование стека
    @Override
    public Object clone() {
        try {
            // Создаем поверхностную копию текущего объекта MyStack
            MyStack clonedStack = (MyStack) super.clone();
            // Создаем новый ArrayList для поля list, копируя элементы текущего списка
            clonedStack.list = new ArrayList<>(list);
            // Возвращаем клонированный объект MyStack
            return clonedStack;
        }
        catch (CloneNotSupportedException ex) {
            // В случае ошибки клонирования возвращаем null
            return null;
        }
    }
}
