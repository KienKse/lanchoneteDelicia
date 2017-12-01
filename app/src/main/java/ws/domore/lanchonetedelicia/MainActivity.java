package ws.domore.lanchonetedelicia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.*;
import java.io.Serializable;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Produto[] produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BIBLIOTECA ASYNCHTTPCLIENT
        AsyncHttpClient client = new AsyncHttpClient();

        TextView textView = (TextView)this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        final ArrayList<String> produto_list = new ArrayList<String>();

//        ArrayList<Produto> produto_list = new ArrayList<Produto>();

        //String nome ,String valor, String desc, Integer idImagem
        /*
        produto_list.add(new Produto("Salada  Surpresa","R$12,00","Ervilha, mix de alface, batata doce, cenoura, rabanete e tomate",1));
        produto_list.add(new Produto("Suco Onda Tropical","R$6,00","Laranja e frutas tropicais",2));
        produto_list.add(new Produto("Vitamina Planetaria","R$8,00","Banana flambada, açúcar mascavo, canela em pó e cacau em pó",3));
        produto_list.add(new Produto("Hamburguer Exagerado","R$15,50","ERROR 404",4));
        produto_list.add(new Produto("Pastel Super","R$7,00","ERROR 404",5));
        produto_list.add(new Produto("Empada Olho Grande","R$5,00","ERROR 404",6));
        produto_list.add(new Produto("BOLIVIANO Quente","R$3,50","ERROR 404",7));
        produto_list.add(new Produto("Quibe POP","R$3,00","ERROR 404",8));
        produto_list.add(new Produto("Esfirra do Sabor","R$5,00","ERROR 404",9));
        produto_list.add(new Produto("Crepioca Saborosa","R$6,00","ERROR 404",10));
        produto_list.add(new Produto("Pao de Nuvem","R$3,00","ERROR 404",11));
        produto_list.add(new Produto("Bruschetta Integral","R$10,00","ERROR 404",12));
        produto_list.add(new Produto("Banana chips","R$6,00","ERROR 404",13));
        produto_list.add(new Produto("Sopa Funcional","R$13,00","ERROR 404",14));
        produto_list.add(new Produto("Sanduche Natureba","R$9,90","ERROR 404",15));
        */
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_produto,
                R.id.text_view_produto,produto_list);

//        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this,R.layout.list_item_produto,
//                R.id.text_view_produto,produto_list);

        ListView listView = (ListView)this.findViewById(R.id.list_view_produtos);

        listView.setAdapter(adapter);

        client.get(
                //https://herokuapp.com/main/api - NOT FOUND
                "https://patra-backend.appspot.com/produtos",
                //  TextHttpResponseHandler - onSuccess() | onFailure()
                new TextHttpResponseHandler() {

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Log.d("AsyncHttpClient", "FALHA - " + throwable.toString());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response = " + responseString);
                        Log.d("AsyncHttpClient", "SUCESSO");

                        Gson gson = new GsonBuilder().create();
                        produtos = gson.fromJson(responseString, Produto[].class);
                        adapter.clear();
                        for(Produto produto : produtos) {
                            adapter.add(produto.getNome());
                        }
                    }
                });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
//                intent.putExtra("produto_list", (Serializable) parent.getItemAtPosition(position));
                intent.putExtra("produto_nome",produtos[position].getNome());
                intent.putExtra("produto_preco", produtos[position].getPreco());
                intent.putExtra("produto_desc", produtos[position].getDescricao());
                 intent.putExtra("produto_url", produtos[position].getImagem());
                startActivity(intent);
            }
        });

    }
}