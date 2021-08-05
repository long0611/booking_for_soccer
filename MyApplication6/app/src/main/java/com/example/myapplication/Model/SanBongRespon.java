package com.example.myapplication.Model;

import com.example.myapplication.Meta.SanBongMeta;

import java.util.List;

public class SanBongRespon {
    private boolean error;
    private List<SanBongMeta> sanBongMetas;

    public SanBongRespon(boolean error, List<SanBongMeta> sanBongMetas) {
        this.error = error;
        this.sanBongMetas = sanBongMetas;
    }

    public boolean isError() {
        return error;
    }

    public List<SanBongMeta> getSanBongMetas() {
        return sanBongMetas;
    }
}
