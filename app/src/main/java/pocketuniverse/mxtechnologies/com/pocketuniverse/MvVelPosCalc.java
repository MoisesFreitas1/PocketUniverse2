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
 * Created by Moisés on 11/03/2016.
 */
public class MvVelPosCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velfinal = 0.0;
    private double velinicial = 0.0;
    private double aceleracao = 0.0;
    private double deslocamento = 0.0;
    private TextView veloiTextView;
    private TextView deslTextView;
    private TextView veloTextView;
    private TextView aceleraTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_muvveldes, container, false);

        veloiTextView = (TextView) view.findViewById(R.id.veloiTextView);
        deslTextView = (TextView) view.findViewById(R.id.deslTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);
        aceleraTextView = (TextView) view.findViewById(R.id.aceleraTextView);

        veloiTextView.setText(numberFormat.format(velinicial));
        deslTextView.setText(numberFormat.format(deslocamento));
        veloTextView.setText(numberFormat.format(velfinal));
        aceleraTextView.setText(numberFormat.format(aceleracao));
        update();

        EditText veloiEditText = (EditText) view.findViewById(R.id.veloiEditText);
        veloiEditText.addTextChangedListener(veloiEditTextWatcher);
        EditText deslEditText = (EditText) view.findViewById(R.id.deslEditText);
        deslEditText.addTextChangedListener(deslEditTextWatcher);
        EditText aceleraEditText = (EditText) view.findViewById(R.id.aceleraEditText);
        aceleraEditText.addTextChangedListener(aceleraEditTextWatcher);

        return view;
    }

    private void update(){

        double velf = velfinal;
        double veli = velinicial;
        double desl = deslocamento;
        double acel = aceleracao;
        double velfqd;
        double velfqd1;
        double velfqd2;

        velfqd1 = (veli*veli);
        velfqd2 = (-1)*2*acel*desl;

        velfqd=velfqd1+velfqd2;


        veloiTextView.setText(numberFormat.format(veli));
        deslTextView.setText(numberFormat.format(desl));
        veloTextView.setText(numberFormat.format(velfqd));
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

    private TextWatcher deslEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                deslocamento = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                deslocamento = 0.0;
            }
            deslTextView.setText(numberFormat.format(deslocamento));
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
