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
public class HEPCalc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    private double forcn = 0.0;
    private double area = 0.0;
    private double pres = 0.0;
    private TextView forcnTextView;
    private TextView areaTextView;
    private TextView presTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calc_hep, container, false);

        forcnTextView = (TextView) view.findViewById(R.id.forcnTextView);
        areaTextView = (TextView) view.findViewById(R.id.areaTextView);
        presTextView = (TextView) view.findViewById(R.id.presTextView);

        forcnTextView.setText(numberFormat.format(forcn));
        areaTextView.setText(numberFormat.format(area));
        presTextView.setText(numberFormat.format(pres));
        update();

        EditText forcnEditText = (EditText) view.findViewById(R.id.forcnEditText);
        forcnEditText.addTextChangedListener(forcnEditTextWatcher);
        EditText areaEditText = (EditText) view.findViewById(R.id.areaEditText);
        areaEditText.addTextChangedListener(areaEditTextWatcher);

        return view;
    }

    private void update(){
        double fn=forcn;
        double a=area;
        double p;

        p=fn/a;

        forcnTextView.setText(numberFormat.format(fn));
        areaTextView.setText(numberFormat.format(a));
        presTextView.setText(numberFormat.format(p));
    }

    private TextWatcher forcnEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                forcn = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                forcn = 0.0;
            }
            forcnTextView.setText(numberFormat.format(forcn));
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

    private TextWatcher areaEditTextWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                area = Double.parseDouble(s.toString()) / 100.0;
            }
            catch (NumberFormatException e)
            {
                area = 0.0;
            }
            areaTextView.setText(numberFormat.format(area));
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
