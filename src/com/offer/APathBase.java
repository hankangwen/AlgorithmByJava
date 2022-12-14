package com.offer;

import java.util.List;
import java.util.Stack;

public abstract class APathBase {
    public APathBase(){
        System.out.println("Class Name is " + this.getClass().getName());
        Start();
    }

    public abstract void Start();

    protected void print(int result){
        System.out.println(result);
    }

    protected void print(String result){
        System.out.println(result);
    }

    protected void print(int[] array){
        System.out.print("[ ");
        for (int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println(" ]");
    }

    protected void print(List<List<Integer>> result){
        for (List<Integer> list : result) {
            System.out.print("[ ");
            for (int j = 0; j < list.size() - 1; j++) {
                System.out.print(list.get(j) + ", ");
            }
            System.out.print(list.get(list.size() - 1));
            System.out.println(" ]");
        }
    }

    protected void print(Stack<Integer> stack){
        System.out.print("[ ");
        for (int i = stack.size()-1; i >= 0; i--) {
            int value = stack.get(i);
            System.out.print(value + ", ");
        }
        System.out.println(" ]");
    }
}
