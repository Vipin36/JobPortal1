package palletechnology.com.jobportal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomePageFragment extends Fragment {
   ImageButton im1;
    Button b1,b2,b3;
    MainActivity m;




    public WelcomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_welcome_page, container, false);
        im1 = (ImageButton) v.findViewById(R.id.loginImageButton);
        b1 = (Button) v.findViewById(R.id.createAccountButton);
        b2 = (Button) v.findViewById(R.id.useWithoutAccButton);
        b3 = (Button) v.findViewById(R.id.myAccountButton);
        m = (MainActivity) getActivity();
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.changeFragment(v);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.changeFragment(v);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity2.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           m.changeFragment(v);
            }
        });
        return v;
    }

}
