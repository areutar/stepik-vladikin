package module6._631.ternaryOperator;

import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            if (condition.test(t)) {
                return ifTrue.apply(t);
            } else {
                return ifFalse.apply(t);
            }
        };
    }
}
