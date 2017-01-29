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
public class HEECalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double densl = 0.0;
    private double idf = 0.0;
    private double cg = 0.0;
    private double volsub = 0.0;
    private TextView denslTextView;
    private TextView volsubTextView;
    private TextView cgTextView;
    private TextView ifTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_hee,container,false);

        denslTextView = (TextView) view.findViewById(R.id.denslTextView);
        volsubTextView = (TextView) view.findViewById(R.id.volsubTextView);
        cgTextView = (TextView) view.findViewById(R.id.cgTextView);
        ifTextView = (TextView) view.findViewById(R.id.ifTextView);

        denslTextView.setText(numberFormat.format(densl));
        volsubTextView.setText(numberFormat.format(volsub));
        cgTextView.setText(numberFormat.format(cg));
        ifTextView.setText(numberFormat.format(idf));

        update();

        EditText denslEditText = (EditText) view.findViewById(R.id.denslEditText);
        denslEditText.addTextChangedListener(denslEditTextWatcher);
        EditText volsubEditText = (EditText) view.findViewById(R.id.volsubEditText);
        volsubEditText.addTextChangedListener(volsubEditTextWatcher);
        EditText cgEditText = (EditText) view.findViewById(R.id.cgEditText);
        cgEditText.addTextChangedListener(cgEditTextWatcher);
        return view;
    }

    private void update(){
        double g = cg;
        double d = densl;
        double e = idf;
        double v = volsub;

        e=d*v*g;


        denslTextView.setText(numberFormat.format(d));
        ifTextView.setText(numberFormat.format(e));
        volsubTextView.setText(numberFormat.format(v));
        cgTextView.setText(numberFormat.format(g));
    }

    private TextWatcher denslEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                densl = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                densl = 0.0;
            }
            denslTextView.setText(numberFormat.format(densl));
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

    private TextWatcher volsubEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                volsub = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                volsub = 0.0;
            }
            volsubTextView.setText(numberFormat.format(volsub));
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

    private TextWatcher cgEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                cg = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                cg = 0.0;
            }
            cgTextView.setText(numberFormat.format(cg));
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
