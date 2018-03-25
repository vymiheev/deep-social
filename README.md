Необходимо сделать приложение, собирающее информацию по Youtube-каналам, и
выводящее статистику по географии каналов.
Входные данные - файл с идентификаторами (channel_id) каналов Youtube.
У каждого Youtube-канала существует страничка с информацией о канале.
Её адрес - https://www.youtube.com/channel/<channel_id>/about, например:
https://www.youtube.com/channel/UCxSv7WIOXbyDAvw2US1LSlg/about
Требуется для всех каналов из файла скачать эти странички, извлечь из них информацию
по странам и числу подписчиков каждого канала.
На выходе нужно получить список стран, число каналов в каждой стране, суммарное
количество подписчиков каналов этой страны. Список упорядочить по убыванию
суммарного количества подписчиков.


Замечания
1. Язык страницы (и, соответственно, названия стран) youtube зависит от ip-адреса, с
которого делается запрос. Там, где страна не указана - используйте особое
значение (например “Неизвестно”).
2. Можно использовать любые привычные библиотеки для парсинга html и
выполнения http-запросов.

3. Вы можете выбрать любой удобным вам вариант реализации - консольное или веб
приложение. Формат выводимых данных также может быть любой удобный для
вас - CSV, JSON, html таблица или любой другой.
4. Плюсом будет реализация параллельной обработки разных страниц в разных
потоках (например, в 8 потоков).
