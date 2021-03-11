package com.example.camhoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment implements ItemAdapter.OnItemClick{
    ImageSlider imageSlider;
    TextView tvGetAll;
    RecyclerView recyclerViewFlowerArrangementPattern,recyclerViewSymmetricalFlowerArrangement,recyclerViewFlowerArrangementInBlocks;
    ItemAdapter adapterViewFlowerArrangementPattern,adapterViewSymmetricalFlowerArrangement,adapterFlowerArrangementInBlocks;
    List<Item> listViewFlowerArrangementPattern,listViewSymmetricalFlowerArrangement,listFlowerArrangementInBlocks;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider=view.findViewById(R.id.image_slider);
        tvGetAll=view.findViewById(R.id.tvGetAll);
        List<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.",ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(imageList);
        recyclerViewFlowerArrangementPattern=view.findViewById(R.id.recyclerViewFlowerArrangementPattern);
        recyclerViewSymmetricalFlowerArrangement=view.findViewById(R.id.recyclerViewSymmetricalFlowerArrangement);
        recyclerViewFlowerArrangementInBlocks=view.findViewById(R.id.recyclerViewFlowerArrangementInBlocks);
        getData();
        tvGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentHomePage()).commit();
            }
        });
        return view;
    }

    private void getData() {
        listViewFlowerArrangementPattern=new ArrayList<>();
        listViewFlowerArrangementPattern.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewFlowerArrangementPattern.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewFlowerArrangementPattern.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewFlowerArrangementPattern.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewFlowerArrangementPattern.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        adapterViewFlowerArrangementPattern=new ItemAdapter(listViewFlowerArrangementPattern,getContext());
        recyclerViewFlowerArrangementPattern.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFlowerArrangementPattern.setLayoutManager(horizontalLayoutManager);
        recyclerViewFlowerArrangementPattern.setAdapter(adapterViewFlowerArrangementPattern);
        adapterViewFlowerArrangementPattern.setClickListener(this::onItemClick);

        listViewSymmetricalFlowerArrangement=new ArrayList<>();
        listViewSymmetricalFlowerArrangement.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewSymmetricalFlowerArrangement.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewSymmetricalFlowerArrangement.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewSymmetricalFlowerArrangement.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listViewSymmetricalFlowerArrangement.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        adapterViewSymmetricalFlowerArrangement=new ItemAdapter(listViewSymmetricalFlowerArrangement,getContext());
        recyclerViewSymmetricalFlowerArrangement.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewSymmetricalFlowerArrangement.setLayoutManager(horizontalLayoutManager1);
        recyclerViewSymmetricalFlowerArrangement.setAdapter(adapterViewSymmetricalFlowerArrangement);

        listFlowerArrangementInBlocks=new ArrayList<>();
        listFlowerArrangementInBlocks.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listFlowerArrangementInBlocks.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listFlowerArrangementInBlocks.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listFlowerArrangementInBlocks.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        listFlowerArrangementInBlocks.add(new Item("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác"));
        adapterFlowerArrangementInBlocks=new ItemAdapter(listFlowerArrangementInBlocks,getContext());
        recyclerViewFlowerArrangementInBlocks.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFlowerArrangementInBlocks.setLayoutManager(horizontalLayoutManager2);
        recyclerViewFlowerArrangementInBlocks.setAdapter(adapterFlowerArrangementInBlocks);
    }


    @Override
    public void onItemClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new FragmentTutorial()).addToBackStack("FragmentTutorial").commit();
    }
}
