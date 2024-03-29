Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале по формуле левых прямоугольников.
[формуле левых прямоугольников](https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%BF%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2)

Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator. Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.

Интервал интегрирования задается его конечными точками aa и bb, причем a<=ba<=b. Для получения достаточно точного результата используйте шаг сетки не больше 10−610−6.

```java
integrate(x -> 1, 0, 10)
```

должен возвращать значение 10.

P.S. Если задача слишком легкая, то дополнительно можете реализовать динамический выбор шага сетки по следующему алгоритму:

1. Вычислить приближенное значение интеграла функции при начальном значении шага сетки (например, 1).

2. Вычислить приближенное значение интеграла функции при более мелком шаге сетки (например, уменьшить шаг сетки в два раза).

3. Если разность двух последовательных приближений интеграла функции достаточно мала, то завершаем алгоритм и возвращаем текущее приближение в качестве результата.

4. Иначе возвращаемся к шагу 2.