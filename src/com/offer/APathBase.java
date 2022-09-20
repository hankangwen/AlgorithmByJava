package com.offer;

public abstract class APathBase {
    public APathBase(){
        System.out.println("Class Name is " + this.getClass().getName());
        Start();
    }

    public abstract void Start();
}
