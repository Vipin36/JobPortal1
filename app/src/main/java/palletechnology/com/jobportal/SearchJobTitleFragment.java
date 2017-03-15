package palletechnology.com.jobportal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchJobTitleFragment extends Fragment {
      AutoCompleteTextView autoCompleteTextView1;
    Spinner sp1;
    ArrayAdapter<String> arrayAdapter1,arrayAdapter2;
      String[] job_titles,city_names;
    String city;
    Button b1;
    int count=0;

    public SearchJobTitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_job_title, container, false);
        autoCompleteTextView1 = (AutoCompleteTextView) v.findViewById(R.id.searchJobAutoCompleteTextView);
        sp1 = (Spinner) v.findViewById(R.id.selectCitySpinner);
        b1 = (Button) v.findViewById(R.id.findJobButton);
        job_titles = getResources().getStringArray(R.array.technology);
        arrayAdapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,job_titles);
        autoCompleteTextView1.setAdapter(arrayAdapter1);
        city_names = getResources().getStringArray(R.array.city_names);
        arrayAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,city_names);
        sp1.setAdapter(arrayAdapter2);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = city_names[position];
                count = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(autoCompleteTextView1.getText().toString().isEmpty()||count==0){
                    DataMissingDialogFragment d1 = new DataMissingDialogFragment();
                    d1.show(getActivity().getSupportFragmentManager(),null);
                }
                else{
                    String job = autoCompleteTextView1.getText().toString();
                    MainActivity2 m2 = (MainActivity2) getActivity();
                    m2.getJobDetail(job, city);
                    m2.changeFragment(v);
                    autoCompleteTextView1.setText("");
                    sp1.setSelection(0);
                }
            }
        });

        return v;
    }

}
