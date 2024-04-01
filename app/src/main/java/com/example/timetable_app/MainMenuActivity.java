package com.example.timetable_app;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;

public class MainMenuActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button b1 = findViewById(R.id.LogoutButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent il = new Intent(MainMenuActivity.this, LogInActivity.class);
                startActivity(il);
            }
        });

        setupUIViews();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.MenuList);
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.MenuTitle);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Intent il = new Intent(MainMenuActivity.this, TimetableActivity.class);
                        startActivity(il);
                        break;
                    }
                    case 1: {
                        Intent il = new Intent(MainMenuActivity.this, NewsActivity.class);
                        startActivity(il);
                        break;
                    }
                    case 2: {
                        Intent il = new Intent(MainMenuActivity.this, MessagesActivity.class);
                        startActivity(il);
                        break;
                    }
                    case 3: {
                        Intent il = new Intent(MainMenuActivity.this, DepartmentActivity.class);
                        startActivity(il);
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description){
            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_menu_icons, null);
            }

            title = (TextView)convertView.findViewById(R.id.Timetable);
            description = (TextView)convertView.findViewById(R.id.TimetableDesc);
            imageView = (ImageView)convertView.findViewById(R.id.TimetableImage);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.timetable);
            }else if(titleArray[position].equalsIgnoreCase("News")){
                imageView.setImageResource(R.drawable.newspaper);
            }else if(titleArray[position].equalsIgnoreCase("Messages")){
                imageView.setImageResource(R.drawable.envelope);
            }else if(titleArray[position].equalsIgnoreCase("Staff")){
                imageView.setImageResource(R.drawable.profile);
            }

            return convertView;

        }
    }

}