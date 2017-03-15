package palletechnology.com.jobportal;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostJobDialogFragment extends DialogFragment {
  EditText et1,et2;
    ImageButton im1;

    public PostJobDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d= null;
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Admin Login");
        final View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_post_job_dialog,null);
        et1 = (EditText) v.findViewById(R.id.adminIdEditText);
        et2 = (EditText) v.findViewById(R.id.adminPassEditText);
       im1 = (ImageButton) v.findViewById(R.id.adminLoginImgButton);
        b.setView(v);

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().trim().isEmpty()||et2.getText().toString().trim().isEmpty())
                {
                    DataMissingDialogFragment d1 = new DataMissingDialogFragment();
                    d1.show(getActivity().getSupportFragmentManager(),null);
                }
                else
                {
                    if (et2.getText().toString().trim().equalsIgnoreCase("palle") && et1.getText().toString().trim().equalsIgnoreCase("palle")) {
                        //getActivity().onBackPressed();
                       // Toast.makeText(g, "", Toast.LENGTH_SHORT).show();
                        MainActivity2 m2 = (MainActivity2) getActivity();
                        //getActivity().onBackPressed();
                        m2.changeFragment(v);
                        //getActivity().onBackPressed();
                        getDialog().cancel();//for hidding a dilaog.


                    } else {
                        IdorPassNotMatchDialogFragment p2 = new IdorPassNotMatchDialogFragment();
                        p2.show(getActivity().getSupportFragmentManager(), null);
                    }
                }
            }
        });
        d=b.create();

        return d;
    }


}
