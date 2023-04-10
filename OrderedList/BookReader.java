import java.io.*;
import java.util.Scanner;

public class BookReader {

    String book; //the book as a string
    MyLinkedList<String> words = new MyLinkedList<>(); //a list of all the words in the book

    //calls readBook on filename and parseWords
    public BookReader(String filename) {
        //calls readBook on filename
        //calls parseWords
        try {
            readBook(filename);
        }
        catch(Exception e) {

        }
        parseWords();
    }

    //reads the content of the file into the book
    //should run in O(n)
    public void readBook(String filename) throws IOException {
        //open the file filename
        //read the file character by character (not word by word or line by line)
        //closes the file
        //stores the contents of the file in book
        //should time itself and output its runtime to the console
//        long duration = 0;
//        long start = System.currentTimeMillis();
//        File file = new File(filename);
//        Scanner input = new Scanner(file);
//        BufferedReader inputStream = new BufferedReader(new FileReader(file));
//        while (input.hasNextLine()) {
//            String word = input.nextLine();
//            for (char c : word.toCharArray()) {
//                book += c;
//            }
//        }
//        input.close();
//        long now = System.currentTimeMillis();
//        duration = now - start;
//        System.out.println("readBook duration" + duration + "ms");
        long duration = 0;
        long start = System.currentTimeMillis();
        int characterCount = 0;
        File file = new File(filename);
        FileReader fileRead = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(fileRead);
        StringBuilder text = new StringBuilder();
        int character = 0;
        while ((character = buffRead.read()) != -1) {
            text.append((char)character);
            characterCount++;
        }
        text.append(' ');
        fileRead.close();
        book = text.toString();
    }

    //scans the book for words
    //should run in O(n)
    public void parseWords() {
        //traverse the string 'book' one character at a time
        //if the character is a word character (from list above) add to word buffer
        //if character it not a word character
            //add the word in the word buffer to words if it exists
            //clear the word buffer
        long duration = 0;
        long start = System.currentTimeMillis();
        char ch;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < book.length(); i++)  {
                ch = book.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || Character.valueOf(ch).equals('\'')) {
                word.append(ch); //if word character, add to buffer
            } else {
                if (!word.isEmpty()) {
                    words.addBefore(word.toString()); //if not a word character, add to linkedlist words
                    word = new StringBuilder();
                }
            }
        }
        long now = System.currentTimeMillis();
        duration = now - start;
        System.out.println("readBook duration" + duration + "ms");
    }
}
