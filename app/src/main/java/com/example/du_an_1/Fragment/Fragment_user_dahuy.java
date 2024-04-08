package com.example.du_an_1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.du_an_1.Adapter.DahuyAdapter;
import com.example.du_an_1.Adapter.DonhangAdapterAdmin_choxacnhan;
import com.example.du_an_1.Adapter.User_dahuy_Adapter;
import com.example.du_an_1.Dao.DonhangDao;
import com.example.du_an_1.Model.Donhang;
import com.example.du_an_1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_user_dahuy#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_user_dahuy extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_user_dahuy() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_user_dahuy.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_user_dahuy newInstance(String param1, String param2) {
        Fragment_user_dahuy fragment = new Fragment_user_dahuy();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    RecyclerView recyclerView;
    ArrayList<Donhang> donhangArrayList;

    DonhangDao donhangDao;
    User_dahuy_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user_dahuy, container, false);
        donhangDao=new DonhangDao(getActivity());
        recyclerView=view.findViewById(R.id.userdahuy);
        donhangArrayList=donhangDao.getall();
        ArrayList<Donhang> donhangArrayList1=new ArrayList<>();
        for (Donhang donhang:donhangArrayList) {
            if(donhang.trangthai==2||donhang.trangthai==5){
                donhangArrayList1.add(donhang);
            }
        }
        adapter=new User_dahuy_Adapter(getContext(),donhangArrayList1);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        recyclerView.setAdapter(adapter);
        return view;
    }
}