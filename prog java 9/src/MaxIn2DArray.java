public class MaxIn2DArray {

    // Метод для поиска максимального элемента в двумерном массиве
    public static <T extends Comparable<T>> T findMax(T[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return null;

        T max = array[0][0]; // Инициализируем max первым элементом массива
        for (T[] row : array) { // Проходим по каждой строке
            for (T element : row) { // Проходим по каждому элементу строки
                if (element.compareTo(max) > 0) { // Сравниваем текущий элемент с max
                    max = element; // Обновляем max, если нашли больший элемент
                }
            }
        }
        return max; // Возвращаем максимальный элемент
    }
}
