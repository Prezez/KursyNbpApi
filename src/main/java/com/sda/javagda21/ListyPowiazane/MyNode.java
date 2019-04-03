package com.sda.javagda21.ListyPowiazane;


import lombok.Data;

@Data
public class MyNode <T> {

    private T data;
    private MyNode <T> next;

    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
