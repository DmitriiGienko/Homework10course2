
import java.util.Scanner;
import java.util.function.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

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
        System.out.println("Введите число с десятичной частью");
        Double a = sc.nextDouble();
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return a.longValue();

            }
        };
        System.out.printf("Число %f округлили до %d\n", a, function.apply(a));

        // решение через лямбду
        System.out.println("Введите число с десятичной частью");
        Function<Double, Long> function1 = d -> d.longValue();
        Double d = sc.nextDouble();
        System.out.printf("Число %f округлили до %d\n", d, function1.apply(d));

        System.out.println("______Задача 4_____");
        //  Решение через анонимный класс.
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }


        };
        System.out.println("Сгенерировали число " + supplier.get());

        // решение через лямбду
        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);
        System.out.println("Сгенерировали число " + supplier1.get());


        System.out.println("______Задача 5_____");

        System.out.println("Ваш возраст?");

        System.out.println(ternaryOperator(integer -> integer >= 18,
                yes -> "Можно выпить",
                no -> "Еще не дорос").apply(Function.identity()));


    }

    public static <T, U> Function<? super T, ? extends U> ternaryOperator(
            Predicate<Integer> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        if (condition.test(sc.nextInt())) {
            return ifTrue;
        } else {
            return ifFalse;
        }
    }


}


