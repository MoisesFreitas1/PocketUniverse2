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
public class MuvVmCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double velm = 0.0;
    private double velf = 0.0;
    private double veli = 0.0;
    private TextView velfTextView;
    private TextView veliTextView;
    private TextView vemTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_muvvm, container, false);

        velfTextView = (TextView) view.findViewById(R.id.velfTextView);
        veliTextView = (TextView) view.findViewById(R.id.veliTextView);
        vemTextView = (TextView) view.findViewById(R.id.vemTextView);

        velfTextView.setText(numberFormat.format(velf));
        veliTextView.setText(numberFormat.format(veli));
        vemTextView.setText(numberFormat.format(velm));
        update();

        EditText velfEditText = (EditText) view.findViewById(R.id.velfEditText);
        velfEditText.addTextChangedListener(velfEditTextWatcher);
        EditText veliEditText = (EditText) view.findViewById(R.id.veliEditText);
        veliEditText.addTextChangedListener(veliEditTextWatcher);
        return view;
    }

    private void update(){
        double velof = velf;
        double veloi = veli;
        double velom = velm;

        velom = (velof+veloi)/2;

        velfTextView.setText(numberFormat.format(velof));
        veliTextView.setText(numberFormat.format(veloi));
        vemTextView.setText(numberFormat.format(velom));

    }

    private TextWatcher velfEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                velf = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                velf = 0.0;
            }
            velfTextView.setText(numberFormat.format(velf));
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

    private TextWatcher veliEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count)
        {
            try
            {
                veli = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                veli = 0.0;
            }
            veliTextView.setText(numberFormat.format(veli));
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
