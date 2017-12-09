package ws.domore.lanchonetedelicia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kien on 09/12/2017.
 */

public class BancoHelper extends SQLiteOpenHelper {

    public BancoHelper(Context c){
        super(c,BancoProduto.NOME_BD,null,BancoProduto.BD_V);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BancoProduto.QUERY_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
