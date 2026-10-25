package com.p000nx.assist.log.standout.p001ui.adapter;

import I1I.IL1Iii;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.qyzs.smn2.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LogRecordsListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private File[] mLogRecordsFiles;

    public class ViewHolder {
        public TextView mTvRecordFileLastModified;
        public TextView mTvRecordFileSize;
        public TextView mTvRecordFilename;

        private ViewHolder() {
        }
    }

    public LogRecordsListAdapter(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService(IL1Iii.IL1Iii(new byte[]{88, 0, 26, 11, 70, 68, 107, 8, 13, 2, 95, 81, 64, 4, 17}, IL1Iii.IL1Iii(new byte[]{82, 85, 84, 84, 6, 4}, IL1Iii.IL1Iii(new byte[]{0, 86, 85, 2, 87, 80}, "fbb2bd"))));
        readAllRecordsFiles();
    }

    private String getRecordFileSize(long j) {
        String strIL1Iii;
        byte[] bArr = {123, 36};
        if (j / 1048576 == 0) {
            // fill-array-data instruction
            bArr[0] = 46;
            bArr[1] = 118;
            strIL1Iii = IL1Iii.IL1Iii(bArr, IL1Iii.IL1Iii(new byte[]{7, 0, 14, 83, 5, 7}, IL1Iii.IL1Iii(new byte[]{83, 86, 14, 12, 80, 4}, "1b8967")));
        } else {
            strIL1Iii = IL1Iii.IL1Iii(bArr, IL1Iii.IL1Iii(new byte[]{80, 86, 11, 83, 88, 4}, IL1Iii.IL1Iii(new byte[]{3, 9, 80, 3, 83, 11}, "e9b128")));
        }
        return String.format(IL1Iii.IL1Iii(new byte[]{29, 77, 80, 85, 20}, IL1Iii.IL1Iii(new byte[]{13, 86, 1, 3, 80, 87}, IL1Iii.IL1Iii(new byte[]{13, 87, 90, 0, 85, 84}, "8b901a"))) + strIL1Iii, Double.valueOf(j / (strIL1Iii.compareTo(IL1Iii.IL1Iii(new byte[]{124, 119}, IL1Iii.IL1Iii(new byte[]{15, 83, 86, 90, 1, 0}, IL1Iii.IL1Iii(new byte[]{12, 84, 1, 1, 82, 86}, "42c97f")))) == 0 ? 1024.0d : 1048576.0d)));
    }

    private void readAllRecordsFiles() {
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mLogRecordsFiles.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mLogRecordsFiles[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        File file = this.mLogRecordsFiles[i];
        if (view == null) {
            view = this.mInflater.inflate(R.layout.logrecord_listitem, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mTvRecordFilename = (TextView) view.findViewById(R.id.recordFilename);
            viewHolder.mTvRecordFileLastModified = (TextView) view.findViewById(R.id.recordFileLastModified);
            viewHolder.mTvRecordFileSize = (TextView) view.findViewById(R.id.recordFileSize);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTvRecordFilename.setText(file.getName());
        viewHolder.mTvRecordFileLastModified.setText(new SimpleDateFormat(IL1Iii.IL1Iii(new byte[]{1, 87, 24, 117, 117, 30, 28, 74, 78, 65, 24, 89, 13, 9, 90, 85, 2, 66, 22}, IL1Iii.IL1Iii(new byte[]{84, 3, 7, 89, 14, 2}, IL1Iii.IL1Iii(new byte[]{3, 86, 86, 89, 15, 0}, "2ff893"))), Locale.US).format(new Date(file.lastModified())));
        viewHolder.mTvRecordFileSize.setText(getRecordFileSize(file.length()));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mLogRecordsFiles.length == 0;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        readAllRecordsFiles();
        super.notifyDataSetChanged();
    }
}
