package palletechnology.com.jobportal;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MailIdNotMatchDilogFragment extends DialogFragment {


    public MailIdNotMatchDilogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("Mail Id not match!!!");
        b.setMessage("Your typed Mail Id not match with existing account Mail Id.");
        b.setPositiveButton("Ok",null);

        d = b.create();
        return  d;
    }
}
