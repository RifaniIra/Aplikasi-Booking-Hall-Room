package id.sch.smktelkom_mlg.learn.aplikasibookinghallroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etNomor;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();

            }
        });
    }

    private void doProcess() {
        if(isValid()) {
            String nama = etNama.getText().toString();
            int nomor = Integer.parseInt(etNomor.getText().toString());
            tvHasil.setText(nama + "No. KTP = " + nomor);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(nomor.isEmpty())
        {
            etNomor.setError("Nomor KTP Belum Diisi");
            valid = false;
        }
        else {
            etNomor.setError(null);
        }
        return valid;
    }
}
