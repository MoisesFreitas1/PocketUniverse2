package pocketuniverse.mxtechnologies.com.pocketuniverse;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by Moisés on 02/03/2016.
 */
public class VemCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velocidade = 0.0;
    private double deslocamento = 0.0;
    private double tempo = 0.0;
    private TextView desTextView;
    private TextView temTextView;
    private TextView vemTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_vem,container,false);

        desTextView = (TextView) view.findViewById(R.id.desTextView);
        temTextView = (TextView) view.findViewById(R.id.temTextView);
        vemTextView = (TextView) view.findViewById(R.id.vemTextView);

        desTextView.setText(numberFormat.format(deslocamento));
        temTextView.setText(numberFormat.format(tempo));
        vemTextView.setText(numberFormat.format(velocidade));
        update();

        EditText desEditText = (EditText) view.findViewById(R.id.desEditText);
        desEditText.addTextChangedListener(desEditTextWatcher);
        EditText temEditText = (EditText) view.findViewById(R.id.temEditText);
        temEditText.addTextChangedListener(temEditTextWatcher);
    return view;
    }

    private void update(){
        double vel = velocidade;
        double des = deslocamento;
        double tem = tempo;

        vel = des/tem;

        desTextView.setText(numberFormat.format(des));
        temTextView.setText(numberFormat.format(tem));
        vemTextView.setText(numberFormat.format(vel));

    }

    private TextWatcher desEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                deslocamento = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                deslocamento = 0.0;
            }
            desTextView.setText(numberFormat.format(deslocamento));
            update();
        }
        @Override
        public void afterTextChanged(Editable s)
        {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }
    };


    private TextWatcher temEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                tempo = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                tempo = 0.0;
            }
            temTextView.setText(numberFormat.format(tempo));
            update();
        }
        @Override
        public void afterTextChanged(Editable s)
        {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }
    };
}
