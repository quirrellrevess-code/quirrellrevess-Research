package com.p000nx.assist.lua;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public interface IGridAdapter {
    boolean areAllItemsEnabled();

    long getCount();

    Object getItem(int i);

    long getItemId(int i);

    long getItemViewType(int i);

    View getView(int i, View view, ViewGroup viewGroup);

    long getViewTypeCount();

    boolean hasStableIds();

    boolean isEmpty();

    boolean isEnabled(int i);

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
