package Lesson_3.task_1;

import Lesson_3.task_1.TransposeString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputString = reader.readLine();
            System.out.println(new TransposeString(inputString).transpose());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
