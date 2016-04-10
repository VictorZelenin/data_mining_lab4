package classifier;


import elements.ClassOfEmail;
import elements.dictionary.Dictionary;
import elements.dictionary.DictionaryElement;
import util.TemplateParser;

import java.util.ArrayList;

/**
 * Created by victor on 08.04.16.
 */
public class BayesClassifier implements ClassifierInterface {


    private ClassOfEmail classOfEmail;
    private TemplateParser templateParser;
    private Dictionary dictionary;

    public BayesClassifier(String fileName) {

        templateParser = new TemplateParser(fileName);

        dictionary = new Dictionary(templateParser);

        this.normalizeDictionary();

        dictionary.getDictionary().forEach(System.out::println);

    }

    private void normalizeDictionary() {


        for (DictionaryElement element : dictionary.getDictionary()) {

            double totalCountOfWords = element.getNotSpamNumber() + element.getSpamNumber();
            double wordNotSpamProbability = element.getNotSpamNumber() / totalCountOfWords;
            double wordSpamProbability = element.getSpamNumber() / totalCountOfWords;


            element.setNotSpamNumber((
                    totalCountOfWords * wordNotSpamProbability + 0.5) / (totalCountOfWords + 1));
            element.setSpamNumber((
                    totalCountOfWords * wordSpamProbability + 0.5) / (totalCountOfWords + 1));

        }

    }


    @Override
    public void classifySentence(String string) {

        String[] words = string.split(" ");
        ArrayList<Double> notSpamNumbers = new ArrayList<>();
        ArrayList<Double> spamNumbers = new ArrayList<>();

        double notSpamProbability = 1;
        double spamProbability = 1;

        for (String word : words) {

            int index = dictionary.isInDictionary(word);
            if (index != -1) {
                notSpamNumbers.add(dictionary.getDictionary().get(index).getNotSpamNumber());
                spamNumbers.add(dictionary.getDictionary().get(index).getSpamNumber());
            }

        }

        for (double value : notSpamNumbers) {
            notSpamProbability *= value;
        }

        for (double value : spamNumbers) {
            spamProbability *= value;
        }

        notSpamProbability = 0.5 * notSpamProbability;
        spamProbability = 0.5 * spamProbability;


        if (notSpamProbability >= spamProbability) {
            classOfEmail = ClassOfEmail.NOT_SPAM;
        } else {
            classOfEmail = ClassOfEmail.SPAM;
        }


    }


    @Override
    public ClassOfEmail getClassOfEmail() {
        return classOfEmail;
    }


}
