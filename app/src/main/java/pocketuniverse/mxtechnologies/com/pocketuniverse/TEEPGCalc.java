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
public class TEEPGCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double altura = 0.0;
    private double cg = 0.0;
    private double teepg = 0.0;
    private TextView massaTextView;
    private TextView alturaTextView;
    private TextView cgTextView;
    private TextView teepgTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_teepg,container,false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        alturaTextView = (TextView) view.findViewById(R.id.alturaTextView);
        cgTextView = (TextView) view.findViewById(R.id.cgTextView);
        teepgTextView = (TextView) view.findViewById(R.id.teepgTextView);

        massaTextView.setText(numberFormat.format(massa));
        alturaTextView.setText(numberFormat.format(altura));
        cgTextView.setText(numberFormat.format(cg));
        teepgTextView.setText(numberFormat.format(teepg));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText alturaEditText = (EditText) view.findViewById(R.id.alturaEditText);
        alturaEditText.addTextChangedListener(alturaEditTextWatcher);
        EditText cgEditText = (EditText) view.findViewById(R.id.cgEditText);
        cgEditText.addTextChangedListener(cgEditTextWatcher);
        return view;
    }

    private void update(){
        double g = cg;
        double m = massa;
        double h = altura;
        double t;

        t=m*g*h;

        massaTextView.setText(numberFormat.format(m));
        alturaTextView.setText(numberFormat.format(h));
        cgTextView.setText(numberFormat.format(g));
        teepgTextView.setText(numberFormat.format(t));
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

    private TextWatcher alturaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                altura = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                altura = 0.0;
            }
            alturaTextView.setText(numberFormat.format(altura));
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