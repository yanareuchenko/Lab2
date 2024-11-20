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