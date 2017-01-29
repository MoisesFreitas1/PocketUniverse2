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
public class DITDICalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double veloi = 0.0;
    private double velo = 0.0;
    private double massa = 0.0;
    private double idf = 0.0;
    private TextView veloiTextView;
    private TextView veloTextView;
    private TextView massaTextView;
    private TextView ifTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_ditdi,container,false);

        veloiTextView = (TextView) view.findViewById(R.id.veloiTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);
        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        ifTextView = (TextView) view.findViewById(R.id.ifTextView);

        veloiTextView.setText(numberFormat.format(veloi));
        veloTextView.setText(numberFormat.format(velo));
        massaTextView.setText(numberFormat.format(massa));
        ifTextView.setText(numberFormat.format(idf));
        update();

        EditText veloiEditText = (EditText) view.findViewById(R.id.veloiEditText);
        veloiEditText.addTextChangedListener(veloiEditTextWatcher);
        EditText veloEditText = (EditText) view.findViewById(R.id.veloEditText);
        veloEditText.addTextChangedListener(veloEditTextWatcher);
        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        return view;
    }

    private void update(){
        double vi = veloi;
        double v = velo;
        double m = massa;
        double i;

        i=m*(v-vi);

        veloiTextView.setText(numberFormat.format(vi));
        veloTextView.setText(numberFormat.format(v));
        massaTextView.setText(numberFormat.format(m));
        ifTextView.setText(numberFormat.format(i));
    }

    private TextWatcher veloiEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                veloi = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                veloi = 0.0;
            }
            veloiTextView.setText(numberFormat.format(veloi));
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
                velo = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velo = 0.0;
            }
            veloTextView.setText(numberFormat.format(velo));
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

    private TextWatcher massaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                massa = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                massa = 0.0;
            }
            massaTextView.setText(numberFormat.format(massa));
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
