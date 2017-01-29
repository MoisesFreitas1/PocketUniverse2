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
public class EMFCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double forc = 0.0;
    private double desl = 0.0;
    private double mf = 0.0;
    private TextView forcTextView;
    private TextView deslTextView;
    private TextView mfTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_edcmduf, container, false);

        forcTextView = (TextView) view.findViewById(R.id.forcTextView);
        deslTextView = (TextView) view.findViewById(R.id.deslTextView);
        mfTextView = (TextView) view.findViewById(R.id.mfTextView);

        forcTextView.setText(numberFormat.format(forc));
        deslTextView.setText(numberFormat.format(desl));
        mfTextView.setText(numberFormat.format(mf));
        update();

        EditText forcEditText = (EditText) view.findViewById(R.id.forcEditText);
        forcEditText.addTextChangedListener(forcEditTextWatcher);
        EditText deslEditText = (EditText) view.findViewById(R.id.deslEditText);
        deslEditText.addTextChangedListener(deslEditTextWatcher);

        return view;
    }

    private void update(){
        double f=forc;
        double dx=desl;
        double m;

        m=f*dx;

        forcTextView.setText(numberFormat.format(f));
        deslTextView.setText(numberFormat.format(dx));
        mfTextView.setText(numberFormat.format(m));
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

    private TextWatcher deslEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                desl = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                desl = 0.0;
            }
            deslTextView.setText(numberFormat.format(desl));
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
