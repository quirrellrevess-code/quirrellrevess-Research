package com.google.android.material.bottomnavigation;

import ILil.ILil.p024llL1ii.ILL.C0629il;
import ILil.ILil.p024llL1ii.ILL.IiL;
import ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl;
import ILil.ILil.p024llL1ii.ILL.Lil;
import ILil.ILil.p024llL1ii.ILL.iIi1;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationPresenter implements InterfaceC0628ILl {

    /* JADX INFO: renamed from: id */
    private int f69id;
    private IiL menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public ParcelableSparseArray badgeSavedStates;
        public int selectedItemId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean collapseItemActionView(IiL iiL, C0629il c0629il) {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean expandItemActionView(IiL iiL, C0629il c0629il) {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean flagActionItems() {
        return false;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public int getId() {
        return this.f69id;
    }

    public Lil getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void initForMenu(Context context, IiL iiL) {
        this.menu = iiL;
        this.menuView.initialize(iiL);
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onCloseMenu(IiL iiL, boolean z) {
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public boolean onSubMenuSelected(iIi1 iii1) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void setCallback(InterfaceC0628ILl.IL1Iii iL1Iii) {
    }

    public void setId(int i) {
        this.f69id = i;
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    @Override // ILil.ILil.p024llL1ii.ILL.InterfaceC0628ILl
    public void updateMenuView(boolean z) {
        if (this.updateSuspended) {
            return;
        }
        if (z) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }
}
