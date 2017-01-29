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
public class PlanInclCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double peso = 0.0;
    private double teta = 0.0;
    private double peson=0;
    private double pesot=0;
    private double pi = 3.1415;
    private TextView pesoTextView;
    private TextView tetaTextView;
    private TextView pesonTextView;
    private TextView pesotTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_planincl, container, false);

        pesoTextView = (TextView) view.findViewById(R.id.pesoTextView);
        tetaTextView = (TextView) view.findViewById(R.id.tetaTextView);
        pesonTextView = (TextView) view.findViewById(R.id.pesonTextView);
        pesotTextView = (TextView) view.findViewById(R.id.pesotTextView);

        pesoTextView.setText(numberFormat.format(peso));
        tetaTextView.setText(numberFormat.format(teta));
        pesonTextView.setText(numberFormat.format(peson));
        pesotTextView.setText(numberFormat.format(pesot));
        update();

        EditText pesoEditText = (EditText) view.findViewById(R.id.pesoEditText);
        pesoEditText.addTextChangedListener(pesoEditTextWatcher);
        EditText tetaEditText = (EditText) view.findViewById(R.id.tetaEditText);
        tetaEditText.addTextChangedListener(tetaEditTextWatcher);
        return view;
    }

    private void update(){

        double p = peso;
        double tet = teta;
        double pn;
        double pt;
        double seno;
        double cosseno;
        double rad;

        rad = (tet*pi)/180;
        seno = Math.sin(rad);
        cosseno = Math.cos(rad);
        pn = p*cosseno;
        pt = p*seno;


        pesoTextView.setText(numberFormat.format(p));
        tetaTextView.setText(numberFormat.format(tet));
        pesotTextView.setText(numberFormat.format(pt));
        pesonTextView.setText(numberFormat.format(pn));
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

    private TextWatcher tetaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                teta = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                teta = 0.0;
            }
            tetaTextView.setText(numberFormat.format(teta));
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