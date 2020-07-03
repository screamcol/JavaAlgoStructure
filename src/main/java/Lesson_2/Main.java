package Lesson_2;

public class Main {
    public static void main(String[] args) {
        int[] arr; // int arr[]
        arr = new int[5];
        int[] arr2 = {1, 2, 3, 4};

        Array array1 = new Array(1,2,3);
        Array array2 = new Array(5);
        array2.append(1);
        array2.append(2);
        array2.append(3);
        array2.append(4);
//        array2.insert(4, 25);
//        array1.insert(-1, 36);

//        array2.deleteVal(2);
//        array1.deleteVal(1);

//        array2.deleteIndex(1);
//        array1.deleteIndex(0);

//        array1.deleteAll();
//        array2.deleteAll();

//        System.out.println(array1.get(0));
//        System.out.println(array1.length());
//        System.out.println(array1);
        Array a0 = new Array(-2, -5, -3, 2, 1, 3, 4);
        a0.sortCount();
        System.out.println(a0);
    }
}
