package com.company;

import java.util.*;

public class A_star {
    public static HashSet<State> SOLUTION = new HashSet<State>();
    public static PriorityQueue<State> A_STAR = new PriorityQueue<State>() ;
    public static Queue<State> NEIGHBORSA = new LinkedList<>();
    public static  int numberOfNodes=0;
    public static  int numberOfMoves=0;
    public static  int heu_type;


    public A_star(int h) {
        this.heu_type=h;
    }

    static abstract class The_Comparator implements Comparator<Double> {
        public double compare(double one, double two)
        {

            return Double.compare(one,two);
        }
    }

    public static boolean  A_star_search(State start, String goal ) {
        int positionx=0;
        A_STAR.add(start);
        SOLUTION.add(start);
        numberOfMoves++;
        start.depth=0;
        start.gn=0;
        TRANSWCOST trial = new TRANSWCOST(start,null,0,heu_type) ;
        start.hn=trial.getHeuristicsForRoot(start);

        while (!A_STAR.isEmpty()) {
            State state = A_STAR.poll();
            numberOfNodes++;
            System.out.println(state.state);
            System.out.println(",,,,,,,,,,,,,,");
            if (state.state.equals(goal)) {
                System.out.println("depth of tree:"+state.depth);
                return true;

            }
            else  {
                positionx =state.state.indexOf('0');
                int depthNow = state.depth;
                successorsinA_STAR(state,positionx,numberOfNodes,depthNow);

            }
        }
        return  false;

    }

   public static void successorsinA_STAR(State s, int p,int n,int depth) {
       State newState;
       TRANSWCOST c= new TRANSWCOST(s,s,n,heu_type);
       newState = c.upTransition(s.state, p,depth);
       if (newState != null) {
           NEIGHBORSA.add(newState);
       }
      newState = c.downTransition(s.state, p,depth);
       if (newState != null) {
           NEIGHBORSA.add(newState);
       }
       newState = c.rightTransition(s.state, p,depth);
       if (newState != null) {
           NEIGHBORSA.add(newState);
       }
     newState =c.leftTransition(s.state, p,depth);
       if (newState != null) {
           NEIGHBORSA.add(newState);
       }
       while (!NEIGHBORSA.isEmpty()) {
          State test;
           test = NEIGHBORSA.poll();
           System.out.println(test.state);

            if(!SOLUTION.contains(test) && !A_STAR.contains(test))
           {
               A_STAR.add(test);
               SOLUTION.add(test);
               numberOfMoves++;
           }

           else {continue;}

       }
   }


}
