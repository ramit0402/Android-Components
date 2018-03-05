package com.example.android.recyclerview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.recyclerview.R;
import com.example.android.recyclerview.UserDetails.User;
import java.util.ArrayList;

/**
 * Created by ramit on 05-Mar-18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UserViewHolder>{

    private ArrayList<User> list_members = new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    UserViewHolder holder;
    private Context context;

    public CustomAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.custom_row, parent, false);
        holder = new UserViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User list_items = list_members.get(position);
        holder.userName.setText(list_items.getUserName());
        holder.userId.setText(list_items.getUserId());
        holder.userDate.setText(list_items.getDate());
    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    public void setListContent(ArrayList<User> list_members){
        this.list_members = list_members;
        notifyItemRangeChanged(0,list_members.size());
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView userImage;
        TextView userName, userId, userDate;

        public UserViewHolder(View itemView) {
            super(itemView);
            userImage = (ImageView)itemView.findViewById(R.id.iv_user);
            userName = (TextView)itemView.findViewById(R.id.tv_user_name);
            userId = (TextView)itemView.findViewById(R.id.tv_user_id);
            userDate = (TextView)itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View view) {

        }


    }
}
