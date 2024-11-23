public class GenericStack<E> {
    private E[] elements; // Массив для хранения элементов стека
    private int size = 0; // Текущий размер стека
    private static final int DEFAULT_CAPACITY = 10; // Начальная емкость стека

    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY]; // Инициализация массива с начальной емкостью
    }

    // Метод добавления элемента на вершину стека
    public void push(E value) {
        if (size == elements.length) { // Проверка на заполненность массива
            resize(); // Удвоение размера массива, если он заполнен
        }
        elements[size++] = value; // Добавляем новый элемент и увеличиваем size
    }

    // Метод для получения элемента с вершины стека без удаления
    public E peek() {
        return elements[size - 1];
    }

    // Метод для удаления элемента с вершины стека
    public E pop() {
        E topElement = elements[--size]; // Получаем верхний элемент и уменьшаем size
        elements[size] = null; // Помогаем сборщику мусора, удаляя ссылку на объект
        return topElement;
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для увеличения размера массива
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) new Object[elements.length * 2]; // Создаем новый массив с удвоенной емкостью
        System.arraycopy(elements, 0, newArray, 0, elements.length); // Копируем элементы в новый массив
        elements = newArray; // Переназначаем ссылку на новый массив
    }
}
