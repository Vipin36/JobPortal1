package palletechnology.com.jobportal;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostJobFragment extends Fragment {
      TextView tv1;
    EditText et1,et2;
    Spinner sp1,sp2,sp3,sp4;
    Button b1;
    String [] city_List,experience_list,technology_list,job_type;
    String city,experience,technology,jobType;
    ArrayAdapter arrayAdapter1,arrayAdapter2,arrayAdapter3,arrayAdapter4;
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

    public PostJobFragment() {
        // Required empty public constructor
    }
public void resetDate(){
    Calendar calendar = Calendar.getInstance();
    int year = calendar .get(Calendar.YEAR);
    int month = calendar .get(Calendar.MONTH);
    String mon ;
    switch (month){
        case 0:mon ="Jan";break;
        case 1:mon ="Feb";break;
        case 2:mon ="March";break;
        case 3:mon ="April";break;
        case 4:mon ="May";break;
        case 5:mon ="June";break;
        case 6:mon ="July";break;
        case 7:mon ="Oug";break;
        case 8:mon ="Sep";break;
        case 9:mon ="Oct";break;
        case 10:mon ="Nov";break;
        case 11:mon ="Dec";break;
        default:mon = "jan"; break;
    }
    int date = calendar .get(Calendar.DATE);
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    String min;
    if(minute<10){min="0"+minute; }else min = ""+minute;
    //int sec = calendar.get(Calendar.SECOND);
    int amORpm = calendar.get(Calendar.AM_PM);
    String ampm ;
    if(amORpm==0){ampm = "AM";}else {ampm = "PM";}
    tv1.setText(""+mon+" "+date+" "+year+"  "+hour+":"+min+" "+ampm);
}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_post_job, container, false);
        tv1 = (TextView) v.findViewById(R.id.dateOrTimeTextView);
        sp1 = (Spinner) v.findViewById(R.id.postCitySpinner);
        sp2 = (Spinner) v.findViewById(R.id.selectExperianceLevelSpinner);
        sp3 = (Spinner) v.findViewById(R.id.selectTechnologySpinner);
        sp4 = (Spinner) v.findViewById(R.id.postJopTypeSpinner);
        b1 = (Button) v.findViewById(R.id.postJobButton);
        et1 = (EditText) v.findViewById(R.id.postCompanyNameEditText);
        et2 = (EditText) v.findViewById(R.id.descEditText);
        job_type = getResources().getStringArray(R.array.job_type);
        city_List = getResources().getStringArray(R.array.city_names);
        experience_list = getResources().getStringArray(R.array.experience);
        technology_list = getResources().getStringArray(R.array.technology);
        arrayAdapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,city_List);
        arrayAdapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,experience_list);
        arrayAdapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,technology_list);
        arrayAdapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,job_type);
        sp1.setAdapter(arrayAdapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              city = city_List[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setAdapter(arrayAdapter2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                experience = experience_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setAdapter(arrayAdapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                technology = technology_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp4.setAdapter(arrayAdapter4);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jobType = job_type[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Calendar calendar = Calendar.getInstance();
        int year = calendar .get(Calendar.YEAR);
        int month = calendar .get(Calendar.MONTH);
        String mon ;
        switch (month){
            case 0:mon ="Jan";break;
            case 1:mon ="Feb";break;
            case 2:mon ="March";break;
            case 3:mon ="April";break;
            case 4:mon ="May";break;
            case 5:mon ="June";break;
            case 6:mon ="July";break;
            case 7:mon ="Oug";break;
            case 8:mon ="Sep";break;
            case 9:mon ="Oct";break;
            case 10:mon ="Nov";break;
            case 11:mon ="Dec";break;
            default:mon = "jan"; break;
        }
        int date = calendar .get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        String min;
        if(minute<10){min="0"+minute; }else min = ""+minute;
        //int sec = calendar.get(Calendar.SECOND);
        int amORpm = calendar.get(Calendar.AM_PM);
        String ampm ;
        if(amORpm==0){ampm = "AM";}else {ampm = "PM";}
        tv1.setText(""+mon+" "+date+" "+year+"  "+hour+":"+min+" "+ampm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()){
                    DataMissingDialogFragment dm = new DataMissingDialogFragment();
                    dm.show(getActivity().getSupportFragmentManager(),null);
                }
                else {
                    myDatabase.insertJobs(tv1.getText().toString(), et1.getText().toString(), city, experience, jobType, technology, et2.getText().toString());
                    Toast.makeText(getActivity(), "Job Post.", Toast.LENGTH_SHORT).show();
                    sp1.setSelection(0);
                    sp2.setSelection(0);
                    sp3.setSelection(0);
                    sp4.setSelection(0);
                    et1.setText("");
                    et2.setText("");
                    et1.requestFocus();
                    resetDate();

                }
            }
        });


        return v;
    }


}
