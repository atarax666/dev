import java.util.concurrent.ConcurrentHashMap;

public class AppSettings {
    // Поле для хранения единственного экземпляра
    private static volatile AppSettings instance;

    // Коллекция для хранения настроек
    private final ConcurrentHashMap<String, String> settings;

    // Приватный конструктор для предотвращения создания объектов извне
    private AppSettings() {
        settings = new ConcurrentHashMap<>();
    }

    // Метод для получения единственного экземпляра (реализация Singleton с двойной проверкой)
    public static AppSettings getInstance() {
        // Первая проверка для уменьшения блокировок
        if (instance == null) {
            // Синхронизация для потокобезопасности
            synchronized (AppSettings.class) {
                // Вторая проверка, чтобы не создавать несколько объектов
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    // Метод для установки значения настройки
    public void setSetting(String key, String value) {
        settings.put(key, value); // Сохраняем настройку по ключу
    }

    // Метод для получения значения настройки
    public String getSetting(String key) {
        return settings.get(key); // Возвращаем значение настройки по ключу
    }

    public static void main(String[] args) {
        // Задача для многопоточного тестирования Singleton
        Runnable task = () -> {
            // Получаем экземпляр Singleton
            AppSettings settings = AppSettings.getInstance();
            // Получаем имя текущего потока
            String threadName = Thread.currentThread().getName();
            // Устанавливаем настройку с указанием темы и имени потока
            settings.setSetting("theme", "тёмная тема (" + threadName + ")");
            // Выводим сообщение, какая тема была установлена этим потоком
            System.out.println(threadName + " установил тему: " + settings.getSetting("theme"));
        };

        // Создаём три потока, которые будут выполнять задачу
        Thread thread1 = new Thread(task, "Поток-1");
        Thread thread2 = new Thread(task, "Поток-2");
        Thread thread3 = new Thread(task, "Поток-3");

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();

        // Дожидаемся завершения всех потоков
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем итоговое значение настройки
        AppSettings settings = AppSettings.getInstance();
        System.out.println("Финальная тема: " + settings.getSetting("theme"));
    }
}
