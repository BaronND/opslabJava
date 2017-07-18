package JavaSE.collection.stack;

import java.util.Stack;

public class stackDemo {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");

        //当前内容为
        for (String temp : stack) {
            System.out.print(temp + "\t");
        }

        System.out.print("\n栈顶元素为:" + stack.peek());
        System.out.println("\n数序输出栈");
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pop());
        }
    }

}
