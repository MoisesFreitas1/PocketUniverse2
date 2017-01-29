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
public class DIIdFCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double forca = 0.0;
    private double dur = 0.0;
    private double idf = 0.0;
    private TextView forcaTextView;
    private TextView durTextView;
    private TextView ifTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_diiduf,container,false);

        forcaTextView = (TextView) view.findViewById(R.id.forcaTextView);
        durTextView = (TextView) view.findViewById(R.id.durTextView);
        ifTextView = (TextView) view.findViewById(R.id.ifTextView);

        forcaTextView.setText(numberFormat.format(forca));
        durTextView.setText(numberFormat.format(dur));
        ifTextView.setText(numberFormat.format(idf));
        update();

        EditText forcaEditText = (EditText) view.findViewById(R.id.forcaEditText);
        forcaEditText.addTextChangedListener(forcaEditTextWatcher);
        EditText durEditText = (EditText) view.findViewById(R.id.durEditText);
        durEditText.addTextChangedListener(durEditTextWatcher);
        return view;
    }

    private void update(){
        double f = forca;
        double t = dur;
        double i;

        i=f*t;

        forcaTextView.setText(numberFormat.format(f));
        durTextView.setText(numberFormat.format(t));
        ifTextView.setText(numberFormat.format(i));
    }

    private TextWatcher forcaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                forca = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                forca = 0.0;
            }
            forcaTextView.setText(numberFormat.format(forca));
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

    private TextWatcher durEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                dur = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                dur = 0.0;
            }
            durTextView.setText(numberFormat.format(dur));
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
