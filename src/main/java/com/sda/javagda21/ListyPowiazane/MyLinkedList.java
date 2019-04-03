package com.sda.javagda21.ListyPowiazane;

import lombok.Data;

@Data
public class MyLinkedList<T> {
    private MyNode<T> head;

    public MyLinkedList(MyNode<T> head) {
        this.head = head;
    }

    public void dodanieNowegoElementu(T value) {

        MyNode<T> nowyNode = new MyNode<T>(value, null);
        MyNode<T> candidate = head;

        if (head == null) {
            head = nowyNode;
        } else {
            while (candidate.getNext() != null)
                candidate = candidate.getNext();
        }
        candidate.setNext(nowyNode);

//        } else {
//            MyNode<T> koniecListy = znajdzKoniecListy(head);
//            koniecListy.setNext(nowyNode);
//        }

    }

    private MyNode<T> znajdzKoniecListy(MyNode<T> candidate) {
        if (candidate.getNext() != null) {
            return znajdzKoniecListy(candidate.getNext());
        }
        return candidate;
    }

    public void odczytajPierwszyElementZListy() {
        System.out.println(head.getData());
    }

    public void odczytajDowolnyElementZListy(int licznik) {
//        MyNode<T> candidate = head;
//
//        for (int j = 0; j < licznik; j++) {
//            if (candidate.getNext() == null) {
//                System.out.println("Nie ma tylu elementów");
//                return;
//            } else {
//                candidate = candidate.getNext();
//            }
//        }

        MyNode candidate = znajdzItyElement(licznik);

        System.out.print(candidate.getData());
    }

    public void dodajElementDoPoczatkuListy (T value){

//        MyNode <T> temp = head;
        MyNode <T> nowyElement = new MyNode<T>(value, head);
        head = nowyElement;
    }

    public MyNode <T> znajdzItyElement (int licznik){
        MyNode<T> candidate = head;

        for (int j = 0; j < licznik; j++) {
            if (candidate.getNext() == null) {
                System.out.print("Nie ma tylu elementów, ale ostatni element to: ");
                break;
            } else {
                candidate = candidate.getNext();
            }
        }

        return candidate;
    }

    public void usunItyElementZListy (int licznik) {
        MyNode<T> nodeWczesniejszy = znajdzItyElement(licznik -1);

        nodeWczesniejszy.setNext(nodeWczesniejszy.getNext().getNext());
    }

    public void dodajElementWIteMiejsceWLiscie (int licznik, T value){
        MyNode<T> szukanyElement = znajdzItyElement(licznik);
        MyNode <T> nowyElement = new MyNode<T>(value, null);
        MyNode <T> temp = szukanyElement.getNext();

        nowyElement.setNext(temp);
        szukanyElement.setNext(nowyElement);
    }
}
