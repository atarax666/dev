import java.util.ArrayList;

// Класс MyStackInheritsArrayList является подклассом ArrayList и представляет стек
public class MyStackInheritsArrayList extends ArrayList<Object> {
    // Метод isEmpty проверяет, пуст ли стек, возвращая true, если в стеке нет элементов
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // Метод getSize возвращает количество элементов в стеке
    public int getSize() {
        return super.size();
    }

    // Метод peek возвращает элемент на вершине стека, не удаляя его
    public Object peek() {
        // Если стек пуст, выбрасывается исключение
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Возвращаем последний элемент списка (верхушку стека)
        return super.get(size() - 1);
    }

    // Метод pop удаляет и возвращает элемент, находящийся на вершине стека
    public Object pop() {
        // Если стек пуст, выбрасывается исключение
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        // Удаляем и возвращаем последний элемент списка (верхушку стека)
        return super.remove(size() - 1);
    }

    // Метод push добавляет новый элемент в верхнюю часть стека
    public void push(Object o) {
        super.add(o);
    }
}



//        Класс MyStack содержит ArrayList, поэтому отношение между MyStack и ArrayList —
//        ĸомпозиция. По существу, ĸомпозиция означает объявление переменной эĸземпляра для
//        ссылĸи на объеĸт. Этот объеĸт называется составным. В то время ĸаĸ наследование
//        моделирует отношение is-a, ĸомпозиция моделирует отношения has-a. Таĸже можно
//        реализовать MyStack в ĸачестве подĸласса ArrayList. Однаĸо использование ĸомпозиции
//        лучше, таĸ ĸаĸ позволяет определить совершенно новый ĸласс для моделирования стеĸа
//        без наследования ненужных и неподходящих методов ĸласса ArrayList.