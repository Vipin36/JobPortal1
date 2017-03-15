package palletechnology.com.jobportal;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdorPassNotMatchDialogFragment extends DialogFragment {


    public IdorPassNotMatchDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d =null;
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        b.setTitle("ID or Password not Match!!!");
        b.setMessage("Mail Id or Password is miss match.");
        b.setPositiveButton("Ok",null);
        d = b.create();
        return d;
    }
}
