import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    // заголовки задач
    public static void taskHeader(int number, String caption) {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("|| Задача " + number + ": " + caption + " ||");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    // ====================================================================================================================

    public static boolean checkLeapYear(int year) {                         // проверка года на високосность
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void printLeapYear(int year) {                              // вывод сообщения
        if (checkLeapYear(year)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
    }

    public static void task1() {
        taskHeader(1, "Високосный год");
        short yearToCheck = (short) ((Math.random() * 201) + 1900);
        printLeapYear(yearToCheck);
    }

    // ====================================================================================================================

    public static String inputOS() {    // пользователь выбирает ОС
        System.out.println("Выберите вашу операционную систему: 1 — iOS, 2 — Android");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int userOS = scanner.nextInt();
            switch (userOS) {
                case 1:
                    return "iOS";
                case 2:
                    return "Android";
            }
        }
        return "404";
    }

    public static int inputYear() { // пользователь задаёт года выпуска телефона
        System.out.println("Введите года выпуска телефона");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else return LocalDate.now().getYear();
    }

    public static String checkOSVersion(int clientDeviceYear) { // выбираем версию приложения
        int currentYear = LocalDate.now().getYear();
        if (clientDeviceYear <= currentYear)
            return " облегченную";
        else return "";
    }

    public static void task2() {
        taskHeader(2, "Операционная система");
        String osType = inputOS();
        if (osType.equals("404")) {
            System.out.println("Ваша ОС не поддерживается");
        } else {
            String versionType = checkOSVersion(inputYear());
            System.out.printf("Установите%s версию приложения для %s по ссылке \n", versionType, osType);
        }
    }

    // ====================================================================================================================
    public static byte checkDeliveryTime(int deliveryDistance) {  // вычисление времени доставки
        if (deliveryDistance < 20) {
            return 1;
        } else if (deliveryDistance < 60) {
            return 2;
        } else if (deliveryDistance <= 100) {
            return 3;
        }
        return -1;  // если доставка не доступна
    }

    public static void task3() {
        taskHeader(3, "Delivery club");
        int distance = (int) (Math.random() * 121); // задаём расстояние доставки как случайное число от 0 до 120
        System.out.println("Delivery distance is " + distance + " kilometers.");
        byte deliveryTime = checkDeliveryTime(distance);
        if (deliveryTime >= 0) System.out.println("Estimated delivery time is " + deliveryTime + " days.");
        else {
            System.out.println("Delivery is not available.");
        }
    }
}