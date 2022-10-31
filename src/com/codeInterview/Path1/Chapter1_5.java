package com.codeInterview.Path1;
import com.offer.APathBase;
import java.util.Stack;

/*
【题目】用一个栈实现另一个栈的排序
【要求】
一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
如何完成排序？
*/
public class Chapter1_5 extends APathBase {

    @Override
    public void Start() {
        Stack<Integer> stack = new Stack<Integer>();
        int[] array = {8,5,2,9,6,3,7,4,1};
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        print(stack);
        sortStackByStack(stack);
        print(stack);
    }

    void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty()&&help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}