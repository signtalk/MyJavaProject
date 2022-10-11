package com.javaproject;

import java.util.ArrayList;

public class P3for2021 {
    public static void main(String[] args) {

        ClubMembers cm1 = new ClubMembers();

        String[] memberList2017 = {"Simon171", "Simon172"};
        String[] memberList2018 = {"Simon181", "Simon182"};
        String[] memberList2019 = {"Simon191", "Simon192"};
        String[] memberList2020 = {"Simon201", "Simon202"};

        cm1.addMembers(memberList2017, 2017);
        cm1.addMembers(memberList2018, 2018);
        cm1.addMembers(memberList2019, 2019);
        cm1.addMembers(memberList2020, 2020);

        cm1.removeMembers(2018);

    }
}

class MemberInfo {

    private String name;
    private int gradYear;
    private boolean hasGoodStanding;

    public MemberInfo(String n, int g, boolean hGS) {
        name = n;
        gradYear = g;
        hasGoodStanding = hGS;

    }

    public String getName() {
        return name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public boolean isGoodStanding() {
        return hasGoodStanding;
    }
}

class ClubMembers {
    private ArrayList<MemberInfo> memberList;
    private int year;

    public ClubMembers() {
        memberList = new ArrayList<MemberInfo>();
    }

    public void addMembers(String[] names, int gradYear) {
        for (String name : names) {
            MemberInfo mi = new MemberInfo(name, gradYear, true);
            memberList.add(mi);
        }


    }

    public ArrayList<MemberInfo> removeMembers(int year) {
        ArrayList<MemberInfo> removeList = new ArrayList<MemberInfo>();
        ArrayList<MemberInfo> returnList = new ArrayList<MemberInfo>();

        for (MemberInfo mi : memberList) {
            if (mi.getGradYear() <= year) {
                removeList.add(mi);
                if(mi.getGradYear() == year) {
                    returnList.add(mi);
                }
            }
        }
        memberList.removeAll(removeList);

        for (MemberInfo mi : returnList) {
            System.out.println(mi.getName() + mi.getGradYear());
        }
        return returnList;
    }

}