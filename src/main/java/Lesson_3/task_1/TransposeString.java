package Lesson_3.task_1;

public class TransposeString {
    String inputString;

    public TransposeString(String inputString) {
        this.inputString = inputString;
    }

    public String transpose() {
        int size =  inputString.length();
        Stack stack = new Stack(size);
        for (int i = 0; i < size; i++) {
            stack.push(inputString.charAt(i));
        }
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
