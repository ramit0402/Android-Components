package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.android.recyclerview.Adapter.CustomAdapter;
import com.example.android.recyclerview.UserDetails.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    CustomAdapter mCustomAdapter;
    private Toast mToast;
    private ArrayList<User> mUsersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCustomAdapter = new CustomAdapter(this);
        populateRecycerViewValues();

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListner(this,
                mRecyclerView, new ItemClickListener() {
            @Override
            public void onClick(View view, final int position) {
                if(mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(MainActivity.this, "Single Click on position :"+position, Toast.LENGTH_SHORT);
                mToast.show();
            }

            @Override
            public void onLongClick(View view, int position) {
                if(mToast != null) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(MainActivity.this, "Long press on position :"+position, Toast.LENGTH_LONG);
                mToast.show();
            }
        }));
    }

    private void populateRecycerViewValues() {
        for(int iter = 1; iter <= 50; iter++) {
            User userObject = new User();
            userObject.setUserName("Shyamala Kovvalpurail");
            userObject.setUserId("Hello RecyclerView! item: " + iter);
            userObject.setDate("10:45PM");
            mUsersList.add(userObject);
        }
        mCustomAdapter.setListContent(mUsersList);
        mRecyclerView.setAdapter(mCustomAdapter);
    }

    // ---------For Click Actions--------- //
    public static interface ItemClickListener{
        public void onClick(View view, int position);
        public void onLongClick(View view,int position);
    }

    class RecyclerTouchListner implements RecyclerView.OnItemTouchListener {
        private ItemClickListener itemClickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListner(Context context, final RecyclerView recycleView, final ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child != null && itemClickListener != null){
                        itemClickListener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && itemClickListener!=null && gestureDetector.onTouchEvent(e)){
                itemClickListener.onClick(child,rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
