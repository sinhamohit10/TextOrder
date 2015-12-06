/*******************************************************************************
 * Copyright 2013 Gabriele Mariotti
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.amazon.mohsinha.ccxhack;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;

public class MainActivity extends ListActivity {

    private EditText mNewMessage;
    private ImageButton mNewMessageSend;
    private ViewHolderAdapter mAdapter;
    private ServiceHelper helper;
    private GestureDetector gdt;

    public ViewHolderAdapter getAdapter(){
        return mAdapter;
    }

    public ServiceHelper getHelper(){
        return helper;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gdt= new GestureDetector(this, new SwipeGestureListener(this));
        mAdapter = ListHelper.buildViewHolderAdapter(this,
                R.layout.list_item, gdt);


        setListAdapter(mAdapter);
        helper = new ServiceHelper(mAdapter,this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        mNewMessage = (EditText) findViewById(R.id.newmsg);
        mNewMessageSend = (ImageButton) findViewById(R.id.newmsgsend);
        if (mNewMessageSend!=null){
            mNewMessageSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItem();
                }
            });
        }
        mNewMessageSend.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("ADDED", "CALLBACK");
                helper.callSNS(null);
            }
        }, 40000);
    }



    private void addItem() {


        MyObj obj = new MyObj();
        obj.setName("You");
        obj.setTitle(mNewMessage.getText().toString());
        mAdapter.add(obj);

        mAdapter.notifyDataSetChanged();

        helper.callSearch(mNewMessage.getText().toString());
        mNewMessage.setText("");
    }


}
