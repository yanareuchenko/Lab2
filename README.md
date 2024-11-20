## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2401`

#### Выполнил: `Реученко Яна Антоновна`

#### Вариант: `23`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

>   Напишите программу на Java, которая выполняет следующие действия с двумерным массивом целых чисел, представляющим матрицу смежности графа:
> 1) Считывает с консоли размер матрицы N, затем элементы матрицы размером N × N.
> 2) Проверяет, является ли граф, заданный матрицей, эйлеровым, и выводит результат.
> 3) Находит и выводит степень каждой вершины графа.
> 4) Выводит список рёбер графа.
> 5) Строит и выводит матрицу достижимости графа.

Вводим с клавиатуры натуральное число, определяющее размерность матрицы. С помощью циклов формируем массив. Выводим введенный массив в виде матрицы. Проверяем, является ли граф Эйлеровым (Эйлеров граф - граф у которого нет изолированных вершин и степень каждой вершины четна), для этого считаем степень каждой вершины графа и проверяем ее на четность. Далее выводим степени каждой вершины графа. Чтобы вывести список ребер графа, проверим какое значение (0 или 1) стоит на каждой позиции в заданной матрице смежности. Если 1 - ребро есть, если 0 - отсутствует. Выведем на экран список ребер графа. Создаем временную матрицу и матрицу достижимости графа (размерность совпадает с размером заданной матрицей смежности).Скопируем элементы матрицы смежности в матрицу достижимости, заполнив главную диагонать 1 - тк точка доступна из самой себя. Временную матрицу заполним нулями. Проходя по элементам матрицы достижимости, заполним временную матрицу единиуами там, где вершина достижима через одну (две дороги). Скопируем единицы в матрицу достижимости и выведем итог на экран.  

### 2. Входные и выходные данные

#### Данные на вход

На вход программа должна получить натуральное число - размерность матрицы. Далее N*N натуральных чисел (0 или 1) - элементы матрицы. Переменная типа Boolean для проверки графа на эйлеровость. Переменные k и st - счетчики

*Диапазон значений для указанных входных данных (кроме переменной boolean): size – область натуральных чисел (0; +бесконечности) в пределах разумного =); N[i][j] - элементы матрицы принимают значения 0 или 1 по условию (тк таблица смежности неориентированного графа); k и st - принимают начальное значение 0.*




| Переменная                       | Тип          | Значение                      |
|----------------------------------|--------------|-------------------------------|
| size (Число 1)                   | Целое число  | Размерность матрицы           |
| N [i][j] (Число 2 - Число N*N+1) | Целое число  | Элемент массива               |
| isEilerov                        | boolean      | Проверка графа на эйлеровость |
| k (Число)                        | Целое число  | Счетчик                       |
| st (Число)                       | Целое число  | Счетчик                       |
#### Данные на выход

1. Двумерный массив преобразованный в форму матрицы смежности графа. 
2. Человекачитаемая строка - является ли заданный граф Эйлеровым
3. Степень каждой вершины графа
4. Список ребер графа
5. Матрица достижимости графа
 

### 3. Выбор структуры данных

Для храниния введенных из консоли данных будем использовать двумерный массив, размер которого также задается через консоль. Тип данных хранимых в массиве - int (в количестве размерности массива в квадрате). Переменная isEilerov - тип boolean.

|                                                     | название переменной | Тип (в Java) | 
|-----------------------------------------------------|---------------------|--------------|
| Размер массива (Число 1)                            | `size`              | `int`        |
| Элементы двумерного массива (Число 2 -Число N*N+1 ) | `N[i][j]`           | `int`        |
| Флаг                                                | `isEilerov`         | `boolean`    |
| Счетчик                                             | `k`                 | `int`        |
| Счетчик                                             | `st`                | `int`        |


### 4. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**  
   Программа считывает целое число, обозначенное как `size`, и создает массив `N` размера size x size. Далее считывает size^2 натуральных чисел (int) `N[i][j]` и заполняет ими массив. 

2. **Проверка, является ли заданный матрицей смежности граф Эйлеровым:**  
   Программа получает переменную типа boolean `isEilerov`. Проходит двойным циклам по всемэлементам матрицы и, если граф удовлетворяет условиям Эйлеровости (степень всех вершин четна и нет обособленных вершин) - выводит ответ Граф, `заданный матрицей, является эйлеровым`на экран Граф, в противном случае `заданный матрицей, НЕ является эйлеровым`.

