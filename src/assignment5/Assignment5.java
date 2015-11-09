/*
 * Tyler Nally
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Assignment5 {

    static BinarySearchTree[] dictionary = new BinarySearchTree[26];

    long wrongWords = 0;
    long rightWords = 0;
    long compsfound = 0;
    long compsnotfound = 0;
//constructor

    Assignment5() {
        for (int i = 0; i < dictionary.length; i++) {

            dictionary[i] = new BinarySearchTree<String>();
        }
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    
        Assignment5 a4 = new Assignment5();
        a4.readDictonary();
        a4.readandSearch();
       
    }

    /**
     * @pre while ((n = info.read()) != -1) //let does not equal -1 if
     * (Character.isLetter(let)) // char is letter if (list[(int) word.charAt(0)
     * - 97].search(word, a))
     * @post read file make lowercase check if oliver contains words for
     * comparisons
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readandSearch() throws FileNotFoundException, IOException {

        int[] a = new int[1];
        
        FileInputStream info = new FileInputStream(new File("oliver.txt"));
        char let;
        String word = "";
        int n = 0;
        while ((n = info.read()) != -1) {
            let = (char) n;

            if (Character.isLetter(let)) {
                word += Character.toLowerCase(let);
            }

            if ((Character.isWhitespace(let) || let == '-') && !word.isEmpty()) {

                if (dictionary[(int) word.charAt(0) - 97].search(word, a)) {
                    rightWords++;
                    compsfound+=a[0];
                } else {
                    wrongWords++;
                    compsnotfound+=a[0];
                            
                }
                word="";
                
            }
        }
        info.close();
        System.out.println(word);
        long avcompsfound = compsfound / rightWords;
        long avcompsnotfound = compsnotfound / wrongWords;
        System.out.println("Words found: " + rightWords);
        System.out.println("Words not found: " + wrongWords);
        System.out.println("Average number of comparisons found: " + avcompsfound);
        System.out.println("Average number of comparisons not found: " + avcompsnotfound);
    }

    /**
     * @pre while (in.hasNext()) // while there is another line
     * @post list[(int) word.charAt(0) - 97].insert(word);// add word to array
     * in proper linked list
     */
    public void readDictonary() {
        try {
            File f = new File("random_dictionary.txt");
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String word = in.next();
                word = word.toLowerCase();
                dictionary[(int) word.charAt(0) - 97].insert(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

run:

Words found: 937492
Words not found: 54648
Average number of comparisons found: 468746
Average number of comparisons not found: 441326
BUILD SUCCESSFUL (total time: 51 seconds)
