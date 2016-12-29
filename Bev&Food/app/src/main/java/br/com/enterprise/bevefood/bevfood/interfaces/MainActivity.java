package br.com.enterprise.bevefood.bevfood.interfaces;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import br.com.enterprise.bevefood.bevfood.R;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        toolbarMain.setTitle("Bev&Food");
        setSupportActionBar(toolbarMain);

        button = (Button) this.findViewById(R.id.button1);
        final Activity activity = this;

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scanner Bev&Food");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String resposta;
        String mesa;
        String endereco;
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "Voce cancelou o Scanner", Toast.LENGTH_LONG).show();
            } else{
                Intent intencao = new Intent(MainActivity.this, Main2Activity.class);
                resposta = result.getContents().toString();
                String[] array = resposta.split(":");
                mesa = array[0];
                endereco = array[1];
                intencao.putExtra("MESA", mesa);
                intencao.putExtra("ENDERECO", endereco);
                startActivity(intencao);
                finish();
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
