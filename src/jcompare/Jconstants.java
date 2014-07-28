/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author kareem
 */
public class Jconstants {
    
    //Table for all of Java Reservered Words
    private static Hashtable<String,Integer> reserverdWord;
    //List of all Java Arthimatic, Logical, .... operators and signs
    private static ArrayList<Character> signs;
    
    public Jconstants(){
   
        signs = new ArrayList<Character>();
//        signs.add("+");
//        signs.add("--");
//        signs.add("&&");
//        signs.add("||");
//        signs.add("+=");
        signs.add('+');
//        signs.add("-=");
        signs.add('-');
//        signs.add("*=");
        signs.add('*');
//        signs.add("/=");
        signs.add('/');
//        signs.add("%=");
//        signs.add("&=");
//        signs.add("|=");
//        signs.add("^=");
//        signs.add("==");
//        signs.add("!=");
//        signs.add("<=");
//        signs.add(">=");
//        signs.add("<<");
//        signs.add(">>");
//        signs.add("<<=");
//        signs.add(">>=");
//        signs.add(">>>");
//        signs.add(">>>=");
        signs.add('(');
        signs.add(')');
        signs.add('{');
        signs.add('}');
        signs.add('[');
        signs.add(']');
        signs.add('&');
        signs.add(',');
        signs.add(';');
        signs.add('<');
        signs.add('=');
        signs.add('>');
        signs.add('?');
        signs.add('!');
        signs.add(':');
        signs.add('.');
        signs.add('%');
        signs.add('^');
        signs.add('|');
        signs.add('~');
        signs.add((char)92);
        //signs.add((char)13);
        //signs.add((char)10);
        //signs.add("/*");
        //signs.add("//");
        //signs.add("*/");
        
        reserverdWord = new Hashtable<String, Integer>();
        reserverdWord.put("assert", 35287);
        reserverdWord.put("abstract", 36807);
        reserverdWord.put("boolean", 63393);
        reserverdWord.put("break", 58667);
        reserverdWord.put("byte", 6398);
        reserverdWord.put("case", 6175);
        reserverdWord.put("catch", 62250);
        reserverdWord.put("char", 54282);
        reserverdWord.put("class", 9933);
        reserverdWord.put("const", 36007);
        reserverdWord.put("continue", 49602);
        reserverdWord.put("default", 39750);
        reserverdWord.put("do", 24231);
        reserverdWord.put("double", 25612);
        reserverdWord.put("else", 62544);
        reserverdWord.put("extends", 58692);
        reserverdWord.put("enum", 56154);
        reserverdWord.put("final", 23179);
        reserverdWord.put("finally", 15485);
        reserverdWord.put("float", 43941);
        reserverdWord.put("for", 11980);
        reserverdWord.put("goto", 14772);
        reserverdWord.put("if", 48594);
        reserverdWord.put("implements", 42605);
        reserverdWord.put("import", 59249);
        reserverdWord.put("instanceof", 35158);
        reserverdWord.put("int", 13004);
        reserverdWord.put("interface", 7390);
        reserverdWord.put("long", 44340);
        reserverdWord.put("native", 21131);
        reserverdWord.put("new", 53763);
        reserverdWord.put("null", 10653);
        reserverdWord.put("package", 7356);
        reserverdWord.put("private", 17314);
        reserverdWord.put("protected", 37927);
        reserverdWord.put("public", 60161);
        reserverdWord.put("return", 9948);
        reserverdWord.put("short", 41014);
        reserverdWord.put("static", 31800);
        reserverdWord.put("strictfp", 56162);
        reserverdWord.put("super", 55666);
        reserverdWord.put("switch", 29672);
        reserverdWord.put("synchronized", 37717);
        reserverdWord.put("this", 46476);
        reserverdWord.put("throw", 35158);
        reserverdWord.put("throws", 45397);
        reserverdWord.put("transient", 55104);
        reserverdWord.put("try", 61897);
        reserverdWord.put("void", 48485);
        reserverdWord.put("volatile", 28265);
        reserverdWord.put("while", 60856);
       
    }

    public Hashtable<String, Integer> getReserverdWord() {
        return reserverdWord;
    }

    public ArrayList<Character> getSigns() {
        return signs;
    }

    public int isReserveredWord(String word){
        
        int code = 0;
        if(reserverdWord.containsKey(word))
            return reserverdWord.get(word);
        return code;
    }
    public boolean isSpecialChar(char ch){
        
        if(signs.contains(ch))
            return true;
        
        return false;
    } 
    
}
