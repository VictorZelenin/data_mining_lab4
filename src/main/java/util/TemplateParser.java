package util;

import elements.ClassOfEmail;
import elements.Sentence;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by victor on 09.04.16.
 */
public class TemplateParser {

    private ArrayList<Sentence> sentences;


    public TemplateParser(String templateFileName) {

        sentences = new ArrayList<>();

        try {
            parseData(templateFileName);
        } catch (FileNotFoundException e) {
            System.err.println("Can not read file!");
            e.printStackTrace();
        }

    }

    private void parseData(String templateFileName) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(templateFileName));

        while (scanner.hasNext()) {

            String line = scanner.nextLine();

            if (line.endsWith("nspam")) {


                sentences.add(new Sentence(line.replaceAll(" - nspam", ""), ClassOfEmail.NOT_SPAM));

            } else {
                sentences.add(new Sentence(line.replaceAll(" - spam", ""), ClassOfEmail.SPAM));
            }


        }
//        System.out.println(sentences);

    }


    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    //testing unit
    public static void main(String[] args) {

        new TemplateParser("template.txt");

    }


}













