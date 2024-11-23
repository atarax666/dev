import java.util.ArrayList;
import java.util.List;

public class Task1 {

    // Метод, который принимает список с дубликатами и возвращает новый список без дубликатов
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> result = new ArrayList<>(); // Создаем новый список для хранения уникальных элементов
        for (T element : list) { // Проходим по каждому элементу входного списка
            if (!result.contains(element)) { // Если элемент еще не добавлен в новый список
                result.add(element); // Добавляем элемент в список уникальных значений
            }
        }
        return result; // Возвращаем новый список без дубликатов
    }
}
