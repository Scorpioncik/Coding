package com.udemy.list.linked;

public interface List<T> {
    void insert(T data);

    void remove(T data);

    void traverseList();

    int size ();

    void reverseIter();

    void reverseRec();
}
