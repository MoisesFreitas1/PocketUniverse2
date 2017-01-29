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
public class AemCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double aceleracao = 0.0;
    private double velocidade = 0.0;
    private double tempo = 0.0;
    private TextView velTextView;
    private TextView temTextView;
    private TextView aemTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_aem,container,false);

        velTextView = (TextView) view.findViewById(R.id.velTextView);
        temTextView = (TextView) view.findViewById(R.id.temTextView);
        aemTextView = (TextView) view.findViewById(R.id.aemTextView);

        velTextView.setText(numberFormat.format(velocidade));
        temTextView.setText(numberFormat.format(tempo));
        aemTextView.setText(numberFormat.format(aceleracao));
        update();

        EditText velEditText = (EditText) view.findViewById(R.id.velEditText);
        velEditText.addTextChangedListener(velEditTextWatcher);
        EditText temEditText = (EditText) view.findViewById(R.id.temEditText);
        temEditText.addTextChangedListener(temEditTextWatcher);

        return view;
    }

    private void update(){
        double vel = velocidade;
        double ace = aceleracao;
        double tem = tempo;


        ace = vel/tem;


        velTextView.setText(numberFormat.format(vel));
        temTextView.setText(numberFormat.format(tem));
        aemTextView.setText(numberFormat.format(ace));

    }

    private TextWatcher velEditTextWatcher = new TextWatcher()
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
            velTextView.setText(numberFormat.format(velocidade));
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
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count)
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
