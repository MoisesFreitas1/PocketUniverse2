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
 * Created by Moisés on 11/03/2016.
 */
public class McuFrePerCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double frequencia1 = 0.5;
    private double periodo1 = 2.0;
    private double frequencia2 = 0.5;
    private double periodo2 = 2.0 ;
    private TextView frequencia1TextView;
    private TextView periodo1TextView;
    private TextView frequencia2TextView;
    private TextView periodo2TextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_mcufreper, container, false);

        frequencia1TextView = (TextView) view.findViewById(R.id.frequencia1TextView);
        periodo1TextView = (TextView) view.findViewById(R.id.periodo1TextView);
        frequencia2TextView = (TextView) view.findViewById(R.id.frequencia2TextView);
        periodo2TextView = (TextView) view.findViewById(R.id.periodo2TextView);

        frequencia1TextView.setText(numberFormat.format(frequencia1));
        periodo1TextView.setText(numberFormat.format(periodo1));
        frequencia2TextView.setText(numberFormat.format(frequencia2));
        periodo2TextView.setText(numberFormat.format(periodo2));
        update();

        EditText frequencia1EditText = (EditText) view.findViewById(R.id.frequencia1EditText);
        frequencia1EditText.addTextChangedListener(frequencia1EditTextWatcher);
        EditText periodo2EditText = (EditText) view.findViewById(R.id.periodo2EditText);
        periodo2EditText.addTextChangedListener(periodo2EditTextWatcher);

        return view;
    }

    private void update(){
        double freq1 = frequencia1;
        double per1;
        double freq2;
        double per2 = periodo2;

        per1=1/(freq1);
        freq2=1/(per2);

        frequencia1TextView.setText(numberFormat.format(freq1));
        periodo1TextView.setText(numberFormat.format(per1));
        frequencia2TextView.setText(numberFormat.format(freq2));
        periodo2TextView.setText(numberFormat.format(per2));
    }

    private TextWatcher frequencia1EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                frequencia1 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                frequencia1 = 0.0;
            }
            frequencia1TextView.setText(numberFormat.format(frequencia1));
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


    private TextWatcher periodo2EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                periodo2 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                periodo2 = 0.0;
            }
            periodo2TextView.setText(numberFormat.format(periodo2));
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