package classifier;

import elements.ClassOfEmail;

/**
 * Created by victor on 10.04.16.
 */
public interface ClassifierInterface {

    void classifySentence(String sentence);

    ClassOfEmail getClassOfEmail();


}
