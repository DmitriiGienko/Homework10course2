import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("______Задача 1_____");
        //решение через анонимный класс
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println("Введите целое число");
        Scanner sc = new Scanner(System.in);
        int vol = sc.nextInt();
        System.out.println("Число " + vol + (isEven.test(vol) ? " - четное" : " - нечетное"));

        // решение через лямбду
        System.out.println("Введите целое число");
        int vol2 = sc.nextInt();
        Predicate<Integer> isEven2 = integer -> integer % 2 == 0;
        System.out.println("Число " + vol2 + (isEven2.test(vol2) ? " - четное" : " - нечетное"));


        System.out.println("______Задача 2_____");
        //решение через анонимный класс
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет " + s + "!");
            }
        };
        System.out.println("Как вас зовут?");
        consumer.accept(sc.next());

        // решение через лямбду
        System.out.println("Как вас зовут?");
        Consumer<String> consumer1 = s -> System.out.println("Привет " + s + "!");
        consumer1.accept(sc.next());


        System.out.println("______Задача 3_____");
        //   Решение через анонимный класс.
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long accept(Double a) {
                return a.longValue();
            }
        };
        System.out.println("Введите число с десятичной частью");
        Double a = sc.nextDouble();
        System.out.printf("Число %f округлили до %d\n", a, function.accept(a));

        // решение через лямбду
        System.out.println("Введите число с десятичной частью");
        Function<Double, Long> function1 = d -> d.longValue();
        Double d = sc.nextDouble();
        System.out.printf("Число %f округлили до %d\n", d, function1.accept(d));

        System.out.println("______Задача 4_____");
        //  Решение через анонимный класс.
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer getT() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println("Сгенерировали число " + supplier.getT());

        // решение через лямбду
        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println("Сгенерировали число " + supplier1.getT());


    }
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface Function<T, R> {
    R accept(T t);
}

@FunctionalInterface
interface Supplier<T> {
    T getT();
}

