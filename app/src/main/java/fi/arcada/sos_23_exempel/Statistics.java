package fi.arcada.sos_23_exempel;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    // Metod för att sortera data
    public static ArrayList<Double> sortValues(ArrayList<Double> values) {
        // vi skapar en kopia så vi inte sorterar ursprungliga datamängden
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(values);
        return sorted;
    }

    public static double calcMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        int middle = sorted.size()/2;
        return sorted.get(middle);
    }

    public static double calcMean(ArrayList<Double> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum / values.size();
    }

    public static double calcSD(ArrayList<Double> values) {
        double mean = calcMean(values);
        double sumOffDiff = 0;

        for (int i = 0; i < values.size(); i++) {
            sumOffDiff += Math.pow(values.get(i) - mean, 2);
        }
        double variance = sumOffDiff / values.size();

        return Math.sqrt(variance);
    }

}
