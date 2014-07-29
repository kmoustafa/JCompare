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
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kareem
 */
public class FileToTokens {

    public String convertFileToTokens(String fileName) {

        JConstants constant = new JConstants();
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isLineComment = false;
        boolean isMultiLinesComment = false;
        boolean isString = false;
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
                        if(ch == '"' && !isString)
                            isString = true;
                        else if (ch =='"' && isString)
                            isString = false;
                        temp.append(ch);
                    } else if (temp.length() > 0 && ch != 13 && (ch == ' ' || constant.isSpecialChar(ch)) && !isString) {
                        //System.out.println("TOKEN : " + temp);
                        int token = constant.isReserveredWord(temp.toString());
                        if (token != 0) {
                           // System.out.println(temp.toString() + constant.isReserveredWord(temp.toString()));
                            builder.append("id" +token);
                        } else {
                            if(isNumeric(temp.toString())){
                                token = TokensGenerator.getchar(temp.toString());
                                builder.append("NUM" + token);
                            }else if(temp.charAt(0) == '"'){
                                token = TokensGenerator.getchar(temp.toString());
                                builder.append("str" + token);
                            }else{
                                token = TokensGenerator.getchar(temp.toString());
                                builder.append("id" + token);
                            }
                                
                        }
                        temp.delete(0, temp.length());
                    }
                }

                //Writing White spaces and new lines
                if (!isLineComment && !isMultiLinesComment && (ch == '\n' || ch == ' ' || constant.isSpecialChar(ch))) {
                    if(isString)
                        temp.append(ch);
                    else
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
    
     public static boolean isNumeric(String str)
{
    NumberFormat formatter = NumberFormat.getInstance();
    ParsePosition pos = new ParsePosition(0);
  formatter.parse(str, pos);
  return str.length() == pos.getIndex();
}
}
