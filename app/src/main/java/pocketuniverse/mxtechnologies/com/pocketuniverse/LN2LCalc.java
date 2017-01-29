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
public class LN2LCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double acel = 0.0;
    private double forc = 0.0;
    private TextView massaTextView;
    private TextView acelTextView;
    private TextView forcaTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_ldn2l, container, false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        acelTextView = (TextView) view.findViewById(R.id.acelTextView);
        forcaTextView = (TextView) view.findViewById(R.id.forcaTextView);

        massaTextView.setText(numberFormat.format(massa));
        acelTextView.setText(numberFormat.format(acel));
        forcaTextView.setText(numberFormat.format(forc));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText acelEditText = (EditText) view.findViewById(R.id.acelEditText);
        acelEditText.addTextChangedListener(acelEditTextWatcher);

        return view;
    }

    private void update(){
        double m=massa;
        double a=acel;
        double f;

        f=m*a;

        massaTextView.setText(numberFormat.format(m));
        acelTextView.setText(numberFormat.format(a));
        forcaTextView.setText(numberFormat.format(f));
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

    private TextWatcher acelEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                acel = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                acel = 0.0;
            }
            acelTextView.setText(numberFormat.format(acel));
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
