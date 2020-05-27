package com.example.maohuawei.addressbookindex.view;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.maohuawei.addressbookindex.R;
import com.example.maohuawei.addressbookindex.bean.Person;
import com.example.maohuawei.addressbookindex.util.ToastUtil;

import java.util.List;



public class AddressBookView extends LinearLayout {


    private RecyclerView recyclerView;

    private IndexView indexView;

    private View view;

    private List<Person> personList;

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


    public AddressBookView(Context context) {
        this(context, null);
    }

    public AddressBookView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AddressBookView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = LayoutInflater.from(context).inflate(R.layout.view_addressbook, this);
        init();
    }

    private void init() {

        initView();

    }

    private void initView() {

        recyclerView = view.findViewById(R.id.recyclerView);
        indexView = view.findViewById(R.id.indexView);

    }

    public void setpersonList(List<Person> personList) {
        this.personList = personList;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AddressBookAdapter());
        indexView.setIndexViewLetterChangeListener(new IndexView.IndexViewLetterChangeListener() {
            @Override
            public void onIndexLetterChange(String letter) {

                ToastUtil.showToast(letter);

                updateRecyclerView(letter);

            }
        });
    }

    private void updateRecyclerView(String letter) {


        for (int i = 0; i < personList.size(); i++) {
            String let = personList.get(i).getPinyin().substring(0, 1);

            if (let.equals("#")) {
                MoveToPosition(linearLayoutManager, 0);
            }

            if (let.equals(letter)) {
                MoveToPosition(linearLayoutManager, i);
                return;
            }
        }
    }

    /**
     * 设置RecyclerView 到指定位置
     *
     * @param manager
     * @param n
     */
    public static void MoveToPosition(LinearLayoutManager manager, int n) {
        manager.scrollToPositionWithOffset(n, 0);
        manager.setStackFromEnd(true);
    }

    public class AddressBookAdapter extends RecyclerView.Adapter<AddressBookAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_addressbook, parent, false);


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

        class ViewHolder extends RecyclerView.ViewHolder {

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

}
