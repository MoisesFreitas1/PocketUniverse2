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
public class TEEPECalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double consela = 0.0;
    private double deform = 0.0;
    private double teepe = 0.0;
    private TextView conselaTextView;
    private TextView deformTextView;
    private TextView teepeTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_teepe, container, false);

        conselaTextView = (TextView) view.findViewById(R.id.conselaTextView);
        deformTextView = (TextView) view.findViewById(R.id.deformTextView);
        teepeTextView = (TextView) view.findViewById(R.id.teepeTextView);

        conselaTextView.setText(numberFormat.format(consela));
        deformTextView.setText(numberFormat.format(deform));
        teepeTextView.setText(numberFormat.format(teepe));
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
        double t;

        t=k*(dx*dx)/2;

        conselaTextView.setText(numberFormat.format(k));
        deformTextView.setText(numberFormat.format(dx));
        teepeTextView.setText(numberFormat.format(t));
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
