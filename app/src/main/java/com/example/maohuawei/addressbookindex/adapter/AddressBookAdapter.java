package com.example.maohuawei.addressbookindex.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maohuawei.addressbookindex.R;
import com.example.maohuawei.addressbookindex.bean.Person;

import java.util.List;


/**
 * Created by maohuawei on 2018/2/5.
 */

public class AddressBookAdapter extends RecyclerView.Adapter<AddressBookAdapter.ViewHolder> {

    private Context context;

    private List<Person> personList;

    public AddressBookAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.item_addressbook, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Person person = personList.get(position);


        String letter = person.getPinyin().substring(0, 1);
        String name = person.getName();

        if (letter.toCharArray()[0] < 'A' || letter.toCharArray()[0] > 'Z') {

            holder.textViewLetter.setText("#");
            holder.textViewName.setText(name);
        } else {

            holder.textViewLetter.setText(letter);
            holder.textViewName.setText(name);

        }


        if (position == 0) {
            holder.textViewLetter.setVisibility(View.VISIBLE);
        } else {

            String lett = personList.get(position - 1).getPinyin().substring(0, 1);

            if (letter.equals(lett)) {

                holder.textViewLetter.setVisibility(View.GONE);

            } else {
                holder.textViewLetter.setVisibility(View.VISIBLE);
            }
            // 对#的处理
            if (lett.toCharArray()[0] < 'A' || lett.toCharArray()[0] > 'Z') {
                lett = "#";
                if (letter.toCharArray()[0] < 'A' || letter.toCharArray()[0] > 'Z') {
                    letter = "#";
                    if (letter.equals(lett)) {
                        holder.textViewLetter.setVisibility(View.GONE);
                    } else {
                        holder.textViewLetter.setVisibility(View.VISIBLE);
                    }
                }
            }
        }


        holder.textViewName.setText(person.getName());

        holder.textViewTel.setText(person.getTel());


    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewLetter;

        private TextView textViewName;

        private ImageView imageViewAvatar;

        private TextView textViewTel;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewLetter = itemView.findViewById(R.id.textViewLetter);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
            textViewTel = itemView.findViewById(R.id.textViewTel);

        }
    }
}
