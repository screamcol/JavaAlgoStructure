package Lesson_1;

public class Main {
    public static void main(String[] args) {
        System.out.println(binaryInvolution(2, 6));
        int[] array = {1, 5, 7, -2, 0};
        System.out.println(minElement(array));
        System.out.println(arithmeticalMean(array));
    }

    // используется бинарное возведение в степень. За счет битового сдвига вправо каждый раз степень (power) уменьшается ровно наполовину.
    // Таким образов сложность алгоритма составляет O(logn)
    static int binaryInvolution(int number, int power) {
        int res = 1;
        while (power > 0)
            if (power % 2 == 1) {
                res *= number;
                --power;
            }
            else {
                number *= number;
                power >>= 1;
            }
        return res;
    }

    // Нахождение минимального элемента в массиве. Сложность O(n). Каждая операция считает 1 элемент. Чтобы пройти по всему массиву, нужно перебрать каждый элемент.
    // По факту здесь используется больше чем 1 операция, например взять элемент из массива и просвоить переменной min, затем каждый элемент взять из массива и присвоить переменной i
    // сделать проверку. Получается O(n + k), но k модно принебречь.
    static int minElement(int[] array) {
        int min = array[0];
        for (int i : array) {
            min = i < min ? i : min;
        }
        return min;
    }

    // Нахождение среднего арифметического. Сложность O(n + k). Перебирается каждый элемент массива и в самом массиве производится действие по суммированию. Так как k можно опустить, то получается O(n).
    static double arithmeticalMean(int[] array) {
        double sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }

}
