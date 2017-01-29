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
public class PRRCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double pu = 0.0;
    private double pt = 0.0;
    private double r = 0.0;
    private TextView puTextView;
    private TextView ptTextView;
    private TextView rTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_prr, container, false);

        puTextView = (TextView) view.findViewById(R.id.puTextView);
        ptTextView = (TextView) view.findViewById(R.id.ptTextView);
        rTextView = (TextView) view.findViewById(R.id.rTextView);

        puTextView.setText(numberFormat.format(pu));
        ptTextView.setText(numberFormat.format(pt));
        rTextView.setText(numberFormat.format(r));
        update();

        EditText puEditText = (EditText) view.findViewById(R.id.puEditText);
        puEditText.addTextChangedListener(puEditTextWatcher);
        EditText ptEditText = (EditText) view.findViewById(R.id.ptEditText);
        ptEditText.addTextChangedListener(ptEditTextWatcher);

        return view;
    }

    private void update(){
        double u=pu;
        double t=pt;
        double re;

        re=u/t;

        puTextView.setText(numberFormat.format(u));
        ptTextView.setText(numberFormat.format(t));
        rTextView.setText(numberFormat.format(re));
    }

    private TextWatcher puEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                pu = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                pu = 0.0;
            }
            puTextView.setText(numberFormat.format(pu));
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

    private TextWatcher ptEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                pt = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                pt = 0.0;
            }
            ptTextView.setText(numberFormat.format(pt));
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
