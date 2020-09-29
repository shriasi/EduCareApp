package com.shrimali.eduapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }



    public class MainDashboardActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_dashboard);
            MyListData[] myListData = new MyListData[] {
                    new MyListData("Email", android.R.drawable.ic_dialog_email),
                    new MyListData("Info", android.R.drawable.ic_dialog_info),
                    new MyListData("Delete", android.R.drawable.ic_delete),
                    new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                    new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                    new MyListData("Map", android.R.drawable.ic_dialog_map),
                    new MyListData("Email", android.R.drawable.ic_dialog_email),
                    new MyListData("Info", android.R.drawable.ic_dialog_info),
                    new MyListData("Delete", android.R.drawable.ic_delete),
                    new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                    new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                    new MyListData("Map", android.R.drawable.ic_dialog_map),
            };

            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            MyListAdapter adapter = new MyListAdapter(myListData);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

        }


    }
}