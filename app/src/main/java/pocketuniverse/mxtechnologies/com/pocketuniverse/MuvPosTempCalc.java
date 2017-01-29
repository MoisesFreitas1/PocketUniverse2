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
public class MuvPosTempCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double posicaoi = 0.0;
    private double posicaof = 0.0;
    private double velocidade = 0.0;
    private double aceleracao = 0.0;
    private double tempo = 0.0;
    private TextView posiTextView;
    private TextView posfTextView;
    private TextView tempoTextView;
    private TextView veloTextView;
    private TextView aceleraTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.postemp_muv, container, false);

        posiTextView = (TextView) view.findViewById(R.id.posiTextView);
        aceleraTextView = (TextView) view.findViewById(R.id.aceleraTextView);
        posfTextView = (TextView) view.findViewById(R.id.posfTextView);
        tempoTextView = (TextView) view.findViewById(R.id.tempoTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);

        posiTextView.setText(numberFormat.format(posicaoi));
        aceleraTextView.setText(numberFormat.format(aceleracao));
        posfTextView.setText(numberFormat.format(posicaof));
        tempoTextView.setText(numberFormat.format(tempo));
        veloTextView.setText(numberFormat.format(velocidade));
        update();

        EditText posiEditText = (EditText) view.findViewById(R.id.posiEditText);
        posiEditText.addTextChangedListener(posiEditTextWatcher);
        EditText aceleraEditText = (EditText) view.findViewById(R.id.aceleraEditText);
        aceleraEditText.addTextChangedListener(aceleraEditTextWatcher);
        EditText tempoEditText = (EditText) view.findViewById(R.id.tempoEditText);
        tempoEditText.addTextChangedListener(tempoEditTextWatcher);
        EditText veloEditText = (EditText) view.findViewById(R.id.veloEditText);
        veloEditText.addTextChangedListener(veloEditTextWatcher);
        return view;
    }
        private void update(){
            double vel = velocidade;
            double posi = posicaoi;
            double posf = posicaof;
            double temp = tempo;
            double acel = aceleracao;
            double posf1 = 0.0;
            double posf2 = 0.0;
            double aux1 = vel;
            double aux2 = posi;
            double aux3 = temp;

            posf1 = vel*temp;
            posf2 = acel*(temp*temp)/2;

            posf=posf2+posf1+posi;


            posiTextView.setText(numberFormat.format(posi));
            posfTextView.setText(numberFormat.format(posf));
            tempoTextView.setText(numberFormat.format(temp));
            veloTextView.setText(numberFormat.format(vel));
            aceleraTextView.setText(numberFormat.format(acel));
        }

        private TextWatcher posiEditTextWatcher = new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                try
                {
                    posicaoi = Double.parseDouble(s.toString()) / 100.0;
                }
                catch (NumberFormatException e)
                {
                    posicaoi = 0.0;
                }
                posiTextView.setText(numberFormat.format(posicaoi));
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


        private TextWatcher veloEditTextWatcher = new TextWatcher()
        {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                try
                {
                    velocidade = Double.parseDouble(s.toString()) / 100.0;
                }
                catch (NumberFormatException e)
                {
                    velocidade = 0.0;
                }
                veloTextView.setText(numberFormat.format(velocidade));
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
