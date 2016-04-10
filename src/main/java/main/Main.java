package main;

import classifier.BayesClassifier;
import classifier.ClassifierInterface;
import util.Util;

/**
 * Created by victor on 08.04.16.
 */
public class Main {


    public static void main(String[] args) {

        ClassifierInterface classifier = new BayesClassifier("template.txt");

        Util.createResultFile(Util.parseFile("test.txt"), classifier);

    }

}
