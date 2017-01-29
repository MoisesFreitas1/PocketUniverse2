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
 * Created by Moisés on 14/03/2016.
 */
public class FCentCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double raio = 0.0;
    private double velocidade = 0.0;
    private double fcent = 0.0;
    private TextView massaTextView;
    private TextView raioTextView;
    private TextView veloTextView;
    private TextView fcentTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_fcent,container,false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        raioTextView = (TextView) view.findViewById(R.id.raioTextView);
        fcentTextView = (TextView) view.findViewById(R.id.fcentTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);

        massaTextView.setText(numberFormat.format(massa));
        raioTextView.setText(numberFormat.format(raio));
        fcentTextView.setText(numberFormat.format(fcent));
        veloTextView.setText(numberFormat.format(velocidade));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText raioEditText = (EditText) view.findViewById(R.id.raioEditText);
        raioEditText.addTextChangedListener(raioEditTextWatcher);
        EditText veloEditText = (EditText) view.findViewById(R.id.veloEditText);
        veloEditText.addTextChangedListener(veloEditTextWatcher);
        return view;
    }

    private void update(){
        double v = velocidade;
        double m = massa;
        double r = raio;
        double fc;

        fc = m*(v*v)/r;


        massaTextView.setText(numberFormat.format(m));
        raioTextView.setText(numberFormat.format(r));
        fcentTextView.setText(numberFormat.format(fc));
        veloTextView.setText(numberFormat.format(v));
    }

    private TextWatcher massaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                massa = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                massa = 0.0;
            }
            massaTextView.setText(numberFormat.format(massa));
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

    private TextWatcher raioEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                raio = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                raio = 0.0;
            }
            raioTextView.setText(numberFormat.format(raio));
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