3. **Вывод степени каждой вершины на экран:**
    Проходя по каждой строке матрицы, прибавляет к заданному счетчику`st` значение в данном элементе. Для каждой строки счетчик обнуляется. 

4. **Выводт список ребер графа:**
    Проходя двойным циклом по половине матрицы, выше главной диагонали, проверяет значение в каждой точке матрицы, если значение в элементе - 1, значит дорога между этими пунктами существует. Выводит ребро на экран. Если значение в элементе - 0, значит дороги между этими пунктами не существует.
5. **Строит и выводит матрицу достижимости графа:**
   Программа создает два пустых массива: временный и достижимости, по размеру совпадающие с марицой смежности графа. Временный массив заполняется нулями. А матрица достижимости в соответствие с матрицей смежности, но на главную диагональ матрицы проставляются 1. С помощью двойного цикла проверяем элементы в матрце достижимости, если нашелся 0, то проходим циклом по строчке, прверяя, найдется ли 1, если да - значит пункты достижимы через 1, меняет=м значение в симметричных (относительно главной диагонали) точках на 1 в временной матрице. Далее переносим все единицы из временной матрицы в матрицу достижимости. Выводим итоговую матрицу на экран.



### 5. Программа

```java
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
   public static Scanner in = new Scanner(System.in);
   public static PrintStream out = System.out;
   public static void main(String[] args) {
      out.println("Введите размер матрицы:");
      //вводим с клавиатуры размерность матрицы
      int size = in.nextInt();
      // создаем двумерный массив размером size x size
      int N [][]=new int [size][size];
      out.println("Введите элементы матрицы:");
      for (int i = 0 ; i < N.length ; i++)
         for (int j = 0 ; j < N[i].length ; j++)
            // вводим с клавиатуры каждый элемент массива
            N[i][j] = in.nextInt();

      //  с помощью циклов проходим по всем элементам массива
      //  выводим на экран, для наглядности, массив в форме матрицы
      out.println("1) Получившаяся матрица смежности графа:");
      for (int i = 0 ; i < N.length ; i++) {
         for (int j = 0 ; j < N[i].length ; j++)
            out.print(N[i][j] + " ");
         out.println();}

      // задаем переменную isEilerov типа boolean, чтобы проверить является ли граф эйлеровым
      boolean isEilerov = true;
      for (int i = 0 ; i < N.length ; i++) {
         // обнуляем к перед каждым входом во второй цикл
         int k = 0;
         for (int j = 0 ; j < N[i].length ; j++)
            k += N[i][j];
         if (k % 2 != 0 && k != 0)
            isEilerov = false;
         if (isEilerov == false)
            break;
      }
      out.println(" ");
      // выводим на экран является ли граф эйлеровым
      if (isEilerov==true)
         out.println("2) Граф, заданный матрицей, является эйлеровым");
      else
         out.println("2) Граф, заданный матрицей, НЕ является эйлеровым");

      out.println(" ");
      // находим и выводим степень каждой вершины графа
      for (int i = 0 ; i < N.length ; i++) {
         // обнуляем переменную степени для каждой новой строки
         int st = 0;
         for (int j = 0 ; j < N[i].length ; j++)
            st += N[i][j];
         out.print("Степень вершины "+ (i+1) + ": ");
         out.println(st);
      }
      out.println(" ");
      out.println("Рёбра графа:");
      // выводим список ребер графа
      for (int i = 0 ; i < N.length ; i++) {
         // второй цикл только по половине матрицы
         for (int j = i ; j < N[i].length ; j++) {
            // если значение в элементе 1, значит дорога между этими пунктами существует
            if (N[i][j]!=0)
               out.println((i+1) + "-"+ (j+1));
         }
      }

      // создаем двумерные массивы dost b dostTemp(временный) размером size x size (как изначальная матрица смежности)
      int dost [][] = new int [size][size];
      int dostTemp [][] = new int [size][size];
      for (int i = 0 ; i < dost.length ; i++) {
         for (int j = 0 ; j < dost[i].length ; j++) {
            // заполняем матрицу dost в соответствие с матрицой смежности, но проставляя 1 на главной диагонали
            if (i==j)
               dost[i][j]=1;
            else
               dost[i][j]=N[i][j];
            // заполняем временную матрицу достижимости нулями
            dostTemp[i][j] = 0;
         }
      }

      // с помощью двойного цикла проходя по всем элементам матрицы dost заполняем матрицу dostTemp единицами
      for (int rowNum = 0 ; rowNum < dost.length ; rowNum++) {
         for (int colNum = 0 ; colNum < dost.length ; colNum++){
            // если значение равно 0, то проверяем пересечение по строке
            if (dost[rowNum][colNum]==0){
               for (int j = 0 ; j < dost.length ; j++) {
                  // если в строке нашлась единица, и это не главная диагональ матрицы, то меняем в временной матрице значения на 1
                  // (это значит что вершина достижима через одну)
                  if (dost[j][colNum]==1 && j!=colNum && dost[rowNum][j] == 1) {
                     // меняем оба пересечения элементов (матрица симметрична относительно главной диагонали)
                     dostTemp[colNum][rowNum] = 1;
                     dostTemp[rowNum][colNum] = 1;
                     //выходим из цикла перебора в строке, когда первая такая связь нашлась
                     break;
                  }
               }
            }
         }
      }

      //копируем единицы из временной матрицы в матрицу достижимости
      for (int i = 0 ; i < dostTemp.length ; i++) {
         for (int j = 0 ; j < dostTemp[i].length ; j++) {
            if (dostTemp[i][j] == 1)
               dost[i][j]=1;
         }
      }

      out.println(" ");
      out.println("Матрица достижимости графа:");
      // выводим итоговую матрицу достижимости графа на экран
      for (int i = 0 ; i < dost.length ; i++) {
         for (int j = 0 ; j < dost[i].length ; j++)
            out.print(dost[i][j] + " ");
         out.println();
      }

   }
}
 
 
```

