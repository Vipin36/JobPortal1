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
public class SignUpPageFragment extends Fragment {
   EditText et1,et2,et3;
    Button b1,b2,b3;
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

    public SignUpPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_sign_up_page, container, false);
        et1 = (EditText) v.findViewById(R.id.signInEmailEditText);
        et2 = (EditText) v.findViewById(R.id.signInPassEditText);
        et3 = (EditText) v.findViewById(R.id.forgotPassEmailEditText);
        b1 = (Button) v.findViewById(R.id.signInButton);
        b2 = (Button) v.findViewById(R.id.signWithGmailButton);
        b3 = (Button) v.findViewById(R.id.forgotPassSubmitButton);
       // Toast.makeText(getActivity(), "This is on Creare.", Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           String name =et1.getText().toString().trim();
            String pass = et2.getText().toString().trim();
             c= myDatabase.queryjobseeker();
                if(c.moveToNext()) {
                    if (name.equalsIgnoreCase(c.getString(1)) && pass.equalsIgnoreCase(c.getString(2))) {
                        MainActivity m = (MainActivity) getActivity();
                        m.changeFragment(v);
                    } else {
                        IdorPassNotMatchDialogFragment d1 = new IdorPassNotMatchDialogFragment();
                        d1.show(getActivity().getSupportFragmentManager(), null);
                    }
                }
                else
                    Toast.makeText(getActivity(), "Create your account first.", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et3.getText().toString().trim().isEmpty())
                {
                    DataMissingDialogFragment d1 = new DataMissingDialogFragment();
                    d1.show(getActivity().getSupportFragmentManager(),null);
                }
                else
                {

                    c = myDatabase.queryjobseeker();
                    if(c.moveToNext())
                    {if(et3.getText().toString().trim().equalsIgnoreCase(c.getString(1)))
                    {
                        //semd mail code.
                        Toast.makeText(getActivity(), "Your password is send to your mail.", Toast.LENGTH_SHORT).show();
                    }
                    else  {
                          MailIdNotMatchDilogFragment  m1 =new  MailIdNotMatchDilogFragment();
                        m1.show(getActivity().getSupportFragmentManager(),null);
                    }
                    }else {
                        Toast.makeText(getActivity(), "Create your Account first.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return v;
    }

}
