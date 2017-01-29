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
 * Created by Moisés on 15/03/2016.
 */
public class HEDCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double vol = 0.0;
    private double dens = 0.0;
    private TextView massaTextView;
    private TextView volTextView;
    private TextView densTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_hed, container, false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        volTextView = (TextView) view.findViewById(R.id.volTextView);
        densTextView = (TextView) view.findViewById(R.id.densTextView);

        massaTextView.setText(numberFormat.format(massa));
        volTextView.setText(numberFormat.format(vol));
        densTextView.setText(numberFormat.format(dens));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText volEditText = (EditText) view.findViewById(R.id.volEditText);
        volEditText.addTextChangedListener(volEditTextWatcher);

        return view;
    }

    private void update(){
        double m=massa;
        double v=vol;
        double d;

        d=m/v;

        massaTextView.setText(numberFormat.format(m));
        volTextView.setText(numberFormat.format(v));
        densTextView.setText(numberFormat.format(d));
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

    private TextWatcher volEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                vol = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                vol = 0.0;
            }
            volTextView.setText(numberFormat.format(vol));
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
