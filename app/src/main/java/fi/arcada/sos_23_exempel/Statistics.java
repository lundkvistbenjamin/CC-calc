package fi.arcada.sos_23_exempel;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static ArrayList<DataItem> getSampleData() {
        ArrayList<DataItem> dataItems = new ArrayList<>();
        String[] names =  {"Helsingfors", "Esbo", "Tammerfors", "Vanda", "Uleåborg", "Åbo", "Jyväskylä", "Kuopio", "Lahtis", "Björneborg", "Kouvola", "Joensuu", "Villmanstrand", "Tavastehus", "Vasa", "Seinäjoki", "Rovaniemi", "S:t Michel", "Salo", "Kotka", "Borgå", "Karleby", "Hyvinge", "Lojo", "Träskända", "Raumo", "Kervo", "Kajana", "S:t Karins", "Nokia", "Ylöjärvi", "Kangasala", "Nyslott", "Riihimäki", "Raseborg", "Imatra", "Reso", "Brahestad", "Sastamala", "Torneå", "Idensalmi", "Valkeakoski", "Kurikka", "Kemi", "Varkaus", "Jämsä", "Fredrikshamn", "Nådendal", "Jakobstad", "Heinola", "Äänekoski", "Pieksämäki", "Forssa", "Ackas", "Orimattila", "Loimaa", "Nystad", "Ylivieska", "Kauhava", "Kuusamo", "Pargas", "Lovisa", "Lappo", "Kauhajoki", "Ulvsby", "Kankaanpää", "Kalajoki", "Mariehamn", "Alavo", "Pemar", "Lieksa", "Grankulla", "Nivala", "Kides", "Vittis", "Mänttä-Vilppula", "Närpes", "Keuru", "Nurmes", "Alajärvi", "Saarijärvi", "Orivesi", "Högfors", "Somero", "Letala", "Hangö", "Kuhmo", "Kiuruvesi", "Pudasjärvi", "Nykarleby", "Kemijärvi", "Oulainen", "Kumo", "Suonenjoki", "Ikalis", "Haapajärvi", "Harjavalta", "Haapavesi", "Outokumpu", "Virdois", "Kristinestad", "Parkano", "Viitasaari", "Etseri", "Kannus", "Pyhäjärvi", "Kaskö"};
        double[] values = { 658457, 297132, 244223, 239206, 209551, 195137, 144473, 121543, 120027, 83482, 80454, 77261, 72634, 67971, 67615, 64736, 64180, 52122, 51400, 51241, 51149, 47909, 46880, 45988, 45226, 38959, 37232, 36493, 35497, 34884, 33533, 32622, 32547, 28521, 27484, 25655, 24810, 24260, 23998, 21333, 20958, 20695, 20197, 19982, 19973, 19767, 19702, 19579, 19097, 18344, 18318, 17253, 16573, 16467, 15808, 15628, 15463, 15357, 15312, 15165, 15086, 14643, 14203, 12890, 12669, 12662, 12412, 11742, 11197, 11041, 10543, 10396, 10396, 9877, 9870, 9563, 9562, 9443, 9423, 9311, 9117, 8978, 8717, 8563, 8456, 7979, 7928, 7759, 7702, 7497, 7105, 7102, 6951, 6891, 6877, 6802, 6785, 6613, 6506, 6465, 6380, 6286, 6070, 5484, 5390, 4964, 1289};

        for (int i = 0; i < names.length; i++) {
            dataItems.add(new DataItem(names[i], values[i]));
        }

        return dataItems;
    }

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
