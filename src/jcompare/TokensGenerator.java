/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

/**
 *
 * @author kareem
 */
public class TokensGenerator {
    public static int getchar(String x) {
        int ccr = 0;

        char[] st = x.toCharArray();
       // System.out.println(st[0]);
        for (int i = 0; i < st.length; i++) {
            ccr = ((char) ((ccr >> 8) | ccr << 8));
         //   System.out.println("a : " + ccr);
            ccr = ccr ^ st[i];
           // System.out.println("b : " + ccr);
            ccr ^= ((char) (ccr & 0xff) >> 4);
            //System.out.println("b : " + ccr);
            ccr ^= (ccr << 8) << 4;
            //System.out.println("c : " + ccr);
            ccr ^= ((ccr & 0xff) << 4) << 1;
           // System.out.println("d : " + ccr);
        }

        return ccr & 0xffff;
    }
    
}
