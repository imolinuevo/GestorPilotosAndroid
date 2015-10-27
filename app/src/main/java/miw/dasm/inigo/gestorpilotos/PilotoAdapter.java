package miw.dasm.inigo.gestorpilotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PilotoAdapter extends ArrayAdapter<Piloto> {

    public PilotoAdapter(Context context, int resource, List<Piloto> pilotos) {
        super(context, resource, pilotos);
    }

    public View getView (int position, View convertView, ViewGroup parent){
        if( convertView == null ){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_listado_pilotos, parent, false);
        }
        Piloto piloto = getItem(position);
        TextView nombrePiloto = (TextView) convertView.findViewById(R.id.nombrePiloto);
        nombrePiloto.setText(piloto.get_nombre());
        return convertView;
    }

}
