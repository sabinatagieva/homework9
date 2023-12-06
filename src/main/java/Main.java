import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Задание 1: Создание класса Car с условиями исключений
        Car car = new Car();

        try {
            car.setBrand("Toyota");
            car.setYear(2022);

            System.out.println("Бренд: " + car.getBrand());
            System.out.println("Год выпуска: " + car.getYear());
        } catch (InvalidBrandException | InvalidYearException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Задание 2: Создание ArrayList, добавление, удаление и изменение элементов
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Исходный список: " + numbers);

        numbers.remove(0);
        numbers.remove(3);
        numbers.remove(numbers.size() - 1);

        System.out.println("Список после удаления: " + numbers);

        int indexToChange = 1;
        int newValue = 100;
        numbers.set(indexToChange, newValue);

        System.out.println("Список после изменения: " + numbers);

        // Задание 3: Создание коллекции с уникальными значениями
        List<String> languages = List.of("Java", "Python", "Perl", "C++", "Java", "C++", "C#");
        Set<String> uniqueLanguages = new HashSet<>(languages);

        System.out.println("Коллекция с уникальными значениями: " + uniqueLanguages);
    }
}

// Задание 1: Создание своих исключений
class InvalidBrandException extends Exception {
    public InvalidBrandException(String message) {
        super(message);
    }
}

class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

// Задание 2: Создание класса Car
class Car {
    private String brand;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidBrandException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new InvalidBrandException("Бренд не может быть пустым или равным null");
        }
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidYearException {
        if (year < 1886 || year > getCurrentYear()) {
            throw new InvalidYearException("Некорректный год выпуска автомобиля");
        }
        this.year = year;
    }

    private int getCurrentYear() {
        return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    }
}
