package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText;
    RecyclerView recyclerView;

    ArrayList<DataItem> dataItems = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();

    double[] tempValues = { 658457, 297132, 244223, 239206, 209551, 195137, 144473, 121543, 120027, 83482, 80454, 77261, 72634, 67971, 67615, 64736, 64180, 52122, 51400, 51241, 51149, 47909, 46880, 45988, 45226, 38959, 37232, 36493, 35497, 34884, 33533, 32622, 32547, 28521, 27484, 25655, 24810, 24260, 23998, 21333, 20958, 20695, 20197, 19982, 19973, 19767, 19702, 19579, 19097, 18344, 18318, 17253, 16573, 16467, 15808, 15628, 15463, 15357, 15312, 15165, 15086, 14643, 14203, 12890, 12669, 12662, 12412, 11742, 11197, 11041, 10543, 10396, 10396, 9877, 9870, 9563, 9562, 9443, 9423, 9311, 9117, 8978, 8717, 8563, 8456, 7979, 7928, 7759, 7702, 7497, 7105, 7102, 6951, 6891, 6877, 6802, 6785, 6613, 6506, 6465, 6380, 6286, 6070, 5484, 5390, 4964, 1289};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataItems = Statistics.getSampleData();

        for (DataItem item: dataItems) {
            values.add(item.getValue());
        }

        // Vi skapar en koppling mellan vår Java-kod och vår XML-layout
        outputText = findViewById(R.id.outputText);
        inputText = findViewById((R.id.editTextName));
        recyclerView = findViewById(R.id.dataItemsRecyclerView);

        CustomAdapter adapter = new CustomAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        DataItem mittObjekt = new DataItem("Helsingfors", 658457);
        DataItem mittAndraObjekt = new DataItem("Esbo", 297132);

        // HashMap-exempel
        HashMap<String, Double> cities = new HashMap<>();
        cities.put("Helsingfors", 658457.0);
        cities.put("Esbo", 297132.0);

        HashMap<String, DataItem> cityItems = new HashMap<>();
        cityItems.put("manse", new DataItem("Tammerfors", 244223));

        // JavaScript: {manse: {name: "Tammerfors", value: 244223}}


        outputText.setText(String.format("%s: %.2f\nEsbo: %.2f\n%s: %.2f",
                mittObjekt.getName(),
                mittObjekt.getValue(),
                cities.get("Esbo"),
                cityItems.get("manse").getName(),
                cityItems.get("manse").getValue()
                ));

    }

    public void calculate(View view) {
        //System.out.println("Du tryckte på knappen!");

        // Vi avläser vår EditText och omvandlar till String
        // String namn = inputText.getText().toString();

        outputText.setText(String.format("Hej %s\n\nMedelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                inputText.getText(),
                Statistics.calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcSD(values)
        ));

    }
}