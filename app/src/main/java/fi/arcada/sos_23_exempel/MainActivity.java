package fi.arcada.sos_23_exempel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // deklarera variabler
    TextView outputText;
    EditText inputText;

    double[] values = { 3, 5, 6, 23, 33, 45, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vi skapar en koppling mellan vår Java-kod och vår XML-layout
        outputText = findViewById(R.id.outputText);
        inputText = findViewById((R.id.editTextName));

        outputText.setText("...");
    }



    public void calculate(View view) {
        //System.out.println("Du tryckte på knappen!");

        // Vi avläser vår EditText och omvandlar till String
        // String namn = inputText.getText().toString();

        outputText.setText(String.format("Hej %s\n\nMedelvärde:%.2f",
                inputText.getText(),
                Statistics.calcMean(values)));

    }
}