package util;

import classifier.Classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by victor on 10.04.16.
 */
public class Util {


    private static ArrayList<String> parseFile(String fileName) {

        ArrayList<String> sentences = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Can't read file!");
            e.printStackTrace();
        }

        assert scanner != null;
        while (scanner.hasNext()) {

            sentences.add(scanner.nextLine());
        }

        scanner.close();

        return sentences;
    }

    public static void createResultFile(String inputFileName,
                                        String outputFileName, Classifier classifier) {

        ArrayList<String> sentences = parseFile(inputFileName);

        File resultFile = new File(outputFileName);

        if (!resultFile.exists()) {
            try {
                resultFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        PrintWriter writer = null;
        try {
            writer = new PrintWriter(resultFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String sentence : sentences) {
            classifier.classifySentence(sentence);

            if (writer != null) {
                writer.write(sentence + " " + classifier.getClassOfEmail() + "\r");
                writer.flush();
            }

        }

        assert writer != null;
        writer.close();

    }
}
