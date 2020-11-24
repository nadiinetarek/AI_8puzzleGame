package com.company;
import java.lang.*;
import java.util.Scanner;


public class TRANSWCOST {
   // double cost;
    State start ;
    String goal = "012345678";
    State previousState;
    int numberofNodes;
    int heur_type;

    public TRANSWCOST(State s ,State prev, int n,int h) {
        this.start=s;
     //   this.start.hn = getHeuristics();
     //   this.start.gn=prev.gn +1;
        this.numberofNodes=n;
        this.previousState=prev;
        this.heur_type=h;
    }


    public double getHeuristics(String temp,int h)
    {
     int manh = manhattan(temp);
     double eucl = euclidian(temp);
     double heuristic=0;
     if (h==1)
         heuristic=manh;
     if (h==2)
         heuristic=eucl;
     /*if ((gn+manh)<(gn+eucl))
       heuristic=manh+gn;
     else if((gn+manh)>(gn+eucl))
    heuristic=eucl+gn;*/


       return heuristic;
    }

    public double getHeuristicsForRoot(State root)
    {
        int manh = manhattan(root.state);
        double eucl = euclidian(root.state);
        double heuristic=0;
        double gn=root.gn;
        if ((gn+manh)<(gn+eucl))
        {
            heuristic=manh+gn;
        }
        else if((gn+manh)>(gn+eucl))
        {
            heuristic=eucl+gn;
        }
        return heuristic;
    }


    public static int manhattan(String start) {
        int manhattan = 0;
        int x_pos=0;
        int y_pos =0;
        int zeroPosition = start.indexOf('0');

        switch (zeroPosition)
        {
            case 0:
            {  x_pos = 0;
             y_pos =0;}
            break;
            case 1:
            {  x_pos = 1;
                y_pos =0;}
            break;
            case 2:
            {  x_pos = 2;
                y_pos =0;}
            break;
            case 3:
            {  x_pos = 0;
                y_pos =1;}
            break;
            case 4:
            {  x_pos = 1;
                y_pos =1;}
                break;
            case 5:
            {  x_pos = 2;
                y_pos =1;}
                break;
            case 6:
            {  x_pos = 0;
                y_pos =2;}
                break;
            case 7:
            {  x_pos = 1;
                y_pos =2;}
                break;
            case 8:
            {  x_pos = 2;
                y_pos =2;}
                break;
        }
            manhattan=Math.abs(x_pos-0)+Math.abs(y_pos-0);
        return manhattan;
    }

    public static double euclidian(String start) {
        double euclidian = 0;

        int x_pos=0;
        int y_pos =0;
        int zeroPosition = start.indexOf('0');
        double term1 =0;
        double term2 =0;

        switch (zeroPosition)
        {
            case 0:
            {  x_pos = 0;
                y_pos =0;}
            break;
            case 1:
            {  x_pos = 1;
                y_pos =0;}
            break;
            case 2:
            {  x_pos = 2;
                y_pos =0;}
            break;
            case 3:
            {  x_pos = 0;
                y_pos =1;}
            break;
            case 4:
            {  x_pos = 1;
                y_pos =1;}
            break;
            case 5:
            {  x_pos = 2;
                y_pos =1;}
            break;
            case 6:
            {  x_pos = 0;
                y_pos =2;}
            break;
            case 7:
            {  x_pos = 1;
                y_pos =2;}
            break;
            case 8:
            {  x_pos = 2;
                y_pos =2;}
            break;
        }
        term1=Math.pow((x_pos-0),2);
        term2=Math.pow((y_pos-0),2);
        euclidian=Math.sqrt(term1+term2);
   return euclidian;
    }


    public State upTransition(String s, int p, int depth)
    {
        String string =s;
        int y;
        if(p>3)
        {   y = p-3;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String one = string.substring(0,y);
            String two = string.substring(y+1,p);
            String three = string.substring(p+1);
            string =  one + a+ two + b + three;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }

        if (p==3)
        {
            y = p-3;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String two = string.substring(y+1,p);
            String three = string.substring(p+1);
            string=  a+ two + b + three;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }
        return null;

    }

    public  State downTransition(String s, int p, int depth) {
        String string = s;
        int y;
        if (p < 5) {
            y = p + 3;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String one = string.substring(0, p);
            String two = string.substring(p + 1, y);
            String three = string.substring(y + 1);
            string = one + b + two + a + three;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }

        if (p == 5) {
            y = p + 3;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String one = string.substring(0, p);
            String two = string.substring(p + 1, y);
            String three = string.substring(y + 1);
            string = one + b + two + a + three;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }

        return null;

    }


    public  State rightTransition(String s, int p, int depth)
    {
        String string =s;

        int y;
        if(p != 2 && p != 5 && p!=8)
        {   y = p+1;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String one = string.substring(0,p);
            String two = string.substring(y+1);
            string =  one + b+ a + two;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }

        return null ;
    }

    public  State leftTransition(String s, int p,int depth)
    {
        String string = s;
        int y;
        if(p != 0 && p != 3 && p!=6)
        {   y = p-1;
            char a = string.charAt(p);
            char b = string.charAt(y);
            String one = string.substring(0,y);
            String two = string.substring(p+1) ;
            string =  one + a + b + two;
            State result=new State(string);
            result.gn=this.previousState.gn+1;
            result.hn=getHeuristics(string,heur_type);
            result.depth=depth+1;
            return result;
        }

        return null;
    }




}


