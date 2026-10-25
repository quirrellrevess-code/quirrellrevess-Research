package com.p000nx.assist.log.standout.p001ui.adapter;

import I1I.IL1Iii;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.qyzs.smn2.R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LogcatViewerListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private HashMap<String, Integer> mPriorityLevelColorMap;
    public static final String PRIORITY_LEVEL_VERBOSE = IL1Iii.IL1Iii(new byte[]{16, 53, 68}, IL1Iii.IL1Iii(new byte[]{86, 87, 82, 0, 8, 93}, IL1Iii.IL1Iii(new byte[]{84, 1, 6, 7, 13, 86}, "250252")));
    public static final String PRIORITY_LEVEL_DEBUG = IL1Iii.IL1Iii(new byte[]{16, 114, 25}, IL1Iii.IL1Iii(new byte[]{84, 85, 92, 80, 84, 0}, IL1Iii.IL1Iii(new byte[]{93, 6, 7, 93, 85, 1}, "9eb9b6")));
    public static final String PRIORITY_LEVEL_INFO = IL1Iii.IL1Iii(new byte[]{19, 47, 18}, IL1Iii.IL1Iii(new byte[]{6, 86, 83, 10, 4, 11}, IL1Iii.IL1Iii(new byte[]{12, 85, 88, 93, 3, 0}, "9e9d48")));
    public static final String PRIORITY_LEVEL_WARNING = IL1Iii.IL1Iii(new byte[]{67, 52, 24}, IL1Iii.IL1Iii(new byte[]{81, 81, 91, 93, 82, 82}, IL1Iii.IL1Iii(new byte[]{10, 83, 84, 1, 84, 85}, "8a78e6")));
    public static final String PRIORITY_LEVEL_ERROR = IL1Iii.IL1Iii(new byte[]{21, 124, 67}, IL1Iii.IL1Iii(new byte[]{5, 15, 82, 5, 84, 3}, IL1Iii.IL1Iii(new byte[]{2, 80, 7, 3, 3, 86}, "2f62bb")));
    private String mLogPriorityLevel = BuildConfig.FLAVOR;
    private String mLogFilterText = BuildConfig.FLAVOR;
    public final String[] mPriorityLevels = {IL1Iii.IL1Iii(new byte[]{24, 96, 70}, IL1Iii.IL1Iii(new byte[]{94, 87, 4, 87, 82, 7}, IL1Iii.IL1Iii(new byte[]{2, 4, 80, 7, 8, 87}, "de218d"))), IL1Iii.IL1Iii(new byte[]{65, 115, 23}, IL1Iii.IL1Iii(new byte[]{89, 5, 15, 84, 12, 83}, IL1Iii.IL1Iii(new byte[]{14, 4, 92, 83, 91, 7}, "66dcc7"))), IL1Iii.IL1Iii(new byte[]{65, 123, 20}, IL1Iii.IL1Iii(new byte[]{86, 83, 2, 7, 86, 95}, IL1Iii.IL1Iii(new byte[]{4, 5, 87, 84, 81, 15}, "3da106"))), IL1Iii.IL1Iii(new byte[]{20, 110, 66}, IL1Iii.IL1Iii(new byte[]{2, 10, 82, 81, 87, 5}, IL1Iii.IL1Iii(new byte[]{15, 0, 3, 85, 83, 80}, "933126"))), IL1Iii.IL1Iii(new byte[]{66, 38, 23}, IL1Iii.IL1Iii(new byte[]{80, 2, 81, 7, 80, 1}, IL1Iii.IL1Iii(new byte[]{11, 80, 87, 13, 86, 7}, "9118cc")))};
    private ArrayList<LogUnit> mLogcatData = new ArrayList<>();
    private ArrayList<LogUnit> mFilteredLogcatData = new ArrayList<>();

    public LogcatViewerListAdapter(Context context) {
        this.mInflater = (LayoutInflater) context.getSystemService(IL1Iii.IL1Iii(new byte[]{90, 85, 27, 89, 70, 64, 105, 93, 12, 80, 95, 85, 66, 81, 16}, IL1Iii.IL1Iii(new byte[]{83, 87, 80, 5, 86, 6}, IL1Iii.IL1Iii(new byte[]{92, 6, 11, 7, 0, 4}, "9e94e6"))));
        HashMap<String, Integer> map = new HashMap<>();
        this.mPriorityLevelColorMap = map;
        map.put(IL1Iii.IL1Iii(new byte[]{25, 50, 17}, IL1Iii.IL1Iii(new byte[]{12, 86, 82, 0, 13, 81}, IL1Iii.IL1Iii(new byte[]{81, 1, 91, 3, 7, 82}, "d3863f"))), -3355444);
        this.mPriorityLevelColorMap.put(IL1Iii.IL1Iii(new byte[]{67, 119, 20}, IL1Iii.IL1Iii(new byte[]{0, 85, 80, 80, 2, 90}, IL1Iii.IL1Iii(new byte[]{6, 4, 81, 3, 7, 91}, "eb5a1c"))), -15753896);
        this.mPriorityLevelColorMap.put(IL1Iii.IL1Iii(new byte[]{19, 45, 67}, IL1Iii.IL1Iii(new byte[]{81, 87, 84, 86, 7, 5}, IL1Iii.IL1Iii(new byte[]{84, 3, 82, 7, 2, 1}, "60ea66"))), -12417548);
        this.mPriorityLevelColorMap.put(IL1Iii.IL1Iii(new byte[]{65, 53, 19}, IL1Iii.IL1Iii(new byte[]{84, 85, 82, 83, 1, 81}, IL1Iii.IL1Iii(new byte[]{1, 0, 84, 83, 83, 0}, "475eba"))), -26624);
        this.mPriorityLevelColorMap.put(IL1Iii.IL1Iii(new byte[]{65, 124, 66}, IL1Iii.IL1Iii(new byte[]{86, 10, 84, 14, 87, 81}, IL1Iii.IL1Iii(new byte[]{4, 82, 84, 81, 82, 6}, "3abf03"))), -4640223);
    }

    private void addFilterLogcatEntry(LogUnit logUnit) {
        if (TextUtils.isEmpty(this.mLogPriorityLevel) || (!TextUtils.isEmpty(this.mLogPriorityLevel) && priorityLevelConditionForFiltering(logUnit.level))) {
            if (TextUtils.isEmpty(this.mLogFilterText) || (!TextUtils.isEmpty(this.mLogFilterText) && logUnit.log.toLowerCase().contains(this.mLogFilterText.toLowerCase()))) {
                this.mFilteredLogcatData.add(logUnit);
            }
        }
    }

    private void filterLogcatData() {
        this.mFilteredLogcatData.clear();
        if (TextUtils.isEmpty(this.mLogPriorityLevel) && TextUtils.isEmpty(this.mLogFilterText)) {
            this.mFilteredLogcatData = new ArrayList<>(this.mLogcatData);
        }
        for (LogUnit logUnit : this.mLogcatData) {
            if (TextUtils.isEmpty(this.mLogPriorityLevel) || (!TextUtils.isEmpty(this.mLogPriorityLevel) && priorityLevelConditionForFiltering(logUnit.level))) {
                if (TextUtils.isEmpty(this.mLogFilterText) || (!TextUtils.isEmpty(this.mLogFilterText) && logUnit.log.toLowerCase().contains(this.mLogFilterText.toLowerCase()))) {
                    this.mFilteredLogcatData.add(logUnit);
                }
            }
        }
    }

    private int getTextColorForLogcatEntry(String str) {
        String str2 = PRIORITY_LEVEL_VERBOSE;
        for (String str3 : this.mPriorityLevelColorMap.keySet()) {
            CharSequence charSequence = str3.trim() + IL1Iii.IL1Iii(new byte[]{76}, IL1Iii.IL1Iii(new byte[]{82, 80, 1, 4, 87, 89}, IL1Iii.IL1Iii(new byte[]{85, 82, 4, 2, 85, 84}, "da30d5")));
            if (str.contains(str3) || str.contains(charSequence)) {
                str2 = str3;
                break;
            }
        }
        return this.mPriorityLevelColorMap.get(str2).intValue();
    }

    private boolean priorityLevelConditionForFiltering(String str) {
        return !TextUtils.isEmpty(this.mLogPriorityLevel) && str.contains(this.mLogPriorityLevel);
    }

    public void addLogEntry(int i, String str) {
        String str2;
        if (i == 1) {
            str2 = PRIORITY_LEVEL_VERBOSE;
        } else if (i == 2) {
            str2 = PRIORITY_LEVEL_DEBUG;
        } else if (i == 3) {
            str2 = PRIORITY_LEVEL_INFO;
        } else if (i == 4) {
            str2 = PRIORITY_LEVEL_WARNING;
        } else {
            str2 = (i == 5 || i == 6) ? PRIORITY_LEVEL_ERROR : PRIORITY_LEVEL_INFO;
        }
        LogUnit logUnit = new LogUnit(str2, str);
        if (this.mLogcatData.size() > 100) {
            this.mLogcatData.remove(0);
        }
        if (this.mFilteredLogcatData.size() > 100) {
            this.mFilteredLogcatData.remove(0);
        }
        this.mLogcatData.add(logUnit);
        addFilterLogcatEntry(logUnit);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mFilteredLogcatData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mFilteredLogcatData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public String getLogFilterText() {
        return this.mLogFilterText;
    }

    public String getLogPriorityLevel() {
        return this.mLogPriorityLevel;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        LogUnit logUnit = this.mFilteredLogcatData.get(i);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.logentry_listitem, viewGroup, false);
            textView = (TextView) view.findViewById(R.id.logEntry);
            textView.setTypeface(Typeface.MONOSPACE);
            view.setTag(textView);
        } else {
            textView = (TextView) view.getTag();
        }
        textView.setText(logUnit.log);
        textView.setTextColor(getTextColorForLogcatEntry(logUnit.level));
        if (viewGroup.getScrollY() + viewGroup.getHeight() >= viewGroup.getBottom()) {
            ((ListView) viewGroup).setSelection(this.mFilteredLogcatData.size() - 1);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mFilteredLogcatData.size() == 0;
    }

    public void reset() {
        this.mLogFilterText = BuildConfig.FLAVOR;
        this.mLogPriorityLevel = BuildConfig.FLAVOR;
        this.mFilteredLogcatData.clear();
        this.mLogcatData.clear();
        notifyDataSetChanged();
    }

    public void setLogFilterText(String str) {
        if (this.mLogFilterText.equals(str)) {
            return;
        }
        this.mLogFilterText = str;
        filterLogcatData();
    }

    public void setLogPriorityLevel(String str) {
        if (this.mLogPriorityLevel.equals(str)) {
            return;
        }
        this.mLogPriorityLevel = str;
        filterLogcatData();
    }
}
