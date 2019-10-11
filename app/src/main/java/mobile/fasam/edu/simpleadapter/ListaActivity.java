package mobile.fasam.edu.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtTelefone;
    EditText txtEmail;
    ListView listview;

    List<HashMap<String,String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void adicionar(View view) {

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtEmail = findViewById(R.id.txtEmail);

        String nome, sobrenome, email, telefone;
        nome = txtNome.getText().toString();
        sobrenome = txtSobrenome.getText().toString();
        telefone = txtTelefone.getText().toString();
        email = txtEmail.getText().toString();


        String dadosSaida = String.format("Dados adicionados: %s %s %s %s", nome,sobrenome,telefone,email);
        HashMap<String,String> map = new HashMap<>();
        map.put("nome", nome);
        map.put("sobrenome", sobrenome);
        map.put("telefone", telefone);
        map.put("email", email);

        lista.add(map);

        String[] de ={"nome","sobrenome","telefone","email"};
        int[] para = {R.id.labelNome, R.id.labelSobrenome, R.id.labelTelefone, R.id.labelEmail,};

        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                lista,
                R.layout.listagem,
                de,
                para
        );


        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

    }
}
