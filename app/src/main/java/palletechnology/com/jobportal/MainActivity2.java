package palletechnology.com.jobportal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    String job,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //getSupportActionBar().setTitle("Search Job");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setFragment();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                      //  .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                 int id = item.getItemId();
                 if(id == R.id.admin)
                 {
                     PostJobDialogFragment p1 = new PostJobDialogFragment();
                     p1.show(getSupportFragmentManager(),null);

                 }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }
    public void changeFragment(View v)
    {
        JobListFragment s2 = new JobListFragment();
        PostJobFragment s3 = new PostJobFragment();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction ft = mgr.beginTransaction();

        switch (v.getId())
        {
            case R.id.findJobButton: ft.addToBackStack(null);
                ft.replace(R.id.contener2,s2);
                Bundle bundle = new Bundle();
                bundle.putString("job",job);
                bundle.putString("city",city);
                s2.setArguments(bundle);
                break;
            case R.id.adminLoginImgButton:ft.addToBackStack(null);
                ft.replace(R.id.contener2,s3);
                break;
        }
        ft.commit();
    }
    public void getJobDetail(String s1,String s2)
    {
        job = s1;
        city = s2;
    }
    public void setFragment()
    {
        SearchJobTitleFragment s1 = new SearchJobTitleFragment();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction ft = mgr.beginTransaction();
        ft.replace(R.id.contener2,s1);
        ft.commit();

    }
    public  void  sendDetail(String s1, String s2, String s3, String s4, String s5,String s6 , String s7)
    {   Bundle bundle = new Bundle();
        bundle.putString("jdate",s1);
        bundle.putString("cname",s2);
        bundle.putString("jcity",s3);
        bundle.putString("jexep",s4);
        bundle.putString("jtype",s5);
        bundle.putString("jtech",s6);
        bundle.putString("jdesc",s7);
        JobDetailFragment jd = new JobDetailFragment();
        jd.setArguments(bundle);
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction ft = mgr.beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.contener2,jd);
        ft.commit();

    }
}
