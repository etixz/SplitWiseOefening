package eb.egonb.splitwiseoefening.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import eb.egonb.splitwiseoefening.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplitFragment extends Fragment {

    private EditText etAmount, etTip, etParty;
    private TextView tvSplitAmount;

    private View.OnClickListener splitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(etAmount.getText().toString().isEmpty() || etTip.getText().toString().isEmpty() || etParty.getText().toString().isEmpty()){
                tvSplitAmount.setText("Gelieve de velden in te vullen om te berekenen!");
            }
            else{

                String amount = etAmount.getText().toString();
                double amountNaarDouble = Double.valueOf(amount);

                String tip = etTip.getText().toString();
                double tipNaarDouble = Double.valueOf(tip);

                String party = etParty.getText().toString();
                double partyNaarDouble = Double.valueOf(party);

                double splitAmount = (tipNaarDouble + amountNaarDouble) / partyNaarDouble;
                tvSplitAmount.setText(String.format("Elke persoon moet: €%.2f betalen!", splitAmount));
                Toast.makeText(getActivity(), "The amount " + (amountNaarDouble + tipNaarDouble) + " has been divided between " + partyNaarDouble + " people", Toast.LENGTH_SHORT).show();

            }
        }
    };


    public SplitFragment() {
        // Required empty public constructor
    }

    public static SplitFragment newInstance(){
        return new SplitFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_split, container, false);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        etAmount = rootView.findViewById(R.id.et_amount);
        etTip = rootView.findViewById(R.id.et_tip);

        String tipKey = "pref_tip";
        etTip.setText(prefs.getString(tipKey, ""));
        etParty = rootView.findViewById(R.id.et_party);

        tvSplitAmount = rootView.findViewById(R.id.tv_splitAmount);

        Button splitButton = rootView.findViewById(R.id.btn_split);
        splitButton.setOnClickListener(splitListener);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String tipKey = "pref_tip";
        etTip.setText(prefs.getString(tipKey, ""));

    }
}
