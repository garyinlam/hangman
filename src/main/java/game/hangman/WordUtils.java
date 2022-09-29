package game.hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordUtils {
    private static final List<String> wordsList = new ArrayList<>();
    private static final List<String> moviesList = new ArrayList<>();
    private static final List<String> javaList = new ArrayList<>();


    private static final Random RANDOM = new Random();

    static {
        readFile("words.txt",wordsList);
        readFile("movies.txt",moviesList);
        readFile("java.txt",javaList);
    }

    private static void readFile(String file, List<String> arrList){
        try {
            FileReader fr = new FileReader("wordLists/"+file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
                arrList.add(line);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWord(int category){
        switch (category){
            case 1:
                return wordsList.get(RANDOM.nextInt(wordsList.size()));
            case 2:
                return moviesList.get(RANDOM.nextInt(moviesList.size()));
            case 3:
                return javaList.get(RANDOM.nextInt(javaList.size()));
            default:
                return "";
        }
    }
}
