package ws.domore.lanchonetedelicia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Produto produt = (Produto) getIntent().getSerializableExtra("produto_list");

        ImageView imagem = (ImageView) findViewById(R.id.imgProduto);
        TextView nome = (TextView) findViewById(R.id.nomeProduto);
        TextView valor = (TextView) findViewById(R.id.valorProduto);
        TextView desc = (TextView) findViewById(R.id.descProduto);

        nome.setText(produt.getNome());
        valor.setText(produt.getValor());
        desc.setText(produt.getDesc());

        switch (produt.getIdImagem()) {
            case 1:
                imagem.setImageResource(R.drawable.salada_surpresa);
                break;
            case 2:
                imagem.setImageResource(R.drawable.sucoondatropical);
                break;
            case 3:
                imagem.setImageResource(R.drawable.vitaminainter);
                break;
            case 4:
                imagem.setImageResource(R.drawable.hamburguerexagerado);
                break;
            case 5:
                imagem.setImageResource(R.drawable.superpastel);
                break;
            case 6:
                imagem.setImageResource(R.drawable.empadaolho);
                break;
            case 7:
                imagem.setImageResource(R.drawable.boliviano);
                break;
            case 8:
                imagem.setImageResource(R.drawable.quibe);
                break;
            case 9:
                imagem.setImageResource(R.drawable.esfirra);
                break;
            case 10:
                imagem.setImageResource(R.drawable.crepioca);
                break;
            case 11:
                imagem.setImageResource(R.drawable.cloudbread);
                break;
            case 12:
                imagem.setImageResource(R.drawable.bruschetta);
                break;
            case 13:
                imagem.setImageResource(R.drawable.bananachips);
                break;
            case 14:
                imagem.setImageResource(R.drawable.sopadevegetais);
                break;
            case 15:
                imagem.setImageResource(R.drawable.sand);
                break;
        }
        }
}
