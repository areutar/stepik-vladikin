Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

1. Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
2. Первый элемент последовательности устанавливается равным этому числу.
3. Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.

Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)

**Пример**

pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:

13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)