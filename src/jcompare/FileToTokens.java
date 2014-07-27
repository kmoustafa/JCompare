/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jcompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kareem
 */
public class FileToTokens {
    
    
    public String convertFileToTokens(String fileName){
        
        StringBuilder builder = new StringBuilder();
        
        BufferedReader reader = null;
        try {
            //File file = new File(fileName);
            reader = new BufferedReader(new FileReader(fileName));
            int st ;
            while((st = reader.read()) != -1){
                builder.append((char)st);
            }
            return builder.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileToTokens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileToTokens.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FileToTokens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
