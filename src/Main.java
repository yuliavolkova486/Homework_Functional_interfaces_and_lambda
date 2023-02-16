import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------task1--------------------------");
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };

        Predicate<Integer> predicate1 = x -> x > 0;

        System.out.println(predicate.test(-5));
        System.out.println(predicate1.test(8));

        System.out.println("---------------------------task2--------------------------");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello, " + s + " !");
            }
        };

        Consumer<String> consumer1 = s -> System.out.println("Hello, " + s + " !");

        consumer.accept("Iuliia");
        consumer1.accept("Mentor");

        System.out.println("---------------------------task3--------------------------");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double, Long> function1 = Math::round;

        System.out.println(function.apply(3.89645));
        System.out.println(function1.apply(899.036));

        System.out.println("---------------------------task4--------------------------");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };

        Supplier<Integer> supplier1 = () -> (int) (Math.random() * 100);

        System.out.println(supplier.get());
        System.out.println(supplier1.get());

        System.out.println("---------------------------task5--------------------------");

        Predicate<Integer> condition = x -> x < 12;
        Function<Integer, Double> function2 = x -> Math.pow(x, 2);
        Function<Integer, Double> function3 = Math::sin;

        System.out.println(ternaryOperator(condition, function2, function3).apply(2));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }







}