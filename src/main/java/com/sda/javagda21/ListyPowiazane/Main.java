package com.sda.javagda21.ListyPowiazane;

public class Main {

    public static void main(String[] args) {

        MyNode<String> nodeA = new MyNode<String>("A", null);
        MyNode<String> nodeP = new MyNode<String>("P", nodeA);
        MyNode<String> nodeU = new MyNode<String>("U", nodeP);
        MyNode<String> nodeD = new MyNode<String>("D", nodeU);

        MyLinkedList<String> zlinkowanaLista = new MyLinkedList<String>(nodeD);
        System.out.println(zlinkowanaLista);

        zlinkowanaLista.dodanieNowegoElementu("G");
        System.out.println(zlinkowanaLista);
        System.out.println();

        zlinkowanaLista.odczytajPierwszyElementZListy();
        System.out.println();

        zlinkowanaLista.odczytajDowolnyElementZListy(5);
        System.out.println();

        zlinkowanaLista.dodajElementDoPoczatkuListy("Z");
        System.out.println(zlinkowanaLista);
        System.out.println();

        zlinkowanaLista.usunItyElementZListy(2);
        System.out.println(zlinkowanaLista);
        System.out.println();

        zlinkowanaLista.dodajElementWIteMiejsceWLiscie(0, "X");
        System.out.println(zlinkowanaLista);
        System.out.println();

        for (int i = 0; i <5 ; i++) {
            zlinkowanaLista.odczytajDowolnyElementZListy(i);
        }
        System.out.println();



    }
}
