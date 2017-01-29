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
public class McuVelLinCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velang = 0.0;
    private double raio = 0.0;
    private double vellin = 0.0;
    private TextView velangTextView;
    private TextView raioTextView;
    private TextView vellinTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_mcuvellin, container, false);

        velangTextView = (TextView) view.findViewById(R.id.velangTextView);
        raioTextView = (TextView) view.findViewById(R.id.raioTextView);
        vellinTextView = (TextView) view.findViewById(R.id.vellinTextView);

        velangTextView.setText(numberFormat.format(velang));
        raioTextView.setText(numberFormat.format(raio));
        vellinTextView.setText(numberFormat.format(vellin));
        update();

        EditText velangEditText = (EditText) view.findViewById(R.id.velangEditText);
        velangEditText.addTextChangedListener(velangEditTextWatcher);
        EditText raioEditText = (EditText) view.findViewById(R.id.raioEditText);
        raioEditText.addTextChangedListener(raioEditTextWatcher);

        return view;
    }

    private void update(){
        double vang=velang;
        double r=raio;
        double vl;

        vl=vang*r;

        velangTextView.setText(numberFormat.format(vang));
        raioTextView.setText(numberFormat.format(r));
        vellinTextView.setText(numberFormat.format(vl));
    }

    private TextWatcher velangEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                velang = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velang = 0.0;
            }
            velangTextView.setText(numberFormat.format(velang));
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

    private TextWatcher raioEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                raio = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                raio = 0.0;
            }
            raioTextView.setText(numberFormat.format(raio));
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
