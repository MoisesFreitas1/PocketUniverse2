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
public class PRPMCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double trab = 0.0;
    private double tempo = 0.0;
    private double pm = 0.0;
    private TextView trabTextView;
    private TextView tempoTextView;
    private TextView pmTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_prpm, container, false);

        trabTextView = (TextView) view.findViewById(R.id.trabTextView);
        tempoTextView = (TextView) view.findViewById(R.id.tempoTextView);
        pmTextView = (TextView) view.findViewById(R.id.pmTextView);

        trabTextView.setText(numberFormat.format(trab));
        tempoTextView.setText(numberFormat.format(tempo));
        pmTextView.setText(numberFormat.format(pm));
        update();

        EditText trabEditText = (EditText) view.findViewById(R.id.trabEditText);
        trabEditText.addTextChangedListener(trabEditTextWatcher);
        EditText tempoEditText = (EditText) view.findViewById(R.id.tempoEditText);
        tempoEditText.addTextChangedListener(tempoEditTextWatcher);

        return view;
    }

    private void update(){
        double t=trab;
        double tm=tempo;
        double p;

        p=t/tm;

        trabTextView.setText(numberFormat.format(t));
        tempoTextView.setText(numberFormat.format(tm));
        pmTextView.setText(numberFormat.format(p));
    }

    private TextWatcher trabEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                trab = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                trab = 0.0;
            }
            trabTextView.setText(numberFormat.format(trab));
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

    private TextWatcher tempoEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                tempo = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                tempo = 0.0;
            }
            tempoTextView.setText(numberFormat.format(tempo));
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
