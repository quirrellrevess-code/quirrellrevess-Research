package com.p000nx.assist.lua;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: classes.dex */
public class LuaAdapter extends BaseAdapter {
    private IListAdapter mAdapter;

    public LuaAdapter(IListAdapter iListAdapter) {
        this.mAdapter = null;
        this.mAdapter = iListAdapter;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return Long.valueOf(this.mAdapter.getCount()).intValue();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mAdapter.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.mAdapter.getItemId(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.mAdapter.getView(i, view, viewGroup);
    }
}
