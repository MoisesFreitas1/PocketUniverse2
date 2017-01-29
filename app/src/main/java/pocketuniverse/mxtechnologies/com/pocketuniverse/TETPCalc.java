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
public class TETPCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double deslocv = 0.0;
    private double cg = 0.0;
    private double tetp = 0.0;
    private TextView massaTextView;
    private TextView deslocvTextView;
    private TextView cgTextView;
    private TextView tetpTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_tetp,container,false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        deslocvTextView = (TextView) view.findViewById(R.id.deslocvTextView);
        cgTextView = (TextView) view.findViewById(R.id.cgTextView);
        tetpTextView = (TextView) view.findViewById(R.id.tetpTextView);

        massaTextView.setText(numberFormat.format(massa));
        deslocvTextView.setText(numberFormat.format(deslocv));
        cgTextView.setText(numberFormat.format(cg));
        tetpTextView.setText(numberFormat.format(tetp));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText deslocvEditText = (EditText) view.findViewById(R.id.deslocvEditText);
        deslocvEditText.addTextChangedListener(deslocvEditTextWatcher);
        EditText cgEditText = (EditText) view.findViewById(R.id.cgEditText);
        cgEditText.addTextChangedListener(cgEditTextWatcher);
        return view;
    }

    private void update(){
        double g = cg;
        double m = massa;
        double h = deslocv;
        double t;

        t=m*g*h;

        massaTextView.setText(numberFormat.format(m));
        deslocvTextView.setText(numberFormat.format(h));
        cgTextView.setText(numberFormat.format(g));
        tetpTextView.setText(numberFormat.format(t));
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

    private TextWatcher deslocvEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                deslocv = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                deslocv = 0.0;
            }
            deslocvTextView.setText(numberFormat.format(deslocv));
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