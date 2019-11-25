package com.udemy.list.linked;

public class App {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.insert("Test1");
        list.insert("Test2");
        list.insert("Test3");
        list.insert("Test4");

        list.traverseList();
    }
}
