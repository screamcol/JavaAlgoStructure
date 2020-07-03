package Lesson_2;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set (int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    // homework
    // insert(index, value);
    // delete(val);
    // delete(index);
    // deleteAll();

    /**
     * Homework insert
     * @param index
     * @param value
     */
    public void insert(int index, int value) {
        if (index == arr.length || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        if (size >= arr.length) {
            increaseCapacity();
        }
        int[] temp = arr.clone();
        arr[index] = value;
        if (index != size) System.arraycopy(temp, index, arr, index + 1, size - index);
        ++size;
    }

    /**
     * Homework delete value
     * @param value
     */
    public void deleteVal(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        int index = find(value);
        if (index == -1) System.out.println("such element wasn't found");
        else if (index == size - 1) deleteLast();
        else {
            int[] temp = arr.clone();
            if (index != size) System.arraycopy(temp, index + 1, arr, index, size - index);
            --size;
        }
    }

    /**
     * Homework delete index
     * @param index
     */
    public void deleteIndex(int index) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index);
        else if (index == size - 1) deleteLast();
        else {
            int[] temp = arr.clone();
            if (index != size) System.arraycopy(temp, index + 1, arr, index, size - index);
            --size;
        }
    }

    /**
     * Homework delete all
     */
    public void deleteAll() {
        size = 0;
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Добавил переменную temp которая увеличивается во внутреннем цикле. Если она не увличилась за 1 проход внешнего цикла, значит массив уже отсортирован.
     * Основная идея заключалась в том, что внешнией цикл всегда проходил все элементы массива (т.е. совершал итераций равный количеству элементов массива).
     * Чтобы избавиться от этого, ведь зачастую сортировка происходит намного раньше и массив просто так по уже отсортированному массиву не бегал,
     * была и введена эта переменная. По факту, на сколько я могу судить, алгоритм остается сложностью O(n^2), однаком лучший вариант будет W(n) - омега большое.
     */
    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            int temp = 0;
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    temp++;
                }
            }
            if (temp == 0) return;
        }
        isSorted = true;
    }

    // O(n^2) сложность. Есть 2 цикла, оба проходят по всему массиву и внутренний цикл находит минимальный элемент, а внешний формирует отсортированный массив
    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
    }

    // Здесь также сложность O(n^2), поскольку есть 2 цикла, внешний цикл проходит по всему массиву, внутренний за 1 итерацию внешнего проходит часть массива. Таким образом в самом худшем случае при последней итерации
    // внешнего цикла внутренний цикл будет проходить по всему массиву чтобы последний элемент переместить на 1 позицию.
    public void sortInsert() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }

    public void sortCount() {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < size; i++) {
             min = arr[i] < min ? arr[i] : min;
             max = arr[i] > max ? arr[i] : max;
        }
        int[] temp;
        if (min < 0) {
            temp = new int[Math.abs(min) + max + 1];
        } else temp = new int[max + 1];

        for (int i = 0; i < size ; i++) {
            if (min < 0) {
                temp[arr[i] + Math.abs(min)] = temp[arr[i] +  Math.abs(min)] + 1;
            } else {
                temp[arr[i]] = temp[arr[i]] + 1;
            }
        }

        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }

        int[] outputArr = new int[temp[temp.length - 1]];

        for (int i = 0; i < outputArr.length; i++) {
            if (min < 0) {
                int cell = temp[arr[i] +  Math.abs(min)];
                outputArr[cell-1] = arr[i];
            } else {
                int cell = temp[arr[i]] - 1;
                outputArr[cell] = arr[i];
            }
        }
        arr = outputArr;
    }
}

