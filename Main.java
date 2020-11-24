package com.company;
import java.util.*;
import java.io.*;


public class Main {




    public static void main(String[] args) {

        String start = "312408657" ;
        String goal =  "012345678" ;

        boolean answerD = false;
        boolean answerB = false;
        boolean answerA = false;

        Scanner choise = new Scanner(System.in);

        System.out.println("1-BFS search 2-DFS search   3-A-star");
        int choose =choise.nextInt();
        State st = new State(start);
        switch (choose) {
            case 1:
                BFS b = new BFS();
                answerB = b.BFS_search(st, goal);
                if (answerB) {
                    System.out.println("SUCESS_BFS");
                    System.out.println("Number of nodes traversed(cost):"+b.numberOfNodes);
                    System.out.println("Number of movements:"+b.numberOfMoves);

                }
                 break;

            case 2:
                DFS d = new DFS();
                answerD = d.DFS_search(st, goal);
                   if (answerD) {
                   System.out.println("SUCESS_DFS");
                   System.out.println("Number of nodes traversed(cost):"+d.numberOfNodes);
                   System.out.println("Number of movements:"+d.numberOfMoves);
                   }
                    break;


            case 3 :

                System.out.println("choose 1-manhattan  2-euclidian");
                Scanner ch = new Scanner(System.in);
                int heu = ch.nextInt();
                A_star a = new A_star(heu);
                answerA = a.A_star_search(st,goal);

                if (answerA) {
                    System.out.println("SUCESS_A_star");
                    System.out.println("Number of nodes traversed(cost):"+a.numberOfNodes);
                    System.out.println("Number of movements:"+a.numberOfMoves);
                }
                break;





        }
        
    }
}

