package com.company;

public class TRANSITIONS {

      State now ;

    public TRANSITIONS(State now) {
        this.now = now;
    }

    public static State upTransition(String s, int p, int depth)
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
            result.depth=depth+1;
            return result;
        }
        return null;

    }

    public static State downTransition(String s, int p,int depth) {
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
            result.depth=depth+1;
            return result;
        }

        return null;

    }


    public static State rightTransition(String s, int p,int depth)
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
            result.depth=depth+1;
            return result;
        }

        return null ;
    }

    public static State leftTransition(String s, int p,int depth)
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
            result.depth=depth+1;
            return result;
        }

        return null;
    }


}
