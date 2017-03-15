package palletechnology.com.jobportal;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyJobsFragment extends Fragment {
     RecyclerView rv1;
    ArrayList<Jobs> arrayList;
    MyDatabase myDatabase;
    Cursor cursor;
    MyAdapter myAdapter;
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.job_list_row,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
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

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv1,tv2,tv3,tv4;
            public ViewHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.jobLocationRowTextView);
                tv2 = (TextView) itemView.findViewById(R.id.timeAndDateRowTextView);
                tv3 = (TextView) itemView.findViewById(R.id.jobProfileRowTextView);
                tv4 = (TextView) itemView.findViewById(R.id.companyNameRowTextView);
            }
        }
    }

    public MyJobsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDatabase.close();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_jobs, container, false);
        rv1 = (RecyclerView) v.findViewById(R.id.myJobsRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv1.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        cursor = myDatabase.querymyjobs();
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
        myAdapter = new MyAdapter();
        rv1.setAdapter(myAdapter);

        return v;
    }

}