### 6. Анализ правильности решения

 

1. Тест  `1`:

    - **Input**:
        ``` 
        5
      0 0 1 0 1  0 0 1 1 0  1 1 0 0 0  0 1 0 0 0  1 0 0 0 0
        ```

    - **Output**:
        ```
         1) Получившаяся матрица смежности графа:
      0 0 1 0 1
      0 0 1 1 0
      1 1 0 0 0
      0 1 0 0 0
      1 0 0 0 0

      2) Граф, заданный матрицей, НЕ является эйлеровым

      Степень вершины 1: 2
      Степень вершины 2: 2
      Степень вершины 3: 2
      Степень вершины 4: 1
      Степень вершины 5: 1

      Рёбра графа:
      1-3
      1-5
      2-3
      2-4

      Матрица достижимости графа:
      1 1 1 0 1
      1 1 1 1 0
      1 1 1 1 1
      0 1 1 1 0
      1 0 1 0 1
      ```

2. Тест `2`:

    - **Input**:
        ```
        6
      0 1 1 0 0 0  1 0 1 0 0 0  1 1 0 0 0 0  0 0 0 0 1 1  0 0 0 1 0 1  0 0 0 1 1 0
        ```

    - **Output**:
        ```
        1) Получившаяся матрица смежности графа:
      0 1 1 0 0 0
      1 0 1 0 0 0
      1 1 0 0 0 0
      0 0 0 0 1 1
      0 0 0 1 0 1
      0 0 0 1 1 0
      
      2) Граф, заданный матрицей, является эйлеровым
      Степень вершины 1: 2
      Степень вершины 2: 2
      Степень вершины 3: 2
      Степень вершины 4: 2
      Степень вершины 5: 2
      Степень вершины 6: 2
      
      Рёбра графа:
      1-2
      1-3
      2-3
      4-5
      4-6
      5-6
      
      Матрица достижимости графа:
      1 1 1 0 0 0
      1 1 1 0 0 0
      1 1 1 0 0 0
      0 0 0 1 1 1
      0 0 0 1 1 1
      0 0 0 1 1 1

        ```

3. Тест на `3`:

    - **Input**:
        ```
        4
       0 1 1 1  1 0 0 0  1 0 0 0  1 0 0 0
        ```

    - **Output**:
        ```
         1) Получившаяся матрица смежности графа:
      0 1 1 1
      1 0 0 0
      1 0 0 0
      1 0 0 0

      2) Граф, заданный матрицей, НЕ является эйлеровым

      Степень вершины 1: 3
      Степень вершины 2: 1
      Степень вершины 3: 1
      Степень вершины 4: 1

      Рёбра графа:
      1-2
      1-3
      1-4

      Матрица достижимости графа:
      1 1 1 1
      1 1 1 1
      1 1 1 1
      1 1 1 1

        ```

  
