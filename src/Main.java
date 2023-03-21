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

    public static boolean checkLeapYear(int year) {                         // проверка года на високосность
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void printLeapYear(int year) {                              // вывод сообщения
        if (checkLeapYear(year) == true) {
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

    public static String checkOS(int clientOS, int clientDeviceYear) {                         // проверка операционной системы
        if ((clientOS == 0) && (clientDeviceYear < 2015))
            return ("Установите облегченную версию приложения для iOS по ссылке");
        else if ((clientOS == 0) && (clientDeviceYear >= 2015)) {
            return ("Установите версию приложения для iOS по ссылке");
        }
        if ((clientOS == 1) && (clientDeviceYear < 2015)) {
            return ("Установите облегченную версию приложения для Android по ссылке");
        } else if ((clientOS == 1) && (clientDeviceYear >= 2015))
            return ("Установите версию приложения для Android по ссылке");
        else {
            return ("Ваша ОС не поддерживается");
        }
    }

    public static void task2() {
        taskHeader(2, "Операционная система");
        System.out.println(checkOS(1, 2012)); // 0 — iOS, 1 — Android, 2 - другая ОС
    }

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
        System.out.println("Delivery distance is " +distance+ " kilometers.");
        byte deliveryTime = checkDeliveryTime(distance);
        if (deliveryTime >= 0) System.out.println("Estimated delivery time is " + deliveryTime+ " days.");
        else {
            System.out.println("Delivery is not available.");
        }
    }
}