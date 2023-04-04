package fi.arcada.sos_23_exempel;

public class Statistics {

    public static double calcMean(double[] arr) {
        double sum = 0;
        for (int i = 0; i <= arr.length; i++){
            sum += i;  
        }
        return sum / arr.length;
    }

}
