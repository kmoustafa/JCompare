/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

import java.text.NumberFormat;
import java.text.ParsePosition;
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
        
        String st= new FileToTokens().convertFileToTokens("/home/kareem/NetBeansProjects/JCompare/src/jcompare/Monitor.java");
        //String st= new FileToTokens().convertFileToTokens("/home/kareem/NetBeansProjects/JCompare/src/jcompare/Item.java");
        
        /*
        Just for Testing and see the string in large line
        */
        JOptionPane.showMessageDialog(null, st);
   
    }
     
}
