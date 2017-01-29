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
public class McuVelAngCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double frequencia1 = 0.0;
    private double velang1 = 0.0;
    private double frequencia2 = 0.0;
    private double velang2 = 0.0;
    private TextView frequencia1TextView;
    private TextView velang1TextView;
    private TextView frequencia2TextView;
    private TextView velang2TextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_mcuvelang, container, false);

        frequencia1TextView = (TextView) view.findViewById(R.id.frequencia1TextView);
        velang1TextView = (TextView) view.findViewById(R.id.velang1TextView);
        frequencia2TextView = (TextView) view.findViewById(R.id.frequencia2TextView);
        velang2TextView = (TextView) view.findViewById(R.id.velang2TextView);

        frequencia1TextView.setText(numberFormat.format(frequencia1));
        velang1TextView.setText(numberFormat.format(velang1));
        frequencia2TextView.setText(numberFormat.format(frequencia2));
        velang2TextView.setText(numberFormat.format(velang2));
        update();

        EditText frequencia1EditText = (EditText) view.findViewById(R.id.frequencia1EditText);
        frequencia1EditText.addTextChangedListener(frequencia1EditTextWatcher);
        EditText velang2EditText = (EditText) view.findViewById(R.id.velang2EditText);
        velang2EditText.addTextChangedListener(velang2EditTextWatcher);

        return view;
    }

    private void update(){
        double freq1=frequencia1;
        double van1;
        double freq2;
        double van2=velang2;

        van1=(Math.PI)*2*freq1;
        freq2=van2/(2*(Math.PI));

        frequencia1TextView.setText(numberFormat.format(freq1));
        velang1TextView.setText(numberFormat.format(van1));
        frequencia2TextView.setText(numberFormat.format(freq2));
        velang2TextView.setText(numberFormat.format(van2));
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

    private TextWatcher velang2EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                velang2 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velang2 = 0.0;
            }
            velang2TextView.setText(numberFormat.format(velang2));
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
