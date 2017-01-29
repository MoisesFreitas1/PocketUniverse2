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
public class ForElaMSCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double consela1 = 0.0;
    private double consela2 = 0.0;
    private double conselaeq = 0.0;
    private TextView consela1TextView;
    private TextView consela2TextView;
    private TextView conselaeqTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_forelams, container, false);

        consela1TextView = (TextView) view.findViewById(R.id.consela1TextView);
        consela2TextView = (TextView) view.findViewById(R.id.consela2TextView);
        conselaeqTextView = (TextView) view.findViewById(R.id.conselaeqTextView);

        consela1TextView.setText(numberFormat.format(consela1));
        consela2TextView.setText(numberFormat.format(consela2));
        conselaeqTextView.setText(numberFormat.format(conselaeq));
        update();

        EditText consela1EditText = (EditText) view.findViewById(R.id.consela1EditText);
        consela1EditText.addTextChangedListener(consela1EditTextWatcher);
        EditText consela2EditText = (EditText) view.findViewById(R.id.consela2EditText);
        consela2EditText.addTextChangedListener(consela2EditTextWatcher);

        return view;
    }

    private void update(){
        double k1=consela1;
        double k2=consela2;
        double ke;

        ke=(k1*k2)/(k1+k2);

        consela1TextView.setText(numberFormat.format(k1));
        consela2TextView.setText(numberFormat.format(k2));
        conselaeqTextView.setText(numberFormat.format(ke));
    }

    private TextWatcher consela1EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                consela1 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                consela1 = 0.0;
            }
            consela1TextView.setText(numberFormat.format(consela1));
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

    private TextWatcher consela2EditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                consela2 = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                consela2 = 0.0;
            }
            consela2TextView.setText(numberFormat.format(consela2));
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
