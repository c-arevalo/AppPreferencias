package arevalosalazar.cesar.apppreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private final static String PREFERENCIA_MELODIA = "melodia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferencias;
        preferencias = getPreferences(Context.MODE_PRIVATE);
        int id = preferencias.getInt(PREFERENCIA_MELODIA,R.id.radioButton);
        RadioButton r;
        r = findViewById(id);
        r.setChecked(true);
    }


    public void onCancelar(View v){
        finish();
    }

    public void onAceptar (View v){
        SharedPreferences preferencias;
        preferencias = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = preferencias.edit();
        RadioGroup rg;
        rg = findViewById(R.id.radioGroup);
        editor.putInt(PREFERENCIA_MELODIA, rg.getCheckedRadioButtonId());
        editor.commit();
        //finish();
    }
}