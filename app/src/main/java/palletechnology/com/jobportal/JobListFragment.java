package palletechnology.com.jobportal;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JobListFragment extends Fragment {
   TextView tv1;
    RecyclerView rv1;
    ArrayList<Jobs> arrayList;
    MyDatabase myDatabase;
    Cursor cursor;
    MyAdapter myAdapter;
    String s1,s2,jobType;
    Button b1;
    Spinner sp1;
    String[] job_types;
    ArrayAdapter arrayAdapter1;


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {
       ArrayList<Jobs> jobs= new ArrayList<>();
       Context ctx;

        public MyAdapter(ArrayList<Jobs> jobs, Context ctx) {
            this.jobs = jobs;
            this.ctx = ctx;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.job_list_row,parent,false);
            ViewHolder viewHolder = new ViewHolder(view,ctx,jobs);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Jobs jobs = arrayList.get(position);
            holder.tv1.setText(jobs.getCity());
            holder.tv2.setText(jobs.getDate());
            holder.tv3.setText(jobs.getTechnology());
            holder.tv4.setText(jobs.getCname());

        }


        @Override
        public int getItemCount() {
            return arrayList.size();
        }



        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            TextView tv1,tv2,tv3,tv4;
            ArrayList<Jobs> jobs = new ArrayList<Jobs>();
            Context ctx;
            public ViewHolder(View itemView,Context ctx,ArrayList<Jobs> jobs) {
                super(itemView);
                this.jobs = jobs;
                this.ctx = ctx;
                //MainActivity2 m2 = (MainActivity2) getActivity();
                itemView.setOnClickListener(this);
                tv1 = (TextView) itemView.findViewById(R.id.jobLocationRowTextView);
                tv2 = (TextView) itemView.findViewById(R.id.timeAndDateRowTextView);
                tv3 = (TextView) itemView.findViewById(R.id.jobProfileRowTextView);
                tv4 = (TextView) itemView.findViewById(R.id.companyNameRowTextView);
            }

            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                Jobs job = this.jobs.get(pos);
                MainActivity2 m2 = (MainActivity2) getActivity();
                m2.sendDetail(job.getDate(),job.getCname(),job.getCity(),job.getExperience(),job.getJobType(),job.getTechnology(),job.getDescreption());
            }
        }
    }

    @Override
    public void onDestroy() {
        myDatabase.close();
        super.onDestroy();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
    }
    public JobListFragment() {
        // Required empty public constructor
    }

   // public JobListFragment(ArrayList<Jobs> jobses, Context ctx) {
        // Required empty public constructor

     //   arrayList = jobses;
      //  this.ctx=ctx;

    //}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_job_list, container, false);
        tv1= (TextView) v.findViewById(R.id.getJobTextView);
        rv1 = (RecyclerView) v.findViewById(R.id.jobRecyclerView);
        b1 = (Button) v.findViewById(R.id.filterButton);
        sp1 = (Spinner) v.findViewById(R.id.jobTypeSpinner);
        job_types = getResources().getStringArray(R.array.job_type);
        arrayAdapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,job_types);
        sp1.setAdapter(arrayAdapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jobType = job_types[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv1.setLayoutManager(linearLayoutManager);
        Bundle bundle = getArguments();
        s1 = bundle.getString("job");
        s2 = bundle.getString("city");
        tv1.setText(s1+" in "+s2);
        arrayList = new ArrayList<>();
        cursor = myDatabase.queryjobs(s2,s1);
        if(cursor!=null)
        {
            while (cursor.moveToNext())
            {
               int sNo = cursor.getInt(0);
                String date = cursor.getString(1);
                String cname = cursor.getString(2);
                String city = cursor.getString(3);
                String experence = cursor.getString(4);
                String jtype = cursor.getString(5);
                String technology = cursor.getString(6);
                String description = cursor.getString(7);

                Jobs jobs = new Jobs(""+sNo,date,cname,city,experence,jtype,technology,description);
                arrayList.add(jobs);
            }
        }
        myAdapter = new MyAdapter(arrayList,getActivity());
        rv1.setAdapter(myAdapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = myDatabase.queryjobs(s2,s1,jobType);
                if(cursor!=null)
                {
                    while (cursor.moveToNext())
                    {
                        int sNo = cursor.getInt(0);
                        String date = cursor.getString(1);
                        String cname = cursor.getString(2);
                        String city = cursor.getString(3);
                        String experence = cursor.getString(4);
                        String jtype = cursor.getString(5);
                        String technology = cursor.getString(6);
                        String description = cursor.getString(7);

                        Jobs jobs = new Jobs(""+sNo,date,cname,city,experence,jtype,technology,description);
                        arrayList = new ArrayList<>();
                        arrayList.add(jobs);

                    }
                }
                rv1.setAdapter(myAdapter);

            }
        });


        return v;
    }


}
