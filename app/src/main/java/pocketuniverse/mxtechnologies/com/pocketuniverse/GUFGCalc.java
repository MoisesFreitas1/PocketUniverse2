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
public class GUFGCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double m1 = 0.0;
    private double dist = 0.0;
    private double m2 = 0.0;
    private double fg = 0.0;
    private TextView m1TextView;
    private TextView distTextView;
    private TextView m2EditText;
    private TextView fgTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_gufg,container,false);

        m1TextView = (TextView) view.findViewById(R.id.m1TextView);
        distTextView = (TextView) view.findViewById(R.id.distTextView);
        m2EditText = (TextView) view.findViewById(R.id.m2EditText);
        fgTextView = (TextView) view.findViewById(R.id.fgTextView);

        m1TextView.setText(numberFormat.format(m1));
        distTextView.setText(numberFormat.format(dist));
        m2EditText.setText(numberFormat.format(m2));
        fgTextView.setText(numberFormat.format(fg));
        update();

        EditText m1EditText = (EditText) view.findViewById(R.id.m1EditText);
        m1EditText.addTextChangedListener(m1EditTextWatcher);
        EditText distEditText = (EditText) view.findViewById(R.id.distEditText);
        distEditText.addTextChangedListener(distEditTextWatcher);
        EditText m2EditText = (EditText) view.findViewById(R.id.m2EditText);
        m2EditText.addTextChangedListener(m2EditTextWatcher);
        return view;
    }

    private void update(){
        double m11 = m1;
        double d = dist;
        double m22 = m2;
        double f;
        double g=0.0000000000667408;
        double cg;

        cg=g*m11/(d*d);
        f=cg*m22;

        m1TextView.setText(numberFormat.format(m11));
        distTextView.setText(numberFormat.format(d));
        m2EditText.setText(numberFormat.format(m22));
        fgTextView.setText(numberFormat.format(f));
    }

    private TextWatcher m1EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                m1 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                m1 = 0.0;
            }
            m1TextView.setText(numberFormat.format(m1));
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

    private TextWatcher distEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                dist = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                dist = 0.0;
            }
            distTextView.setText(numberFormat.format(dist));
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

    private TextWatcher m2EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                m2 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                m2 = 0.0;
            }
            m2EditText.setText(numberFormat.format(m2));
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
