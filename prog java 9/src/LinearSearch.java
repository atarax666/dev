public class LinearSearch {
    // Метод для линейного поиска элемента в массиве
    public static <T> int linearSearch(T[] array, T target) {
        for (int i = 0; i < array.length; i++) { // Проходим по каждому элементу массива
            if (array[i].equals(target)) { // Если элемент равен искомому
                return i; // Возвращаем индекс найденного элемента
            }
        }
        return -1; // Если элемент не найден, возвращаем -1
    }
}
