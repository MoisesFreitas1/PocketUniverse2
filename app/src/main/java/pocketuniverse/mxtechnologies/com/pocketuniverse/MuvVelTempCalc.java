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
 * Created by Moisés on 03/03/2016.
 */
public class MuvVelTempCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velfinal = 0.0;
    private double velinicial = 0.0;
    private double aceleracao = 0.0;
    private double tempo = 0.0;
    private TextView veloiTextView;
    private TextView tempoTextView;
    private TextView veloTextView;
    private TextView aceleraTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_muvveltem, container, false);

        veloiTextView = (TextView) view.findViewById(R.id.veloiTextView);
        tempoTextView = (TextView) view.findViewById(R.id.tempoTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);
        aceleraTextView = (TextView) view.findViewById(R.id.aceleraTextView);

        veloiTextView.setText(numberFormat.format(velinicial));
        tempoTextView.setText(numberFormat.format(tempo));
        veloTextView.setText(numberFormat.format(velfinal));
        aceleraTextView.setText(numberFormat.format(aceleracao));
        update();

        EditText veloiEditText = (EditText) view.findViewById(R.id.veloiEditText);
        veloiEditText.addTextChangedListener(veloiEditTextWatcher);
        EditText tempoEditText = (EditText) view.findViewById(R.id.tempoEditText);
        tempoEditText.addTextChangedListener(tempoEditTextWatcher);
        EditText aceleraEditText = (EditText) view.findViewById(R.id.aceleraEditText);
        aceleraEditText.addTextChangedListener(aceleraEditTextWatcher);

        return view;
    }
    private void update(){

        double velf = velfinal;
        double veli = velinicial;
        double temp = tempo;
        double acel = aceleracao;
        double velf1;

        velf1 = acel*temp;
        velf=velf1+veli;

        veloiTextView.setText(numberFormat.format(veli));
        tempoTextView.setText(numberFormat.format(temp));
        veloTextView.setText(numberFormat.format(velf));
        aceleraTextView.setText(numberFormat.format(acel));
    }

    private TextWatcher veloiEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                velinicial = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velinicial = 0.0;
            }
            veloiTextView.setText(numberFormat.format(velinicial));
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

    private TextWatcher aceleraEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                aceleracao = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                aceleracao = 0.0;
            }
            aceleraTextView.setText(numberFormat.format(aceleracao));
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
