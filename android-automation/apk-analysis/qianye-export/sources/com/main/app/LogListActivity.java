package com.main.app;

import I1I.I1I.p008IL.lIlii;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.qyzs.smn2.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LogListActivity extends AppCompatActivity {
    public ListView iIlLiL;
    public FileObserver llliI;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public TextView f2867lL;
    public List<String> I11li1 = new ArrayList();
    public View I11L = null;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public BaseAdapter f2868l = new IL1Iii();

    public class I1I implements Runnable {

        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogListActivity.this.I11L.setVisibility(8);
                LogListActivity.this.iIlLiL.setAdapter((ListAdapter) LogListActivity.this.f2868l);
                LogListActivity.this.m3456L11();
            }
        }

        public I1I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File fileM20lL = lIlii.m20lL(LogListActivity.this);
            if (fileM20lL != null) {
                for (File file : fileM20lL.listFiles()) {
                    LogListActivity.this.I11li1.add(file.getAbsolutePath());
                }
            }
            LogListActivity.this.runOnUiThread(new IL1Iii());
        }
    }

    public class IL1Iii extends BaseAdapter {
        public IL1Iii() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return LogListActivity.this.I11li1.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return LogListActivity.this.I11li1.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(LogListActivity.this, R.layout.log_listitem, null);
                C0672il c0672il = new C0672il(LogListActivity.this, null);
                c0672il.f5309IL1Iii = (TextView) view.findViewById(R.id.name);
                view.setTag(c0672il);
            }
            ((C0672il) view.getTag()).f5309IL1Iii.setText(new File((String) LogListActivity.this.I11li1.get(i)).getName());
            return view;
        }
    }

    public class ILil implements View.OnClickListener {
        public ILil() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogListActivity.this.m3458ill();
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$I丨L, reason: invalid class name */
    public class IL implements AdapterView.OnItemClickListener {
        public IL() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            String str = (String) LogListActivity.this.I11li1.get(i);
            Intent intent = new Intent(LogListActivity.this, (Class<?>) LogActivity.class);
            intent.putExtra(I1I.IL1Iii.IL1Iii(new byte[]{82, 95, 94, 6}, I1I.IL1Iii.IL1Iii(new byte[]{13, 87, 86, 85, 84, 85}, I1I.IL1Iii.IL1Iii(new byte[]{88, 3, 86, 1, 81, 91}, "ab2728"))), str);
            LogListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$I丨iL, reason: invalid class name */
    public class IiL implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5303ILil;

        public IiL(String str) {
            this.f5303ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogListActivity.this.I11li1.remove(this.f5303ILil);
            LogListActivity.this.f2868l.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$L丨1丨1丨I, reason: invalid class name */
    public class L11I implements Runnable {

        /* JADX INFO: renamed from: com.main.app.LogListActivity$L丨1丨1丨I$IL1Iii */
        public class IL1Iii implements Runnable {
            public IL1Iii() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LogListActivity.this.I11li1.clear();
                LogListActivity.this.I11L.setVisibility(8);
                LogListActivity.this.f2868l.notifyDataSetChanged();
            }
        }

        public L11I() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (File file : lIlii.m20lL(LogListActivity.this).listFiles()) {
                if (file.exists()) {
                    file.delete();
                }
            }
            LogListActivity.this.runOnUiThread(new IL1Iii());
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$iI丨LLL1, reason: invalid class name */
    public class iILLL1 implements Runnable {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ String f5307ILil;

        public iILLL1(String str) {
            this.f5307ILil = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogListActivity.this.I11li1.add(this.f5307ILil);
            LogListActivity.this.f2868l.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$l丨Li1LL, reason: invalid class name */
    public class lLi1LL extends FileObserver {
        public lLi1LL(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (str == null) {
                return;
            }
            File file = new File(lIlii.m20lL(LogListActivity.this), str);
            if (i == 256) {
                LogListActivity.this.m3457LIll(file.getAbsolutePath());
            } else {
                if (i != 512) {
                    return;
                }
                LogListActivity.this.m3459(file.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.LogListActivity$丨il, reason: invalid class name and case insensitive filesystem */
    public class C0672il {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public TextView f5309IL1Iii;

        public C0672il(LogListActivity logListActivity) {
        }

        public /* synthetic */ C0672il(LogListActivity logListActivity, IL1Iii iL1Iii) {
            this(logListActivity);
        }
    }

    /* JADX INFO: renamed from: L11丨, reason: contains not printable characters */
    public final void m3456L11() {
        lLi1LL lli1ll = new lLi1LL(lIlii.m20lL(this).getAbsolutePath());
        this.llliI = lli1ll;
        if (lli1ll != null) {
            try {
                lli1ll.startWatching();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: LI丨丨l丨l, reason: contains not printable characters */
    public final void m3457LIll(String str) {
        runOnUiThread(new iILLL1(str));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            FileObserver fileObserver = this.llliI;
            if (fileObserver != null) {
                fileObserver.stopWatching();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: il丨l丨, reason: contains not printable characters */
    public final void m3458ill() {
        this.I11L.setVisibility(0);
        new Thread(new L11I()).start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.loglist_activity);
        this.iIlLiL = (ListView) findViewById(R.id.listdir);
        this.I11L = findViewById(R.id.empty_page);
        TextView textView = (TextView) findViewById(R.id.delall);
        this.f2867lL = textView;
        textView.setOnClickListener(new ILil());
        this.I11L.setVisibility(0);
        new Thread(new I1I()).start();
        this.iIlLiL.setOnItemClickListener(new IL());
    }

    /* JADX INFO: renamed from: 丨丨丨丨, reason: contains not printable characters */
    public final void m3459(String str) {
        runOnUiThread(new IiL(str));
    }
}
