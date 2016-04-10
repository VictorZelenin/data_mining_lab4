package classifier;

import elements.ClassOfEmail;

/**
 * Created by victor on 10.04.16.
 */
public interface Classifier {

    void classifySentence(String sentence);

    ClassOfEmail getClassOfEmail();


}
