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
public class DIQMCalc extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double massa = 0.0;
    private double velo = 0.0;
    private double qm = 0.0;
    private TextView massaTextView;
    private TextView veloTextView;
    private TextView qmTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_diqdm,container,false);

        massaTextView = (TextView) view.findViewById(R.id.massaTextView);
        veloTextView = (TextView) view.findViewById(R.id.veloTextView);
        qmTextView = (TextView) view.findViewById(R.id.qmTextView);

        massaTextView.setText(numberFormat.format(massa));
        veloTextView.setText(numberFormat.format(velo));
        qmTextView.setText(numberFormat.format(qm));
        update();

        EditText massaEditText = (EditText) view.findViewById(R.id.massaEditText);
        massaEditText.addTextChangedListener(massaEditTextWatcher);
        EditText veloEditText = (EditText) view.findViewById(R.id.veloEditText);
        veloEditText.addTextChangedListener(veloEditTextWatcher);
        return view;
    }

    private void update(){
        double m = massa;
        double v = velo;
        double q;

        q=m*v;

        massaTextView.setText(numberFormat.format(m));
        veloTextView.setText(numberFormat.format(v));
        qmTextView.setText(numberFormat.format(q));
    }

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
}
