/*
 Тут две дискуссионные темы: 
 проверка пустоты стрима,
 как обойти ограничение в использовании в стримах
  только финальных переменных
 */
package module6._642.findMinMax;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class FindMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Iterator<? extends T> iterator = stream.iterator();
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        T initial = iterator.next();
        AtomicReference<T> min = new AtomicReference<>(initial);
        AtomicReference<T> max = new AtomicReference<>(initial);

        while (iterator.hasNext()) {
            T t = iterator.next();
            if (order.compare(t, min.get()) < 0) {
                min.set(t);
            }
            if (order.compare(t, max.get()) > 0) {
                max.set(t);
            }
        }
        minMaxConsumer.accept(min.get(), max.get());
    }
}
