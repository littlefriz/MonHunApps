package com.example.monhunapps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rvMonster;
    private ArrayList<Monster> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        rvMonster = view.findViewById(R.id.rv_monster);
        rvMonster.setHasFixedSize(true);

        list.addAll(MonsterData.getListData());
        showRecyclerList();

    return view;
    }private void showRecyclerList(){
        rvMonster.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMonsterAdapter listMonsterAdapter = new ListMonsterAdapter(list);
        rvMonster.setAdapter(listMonsterAdapter);

        listMonsterAdapter.setOnItemClickCallback(new ListMonsterAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Monster data){
                showSelectedMonster(data);
            }
        });
    }

    private void showSelectedMonster(Monster monster){
        Toast.makeText(getActivity(),"Kamu memilih "+monster.getName(), Toast.LENGTH_LONG).show();
    }
}
