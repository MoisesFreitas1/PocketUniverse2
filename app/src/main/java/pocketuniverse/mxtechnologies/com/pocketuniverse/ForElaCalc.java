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
public class ForElaCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double consela = 0.0;
    private double deform = 0.0;
    private double forela = 0.0;
    private TextView conselaTextView;
    private TextView deformTextView;
    private TextView forelaTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_forela, container, false);

        conselaTextView = (TextView) view.findViewById(R.id.conselaTextView);
        deformTextView = (TextView) view.findViewById(R.id.deformTextView);
        forelaTextView = (TextView) view.findViewById(R.id.forelaTextView);

        conselaTextView.setText(numberFormat.format(consela));
        deformTextView.setText(numberFormat.format(deform));
        forelaTextView.setText(numberFormat.format(forela));
        update();

        EditText conselaEditText = (EditText) view.findViewById(R.id.conselaEditText);
        conselaEditText.addTextChangedListener(conselaEditTextWatcher);
        EditText deformEditText = (EditText) view.findViewById(R.id.deformEditText);
        deformEditText.addTextChangedListener(deformEditTextWatcher);

        return view;
    }

    private void update(){
        double k=consela;
        double dx=deform;
        double fe;

        fe=k*dx;

        conselaTextView.setText(numberFormat.format(k));
        deformTextView.setText(numberFormat.format(dx));
        forelaTextView.setText(numberFormat.format(fe));
    }

    private TextWatcher conselaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                consela = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                consela = 0.0;
            }
            conselaTextView.setText(numberFormat.format(consela));
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

    private TextWatcher deformEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                deform = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                deform = 0.0;
            }
            deformTextView.setText(numberFormat.format(deform));
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
