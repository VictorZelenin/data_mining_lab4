package elements.dictionary;

/**
 * Created by victor on 09.04.16.
 */
public class DictionaryElement {

    private final String word;

    private double notSpamNumber;

    private double spamNumber;


    DictionaryElement(String word, double notSpamNumber, double spamNumber) {
        this.word = word;
        this.notSpamNumber = notSpamNumber;
        this.spamNumber = spamNumber;
    }

    String getWord() {
        return word;
    }

    public double getNotSpamNumber() {
        return notSpamNumber;
    }

    public double getSpamNumber() {
        return spamNumber;
    }


    public void setNotSpamNumber(double notSpamNumber) {
        this.notSpamNumber = notSpamNumber;
    }

    public void setSpamNumber(double spamNumber) {
        this.spamNumber = spamNumber;
    }

    @Override
    public String toString() {

        return "Word: " + word + " | not_spam_number: " + notSpamNumber + " | spam_number: " + spamNumber;

    }

}
