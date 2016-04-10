package elements.dictionary;

import elements.ClassOfEmail;
import elements.Sentence;
import util.TemplateParser;

import java.util.ArrayList;

/**
 * Created by victor on 09.04.16.
 */
public class Dictionary {

    private ArrayList<DictionaryElement> dictionary;

    public Dictionary(TemplateParser templateParser) {

        dictionary = new ArrayList<>();

        createDictionary(templateParser);

    }

    private void createDictionary(TemplateParser templateParser) {

        ArrayList<Sentence> sentences = templateParser.getSentences();

        for (Sentence sentence : sentences) {
            for (String word : sentence.getWords()) {

                int index = isInDictionary(word);

                if (index == -1) {
                    if (sentence.getClassOfEmail() == ClassOfEmail.NOT_SPAM) {
                        dictionary.add(new DictionaryElement(word, 1, 0));
                    } else {
                        dictionary.add(new DictionaryElement(word, 0, 1));
                    }

                } else {

                    if (sentence.getClassOfEmail() == ClassOfEmail.NOT_SPAM) {

                        double numberOfNotSpam = dictionary.get(index).getNotSpamNumber() + 1;

                        dictionary.get(index).setNotSpamNumber(numberOfNotSpam);

                    } else {

                        double numberOfSpam = dictionary.get(index).getSpamNumber() + 1;
                        dictionary.get(index).setSpamNumber(numberOfSpam);


                    }

                }


            }
        }

    }

    public int isInDictionary(String word) {


        int i = 0;
        for (DictionaryElement element : dictionary) {
            if (element.getWord().toLowerCase().equals(word.toLowerCase())) {
                return i;
            }
            i++;
        }


        return -1;
    }


    public ArrayList<DictionaryElement> getDictionary() {
        return dictionary;
    }


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new TemplateParser("template.txt"));


        dictionary.getDictionary().forEach(System.out::println);


    }

}
