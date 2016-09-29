package id.sch.smktelkom_mlg.learn.aplikasibookinghallroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    EditText etNama;
    EditText etNomor;
    Button bOK;
    RadioGroup rgJumlah;
    TextView tvHasil, tvFata;
    CheckBox cbMM, cbKS, cbCM, cbEA, cbSL;
    int nFata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        bOK = (Button) findViewById(R.id.buttonOK);
        rgJumlah = (RadioGroup) findViewById(R.id.radioGroupJumlah);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        cbMM = (CheckBox) findViewById(R.id.checkBoxMM);
        cbKS = (CheckBox) findViewById(R.id.checkBoxKS);
        cbCM = (CheckBox) findViewById(R.id.checkBoxCM);
        cbEA = (CheckBox) findViewById(R.id.checkBoxEA);
        cbSL = (CheckBox) findViewById(R.id.checkBoxSL);

        tvFata = (TextView) findViewById(R.id.textViewFata);
        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                doProcess();

            }
        });

        cbMM.setOnCheckedChangeListener(this);
        cbKS.setOnCheckedChangeListener(this);
        cbCM.setOnCheckedChangeListener(this);
        cbEA.setOnCheckedChangeListener(this);
        cbSL.setOnCheckedChangeListener(this);
    }

    private void doProcess() {
        String hasil = null;
        if(rgJumlah.getCheckedRadioButtonId()!=-1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgJumlah.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if(hasil == null)
        {
            hasil = "Anda Belum Memilih Jumlah Orang";
        }

        String hasil2 ="Fasilitas Tambahan yang dipilih :\n";
        int startlen =hasil2.length();
        if(cbMM.isChecked()) hasil2+=cbMM.getText()+"\n";
        if(cbKS.isChecked()) hasil2+=cbKS.getText()+"\n";
        if(cbCM.isChecked()) hasil2+=cbCM.getText()+"\n";
        if(cbEA.isChecked()) hasil2+=cbEA.getText()+"\n";
        if(cbSL.isChecked()) hasil2+=cbSL.getText()+"\n";

        if(hasil2.length()==startlen) hasil2+="Tidak Ada pada Pilihan";


        if(isValid()) {
            String nama = etNama.getText().toString();
            int nomor = Integer.parseInt(etNomor.getText().toString());
            tvHasil.setText("Nama            : " + nama +  "\n" +
                            "No. KTP        : " + nomor + "\n" +
                            "Jumlah          : " + hasil + "\n" +
                            hasil2);

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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) nFata+=1;
        else nFata-=1;
        tvFata.setText("Fasilitas Tambahan ("+nFata+" terpilih)");
    }
}
