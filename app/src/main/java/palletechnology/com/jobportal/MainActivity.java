package palletechnology.com.jobportal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();      //setTitle("Welcome To Job Portal");  //.setIcon(R.mipmap.ic_launcher);
       // Toolbar myToolBar = findViewById(R.id.)
        WelcomePageFragment f1 = new WelcomePageFragment();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction ft = mgr.beginTransaction();
        ft.add(R.id.contener1,f1);
        ft.commit();
    }
    public void changeFragment(View v)
    {
        CreateAccountFragment f2 = new CreateAccountFragment();
        SignUpPageFragment f3 = new SignUpPageFragment();
        EnterInMyAccountFragment f4 = new EnterInMyAccountFragment();
        MyJobsFragment f5 = new MyJobsFragment();
        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction ft = mgr.beginTransaction();
        switch (v.getId())
        {
            case R.id.createAccountButton:ft.replace(R.id.contener1, f2);break;
            case R.id.createAccountSubmitButton:
            case R.id.loginImageButton:ft.replace(R.id.contener1,f3);break;
            case R.id.signInButton:{
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;}
            case R.id.myAccountButton: ft.replace(R.id.contener1,f4); break;
            case R.id.enterInAccountButton:ft.replace(R.id.contener1,f5);break;
        }
        ft.addToBackStack(null);
        ft.commit();

    }
}
