package com.codeInterview.Path1;

import com.offer.APathBase;

import java.util.Stack;

/*由两个栈组成的队列
【题目】编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
【要求】
*/
public class Chapter1_2 extends APathBase {

    @Override
    public void Start() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        print(queue.poll());
        print(queue.poll());
        queue.add(5);
        queue.add(6);
        queue.add(7);
        print(queue.poll());
        print(queue.poll());
        print(queue.poll());
        print(queue.poll());
        print(queue.poll());
    }
}

class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    // push栈向pop栈倒入数据
    private void pushToPop(){
        if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }

    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }
}