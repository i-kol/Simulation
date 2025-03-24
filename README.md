## Проект “Симуляция”

Суть проекта - пошаговая симуляция 2D мира, населённого травоядными и хищниками. Кроме существ, мир содержит ресурсы (траву), которыми питаются травоядные, и статичные объекты (деревья, камни), с которыми нельзя взаимодействовать - они просто занимают место.

2D мир представляет из себя матрицу NxM, каждое существо или объект занимают клетку целиком, нахождение в клетке нескольких объектов/существ - недопустимо.

![Screenshot_1](https://github.com/user-attachments/assets/23bec700-692b-428e-910f-90af8ee18d2e)

Вначале необхлдимо задать размеры игровой карте (указать количество строк и столбцов).
После этого будет запущен бесконечный процесс симуляции. По мере исчезновения ресурсов для существ, они будут автоматически генерироваться, исходя из размеров карты.

Бесконечный игровой процесс можно:
1. Поставить на паузу
2. Возобновить
3. Включить пошаговый процесс (по 1-му ходу всех существ за итерацию)
4. Прервать и выйти из приложения

### Установка и запуск приложения

Для запуска приложения установите на своем компьютере Java 17 (или выше).

Запуск из Intellij IDEA:
1. Клонировать проект по ссылке: https://github.com/i-kol/Simulation.git
2. Запустить Main.java

Запуск из jar-файла:
1. Скопировать ZIP-архив проекта по ссылке: https://github.com/i-kol/Simulation.git
2. Распаковать на своем компьютере
3. В терминале свой OS перейти в распакованную папку проекта
4. Запустить файл Simulation.jar (команда: java -jar Simulation.jar)
