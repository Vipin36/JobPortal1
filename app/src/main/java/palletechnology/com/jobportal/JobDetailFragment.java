package palletechnology.com.jobportal;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobDetailFragment extends Fragment {
   String date,cname,city,exp,jtype,jtech,jdesc;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    Button b1,b2;
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

    public JobDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_job_detail, container, false);
        tv1 = (TextView) v.findViewById(R.id.jobDetailsDate);
        tv2 = (TextView) v.findViewById(R.id.jobDetailCity);
        tv3 = (TextView) v.findViewById(R.id.jobDetailTech);
        tv4 = (TextView) v.findViewById(R.id.jobDetailsCompanyName);
        tv5 = (TextView) v.findViewById(R.id.jobDetailMinExpTextView);
        tv6 = (TextView) v.findViewById(R.id.jobDetailjobTypeTextView);
        tv7 = (TextView) v.findViewById(R.id.jobDetailDescription);
        b1 = (Button) v.findViewById(R.id.saveJobButton);
        b2 = (Button) v.findViewById(R.id.applyJobButton);
        Bundle bundle = getArguments();
        exp = bundle.getString("jexep");
       date =  bundle.getString("jdate");
       cname = bundle.getString("cname");
       city = bundle.getString("jcity");
       jtype = bundle.getString("jtype");
       jtech = bundle.getString("jtech");
       jdesc = bundle.getString("jdesc");
        tv1.setText(date);
        tv2.setText(city);
        tv3.setText(jtech);
        tv4.setText(cname);
        tv5.setText(exp);
        tv6.setText(jtype);
        tv7.setText(jdesc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.insertmyJobs(date, cname, city, exp, jtype, jtech, jdesc);
                Toast.makeText(getActivity(), "Job saved.", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "For apply go through description.", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

}
