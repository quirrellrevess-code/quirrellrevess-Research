package com.p000nx.assist.log.standout;

import I1I.IL1Iii;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.flexbox.BuildConfig;
import com.p000nx.assist.log.standout.constants.StandOutFlags;
import com.p000nx.assist.log.standout.p001ui.TouchInfo;
import com.p000nx.assist.log.standout.p001ui.Window;
import com.p000nx.assist.log.standout.p001ui.adapter.LogcatViewerListAdapter;
import com.qyzs.smn2.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ConsoleWindow {
    private LogcatViewerListAdapter mAdapter;
    private Context mContext;
    private LinearLayout mFilterLayout;
    private LayoutInflater mLayoutInflater;
    private ListView mListView;
    private LinearLayout mMenuOptionLayout;
    private LinearLayout mNormalBottombarLayout;
    private RadioGroup mPriorityLevelRadioGroup;
    private WindowManager mWindowManager;
    private Map<Integer, Window> sWindowCache = new HashMap();
    private boolean bPause = false;
    private Window sFocusedWindow = null;

    public class DropDownListItem {
        public Runnable action;
        public String description;
        public int icon;

        public DropDownListItem(int i, String str, Runnable runnable) {
            this.icon = i;
            this.description = str;
            this.action = runnable;
        }

        public String toString() {
            return this.description;
        }
    }

    public ConsoleWindow(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService(IL1Iii.IL1Iii(new byte[]{64, 10, 8, 92, 10, 66}, IL1Iii.IL1Iii(new byte[]{7, 87, 95, 15, 84, 80}, IL1Iii.IL1Iii(new byte[]{2, 82, 1, 83, 82, 93}, "2f8dc8"))));
        this.mLayoutInflater = (LayoutInflater) this.mContext.getSystemService(IL1Iii.IL1Iii(new byte[]{13, 82, 78, 86, 20, 67, 62, 90, 89, 95, 13, 86, 21, 86, 69}, IL1Iii.IL1Iii(new byte[]{2, 6, 3, 92, 85, 84}, IL1Iii.IL1Iii(new byte[]{2, 86, 87, 81, 6, 86}, "acc425"))));
    }

    private View getViewByPosition(int i, ListView listView) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        return (i < firstVisiblePosition || i > (listView.getChildCount() + firstVisiblePosition) + (-1)) ? listView.getAdapter().getView(i, null, listView) : listView.getChildAt(i - firstVisiblePosition);
    }

    public static boolean isSet(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseImp(View view) {
        if (view != null) {
            pauseLogging();
            view.findViewById(R.id.pause).setVisibility(8);
            view.findViewById(R.id.play).setVisibility(0);
        }
    }

    private void pauseLogging() {
        this.bPause = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playImp(View view) {
        if (view != null) {
            resumeLogging();
            view.findViewById(R.id.play).setVisibility(8);
            view.findViewById(R.id.pause).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetMenuOptionLayout() {
        this.mFilterLayout.setVisibility(8);
        this.mPriorityLevelRadioGroup.setVisibility(8);
        this.mMenuOptionLayout.setVisibility(8);
    }

    private void resumeLogging() {
        this.bPause = false;
    }

    private void setupBottomBarView(final View view) {
        view.findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConsoleWindow.this.pauseImp(view);
            }
        });
        view.findViewById(R.id.play).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConsoleWindow.this.playImp(view);
            }
        });
        view.findViewById(R.id.find).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int visibility = ConsoleWindow.this.mFilterLayout.getVisibility();
                ConsoleWindow.this.resetMenuOptionLayout();
                if (visibility == 8) {
                    ConsoleWindow.this.mFilterLayout.setVisibility(0);
                    ConsoleWindow.this.mMenuOptionLayout.setVisibility(0);
                }
            }
        });
        view.findViewById(R.id.btnPriorityLevel).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int visibility = ConsoleWindow.this.mPriorityLevelRadioGroup.getVisibility();
                ConsoleWindow.this.resetMenuOptionLayout();
                if (visibility == 8) {
                    ConsoleWindow.this.mPriorityLevelRadioGroup.setVisibility(0);
                    ConsoleWindow.this.mMenuOptionLayout.setVisibility(0);
                }
            }
        });
        view.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ConsoleWindow.this.mAdapter.reset();
                ConsoleWindow.this.resetMenuOptionLayout();
            }
        });
    }

    private void setupFilterTextView(final View view) {
        view.findViewById(R.id.btnLogFilter).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String strTrim = ((EditText) view.findViewById(R.id.etLogFilter)).getText().toString().trim();
                ConsoleWindow.this.resetMenuOptionLayout();
                boolean z = ConsoleWindow.this.bPause;
                if (!z) {
                    ConsoleWindow.this.pauseImp(view);
                }
                ConsoleWindow.this.mAdapter.setLogFilterText(strTrim);
                if (z) {
                    return;
                }
                ConsoleWindow.this.playImp(view);
            }
        });
    }

    private void setupLogListView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.list);
        this.mListView = listView;
        listView.setStackFromBottom(true);
        this.mListView.setTranscriptMode(1);
        LogcatViewerListAdapter logcatViewerListAdapter = new LogcatViewerListAdapter(this.mContext.getApplicationContext());
        this.mAdapter = logcatViewerListAdapter;
        this.mListView.setAdapter((ListAdapter) logcatViewerListAdapter);
    }

    private void setupPriorityLevelView() {
        this.mPriorityLevelRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String strIL1Iii;
                if (i == R.id.radioDebug) {
                    strIL1Iii = IL1Iii.IL1Iii(new byte[]{65, 112, 20}, IL1Iii.IL1Iii(new byte[]{87, 85, 5, 80, 80, 95}, IL1Iii.IL1Iii(new byte[]{85, 88, 5, 1, 86, 3}, "c947ce")));
                } else if (i == R.id.radioInfo) {
                    strIL1Iii = IL1Iii.IL1Iii(new byte[]{24, 44, 19}, IL1Iii.IL1Iii(new byte[]{1, 1, 82, 1, 0, 4}, IL1Iii.IL1Iii(new byte[]{0, 5, 0, 85, 82, 84}, "9aa70f")));
                } else if (i == R.id.radioWarning) {
                    strIL1Iii = IL1Iii.IL1Iii(new byte[]{70, 103, 67}, IL1Iii.IL1Iii(new byte[]{83, 9, 91, 92, 1, 4}, IL1Iii.IL1Iii(new byte[]{2, 88, 14, 14, 12, 80}, "7a664f")));
                } else {
                    strIL1Iii = i == R.id.radioError ? IL1Iii.IL1Iii(new byte[]{16, 35, 70}, IL1Iii.IL1Iii(new byte[]{85, 82, 86, 5, 80, 2}, IL1Iii.IL1Iii(new byte[]{83, 81, 6, 81, 6, 87}, "6e6231"))) : BuildConfig.FLAVOR;
                }
                ConsoleWindow.this.mAdapter.setLogPriorityLevel(strIL1Iii);
                ConsoleWindow.this.resetMenuOptionLayout();
            }
        });
    }

    public final synchronized void bringToFront(int i) {
        Window window = getWindow(i);
        if (window == null) {
            return;
        }
        int i2 = window.visibility;
        if (i2 == 0) {
            return;
        }
        if (i2 == 2) {
            return;
        }
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        try {
            this.mWindowManager.removeView(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.mWindowManager.addView(window, layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void clearLog(int i) {
        this.mAdapter.reset();
        resetMenuOptionLayout();
    }

    public final synchronized void close(int i) {
        Window window = getWindow(i);
        if (window == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{50, 22, 92, 87, 6, 16, 18, 11, 21, 81, 14, 95, 21, 1, 29}, IL1Iii.IL1Iii(new byte[]{2, 80, 4, 0, 82, 2}, IL1Iii.IL1Iii(new byte[]{81, 82, 84, 6, 1, 83}, "5fe41a"))) + i + IL1Iii.IL1Iii(new byte[]{31, 17, 84, 69, 93, 20, 90, 93, 21, 18, 90, 15, 82, 94, 66, 75}, IL1Iii.IL1Iii(new byte[]{84, 84, 84, 93, 85, 2}, IL1Iii.IL1Iii(new byte[]{84, 4, 4, 93, 5, 87}, "6aeec4"))));
        }
        if (window.visibility == 2) {
            return;
        }
        unfocus(window);
        window.visibility = 2;
        try {
            this.mWindowManager.removeView(window);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAndAttachView(int i, FrameLayout frameLayout) {
        View viewInflate = ((LayoutInflater) this.mContext.getSystemService(IL1Iii.IL1Iii(new byte[]{13, 82, 77, 12, 17, 68, 62, 90, 90, 5, 8, 81, 21, 86, 70}, IL1Iii.IL1Iii(new byte[]{85, 81, 13, 7, 85, 81}, IL1Iii.IL1Iii(new byte[]{3, 81, 15, 86, 84, 2}, "7362ec"))))).inflate(R.layout.main, (ViewGroup) frameLayout, true);
        this.mMenuOptionLayout = (LinearLayout) viewInflate.findViewById(R.id.menuOptionsLayout);
        this.mFilterLayout = (LinearLayout) viewInflate.findViewById(R.id.filterLayout);
        this.mPriorityLevelRadioGroup = (RadioGroup) viewInflate.findViewById(R.id.rgPriorityLevels);
        this.mNormalBottombarLayout = (LinearLayout) viewInflate.findViewById(R.id.normalbottombar);
        setupLogListView(viewInflate);
        setupBottomBarView(viewInflate);
        setupFilterTextView(viewInflate);
        setupPriorityLevelView();
    }

    public final synchronized boolean focus(int i) {
        Window window = getWindow(i);
        if (window == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{101, 19, 8, 7, 7, 18, 69, 14, 65, 4, 12, 81, 68, 18, 73}, IL1Iii.IL1Iii(new byte[]{85, 7, 3, 81, 91, 2}, IL1Iii.IL1Iii(new byte[]{81, 80, 6, 3, 14, 84}, "56d06d"))) + i + IL1Iii.IL1Iii(new byte[]{74, 17, 88, 66, 13, 17, 15, 93, 25, 21, 10, 10, 7, 94, 78, 76}, IL1Iii.IL1Iii(new byte[]{2, 9, 11, 6, 82, 86}, IL1Iii.IL1Iii(new byte[]{0, 8, 84, 86, 8, 83}, "a0f29a"))));
        }
        if (isSet(window.flags, StandOutFlags.FLAG_WINDOW_FOCUSABLE_DISABLE)) {
            return false;
        }
        Window window2 = this.sFocusedWindow;
        if (window2 != null) {
            unfocus(window2);
        }
        return window.onFocus(true);
    }

    public int getAppIcon() {
        return this.mContext.getApplicationInfo().icon;
    }

    public String getAppName() {
        Context context = this.mContext;
        return context.getString(context.getApplicationInfo().labelRes);
    }

    public Context getContext() {
        return this.mContext;
    }

    public PopupWindow getDropDown(int i) {
        List<DropDownListItem> dropDownItems = getDropDownItems(i);
        if (dropDownItems == null) {
            dropDownItems = new ArrayList<>();
        }
        dropDownItems.add(new DropDownListItem(android.R.drawable.ic_menu_close_clear_cancel, IL1Iii.IL1Iii(new byte[]{52, 66, 12, 21, 68}, IL1Iii.IL1Iii(new byte[]{82, 5, 83, 89, 86, 85}, IL1Iii.IL1Iii(new byte[]{6, 0, 82, 94, 3, 80}, "12df1a"))) + getAppName(), new Runnable() { // from class: com.nx.assist.log.standout.ConsoleWindow.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }));
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        final PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
        for (final DropDownListItem dropDownListItem : dropDownItems) {
            ViewGroup viewGroup = (ViewGroup) this.mLayoutInflater.inflate(R.layout.drop_down_list_item, (ViewGroup) null);
            linearLayout.addView(viewGroup);
            ((ImageView) viewGroup.findViewById(R.id.icon)).setImageResource(dropDownListItem.icon);
            ((TextView) viewGroup.findViewById(R.id.description)).setText(dropDownListItem.description);
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ConsoleWindow.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dropDownListItem.action.run();
                    popupWindow.dismiss();
                }
            });
        }
        popupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(android.R.drawable.editbox_dropdown_dark_frame));
        return popupWindow;
    }

    public List<DropDownListItem> getDropDownItems(int i) {
        return null;
    }

    public int getFlags(int i) {
        return StandOutFlags.FLAG_DECORATION_SYSTEM | StandOutFlags.FLAG_BODY_MOVE_ENABLE | StandOutFlags.FLAG_WINDOW_HIDE_ENABLE | StandOutFlags.FLAG_WINDOW_BRING_TO_FRONT_ON_TAP | StandOutFlags.FLAG_WINDOW_EDGE_LIMITS_ENABLE | StandOutFlags.FLAG_WINDOW_PINCH_RESIZE_ENABLE;
    }

    public final Window getFocusedWindow() {
        return this.sFocusedWindow;
    }

    public StandOutLayoutParams getParams(int i, Window window) {
        DisplayMetrics displayMetrics = this.mContext.getApplicationContext().getResources().getDisplayMetrics();
        return new StandOutLayoutParams(this, i, Build.VERSION.SDK_INT >= 26 ? 2038 : 2002, (displayMetrics.widthPixels * 5) / 6, displayMetrics.heightPixels / 2, 0, 0, 0, 0);
    }

    public int getThemeStyle() {
        return 0;
    }

    public String getTitle(int i) {
        return getAppName();
    }

    public final Window getWindow(int i) {
        return this.sWindowCache.get(Integer.valueOf(i));
    }

    public final synchronized void hide(int i) {
        Window window = getWindow(i);
        if (window == null) {
            return;
        }
        if (window.visibility == 0) {
            Log.d(IL1Iii.IL1Iii(new byte[]{47, 61}, IL1Iii.IL1Iii(new byte[]{84, 86, 3, 0, 7, 81}, IL1Iii.IL1Iii(new byte[]{86, 87, 87, 91, 83, 85}, "cdf81f"))), IL1Iii.IL1Iii(new byte[]{53, 88, 93, 86, 10, 20, 66}, IL1Iii.IL1Iii(new byte[]{85, 7, 7, 10, 3, 90}, IL1Iii.IL1Iii(new byte[]{83, 87, 1, 93, 82, 12}, "da5e45"))) + i + IL1Iii.IL1Iii(new byte[]{22, 10, 23, 69, 85, 8, 68, 6, 5, 1, 77, 68, 94, 10, 0, 1, 81, 10, 24}, IL1Iii.IL1Iii(new byte[]{1, 0, 7, 3, 4, 86}, IL1Iii.IL1Iii(new byte[]{1, 82, 7, 0, 84, 87}, "61dfde"))));
        }
        if (isSet(window.flags, StandOutFlags.FLAG_WINDOW_HIDE_ENABLE)) {
            window.visibility = 2;
            try {
                this.mWindowManager.removeView(window);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            close(i);
        }
    }

    public void lock(int i) {
        Window window = getWindow(i);
        if (window == null) {
            return;
        }
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        if (layoutParams != null) {
            ((WindowManager.LayoutParams) layoutParams).flags |= 16;
        }
        if (window.getParent() != null) {
            updateViewLayout(i, layoutParams);
        }
    }

    public boolean onBringToFront(int i, Window window) {
        return false;
    }

    public boolean onFocusChange(int i, Window window, boolean z) {
        return false;
    }

    public boolean onKeyEvent(int i, Window window, KeyEvent keyEvent) {
        return false;
    }

    public void onMove(int i, Window window, View view, MotionEvent motionEvent) {
    }

    public void onResize(int i, Window window, View view, MotionEvent motionEvent) {
    }

    public boolean onTouchBody(int i, Window window, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchHandleMove(int i, Window window, View view, MotionEvent motionEvent) {
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        TouchInfo touchInfo = window.touchInfo;
        int i2 = touchInfo.lastX - touchInfo.firstX;
        int i3 = touchInfo.lastY - touchInfo.firstY;
        int action = motionEvent.getAction();
        if (action == 0) {
            window.touchInfo.lastX = (int) motionEvent.getRawX();
            window.touchInfo.lastY = (int) motionEvent.getRawY();
            TouchInfo touchInfo2 = window.touchInfo;
            touchInfo2.firstX = touchInfo2.lastX;
            touchInfo2.firstY = touchInfo2.lastY;
        } else if (action == 1) {
            window.touchInfo.moving = false;
        } else if (action == 2) {
            int rawX = ((int) motionEvent.getRawX()) - window.touchInfo.lastX;
            int rawY = (int) motionEvent.getRawY();
            TouchInfo touchInfo3 = window.touchInfo;
            int i4 = rawY - touchInfo3.lastY;
            touchInfo3.lastX = (int) motionEvent.getRawX();
            window.touchInfo.lastY = (int) motionEvent.getRawY();
            if (window.touchInfo.moving || Math.abs(i2) >= layoutParams.threshold || Math.abs(i3) >= layoutParams.threshold) {
                window.touchInfo.moving = true;
                if (isSet(window.flags, StandOutFlags.FLAG_BODY_MOVE_ENABLE)) {
                    if (motionEvent.getPointerCount() == 1) {
                        ((WindowManager.LayoutParams) layoutParams).x += rawX;
                        ((WindowManager.LayoutParams) layoutParams).y += i4;
                    }
                    window.edit().setPosition(((WindowManager.LayoutParams) layoutParams).x, ((WindowManager.LayoutParams) layoutParams).y).commit();
                }
            }
        }
        onMove(i, window, view, motionEvent);
        return true;
    }

    public boolean onTouchHandleResize(int i, Window window, View view, MotionEvent motionEvent) {
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        int action = motionEvent.getAction();
        if (action == 0) {
            window.touchInfo.lastX = (int) motionEvent.getRawX();
            window.touchInfo.lastY = (int) motionEvent.getRawY();
            TouchInfo touchInfo = window.touchInfo;
            touchInfo.firstX = touchInfo.lastX;
            touchInfo.firstY = touchInfo.lastY;
        } else if (action == 2) {
            int rawX = ((int) motionEvent.getRawX()) - window.touchInfo.lastX;
            int rawY = (int) motionEvent.getRawY();
            TouchInfo touchInfo2 = window.touchInfo;
            int i2 = rawY - touchInfo2.lastY;
            int i3 = ((WindowManager.LayoutParams) layoutParams).width + rawX;
            ((WindowManager.LayoutParams) layoutParams).width = i3;
            ((WindowManager.LayoutParams) layoutParams).height += i2;
            if (i3 >= layoutParams.minWidth && i3 <= layoutParams.maxWidth) {
                touchInfo2.lastX = (int) motionEvent.getRawX();
            }
            int i4 = ((WindowManager.LayoutParams) layoutParams).height;
            if (i4 >= layoutParams.minHeight && i4 <= layoutParams.maxHeight) {
                window.touchInfo.lastY = (int) motionEvent.getRawY();
            }
            window.edit().setSize(((WindowManager.LayoutParams) layoutParams).width, ((WindowManager.LayoutParams) layoutParams).height).commit();
        }
        onResize(i, window, view, motionEvent);
        return true;
    }

    public void pause(int i) {
        Window window = getWindow(i);
        if (window != null) {
            pauseImp(window);
        }
    }

    public void play(int i) {
        Window window = getWindow(i);
        if (window != null) {
            playImp(window);
        }
    }

    public final synchronized void println(int i, int i2, String str) {
        if (this.bPause) {
            return;
        }
        if (getWindow(i) == null) {
            return;
        }
        LogcatViewerListAdapter logcatViewerListAdapter = this.mAdapter;
        if (logcatViewerListAdapter != null) {
            logcatViewerListAdapter.addLogEntry(i2, str);
        }
    }

    public final void setFocusedWindow(Window window) {
        this.sFocusedWindow = window;
    }

    public void setPos(int i, int i2, int i3, int i4, int i5) {
        Log.i(IL1Iii.IL1Iii(new byte[]{125, 61}, IL1Iii.IL1Iii(new byte[]{2, 80, 80, 2, 86, 91}, IL1Iii.IL1Iii(new byte[]{85, 0, 4, 0, 85, 80}, "d5e142"))), IL1Iii.IL1Iii(new byte[]{29, 89}, IL1Iii.IL1Iii(new byte[]{81, 91, 7, 1, 85, 7}, IL1Iii.IL1Iii(new byte[]{4, 10, 0, 85, 3, 12}, "023d08"))) + i2 + IL1Iii.IL1Iii(new byte[]{95}, IL1Iii.IL1Iii(new byte[]{7, 8, 5, 80, 84, 13}, IL1Iii.IL1Iii(new byte[]{5, 84, 83, 4, 87, 11}, "fec642"))) + i3 + IL1Iii.IL1Iii(new byte[]{89}, IL1Iii.IL1Iii(new byte[]{84, 12, 6, 3, 81, 85}, IL1Iii.IL1Iii(new byte[]{82, 1, 85, 10, 0, 3}, "d9a9c4"))) + i4 + IL1Iii.IL1Iii(new byte[]{15}, IL1Iii.IL1Iii(new byte[]{86, 89, 80, 6, 3, 82}, IL1Iii.IL1Iii(new byte[]{87, 82, 5, 83, 0, 2}, "533d72"))) + i5);
        Window window = getWindow(i);
        if (window == null || i2 < 0 || i3 < 0) {
            return;
        }
        window.setXY(i2, i3, i4, i5);
    }

    public void setTitle(int i, String str) {
        Window window = getWindow(i);
        if (window != null) {
            ((TextView) window.findViewById(R.id.title)).setText(str);
        }
    }

    public final synchronized Window show(int i, float f) {
        Window window = getWindow(i);
        if (window == null) {
            window = new Window(this, i);
        }
        window.setAlpha(f);
        if (window.visibility == 1) {
            focus(i);
            return window;
        }
        window.visibility = 1;
        try {
            this.mWindowManager.addView(window, window.getLayoutParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.sWindowCache.put(Integer.valueOf(i), window);
        focus(i);
        return window;
    }

    public void showTitle(int i, boolean z) {
        Window window = getWindow(i);
        if (window != null) {
            if (z) {
                window.findViewById(R.id.titlebar).setVisibility(0);
            } else {
                window.findViewById(R.id.titlebar).setVisibility(8);
            }
        }
    }

    public synchronized boolean unfocus(Window window) {
        try {
            if (window == null) {
                throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{101, 20, 11, 7, 92, 65, 69, 9, 66, 23, 86, 7, 94, 5, 23, 17, 24, 0, 17, 8, 23, 14, 84, 65, 70, 15, 12, 6, 87, 22, 31}, IL1Iii.IL1Iii(new byte[]{4, 7, 91, 80, 9, 85}, IL1Iii.IL1Iii(new byte[]{84, 7, 14, 84, 84, 81}, "af7fee"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return window.onFocus(false);
    }

    public void unlock(int i) {
        Window window = getWindow(i);
        if (window == null) {
            return;
        }
        StandOutLayoutParams layoutParams = window.getLayoutParams();
        if (layoutParams != null) {
            ((WindowManager.LayoutParams) layoutParams).flags &= -17;
        }
        if (window.getParent() != null) {
            updateViewLayout(i, layoutParams);
        }
    }

    public void updateViewLayout(int i, StandOutLayoutParams standOutLayoutParams) {
        Window window = getWindow(i);
        if (window == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{97, 68, 95, 6, 7, 23, 65, 89, 22, 22, 19, 83, 84, 66, 83, 53, 10, 82, 66, 122, 87, 26, 12, 66, 65, 30}, IL1Iii.IL1Iii(new byte[]{87, 5, 87, 82, 83, 14}, IL1Iii.IL1Iii(new byte[]{6, 5, 89, 7, 2, 95}, "d6862f"))) + i + IL1Iii.IL1Iii(new byte[]{24, 23, 89, 20, 15, 23, 93, 91, 24, 67, 8, 12, 85, 88, 79, 26}, IL1Iii.IL1Iii(new byte[]{0, 15, 10, 81, 4, 80}, IL1Iii.IL1Iii(new byte[]{8, 93, 2, 0, 4, 87}, "9e0eae"))));
        }
        Log.i(IL1Iii.IL1Iii(new byte[]{122, 104}, IL1Iii.IL1Iii(new byte[]{1, 3, 85, 3, 0, 85}, IL1Iii.IL1Iii(new byte[]{3, 2, 7, 7, 81, 82}, "61fe41"))), IL1Iii.IL1Iii(new byte[]{20, 70, 2, 87, 68, 84, 55, 95, 3, 65, 124, 80, 24, 89, 19, 66, 10}, IL1Iii.IL1Iii(new byte[]{80, 14, 5, 6, 9, 9}, IL1Iii.IL1Iii(new byte[]{8, 11, 80, 84, 15, 10}, "933d62"))) + window.visibility);
        int i2 = window.visibility;
        if (i2 == 0 || i2 == 2) {
            return;
        }
        try {
            window.setLayoutParams(standOutLayoutParams);
            this.mWindowManager.updateViewLayout(window, standOutLayoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class StandOutLayoutParams extends WindowManager.LayoutParams {
        public static final int AUTO_POSITION = -2147483647;
        public static final int BOTTOM = Integer.MAX_VALUE;
        public static final int CENTER = Integer.MIN_VALUE;
        public static final int LEFT = 0;
        public static final int RIGHT = Integer.MAX_VALUE;
        public static final int TOP = 0;
        public int maxHeight;
        public int maxWidth;
        public int minHeight;
        public int minWidth;
        public int threshold;

        public StandOutLayoutParams(int i, int i2) {
            super(200, 200, i2, 262176, -3);
            int flags = ConsoleWindow.this.getFlags(i);
            setFocusFlag(false);
            if (!ConsoleWindow.isSet(flags, StandOutFlags.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                ((WindowManager.LayoutParams) this).flags |= 512;
            }
            ((WindowManager.LayoutParams) this).x = getX(i, ((WindowManager.LayoutParams) this).width);
            ((WindowManager.LayoutParams) this).y = getY(i, ((WindowManager.LayoutParams) this).height);
            ((WindowManager.LayoutParams) this).gravity = 51;
            this.threshold = 10;
            this.minHeight = 0;
            this.minWidth = 0;
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        private int getX(int i, int i2) {
            return ((ConsoleWindow.this.sWindowCache.size() * 100) + (i * 100)) % (ConsoleWindow.this.mWindowManager.getDefaultDisplay().getWidth() - i2);
        }

        private int getY(int i, int i2) {
            Display defaultDisplay = ConsoleWindow.this.mWindowManager.getDefaultDisplay();
            return ((ConsoleWindow.this.sWindowCache.size() * 100) + (((WindowManager.LayoutParams) this).x + (((i * 100) * 200) / (defaultDisplay.getWidth() - ((WindowManager.LayoutParams) this).width)))) % (defaultDisplay.getHeight() - i2);
        }

        public void setFocusFlag(boolean z) {
            if (z) {
                ((WindowManager.LayoutParams) this).flags ^= 8;
            } else {
                ((WindowManager.LayoutParams) this).flags |= 8;
            }
        }

        public StandOutLayoutParams(ConsoleWindow consoleWindow, int i, int i2, int i3, int i4) {
            this(i, i2);
            ((WindowManager.LayoutParams) this).width = i3;
            ((WindowManager.LayoutParams) this).height = i4;
        }

        public StandOutLayoutParams(ConsoleWindow consoleWindow, int i, int i2, int i3, int i4, int i5, int i6) {
            this(consoleWindow, i, i2, i3, i4);
            if (i5 != -2147483647) {
                ((WindowManager.LayoutParams) this).x = i5;
            }
            if (i6 != -2147483647) {
                ((WindowManager.LayoutParams) this).y = i6;
            }
            Display defaultDisplay = consoleWindow.mWindowManager.getDefaultDisplay();
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            int i7 = ((WindowManager.LayoutParams) this).x;
            if (i7 == Integer.MAX_VALUE) {
                ((WindowManager.LayoutParams) this).x = width - i3;
            } else if (i7 == Integer.MIN_VALUE) {
                ((WindowManager.LayoutParams) this).x = (width - i3) / 2;
            }
            int i8 = ((WindowManager.LayoutParams) this).y;
            if (i8 == Integer.MAX_VALUE) {
                ((WindowManager.LayoutParams) this).y = height - i4;
            } else if (i8 == Integer.MIN_VALUE) {
                ((WindowManager.LayoutParams) this).y = (height - i4) / 2;
            }
        }

        public StandOutLayoutParams(ConsoleWindow consoleWindow, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this(consoleWindow, i, i2, i3, i4, i5, i6);
            this.minWidth = i7;
            this.minHeight = i8;
        }

        public StandOutLayoutParams(ConsoleWindow consoleWindow, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this(consoleWindow, i, i2, i3, i4, i5, i6, i7, i8);
            this.threshold = i9;
        }
    }
}
