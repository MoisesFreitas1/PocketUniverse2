package pocketuniverse.mxtechnologies.com.pocketuniverse;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MecanicaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager FM;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecanica);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FM = getFragmentManager();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6303877676651382/5970476555");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.vem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormVelEscMed()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.aem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormAceEscMed()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mru_postem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMru()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.muv_postem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMuvPosTemp()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.muv_veltem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMuvVelTem()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.muv_veldes) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMuvVelDesl()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.muv_vm) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMuvVm()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.muv_lo) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMuvLO()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mv_postem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMvPosTem()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mv_veltem) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMvVelTem()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mv_velpos) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMvVelPos()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mcu_fp) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMcuFrePer()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mcu_velang) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMcuVelAng()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.mcu_vellin) {
            FM.beginTransaction().replace(R.id.content_principal, new FormMcuVelLin()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.ln_pl) {
            FM.beginTransaction().replace(R.id.content_principal, new FormLN1L()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.ln_sl) {
            FM.beginTransaction().replace(R.id.content_principal, new FormLN2L()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.ln_tl) {
            FM.beginTransaction().replace(R.id.content_principal, new FormLN3L()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.ln_fp) {
            FM.beginTransaction().replace(R.id.content_principal, new FormLNFP()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.pi) {
            FM.beginTransaction().replace(R.id.content_principal, new FormPlanIncl()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fe) {
            FM.beginTransaction().replace(R.id.content_principal, new FormForEla()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fe_ams) {
            FM.beginTransaction().replace(R.id.content_principal, new FormForElaMS()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fe_amp) {
            FM.beginTransaction().replace(R.id.content_principal, new FormForElaMP()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fa_em) {
            FM.beginTransaction().replace(R.id.content_principal, new FormFAEM()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fa_c) {
            FM.beginTransaction().replace(R.id.content_principal, new FormFAC()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.fc) {
            FM.beginTransaction().replace(R.id.content_principal, new FormFCent()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_tfc) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTETFC()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_tp) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTETP()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_tfe) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTETFE()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_ec) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTEEC()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_tec) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTETEC()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_epg) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTEEPG()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.te_epe) {
            FM.beginTransaction().replace(R.id.content_principal, new FormTEEPE()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.pr_pm) {
            FM.beginTransaction().replace(R.id.content_principal, new FormPRPM()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.pr_r) {
            FM.beginTransaction().replace(R.id.content_principal, new FormPRR()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        //} else if (id == R.id.gu_fg) {
        //    FM.beginTransaction().replace(R.id.content_principal, new FormGUFG()).addToBackStack(null).commit();             if (mInterstitialAd.isLoaded()) {                 mInterstitialAd.show();             }
        } else if (id == R.id.gu_cg) {
            FM.beginTransaction().replace(R.id.content_principal, new FormGUCG()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.di_qm) {
            FM.beginTransaction().replace(R.id.content_principal, new FormDIQM()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.di_if) {
            FM.beginTransaction().replace(R.id.content_principal, new FormDIIdF()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.di_ti) {
            FM.beginTransaction().replace(R.id.content_principal, new FormDITDI()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.e_epm) {
            FM.beginTransaction().replace(R.id.content_principal, new FormEdPM()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.e_mf) {
            FM.beginTransaction().replace(R.id.content_principal, new FormEMF()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.hs_d) {
            FM.beginTransaction().replace(R.id.content_principal, new FormHED()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.hs_p) {
            FM.beginTransaction().replace(R.id.content_principal, new FormHEP()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.hs_e) {
            FM.beginTransaction().replace(R.id.content_principal, new FormHEE()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        } else if (id == R.id.hs_pap) {
            FM.beginTransaction().replace(R.id.content_principal, new FormHEPAP()).addToBackStack(null).commit();
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
}
