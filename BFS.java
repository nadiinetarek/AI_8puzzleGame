package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static HashSet<State> EXPLORED = new HashSet<>();
    public static Queue<State> BFSqueue = new LinkedList<>() ;
    public static Queue<State> NEIGHBORSB = new LinkedList <>();
    public static  int numberOfNodes=0;
    public static  int numberOfMoves=0;

    public static boolean  BFS_search(State start, String goal )
    {
        int positionx=0;
        BFSqueue.add(start);
        EXPLORED.add(start);
        start.depth=0;
        numberOfMoves++;

        while(! BFSqueue.isEmpty())
        {
            State state = BFSqueue.poll();
            numberOfNodes++;
            System.out.println(state.state);
            System.out.println(",,,,,,,,,,,,,,");
            if( state.state.equals(goal) ) {
                System.out.println("depth of tree:"+state.depth);
                return true;

            }

            else{
                positionx = state.state.indexOf('0');
                int depthNow = state.depth;
                successorsinBFS(state,positionx,depthNow);
            }
        }

        return false;
    }

    public static void successorsinBFS(State s, int p, int depth)
    {
        State newState ;
        TRANSITIONS t= new TRANSITIONS(s);

        newState=t.upTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORSB.add(newState);}
        newState=t.downTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORSB.add(newState);}
        newState=t.rightTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORSB.add(newState);}
        newState=t.leftTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORSB.add(newState);}
        while(!NEIGHBORSB.isEmpty())
        {
            State test;
            test=NEIGHBORSB.poll();
            System.out.println(test.state);
            if(BFSqueue.contains(test) || EXPLORED.contains(test))
            {continue;}
            if(!BFSqueue.contains(test) && !EXPLORED.contains(test)  )
            {
                BFSqueue.add(test);
                EXPLORED.add(test);
                numberOfMoves++;
            }

        }
        System.out.println(",,,,,,,,,,,,,,");

    }




}
