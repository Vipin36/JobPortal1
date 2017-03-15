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
public class CreateAccountFragment extends Fragment {
  EditText et1,et2,et3;
    Button b1;
   // Cursor c; //no need of cursor here.
    MyDatabase myDatabase;

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

    public CreateAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_create_account, container, false);
        et1 = (EditText) v.findViewById(R.id.createAccountEmailEditText);
        et2 = (EditText) v.findViewById(R.id.createAccountPassEditText);
        et3 = (EditText) v.findViewById(R.id.createAccountConformPassEditText);
        b1= (Button) v.findViewById(R.id.createAccountSubmitButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()||et3.getText().toString().isEmpty())
                {
                    DataMissingDialogFragment dm = new DataMissingDialogFragment();
                    dm.show(getActivity().getSupportFragmentManager(),null);
                }
                else if((et2.getText().toString().equals(et3.getText().toString()))!=true)
                {
                    PasswordNotMatchDialogFragment pass = new PasswordNotMatchDialogFragment();
                    pass.show(getActivity().getSupportFragmentManager(),null);
                }
                else
                {
                    String mail = et1.getText().toString();
                    String pass = et2.getText().toString();
                    myDatabase.insertJobSeeker(mail,pass);
                    Toast.makeText(getActivity(),"New account created.",Toast.LENGTH_LONG).show();
                    et1.setText("");
                    et2.setText("");
                    et1.requestFocus();
                    //store in database.
                  MainActivity m = (MainActivity) getActivity();
                    m.changeFragment(v);
                }
            }
        });
        return v;
    }

}
