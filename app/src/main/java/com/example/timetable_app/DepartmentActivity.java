package com.example.timetable_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DepartmentActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        setupUIViews();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.MenuList);
    }

    private void setupListView(){

        String[] name = getResources().getStringArray(R.array.StaffName);
        String[] email = getResources().getStringArray(R.array.StaffEmail);

        DepartmentActivity.SimpleAdapter simpleAdapter = new DepartmentActivity.SimpleAdapter(this, name, email);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView name, email;
        private String[] StaffName;
        private String[] StaffEmail;
        private ImageView image;

        public SimpleAdapter(Context context, String[] name, String[] email){
            mContext = context;
            StaffName = name;
            StaffEmail = email;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return StaffName.length;
        }

        @Override
        public Object getItem(int position) {
            return StaffName[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_staff, null);
            }

            name = (TextView)convertView.findViewById(R.id.StaffName);
            email = (TextView)convertView.findViewById(R.id.StaffEmail);
            image = (ImageView)convertView.findViewById(R.id.StaffImage);

            name.setText(StaffName[position]);
            email.setText(StaffEmail[position]);

            if(StaffName[position].equalsIgnoreCase("Richard Mitchell")){
                image.setImageResource(R.drawable.rmitchell);
            }else if(StaffName[position].equalsIgnoreCase("Martin Lester")){
                image.setImageResource(R.drawable.mlester);
            }else if(StaffName[position].equalsIgnoreCase("Hong Wei")){
                image.setImageResource(R.drawable.hwei);
            }else if(StaffName[position].equalsIgnoreCase("Lily Sun")){
                image.setImageResource(R.drawable.lsun);
            }

            return convertView;

        }
    }
}