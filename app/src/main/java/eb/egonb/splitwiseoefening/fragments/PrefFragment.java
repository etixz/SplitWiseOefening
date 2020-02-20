package eb.egonb.splitwiseoefening.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import eb.egonb.splitwiseoefening.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrefFragment extends PreferenceFragmentCompat {

    public static PrefFragment newInstance(){
        return new PrefFragment();
    }



    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Inflate the layout for this fragment
        setPreferencesFromResource(R.xml.preferences, rootKey);

        final EditTextPreference numberPreference = findPreference("pref_tip");
        if(numberPreference != null){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
            String tipKey = "pref_tip";
            numberPreference.setSummary("€" + prefs.getString(tipKey, ""));
            numberPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
                @Override
                public void onBindEditText(@NonNull EditText editText) {
                    editText.setInputType(InputType.TYPE_CLASS_NUMBER);

                }
            });
            numberPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                    String tipKey = "pref_tip";
                    prefs.getString(tipKey, "");
                    numberPreference.setText("" + newValue);
                    numberPreference.setSummary("€" + newValue);

                    return false;
                }

            });
        }
    }

    /*@Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditTextPreference numberPreference = findPreference("pref_tip");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipKey = "pref_tip";
        numberPreference.setSummary("€" + prefs.getString(tipKey, ""));
    }

    @Override
    public void onStart() {
        super.onStart();
        EditTextPreference numberPreference = findPreference("pref_tip");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipKey = "pref_tip";
        numberPreference.setSummary("€" + prefs.getString(tipKey, ""));
    }*/
}
