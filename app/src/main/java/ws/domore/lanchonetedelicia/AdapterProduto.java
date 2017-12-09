package ws.domore.lanchonetedelicia;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Kien on 09/12/2017.
 */

public class AdapterProduto extends CursorAdapter {

    public AdapterProduto(Context cx, Cursor c) {
        super(cx,c,false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(
                R.layout.list_item_produto, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv = (TextView) view.findViewById( R.id.text_view_produto);
        String produtoNome = cursor.getString(
                cursor.getColumnIndexOrThrow("nome"));
        tv.setText(produtoNome);
    }
}
