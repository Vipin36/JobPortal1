package palletechnology.com.jobportal;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnterInMyAccountFragment extends Fragment {
    EditText ed1,ed2;
    Button b1;
    MyDatabase myDatabase;
    Cursor c;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
    }

    @Override
    public void onDestroy() {
        myDatabase.close();
        super.onDestroy();
    }

    public EnterInMyAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_enter_in_my_account, container, false);
        ed1 = (EditText) v.findViewById(R.id.enterAccountEmailEditText);
        ed2 = (EditText) v.findViewById(R.id.enterAccountPassEditText);
        b1 = (Button) v.findViewById(R.id.enterInAccountButton);
        final MainActivity m1 = (MainActivity) getActivity();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty())
                {
                    DataMissingDialogFragment d1 = new DataMissingDialogFragment();
                    d1.show(getActivity().getSupportFragmentManager(), null);
                } else
                {
                    String name = ed1.getText().toString().trim();
                    String pass = ed2.getText().toString().trim();
                    c = myDatabase.queryjobseeker();
                    if(c.moveToNext()) {
                        if (name.equalsIgnoreCase(c.getString(1)) && pass.equalsIgnoreCase(c.getString(2)))
                        {
                            MainActivity m = (MainActivity) getActivity();
                            m.changeFragment(v);
                        }
                        else
                        {
                            IdorPassNotMatchDialogFragment d1 = new IdorPassNotMatchDialogFragment();
                            d1.show(getActivity().getSupportFragmentManager(), null);
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Create your account first.", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });
        return v;
    }

}
