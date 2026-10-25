package com.p000nx.assist.log.standout.p001ui;

import I1I.I1I.p008IL.lIlii;
import I1I.IL1Iii;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.p000nx.assist.log.standout.ConsoleWindow;
import com.p000nx.assist.log.standout.constants.StandOutFlags;
import com.qyzs.smn2.R;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class Window extends FrameLayout {
    public static final String TAG = IL1Iii.IL1Iii(new byte[]{98, 88, 95, 80, 93, 78}, IL1Iii.IL1Iii(new byte[]{0, 3, 7, 13, 3, 88}, IL1Iii.IL1Iii(new byte[]{13, 11, 1, 15, 5, 3}, "89764b")));
    public static final int VISIBILITY_GONE = 0;
    public static final int VISIBILITY_TRANSITION = 2;
    public static final int VISIBILITY_VISIBLE = 1;
    public Bundle data;
    public int flags;
    public boolean focused;

    /* JADX INFO: renamed from: id */
    public int f86id;
    private final ConsoleWindow mContext;
    private LayoutInflater mLayoutInflater;
    public ConsoleWindow.StandOutLayoutParams originalParams;
    public TouchInfo touchInfo;
    public int visibility;

    public class Editor {
        public static final int UNCHANGED = Integer.MIN_VALUE;
        public ConsoleWindow.StandOutLayoutParams mParams;
        public float anchorY = 0.0f;
        public float anchorX = 0.0f;

        public Editor() {
            this.mParams = Window.this.getLayoutParams();
        }

        public void commit() {
            if (this.mParams != null) {
                Log.i(IL1Iii.IL1Iii(new byte[]{120, 96}, IL1Iii.IL1Iii(new byte[]{7, 13, 86, 4, 11, 0}, IL1Iii.IL1Iii(new byte[]{8, 87, 86, 3, 4, 86}, "9bf462"))), IL1Iii.IL1Iii(new byte[]{84, 9, 8, 90, 81, 18, 13}, IL1Iii.IL1Iii(new byte[]{85, 3, 3, 0, 12, 2}, IL1Iii.IL1Iii(new byte[]{80, 0, 95, 14, 4, 6}, "2e990b"))) + this.mParams);
                Window.this.mContext.updateViewLayout(Window.this.f86id, this.mParams);
                this.mParams = null;
            }
        }

        public Editor setAnchorPoint(float f, float f2) {
            if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
                throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{34, 93, 80, 91, 87, 16, 67, 67, 92, 90, 86, 22, 67, 94, 70, 64, 76, 66, 1, 86, 19, 81, 93, 22, 20, 86, 86, 93, 24, 82, 67, 82, 93, 87, 24, 83, 79, 19, 90, 93, 91, 14, 22, 64, 90, 69, 93, 76}, IL1Iii.IL1Iii(new byte[]{85, 1, 2, 85, 13, 4}, IL1Iii.IL1Iii(new byte[]{2, 83, 85, 83, 1, 84}, "4ad542"))));
            }
            this.anchorX = f;
            this.anchorY = f2;
            return this;
        }

        public Editor setPosition(float f, float f2) {
            Point displaySize = Window.this.getDisplaySize();
            return setPosition((int) (displaySize.x * f), (int) (displaySize.y * f2));
        }

        public Editor setSize(int i, int i2) {
            return setSize(i, i2, false);
        }

        private Editor setSize(int i, int i2, boolean z) {
            if (this.mParams != null) {
                float f = this.anchorX;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.anchorY;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        Point displaySize = Window.this.getDisplaySize();
                        ConsoleWindow.StandOutLayoutParams standOutLayoutParams = this.mParams;
                        if (i == -1) {
                            i = displaySize.x;
                        }
                        if (i2 == -1) {
                            i2 = displaySize.y;
                        }
                        int i3 = ((WindowManager.LayoutParams) standOutLayoutParams).width;
                        int i4 = ((WindowManager.LayoutParams) standOutLayoutParams).height;
                        if (i != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).width = i;
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            ((WindowManager.LayoutParams) standOutLayoutParams).height = i2;
                        }
                        int iMin = standOutLayoutParams.maxWidth;
                        int iMin2 = standOutLayoutParams.maxHeight;
                        int i5 = displaySize.x;
                        int i6 = displaySize.y;
                        if (ConsoleWindow.isSet(Window.this.flags, StandOutFlags.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            iMin = Math.min(iMin, i5);
                            iMin2 = Math.min(iMin2, i6);
                        }
                        ConsoleWindow.StandOutLayoutParams standOutLayoutParams2 = this.mParams;
                        ((WindowManager.LayoutParams) standOutLayoutParams2).width = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).width, standOutLayoutParams2.minWidth), iMin);
                        ConsoleWindow.StandOutLayoutParams standOutLayoutParams3 = this.mParams;
                        ((WindowManager.LayoutParams) standOutLayoutParams3).height = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).height, standOutLayoutParams3.minHeight), iMin2);
                        if (ConsoleWindow.isSet(Window.this.flags, StandOutFlags.FLAG_WINDOW_ASPECT_RATIO_ENABLE)) {
                            ConsoleWindow.StandOutLayoutParams standOutLayoutParams4 = this.mParams;
                            float f3 = ((WindowManager.LayoutParams) standOutLayoutParams4).height;
                            float f4 = Window.this.touchInfo.ratio;
                            int i7 = (int) (f3 * f4);
                            int i8 = (int) (((WindowManager.LayoutParams) standOutLayoutParams4).width / f4);
                            if (i8 < standOutLayoutParams4.minHeight || i8 > standOutLayoutParams4.maxHeight) {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).width = i7;
                            } else {
                                ((WindowManager.LayoutParams) standOutLayoutParams4).height = i8;
                            }
                        }
                        ConsoleWindow.StandOutLayoutParams standOutLayoutParams5 = this.mParams;
                        if (((WindowManager.LayoutParams) standOutLayoutParams5).width >= displaySize.x) {
                            ((WindowManager.LayoutParams) standOutLayoutParams5).width = -1;
                        }
                        if (((WindowManager.LayoutParams) standOutLayoutParams5).height >= displaySize.y) {
                            ((WindowManager.LayoutParams) standOutLayoutParams5).height = -1;
                        }
                        if (!z) {
                            setPosition((int) (((WindowManager.LayoutParams) standOutLayoutParams5).x + (i3 * this.anchorX)), (int) (((WindowManager.LayoutParams) standOutLayoutParams5).y + (i4 * this.anchorY)));
                        }
                    }
                }
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{121, 93, 86, 93, 94, 70, 24, 67, 90, 92, 95, 64, 24, 94, 64, 70, 69, 20, 90, 86, 21, 87, 84, 64, 79, 86, 80, 91, 17, 4, 24, 82, 91, 81, 17, 5, 20, 19, 92, 91, 82, 88, 77, 64, 92, 67, 84, 26}, IL1Iii.IL1Iii(new byte[]{8, 85, 1, 6, 7, 1}, IL1Iii.IL1Iii(new byte[]{6, 87, 1, 3, 85, 83}, "6150cf"))));
            }
            return this;
        }

        public Editor setPosition(int i, int i2) {
            return setPosition(i, i2, false);
        }

        private Editor setPosition(int i, int i2, boolean z) {
            ConsoleWindow.StandOutLayoutParams standOutLayoutParams = this.mParams;
            if (standOutLayoutParams != null) {
                float f = this.anchorX;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.anchorY;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        if (i != Integer.MIN_VALUE) {
                            int i3 = ((WindowManager.LayoutParams) standOutLayoutParams).width;
                            if (i3 != -1) {
                                ((WindowManager.LayoutParams) standOutLayoutParams).x = (int) (i - (i3 * f));
                            } else {
                                ((WindowManager.LayoutParams) standOutLayoutParams).x = 0;
                            }
                        }
                        if (i2 != Integer.MIN_VALUE) {
                            int i4 = ((WindowManager.LayoutParams) standOutLayoutParams).height;
                            if (i4 != -1) {
                                ((WindowManager.LayoutParams) standOutLayoutParams).y = (int) (i2 - (i4 * f2));
                            } else {
                                ((WindowManager.LayoutParams) standOutLayoutParams).y = 0;
                            }
                        }
                        if (ConsoleWindow.isSet(Window.this.flags, StandOutFlags.FLAG_WINDOW_EDGE_LIMITS_ENABLE)) {
                            if (((WindowManager.LayoutParams) this.mParams).gravity == 51) {
                                Point displaySize = Window.this.getDisplaySize();
                                ConsoleWindow.StandOutLayoutParams standOutLayoutParams2 = this.mParams;
                                if (((WindowManager.LayoutParams) standOutLayoutParams2).width != -1) {
                                    ((WindowManager.LayoutParams) standOutLayoutParams2).x = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams2).x, 0), displaySize.x - ((WindowManager.LayoutParams) this.mParams).width);
                                } else {
                                    ((WindowManager.LayoutParams) standOutLayoutParams2).x = 0;
                                }
                                ConsoleWindow.StandOutLayoutParams standOutLayoutParams3 = this.mParams;
                                if (((WindowManager.LayoutParams) standOutLayoutParams3).height != -1) {
                                    ((WindowManager.LayoutParams) standOutLayoutParams3).y = Math.min(Math.max(((WindowManager.LayoutParams) standOutLayoutParams3).y, 0), displaySize.y - ((WindowManager.LayoutParams) this.mParams).height);
                                } else {
                                    ((WindowManager.LayoutParams) standOutLayoutParams3).y = 0;
                                }
                            } else {
                                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{99, 10, 83, 22, 65, 81, 89, 6, 89, 65, 22}, IL1Iii.IL1Iii(new byte[]{83, 3, 4, 15, 82, 1}, IL1Iii.IL1Iii(new byte[]{1, 87, 1, 88, 83, 90}, "e63a7c"))) + Window.this.f86id + IL1Iii.IL1Iii(new byte[]{18, 5, 64, 88, 21, 12, 70, 27, 18, 84, 22, 22, 70, 66, 80, 92, 67, 49, 125, 50, 78, 117, 38, 35, 102, 66, 91, 95, 67, 35, 126, 35, 117, 102, 52, 44, 124, 38, 125, 110, 60, 32, 118, 37, 119, 102, 47, 44, 127, 43, 102, 106, 60, 32, 124, 35, 112, 117, 38, 69, 93, 16, 18, 127, 47, 36, 117, 61, 101, 112, 45, 33, 125, 53, 109, 124, 39, 34, 119, 61, 102, 112, 47, 32, 109, 39, 124, 120, 33, 41, 119, 66, 91, 74, 67, 22, 87, 22, 28}, IL1Iii.IL1Iii(new byte[]{4, 6, 0, 95, 91, 87}, IL1Iii.IL1Iii(new byte[]{14, 5, 81, 87, 1, 80}, "8ac19b"))));
                            }
                        }
                    }
                }
                throw new IllegalStateException(IL1Iii.IL1Iii(new byte[]{115, 95, 0, 92, 87, 71, 18, 65, 12, 93, 86, 65, 18, 92, 22, 71, 76, 21, 80, 84, 67, 86, 93, 65, 69, 84, 6, 90, 24, 5, 18, 80, 13, 80, 24, 4, 30, 17, 10, 90, 91, 89, 71, 66, 10, 66, 93, 27}, IL1Iii.IL1Iii(new byte[]{87, 87, 84, 2, 91, 81}, IL1Iii.IL1Iii(new byte[]{83, 87, 3, 15, 7, 7}, "6149dc"))));
            }
            return this;
        }
    }

    public static class WindowDataKeys {
        public static final String IS_MAXIMIZED = IL1Iii.IL1Iii(new byte[]{88, 23, 121, 0, 28, 8, 92, 13, 78, 4, 0}, IL1Iii.IL1Iii(new byte[]{82, 82, 2, 86, 83, 84}, IL1Iii.IL1Iii(new byte[]{82, 87, 87, 83, 14, 6}, "1aad93")));
        public static final String WIDTH_BEFORE_MAXIMIZE = IL1Iii.IL1Iii(new byte[]{18, 81, 5, 68, 14, 33, 0, 94, 14, 66, 3, 46, 4, 64, 8, 93, 15, 25, 0}, IL1Iii.IL1Iii(new byte[]{1, 9, 84, 84, 86, 90}, IL1Iii.IL1Iii(new byte[]{86, 2, 81, 93, 1, 90}, "23d91c")));
        public static final String HEIGHT_BEFORE_MAXIMIZE = IL1Iii.IL1Iii(new byte[]{9, 84, 8, 80, 10, 69, 35, 84, 7, 88, 16, 84, 44, 80, 25, 94, 15, 88, 27, 84}, IL1Iii.IL1Iii(new byte[]{89, 5, 2, 2, 87, 82}, IL1Iii.IL1Iii(new byte[]{14, 1, 87, 1, 2, 1}, "65447b")));
        public static final String X_BEFORE_MAXIMIZE = IL1Iii.IL1Iii(new byte[]{76, 122, 6, 85, 91, 20, 81, 117, 2, 75, 93, 11, 93, 66, 6}, IL1Iii.IL1Iii(new byte[]{13, 14, 87, 85, 3, 3}, IL1Iii.IL1Iii(new byte[]{95, 14, 82, 95, 83, 93}, "f8f9d8")));
        public static final String Y_BEFORE_MAXIMIZE = IL1Iii.IL1Iii(new byte[]{76, 38, 4, 87, 91, 22, 80, 41, 0, 73, 93, 9, 92, 30, 4}, IL1Iii.IL1Iii(new byte[]{2, 81, 3, 5, 2, 84}, IL1Iii.IL1Iii(new byte[]{83, 84, 91, 86, 85, 2}, "da9bc2")));
    }

    public Window(Context context) {
        super(context);
        this.mContext = null;
    }

    private View getSystemDecorations() {
        View viewInflate = this.mLayoutInflater.inflate(R.layout.system_window_decorators, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(this.mContext.getTitle(this.f86id));
        viewInflate.findViewById(R.id.window_icon).setBackgroundResource(R.mipmap.ic_launcher);
        viewInflate.findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ui.Window.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Window.this.mContext.hide(Window.this.f86id);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R.id.maximize);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.nx.assist.log.standout.ui.Window.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConsoleWindow.StandOutLayoutParams layoutParams = Window.this.getLayoutParams();
                if (Window.this.data.getBoolean(IL1Iii.IL1Iii(new byte[]{88, 23, 120, 4, 27, 94, 92, 13, 79, 0, 7}, IL1Iii.IL1Iii(new byte[]{3, 83, 3, 87, 1, 82}, IL1Iii.IL1Iii(new byte[]{3, 83, 84, 7, 90, 6}, "1db58c")))) && ((WindowManager.LayoutParams) layoutParams).width == -1 && ((WindowManager.LayoutParams) layoutParams).height == -1 && ((WindowManager.LayoutParams) layoutParams).x == 0 && ((WindowManager.LayoutParams) layoutParams).y == 0) {
                    Window.this.data.putBoolean(IL1Iii.IL1Iii(new byte[]{8, 67, 46, 3, 78, 15, 12, 89, 25, 7, 82}, IL1Iii.IL1Iii(new byte[]{84, 1, 87, 3, 14, 82}, IL1Iii.IL1Iii(new byte[]{5, 8, 1, 83, 89, 2}, "0952a6"))), false);
                    int i = Window.this.data.getInt(IL1Iii.IL1Iii(new byte[]{79, 93, 6, 65, 88, 118, 93, 82, 13, 71, 85, 121, 89, 76, 11, 88, 89, 78, 93}, IL1Iii.IL1Iii(new byte[]{15, 6, 90, 84, 81, 85}, IL1Iii.IL1Iii(new byte[]{7, 6, 12, 4, 88, 81}, "044e90"))), -1);
                    int i2 = Window.this.data.getInt(IL1Iii.IL1Iii(new byte[]{90, 83, 10, 81, 90, 17, 112, 83, 5, 89, 64, 0, 127, 87, 27, 95, 95, 12, 72, 83}, IL1Iii.IL1Iii(new byte[]{80, 14, 85, 15, 0, 0}, IL1Iii.IL1Iii(new byte[]{0, 93, 87, 14, 11, 1}, "bea79d"))), -1);
                    Window.this.edit().setSize(i, i2).setPosition(Window.this.data.getInt(IL1Iii.IL1Iii(new byte[]{72, 39, 81, 80, 14, 65, 85, 40, 85, 78, 8, 94, 89, 31, 81}, IL1Iii.IL1Iii(new byte[]{84, 4, 3, 15, 86, 10}, IL1Iii.IL1Iii(new byte[]{2, 5, 85, 9, 6, 12}, "fdb015"))), -1), Window.this.data.getInt(IL1Iii.IL1Iii(new byte[]{72, 113, 92, 5, 94, 71, 84, 126, 88, 27, 88, 88, 88, 73, 92}, IL1Iii.IL1Iii(new byte[]{80, 5, 10, 2, 80, 2}, IL1Iii.IL1Iii(new byte[]{83, 1, 1, 86, 82, 85}, "27273b"))), -1)).commit();
                    return;
                }
                Window.this.data.putBoolean(IL1Iii.IL1Iii(new byte[]{15, 18, 44, 0, 78, 93, 11, 8, 27, 4, 82}, IL1Iii.IL1Iii(new byte[]{2, 80, 86, 2, 3, 3}, IL1Iii.IL1Iii(new byte[]{83, 3, 6, 86, 81, 7}, "7215d0"))), true);
                Window.this.data.putInt(IL1Iii.IL1Iii(new byte[]{71, 92, 84, 66, 80, 119, 85, 83, 95, 68, 93, 120, 81, 77, 89, 91, 81, 79, 85}, IL1Iii.IL1Iii(new byte[]{6, 0, 84, 0, 94, 86}, IL1Iii.IL1Iii(new byte[]{0, 2, 83, 85, 3, 2}, "677cea"))), ((WindowManager.LayoutParams) layoutParams).width);
                Window.this.data.putInt(IL1Iii.IL1Iii(new byte[]{91, 85, 13, 1, 88, 22, 113, 85, 2, 9, 66, 7, 126, 81, 28, 15, 93, 11, 73, 85}, IL1Iii.IL1Iii(new byte[]{3, 4, 7, 83, 1, 87}, IL1Iii.IL1Iii(new byte[]{3, 5, 83, 80, 84, 13}, "310ee8"))), ((WindowManager.LayoutParams) layoutParams).height);
                Window.this.data.putInt(IL1Iii.IL1Iii(new byte[]{29, 118, 3, 82, 91, 66, 0, 121, 7, 76, 93, 93, 12, 78, 3}, IL1Iii.IL1Iii(new byte[]{4, 5, 85, 7, 82, 84}, IL1Iii.IL1Iii(new byte[]{0, 82, 10, 2, 80, 86}, "ac9162"))), ((WindowManager.LayoutParams) layoutParams).x);
                Window.this.data.putInt(IL1Iii.IL1Iii(new byte[]{76, 114, 3, 0, 86, 74, 80, 125, 7, 30, 80, 85, 92, 74, 3}, IL1Iii.IL1Iii(new byte[]{81, 81, 80, 7, 88, 94}, IL1Iii.IL1Iii(new byte[]{85, 83, 15, 80, 4, 85}, "1291e3"))), ((WindowManager.LayoutParams) layoutParams).y);
                Window.this.edit().setSize(-1, -1).setPosition(0, 0).commit();
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.titlebar);
        viewFindViewById2.setOnTouchListener(new View.OnTouchListener() { // from class: com.nx.assist.log.standout.ui.Window.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ConsoleWindow consoleWindow = Window.this.mContext;
                Window window = Window.this;
                return consoleWindow.onTouchHandleMove(window.f86id, window, view, motionEvent);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.corner);
        viewFindViewById3.setOnTouchListener(new View.OnTouchListener() { // from class: com.nx.assist.log.standout.ui.Window.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ConsoleWindow consoleWindow = Window.this.mContext;
                Window window = Window.this;
                return consoleWindow.onTouchHandleResize(window.f86id, window, view, motionEvent);
            }
        });
        if (ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_DECORATION_MAXIMIZE_DISABLE)) {
            viewFindViewById.setVisibility(8);
        }
        if (ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_DECORATION_MOVE_DISABLE)) {
            viewFindViewById2.setOnTouchListener(null);
        }
        if (ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_DECORATION_RESIZE_DISABLE)) {
            viewFindViewById3.setVisibility(8);
        }
        return viewInflate;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.mContext.onKeyEvent(this.f86id, this, keyEvent)) {
            if (keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4) {
                return super.dispatchKeyEvent(keyEvent);
            }
            this.mContext.unfocus(this);
            return true;
        }
        Log.d(TAG, IL1Iii.IL1Iii(new byte[]{103, 89, 90, 82, 9, 79, 16}, IL1Iii.IL1Iii(new byte[]{9, 9, 7, 15, 83, 1}, IL1Iii.IL1Iii(new byte[]{12, 1, 1, 95, 87, 95}, "582fbf"))) + this.f86id + IL1Iii.IL1Iii(new byte[]{17, 10, 7, 24, 16, 3, 71, 4, 12, 21, 16}, IL1Iii.IL1Iii(new byte[]{7, 3, 86, 87, 6, 84}, IL1Iii.IL1Iii(new byte[]{5, 87, 86, 0, 14, 4}, "35b686"))) + keyEvent + IL1Iii.IL1Iii(new byte[]{70, 87, 86, 92, 86, 7, 10, 88, 82, 86, 21, 0, 31, 20, 94, 95, 69, 14, 3, 89, 82, 92, 65, 3, 18, 93, 88, 92, 27}, IL1Iii.IL1Iii(new byte[]{95, 5, 2, 0, 1, 6}, IL1Iii.IL1Iii(new byte[]{0, 2, 12, 80, 80, 83}, "939bd7"))));
        return false;
    }

    public Editor edit() {
        return new Editor();
    }

    public void fixCompatibility(View view) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        while (true) {
            View view2 = (View) linkedList.poll();
            if (view2 == null) {
                return;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    linkedList.add(viewGroup.getChildAt(i));
                }
            }
        }
    }

    public Point getDisplaySize() {
        return lIlii.m1123IIi(this.mContext.getContext());
    }

    public boolean onFocus(boolean z) {
        if (ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_WINDOW_FOCUSABLE_DISABLE) || z == this.focused) {
            return false;
        }
        this.focused = z;
        if (this.mContext.onFocusChange(this.f86id, this, z)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(IL1Iii.IL1Iii(new byte[]{111, 8, 8, 84, 9, 22, 24}, IL1Iii.IL1Iii(new byte[]{91, 2, 84, 8, 94, 87}, IL1Iii.IL1Iii(new byte[]{80, 6, 4, 9, 89, 82}, "3e61ad"))));
            sb.append(this.f86id);
            sb.append(IL1Iii.IL1Iii(new byte[]{67, 7, 12, 1, 20, 75, 67, 2, 11, 3, 15, 95, 6, 65}, IL1Iii.IL1Iii(new byte[]{91, 85, 91, 90, 85, 11}, IL1Iii.IL1Iii(new byte[]{12, 82, 14, 15, 7, 6}, "4f6735"))));
            sb.append(z ? IL1Iii.IL1Iii(new byte[]{29, 77, 16, 65, 92, 29}, IL1Iii.IL1Iii(new byte[]{86, 1, 80, 1, 95, 82}, IL1Iii.IL1Iii(new byte[]{2, 90, 4, 81, 87, 84}, "ab6d12"))) : IL1Iii.IL1Iii(new byte[]{74, 85, 7, 84, 18, 82, 75}, IL1Iii.IL1Iii(new byte[]{82, 1, 4, 90, 4, 1}, IL1Iii.IL1Iii(new byte[]{8, 86, 4, 87, 81, 15}, "8df549"))));
            sb.append(IL1Iii.IL1Iii(new byte[]{66, 2, 86, 92, 85, 1, 14, 13, 82, 86, 22, 6, 27, 65, 94, 95, 70, 8, 7, 12, 82, 92, 66, 5, 22, 8, 88, 92, 24}, IL1Iii.IL1Iii(new byte[]{91, 84, 5, 3, 15, 80}, IL1Iii.IL1Iii(new byte[]{1, 6, 2, 5, 8, 6}, "830412"))));
            Log.d(str, sb.toString());
            this.focused = !z;
            return false;
        }
        if (!ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_WINDOW_FOCUS_INDICATOR_DISABLE)) {
            View viewFindViewById = findViewById(R.id.content);
            if (z || ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_DECORATION_SYSTEM)) {
                viewFindViewById.setBackgroundResource(android.R.color.holo_green_dark);
            } else {
                viewFindViewById.setBackgroundResource(0);
            }
        }
        ConsoleWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        layoutParams.setFocusFlag(z);
        this.mContext.updateViewLayout(this.f86id, layoutParams);
        if (z) {
            this.mContext.setFocusedWindow(this);
        } else if (this.mContext.getFocusedWindow() == this) {
            this.mContext.setFocusedWindow(null);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ConsoleWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        if (motionEvent.getAction() == 0 && this.mContext.getFocusedWindow() != this) {
            this.mContext.focus(this.f86id);
        }
        if (motionEvent.getPointerCount() < 2 || !ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_WINDOW_PINCH_RESIZE_ENABLE) || (motionEvent.getAction() & 255) != 5) {
            return false;
        }
        TouchInfo touchInfo = this.touchInfo;
        touchInfo.scale = 1.0d;
        touchInfo.dist = -1.0d;
        touchInfo.firstWidth = ((WindowManager.LayoutParams) layoutParams).width;
        touchInfo.firstHeight = ((WindowManager.LayoutParams) layoutParams).height;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            if (this.mContext.getFocusedWindow() == this) {
                this.mContext.unfocus(this);
            }
            this.mContext.onTouchBody(this.f86id, this, this, motionEvent);
        }
        if (motionEvent.getPointerCount() >= 2 && ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_WINDOW_PINCH_RESIZE_ENABLE)) {
            double dSqrt = Math.sqrt(Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
            if ((motionEvent.getAction() & 255) == 2) {
                TouchInfo touchInfo = this.touchInfo;
                if (touchInfo.dist == -1.0d) {
                    touchInfo.dist = dSqrt;
                }
                touchInfo.scale *= dSqrt / touchInfo.dist;
                touchInfo.dist = dSqrt;
                Editor anchorPoint = edit().setAnchorPoint(0.5f, 0.5f);
                TouchInfo touchInfo2 = this.touchInfo;
                double d = touchInfo2.firstWidth;
                double d2 = touchInfo2.scale;
                anchorPoint.setSize((int) (d * d2), (int) (touchInfo2.firstHeight * d2)).commit();
            }
            this.mContext.onResize(this.f86id, this, this, motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ConsoleWindow.StandOutLayoutParams) {
            super.setLayoutParams(layoutParams);
            return;
        }
        throw new IllegalArgumentException(TAG + this.f86id + IL1Iii.IL1Iii(new byte[]{94, 68, 124, 3, 28, 10, 17, 16, 96, 3, 23, 4, 9, 23, 16, 15, 16, 22, 16, 68, 82, 7, 69, 4, 10, 68, 89, 12, 22, 17, 5, 10, 83, 7, 69, 10, 2, 68, 99, 22, 4, 11, 0, 43, 69, 22, 41, 4, 29, 11, 69, 22, 53, 4, 22, 5, 93, 17, 75}, IL1Iii.IL1Iii(new byte[]{5, 84, 7, 6, 92, 93}, IL1Iii.IL1Iii(new byte[]{5, 0, 3, 82, 15, 1}, "d04669"))));
    }

    public void setXY(int i, int i2, int i3, int i4) {
        ConsoleWindow.StandOutLayoutParams layoutParams = getLayoutParams();
        this.data.putBoolean(IL1Iii.IL1Iii(new byte[]{90, 18, 127, 85, 75, 13, 94, 8, 72, 81, 87}, IL1Iii.IL1Iii(new byte[]{82, 7, 86, 82, 80, 92}, IL1Iii.IL1Iii(new byte[]{83, 3, 83, 82, 87, 93}, "2e744e"))), true);
        this.data.putInt(IL1Iii.IL1Iii(new byte[]{67, 89, 7, 71, 90, 123, 81, 86, 12, 65, 87, 116, 85, 72, 10, 94, 91, 67, 81}, IL1Iii.IL1Iii(new byte[]{0, 5, 7, 85, 1, 91}, IL1Iii.IL1Iii(new byte[]{12, 5, 1, 86, 81, 3}, "80e0ba"))), ((WindowManager.LayoutParams) layoutParams).width);
        this.data.putInt(IL1Iii.IL1Iii(new byte[]{89, 92, 12, 82, 9, 69, 115, 92, 3, 90, 19, 84, 124, 88, 29, 92, 12, 88, 75, 92}, IL1Iii.IL1Iii(new byte[]{82, 14, 4, 84, 85, 4}, IL1Iii.IL1Iii(new byte[]{91, 84, 4, 86, 5, 5}, "8ce710"))), ((WindowManager.LayoutParams) layoutParams).height);
        this.data.putInt(IL1Iii.IL1Iii(new byte[]{78, 32, 80, 81, 94, 20, 83, 47, 84, 79, 88, 11, 95, 24, 80}, IL1Iii.IL1Iii(new byte[]{87, 6, 2, 85, 7, 87}, IL1Iii.IL1Iii(new byte[]{80, 6, 86, 81, 84, 9}, "1ba3b8"))), ((WindowManager.LayoutParams) layoutParams).x);
        this.data.putInt(IL1Iii.IL1Iii(new byte[]{29, 116, 81, 82, 9, 67, 1, 123, 85, 76, 15, 92, 13, 76, 81}, IL1Iii.IL1Iii(new byte[]{0, 80, 87, 5, 86, 1}, IL1Iii.IL1Iii(new byte[]{87, 80, 90, 87, 9, 8}, "369f98"))), ((WindowManager.LayoutParams) layoutParams).y);
        if (i3 <= 0 || i4 <= 0) {
            edit().setPosition(i, i2).commit();
        } else {
            edit().setSize(i3, i4).setPosition(i, i2).commit();
        }
    }

    @Override // android.view.View
    public ConsoleWindow.StandOutLayoutParams getLayoutParams() {
        ConsoleWindow.StandOutLayoutParams standOutLayoutParams = (ConsoleWindow.StandOutLayoutParams) super.getLayoutParams();
        return standOutLayoutParams == null ? this.originalParams : standOutLayoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.widget.FrameLayout, com.nx.assist.log.standout.ui.Window] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.nx.assist.log.standout.ConsoleWindow] */
    public Window(final ConsoleWindow consoleWindow, final int i) {
        View frameLayout;
        ?? r1;
        super(consoleWindow.getContext());
        this.mContext = consoleWindow;
        this.mLayoutInflater = LayoutInflater.from(getContext());
        this.f86id = i;
        this.originalParams = consoleWindow.getParams(i, this);
        this.flags = consoleWindow.getFlags(i);
        TouchInfo touchInfo = new TouchInfo();
        this.touchInfo = touchInfo;
        ConsoleWindow.StandOutLayoutParams standOutLayoutParams = this.originalParams;
        touchInfo.ratio = ((WindowManager.LayoutParams) standOutLayoutParams).width / ((WindowManager.LayoutParams) standOutLayoutParams).height;
        this.data = new Bundle();
        if (ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_DECORATION_SYSTEM)) {
            frameLayout = getSystemDecorations();
            r1 = (FrameLayout) frameLayout.findViewById(R.id.body);
        } else {
            frameLayout = new FrameLayout(consoleWindow.getContext());
            frameLayout.setId(R.id.content);
            r1 = frameLayout;
        }
        addView(frameLayout);
        r1.setOnTouchListener(new View.OnTouchListener() { // from class: com.nx.assist.log.standout.ui.Window.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return consoleWindow.onTouchBody(i, Window.this, view, motionEvent) || (consoleWindow.onTouchHandleMove(i, Window.this, view, motionEvent));
            }
        });
        consoleWindow.createAndAttachView(i, r1);
        if (r1.getChildCount() != 0) {
            if (!ConsoleWindow.isSet(this.flags, StandOutFlags.FLAG_FIX_COMPATIBILITY_ALL_DISABLE)) {
                fixCompatibility(r1);
            }
            setTag(r1.getTag());
            return;
        }
        throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{109, 92, 68, 18, 90, 70, 71, 71, 17, 83, 67, 71, 85, 80, 89, 18, 78, 92, 65, 65, 17, 68, 94, 86, 67, 19, 69, 93, 23, 71, 92, 86, 17, 85, 94, 69, 81, 93, 17, 84, 69, 82, 89, 86, 17, 91, 89, 19, 87, 65, 84, 83, 67, 86, 117, 93, 85, 115, 67, 71, 85, 80, 89, 100, 94, 86, 67, 27, 24}, IL1Iii.IL1Iii(new byte[]{81, 3, 80, 87, 15, 7}, IL1Iii.IL1Iii(new byte[]{0, 9, 86, 93, 93, 0}, "e978e4"))));
    }
}
