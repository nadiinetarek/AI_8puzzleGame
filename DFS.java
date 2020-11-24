package com.company;

import javax.management.StandardEmitterMBean;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static HashSet<State> PATH = new HashSet<>();
    public static Stack<State> frontier = new Stack<State>();
    public static Queue<State> NEIGHBORS = new LinkedList<>();
    public static  int numberOfNodes=0;
    public static  int numberOfMoves=0;


    public  static boolean DFS_search(State start, String goal)
    {
        int positionx=0;
        PATH.add(start);
        frontier.push(start);
        start.depth=0;
        numberOfMoves++;

        while(! frontier.isEmpty()) {

            State state = frontier.pop();
            numberOfNodes++;
            System.out.println(state.state);
            System.out.println(",,,,,,,,,,,,,,");

            if( state.state.equals(goal) ) {
                System.out.println("depth of tree:"+state.depth);
                return true;
            } else
                positionx = state.state.indexOf('0');
            int depthNow = state.depth;
             successorsinDFS(state, positionx,depthNow);

        }
        return false;
    }
    public static void successorsinDFS(State s, int p,int depth)
    {
        State newState;
       TRANSITIONS t= new TRANSITIONS(s);

        newState=t.upTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORS.add(newState);}
        newState=t.downTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORS.add(newState);}
        newState=t.rightTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORS.add(newState);}
        newState=t.leftTransition(s.state,p,depth);
        if(newState!=null)
        { NEIGHBORS.add(newState);}
        while(!NEIGHBORS.isEmpty())
        {
            State test;
            test=NEIGHBORS.poll();
            System.out.println(test.state);

            if( PATH.contains(test) || frontier.contains(test))
            {
            }
            else if(!PATH.contains(test) && !frontier.contains(test))
            {
                frontier.push(test);
                PATH.add(test);
                numberOfMoves++;
            }


        } System.out.println(",,,,,,,,,,,");
    }
       }



