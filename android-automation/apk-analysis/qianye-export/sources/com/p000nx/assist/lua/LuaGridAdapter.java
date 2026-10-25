package com.p000nx.assist.lua;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes.dex */
public class LuaGridAdapter implements ListAdapter {
    private IGridAdapter mAdapter;

    public LuaGridAdapter(IGridAdapter iGridAdapter) {
        this.mAdapter = null;
        this.mAdapter = iGridAdapter;
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mAdapter.areAllItemsEnabled();
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
    public int getItemViewType(int i) {
        return Long.valueOf(this.mAdapter.getItemViewType(i)).intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.mAdapter.getView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return Long.valueOf(this.mAdapter.getViewTypeCount()).intValue();
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.mAdapter.hasStableIds();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.mAdapter.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.mAdapter.isEnabled(i);
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }
}
