public class Circle implements Comparable<Circle> {
    private double radius; // Поле для хранения радиуса круга

    public Circle(double radius) { // Конструктор для инициализации радиуса
        this.radius = radius;
    }

    public double getRadius() { // Метод для получения значения радиуса
        return radius;
    }

    @Override
    public int compareTo(Circle other) { // Метод сравнения кругов по радиусу
        return Double.compare(this.radius, other.radius); // Используем встроенное сравнение чисел с плавающей точкой
    }
}