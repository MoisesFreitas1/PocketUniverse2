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
public class GUCGCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double m1 = 0.0;
    private double dist = 0.0;
    private double cg = 0.0;
    private TextView massaTextView;
    private TextView distTextView;
    private TextView cgTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_gucg,container,false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        distTextView = (TextView) view.findViewById(R.id.distTextView);
        cgTextView = (TextView) view.findViewById(R.id.cgTextView);

        massaTextView.setText(numberFormat.format(m1));
        distTextView.setText(numberFormat.format(dist));
        cgTextView.setText(numberFormat.format(cg));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText distEditText = (EditText) view.findViewById(R.id.distEditText);
        distEditText.addTextChangedListener(distEditTextWatcher);
        return view;
    }

    private void update(){
        double m11 = m1;
        double d = dist;
        double f;
        double g=0.0000000000667408;

        f=g*m11/(d*d);

        massaTextView.setText(numberFormat.format(m11));
        distTextView.setText(numberFormat.format(d));
        cgTextView.setText(numberFormat.format(f));
    }

    private TextWatcher massaEditTextWatcher = new TextWatcher()
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
            massaTextView.setText(numberFormat.format(m1));
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
}
