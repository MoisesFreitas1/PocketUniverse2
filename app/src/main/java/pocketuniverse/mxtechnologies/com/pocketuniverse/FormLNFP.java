package pocketuniverse.mxtechnologies.com.pocketuniverse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Moisés on 14/03/2016.
 */
public class FormLNFP extends Fragment {
    FragmentManager FM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ldn_fp,container,false);
        FM = getFragmentManager();

        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button buttonldnfp = (Button)view.findViewById(R.id.buttonldnfp);
        buttonldnfp.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        FM.beginTransaction().replace(R.id.content_principal, new LNFPCalc()).addToBackStack(null).commit();
                    }
                });
        return view;
    }
}