package elements;

/**
 * Created by victor on 09.04.16.
 */
public class Sentence {

    private String sentence;

    private ClassOfEmail classOfEmail;


    public Sentence(String sentence, ClassOfEmail classOfEmail){

        this.sentence = sentence;
        this.classOfEmail = classOfEmail;
    }


    public String[] getWords(){

        String[] words;

        words = sentence.split(" ");

        return words;
    }


    public String getSentence() {
        return sentence;
    }

    public ClassOfEmail getClassOfEmail() {
        return classOfEmail;
    }

    @Override
    public String toString(){

        return "Sentence: " + sentence + ", status: " + classOfEmail;
    }


}
