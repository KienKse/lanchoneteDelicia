package ws.domore.lanchonetedelicia;

import android.provider.BaseColumns;

/**
 * Created by Kien on 09/12/2017.
 */

public class BancoProduto {

    public static final String NOME_BD = "produto.banco";
    public static final int BD_V = 1;
    public static final String QUERY_BD = "CREATE TABLE" +
            BDStrings.NOME_TABELA + "(" +
            BDStrings._ID + " INTEGER PRIMARY KEY," +
            BDStrings.NOME_PRODUTO + "," +
            BDStrings.PRECO_PRODUTO + "," +
            BDStrings.DESCRICAO__PRODUTO + "," +
            BDStrings.IMAGEM__PRODUTO + ")";

    public class BDStrings implements BaseColumns {
        public static final String NOME_TABELA = "produto";
        public static final String NOME_PRODUTO = "nome";
        public static final String PRECO_PRODUTO = "preco";
        public static final String DESCRICAO__PRODUTO = "descricao";
        public static final String IMAGEM__PRODUTO = "imagem";
    }



}
