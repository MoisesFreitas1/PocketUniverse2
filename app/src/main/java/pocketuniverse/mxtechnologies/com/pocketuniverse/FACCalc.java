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
public class FACCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double cc = 0.0;
    private double forcan = 0.0;
    private double fac = 0.0;
    private TextView ccTextView;
    private TextView forcanTextView;
    private TextView facTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_fac, container, false);

        ccTextView = (TextView) view.findViewById(R.id.ccTextView);
        forcanTextView = (TextView) view.findViewById(R.id.forcanTextView);
        facTextView = (TextView) view.findViewById(R.id.facTextView);

        ccTextView.setText(numberFormat.format(cc));
        forcanTextView.setText(numberFormat.format(forcan));
        facTextView.setText(numberFormat.format(fac));
        update();

        EditText ccEditText = (EditText) view.findViewById(R.id.ccEditText);
        ccEditText.addTextChangedListener(ccEditTextWatcher);
        EditText forcanEditText = (EditText) view.findViewById(R.id.forcanEditText);
        forcanEditText.addTextChangedListener(forcanEditTextWatcher);

        return view;
    }

    private void update(){
        double u=cc;
        double N=forcan;
        double fa;

        fa=u*N;

        ccTextView.setText(numberFormat.format(u));
        forcanTextView.setText(numberFormat.format(N));
        facTextView.setText(numberFormat.format(fa));
    }

    private TextWatcher ccEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                cc = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                cc = 0.0;
            }
            ccTextView.setText(numberFormat.format(cc));
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

    private TextWatcher forcanEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                forcan = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                forcan = 0.0;
            }
            forcanTextView.setText(numberFormat.format(forcan));
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
