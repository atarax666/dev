public class MaxElementFinder {

    // Метод поиска максимального элемента в массиве объектов типа Circle
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) return null; // Проверка на пустой массив
        T max = array[0]; // Инициализируем переменную max первым элементом массива
        for (T element : array) { // Проходим по каждому элементу массива
            if (element.compareTo(max) > 0) { // Сравниваем текущий элемент с max
                max = element; // Обновляем max, если нашли больший элемент
            }
        }
        return max; // Возвращаем максимальный элемент
    }
}
