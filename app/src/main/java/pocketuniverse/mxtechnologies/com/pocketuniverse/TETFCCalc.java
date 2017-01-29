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
public class TETFCCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double forc = 0.0;
    private double desloc = 0.0;
    private double teta = 0.0;
    private double tfc = 0.0;
    private double pi = 3.1415;
    private TextView forcTextView;
    private TextView deslocTextView;
    private TextView tetaTextView;
    private TextView tfcTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_tetfc,container,false);

        forcTextView = (TextView) view.findViewById(R.id.forcTextView);
        deslocTextView = (TextView) view.findViewById(R.id.deslocTextView);
        tetaTextView = (TextView) view.findViewById(R.id.tetaTextView);
        tfcTextView = (TextView) view.findViewById(R.id.tfcTextView);

        forcTextView.setText(numberFormat.format(forc));
        deslocTextView.setText(numberFormat.format(desloc));
        tetaTextView.setText(numberFormat.format(teta));
        tfcTextView.setText(numberFormat.format(tfc));
        update();

        EditText forcEditText = (EditText) view.findViewById(R.id.forcEditText);
        forcEditText.addTextChangedListener(forcEditTextWatcher);
        EditText deslocEditText = (EditText) view.findViewById(R.id.deslocEditText);
        deslocEditText.addTextChangedListener(deslocEditTextWatcher);
        EditText tetaEditText = (EditText) view.findViewById(R.id.tetaEditText);
        tetaEditText.addTextChangedListener(tetaEditTextWatcher);
        return view;
    }

    private void update(){
        double tet = teta;
        double f = forc;
        double d = desloc;
        double t;
        double cosseno;
        double rad;

        rad = (tet*pi)/180;
        cosseno = Math.cos(rad);
        t=f*d*cosseno;



        forcTextView.setText(numberFormat.format(f));
        deslocTextView.setText(numberFormat.format(d));
        tetaTextView.setText(numberFormat.format(tet));
        tfcTextView.setText(numberFormat.format(t));
    }

    private TextWatcher forcEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                forc = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                forc = 0.0;
            }
            forcTextView.setText(numberFormat.format(forc));
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

    private TextWatcher deslocEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                desloc = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                desloc = 0.0;
            }
            deslocTextView.setText(numberFormat.format(desloc));
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
