package com.example.monhunapps;

import java.util.ArrayList;

public class MonsterData {
    private static String[] monsterNames = {
            "Astalos",
            "Gammoth",
            "Glavenus",
            "Gogmazios",
            "Gore Magala",
            "Jhen Mohran",
            "Kirin",
            "Lunastra",
            "Mizutsune"
    };

    private static int[] monsterImages = {
            R.drawable.astalos,
            R.drawable.gammoth,
            R.drawable.glavenus,
            R.drawable.gogmazios,
            R.drawable.gore_magala,
            R.drawable.jhen_mohran,
            R.drawable.kirin,
            R.drawable.lunastra,
            R.drawable.mizutsune
    };

    static ArrayList<Monster>getListData(){
        ArrayList<Monster>list = new ArrayList<>();
        for(int position = 0; position<monsterNames.length;position++){
            Monster monster = new Monster();
            monster.setName(monsterNames[position]);
            monster.setPhoto(monsterImages[position]);
            list.add(monster);
        }
        return list;
    }
}
