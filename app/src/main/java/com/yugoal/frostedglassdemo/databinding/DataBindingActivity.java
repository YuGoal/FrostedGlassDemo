package com.yugoal.frostedglassdemo.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yugoal.frostedglassdemo.R;
import com.yugoal.frostedglassdemo.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding);
        User user = new User("caoyu","22");
        binding.setUser(user);
    }
}
