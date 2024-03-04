Рассмотрим следующий код:

Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);

Что будет фактически записано в outputStream, если мы попытаемся вывести через writer символ, не представимый в указанной ему кодировке ASCII? Например, какой-нибудь иероглиф или символ кириллицы.

- Будет брошено исключение
- Байт 32 (ASCII-код пробела)
- Байт 0
- Байт 63 (ASCII-код символа '?')
- Ни одного байта выведено не будет 