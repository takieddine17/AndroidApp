package com.example.timetable_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MessagesActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        setupUIViews();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.MenuList);
    }

    private void setupListView(){

        String[] sender = getResources().getStringArray(R.array.Sender);
        String[] message = getResources().getStringArray(R.array.Message);

        MessagesActivity.SimpleAdapter simpleAdapter = new MessagesActivity.SimpleAdapter(this, sender, message);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView sender, message;
        private String[] Sender;
        private String[] Message;
        private ImageView image;

        public SimpleAdapter(Context context, String[] sender, String[] message){
            mContext = context;
            Sender = sender;
            Message = message;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return Sender.length;
        }

        @Override
        public Object getItem(int position) {
            return Sender[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.activity_message, null);
            }

            sender = (TextView)convertView.findViewById(R.id.Sender);
            message = (TextView)convertView.findViewById(R.id.Message);
            image = (ImageView)convertView.findViewById(R.id.MessageImage);

            sender.setText(Sender[position]);
            message.setText(Message[position]);

            if(Sender[position].equalsIgnoreCase("UOR")){
                image.setImageResource(R.drawable.envelope);
            }else if(Sender[position].equalsIgnoreCase("Martin Lester")){
                image.setImageResource(R.drawable.mlester);
            }else if(Sender[position].equalsIgnoreCase("Hong Wei")){
                image.setImageResource(R.drawable.hwei);
            }else if(Sender[position].equalsIgnoreCase("UOR")){
                image.setImageResource(R.drawable.envelope);
            }

            return convertView;

        }
    }
}