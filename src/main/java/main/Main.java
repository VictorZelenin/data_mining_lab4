package main;

import classifier.BayesClassifier;
import classifier.Classifier;
import util.Util;

/**
 * Created by victor on 08.04.16.
 */
public class Main {


    public static void main(String[] args) {

        // create classifier
        Classifier classifier = new BayesClassifier("template.txt");

        /**
         * @param "test.txt" - input file
         * @param "out.txt" - output.file
         * @param classifier - novice bayes classifier
         *
         * */
        Util.createResultFile("test.txt", "out.txt", classifier);

    }

}
