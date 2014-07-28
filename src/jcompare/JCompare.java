/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

import javax.swing.JOptionPane;

/**
 *
 * @author kareem
 */
public class JCompare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String st= new FileToTokens().convertFileToTokens("Monitor.java");
        //String st= new FileToTokens().convertFileToTokens("/home/kareem/NetBeansProjects/JCompare/src/jcompare/Item.java");

        System.out.println(st);
        //System.out.println(new Jconstants().isReserveredWord("while"));
        //System.out.println(new Jconstants().isSpecialChar('*'));
    }
    
}
