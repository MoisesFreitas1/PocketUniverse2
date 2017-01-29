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
public class MuvLOCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velinicial = 0.0;
    private double teta = 0.0;
    private double velx = 0.0;
    private double vely = 0.0;
    private double pi = 3.1415;
    private TextView veloiTextView;
    private TextView tetaTextView;
    private TextView veloxTextView;
    private TextView veloyTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_muvlo, container, false);

        veloiTextView = (TextView) view.findViewById(R.id.veloiTextView);
        tetaTextView = (TextView) view.findViewById(R.id.tetaTextView);
        veloxTextView = (TextView) view.findViewById(R.id.veloxTextView);
        veloyTextView = (TextView) view.findViewById(R.id.veloyTextView);

        veloiTextView.setText(numberFormat.format(velinicial));
        tetaTextView.setText(numberFormat.format(teta));
        veloxTextView.setText(numberFormat.format(velx));
        veloyTextView.setText(numberFormat.format(vely));
        update();

        EditText veloiEditText = (EditText) view.findViewById(R.id.veloiEditText);
        veloiEditText.addTextChangedListener(veloiEditTextWatcher);
        EditText tetaEditText = (EditText) view.findViewById(R.id.tetaEditText);
        tetaEditText.addTextChangedListener(tetaEditTextWatcher);
        return view;
    }

    private void update(){

        double veli = velinicial;
        double tet = teta;
        double velox = velx;
        double veloy = vely;
        double seno = 0.0;
        double cosseno = 0.0;
        double rad = 0.0;

        rad = (tet*pi)/180;
        seno = Math.sin(rad);
        cosseno = Math.cos(rad);
        velox = veli*cosseno;
        veloy = veli*seno;


        veloiTextView.setText(numberFormat.format(veli));
        tetaTextView.setText(numberFormat.format(tet));
        veloxTextView.setText(numberFormat.format(velox));
        veloyTextView.setText(numberFormat.format(veloy));
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