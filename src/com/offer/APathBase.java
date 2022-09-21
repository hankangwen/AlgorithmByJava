package com.offer;

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
}
