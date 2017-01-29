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
public class HEPAPCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double peso = 0.0;
    private double emp = 0.0;
    private double pap = 0.0;
    private TextView pesoTextView;
    private TextView empTextView;
    private TextView papTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_hepap, container, false);

        pesoTextView = (TextView) view.findViewById(R.id.pesoTextView);
        empTextView = (TextView) view.findViewById(R.id.empTextView);
        papTextView = (TextView) view.findViewById(R.id.papTextView);

        pesoTextView.setText(numberFormat.format(peso));
        empTextView.setText(numberFormat.format(emp));
        papTextView.setText(numberFormat.format(pap));
        update();

        EditText pesoEditText = (EditText) view.findViewById(R.id.pesoEditText);
        pesoEditText.addTextChangedListener(pesoEditTextWatcher);
        EditText empEditText = (EditText) view.findViewById(R.id.empEditText);
        empEditText.addTextChangedListener(empEditTextWatcher);

        return view;
    }

    private void update(){
        double p=peso;
        double e=emp;
        double pa;

        pa=p-e;

        pesoTextView.setText(numberFormat.format(p));
        empTextView.setText(numberFormat.format(e));
        papTextView.setText(numberFormat.format(pa));
    }

    private TextWatcher pesoEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                peso = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                peso = 0.0;
            }
            pesoTextView.setText(numberFormat.format(peso));
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

    private TextWatcher empEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                emp = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                emp = 0.0;
            }
            empTextView.setText(numberFormat.format(emp));
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
