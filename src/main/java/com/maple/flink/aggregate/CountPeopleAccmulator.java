package com.maple.flink.aggregate;

public class CountPeopleAccmulator {

    private String id;
    private long  conunt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getConunt() {
        return conunt;
    }

    public void setConunt(long conunt) {
        this.conunt = conunt;
    }
}
