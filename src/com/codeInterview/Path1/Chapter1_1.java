package com.codeInterview.Path1;

import com.offer.APathBase;
import java.util.Stack;

/*
【题目】实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
【要求】1．pop、push、getMin操作的时间复杂度都是O(1)。
2．设计的栈类型可以使用现成的栈结构。
*/
public class Chapter1_1 extends APathBase {

    @Override
    public void Start() {
        int[] arrays = new int[]{3,4,5,1,2,1};
        
        MyStack1 myStack1 = new MyStack1();
        for (int array : arrays) {
            myStack1.push(array);
        }
        for (int i = 0; i < arrays.length; i++) {
            print(myStack1.pop());
        }
    }
}

class MyStack1{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    
    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }
    
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }
}
