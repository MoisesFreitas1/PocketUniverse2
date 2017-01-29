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
public class MruCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double posicaoi = 0.0;
    private double posicaof = 0.0;
    private double velocidade = 0.0;
    private double tempo = 0.0;
    private TextView posiTextView;
    private TextView posfTextView;
    private TextView tempoTextView;
    private TextView veloTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_mru,container,false);

        posiTextView = (TextView) view.findViewById(R.id.posiTextView);
        posfTextView = (TextView) view.findViewById(R.id.posfTextView);
        tempoTextView = (TextView) view.findViewById(R.id.tempoTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);

        posiTextView.setText(numberFormat.format(posicaoi));
        posfTextView.setText(numberFormat.format(posicaof));
        tempoTextView.setText(numberFormat.format(tempo));
        veloTextView.setText(numberFormat.format(velocidade));
        update();

        EditText posiEditText = (EditText) view.findViewById(R.id.posiEditText);
        posiEditText.addTextChangedListener(posiEditTextWatcher);
        EditText tempoEditText = (EditText) view.findViewById(R.id.tempoEditText);
        tempoEditText.addTextChangedListener(tempoEditTextWatcher);
        EditText veloEditText = (EditText) view.findViewById(R.id.veloEditText);
        veloEditText.addTextChangedListener(veloEditTextWatcher);
        return view;
    }

    private void update(){
        double vel = velocidade;
        double posi = posicaoi;
        double posf = posicaof;
        double temp = tempo;
        double posf1=0;

        posf1 = vel*temp;

        posf=posf1+posi;


        posiTextView.setText(numberFormat.format(posi));
        posfTextView.setText(numberFormat.format(posf));
        tempoTextView.setText(numberFormat.format(temp));
        veloTextView.setText(numberFormat.format(vel));
    }

    private TextWatcher posiEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                posicaoi = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                posicaoi = 0.0;
            }
            posiTextView.setText(numberFormat.format(posicaoi));
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

    private TextWatcher tempoEditTextWatcher = new TextWatcher()
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
            tempoTextView.setText(numberFormat.format(tempo));
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

    private TextWatcher veloEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                velocidade = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velocidade = 0.0;
            }
            veloTextView.setText(numberFormat.format(velocidade));
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
