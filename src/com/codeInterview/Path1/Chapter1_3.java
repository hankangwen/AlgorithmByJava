package com.codeInterview.Path1;

import com.offer.APathBase;

import java.util.Stack;

/*如何仅用递归函数和栈操作逆序一个栈
【题目】一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，
但是只能用递归函数来实现，不能用其他数据结构。
【要求】
*/
public class Chapter1_3 extends APathBase {

    @Override
    public void Start() {
        Stack<Integer> stack = new Stack<Integer>();
        int[] array = {1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        print(stack);
        reverse(stack);
        print(stack);
    }

    private void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    private int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}