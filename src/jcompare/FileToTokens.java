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

    public String convertFileToTokens(String fileName) {

        Jconstants constant = new Jconstants();
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isLineComment = false;
        boolean isMultiLinesComment = false;
        BufferedReader reader = null;
        try {
            char c = '\n';
            char ch;
            //File file = new File(fileName);
            reader = new BufferedReader(new FileReader(fileName));
            int st;
            while ((st = reader.read()) != -1) {
                ch = (char) st;

                /*
                 * Comments Part
                 */
                //Check if a comment begin
                if (ch == '/' && !isMultiLinesComment && !isLineComment) {
                    builder.append(ch);
                    ch = (char) (reader.read());
                    if (ch == '/') {
                        isLineComment = true;
                        builder.append(ch);
                        ch = (char) reader.read();
                    } else if (ch == '*') {
                        isMultiLinesComment = true;
                        builder.append(ch);
                        ch = (char) reader.read();
                    }
                }

                //Handeling Comments
                if (isLineComment && (ch == '\n' || ch == '\r')) {
                    builder.append(ch);
                    isLineComment = false;
                } else if (isMultiLinesComment && (ch == '*')) {
                    builder.append(ch);
                    ch = (char) (reader.read());
                    if (ch == '/') {
                        isMultiLinesComment = false;
                        builder.append(ch);
                    } else {
                        builder.append(ch);
                    }
                } else if ((isLineComment) && ch != '\n' && ch != '\r') {
                    builder.append(ch);
                } else if (isMultiLinesComment && ch != '*' && ch != '\r') {
                    builder.append(ch);
                }

                /*
                 * Tokens Part 
                 */
                
                //Writing Tokens
                if (!isLineComment && !isMultiLinesComment) {
                    if (!constant.isSpecialChar(ch) && ch != ' ' && ch != 13 && ch != '\n') {
                        temp.append(ch);
                    } else if (temp.length() > 0 && ch != 13 && (ch == ' ' || constant.isSpecialChar(ch))) {

                        int token = constant.isReserveredWord(temp.toString());
                        if (token != 0) {
                            System.out.println(temp.toString() + constant.isReserveredWord(temp.toString()));
                            builder.append(token);
                        } else {
                            token = TokensGenerator.getchar(temp.toString());
                            builder.append(token);
                        }
                        temp.delete(0, temp.length());
                    }
                }

                //Writing White spaces and new lines
                if (!isLineComment && !isMultiLinesComment && (ch == '\n' || ch == ' ' || constant.isSpecialChar(ch))) {
                    builder.append(ch);
                }

//                if((char)st == '\n')
//
//                if((char)st ==' ')
//                   
            }
            //System.out.println(builder);
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
