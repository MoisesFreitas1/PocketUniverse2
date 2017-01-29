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
public class FAEMCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double cem = 0.0;
    private double forcan = 0.0;
    private double faem = 0.0;
    private TextView cemTextView;
    private TextView forcanTextView;
    private TextView faemTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_faem, container, false);

        cemTextView = (TextView) view.findViewById(R.id.cemTextView);
        forcanTextView = (TextView) view.findViewById(R.id.forcanTextView);
        faemTextView = (TextView) view.findViewById(R.id.faemTextView);

        cemTextView.setText(numberFormat.format(cem));
        forcanTextView.setText(numberFormat.format(forcan));
        faemTextView.setText(numberFormat.format(faem));
        update();

        EditText cemEditText = (EditText) view.findViewById(R.id.cemEditText);
        cemEditText.addTextChangedListener(cemEditTextWatcher);
        EditText forcanEditText = (EditText) view.findViewById(R.id.forcanEditText);
        forcanEditText.addTextChangedListener(forcanEditTextWatcher);

        return view;
    }

    private void update(){
        double u=cem;
        double N=forcan;
        double fa;

        fa=u*N;

        cemTextView.setText(numberFormat.format(cem));
        forcanTextView.setText(numberFormat.format(forcan));
        faemTextView.setText(numberFormat.format(fa));
    }

    private TextWatcher cemEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                cem = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                cem = 0.0;
            }
            cemTextView.setText(numberFormat.format(cem));
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

    private TextWatcher forcanEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                forcan = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                forcan = 0.0;
            }
            forcanTextView.setText(numberFormat.format(forcan));
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
