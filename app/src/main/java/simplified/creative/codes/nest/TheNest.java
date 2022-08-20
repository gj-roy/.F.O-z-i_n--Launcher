package simplified.creative.codes.nest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.*;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import simplified.creative.codes.nest.Tools.*;

import java.io.*;
import java.text.Collator;
import java.util.*;

import static android.view.View.OnTouchListener;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class TheNest extends Activity implements ListTypeA.AdapterCallback,
        GridTypeA.AdapterCallback, ListTypeB.AdapterCallback, ListTypeC.AdapterCallback,
        ListTypeD.AdapterCallback, ListTypeE.AdapterCallback, ListTypeF.AdapterCallback,
        ListTypeG.AdapterCallback, ListTypeH.AdapterCallback {

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    RelativeLayout theNestRootLayout;
    LayoutInflater inflater;

    View theNestHomeView;
    RelativeLayout theNestHomeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_nest_root_layout);
        inflater = LayoutInflater.from(TheNest.this);

        theNestRootLayout = (RelativeLayout) findViewById(R.id.the_nest_root_layout);
        setSize(this, theNestRootLayout, size(2), size(2));

        fozinConfigurations();

        if(theNestHomeView == null){
            theNestHomeView = inflater.inflate(R.layout.the_nest_home_layout, null);
            theNestHomeLayout = theNestHomeView.findViewById(R.id.the_nest_home_layout);
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) == null) {
            theNestRootLayout.addView(theNestHomeView);
            layoutParamsTypeA(this, theNestHomeLayout, new int[]{direction(2)});
            setSize(this, theNestHomeLayout, size(2), size(2));

            homeConfigurations();
            homeEDGE();
            homeWIDGET();
            homeAPPLET(1);
            homeTOOLTIP();
            homeWALLPAPER();
            homeFolder_Flower();
            homeStatus();
            homeCenterPositions();
            homeDRAWER();
            homeSHORTCUT();

            homeScreenState = 1;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        homeScreenSTATE_A();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) != null) {
            homeScreenSTATE_B();
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_drawer_layout) != null) {
            drawerTooltipSTOPPED();
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_settings_layout) != null) {
            settingsTooltipSTOPPED();
        }

        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) == null) {
            theNestRootLayout.removeView(theNestSettingsView);
            theNestRootLayout.removeView(theNestDrawerView);
            theNestRootLayout.addView(theNestHomeView);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) != null) {
            homeAppletRESUMED();
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_drawer_layout) != null) {
            drawerAppletRESUMED();
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_settings_layout) != null) {

        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) != null) {
            homeScreenSTATE_A();
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_drawer_layout) != null) {

        }
        if(theNestRootLayout.findViewById(R.id.the_nest_settings_layout) != null) {

        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if(theNestRootLayout.findViewById(R.id.the_nest_home_layout) != null) {
            if(homeAppletLayout.findViewById(R.id.home_applet_a) == null){
                homeAPPLET(1);
            }
        }

        if(theNestRootLayout.findViewById(R.id.the_nest_drawer_layout) != null) {
            theNestRootLayout.addView(theNestHomeView);
            theNestRootLayout.removeView(theNestDrawerView);
            homeScreenSTATE_A();
        }

        if(theNestRootLayout.findViewById(R.id.the_nest_settings_layout) != null) {
            theNestRootLayout.addView(theNestHomeView);
            theNestRootLayout.removeView(theNestSettingsView);
            homeScreenSTATE_A();
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private static String statusBar;
    private static String navigationBar;
    public static int background;
    public static int tintA;
    public static int tintB;
    public static int ui;
    public static String fontAMode;
    public static int fontAStyle;
    public static int fontBStyle;
    @SuppressLint("ClickableViewAccessibility")
    private void fozinConfigurations(){
        if(!fileExist(TheNest.this, "Fozin/Configurations")){
            create(TheNest.this, "Fozin","/Configurations", "# Fozin Configurations...");
            create(TheNest.this, "Fozin","/Configurations", "Status Bar - Enabled");
            create(TheNest.this, "Fozin","/Configurations", "Navigation Bar - Enabled");
            create(TheNest.this, "Fozin","/Configurations", "Background - " + R.color.origin);
            create(TheNest.this, "Fozin","/Configurations", "UI - " + R.color.orange_3);
            create(TheNest.this, "Fozin","/Configurations", "Tint A - " + R.color.white);
            create(TheNest.this, "Fozin","/Configurations", "Tint B - " + R.color.black);
            create(TheNest.this, "Fozin","/Configurations", "Font A Mode - SimpliC");
            create(TheNest.this, "Fozin","/Configurations", "Font A Style - " + Typeface.BOLD);
            create(TheNest.this, "Fozin","/Configurations", "Font B Style - " + Typeface.NORMAL);
            create(TheNest.this, "Fozin","/Configurations", " ");
            create(TheNest.this, "Fozin","/Configurations", "--------------------");
            create(TheNest.this, "Fozin","/Configurations", " ");
        }

        List<String> readValues = read(TheNest.this, "Fozin/Configurations");
        statusBar = readValues.get(1).substring(13).trim();
        navigationBar = readValues.get(2).substring(17).trim();
        background = Integer.parseInt(readValues.get(3).substring(12).trim());
        ui = Integer.parseInt(readValues.get(4).substring(4).trim());
        tintA = Integer.parseInt(readValues.get(5).substring(8).trim());
        tintB = Integer.parseInt(readValues.get(6).substring(8).trim());
        fontAMode = readValues.get(7).substring(13).trim();
        fontAStyle = Integer.parseInt(readValues.get(8).substring(14).trim());
        fontBStyle = Integer.parseInt(readValues.get(9).substring(14).trim());

        systemUiBars();
        getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, background));

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            if(!statusBar.equals("Enabled") && !navigationBar.equals("Enabled")){
                theNestRootLayout.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        systemUiBars();
                        return true;
                    }
                });
            } else {
                theNestRootLayout.setOnTouchListener(null);
            }
        }
    }

    private void systemUiBars(){
        if(statusBar.equals("Enabled") && navigationBar.equals("Enabled")){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                getWindow().setDecorFitsSystemWindows(true);
                getWindow().getDecorView().getWindowInsetsController().setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_TOUCH);
                getWindow().getDecorView().getWindowInsetsController().show(WindowInsets.Type.systemBars());
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
        }
        if(statusBar.equals("Enabled") && !navigationBar.equals("Enabled")){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                getWindow().setDecorFitsSystemWindows(true);
                getWindow().getDecorView().getWindowInsetsController().setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                getWindow().getDecorView().getWindowInsetsController().show(WindowInsets.Type.statusBars());
                getWindow().getDecorView().getWindowInsetsController().hide(WindowInsets.Type.navigationBars());
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
        if(!statusBar.equals("Enabled") && navigationBar.equals("Enabled")){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                getWindow().setDecorFitsSystemWindows(true);
                getWindow().getDecorView().getWindowInsetsController().setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                getWindow().getDecorView().getWindowInsetsController().hide(WindowInsets.Type.statusBars());
                getWindow().getDecorView().getWindowInsetsController().show(WindowInsets.Type.navigationBars());
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
        if(!statusBar.equals("Enabled") && !navigationBar.equals("Enabled")){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                getWindow().setDecorFitsSystemWindows(false);
                getWindow().getDecorView().getWindowInsetsController().setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
                getWindow().getDecorView().getWindowInsetsController().hide(WindowInsets.Type.systemBars());
            } else {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void customTouchModeA(View view, int hold, int press){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchStart(view);
                    onTouchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            if(hold == 0){
                                homeWidgetHold();
                            }
                            if(hold == 1){
                                homeWallpaperHold();
                            }
                            if(hold == 2){
                                homeFolderHold();
                            }
                            if(hold == 3){
                                homeStatusHold();
                            }
                            if(hold == 4){
                                homeShortcutHold();
                            }
                            if(hold == 5){

                            }
                            touchVibrate(TheNest.this, view);
                        }
                    };
                    onTouchHandler.postDelayed(onTouchRunnable, 300);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    touchStop(view);
                    if((System.currentTimeMillis() - time) < 200){
                        if(press == 0){

                        }
                        if(press == 1){
                            settingsAboutPress_3();
                        }
                        if(press == 2){
                            settingsAboutPress_4();
                        }
                    }
                }
                touchEnd(event, view);
                return true;
            }
        });
    }

    private void customTouchModeB(View view, String text, int mode, int type, int count){
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchStart(view);
                    onTouchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            if(!text.isEmpty()) {
                                touchTip(TheNest.this, text, mode);
                            }
                            touchVibrate(TheNest.this, view);
                        }
                    };
                    onTouchHandler.postDelayed(onTouchRunnable, 300);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    touchStop(view);
                    if((System.currentTimeMillis() - time) < 200){
                        if(mode == 0){
                            if(type == 0){
                                if(count == 0)
                                    homeWidgetPress_0();
                                if(count == 1)
                                    homeWidgetPress_1();
                                if(count == 2)
                                    homeWidgetPress_2();
                            }
                            if(type == 1){
                                if(count == 0)
                                    homeAppletPress_0();
                                if(count == 1)
                                    homeAppletPress_1();
                                if(count == 2)
                                    homeAppletPress_2();
                                if(count == 3)
                                    homeAppletPress_3();
                                if(count == 4)
                                    homeAppletPress_4();
                                if(count == 5)
                                    homeAppletPress_5();
                                if(count == 6)
                                    homeAppletPress_6();
                                if(count == 7)
                                    homeAppletPress_7();
                            }
                            if(type == 2){
                                if(count == 0)
                                    homeWallpaperPress_0();
                                if(count == 1)
                                    homeWallpaperPress_1();
                            }
                            if(type == 3){
                                if(count == 0)
                                    homeFolderPress_0();
                                if(count == 1)
                                    homeFolderPress_1();
                                if(count == 2)
                                    homeFolderPress_2();
                                if(count == 3)
                                    homeFolderPress_3();
                            }
                            if(type == 4){
                                if(count == 0)
                                    homeStatusPress_0();
                            }
                            if(type == 5){
                                if(count == 0)
                                    homeDrawerPress_0();
                            }
                            if(type == 6){

                            }
                        }
                        if(mode == 1){
                            if(type == 0){
                                if(count == 0)
                                    drawerTilesPress_0();
                            }
                            if(type == 1){
                                if(count == 0)
                                    drawerAppletPress_0();
                                if(count == 1)
                                    drawerAppletPress_1();
                                if(count == 2)
                                    drawerAppletPress_2();
                                if(count == 3)
                                    drawerAppletPress_3();
                                if(count == 4)
                                    drawerAppletPress_4();
                                if(count == 5)
                                    drawerAppletPress_5();
                                if(count == 6)
                                    drawerAppletPress_6();
                                if(count == 7)
                                    drawerAppletPress_7();
                                if(count == 8)
                                    drawerAppletPress_8();
                            }
                        }
                        if(mode == 2){
                            if(type == 0){
                                if(count == 0)
                                    settingsButtonsPress_0();
                                if(count == 1)
                                    settingsButtonsPress_1();
                                if(count == 2)
                                    settingsButtonsPress_2();
                                if(count == 3)
                                    settingsButtonsPress_3();
                            }
                            if(type == 1){
                                if(count == 0)
                                    settingsAboutPress_0();
                                if(count == 1)
                                    settingsAboutPress_1();
                                if(count == 2)
                                    settingsAboutPress_2();
                                if(count == 3)
                                    settingsAboutPress_3();
                                if(count == 4)
                                    settingsAboutPress_4();
                            }
                            if(type == 2){
                                if(count == 0)
                                    settingsMiscPress_0();
                                if(count == 1)
                                    settingsMiscPress_1();
                                if(count == 2)
                                    settingsMiscPress_2();
                                if(count == 3)
                                    settingsMiscPress_3();
                                if(count == 4)
                                    settingsMiscPress_4();
                                if(count == 5)
                                    settingsMiscPress_5();
                                if(count == 6)
                                    settingsMiscPress_6();
                                if(count == 7)
                                    settingsMiscPress_7();
                                if(count == 8)
                                    settingsMiscPress_8();
                                if(count == 9)
                                    settingsMiscPress_9();
                                if(count == 10)
                                    settingsMiscPress_10();
                                if(count == 11)
                                    settingsMiscPress_11();
                                if(count == 12)
                                    settingsMiscPress_12();
                                if(count == 13)
                                    settingsMiscPress_13();
                                if(count == 14)
                                    settingsMiscPress_14();
                                if(count == 15)
                                    settingsMiscPress_15();
                                if(count == 16)
                                    settingsMiscPress_16();
                                if(count == 17)
                                    settingsMiscPress_17();
                                if(count == 18)
                                    settingsMiscPress_18();
                                if(count == 19)
                                    settingsMiscPress_19();
                                if(count == 20)
                                    settingsMiscPress_20();
                                if(count == 21)
                                    settingsMiscPress_21();
                                if(count == 22)
                                    settingsMiscPress_22();
                            }
                            if(type == 3) {
                                if (count == 0)
                                    settingsDrawerPress_0();
                                if (count == 1)
                                    settingsDrawerPress_1();
                                if (count == 2)
                                    settingsDrawerPress_2();
                                if (count == 3)
                                    settingsDrawerPress_3();
                                if (count == 4)
                                    settingsDrawerPress_4();
                                if (count == 5)
                                    settingsDrawerPress_5();
                                if (count == 6)
                                    settingsDrawerPress_6();
                                if (count == 7)
                                    settingsDrawerPress_7();
                            }
                            if(type == 4) {
                                if (count == 0)
                                    settingsHomePress_0();
                                if (count == 1)
                                    settingsHomePress_1();
                                if (count == 2)
                                    settingsHomePress_2();
                                if (count == 3)
                                    settingsHomePress_3();
                                if (count == 4)
                                    settingsHomePress_4();
                                if (count == 5)
                                    settingsHomePress_5();
                                if (count == 6)
                                    settingsHomePress_6();
                                if (count == 7)
                                    settingsHomePress_7();
                                if (count == 8)
                                    settingsHomePress_8();
                                if (count == 9)
                                    settingsHomePress_9();
                                if (count == 10)
                                    settingsHomePress_10();
                                if (count == 11)
                                    settingsHomePress_11();
                                if (count == 12)
                                    settingsHomePress_12();
                                if (count == 13)
                                    settingsHomePress_13();
                                if (count == 14)
                                    settingsHomePress_14();
                                if (count == 15)
                                    settingsHomePress_15();
                                if (count == 16)
                                    settingsHomePress_16();
                                if (count == 17)
                                    settingsHomePress_17();
                                if (count == 18)
                                    settingsHomePress_18();
                                if (count == 19)
                                    settingsHomePress_19();
                                if (count == 20)
                                    settingsHomePress_20();
                                if (count == 21)
                                    settingsHomePress_21();
                                if (count == 22)
                                    settingsHomePress_22();
                                if (count == 23)
                                    settingsHomePress_23();
                                if (count == 24)
                                    settingsHomePress_24();
                                if (count == 25)
                                    settingsHomePress_25();
                                if (count == 26)
                                    settingsHomePress_26();
                                if (count == 27)
                                    settingsHomePress_27();
                                if (count == 28)
                                    settingsHomePress_28();
                                if (count == 29)
                                    settingsHomePress_29();
                                if (count == 30)
                                    settingsHomePress_30();
                                if (count == 31)
                                    settingsHomePress_31();
                                if (count == 32)
                                    settingsHomePress_32();
                                if (count == 33)
                                    settingsHomePress_33();
                                if (count == 34)
                                    settingsHomePress_34();
                                if (count == 35)
                                    settingsHomePress_35();
                                if (count == 36)
                                    settingsHomePress_36();
                            }
                        }
                    }
                }
                touchEnd(event, view);
                return true;
            }
        });
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private String widgetState;
    private String widgetMode;
    private String widgetComponent;
    private int widgetID;
    private String widgetStyle;

    private String appletText;

    private String wallpaperState;
    private String wallpaperMode;
    private String wallpaperComponent;
    private String wallpaperStyle;

    private String folderState;
    private String folderName;
    private String folderSortingOrder;

    private String statusState;
    private String statusMode;

    private String drawerMode;
    private String drawerIcon;
    private float drawerAlpha;
    private String drawerSize;

    private String shortcutState;

    private void homeConfigurations(){
        if(!fileExist(this, "Home/Configurations")){
            create(this, "Home","/Configurations", "# Home Screen Widget Configurations...");
            create(this, "Home","/Configurations", "Widget State - Enabled");
            create(this, "Home","/Configurations", "Widget Mode - [ NONE ]");
            create(this, "Home","/Configurations", "Widget Component - [ NONE ]");
            create(this, "Home","/Configurations", "Widget ID - 0");
            create(this, "Home","/Configurations", "Widget Style - A");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Applet Configurations...");
            create(this, "Home","/Configurations", "Applet Text - ∆×••⟨[ ]⟩");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Wallpaper Configurations...");
            create(this, "Home","/Configurations", "Wallpaper State - Enabled");
            create(this, "Home","/Configurations", "Wallpaper Mode - [ NONE ]");
            create(this, "Home","/Configurations", "Wallpaper Component - [ NONE ]");
            create(this, "Home","/Configurations", "Wallpaper Style - A");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Folder Configurations...");
            create(this, "Home","/Configurations", "Folder State - Enabled");
            create(this, "Home","/Configurations", "Folder Name - Folder");
            create(this, "Home","/Configurations", "Folder Sorting Order - Alphabetically");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Status Configurations...");
            create(this, "Home","/Configurations", "Status State - Enabled");
            create(this, "Home","/Configurations", "Status Mode - [ NONE ]");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Drawer Configurations...");
            create(this, "Home","/Configurations", "Drawer Mode - Icon");
            create(this, "Home","/Configurations", "Drawer Icon - BeeHive");
            create(this, "Home","/Configurations", "Drawer Size - C");
            create(this, "Home","/Configurations", "Drawer Alpha - 1.0f");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "# Home Screen Shortcut Configurations...");
            create(this, "Home","/Configurations", "Shortcut State - Enabled");
            create(this, "Home","/Configurations", " ");
            create(this, "Home","/Configurations", "--------------------");
            create(this, "Home","/Configurations", " ");
        }

        List<String> readValues = read(this, "Home/Configurations");
        widgetState = readValues.get(1).substring(15).trim();
        widgetMode = readValues.get(2).substring(14).trim();
        widgetComponent = readValues.get(3).substring(19).trim();
        widgetID = Integer.parseInt(readValues.get(4).substring(12).trim());
        widgetStyle = readValues.get(5).substring(15).trim();

        appletText = readValues.get(10).substring(14).trim();

        wallpaperState = readValues.get(15).substring(17).trim();
        wallpaperMode = readValues.get(16).substring(17).trim();
        wallpaperComponent = readValues.get(17).substring(22).trim();
        wallpaperStyle = readValues.get(18).substring(18).trim();

        folderState = readValues.get(23).substring(15).trim();
        folderName = readValues.get(24).substring(14).trim();
        folderSortingOrder = readValues.get(25).substring(23).trim();

        statusState = readValues.get(30).substring(15).trim();
        statusMode = readValues.get(31).substring(14).trim();

        drawerMode = readValues.get(36).substring(14).trim();
        drawerIcon = readValues.get(37).substring(14).trim();
        drawerSize = readValues.get(38).substring(14).trim();
        drawerAlpha = Float.parseFloat(readValues.get(39).substring(15).trim());

        shortcutState = readValues.get(44).substring(17).trim();
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private int homeScreenState;
    private void homeScreenSTATE_A(){
        if(homeScreenState == 0){
            homeScreenState = 1;
            if(widgetState.equals("Enabled") && widgetMode.equals("Device")){
                if(settingsHomeBBoolean) {
                    homeWidgetEnable();
                    settingsHomeBBoolean = false;
                } else {
                    if(homeWidgetLayout.findViewById(R.id.home_widget_e) == null){
                        if(homeWidgetHost != null)
                            homeWidgetHost.startListening();
                    }
                }
            }
            if(homeAppletInt == 2){
                if(!isAppInstalled(this, homeAppletBString)){
                    homeAPPLET(1);
                }
            }
            if(homeAppletInt == 4){
                if(homeAppletDInt == 1){
                    if(widgetState.equals("Disabled") || widgetMode.equals("[ NONE ]")){
                        homeAPPLET(1);
                    }
                }
                if(homeAppletDInt == 2){
                    if(wallpaperState.equals("Disabled") || widgetMode.equals("[ NONE ]")){
                        homeAPPLET(1);
                    }
                }
            }
            if(wallpaperState.equals("Enabled") && wallpaperMode.equals("Device")){
                homeWallpaperDevice();
            }
            if(folderState.equals("Enabled") && theNestHomeLayout.findViewById(R.id.home_folder_b) != null){
                homeFolder_Root();
            }
            if(statusState.equals("Enabled") && statusMode.equals("Battery")){
                if(homeStatusReceiver_1 != null && homeStatusIntent_1 != null){
                    unregisterReceiver(homeStatusReceiver_1);
                    unregisterReceiver(homeStatusReceiver_2);
                    registerReceiver(homeStatusReceiver_1, homeStatusIntent_1);
                    registerReceiver(homeStatusReceiver_2, homeStatusIntent_2);
                }
            }
            if(shortcutState.equals("Enabled") && theNestHomeLayout.findViewById(R.id.home_shortcut_b) != null){
                homeShortcutContents();
            }
        }
    }

    private void homeScreenSTATE_B(){
        homeScreenState = 0;
        if(widgetState.equals("Enabled") && widgetMode.equals("Device")){
            if(homeWidgetHost != null)
                homeWidgetHost.stopListening();
        }
        try {
            homeTooltipStateA(homeTooltipLayout.getContext());
            homeTooltipHandler.removeCallbacks(homeTooltipRunnable);
        } catch (Exception e){}
        if(statusState.equals("Enabled") && statusMode.equals("Battery")){
            if(homeStatusReceiver_1 != null){
                unregisterReceiver(homeStatusReceiver_1);
                unregisterReceiver(homeStatusReceiver_2);
            }
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeEDGE(){
        homeEdgeAView();
        homeEdgeBView();
        homeEdgeCView();
    }

    View homeEdgeAView;
    RelativeLayout homeEdgeALayout;
    TextView homeEdgeAText1, homeEdgeAText2;
    private void homeEdgeAView(){
        if(homeEdgeAView == null){
            homeEdgeAView = inflater.inflate(R.layout.home_edge_a, null);
            homeEdgeALayout = homeEdgeAView.findViewById(R.id.home_edge_a);
            homeEdgeAText1 = homeEdgeAView.findViewById(R.id.home_edge_a_text_1);
            homeEdgeAText2 = homeEdgeAView.findViewById(R.id.home_edge_a_text_2);

            textType(this, homeEdgeAText1, textA(13), tintA, Typeface.BOLD);
            textType(this, homeEdgeAText2, textA(13), tintA, Typeface.BOLD);
        }
        if(theNestHomeLayout.findViewById(R.id.home_edge_a) == null){
            theNestHomeLayout.addView(homeEdgeAView);

            layoutParamsTypeA(this, homeEdgeALayout, new int[]{direction(3), direction(5)});
            setSize(this, homeEdgeALayout, size(1), size(1));
            setMargins(this, homeEdgeALayout, 0, 0, 0, 0);

        }
    }

    View homeEdgeBView;
    RelativeLayout homeEdgeBLayout;
    TextView homeEdgeBText1, homeEdgeBText2;
    private void homeEdgeBView(){
        if(homeEdgeBView == null){
            homeEdgeBView = inflater.inflate(R.layout.home_edge_b, null);
            homeEdgeBLayout = homeEdgeBView.findViewById(R.id.home_edge_b);
            homeEdgeBText1 = homeEdgeBView.findViewById(R.id.home_edge_b_text_1);
            homeEdgeBText2 = homeEdgeBView.findViewById(R.id.home_edge_b_text_2);

            textType(this, homeEdgeBText1, textA(13), tintA, Typeface.BOLD);
            textType(this, homeEdgeBText2, textA(13), tintA, Typeface.BOLD);
        }
        if(theNestHomeLayout.findViewById(R.id.home_edge_b) == null){
            theNestHomeLayout.addView(homeEdgeBView);

            layoutParamsTypeA(this, homeEdgeBLayout, new int[]{direction(3), direction(6)});
            setSize(this, homeEdgeBLayout, size(1), size(1));
            setMargins(this, homeEdgeBLayout, 0, 0, 0, 10);

        }
    }

    View homeEdgeCView;
    RelativeLayout homeEdgeCLayout;
    TextView homeEdgeCText1, homeEdgeCText2, homeEdgeCText3;
    private void homeEdgeCView(){
        if(homeEdgeCView == null){
            homeEdgeCView = inflater.inflate(R.layout.home_edge_c, null);
            homeEdgeCLayout = homeEdgeCView.findViewById(R.id.home_edge_c);
            homeEdgeCText1 = homeEdgeCView.findViewById(R.id.home_edge_c_text_1);
            homeEdgeCText2 = homeEdgeCView.findViewById(R.id.home_edge_c_text_2);
            homeEdgeCText3 = homeEdgeCView.findViewById(R.id.home_edge_c_text_3);

            textType(this, homeEdgeCText1, textA(13), tintA, Typeface.BOLD);
            textType(this, homeEdgeCText2, textA(13), tintA, Typeface.BOLD);
            textType(this, homeEdgeCText3, textA(13), tintA, Typeface.BOLD);
        }
        if(theNestHomeLayout.findViewById(R.id.home_edge_c) == null){
            theNestHomeLayout.addView(homeEdgeCView);

            layoutParamsTypeA(this, homeEdgeCLayout, new int[]{direction(4), direction(6)});
            setSize(this, homeEdgeCLayout, size(1), size(1));
            setMargins(this, homeEdgeCLayout, 0, 0, 0, 10);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    public void homeWidgetHold(){
        if(theNestHomeLayout.findViewById(R.id.home_applet_c) == null) {
            homeAPPLET(3);
        }
        appletToggle(0);
    }

    private void homeWidgetPress_0(){
        if(homeAppletLayout.findViewById(R.id.home_applet_d) == null){
            homeAPPLET(4);
        }
        homeAppletCurrentTools(1);
    }

    private void homeWidgetPress_1(){
        homeWidgetEFrame.setVisibility(View.GONE);
        homeWidgetEText2.setVisibility(View.VISIBLE);
    }

    private void homeWidgetPress_2(){
        homeWidgetEFrame.setVisibility(View.VISIBLE);
        homeWidgetEText2.setVisibility(View.GONE);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeWIDGET(){
        if(widgetState.equals("Disabled"))
            theNestHomeLayout.removeView(homeWidgetView);

        if(widgetState.equals("Enabled")){
            homeWidgetView();
            homeWidgetLayout.removeAllViews();

            if(widgetMode.equals("[ NONE ]")){
                homeWidgetA();
            } else if(widgetMode.equals("Device")){
                homeWidgetB();
            } else if(widgetMode.equals("SimpliC")){
                if(widgetComponent.equals("Clock 1"))
                    homeWidgetView3();
                if(widgetComponent.equals("Clock 2"))
                    homeWidgetView4();
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWidgetView;
    RelativeLayout homeWidgetLayout;
    private void homeWidgetView(){
        if(homeWidgetView == null){
            homeWidgetView = inflater.inflate(R.layout.home_widget, null);
            homeWidgetLayout = homeWidgetView.findViewById(R.id.home_widget);
        }
        if(theNestHomeLayout.findViewById(R.id.home_widget) == null){
            theNestHomeLayout.addView(homeWidgetView);

            layoutParamsTypeA(this, homeWidgetLayout, new int[]{direction(3), direction(6)});
            setSize(this, homeWidgetLayout, size(1), size(1));
            setMargins(this, homeWidgetLayout, 45, 0, 40, 50);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWidgetAView;
    RelativeLayout homeWidgetALayout;
    TextView homeWidgetAText1, homeWidgetAText2;
    private void homeWidgetA(){
        if(homeWidgetAView == null){
            homeWidgetAView = inflater.inflate(R.layout.home_widget_a, null);
            homeWidgetALayout = homeWidgetAView.findViewById(R.id.home_widget_a);
            homeWidgetAText1 = homeWidgetAView.findViewById(R.id.home_widget_a_text_1);
            homeWidgetAText2 = homeWidgetAView.findViewById(R.id.home_widget_a_text_2);

            backgroundTypeA(this, homeWidgetAView, background(8), tintA, 3);
            textType(this, homeWidgetAText1, textA(0), tintA, Typeface.BOLD);
            textType(this, homeWidgetAText2, textC(0), tintA, fontAStyle);

            customTouchModeA(homeWidgetALayout, 0, 100);
        }
        if(homeWidgetLayout.findViewById(R.id.home_widget_a) == null){
            homeWidgetLayout.addView(homeWidgetAView);
            setSize(this, homeWidgetALayout, size(1), size(1));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWidgetBView;
    RelativeLayout homeWidgetBLayout, homeWidgetResource, homeWidgetBFrame;
    ImageView homeWidgetBIcon;
    private void homeWidgetB(){
        if(homeWidgetBView == null){
            homeWidgetBView = inflater.inflate(R.layout.home_widget_b, null);
            homeWidgetBLayout = homeWidgetBView.findViewById(R.id.home_widget_b);
            homeWidgetResource = homeWidgetBView.findViewById(R.id.home_widget_b_resource);
            homeWidgetBFrame = homeWidgetBView.findViewById(R.id.home_widget_b_frame);
            homeWidgetBIcon = homeWidgetBView.findViewById(R.id.home_widget_b_icon);

            backgroundTypeA(this, homeWidgetBLayout, background(8), tintA, 3);
            backgroundTypeB(this, homeWidgetBFrame, drawable(2), background, 30);

            imageTypeA(this, homeWidgetBIcon, drawable(2), tintA, 30);

            customTouchModeB(homeWidgetBIcon, textC(9), 0, 0, 0);
        }
        if(homeWidgetLayout.findViewById(R.id.home_widget_b) == null){
            homeWidgetLayout.addView(homeWidgetBView);
            homeWidgetEnable();
        }
    }

    private void homeWidgetEnable(){
        if(isAppInstalled(this, widgetComponent)){
            if(homeWidgetManager == null)
                homeWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
            if(homeWidgetHost == null)
                homeWidgetHost = new AppWidgetHost(getApplicationContext(), 2062);
            homeWidgetHost.startListening();
            homeWidgetInfo = homeWidgetManager.getAppWidgetInfo(widgetID);
            if(homeWidgetInfo != null)
                homeWidgetCommon(homeWidgetInfo);
        } else {
            homeWidgetRemove();
        }
    }

    private void homeWidgetCommon(AppWidgetProviderInfo info){
        if(hostView != null && hostView.getChildCount() > 0)
            hostView.removeAllViews();
        if(hostView == null) {
            hostView = homeWidgetHost.createView(getApplicationContext(), widgetID, info);
            hostView.setAppWidget(widgetID, info);
        }
        widgetSize();
        homeWidgetManager.bindAppWidgetIdIfAllowed(widgetID, info.provider);
    }

    private int widgetWidth;
    private int widgetHeight;
    private void widgetSize(){
        if(widgetStyle.equals("A")){
            widgetWidth = 180;
            widgetHeight = 100;
            setSize(this, homeWidgetBView, density(this, widgetWidth), density(this, widgetHeight));
        }
        if(widgetStyle.equals("B")){
            widgetWidth = 0;
            widgetHeight = 100;
            setSize(this, homeWidgetBView, size(2), density(this, widgetHeight));
        }
        if(widgetStyle.equals("C")){
            widgetWidth = 150;
            widgetHeight = 150;
            setSize(this, homeWidgetBView, density(this, widgetWidth), density(this, widgetHeight));
        }
        if(widgetStyle.equals("D")){
            widgetWidth = 0;
            widgetHeight = 150;
            setSize(this, homeWidgetBView, size(2), density(this, widgetHeight));
        }

        if(hostView != null && homeWidgetResource != null){
            int widgetW = 0;
            int widgetH = 0;
            if(homeWidgetInfo != null){
                widgetW = homeWidgetInfo.minWidth;
                widgetH = homeWidgetInfo.minHeight;
            }
            int dimen_a = 0;
            int dimen_b = 0;
            if(widgetStyle.equals("A")){
                dimen_a = widgetW - 100;
                dimen_b = widgetH - 100;
            }
            if(widgetStyle.equals("B")){
                dimen_a = widgetW + 100;
                dimen_b = widgetH + 50;
            }
            if(widgetStyle.equals("C") || widgetStyle.equals("D")){
                dimen_a = widgetW + 100;
                dimen_b = widgetH + 100;
            }

            if((widgetH) > 500){
                homeWidgetLayout.removeView(homeWidgetBView);
                homeWidgetE();
                homeWidgetEIcon.setImageBitmap(roundedBitmap(drawableIcon(this, widgetComponent, 50)));
                homeWidgetEText3.setText(homeWidgetInfo.loadLabel(getPackageManager()));
            } else {
                if(homeWidgetLayout.findViewById(R.id.home_widget_e) != null){
                    homeWidgetLayout.removeView(homeWidgetEView);
                    homeWidgetLayout.addView(homeWidgetBView);
                }
                if(homeWidgetInfo != null && homeWidgetInfo.resizeMode != AppWidgetProviderInfo.RESIZE_NONE)
                    hostView.updateAppWidgetSize(null, widgetW, widgetH, dimen_a, dimen_b);
                homeWidgetResource.removeAllViews();
                homeWidgetResource.addView(hostView);
            }
        }
    }

    AppWidgetManager homeWidgetManager;
    AppWidgetHost homeWidgetHost;
    AppWidgetHostView hostView;
    AppWidgetProviderInfo homeWidgetInfo;
    private void homeWidgetRemove(){
        edit(this, "Home/Configurations", "Widget Mode - " + widgetMode, "Widget Mode - [ NONE ]");
        edit(this, "Home/Configurations", "Widget Component - " + widgetComponent, "Widget Component - [ NONE ]");
        edit(this, "Home/Configurations", "Widget ID - " + widgetID, "Widget ID - 0");
        if(homeWidgetHost != null){
            homeWidgetHost.stopListening();
            homeWidgetHost.deleteAppWidgetId(widgetID);
            homeWidgetHost = null;
        }
        if(hostView != null){
            hostView.removeAllViews();
            hostView = null;
        }
        if(homeWidgetResource != null)
            homeWidgetResource.removeAllViews();
        homeWidgetManager = null;
        homeConfigurations();
        homeWIDGET();
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWidgetView3;
    RelativeLayout homeWidgetC;
    Analog homeWidgetClock;
    TextClock homeWidgetCText1, homeWidgetCText2;
    private void homeWidgetView3(){
        if(homeWidgetView3 == null){
            homeWidgetView3 = inflater.inflate(R.layout.home_widget_c, null);
            homeWidgetC = homeWidgetView3.findViewById(R.id.home_widget_c);
            homeWidgetClock = homeWidgetView3.findViewById(R.id.home_widget_clock);
            homeWidgetCText1 = homeWidgetView3.findViewById(R.id.home_widget_c_text_1);
            homeWidgetCText2 = homeWidgetView3.findViewById(R.id.home_widget_c_text_2);

            backgroundTypeA(this, homeWidgetC, background(8), tintA, 3);

            textType(this, homeWidgetCText1, (String) homeWidgetCText1.getText(), tintA, fontBStyle);
            textType(this, homeWidgetCText2, (String) homeWidgetCText1.getText(), tintA, fontBStyle);

            homeWidgetC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                    startActivity(i);
                }
            });
        }
        if(homeWidgetLayout.findViewById(R.id.home_widget_c) == null){
            homeWidgetLayout.addView(homeWidgetView3);
            setSize(this, homeWidgetC, density(this, 185), density(this, 130));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWidgetView4;
    RelativeLayout homeWidgetD;
    TextView homeWidgetDText4;
    TextClock homeWidgetDText1, homeWidgetDText2, homeWidgetDText3;
    private void homeWidgetView4(){
        if(homeWidgetView4 == null){
            homeWidgetView4 = inflater.inflate(R.layout.home_widget_d, homeWidgetD);
            homeWidgetD = homeWidgetView4.findViewById(R.id.home_widget_d);
            homeWidgetDText1 = homeWidgetView4.findViewById(R.id.home_widget_d_text_1);
            homeWidgetDText2 = homeWidgetView4.findViewById(R.id.home_widget_d_text_2);
            homeWidgetDText3 = homeWidgetView4.findViewById(R.id.home_widget_d_text_3);
            homeWidgetDText4 = homeWidgetView4.findViewById(R.id.home_widget_d_text_4);

            backgroundTypeA(this, homeWidgetD, background(8), tintA, 3);

            textType(this, homeWidgetDText1, (String) homeWidgetDText1.getText(), tintA, fontBStyle);
            textType(this, homeWidgetDText2, (String) homeWidgetDText3.getText(), tintA, fontBStyle);
            textType(this, homeWidgetDText3, (String) homeWidgetDText3.getText(), tintA, fontBStyle);

            homeWidgetD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                    startActivity(i);
                }
            });
        }
        if(homeWidgetLayout.findViewById(R.id.home_widget_d) == null){
            homeWidgetLayout.addView(homeWidgetView4);
            setSize(this, homeWidgetD, density(this, 170), density(this, 130));
        }
        clock_B();
    }

    private void clock_B(){
        Calendar c = Calendar.getInstance();
        if(c.get(Calendar.AM_PM) == Calendar.AM){
            if(c.get(Calendar.HOUR) <= 6){
                textType(this, homeWidgetDText4, textB(0), tintA, fontBStyle);
            } else {
                textType(this, homeWidgetDText4, textB(1), tintA, fontBStyle);
            }
        } else {
            if(c.get(Calendar.HOUR) < 6){
                textType(this, homeWidgetDText4, textB(2), tintA, fontBStyle);
            } else {
                textType(this, homeWidgetDText4, textB(3), tintA, fontBStyle);
            }
        }
    }


    View homeWidgetEView;
    RelativeLayout homeWidgetELayout, homeWidgetEFrame;
    TextView homeWidgetEText1, homeWidgetEText2, homeWidgetEText3;
    ImageView homeWidgetEIcon;
    private void homeWidgetE(){
        if(homeWidgetEView == null){
            homeWidgetEView = inflater.inflate(R.layout.home_widget_e, null);
            homeWidgetELayout = homeWidgetEView.findViewById(R.id.home_widget_e);
            homeWidgetEFrame = homeWidgetEView.findViewById(R.id.home_widget_e_frame);
            homeWidgetEIcon = homeWidgetEView.findViewById(R.id.home_widget_e_icon);
            homeWidgetEText1 = homeWidgetEView.findViewById(R.id.home_widget_e_text_1);
            homeWidgetEText2 = homeWidgetEView.findViewById(R.id.home_widget_e_text_2);
            homeWidgetEText3 = homeWidgetEView.findViewById(R.id.home_widget_e_text_3);

            backgroundTypeA(this, homeWidgetELayout, background(8), tintA, 3);

            textType(this, homeWidgetEText1, textC(67), tintA, fontAStyle);
            textType(this, homeWidgetEText2, textB(61), tintA, fontBStyle);
            textType(this, homeWidgetEText3, "", tintA, fontBStyle);
            homeWidgetEText2.setVisibility(View.GONE);

            customTouchModeB(homeWidgetEFrame, "", 0, 0, 1);
            customTouchModeB(homeWidgetEText2, "", 0, 0, 2);
        }
        if(homeWidgetLayout.findViewById(R.id.home_widget_e) == null){
            homeWidgetLayout.addView(homeWidgetEView);
        }
    }
    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private int homeAppletInt;
    private void homeAPPLET(int mode){
        homeAppletView0();
        homeAppletLayout.removeAllViews();
        if(mode == 1){
            homeAppletView1();
        }
        if(mode == 2){
            homeAppletView2();
        }
        if(mode == 3){
            homeAppletView3();
        }
        if(mode == 4){
            homeAppletView4();
        }
        homeAppletInt = mode;
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeAppletPress_0(){
        homeScreenSTATE_B();
        theNestRootLayout.removeView(theNestHomeView);
        if(theNestSettingsView == null){
            theNestSettingsView = inflater.inflate(R.layout.the_nest_settings_layout, null);
            theNestSettingsLayout = theNestSettingsView.findViewById(R.id.the_nest_settings_layout);
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_settings_layout) == null){
            theNestRootLayout.addView(theNestSettingsView);
            setSize(this, theNestSettingsLayout, size(2), size(2));

            settingsConfigurations();
            settingsButtonsCREATED();
            settingsTooltipCREATED();
            if(settingsEdgeALayout == null){
                settingsPanelCREATED();
            }
            settingsScreenSTATE_A();
        }
    }

    private void homeAppletPress_1(){
        if(isAppInstalled(this, homeAppletBString)){
            Methods.startActivity(this, homeAppletBString, Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        } else {
            homeAPPLET(1);
        }
    }

    private void homeAppletPress_2(){
        if(homeAppletBInt == 1){
            homeFolder_Stem(homeAppletBString);
        }
        if(homeAppletBInt == 2){
            homeShortcutRemove(homeAppletBString);
        }
        homeAPPLET(1);
    }

    private void homeAppletPress_3(){
        if(homeAppletCString2.equals("Enabled")) {
            edit(this,  "Home/Configurations", homeAppletCString1 + " State - Enabled", homeAppletCString1 + " State - Disabled");
        } else {
            edit(this, "Home/Configurations", homeAppletCString1 + " State - Disabled", homeAppletCString1 + " State - Enabled");
        }
        homeConfigurations();
        if(homeAppletCInt == 0){
            homeWIDGET();
            homeAppletPositions();
        }
        if(homeAppletCInt == 1){
            homeWALLPAPER();
            homeCenterPositions();
        }
        if(homeAppletCInt == 2){
            homeFolder_Flower();
            homeWALLPAPER();
            homeStatus();
            homeCenterPositions();
            InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
        if(homeAppletCInt == 3){
            homeStatus();
            homeCenterPositions();
        }
        if(homeAppletCInt == 4){
            homeSHORTCUT();
        }
        appletToggle(homeAppletCInt);
    }

    private void homeAppletPress_4(){
        if(homeAppletDInt == 1){
            homeWidgetRemove();
        }
        if(homeAppletDInt == 2){
            homeWallpaperRemove();
        }
        homeAPPLET(1);
    }

    private void homeAppletPress_5(){
        if(homeAppletDInt == 1){
            if(widgetStyle.equals("A")){
                edit(this, "Home/Configurations",   "Widget Style - " + widgetStyle,  "Widget Style - B");
            }
            if(widgetStyle.equals("B")){
                edit(this, "Home/Configurations",   "Widget Style - " + widgetStyle,  "Widget Style - C");
            }
            if(widgetStyle.equals("C")){
                edit(this, "Home/Configurations",   "Widget Style - " + widgetStyle,  "Widget Style - D");
            }
            if(widgetStyle.equals("D")){
                edit(this, "Home/Configurations",   "Widget Style - " + widgetStyle,  "Widget Style - A");
            }
            homeConfigurations();
            widgetSize();
        }
    }

    private void homeAppletPress_6(){
        if(isAppInstalled(this, homeAppletBString)){
            Methods.startActivity(this, homeAppletBString, Intent.ACTION_DELETE);
        } else {
            homeAPPLET(1);
        }
    }

    private void homeAppletPress_7(){
        if(homeAppletDInt == 2){
            try {
                homeWallpaperManager.forgetLoadedWallpaper();
            } catch (Exception e){}
            imageTypeD(this, homeWallpaperCView, homeWallpaperManager.getDrawable(), 200);
        }
    }
    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeAppletRESUMED(){
        if(homeAppletLayout.findViewById(R.id.home_applet_b) != null && !isAppInstalled(this, homeAppletBString)){
            homeScreenSTATE_B();
            homeScreenSTATE_A();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeAppletView0;
    RelativeLayout homeAppletLayout;
    private void homeAppletView0(){
        if(homeAppletView0 == null){
            homeAppletView0 = inflater.inflate(R.layout.home_applet, null);
            homeAppletLayout = homeAppletView0.findViewById(R.id.home_applet);
        }
        if(theNestHomeLayout.findViewById(R.id.home_applet) == null){
            theNestHomeLayout.addView(homeAppletView0);
            setSize(this, homeAppletLayout, size(1), size(1));
        }
        homeAppletPositions();
    }

    private void homeAppletPositions(){
        if(theNestHomeLayout.findViewById(R.id.home_widget) == null) {
            layoutParamsTypeA(this, homeAppletLayout, new int[]{direction(1), direction(3)});
            setMargins(this, homeAppletLayout, 45, 0, 40, 60);
        } else {
            layoutParamsTypeB(this, homeAppletLayout, new int[]{direction(1)}, direction(8), R.id.home_widget);
            setMargins(this, homeAppletLayout, 20, 0, 20, 20);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeAppletView1;
    RelativeLayout homeAppletA;
    ImageView homeAppletAIcon;
    TextView homeAppletAText;
    private void homeAppletView1(){
        if(homeAppletView1 == null){
            homeAppletView1 = inflater.inflate(R.layout.home_applet_a, null);
            homeAppletA = homeAppletView1.findViewById(R.id.home_applet_a);
            homeAppletAIcon = homeAppletView1.findViewById(R.id.home_applet_a_icon);
            homeAppletAText = homeAppletView1.findViewById(R.id.home_applet_a_text);

            backgroundTypeC(this, homeAppletA, background(3), tintA);
            imageTypeA(this, homeAppletAIcon, icon(43), tintB, 75);
            textType(this, homeAppletAText, appletText, tintB, fontAStyle);

            customTouchModeB(homeAppletAIcon, textC(6), 0, 1, 0);
            homeAppletText();
        }
        if(homeAppletLayout.findViewById(R.id.home_applet_a) == null){
            homeAppletLayout.addView(homeAppletView1);
        }
    }

    private void homeAppletText(){
        if(appletText.isEmpty()){
            homeAppletAText.setVisibility(View.GONE);
        } else {
            homeAppletAText.setVisibility(View.VISIBLE);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeAppletView2;
    RelativeLayout homeAppletB, homeAppletBFrame1, homeAppletBFrame2, homeAppletBFrame3, homeAppletBFrame4;
    ImageView homeAppletBIcon1, homeAppletBIcon2, homeAppletBIcon3, homeAppletBIcon4;
    TextView homeAppletBText;
    private void homeAppletView2(){
        if(homeAppletView2 == null){
            homeAppletView2 = inflater.inflate(R.layout.home_applet_b, null);
            homeAppletB = homeAppletView2.findViewById(R.id.home_applet_b);
            homeAppletBIcon1 = homeAppletView2.findViewById(R.id.home_applet_b_icon_1);
            homeAppletBIcon2 = homeAppletView2.findViewById(R.id.home_applet_b_icon_2);
            homeAppletBIcon3 = homeAppletView2.findViewById(R.id.home_applet_b_icon_3);
            homeAppletBIcon4 = homeAppletView2.findViewById(R.id.home_applet_b_icon_4);
            homeAppletBFrame1 = homeAppletView2.findViewById(R.id.home_applet_b_frame_1);
            homeAppletBFrame2 = homeAppletView2.findViewById(R.id.home_applet_b_frame_2);
            homeAppletBFrame3 = homeAppletView2.findViewById(R.id.home_applet_b_frame_3);
            homeAppletBFrame4 = homeAppletView2.findViewById(R.id.home_applet_b_frame_4);
            homeAppletBText = homeAppletView2.findViewById(R.id.home_applet_b_text);

            backgroundTypeC(this, homeAppletBFrame4, background(3), tintA);
            backgroundTypeA(this, homeAppletBFrame1, background(5), tintB, 3);
            backgroundTypeA(this, homeAppletBFrame2, background(5), tintB, 3);
            backgroundTypeA(this, homeAppletBFrame3, background(5), tintB, 3);

            imageTypeA(this, homeAppletBIcon2, icon(38), tintB, 30);
            imageTypeA(this, homeAppletBIcon3, icon(40), tintB, 30);
            imageTypeA(this, homeAppletBIcon4, icon(32), tintB, 30);

            textType(this, homeAppletBText, "", tintA, fontAStyle);

            customTouchModeB(homeAppletBFrame1, textC(10), 0, 1,2);
            customTouchModeB(homeAppletBFrame2, textC(11), 0, 1,1);
            customTouchModeB(homeAppletBFrame3, textC(12), 0, 1,6);
        }
        if(homeAppletLayout.findViewById(R.id.home_applet_b) == null){
            homeAppletLayout.addView(homeAppletView2);
            layoutParamsTypeA(this, homeAppletB, new int[]{direction(2)});
        }
        if(!isAppInstalled(this, homeAppletBString)){
            homeAPPLET(1);
        }
    }

    private int homeAppletBInt = 0;
    private String homeAppletBString;
    private void homeAppletBModule(String packageName, int focus){
        homeAppletBString = packageName;
        homeAppletBInt = focus;

        if(!systemApp(this, packageName)){
            homeAppletBFrame3.setVisibility(View.VISIBLE);
        } else {
            homeAppletBFrame3.setVisibility(View.GONE);
        }

        String appLabel = "";
        try {
            appLabel = (String) getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(packageName, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        homeAppletBText.setText(appLabel);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homeAppletBIcon1.setImageBitmap(roundedBitmap(adaptiveIcon(this, packageName, 50)));
        } else {
            homeAppletBIcon1.setImageBitmap(roundedBitmap(drawableIcon(this, packageName, 50)));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeAppletView3;
    RelativeLayout homeAppletC, homeAppletCFrame;
    TextView homeAppletCText;
    ImageView homeAppletCCircle;
    private void homeAppletView3(){
        if(homeAppletView3 == null){
            homeAppletView3 = inflater.inflate(R.layout.home_applet_c, null);
            homeAppletC = homeAppletView3.findViewById(R.id.home_applet_c);
            homeAppletCText = homeAppletView3.findViewById(R.id.home_applet_c_text);
            homeAppletCFrame = homeAppletView3.findViewById(R.id.home_applet_c_frame);
            homeAppletCCircle = homeAppletView3.findViewById(R.id.home_applet_c_circle);

            backgroundTypeC(this, homeAppletC, background(3), tintA);
            backgroundTypeA(this, homeAppletCFrame, background(7), ui, 3);
            textType(this, homeAppletCText, "", tintB, fontBStyle);
        }
        if(homeAppletLayout.findViewById(R.id.home_applet_c) == null){
            homeAppletLayout.addView(homeAppletView3);
        }
    }

    private int homeAppletCInt = 0;
    private String homeAppletCString1 = "";
    private String homeAppletCString2 = "";
    private void appletToggle(int mode){
        homeAppletCInt = mode;
        if(homeAppletCInt == 0){
            homeAppletCString1 = "Widget";
            homeAppletCString2 = widgetState;
            textType(this, homeAppletCText, textB(107), tintB, fontBStyle);
            homeAppletCText.setText(textB(4));
        }
        if(homeAppletCInt == 1){
            homeAppletCString1 = "Wallpaper";
            homeAppletCString2 = wallpaperState;
            homeAppletCText.setText(textB(5));
        }
        if(homeAppletCInt == 2){
            homeAppletCString1 = "Folder";
            homeAppletCString2 = folderState;
            homeAppletCText.setText(textB(6));
        }
        if(homeAppletCInt == 3){
            homeAppletCString1 = "Status";
            homeAppletCString2 = statusState;
            homeAppletCText.setText(textB(7));
        }
        if(homeAppletCInt == 4){
            homeAppletCString1 = "Shortcut";
            homeAppletCString2 = shortcutState;
            homeAppletCText.setText(textB(8));
        }
        if(homeAppletCString2.equals("Enabled")) {
            toggleMode(this, homeAppletCCircle, true);
        } else {
            toggleMode(this, homeAppletCCircle, false);
        }
        customTouchModeB(homeAppletCFrame, "", 0, 1, 3);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeAppletView4;
    RelativeLayout homeAppletD, homeAppletDFrame1, homeAppletDFrame2, homeAppletDFrame3, homeAppletDFrame4,
            homeAppletDFrame5, homeAppletDFrame6;
    ImageView homeAppletDIcon1, homeAppletDIcon2, homeAppletDIcon3, homeAppletDIcon4;
    TextView homeAppletDText;
    private void homeAppletView4(){
        if(homeAppletView4 == null){
            homeAppletView4 = inflater.inflate(R.layout.home_applet_d, null);
            homeAppletD = homeAppletView4.findViewById(R.id.home_applet_d);
            homeAppletDFrame1 = homeAppletView4.findViewById(R.id.home_applet_d_frame_1);
            homeAppletDFrame2 = homeAppletView4.findViewById(R.id.home_applet_d_frame_2);
            homeAppletDFrame3 = homeAppletView4.findViewById(R.id.home_applet_d_frame_3);
            homeAppletDFrame4 = homeAppletView4.findViewById(R.id.home_applet_d_frame_4);
            homeAppletDFrame5 = homeAppletView4.findViewById(R.id.home_applet_d_frame_5);
            homeAppletDFrame6 = homeAppletView4.findViewById(R.id.home_applet_d_frame_6);
            homeAppletDIcon1 = homeAppletView4.findViewById(R.id.home_applet_d_icon_1);
            homeAppletDIcon2 = homeAppletView4.findViewById(R.id.home_applet_d_icon_2);
            homeAppletDIcon3 = homeAppletView4.findViewById(R.id.home_applet_d_icon_3);
            homeAppletDIcon4 = homeAppletView4.findViewById(R.id.home_applet_d_icon_4);
            homeAppletDText = homeAppletView4.findViewById(R.id.home_applet_d_text);

            backgroundTypeA(this, homeAppletDFrame1, background(12), tintA, 3);
            backgroundTypeC(this, homeAppletDFrame3, background(4), tintA);
            backgroundTypeA(this, homeAppletDFrame4, background(5), tintA, 3);
            backgroundTypeA(this, homeAppletDFrame5, background(5), tintA, 3);
            backgroundTypeA(this, homeAppletDFrame6, background(5), tintA, 3);

            imageTypeA(this, homeAppletDIcon2, icon(48), tintA, 40);
            imageTypeA(this, homeAppletDIcon3, icon(49), tintA, 40);
            imageTypeA(this, homeAppletDIcon4, icon(41), tintA, 40);

            textType(this, homeAppletDText, "", tintA, fontAStyle);

            customTouchModeB(homeAppletDFrame4, textC(10), 0, 1, 4);
            customTouchModeB(homeAppletDFrame5, textC(16), 0, 1, 5);
            customTouchModeB(homeAppletDFrame6, textC(19), 0, 1, 7);
        }
        if(homeAppletLayout.findViewById(R.id.home_applet_d) == null){
            homeAppletLayout.addView(homeAppletView4);
        }
    }

    private int homeAppletDInt = 0;
    private void homeAppletCurrentTools(int mode){
        homeAppletDInt = mode;
        if(homeAppletDInt == 1){
            imageTypeA(this, homeAppletDIcon1, icon(46), tintB, 75);
            homeAppletDText.setText(textB(9));
            homeAppletDFrame5.setVisibility(View.VISIBLE);
            homeAppletDFrame6.setVisibility(View.GONE);
        }
        if(homeAppletDInt == 2){
            imageTypeA(this, homeAppletDIcon1, icon(47), tintB, 75);
            homeAppletDText.setText(textB(10));
            homeAppletDFrame5.setVisibility(View.GONE);
            homeAppletDFrame6.setVisibility(View.VISIBLE);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    View homeTooltipView;
    static RelativeLayout homeTooltipLayout;
    static TextView homeTooltipText;
    private void homeTOOLTIP(){
        if(homeTooltipView == null){
            homeTooltipView = inflater.inflate(R.layout.home_tooltip, null);
            homeTooltipLayout = homeTooltipView.findViewById(R.id.home_tooltip);
            homeTooltipText = homeTooltipView.findViewById(R.id.home_tooltip_text);

            backgroundTypeC(this, homeTooltipLayout, background(3), tintA);
        }
        if(theNestHomeLayout.findViewById(R.id.home_tooltip) == null){
            theNestHomeLayout.addView(homeTooltipView);
            layoutParamsTypeB(this, homeTooltipLayout, new int[]{direction(1)}, direction(8), R.id.home_applet);
            homeTooltipStateA(homeTooltipLayout.getContext());
        }
    }

    public static void homeTooltipStateA(Context context){
        homeTooltipText.setText("");
        setMargins(context, homeTooltipLayout, 0, 0, 0, 0);
        setSize(context, homeTooltipLayout, 0, 0);
    }

    public static void homeTooltipStateB(Context context, String tooltip){
        textType(context, homeTooltipText, tooltip, tintB, fontAStyle);
        setMargins(context, homeTooltipLayout, 20, 0, 20, 20);
        setSize(context, homeTooltipLayout, size(1), density(context, 35));
    }

    public static Handler homeTooltipHandler = new Handler();
    public static Runnable homeTooltipRunnable = new Runnable() {
        @Override
        public void run() {
            homeTooltipStateA(homeTooltipLayout.getContext());
        }
    };

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeWALLPAPER(){
        if(wallpaperState.equals("Disabled")){
            theNestHomeLayout.removeView(homeWallpaperView0);
        } else {
            homeWallpaperView0();
            homeWallpaperLayout.removeAllViews();
            if(wallpaperMode.equals("[ NONE ]")){
                homeWallpaperView1();
            }
            if(wallpaperMode.equals("Device")){
                homeWallpaperDevice();
            }
            if(wallpaperMode.equals("SimpliC")){
                if(wallpaperComponent.equals("Blocks")){
                    homeWallpaperView4();
                }
            }
            if(theNestHomeLayout.findViewById(R.id.home_folder_b) != null){
                theNestHomeLayout.removeView(homeWallpaperView0);
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeWallpaperHold(){
        if(theNestHomeLayout.findViewById(R.id.home_applet_c) == null) {
            homeAPPLET(3);
        }
        appletToggle(1);
    }

    private void homeWallpaperPress_0(){
        if(homeAppletLayout.findViewById(R.id.home_applet_d) == null){
            homeAPPLET(4);
        }
        homeAppletCurrentTools(2);
    }

    private void homeWallpaperPress_1(){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView0;
    RelativeLayout homeWallpaperLayout;
    private void homeWallpaperView0(){
        if(homeWallpaperView0 == null){
            homeWallpaperView0 = inflater.inflate(R.layout.home_wallpaper, null);
            homeWallpaperLayout = homeWallpaperView0.findViewById(R.id.home_wallpaper);
        }
        if(theNestHomeLayout.findViewById(R.id.home_wallpaper) == null){
            theNestHomeLayout.addView(homeWallpaperView0);
            setMargins(this, homeWallpaperLayout,20,0,20, 20);
            setSize(this, homeWallpaperLayout, size(1), size(1));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView1;
    RelativeLayout homeWallpaperA;
    TextView homeWallpaperAText1, homeWallpaperAText2;
    private void homeWallpaperView1(){
        if(homeWallpaperView1 == null){
            homeWallpaperView1 = inflater.inflate(R.layout.home_wallpaper_a, null);
            homeWallpaperA = homeWallpaperView1.findViewById(R.id.home_wallpaper_a);
            homeWallpaperAText1 = homeWallpaperView1.findViewById(R.id.home_wallpaper_a_text_1);
            homeWallpaperAText2 = homeWallpaperView1.findViewById(R.id.home_wallpaper_a_text_2);

            backgroundTypeA(this, homeWallpaperA, background(8), tintA, 3);
            textType(this, homeWallpaperAText1, textA(11), tintA, Typeface.BOLD);
            textType(this, homeWallpaperAText2, textC(1), tintA, fontAStyle);

            customTouchModeA(homeWallpaperA, 1, 1000);
        }
        if(homeWallpaperLayout.findViewById(R.id.home_wallpaper_a) == null){
            homeWallpaperLayout.addView(homeWallpaperView1);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView2;
    RelativeLayout homeWallpaperB;
    ImageView homeWallpaperBIcon;
    TextView homeWallpaperBText1, homeWallpaperBText2;
    private void homeWallpaperView2(){
        if(homeWallpaperView2 == null){
            homeWallpaperView2 = inflater.inflate(R.layout.home_wallpaper_b, null);
            homeWallpaperB = homeWallpaperView2.findViewById(R.id.home_wallpaper_b);
            homeWallpaperBIcon = homeWallpaperView2.findViewById(R.id.home_wallpaper_b_icon);
            homeWallpaperBText1 = homeWallpaperView2.findViewById(R.id.home_wallpaper_b_text_1);
            homeWallpaperBText2 = homeWallpaperView2.findViewById(R.id.home_wallpaper_b_text_2);

            backgroundTypeA(this, homeWallpaperB, background(8), tintA, 3);

            textType(this, homeWallpaperBText1, "", tintA, fontAStyle);
            textType(this, homeWallpaperBText2, textB(11), tintA, fontBStyle);
        }
        if(homeWallpaperLayout.findViewById(R.id.home_wallpaper_b) == null){
            homeWallpaperLayout.addView(homeWallpaperView2);
            setSize(this, homeWallpaperB, density(this, 200), size(1));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homeWallpaperBIcon.setImageBitmap(roundedBitmap(adaptiveIcon(this, homeWallpaperInfo.getPackageName(),50)));
        } else {
            homeWallpaperBIcon.setImageBitmap(roundedBitmap(drawableIcon(this, homeWallpaperInfo.getPackageName(),50)));
        }
        homeWallpaperBText1.setText(homeWallpaperInfo.loadLabel(getPackageManager()));
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView3;
    RelativeLayout homeWallpaperC, homeWallpaperCFrame;
    ImageView homeWallpaperCIcon, homeWallpaperCView;
    private void homeWallpaperView3(){
        if(homeWallpaperView3 == null){
            homeWallpaperView3 = inflater.inflate(R.layout.home_wallpaper_c, null);
            homeWallpaperC = homeWallpaperView3.findViewById(R.id.home_wallpaper_c);
            homeWallpaperCView = homeWallpaperView3.findViewById(R.id.home_wallpaper_c_view);
            homeWallpaperCIcon = homeWallpaperView3.findViewById(R.id.home_wallpaper_c_icon);
            homeWallpaperCFrame = homeWallpaperView3.findViewById(R.id.home_wallpaper_c_frame);

            backgroundTypeA(this, homeWallpaperC, background(8), tintA, 3);

            backgroundTypeB(this, homeWallpaperCFrame, drawable(2), background, 30);
            imageTypeA(this, homeWallpaperCIcon, drawable(2), tintA, 30);
            imageTypeD(this, homeWallpaperCView, homeWallpaperManager.getDrawable(),200);

            customTouchModeB(homeWallpaperCIcon, textC(9), 0, 2, 0);
        }
        if(homeWallpaperLayout.findViewById(R.id.home_wallpaper_c) == null){
            homeWallpaperLayout.addView(homeWallpaperView3);
            setSize(this, homeWallpaperCView, density(this, 200), density(this, 200));
        }
    }

    WallpaperManager homeWallpaperManager;
    WallpaperInfo homeWallpaperInfo;
    private void homeWallpaperDevice(){
        if(homeWallpaperManager == null)
            homeWallpaperManager = WallpaperManager.getInstance(this);
        homeWallpaperInfo = homeWallpaperManager.getWallpaperInfo();
        if (homeWallpaperInfo == null) {
            if(permission(this, "android.permission.READ_EXTERNAL_STORAGE")){
                if (homeWallpaperManager.getDrawable() != null) {
                    homeWallpaperView3();
                } else {
                    homeWallpaperRemove();
                }
            } else {
                homeWallpaperView5();
            }
        } else {
            homeWallpaperView2();
        }
    }

    private void homeWallpaperRemove(){
        edit(this, "Home/Configurations", "Wallpaper Mode - " + wallpaperMode, "Wallpaper Mode - [ NONE ]");
        edit(this, "Home/Configurations", "Wallpaper Component - " + wallpaperComponent, "Wallpaper Component - [ NONE ]");
        homeConfigurations();
        homeWALLPAPER();
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView4;
    RelativeLayout homeWallpaperD;
    ImageView homeWallpaperDView;
    private void homeWallpaperView4(){
        if(homeWallpaperView4 == null){
            homeWallpaperView4 = inflater.inflate(R.layout.home_wallpaper_d, null);
            homeWallpaperD = homeWallpaperView4.findViewById(R.id.home_wallpaper_d);
            homeWallpaperDView = homeWallpaperView4.findViewById(R.id.home_wallpaper_d_view);

            backgroundTypeA(this, homeWallpaperD, background(8), tintA, 3);
            imageTypeA(this, homeWallpaperDView, drawable(1), R.color.transparent, 200);
        }
        if(homeWallpaperLayout.findViewById(R.id.home_wallpaper_d) == null){
            homeWallpaperLayout.addView(homeWallpaperView4);
            setSize(this, homeWallpaperDView, density(this, 200), density(this, 200));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeWallpaperView5;
    RelativeLayout homeWallpaperE, homeWallpaperEFrame;
    ImageView homeWallpaperEIcon;
    ScrollView homeWallpaperEScrollView;
    TextView homeWallpaperEText1, homeWallpaperEText2;
    private void homeWallpaperView5(){
        if(homeWallpaperView5 == null){
            homeWallpaperView5 = inflater.inflate(R.layout.home_wallpaper_e, null);
            homeWallpaperE = homeWallpaperView5.findViewById(R.id.home_wallpaper_e);
            homeWallpaperEIcon = homeWallpaperView5.findViewById(R.id.home_wallpaper_e_icon);
            homeWallpaperEText1 = homeWallpaperView5.findViewById(R.id.home_wallpaper_e_text_1);
            homeWallpaperEText2 = homeWallpaperView5.findViewById(R.id.home_wallpaper_e_text_2);
            homeWallpaperEFrame = homeWallpaperView5.findViewById(R.id.home_wallpaper_e_frame);
            homeWallpaperEScrollView = homeWallpaperView5.findViewById(R.id.home_wallpaper_e_scroll_view);

            backgroundTypeA(this, homeWallpaperE, background(8), tintA, 3);
            backgroundTypeA(this, homeWallpaperEFrame, background(9), tintA, 3);

            imageTypeA(this, homeWallpaperEIcon, icon(20), tintA, 40);

            textType(this, homeWallpaperEText1, textC(67), tintA, fontAStyle);
            textType(this, homeWallpaperEText2, textB(82), tintA, fontBStyle);

            customTouchModeB(homeWallpaperEFrame, textC(75), 0, 2, 1);
        }
        if(homeWallpaperLayout.findViewById(R.id.home_wallpaper_e) == null){
            homeWallpaperLayout.addView(homeWallpaperView5);
            setSize(this, homeWallpaperE, density(this, 200), density(this, 200));
        }
    }

    /*
       -------------------------
       [                       ]
       [     HOME - FOLDER     ]
       [                       ]
       -------------------------
     */

    private void homeFolder_Flower(){
        if(folderState.equals("Disabled")){
            theNestHomeLayout.removeView(homeFolderView1);
            theNestHomeLayout.removeView(homeFolderView2);
        } else {
            homeFolder_FruitA();
        }
    }

    View homeFolderView1;
    RelativeLayout homeFolderA;
    ImageView homeFolderAIcon;
    private void homeFolder_FruitA(){
        if(homeFolderView1 == null){
            homeFolderView1 = inflater.inflate(R.layout.home_folder_a, null);
            homeFolderA = homeFolderView1.findViewById(R.id.home_folder_a);
            homeFolderAIcon = homeFolderView1.findViewById(R.id.home_folder_a_icon);

            imageTypeA(this, homeFolderAIcon, icon(37), tintA, 65);

            customTouchModeB(homeFolderA, textC(2), 0, 3, 0);
        }
        if(theNestHomeLayout.findViewById(R.id.home_folder_a) == null){
            theNestHomeLayout.addView(homeFolderView1);
            setMargins(this, homeFolderA, 20, 0, 20, 0);
        }
    }

    View homeFolderView2;
    RelativeLayout homeFolderB, homeFolderBFrame1, homeFolderBFrame2;
    TextView homeFolderBText1, homeFolderBText2;
    EditText homeFolderBEditText;
    ImageView homeFolderBIcon1, homeFolderBIcon2;
    private void homeFolder_FruitB(){
        if(homeFolderView2 == null){
            homeFolderView2 = inflater.inflate(R.layout.home_folder_b, null);
            homeFolderB = homeFolderView2.findViewById(R.id.home_folder_b);
            homeFolderBFrame1 = homeFolderView2.findViewById(R.id.home_folder_b_frame_1);
            homeFolderBFrame2 = homeFolderView2.findViewById(R.id.home_folder_b_frame_2);
            homeFolderBText1 = homeFolderView2.findViewById(R.id.home_folder_b_text_1);
            homeFolderBText2 = homeFolderView2.findViewById(R.id.home_folder_b_text_2);
            homeFolderBEditText = homeFolderView2.findViewById(R.id.home_folder_b_edittext);
            homeFolderBIcon1 = homeFolderView2.findViewById(R.id.home_folder_b_icon_1);
            homeFolderBIcon2 = homeFolderView2.findViewById(R.id.home_folder_b_icon_2);

            homeFolderBEditText.setVisibility(View.GONE);

            backgroundTypeC(this, homeFolderBFrame1, background(6), tintA);
            backgroundTypeC(this, homeFolderBFrame2, background(4), tintA);

            imageTypeA(this, homeFolderBIcon1, icon(45), tintB, 50);
            imageTypeA(this, homeFolderBIcon2, icon(33), tintA, 70);

            textType(this, homeFolderBText1, "", tintB, fontBStyle);
            textType(this, homeFolderBText2, "", tintA, fontBStyle);

            customTypeB(this, homeFolderBEditText, textA(6), tintB, fontBStyle);

            customTouchModeB(homeFolderBIcon2, textC(15), 0, 3,1);
            customTouchModeB(homeFolderBFrame2, textC(14), 0, 3,2);

            homeFolder_LeafA();
        }
        if(theNestHomeLayout.findViewById(R.id.home_folder_b) == null){
            theNestHomeLayout.addView(homeFolderView2);
            layoutParamsTypeB(this, homeFolderB, new int[]{direction(1)}, direction(8), R.id.home_tooltip);
            setMargins(this, homeFolderB, 20, 0, 40, 40);
            setSize(this, homeFolderB, size(1), size(1));
        }
    }

    View homeFolderView3;
    RelativeLayout homeFolderC, homeFolderCFrame;
    TextView homeFolderCText1, homeFolderCText2;
    private void homeFolder_FruitC(){
        if(homeFolderView3 == null){
            homeFolderView3 = inflater.inflate(R.layout.home_folder_c, null);
            homeFolderC = homeFolderView3.findViewById(R.id.home_folder_c);
            homeFolderCFrame = homeFolderView3.findViewById(R.id.home_folder_c_frame);
            homeFolderCText1 = homeFolderView3.findViewById(R.id.home_folder_c_text_1);
            homeFolderCText2 = homeFolderView3.findViewById(R.id.home_folder_c_text_2);

            backgroundTypeC(this, homeFolderC, background(13), tintA);

            textType(this, homeFolderCText1, textA(5), tintB, Typeface.BOLD);
            textType(this, homeFolderCText2, textC(8), tintB, fontAStyle);

            customTouchModeA(homeFolderCFrame, 2, 1000);
        }
        if(homeFolderB.findViewById(R.id.home_folder_c) == null) {
            homeFolderB.addView(homeFolderView3);
            homeFolderB.removeView(homeFolderView4);
            layoutParamsTypeB(this, homeFolderC, new int[]{direction(5)}, direction(8), R.id.home_folder_b_icon_2);
            setMargins(this, homeFolderC, 10, 0, 0, 0);
            setSize(this, homeFolderC, size(1), size(1));
        }
    }

    View homeFolderView4;
    RelativeLayout homeFolderD;
    ListView homeFolderDListView;
    private void homeFolder_FruitD(){
        if(homeFolderView4 == null){
            homeFolderView4 = inflater.inflate(R.layout.home_folder_d, null);
            homeFolderD = homeFolderView4.findViewById(R.id.home_folder_d);
            homeFolderDListView = homeFolderView4.findViewById(R.id.home_folder_d_list_view);
            backgroundTypeC(this, homeFolderD, background(13), tintA);
        }
        if(homeFolderB.findViewById(R.id.home_folder_d) == null) {
            homeFolderB.removeView(homeFolderView3);
            homeFolderB.addView(homeFolderView4);
            layoutParamsTypeB(this, homeFolderD, new int[]{direction(5)}, direction(8), R.id.home_folder_b_icon_2);
            setMargins(this, homeFolderD, 10, 0, 0, 0);
            setSize(this, homeFolderD, size(1), size(1));
        }
    }

    //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ [ PART - 1 ]
    //

    private void homeFolderHold(){
        if(theNestHomeLayout.findViewById(R.id.home_applet_c) == null) {
            homeAPPLET(3);
        }
        appletToggle(2);
    }

    private void homeFolderPress_0(){
        theNestHomeLayout.removeView(homeWallpaperView0);
        theNestHomeLayout.removeView(homeStatusView0);
        theNestHomeLayout.removeView(homeFolderView1);
        homeFolder_FruitB();
        homeFolder_Root();
    }

    private void homeFolderPress_1(){
        theNestHomeLayout.removeView(homeFolderView2);
        homeWALLPAPER();
        homeFolder_Flower();
        homeStatus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    private void homeFolderPress_2(){
        backgroundTypeC(this, homeFolderBFrame2, background(4), ui);
        imageTypeA(this, homeFolderBIcon1, icon(31), tintB, 50);
        customTouchModeB(homeFolderBFrame2, textC(13), 0, 3, 3);

        homeFolderBEditText.setVisibility(View.VISIBLE);
        homeFolderBText1.setVisibility(View.GONE);
        homeFolder_LeafA();
    }

    private void homeFolderPress_3(){
        if(!homeFolderBEditText.getText().toString().isEmpty()){
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

            edit(TheNest.this, "Home/Configurations", "Folder Name - " + folderName, "Folder Name - " + homeFolderBEditText.getText().toString().trim());
            folderName = homeFolderBEditText.getText().toString().trim();

            backgroundTypeC(this, homeFolderBFrame2, background(4), tintA);
            imageTypeA(this, homeFolderBIcon1, icon(45), tintB, 50);
            customTouchModeB(homeFolderBFrame2, textC(14), 0,3,2);

            homeFolderBEditText.setVisibility(View.GONE);
            homeFolderBText1.setVisibility(View.VISIBLE);
            homeFolder_LeafA();
        }
    }

    //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ [ PART - 2 ]
    //

    private void homeFolder_LeafA(){
        homeFolderBText1.setText(folderName);
        homeFolderBEditText.setText(folderName);
    }

    private void homeFolder_LeafB(){
        homeFolder_FruitC();
        homeFolderBText2.setText("");
    }

    private void homeFolder_LeafC(){
        if(folderListArray.size() >= 10){
            homeFolderBText2.setText(textA(8) + " " + folderListArray.size());
        } else {
            homeFolderBText2.setText(textA(15) + " " + folderListArray.size());
        }
    }

    //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ [ PART - 3 ]
    //

    ListTypeA folderListItems;
    ArrayList<String> folderListArray;
    private void homeFolder_Root(){
        if(fileExist(this, "List/Array - 01")){
            Handler homeFolderHandler = new Handler();
            Runnable homeFolderRunnable = new Runnable() {
                @Override
                public void run() {
                    folderListArray = (ArrayList<String>) read(TheNest.this, "List/Array - 01");
                    for (Iterator<String> iterator = folderListArray.iterator(); iterator.hasNext();) {
                        String value = iterator.next();
                        if (value.equals("REMOVED") || !isAppInstalled(TheNest.this, value))
                            iterator.remove();
                    }
                    if(folderListArray.size() == 0){
                        homeFolder_LeafB();
                    } else {
                        homeFolder_FruitD();
                        homeFolder_LeafC();

                        if(folderListItems != null){
                            if(folderListItems.getCount() < folderListArray.size()){
                                for(String string : folderListArray){
                                    if(!folderListItems.arrayItems().contains(string))
                                        folderListItems.add(string);
                                }
                                folderListItems.notifyDataSetChanged();
                            }
                            if(folderListItems.getCount() > folderListArray.size()){
                                for(Object string : folderListItems.arrayItems().toArray()){
                                    if(!folderListArray.contains(string)){
                                        folderListItems.remove(string);
                                    }
                                }
                                //Because it makes it slow
                                //folderListItems.notifyDataSetChanged();
                            }
                        } else {
                            if(folderSortingOrder.equals("Alphabetically")){
                                Collections.sort(folderListArray, new Comparator<String>() {
                                    @Override
                                    public int compare(String a, String b) {
                                        return appLabel(TheNest.this, a).compareTo(appLabel(TheNest.this, b));
                                    }
                                });
                            } else {
                                Collections.sort(folderListArray);
                            }

                            folderListItems = new ListTypeA(TheNest.this, folderListArray, TheNest.this);
                            if(homeFolderDListView.getAdapter() == null)
                                homeFolderDListView.setAdapter(folderListItems);
                        }
                    }
                }
            };
            homeFolderHandler.postDelayed(homeFolderRunnable, 75);
        } else {
            homeFolder_LeafB();
        }
    }

    private void homeFolder_Stem(String appletAppPackage){
        edit(this, "List/Array - 01",  appletAppPackage,"REMOVED");
        homeFolder_Root();
        /*folderListArray.remove(appletAppPackage);
        folderListItems.remove(appletAppPackage);
        //folderListItems.notifyDataSetChanged();
        homeFolder_LeafC();
        if(folderListArray.size() == 0)
            homeFolder_Root();*/
        settingsHomeEBoolean = true;
    }

    @Override
    public void homeFolder_Pores(String current) {
        if(isAppInstalled(this, current)){
            homeAppletBString = current;
            if(homeAppletLayout.findViewById(R.id.home_applet_b) == null){
                homeAPPLET(2);
            }
            homeAppletBModule(current, 1);
        } else {
            //error app not instaalled msg
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeStatus(){
        if(statusState.equals("Disabled")){
            theNestHomeLayout.removeView(homeStatusView0);
        } else {
            homeStatusView0();

            homeStatusLayout.removeAllViews();

            if(statusMode.equals("[ NONE ]")){
                homeStatusView1();
            }
            if(statusMode.equals("Battery Status")){
                homeStatusView2();
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeStatusHold(){
        if(theNestHomeLayout.findViewById(R.id.home_applet_c) == null) {
            homeAPPLET(3);
        }
        appletToggle(3);
    }

    private void homeStatusPress_0(){
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        if(powerManager.isPowerSaveMode()){
            Intent intent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
            startActivity(intent);
        } else {
            Intent intent = new Intent(Intent.ACTION_POWER_USAGE_SUMMARY);
            startActivity(intent);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeStatusView0;
    RelativeLayout homeStatusLayout;
    private void homeStatusView0(){
        if(homeStatusView0 == null){
            homeStatusView0 = inflater.inflate(R.layout.home_status,null);
            homeStatusLayout = homeStatusView0.findViewById(R.id.home_status);
        }
        if(theNestHomeLayout.findViewById(R.id.home_status) == null){
            theNestHomeLayout.addView(homeStatusView0);
            setSize(this, homeStatusLayout, size(1), size(1));
            setMargins(this, homeStatusLayout, 20, 0, 0, 20);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeStatusView1;
    RelativeLayout homeStatusA;
    TextView homeStatusAText1, homeStatusAText2;
    private void homeStatusView1(){
        if(homeStatusView1 == null){
            homeStatusView1 = inflater.inflate(R.layout.home_status_a, null);
            homeStatusA = homeStatusView1.findViewById(R.id.home_status_a);
            homeStatusAText1 = homeStatusView1.findViewById(R.id.home_status_a_text_1);
            homeStatusAText2 = homeStatusView1.findViewById(R.id.home_status_a_text_2);

            textType(this, homeStatusAText1, textA(12), tintA, fontAStyle);
            textType(this, homeStatusAText2, textC(3), tintA, fontAStyle);

            customTouchModeA(homeStatusA, 3, 1000);
        }
        if(homeStatusLayout.findViewById(R.id.home_status_a) == null){
            homeStatusLayout.addView(homeStatusView1);
            setSize(this, homeStatusA, density(this, 100), size(1));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeStatusView2;
    RelativeLayout homeStatusB;
    ImageView homeStatusBIcon;
    TextView homeStatusBText1, homeStatusBText2;
    private void homeStatusView2(){
        if(homeStatusView2 == null){
            homeStatusView2 = inflater.inflate(R.layout.home_status_b, null);
            homeStatusB = homeStatusView2.findViewById(R.id.home_status_b);
            homeStatusBIcon = homeStatusView2.findViewById(R.id.home_status_b_icon);
            homeStatusBText1 = homeStatusView2.findViewById(R.id.home_status_b_text_1);
            homeStatusBText2 = homeStatusView2.findViewById(R.id.home_status_b_text_2);

            textType(this, homeStatusBText1, "", tintA, Typeface.BOLD);
            textType(this, homeStatusBText2, textB(12), tintA, fontBStyle);
            homeStatusBText2.setVisibility(View.GONE);

            customTouchModeB(homeStatusLayout, textC(18), 0, 4, 0);

            homeStatusIntent_1 = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            registerReceiver(homeStatusReceiver_1, homeStatusIntent_1);

            homeStatusIntent_2 = new IntentFilter();
            homeStatusIntent_2.addAction(Intent.ACTION_POWER_CONNECTED);
            homeStatusIntent_2.addAction(Intent.ACTION_POWER_DISCONNECTED);
            registerReceiver(homeStatusReceiver_2, homeStatusIntent_2);
        }
        if(homeStatusLayout.findViewById(R.id.home_status_b) == null){
            homeStatusLayout.addView(homeStatusView2);
            homeStatusBatteryState();
        }
    }

    IntentFilter homeStatusIntent_1;
    BroadcastReceiver homeStatusReceiver_1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED))
                homeStatusBatteryState();
        }
    };

    IntentFilter homeStatusIntent_2;
    BroadcastReceiver homeStatusReceiver_2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)
                    || intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
                homeStatusBatteryState();
        }
    };

    private void homeStatusBatteryState(){
        Intent intent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 100);
        int percent = (level * 100) / scale;

        if(percent >= 0 && percent <= 5){
            imageTypeC(this, homeStatusBIcon, icon(21), R.color.transparent, 150, 100);
        }
        if(percent >= 5 && percent <= 20){
            imageTypeC(this, homeStatusBIcon, icon(26), R.color.transparent, 150, 100);
        }
        if(percent >= 21 && percent <= 40){
            imageTypeC(this, homeStatusBIcon, icon(25), R.color.transparent, 150, 100);
        }
        if(percent >= 41 && percent <= 60){
            imageTypeC(this, homeStatusBIcon, icon(24), R.color.transparent, 150, 100);
        }
        if(percent >= 61 && percent <= 80){
            imageTypeC(this, homeStatusBIcon, icon(23), R.color.transparent, 150, 100);
        }
        if(percent >= 81 && percent <= 100){
            imageTypeC(this, homeStatusBIcon, icon(22), R.color.transparent, 150, 100);
        }

        homeStatusBText1.setText(percent + "%");

        int homeStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        if(homeStatus == BatteryManager.BATTERY_STATUS_CHARGING || homeStatus == BatteryManager.BATTERY_STATUS_FULL){
            homeStatusBText2.setVisibility(View.VISIBLE);
        } else {
            homeStatusBText2.setVisibility(View.GONE);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeCenterPositions(){
        if(wallpaperState.equals("Enabled")){
            if(statusState.equals("Enabled")){
                layoutParamsTypeC(this, homeWallpaperLayout, new int[]{direction(5)}, direction(8), R.id.home_tooltip, direction(9), R.id.home_status);
            } else {
                layoutParamsTypeB(this, homeWallpaperLayout, new int[]{direction(5)}, direction(8), R.id.home_tooltip);
            }
        }
        if(statusState.equals("Enabled")){
            if(wallpaperState.equals("Enabled")){
                layoutParamsTypeB(this, homeStatusLayout, new int[]{direction(6)}, direction(8), R.id.home_tooltip);
            } else {
                layoutParamsTypeB(this, homeStatusLayout, new int[]{direction(1)}, direction(8), R.id.home_tooltip);
            }
        }
        if(folderState.equals("Enabled")){
            if(wallpaperState.equals("Enabled")){
                layoutParamsTypeB(this, homeFolderA, new int[]{direction(5)}, direction(8), R.id.home_wallpaper);
                homeFolderA.setBackground(null);
                setMargins(this, homeFolderAIcon, 0, 0, 0, 0);
            } else {
                if(statusState.equals("Enabled")){
                    layoutParamsTypeB(this, homeFolderA, new int[]{direction(1)}, direction(8), R.id.home_status);
                    backgroundTypeA(this, homeFolderA,background(8), tintA, 3);
                    setMargins(this, homeFolderAIcon, 20, 20, 20, 20);
                } else {
                    layoutParamsTypeB(this, homeFolderA, new int[]{direction(1)}, direction(8), R.id.home_tooltip);
                    backgroundTypeA(this, homeFolderA, background(5), tintA, 3);
                    setMargins(this, homeFolderAIcon, 30, 30, 30, 30);
                }
            }
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeDrawerPress_0(){
        homeScreenSTATE_B();
        theNestRootLayout.removeView(theNestHomeView);
        if(theNestDrawerView == null){
            theNestDrawerView = inflater.inflate(R.layout.the_nest_drawer_layout, null);
            theNestDrawerLayout = theNestDrawerView.findViewById(R.id.the_nest_drawer_layout);
        }
        if(theNestRootLayout.findViewById(R.id.the_nest_drawer_layout) == null){
            theNestRootLayout.addView(theNestDrawerView);
            setSize(this, theNestDrawerLayout, size(2), size(2));

            drawerConfigurations();
            drawerEdgeCREATED();
            drawerTooltipCREATED();
            drawerTilesView();
            drawerAppsView();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeDRAWER(){
        homeDrawerView0();
        homeDrawerLayout.removeAllViews();
        if(drawerMode.equals("Icon")){
            homeDrawerView1();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeDrawerView0;
    RelativeLayout homeDrawerLayout;
    private void homeDrawerView0(){
        if(homeDrawerView0 == null){
            homeDrawerView0 = inflater.inflate(R.layout.home_drawer, null);
            homeDrawerLayout = homeDrawerView0.findViewById(R.id.home_drawer);
        }
        if(theNestHomeLayout.findViewById(R.id.home_drawer) == null){
            theNestHomeLayout.addView(homeDrawerView0);
            layoutParamsTypeB(this, homeDrawerLayout, new int[]{direction(6)}, direction(7),  R.id.home_edge_c);
            setSize(this, homeDrawerLayout, size(1), size(1));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeDrawerView1;
    RelativeLayout homeDrawerA;
    ImageView homeDrawerAIcon;
    private void homeDrawerView1(){
        if(homeDrawerView1 == null){
            homeDrawerView1 = inflater.inflate(R.layout.home_drawer_a, null);
            homeDrawerA = homeDrawerView1.findViewById(R.id.home_drawer_a);
            homeDrawerAIcon = homeDrawerView1.findViewById(R.id.home_drawer_a_icon);
            customTouchModeB(homeDrawerA, textC(5), 0, 5, 0);
            homeDrawerPresets(homeDrawerAIcon);
        }
        if(homeDrawerLayout.findViewById(R.id.home_drawer_a) == null){
            homeDrawerLayout.addView(homeDrawerView1);
            layoutParamsTypeA(this, homeDrawerA, new int[]{direction(3)});
        }
    }

    private void homeDrawerPresets(ImageView imageView){
        int dimen = 0;
        if(drawerSize.equals("A"))
            dimen = 40;
        if(drawerSize.equals("B"))
            dimen = 60;
        if(drawerSize.equals("C"))
            dimen = 80;
        if(drawerSize.equals("D"))
            dimen = 100;
        if(drawerSize.equals("E"))
            dimen = 120;

        int icon = 0;
        if(drawerIcon.equals("BeeHive"))
            icon = icon(35);
        if(drawerIcon.equals("SimpliC"))
            icon = icon(56);

        imageTypeA(this, imageView, icon, tintA, dimen + 20);
        setSize(this, imageView, density(this, dimen), density(this, dimen));
        imageView.setAlpha(drawerAlpha);

        if(imageView == homeDrawerAIcon){
            int bottom = 0;
            int end = 0;
            if(drawerSize.equals("A")){
                bottom = 10;
                end = 72;
            }
            if(drawerSize.equals("B")){
                bottom = 10;
                end = 62;
            }
            if(drawerSize.equals("C")){
                bottom = 10;
                end = 52;
            }
            if(drawerSize.equals("D")){
                bottom = 5;
                end = 42;
            }
            if(drawerSize.equals("E")){
                bottom = 5;
                end = 32;
            }
            setMargins(this, homeDrawerLayout, 0, bottom, 0,  end);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void homeShortcutHold(){
        if(theNestHomeLayout.findViewById(R.id.home_applet_c) == null) {
            homeAPPLET(3);
        }
        appletToggle(4);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeSHORTCUT() {
        if (shortcutState.equals("Disabled")) {
            theNestHomeLayout.removeView(homeShortcutView0);
        } else {
            homeShortcutView0();
            homeShortcutLayout.removeAllViews();
            homeShortcutContents();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeShortcutView0;
    RelativeLayout homeShortcutLayout;
    private void homeShortcutView0(){
        if(homeShortcutView0 == null){
            homeShortcutView0 = inflater.inflate(R.layout.home_shortcut, null);
            homeShortcutLayout = homeShortcutView0.findViewById(R.id.home_shortcut);
        }
        if(theNestHomeLayout.findViewById(R.id.home_shortcut) == null){
            theNestHomeLayout.addView(homeShortcutView0);
            layoutParamsTypeC(this, homeShortcutLayout, new int[]{direction(5)}, direction(9), R.id.home_edge_c, direction(7), R.id.home_edge_c);
            setSize(this, homeShortcutLayout, size(1), size(1));
            setMargins(this, homeShortcutLayout, 0, -57, 20, -100);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeShortcutView1;
    RelativeLayout homeShortcutA, homeShortcutAFrame;
    TextView homeShortcutAText1, homeShortcutAText2;
    private void homeShortcutView1(){
        if(homeShortcutView1 == null){
            homeShortcutView1 = inflater.inflate(R.layout.home_shortcut_a, null);
            homeShortcutA = homeShortcutView1.findViewById(R.id.home_shortcut_a);
            homeShortcutAFrame = homeShortcutView1.findViewById(R.id.home_shortcut_a_frame);
            homeShortcutAText1 = homeShortcutView1.findViewById(R.id.home_shortcut_a_text_1);
            homeShortcutAText2 = homeShortcutView1.findViewById(R.id.home_shortcut_a_text_2);

            backgroundTypeA(this, homeShortcutAFrame, background(7), tintA, 3);
            textType(this, homeShortcutAText1, textA(4), tintA, fontAStyle);
            textType(this, homeShortcutAText2, textC(4), tintA, fontAStyle);

            customTouchModeA(homeShortcutAFrame, 4, 1000);
        }
        if(homeShortcutLayout.findViewById(R.id.home_shortcut_a) == null){
            homeShortcutLayout.addView(homeShortcutView1);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View homeShortcutView2;
    RelativeLayout homeShortcutB, homeShortcutBFrame1, homeShortcutBFrame2;
    HorizontalScrollView homeShortcutBAppView;
    LinearLayout homeShortcutBAppLayout;
    TextView homeShortcutBText;
    private void homeShortcutView2(){
        if(homeShortcutView2 == null){
            homeShortcutView2 = inflater.inflate(R.layout.home_shortcut_b, null);
            homeShortcutB = homeShortcutView2.findViewById(R.id.home_shortcut_b);
            homeShortcutBFrame1 = homeShortcutView2.findViewById(R.id.home_shortcut_b_frame_1);
            homeShortcutBFrame2 = homeShortcutView2.findViewById(R.id.home_shortcut_b_frame_2);
            homeShortcutBAppView = homeShortcutView2.findViewById(R.id.home_shortcut_b_app_view);
            homeShortcutBAppLayout = homeShortcutView2.findViewById(R.id.home_shortcut_b_app_layout);
            homeShortcutBText = homeShortcutView2.findViewById(R.id.home_shortcut_b_text);

            backgroundTypeC(this, homeShortcutBFrame1, background(4), tintA);
            backgroundTypeA(this, homeShortcutBFrame2, background(7), tintA, 3);
            textType(this, homeShortcutBText, "", tintB, Typeface.BOLD);
        }
        if(homeShortcutLayout.findViewById(R.id.home_shortcut_b) == null){
            homeShortcutLayout.addView(homeShortcutView2);
        }
    }

    List<String> shortcutListArray;
    private void homeShortcutContents(){
        if(fileExist(this, "List/Array - 02")){
            Handler homeFolderHandler = new Handler();
            Runnable homeFolderRunnable = new Runnable() {
                @Override
                public void run() {
                    shortcutListArray = (ArrayList<String>) read(TheNest.this, "List/Array - 02");
                    for (Iterator<String> iterator = shortcutListArray.iterator(); iterator.hasNext();) {
                        String value = iterator.next();
                        if (value.equals("REMOVED") || !isAppInstalled(TheNest.this, value))
                            iterator.remove();
                    }
                    if(shortcutListArray.size() == 0){
                        homeShortcutView1();
                    } else {
                        homeShortcutView2();
                        homeShortcutBText.setText(String.valueOf(shortcutListArray.size()));

                        if(homeShortcutBAppLayout.getChildCount() < shortcutListArray.size()){
                            homeShortcutBAppLayout.removeAllViews();
                            homeShortcutInitialize((ArrayList<String>) shortcutListArray, homeShortcutBAppLayout);
                        } else {
                            for(String packageName : shortcutListArray){
                                if(!isAppInstalled(TheNest.this, packageName))
                                    homeShortcutRemove(packageName);
                            }
                            if(shortcutListArray.size() == 0)
                                homeShortcutContents();
                        }
                    }
                }
            };
            homeFolderHandler.postDelayed(homeFolderRunnable, 100);
        } else {
            homeShortcutView1();
        }
    }

    View homeShortcutView;
    RelativeLayout homeShortcutFrame;
    ImageView homeShortcutIcon;
    TextView homeShortcutText;
    @SuppressLint("ClickableViewAccessibility")
    private void homeShortcutInitialize(ArrayList<String> list, LinearLayout layout){
        for (int i = 0; i < list.size(); i++) {
            homeShortcutView = inflater.inflate(R.layout.linear_type_a, layout, false);
            homeShortcutFrame = homeShortcutView.findViewById(R.id.linear_type_a_frame);
            homeShortcutIcon = homeShortcutView.findViewById(R.id.linear_type_a_icon);
            homeShortcutText = homeShortcutView.findViewById(R.id.linear_type_a_text);

            if(list.size() >= 5){
                setSize(this, homeShortcutBFrame2, density(this, 270), size(1));
            } else {
                setSize(this, homeShortcutBFrame2, size(1), size(1));
            }

            if(list.size() >= 3){
                homeShortcutBFrame1.setVisibility(View.VISIBLE);
            } else {
                homeShortcutBFrame1.setVisibility(View.GONE);
            }

            if(list.size() == 1){
                homeShortcutText.setVisibility(View.VISIBLE);
                String appLabel = "";
                try {
                    appLabel = (String) getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(list.get(i), 0));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                textType(this, homeShortcutText, "  " + appLabel, tintA, fontBStyle);
            } else {
                homeShortcutText.setVisibility(View.GONE);
            }

            appIcon(this, homeShortcutIcon, list.get(i), 40);

            int finalI = i;
            homeShortcutFrame.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        touchStart(view);
                        onTouchRunnable = new Runnable() {
                            @Override
                            public void run() {
                                homeAppletBString = list.get(finalI);
                                if(isAppInstalled(TheNest.this, homeAppletBString)){
                                    if(homeAppletLayout.findViewById(R.id.home_applet_b) == null){
                                        homeAPPLET(2);
                                    }
                                    homeAppletBModule(homeAppletBString, 2);
                                } else {
                                    homeShortcutRemove(homeAppletBString);
                                }
                                touchVibrate(TheNest.this, view);
                            }
                        };
                        onTouchHandler.postDelayed(onTouchRunnable, 300);
                    }
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        touchStop(view);
                        if((System.currentTimeMillis() - time) < 200){
                            homeAppletBString = list.get(finalI);
                            if(isAppInstalled(TheNest.this, homeAppletBString)){
                                try {
                                    Intent intent = getPackageManager().getLaunchIntentForPackage(homeAppletBString);
                                    startActivity(intent);
                                } catch (Exception e){}
                            } else {
                                homeShortcutRemove(homeAppletBString);
                            }
                        }
                    }
                    touchEnd(event, view);
                    return true;
                }
            });
            layout.addView(homeShortcutView);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeShortcutRemove(String appletAppPackage){
        edit(this, "List/Array - 02",  appletAppPackage,"REMOVED");
        shortcutListArray.remove(appletAppPackage);
        homeShortcutBAppLayout.removeAllViews();
        homeShortcutInitialize((ArrayList<String>) shortcutListArray, homeShortcutBAppLayout);
        homeShortcutBText.setText(String.valueOf(shortcutListArray.size()));
        if(shortcutListArray.size() == 0){
            homeShortcutLayout.removeAllViews();
            homeShortcutContents();
        }
        settingsHomeHBoolean = true;
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    View theNestDrawerView;
    RelativeLayout theNestDrawerLayout;

    public static String drawerGridStyle;
    private String drawerSortingOrder;
    private String drawerBrowseMode;
    private void drawerConfigurations(){
        if(!fileExist(TheNest.this, "Drawer/Configurations")) {
            create(TheNest.this, "Drawer","/Configurations", "# Drawer Screen Configurations...");
            create(TheNest.this, "Drawer","/Configurations", "Drawer Grid Style - Tiles");
            create(TheNest.this, "Drawer","/Configurations", "Drawer Sorting Order - Alphabetically");
            create(TheNest.this, "Drawer","/Configurations", "Drawer Browse Mode - Index");
            create(TheNest.this, "Drawer","/Configurations", " ");
            create(TheNest.this, "Drawer","/Configurations", "--------------------");
            create(TheNest.this, "Drawer","/Configurations", " ");
        }

        List<String> readValues = read(TheNest.this, "Drawer/Configurations");
        drawerGridStyle = readValues.get(1).substring(20).trim();
        drawerSortingOrder = readValues.get(2).substring(23).trim();
        drawerBrowseMode = readValues.get(3).substring(21).trim();
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void drawerEdgeCREATED(){
        drawerEdgeA();
        drawerEdgeB();
    }

    View drawerEdgeAView;
    RelativeLayout drawerEdgeA;
    ImageView drawerEdgeASquare, drawerEdgeACircle1, drawerEdgeACircle2, drawerEdgeALine;
    TextView drawerEdgeALines;
    private void drawerEdgeA(){
        if(drawerEdgeAView == null){
            drawerEdgeAView = inflater.inflate(R.layout.drawer_edge_a, null);
            drawerEdgeA = drawerEdgeAView.findViewById(R.id.drawer_edge_a);
            drawerEdgeASquare = drawerEdgeAView.findViewById(R.id.drawer_edge_a_square);
            drawerEdgeACircle1 = drawerEdgeAView.findViewById(R.id.drawer_edge_a_circle_1);
            drawerEdgeACircle2 = drawerEdgeAView.findViewById(R.id.drawer_edge_a_circle_2);
            drawerEdgeALine = drawerEdgeAView.findViewById(R.id.drawer_edge_a_line);
            drawerEdgeALines = drawerEdgeAView.findViewById(R.id.drawer_edge_a_lines);

            imageTypeB(this, drawerEdgeACircle1, background(4), tintA);
            imageTypeB(this, drawerEdgeACircle2, background(4), tintA);
            textType(this, drawerEdgeALines, textA(13), tintA, Typeface.BOLD);
            backgroundTypeA(this, drawerEdgeASquare, background(8), tintA, 3);
            imageTypeB(this, drawerEdgeALine, background(6), tintA);
        }
        if(theNestDrawerLayout.findViewById(R.id.drawer_edge_a) == null){
            theNestDrawerLayout.addView(drawerEdgeAView);
            setMargins(this, drawerEdgeA, 10, 0, 20, 0);
            layoutParamsTypeB(this, drawerEdgeA, new int[]{direction(3), direction(5)}, direction(7), R.id.drawer_tiles);
        }
    }

    View drawerEdgeBView;
    RelativeLayout drawerEdgeB;
    ImageView drawerEdgeBSquare, drawerEdgeBCircle1, drawerEdgeBCircle2, drawerEdgeBLine;
    TextView drawerEdgeBLines;
    private void drawerEdgeB(){
        if(drawerEdgeBView == null){
            drawerEdgeBView = inflater.inflate(R.layout.drawer_edge_b, null);
            drawerEdgeB = drawerEdgeBView.findViewById(R.id.drawer_edge_b);
            drawerEdgeBSquare = drawerEdgeBView.findViewById(R.id.drawer_edge_b_square);
            drawerEdgeBCircle1 = drawerEdgeBView.findViewById(R.id.drawer_edge_b_circle_1);
            drawerEdgeBCircle2 = drawerEdgeBView.findViewById(R.id.drawer_edge_b_circle_2);
            drawerEdgeBLine = drawerEdgeBView.findViewById(R.id.drawer_edge_b_line);
            drawerEdgeBLines = drawerEdgeBView.findViewById(R.id.drawer_edge_b_lines);

            imageTypeB(this, drawerEdgeBCircle1, background(4), tintA);
            imageTypeB(this, drawerEdgeBCircle2, background(4), tintA);
            textType(this, drawerEdgeBLines, textA(13), tintA, Typeface.BOLD);
            backgroundTypeA(this, drawerEdgeBSquare, background(8), tintA, 3);
            imageTypeB(this, drawerEdgeBLine, background(6), tintA);
        }
        if(theNestDrawerLayout.findViewById(R.id.drawer_edge_b) == null){
            theNestDrawerLayout.addView(drawerEdgeBView);
            setMargins(this, drawerEdgeB, 5, 10, 20, 0);
            layoutParamsTypeB(this, drawerEdgeB, new int[]{direction(4), direction(5)}, direction(8), R.id.drawer_tiles);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    View drawerTooltipView;
    public static RelativeLayout drawerTooltipLayout;
    public static TextView drawerTooltipText;
    private void drawerTooltipCREATED(){
        if(drawerTooltipView == null){
            drawerTooltipView = inflater.inflate(R.layout.drawer_tooltip, null);
            drawerTooltipLayout = drawerTooltipView.findViewById(R.id.drawer_tooltip);
            drawerTooltipText = drawerTooltipView.findViewById(R.id.drawer_tooltip_text);

            backgroundTypeC(this, drawerTooltipLayout, background(3), tintA);
        }
        if(theNestDrawerLayout.findViewById(R.id.drawer_tooltip) == null){
            theNestDrawerLayout.addView(drawerTooltipView);
            layoutParamsTypeA(this, drawerTooltipLayout, new int[]{direction(3), direction(6)});
            drawerTooltipStateA(this);
        }
    }

    private void drawerTooltipSTOPPED(){
        try {
            drawerTooltipStateA(homeTooltipLayout.getContext());
            drawerTooltipHandler.removeCallbacks(drawerTooltipRunnable);
        } catch (Exception e){}
    }

    public static void drawerTooltipStateA(Context context){
        drawerTooltipText.setText("");
        setMargins(context, drawerTooltipLayout, 35, 0, 0, 0);
        setSize(context, drawerTooltipLayout, 0, 0);
    }

    public static void drawerTooltipStateB(Context context, String tooltip){
        textType(context, drawerTooltipText, tooltip, tintB, fontAStyle);
        setMargins(context, drawerTooltipLayout, 20, 0, 0, 20);
        setSize(context, drawerTooltipLayout, size(1), size(1));
    }

    public static Handler drawerTooltipHandler= new Handler();
    public static Runnable drawerTooltipRunnable = new Runnable() {
        @Override
        public void run() {
            drawerTooltipStateA(drawerTooltipLayout.getContext());
        }
    };

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    Handler drawerTilesHandler = new Handler();
    Runnable drawerTilesRunnable;
    private void drawerTilesPress_0(){
        drawerAppletString = "";
        drawerTilesText.setText("");
        gridAdapter.clear();
        gridAdapter.notifyDataSetChanged();
        gridArray.clear();
        if(drawerBrowseMode.equals("Index")){
            drawerAlphabets.clear();
            drawerTilesAlphabets.removeAllViews();
            drawerTilesFrame3.setVisibility(View.GONE);
        }
        try {
            drawerTilesHandler.removeCallbacks(drawerTilesRunnable);
        } catch (Exception e){}
        drawerTilesRunnable = new Runnable() {
            @Override
            public void run() {
                drawerAppsList();
                if(drawerBrowseMode.equals("Index")){
                    alphabets();
                    initializeAlphabets(drawerAlphabets, drawerTilesAlphabets);
                    drawerTilesFrame3.setVisibility(View.VISIBLE);
                }
            }
        };
        drawerTilesHandler.postDelayed(drawerTilesRunnable, 50);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private View drawerTilesView;
    private RelativeLayout drawerTilesLayout, drawerTilesFrame1, drawerTilesFrame2, drawerTilesFrame3, drawerTilesFrame4;
    private ImageView drawerTilesIcon;
    private TextView drawerTilesText;
    private ScrollView drawerTilesScrollView;
    private LinearLayout drawerTilesAlphabets;
    private void drawerTilesView() {
        if (drawerTilesView == null) {
            drawerTilesView = inflater.inflate(R.layout.drawer_tiles, null);
            drawerTilesLayout = drawerTilesView.findViewById(R.id.drawer_tiles);
            drawerTilesFrame1 = drawerTilesView.findViewById(R.id.drawer_tiles_frame_1);
            drawerTilesFrame2 = drawerTilesView.findViewById(R.id.drawer_tiles_frame_2);
            drawerTilesFrame3 = drawerTilesView.findViewById(R.id.drawer_tiles_frame_3);
            drawerTilesFrame4 = drawerTilesView.findViewById(R.id.drawer_tiles_frame_4);
            drawerTilesIcon = drawerTilesView.findViewById(R.id.drawer_tiles_icon);
            drawerTilesText = drawerTilesView.findViewById(R.id.drawer_tiles_text);
            drawerTilesScrollView = drawerTilesView.findViewById(R.id.drawer_tiles_scroll_view);
            drawerTilesAlphabets = drawerTilesView.findViewById(R.id.drawer_tiles_alphabets);

            backgroundTypeB(this, drawerTilesFrame1, background(2), tintA, 90);
            backgroundTypeB(this, drawerTilesFrame2, background(2), tintA, 90);
            backgroundTypeA(this, drawerTilesFrame3, background(7), tintA, 3);
            imageTypeA(this, drawerTilesIcon, icon(41), tintA, 50);
            textType(this, drawerTilesText, "", tintA, Typeface.BOLD);

            customTouchModeB(drawerTilesFrame1, textC(19), 1, 0, 0);
            drawerBrowseIndex();
        }
        if (theNestDrawerLayout.findViewById(R.id.drawer_tiles) == null) {
            theNestDrawerLayout.addView(drawerTilesView);
            layoutParamsTypeA(this, drawerTilesLayout, new int[]{direction(5), direction(2)});
            setMargins(this, drawerTilesLayout, 10, 5, 20, 0);
            if (drawerAppletLayout != null && theNestDrawerLayout.findViewById(R.id.drawer_applet) != null) {
                theNestDrawerLayout.removeView(drawerTilesView);
            }
        }
    }

    private void drawerBrowseIndex(){
        if(drawerBrowseMode.equals("Index")){
            drawerTilesFrame3.setVisibility(View.GONE);
            Handler drawerTilesHandler = new Handler();
            Runnable drawerTilesRunnable = new Runnable() {
                @Override
                public void run() {
                    alphabets();
                    initializeAlphabets(drawerAlphabets, drawerTilesAlphabets);
                    drawerTilesFrame3.setVisibility(View.VISIBLE);
                }
            };
            drawerTilesHandler.postDelayed(drawerTilesRunnable, 120);
        } else {
            drawerTilesFrame3.setVisibility(View.GONE);
        }
    }

    ArrayList<String> drawerAlphabets;
    private void alphabet(String text, String value){
        if(text.startsWith(value.toLowerCase()) || text.startsWith(value.toUpperCase())){
            if(!drawerAlphabets.toString().contains(value)){
                drawerAlphabets.add(value);
            }
        }
    }

    private void alphabets(){
        if(drawerAlphabets == null){
            drawerAlphabets = new ArrayList<>();
        }
        for(GridItemsA text : gridArray.subList(0, gridArray.size())){
            alphabet(text.getLabel(), "A");
            alphabet(text.getLabel(), "B");
            alphabet(text.getLabel(), "C");
            alphabet(text.getLabel(), "D");
            alphabet(text.getLabel(), "E");
            alphabet(text.getLabel(), "F");
            alphabet(text.getLabel(), "G");
            alphabet(text.getLabel(), "H");
            alphabet(text.getLabel(), "I");
            alphabet(text.getLabel(), "J");
            alphabet(text.getLabel(), "K");
            alphabet(text.getLabel(), "L");
            alphabet(text.getLabel(), "M");
            alphabet(text.getLabel(), "A");
            alphabet(text.getLabel(), "O");
            alphabet(text.getLabel(), "P");
            alphabet(text.getLabel(), "Q");
            alphabet(text.getLabel(), "R");
            alphabet(text.getLabel(), "S");
            alphabet(text.getLabel(), "T");
            alphabet(text.getLabel(), "U");
            alphabet(text.getLabel(), "V");
            alphabet(text.getLabel(), "W");
            alphabet(text.getLabel(), "X");
            alphabet(text.getLabel(), "Y");
            alphabet(text.getLabel(), "Z");
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View drawerAlphabetsView;
    RelativeLayout drawerAlphabetsFrame;
    TextView drawerAlphabetsText;
    public static String drawerAlphabetsString = "";
    @SuppressLint("ClickableViewAccessibility")
    private void initializeAlphabets(ArrayList<String> list, LinearLayout layout){
        for (int i = 0; i < list.size(); i++) {
            drawerAlphabetsView = inflater.inflate(R.layout.linear_type_c, layout, false);
            drawerAlphabetsFrame = drawerAlphabetsView.findViewById(R.id.linear_type_c_frame);
            drawerAlphabetsText = drawerAlphabetsView.findViewById(R.id.linear_type_c_text);

            textType(this, drawerAlphabetsText, list.get(i), tintA, fontBStyle);

            int finalI = i;
            drawerAlphabetsFrame.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        touchStart(view);
                        onTouchRunnable = new Runnable() {
                            @Override
                            public void run() {
                                if(!drawerAlphabetsString.isEmpty()){
                                    drawerAlphabetsString = "";
                                    gridAdapter = new GridTypeA(TheNest.this, R.layout.grid_type_a, gridArray, TheNest.this);
                                    drawerAppsGridView.setAdapter(gridAdapter);
                                    drawerTilesText.setText(String.valueOf(gridAdapter.getCount()));
                                }
                                touchVibrate(TheNest.this, view);
                            }
                        };
                        onTouchHandler.postDelayed(onTouchRunnable, 300);
                    }
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        touchStop(view);
                        if((System.currentTimeMillis() - time) < 200){
                            if(!drawerAlphabetsString.equals(list.get(finalI))){
                                drawerAlphabetsString = list.get(finalI);
                                ArrayList<GridItemsA> temp = new ArrayList<>();
                                temp.clear();
                                for(GridItemsA items : gridArray){
                                    if(items.getLabel().startsWith(drawerAlphabetsString.toUpperCase()) || items.getLabel().startsWith(drawerAlphabetsString.toLowerCase())){
                                        temp.add(items);
                                    }
                                }
                                gridAdapter = new GridTypeA(TheNest.this, R.layout.grid_type_a, temp, TheNest.this);
                                drawerAppsGridView.setAdapter(gridAdapter);
                                drawerTilesText.setText(String.valueOf(gridAdapter.getCount()));
                            }
                        }
                    }
                    touchEnd(event, view);
                    return true;
                }
            });
            layout.addView(drawerAlphabetsView);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private View drawerAppsView;
    private RelativeLayout drawerAppsLayout;
    private GridView drawerAppsGridView;
    private void drawerAppsView() {
        if (drawerAppsView == null) {
            drawerAppsView = inflater.inflate(R.layout.drawer_apps, null);
            drawerAppsLayout = drawerAppsView.findViewById(R.id.drawer_apps);
            drawerAppsGridView = drawerAppsView.findViewById(R.id.drawer_apps_gridview);

            Handler drawerAppsHandler = new Handler();
            Runnable drawerAppsRunnable = new Runnable() {
                @Override
                public void run() {
                    drawerAppsList();
                }
            };
            drawerAppsHandler.postDelayed(drawerAppsRunnable, 100);
        }
        if (theNestDrawerLayout.findViewById(R.id.drawer_apps) == null) {
            theNestDrawerLayout.addView(drawerAppsView);
            layoutParamsTypeB(this, drawerAppsLayout, new int[]{direction(6), direction(4)}, direction(8), R.id.drawer_tooltip);
            setMargins(this, drawerAppsLayout, 20, 50, 0, 20);
            setSize(this, drawerAppsGridView, density(this, 240), size(2));
            drawerGridStyle();
        }
        if(drawerAppsCount != 0){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Intent.ACTION_MAIN, null);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    List<ResolveInfo> drawerPackages = getPackageManager().queryIntentActivities(intent, PackageManager.GET_META_DATA);
                    if(drawerPackages.size() != drawerAppsCount){
                        gridAdapter.clear();
                        gridAdapter.notifyDataSetChanged();
                        gridArray.clear();
                        drawerAppsList();
                        drawerAppletString = "";
                        if(drawerBrowseMode.equals("Index")){
                            drawerAlphabets.clear();
                            alphabets();
                            drawerTilesAlphabets.removeAllViews();
                            initializeAlphabets(drawerAlphabets, drawerTilesAlphabets);
                        }
                        if (theNestDrawerLayout.findViewById(R.id.drawer_applet) != null) {
                            drawerAppletClose();
                        }
                    }
                }
            }, 100);
        }
    }

    private void drawerGridStyle(){
        if(drawerGridStyle.equals("Tiles")){
            drawerAppsGridView.setNumColumns(2);
            drawerAppsGridView.setVerticalSpacing(density(this, 20));
            drawerAppsGridView.setHorizontalSpacing(density(this, 0));
        }
        if(drawerGridStyle.equals("Bubbles")){
            drawerAppsGridView.setNumColumns(4);
            drawerAppsGridView.setVerticalSpacing(density(this, 15));
            drawerAppsGridView.setHorizontalSpacing(density(this, 20));
        }
    }

    private ArrayList<GridItemsA> gridArray;
    private GridTypeA gridAdapter;
    int drawerAppsCount = 0;
    String gridViewString;
    private void drawerAppsList(){
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> drawerPackages = getPackageManager().queryIntentActivities(intent, PackageManager.GET_META_DATA);
        if(drawerSortingOrder.equals("Alphabetically")){
            Collections.sort(drawerPackages, new Comparator<ResolveInfo>() {
                @Override
                public int compare(ResolveInfo resolveInfo_1, ResolveInfo resolveInfo_2) {
                    return resolveInfo_1.loadLabel(getPackageManager()).toString().compareTo(resolveInfo_2.loadLabel(getPackageManager()).toString());
                }
            });
        }

        drawerAppsCount = drawerPackages.size();

        for (ResolveInfo resolveInfo : drawerPackages.subList(0, drawerPackages.size())) {
            boolean add = false;
            if(fileExist(TheNest.this, "List/Array - 03")) {
                List<String> readValues = read(TheNest.this, "List/Array - 03");
                if(!readValues.contains(resolveInfo.activityInfo.packageName)){
                    add = true;
                }
            } else {
                add = true;
            }
            if(add){
                gridViewString = (String) resolveInfo.loadLabel(getPackageManager());
                String packageName = resolveInfo.activityInfo.packageName;
                if(fileExist(this, "List/Array - 04")){
                    List<String> readValues_2 = read(this, "List/Array - 04");
                    for(String value : readValues_2){
                        if(value.startsWith(packageName)){
                            gridViewString = value.substring(packageName.length() + 3).trim();
                        }
                    }
                }
                if(gridArray == null) {
                    gridArray = new ArrayList<>();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    gridArray.add(new GridItemsA(roundedBitmap(adaptiveIcon(this, packageName, 60)), gridViewString, packageName));
                } else {
                    gridArray.add(new GridItemsA(roundedBitmap(drawableIcon(this, packageName, 60)), gridViewString, packageName));
                }
                gridAdapter = new GridTypeA(this, R.layout.grid_type_a, gridArray, this);
                drawerAppsGridView.setAdapter(gridAdapter);
                drawerTilesText.setText(String.valueOf(gridAdapter.getCount()));
            }
        }
    }

    int gridArrayPosition;
    @Override
    public void onItemPressed(String current, int position) {
        gridArrayPosition = position;
        if(isAppInstalled(this, current)){
            theNestDrawerLayout.removeView(drawerTilesView);
            drawerAppletCREATED();
            drawerAppletCurrent(current);
        } else {
            //gridArray.remove(current);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void drawerAppletPress_0(){
        if(isAppInstalled(this, drawerAppletString)){
            if (drawerAppletALayout.findViewById(R.id.drawer_applet_b) != null) {
                drawerAppletALayout.removeView(drawerAppletBView);
                buttonModeA(this, drawerAppletAFrame2, drawerAppletAIcon2, background(5), false);
            } else {
                drawerAppletB();
                buttonModeA(this, drawerAppletAFrame2, drawerAppletAIcon2, background(5), true);
            }
            if (drawerAppletALayout.findViewById(R.id.drawer_applet_c) != null) {
                drawerAppletALayout.removeView(drawerAppletCView);
                buttonModeA(this, drawerAppletAFrame3, drawerAppletAIcon3, background(5), false);
            }
        } else {
            drawerAppletClose();
        }
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    private void drawerAppletPress_1(){
        drawerAppletClose();
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    private void drawerAppletPress_2(){
        if(!drawerAppletBEditText.getText().toString().isEmpty()){
            if(!drawerAppletBString.equals(drawerAppletBEditText.getText().toString())){
                String label = drawerAppletBEditText.getText().toString().trim();
                if(!fileExist(this, "List/Array - 04")){
                    create(this, "List","/Array - 04", drawerAppletString + " - " + label);
                } else {
                    try {
                        if (new Scanner(new File(getFilesDir(), "List/Array - 04")).useDelimiter("\\Z").next().contains(drawerAppletString)) {
                            edit(this, "List/Array - 04", drawerAppletString + " - " + defaultName, drawerAppletString + " - " + label);
                        } else {
                            create(this, "List","/Array - 04", drawerAppletString + " - " + label);
                        }
                    } catch (Exception e) {}
                }
                drawerAppletCurrent(drawerAppletString);
                gridAdapter.getItem(gridArrayPosition).setLabel(label);
                gridAdapter.notifyDataSetChanged();
            }
        }
    }

    private void drawerAppletPress_3(){
        String label = "";
        try {
            label = (String) getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(drawerAppletString, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(!defaultName.equals(label)){
            edit(this, "List/Array - 04", drawerAppletString + " - " + defaultName, drawerAppletString + " - " + label);
            drawerAppletCurrent(drawerAppletString);
            gridAdapter.getItem(gridArrayPosition).setLabel(label);
            gridAdapter.notifyDataSetChanged();
        }
    }

    private void drawerAppletPress_4(){
        if(isAppInstalled(this, drawerAppletString)){
            Methods.startActivity(this, drawerAppletString, Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        } else {
            drawerAppletClose();
        }
    }

    private void drawerAppletPress_5(){
        if(isAppInstalled(this, drawerAppletString)){
            Methods.startActivity(this, drawerAppletString, Intent.ACTION_DELETE);
        } else {
            drawerAppletClose();
        }
    }

    private void drawerAppletPress_6(){
        if(isAppInstalled(this, drawerAppletString)){
            create(this, "List", "/Array - 03", drawerAppletString);
            ////
            gridArray.remove(gridArrayPosition);
            gridAdapter.notifyDataSetChanged();
            drawerTilesText.setText(String.valueOf(gridAdapter.getCount()));
            drawerAppletClose();
        } else {
            drawerAppletClose();
        }
    }

    private void drawerAppletPress_7(){
        boolean permissionGranted = false;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            if(permission(this, "android.permission.WRITE_EXTERNAL_STORAGE") &&
                    permission(this, "android.permission.MANAGE_EXTERNAL_STORAGE")){
                permissionGranted = true;
            }
        } else{
            if(permission(this, "android.permission.WRITE_EXTERNAL_STORAGE")){
                permissionGranted = true;
            }
        }
        if(permissionGranted){
            if(isAppInstalled(this, drawerAppletString)){
                try {
                    ApplicationInfo ai = getPackageManager().getApplicationInfo(drawerAppletString, 0);
                    String app = ai.loadLabel(getPackageManager()).toString();

                    File f1 = new File( ai.publicSourceDir);
                    File f2;

                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                        f2 = new File(getExternalFilesDir(null).getAbsolutePath() + "/SimplifiCc/Apps");
                    } else{
                        f2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SimplifiCc/Apps");
                    }

                    if(!f2.exists())
                        f2.mkdirs();

                    File f3 = new File(f2.getPath() + "/" + app + ".apk");

                    if(!threadState){
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                threadState = true;
                                try {
                                    f3.createNewFile();
                                    InputStream in = new FileInputStream(f1);
                                    OutputStream out = new FileOutputStream(f3);
                                    byte[] bytes = new byte[1024];
                                    int i;
                                    while ((i = in.read(bytes)) > 0){
                                        out.write(bytes, 0, i);
                                    }
                                    in.close();
                                    out.close();

                                    threadState = false;
                                    //runOnUiThread(new Runnable() {
                                    //    public void run() {
                                    //
                                    //    }
                                    //});
                                } catch (Exception e){
                                    threadState = false;
                                }
                            }
                        }).start();
                    }
                    touchTip(this, textC(20), 1);
                } catch (Exception e) {
                    //Storage Permission page
                }
            } else {
                drawerAppletClose();
            }
        } else {
            //Storage Permission page
        }
    }

    private void drawerAppletPress_8(){
        if(isAppInstalled(this, drawerAppletString)){
            if (drawerAppletALayout.findViewById(R.id.drawer_applet_b) != null) {
                drawerAppletALayout.removeView(drawerAppletBView);
                buttonModeA(this, drawerAppletAFrame2, drawerAppletAIcon2, background(5), false);
            }
            if (drawerAppletALayout.findViewById(R.id.drawer_applet_c) != null) {
                drawerAppletALayout.removeView(drawerAppletCView);
                buttonModeA(this, drawerAppletAFrame3, drawerAppletAIcon3, background(5), false);
            } else {
                drawerAppletC();
                buttonModeA(this, drawerAppletAFrame3, drawerAppletAIcon3, background(5), true);
            }
        } else {
            drawerAppletClose();
        }
    }

    // ------------------------------------------------------------------- //

    private void drawerAppletRESUMED(){
        if(drawerAppletString != null && !drawerAppletString.isEmpty() && !isAppInstalled(this, drawerAppletString)){
            gridAdapter.remove(gridAdapter.getItem(gridArrayPosition));
            gridAdapter.notifyDataSetChanged();
            for(GridItemsA items : gridArray){
                if(items.getAppPackage().matches(drawerAppletString)){
                    gridArray.remove(items);
                }
            }
            if(!drawerAlphabetsString.isEmpty()){
                drawerAlphabetsString = "";
                gridAdapter = new GridTypeA(this, R.layout.grid_type_a, gridArray, this);
                drawerAppsGridView.setAdapter(gridAdapter);
            }
            drawerTilesText.setText(String.valueOf(gridAdapter.getCount()));

            drawerAppletClose();

            drawerAlphabets.clear();
            alphabets();
            drawerTilesAlphabets.removeAllViews();
            initializeAlphabets(drawerAlphabets, drawerTilesAlphabets);

            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> drawerPackages = getPackageManager().queryIntentActivities(intent, PackageManager.GET_META_DATA);
            drawerAppsCount = drawerPackages.size();
        }
    }

    // ------------------------------------------------------------------- //

    private View drawerAppletView;
    private RelativeLayout drawerAppletLayout;
    private void drawerAppletCREATED() {
        if (drawerAppletView == null) {
            drawerAppletView = inflater.inflate(R.layout.drawer_applet, null);
            drawerAppletLayout = drawerAppletView.findViewById(R.id.drawer_applet);
        }
        if (theNestDrawerLayout.findViewById(R.id.drawer_applet) == null) {
            theNestDrawerLayout.addView(drawerAppletView);
            layoutParamsTypeA(this, drawerAppletLayout, new int[]{direction(5), direction(2)});
            setSize(this, drawerAppletLayout, size(1), size(1));
            setMargins(this, drawerAppletLayout, 20, 20, 20, 20);
            drawerAppletA();
        }
    }

    // ------------------------------------------------------------------- //

    private View drawerAppletAView;
    private RelativeLayout drawerAppletALayout, drawerAppletAFrame1, drawerAppletAFrame2, drawerAppletAFrame3;
    private ImageView drawerAppletAIcon1, drawerAppletAIcon2, drawerAppletAIcon3, drawerAppletAIcon4;
    private TextView drawerAppletAText;
    private void drawerAppletA() {
        if (drawerAppletAView == null) {
            drawerAppletAView = inflater.inflate(R.layout.drawer_applet_a, null);
            drawerAppletALayout = drawerAppletAView.findViewById(R.id.drawer_applet_a);
            drawerAppletAFrame1 = drawerAppletAView.findViewById(R.id.drawer_applet_a_frame_1);
            drawerAppletAFrame2 = drawerAppletAView.findViewById(R.id.drawer_applet_a_frame_2);
            drawerAppletAFrame3 = drawerAppletAView.findViewById(R.id.drawer_applet_a_frame_3);
            drawerAppletAText = drawerAppletAView.findViewById(R.id.drawer_applet_a_text);
            drawerAppletAIcon1 = drawerAppletAView.findViewById(R.id.drawer_applet_a_icon_1);
            drawerAppletAIcon2 = drawerAppletAView.findViewById(R.id.drawer_applet_a_icon_2);
            drawerAppletAIcon3 = drawerAppletAView.findViewById(R.id.drawer_applet_a_icon_3);
            drawerAppletAIcon4 = drawerAppletAView.findViewById(R.id.drawer_applet_a_icon_4);

            imageTypeA(this, drawerAppletAIcon2, icon(45), tintA, 50);
            imageTypeA(this, drawerAppletAIcon3, icon(30), tintA, 50);
            imageTypeA(this, drawerAppletAIcon4, icon(33), tintA, 50);

            backgroundTypeA(this, drawerAppletAFrame1, background(9), tintA, 3);
            backgroundTypeA(this, drawerAppletAFrame2, background(5), tintA, 3);
            backgroundTypeA(this, drawerAppletAFrame3, background(5), tintA, 3);

            textType(this, drawerAppletAText, "", tintA, fontAStyle);

            customTouchModeB(drawerAppletAFrame2, textC(14), 1, 1,0);
            customTouchModeB(drawerAppletAFrame3, textC(9), 1, 1,8);
            customTouchModeB(drawerAppletAIcon4, textC(21), 1, 1,1);
        }
        if (drawerAppletLayout.findViewById(R.id.drawer_applet_a) == null) {
            drawerAppletLayout.addView(drawerAppletAView);
            layoutParamsTypeA(this, drawerAppletALayout, new int[]{direction(2)});
        }
    }

    private String drawerAppletString;
    private String defaultName;
    private void drawerAppletCurrent(String packageName){
        layoutParamsTypeB(this, drawerEdgeA, new int[]{direction(3), direction(5)}, direction(7), R.id.drawer_applet);
        layoutParamsTypeB(this, drawerEdgeB, new int[]{direction(4), direction(5)}, direction(8), R.id.drawer_applet);
        drawerAppletString = packageName;
        try {
            defaultName = (String) getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(packageName, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(fileExist(this, "List/Array - 04")){
            List<String> readValues = read(this, "List/Array - 04");
            for(String value : readValues){
                if(value.startsWith(packageName)){
                    defaultName = value.substring(packageName.length() + 3).trim();
                }
            }
        }
        drawerAppletAText.setText(defaultName);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            drawerAppletAIcon1.setImageBitmap(roundedBitmap(adaptiveIcon(this, packageName, 50)));
        } else {
            drawerAppletAIcon1.setImageBitmap(roundedBitmap(drawableIcon(this, packageName, 50)));
        }

        if (drawerAppletLayout.findViewById(R.id.drawer_applet_b) != null) {
            drawerCurrentLabel();
        }
        if (drawerAppletLayout.findViewById(R.id.drawer_applet_c) != null) {
            drawerCurrentType();
        }
    }

    private void drawerAppletClose(){
        layoutParamsTypeB(this, drawerEdgeA, new int[]{direction(3), direction(5)}, direction(7), R.id.drawer_tiles);
        layoutParamsTypeB(this, drawerEdgeB, new int[]{direction(4), direction(5)}, direction(8), R.id.drawer_tiles);
        drawerAppletString = "";
        setMargins(this, drawerAppletLayout, 0, 0, 0, 0);
        if (drawerAppletALayout.findViewById(R.id.drawer_applet_b) != null) {
            drawerAppletALayout.removeView(drawerAppletBView);
            buttonModeA(this, drawerAppletAFrame2, drawerAppletAIcon2,  background(5), false);
        }
        if (drawerAppletALayout.findViewById(R.id.drawer_applet_c) != null) {
            drawerAppletALayout.removeView(drawerAppletCView);
            buttonModeA(this, drawerAppletAFrame3, drawerAppletAIcon3,  background(5), false);
        }
        drawerAppletALayout.removeView(drawerAppletCView);
        theNestDrawerLayout.removeView(drawerAppletView);
        if (theNestDrawerLayout.findViewById(R.id.drawer_tiles) == null) {
            theNestDrawerLayout.addView(drawerTilesView);
        }
    }

    // ------------------------------------------------------------------- //

    private View drawerAppletBView;
    private RelativeLayout drawerAppletBLayout, drawerAppletBFrame1, drawerAppletBFrame2, drawerAppletBFrame3, drawerAppletBFrame4;
    private EditText drawerAppletBEditText;
    private ImageView drawerAppletBIcon1, drawerAppletBIcon2, drawerAppletBAngle;
    private void drawerAppletB() {
        if (drawerAppletBView == null) {
            drawerAppletBView = inflater.inflate(R.layout.drawer_applet_b, null);
            drawerAppletBLayout = drawerAppletBView.findViewById(R.id.drawer_applet_b);
            drawerAppletBFrame1 = drawerAppletBView.findViewById(R.id.drawer_applet_b_frame_1);
            drawerAppletBFrame2 = drawerAppletBView.findViewById(R.id.drawer_applet_b_frame_2);
            drawerAppletBFrame3 = drawerAppletBView.findViewById(R.id.drawer_applet_b_frame_3);
            drawerAppletBFrame4 = drawerAppletBView.findViewById(R.id.drawer_applet_b_frame_4);
            drawerAppletBEditText = drawerAppletBView.findViewById(R.id.drawer_applet_b_edit_text);
            drawerAppletBAngle = drawerAppletBView.findViewById(R.id.drawer_applet_b_angle);
            drawerAppletBIcon1 = drawerAppletBView.findViewById(R.id.drawer_applet_b_icon_1);
            drawerAppletBIcon2 = drawerAppletBView.findViewById(R.id.drawer_applet_b_icon_2);

            backgroundTypeC(this, drawerAppletBFrame1, background(3), tintA);
            backgroundTypeA(this, drawerAppletBFrame2, background(5), tintB, 3);
            backgroundTypeA(this, drawerAppletBFrame3, background(5), tintB, 3);
            backgroundTypeA(this, drawerAppletBFrame4, background(7), tintB, 3);

            imageTypeA(this, drawerAppletBAngle, drawable(2), tintA, 30);
            imageTypeA(this, drawerAppletBIcon1, icon(31), tintB, 50);
            imageTypeA(this, drawerAppletBIcon2, icon(42), tintB, 50);

            customTypeB(this, drawerAppletBEditText, textA(7), tintB, fontBStyle);

            customTouchModeB(drawerAppletBFrame2, textC(13),1,1,2);
            customTouchModeB(drawerAppletBFrame3, textC(22),1,1,3);
        }
        if (drawerAppletALayout.findViewById(R.id.drawer_applet_b) == null) {
            drawerAppletALayout.addView(drawerAppletBView);
            layoutParamsTypeC(this, drawerAppletBLayout, new int[]{direction(1)},
                    direction(10), R.id.drawer_applet_a_frame_2,
                    direction(12), R.id.drawer_applet_a_frame_2);
            setSize(this, drawerAppletBLayout, size(1), size(1));
            setMargins(this, drawerAppletBLayout, 0, -10, 10, 0);
            drawerCurrentLabel();
        }
    }

    String drawerAppletBString;
    private boolean threadState = false;
    private void drawerCurrentLabel() {
        drawerAppletBEditText.setText(defaultName);
        drawerAppletBString = defaultName;
    }

    // ------------------------------------------------------------------- //

    private View drawerAppletCView;
    private RelativeLayout drawerAppletCLayout, drawerAppletCFrame1, drawerAppletCFrame2, drawerAppletCFrame3, drawerAppletCFrame4, drawerAppletCFrame5;
    private ImageView drawerAppletCIcon1, drawerAppletCIcon2, drawerAppletCIcon3, drawerAppletCIcon4, drawerAppletCAngle;
    private void drawerAppletC() {
        if (drawerAppletCView == null) {
            drawerAppletCView = inflater.inflate(R.layout.drawer_applet_c, null);
            drawerAppletCLayout = drawerAppletCView.findViewById(R.id.drawer_applet_c);
            drawerAppletCFrame1 = drawerAppletCView.findViewById(R.id.drawer_applet_c_frame_1);
            drawerAppletCFrame2 = drawerAppletCView.findViewById(R.id.drawer_applet_c_frame_2);
            drawerAppletCFrame3 = drawerAppletCView.findViewById(R.id.drawer_applet_c_frame_3);
            drawerAppletCFrame4 = drawerAppletCView.findViewById(R.id.drawer_applet_c_frame_4);
            drawerAppletCFrame5 = drawerAppletCView.findViewById(R.id.drawer_applet_c_frame_5);
            drawerAppletCAngle = drawerAppletCView.findViewById(R.id.drawer_applet_c_angle);
            drawerAppletCIcon1 = drawerAppletCView.findViewById(R.id.drawer_applet_c_icon_1);
            drawerAppletCIcon2 = drawerAppletCView.findViewById(R.id.drawer_applet_c_icon_2);
            drawerAppletCIcon3 = drawerAppletCView.findViewById(R.id.drawer_applet_c_icon_3);
            drawerAppletCIcon4 = drawerAppletCView.findViewById(R.id.drawer_applet_c_icon_4);

            backgroundTypeC(this, drawerAppletCFrame1, background(3), tintA);
            backgroundTypeA(this, drawerAppletCFrame2, background(5), tintB, 3);
            backgroundTypeA(this, drawerAppletCFrame3, background(5), tintB, 3);
            backgroundTypeA(this, drawerAppletCFrame4, background(5), tintB, 3);
            backgroundTypeA(this, drawerAppletCFrame5, background(5), tintB, 3);

            imageTypeA(this, drawerAppletCAngle, drawable(2), tintA, 30);
            imageTypeA(this, drawerAppletCIcon1, icon(40), tintB, 50);
            imageTypeA(this, drawerAppletCIcon2, icon(32), tintB, 50);
            imageTypeA(this, drawerAppletCIcon3, icon(38), tintB, 50);
            imageTypeA(this, drawerAppletCIcon4, icon(34), tintB, 50);

            customTouchModeB(drawerAppletCFrame2, textC(11), 1, 1,4);
            customTouchModeB(drawerAppletCFrame3, textC(12), 1, 1,5);
            customTouchModeB(drawerAppletCFrame4, textC(17), 1, 1,6);
            customTouchModeB(drawerAppletCFrame5, textC(23), 1, 1,7);
        }
        if (drawerAppletALayout.findViewById(R.id.drawer_applet_c) == null) {
            drawerAppletALayout.addView(drawerAppletCView);
            layoutParamsTypeC(this, drawerAppletCLayout, new int[]{direction(1)},
                    direction(10), R.id.drawer_applet_a_frame_3,
                    direction(12), R.id.drawer_applet_a_frame_3);
            setSize(this, drawerAppletCLayout, size(1), size(1));
            setMargins(this, drawerAppletCLayout, 0, -45, 10, 0);
            drawerCurrentType();
        }
    }

    private void drawerCurrentType(){
        if(systemApp(this, drawerAppletString)){
            drawerAppletCFrame3.setVisibility(View.GONE);
        } else {
            drawerAppletCFrame3.setVisibility(View.VISIBLE);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    View theNestSettingsView;
    RelativeLayout theNestSettingsLayout;

    private String settingsTab;
    private String miscListStyle;
    private String homeListStyle;
    private void settingsConfigurations(){
        if(!fileExist(this, "Settings/Configurations")){
            create(this, "Settings","/Configurations", "# Settings Configurations...");
            create(this, "Settings","/Configurations", "Settings Tab - About");
            create(this, "Settings","/Configurations", "Misc List Style - Square");
            create(this, "Settings","/Configurations", "Home List Style - Hexagon");
            create(this, "Settings","/Configurations", " ");
            create(this, "Settings","/Configurations", "--------------------");
            create(this, "Settings","/Configurations", " ");
        }

        List<String> readValues = read(this, "Settings/Configurations");
        settingsTab = readValues.get(1).substring(15).trim();
        miscListStyle = readValues.get(2).substring(18).trim();
        homeListStyle = readValues.get(3).substring(18).trim();
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsScreenSTATE_A(){
        if(settingsDrawerLayout != null && settingsDrawerLayout.findViewById(R.id.settings_drawer_b) != null)
            hiddenApps();
        if(settingsHomeLayout != null && settingsHomeLayout.findViewById(R.id.settings_home_b) != null)
            settingsHomeWidgets();
        if(settingsHomeLayout != null && settingsHomeLayout.findViewById(R.id.settings_home_d) != null)
            settingsHomeWallpaper();
        if(settingsHomeLayout != null && settingsHomeLayout.findViewById(R.id.settings_home_e) != null)
            settingsHomeFolder();
        if(settingsHomeLayout != null && settingsHomeLayout.findViewById(R.id.settings_home_f) != null)
            settingsHomeStatus();
        if(settingsHomeLayout != null && settingsHomeLayout.findViewById(R.id.settings_home_h) != null)
            settingsHomeShortcut();
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsButtonsPress_0(){
        if(theNestSettingsLayout.findViewById(R.id.settings_about) == null){
            settingsAboutView();
        }
        theNestSettingsLayout.removeView(settingsMiscView);
        theNestSettingsLayout.removeView(settingsDrawerView);
        theNestSettingsLayout.removeView(settingsHomeView);
        buttonModeB(TheNest.this, settingsButtonsFrame1, settingsButtonsText1, background(5), true);
        buttonModeA(TheNest.this, settingsButtonsFrame2, settingsButtonsIcon1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame3, settingsButtonsIcon2, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame4, settingsButtonsIcon3, background(5), false);
    }

    private void settingsButtonsPress_1(){
        theNestSettingsLayout.removeView(settingsAboutView);
        if(theNestSettingsLayout.findViewById(R.id.settings_misc) == null) {
            settingsMiscView();
        }
        theNestSettingsLayout.removeView(settingsDrawerView);
        theNestSettingsLayout.removeView(settingsHomeView);
        buttonModeB(TheNest.this, settingsButtonsFrame1, settingsButtonsText1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame2, settingsButtonsIcon1, background(5), true);
        buttonModeA(TheNest.this, settingsButtonsFrame3, settingsButtonsIcon2, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame4, settingsButtonsIcon3, background(5), false);
    }

    private void settingsButtonsPress_2(){
        theNestSettingsLayout.removeView(settingsAboutView);
        theNestSettingsLayout.removeView(settingsMiscView);
        if(theNestSettingsLayout.findViewById(R.id.settings_drawer) == null) {
            settingsDrawer();
        }
        theNestSettingsLayout.removeView(settingsHomeView);
        buttonModeB(TheNest.this, settingsButtonsFrame1, settingsButtonsText1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame2, settingsButtonsIcon1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame3, settingsButtonsIcon2, background(5), true);
        buttonModeA(TheNest.this, settingsButtonsFrame4, settingsButtonsIcon3, background(5), false);
    }

    private void settingsButtonsPress_3(){
        theNestSettingsLayout.removeView(settingsAboutView);
        theNestSettingsLayout.removeView(settingsMiscView);
        theNestSettingsLayout.removeView(settingsDrawerView);
        if(theNestSettingsLayout.findViewById(R.id.settings_home) == null) {
            settingsHome();
        }
        buttonModeB(TheNest.this, settingsButtonsFrame1, settingsButtonsText1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame2, settingsButtonsIcon1, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame3, settingsButtonsIcon2, background(5), false);
        buttonModeA(TheNest.this, settingsButtonsFrame4, settingsButtonsIcon3, background(5), true);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsButtonsView;
    RelativeLayout settingsButtonsLayout, settingsButtonsFrame1, settingsButtonsFrame2, settingsButtonsFrame3,
            settingsButtonsFrame4;
    ImageView settingsButtonsIcon1, settingsButtonsIcon2, settingsButtonsIcon3;
    TextView settingsButtonsText1, settingsButtonsText2;
    private void settingsButtonsCREATED(){
        if(settingsButtonsView == null){
            settingsButtonsView = inflater.inflate(R.layout.settings_buttons, null);
            settingsButtonsLayout = settingsButtonsView.findViewById(R.id.settings_buttons);
            settingsButtonsFrame1 = settingsButtonsView.findViewById(R.id.settings_buttons_frame_1);
            settingsButtonsFrame2 = settingsButtonsView.findViewById(R.id.settings_buttons_frame_2);
            settingsButtonsFrame3 = settingsButtonsView.findViewById(R.id.settings_buttons_frame_3);
            settingsButtonsFrame4 = settingsButtonsView.findViewById(R.id.settings_buttons_frame_4);
            settingsButtonsIcon1 = settingsButtonsView.findViewById(R.id.settings_buttons_icon_1);
            settingsButtonsIcon2 = settingsButtonsView.findViewById(R.id.settings_buttons_icon_2);
            settingsButtonsIcon3 = settingsButtonsView.findViewById(R.id.settings_buttons_icon_3);
            settingsButtonsText1 = settingsButtonsView.findViewById(R.id.settings_buttons_text_1);
            settingsButtonsText2 = settingsButtonsView.findViewById(R.id.settings_buttons_text_2);

            backgroundTypeA(this, settingsButtonsFrame1, background(5), tintA, 3);
            backgroundTypeA(this, settingsButtonsFrame2, background(5), tintA, 3);
            backgroundTypeA(this, settingsButtonsFrame3, background(5), tintA, 3);
            backgroundTypeA(this, settingsButtonsFrame4, background(5), tintA, 3);

            textType(this, settingsButtonsText1, textA(6), tintA, Typeface.BOLD);
            textType(this, settingsButtonsText2, textA(9), tintA, Typeface.BOLD);

            imageTypeA(this, settingsButtonsIcon1, icon(29), tintA, 65);
            imageTypeA(this, settingsButtonsIcon2, icon(36), tintA, 50);
            imageTypeA(this, settingsButtonsIcon3, icon(39), tintA, 50);

            customTouchModeB(settingsButtonsFrame1, "", 2, 0,0);
            customTouchModeB(settingsButtonsFrame2, "", 2, 0,1);
            customTouchModeB(settingsButtonsFrame3, "", 2, 0,2);
            customTouchModeB(settingsButtonsFrame4, "", 2, 0,3);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_buttons) == null){
            theNestSettingsLayout.addView(settingsButtonsView);
            layoutParamsTypeA(this, settingsButtonsLayout, new int[]{direction(3), direction(5)});
            setSize(this, settingsButtonsLayout, size(1), size(1));
            setMargins(this, settingsButtonsLayout, 20, 0, 20, 20);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    View settingsTooltipView;
    public static RelativeLayout settingsTooltipLayout;
    public static TextView settingsTooltipText;
    private void settingsTooltipCREATED(){
        if(settingsTooltipView == null){
            settingsTooltipView = inflater.inflate(R.layout.settings_tooltip, null);
            settingsTooltipLayout = settingsTooltipView.findViewById(R.id.settings_tooltip);
            settingsTooltipText = settingsTooltipView.findViewById(R.id.settings_tooltip_text);

            backgroundTypeC(this, settingsTooltipLayout, background(3), tintA);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_tooltip) == null){
            theNestSettingsLayout.addView(settingsTooltipView);
            layoutParamsTypeA(this, settingsTooltipLayout, new int[]{direction(4), direction(5)});
            settingsTooltipStateA(this);
        }
    }

    private void settingsTooltipSTOPPED(){
        try {
            settingsTooltipStateA(homeTooltipLayout.getContext());
            settingsTooltipHandler.removeCallbacks(settingsTooltipRunnable);
        } catch (Exception e){}
    }

    public static void settingsTooltipStateA(Context context){
        settingsTooltipText.setText("");
        setMargins(context, settingsTooltipLayout, 0, 40, 0, 0);
        setSize(context, settingsTooltipLayout, 0, 0);
    }

    public static void settingsTooltipStateB(Context context, String tooltip){
        textType(context, settingsTooltipText, tooltip, tintB, fontAStyle);
        setMargins(context, settingsTooltipLayout, 0, 20, 20, 0);
        setSize(context, settingsTooltipLayout, size(1), size(1));
    }

    public static Handler settingsTooltipHandler= new Handler();
    public static Runnable settingsTooltipRunnable = new Runnable() {
        @Override
        public void run() {
            settingsTooltipStateA(settingsTooltipLayout.getContext());
        }
    };

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsPanelCREATED(){
        settingsEdgeAView();
        settingsEdgeBView();
        if(settingsTab.equals("About")){
            settingsButtonsPress_0();
        }
        if(settingsTab.equals("Misc")){
            settingsButtonsPress_1();
        }
        if(settingsTab.equals("Drawer")){
            settingsButtonsPress_2();
        }
        if(settingsTab.equals("Home")){
            settingsButtonsPress_3();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsEdgeAView;
    RelativeLayout settingsEdgeALayout, settingsEdgeAFrame;
    ImageView settingsEdgeALine1, settingsEdgeALine2;
    TextView settingsEdgeAText;
    private void settingsEdgeAView(){
        if(settingsEdgeAView == null){
            settingsEdgeAView = inflater.inflate(R.layout.settings_edge_a, null);
            settingsEdgeALayout = settingsEdgeAView.findViewById(R.id.settings_edge_a);
            settingsEdgeAFrame = settingsEdgeAView.findViewById(R.id.settings_edge_a_frame);
            settingsEdgeALine1 = settingsEdgeAView.findViewById(R.id.settings_edge_a_line_1);
            settingsEdgeALine2 = settingsEdgeAView.findViewById(R.id.settings_edge_a_line_2);
            settingsEdgeAText = settingsEdgeAView.findViewById(R.id.settings_edge_a_text);

            backgroundTypeA(this, settingsEdgeAFrame, background(8), tintA, 3);
            imageTypeB(this, settingsEdgeALine1, background(6), tintA);
            imageTypeB(this, settingsEdgeALine2, background(6), tintA);
            textType(this, settingsEdgeAText, "", tintA, fontAStyle);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_edge_a) == null){
            theNestSettingsLayout.addView(settingsEdgeAView);
            layoutParamsTypeB(this, settingsEdgeALayout, new int[]{direction(6)}, direction(8), R.id.settings_buttons);
            setMargins(this, settingsEdgeALayout, 20, 0, 0, 20);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsEdgeBView;
    RelativeLayout settingsEdgeBLayout;
    ImageView settingsEdgeBLine1, settingsEdgeBLine2, settingsEdgeBDot1, settingsEdgeBDot2,
            settingsEdgeBSquare, settingsEdgeBCylinder1, settingsEdgeBCylinder2;
    private void settingsEdgeBView(){
        if(settingsEdgeBView == null){
            settingsEdgeBView = inflater.inflate(R.layout.settings_edge_b, null);
            settingsEdgeBLayout = settingsEdgeBView.findViewById(R.id.settings_edge_b);
            settingsEdgeBLine1 = settingsEdgeBView.findViewById(R.id.settings_edge_b_line_1);
            settingsEdgeBLine2 = settingsEdgeBView.findViewById(R.id.settings_edge_b_line_2);
            settingsEdgeBDot1 = settingsEdgeBView.findViewById(R.id.settings_edge_b_dot_1);
            settingsEdgeBDot2 = settingsEdgeBView.findViewById(R.id.settings_edge_b_dot_2);
            settingsEdgeBCylinder1 = settingsEdgeBView.findViewById(R.id.settings_edge_b_cylinder_1);
            settingsEdgeBCylinder2 = settingsEdgeBView.findViewById(R.id.settings_edge_b_cylinder_2);
            settingsEdgeBSquare = settingsEdgeBView.findViewById(R.id.settings_edge_b_square);

            imageTypeB(this, settingsEdgeBLine1, background(6), tintA);
            imageTypeB(this, settingsEdgeBLine2, background(6), tintA);
            imageTypeB(this, settingsEdgeBDot1, background(4), tintA);
            imageTypeB(this, settingsEdgeBDot2, background(4), tintA);
            imageTypeB(this, settingsEdgeBCylinder1, background(6), tintA);
            imageTypeB(this, settingsEdgeBCylinder2, background(6), tintA);
            backgroundTypeA(this, settingsEdgeBSquare, background(8), tintA, 3);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_edge_b) == null){
            theNestSettingsLayout.addView(settingsEdgeBView);
            layoutParamsTypeA(this, settingsEdgeBLayout, new int[]{direction(4), direction(6)});
            setMargins(this, settingsEdgeBLayout, 0, 20, 0, 20);
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsAboutPress_0(){
        settingsAboutText1.setText(textC(24));
        settingsAboutText2.setText(textC(25));
    }

    private void settingsAboutPress_1(){
        settingsAboutText1.setText(textC(26));
        settingsAboutText2.setText(textC(27));
    }

    private void settingsAboutPress_2(){
        if(isAppInstalled(TheNest.this, "com.google.android.gm")){
            Intent intent = new Intent(Intent.ACTION_SEND);
            String email = "simplicdeveloper2062@gmail.com";
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT,"(^o^)/ Over Here...");
            intent.putExtra(Intent.EXTRA_TEXT,"Is something wrong (*.*)...");
            intent.setType("text/html");
            intent.setPackage("com.google.android.gm");
            startActivity(Intent.createChooser(intent, "Send mail"));
        } else {
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com"));
            //try {
            //    startActivity(intent);
            //} catch (Exception e){
            //    touchTip(this, text(39), 2);
            //}
            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setText("simplicdeveloper2062@gmail.com");
            } else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Email Copied", "simplicdeveloper2062@gmail.com");
                clipboard.setPrimaryClip(clip);
            }
            touchTip(this, textC(28), 2);
        }
    }

    private void settingsAboutPress_3(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/SimpliC-Developer"));
        try {
            startActivity(intent);
        } catch (Exception e){
            //touchTip(this, text(39), 2);
            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboard.setText("https://github.com/SimpliC-Developer");
            } else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Linnk Copied", "https://github.com/SimpliC-Developer");
                clipboard.setPrimaryClip(clip);
            }
            touchTip(this, textC(29), 2);
        }
    }

    private void settingsAboutPress_4(){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsAboutView;
    RelativeLayout settingsAboutLayout, settingsAboutFrame1, settingsAboutFrame2, settingsAboutFrame3, settingsAboutFrame4;
    ScrollView settingsAboutScrollView;
    TextView settingsAboutText1,settingsAboutText2, settingsAboutText3, settingsAboutText4,
            settingsAboutText5, settingsAboutText6, settingsAboutText7, settingsAboutText8,
            settingsAboutText9, settingsAboutText10, settingsAboutText11, settingsAboutText12,
            settingsAboutText13, settingsAboutText14, settingsAboutText15, settingsAboutText16,
            settingsAboutText17, settingsAboutText18, settingsAboutText19, settingsAboutText20,
            settingsAboutText21, settingsAboutText22, settingsAboutText23;
    ImageView settingsAboutIcon1, settingsAboutIcon2, settingsAboutIcon3;
    private void settingsAboutView(){
        if(settingsAboutView == null){
            settingsAboutView = inflater.inflate(R.layout.settings_about, null);
            settingsAboutLayout = settingsAboutView.findViewById(R.id.settings_about);
            settingsAboutScrollView = settingsAboutView.findViewById(R.id.settings_about_scroll_view);
            settingsAboutIcon1 = settingsAboutView.findViewById(R.id.settings_about_icon_1);
            settingsAboutIcon2 = settingsAboutView.findViewById(R.id.settings_about_icon_2);
            settingsAboutIcon3 = settingsAboutView.findViewById(R.id.settings_about_icon_3);
            settingsAboutFrame1 = settingsAboutView.findViewById(R.id.settings_about_frame_1);
            settingsAboutFrame2 = settingsAboutView.findViewById(R.id.settings_about_frame_2);
            settingsAboutFrame3 = settingsAboutView.findViewById(R.id.settings_about_frame_3);
            settingsAboutFrame4 = settingsAboutView.findViewById(R.id.settings_about_frame_4);
            settingsAboutText1 = settingsAboutView.findViewById(R.id.settings_about_text_1);
            settingsAboutText2 = settingsAboutView.findViewById(R.id.settings_about_text_2);
            settingsAboutText3 = settingsAboutView.findViewById(R.id.settings_about_text_3);
            settingsAboutText4 = settingsAboutView.findViewById(R.id.settings_about_text_4);
            settingsAboutText5 = settingsAboutView.findViewById(R.id.settings_about_text_5);
            settingsAboutText6 = settingsAboutView.findViewById(R.id.settings_about_text_6);
            settingsAboutText7 = settingsAboutView.findViewById(R.id.settings_about_text_7);
            settingsAboutText8 = settingsAboutView.findViewById(R.id.settings_about_text_8);
            settingsAboutText9 = settingsAboutView.findViewById(R.id.settings_about_text_9);
            settingsAboutText10 = settingsAboutView.findViewById(R.id.settings_about_text_10);
            settingsAboutText11 = settingsAboutView.findViewById(R.id.settings_about_text_11);
            settingsAboutText12 = settingsAboutView.findViewById(R.id.settings_about_text_12);
            settingsAboutText13 = settingsAboutView.findViewById(R.id.settings_about_text_13);
            settingsAboutText14 = settingsAboutView.findViewById(R.id.settings_about_text_14);
            settingsAboutText15 = settingsAboutView.findViewById(R.id.settings_about_text_15);
            settingsAboutText16 = settingsAboutView.findViewById(R.id.settings_about_text_16);
            settingsAboutText17 = settingsAboutView.findViewById(R.id.settings_about_text_17);
            settingsAboutText18 = settingsAboutView.findViewById(R.id.settings_about_text_18);
            settingsAboutText19 = settingsAboutView.findViewById(R.id.settings_about_text_19);
            settingsAboutText20 = settingsAboutView.findViewById(R.id.settings_about_text_20);
            settingsAboutText21 = settingsAboutView.findViewById(R.id.settings_about_text_21);
            settingsAboutText22 = settingsAboutView.findViewById(R.id.settings_about_text_22);
            settingsAboutText23 = settingsAboutView.findViewById(R.id.settings_about_text_23);

            backgroundTypeC(this, settingsAboutLayout, background(3), tintA);

            Handler settingsAboutHandler = new Handler();
            Runnable settingsAboutRunnable = new Runnable() {
                @Override
                public void run() {
                    backgroundTypeA(TheNest.this, settingsAboutFrame2, background(8), tintB, 3);
                    backgroundTypeA(TheNest.this, settingsAboutFrame3, background(8), tintB, 3);
                    backgroundTypeA(TheNest.this, settingsAboutFrame4, background(9), tintB, 3);

                    imageTypeA(TheNest.this, settingsAboutIcon1, icon(17), R.color.transparent, 120);
                    imageTypeA(TheNest.this, settingsAboutIcon2, icon(20), tintB, 65);
                    imageTypeA(TheNest.this, settingsAboutIcon3, icon(18), R.color.transparent, 90);

                    textType(TheNest.this, settingsAboutText1, textC(24), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText2, textC(25), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText3, textB(13), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText4, textC(30), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText5, textC(31), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText6, textC(32), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText7, textC(33), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText8, textB(14), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText9, textB(15), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText10, textB(16), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText11, textB(17), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText12, textB(18), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText13, textB(19), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText14, textB(20), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText15, textC(34), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText16, textB(22), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText17, textC(35), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText18, textC(36), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText19, textB(23), tintB, fontBStyle);
                    textType(TheNest.this, settingsAboutText20, textC(37), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText21, textA(1), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText22, textA(10), tintB, fontAStyle);
                    textType(TheNest.this, settingsAboutText23, textB(21), tintB, fontBStyle);
                }
            };
            settingsAboutHandler.postDelayed(settingsAboutRunnable, 100);

            customTouchModeB(settingsAboutIcon1,"",2, 1,0);
            customTouchModeB(settingsAboutIcon3, "",2, 1,1);
            customTouchModeB(settingsAboutFrame2, "", 2, 1,2);
            customTouchModeB(settingsAboutFrame3, "", 2, 1,3);
            customTouchModeB(settingsAboutFrame4, "", 2, 1,4);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_about) == null){
            theNestSettingsLayout.addView(settingsAboutView);
            layoutParamsTypeC(this, settingsAboutLayout, new int[]{direction(5)}, direction(8), R.id.settings_edge_a, direction(7), R.id.settings_tooltip);
            setSize(this, settingsAboutLayout, size(2), size(2));
            setMargins(this, settingsAboutLayout, -40, 20, 20, 60);
            settingsEdgeAText.setText(textC(38));
        }
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsMiscPress_0(){
        settingsMiscLayout.removeView(settingsMiscBView);
        settingsMiscAView.setVisibility(View.VISIBLE);
    }

    private void settingsMiscPress_1(){
        if(settingsMiscBInt == 0){
            if(fileExist(TheNest.this, "Home")){
                File home = new File(getFilesDir(), "Home/Configurations");
                home.delete();
            }
            if(fileExist(TheNest.this, "Drawer")){
                File drawer = new File(getFilesDir(), "Drawer/Configurations");
                drawer.delete();
            }
            if(fileExist(TheNest.this, "Settings")){
                File settings = new File(getFilesDir(), "Settings/Configurations");
                settings.delete();
            }
            if(fileExist(TheNest.this, "Fozin")){
                File fozin = new File(getFilesDir(), "Fozin/Configurations");
                fozin.delete();
            }
        }
        if(settingsMiscBInt == 1){
            ((ActivityManager) getSystemService(ACTIVITY_SERVICE)).clearApplicationUserData();
            getCacheDir().delete();
            getFilesDir().delete();
        }
        restart(TheNest.this);
    }

    private void settingsMiscPress_2(){
        if(settingsMiscBInt != 0){
            settingsMiscBInt = 0;
            miscResetMode();
        }
    }

    private void settingsMiscPress_3(){
        if(settingsMiscBInt != 1){
            settingsMiscBInt = 1;
            miscResetMode();
        }
    }

    private void settingsMiscPress_4(){
        settingsMiscLayout.removeView(settingsMiscCView);
        settingsMiscAView.setVisibility(View.VISIBLE);
    }

    private void settingsMiscPress_5(){
        if(settingsMiscCInt == 0){
            if(statusBar.equals("Enabled")) {
                edit(TheNest.this,  "Fozin/Configurations","Status Bar - Enabled","Status Bar - Disabled");
            } else {
                edit(TheNest.this, "Fozin/Configurations", "Status Bar - Disabled", "Status Bar - Enabled");
            }
        }
        if(settingsMiscCInt == 1){
            if (navigationBar.equals("Enabled")) {
                edit(TheNest.this, "Fozin/Configurations", "Navigation Bar - Enabled", "Navigation Bar - Disabled");
            } else {
                edit(TheNest.this, "Fozin/Configurations", "Navigation Bar - Disabled", "Navigation Bar - Enabled");
            }
        }
        fozinConfigurations();
        miscBarsMode();
    }

    private void settingsMiscPress_6(){
        if(settingsMiscCInt != 0){
            settingsMiscCInt = 0;
            miscBarsMode();
        }
    }

    private void settingsMiscPress_7(){
        if(settingsMiscCInt != 1){
            settingsMiscCInt = 1;
            miscBarsMode();
        }
    }

    private void settingsMiscPress_8(){
        settingsMiscLayout.removeView(settingsMiscDView);
        settingsMiscAView.setVisibility(View.VISIBLE);
    }

    private void settingsMiscPress_9(){
        if(settingsMiscDInt_1 == 0){
            if(settingsTab.equals("About"))
                edit(this, "Settings/Configurations", "Settings Tab - " + settingsTab, "Settings Tab - Misc");
            if(settingsTab.equals("Misc"))
                edit(this, "Settings/Configurations", "Settings Tab - " + settingsTab, "Settings Tab - Drawer");
            if(settingsTab.equals("Drawer"))
                edit(this, "Settings/Configurations", "Settings Tab - " + settingsTab, "Settings Tab - Home");
            if(settingsTab.equals("Home"))
                edit(this, "Settings/Configurations", "Settings Tab - " + settingsTab, "Settings Tab - About");
            restart(this);
        }
        if(settingsMiscDInt_1 == 1){
            String style = "";
            if(settingsMiscDInt_2 == 0) {
                if(miscListStyle.equals("Square"))
                    style = "Cylinder";
                if(miscListStyle.equals("Cylinder"))
                    style = "Hexagon";
                if(miscListStyle.equals("Hexagon"))
                    style = "Square";
                edit(this,  "Settings/Configurations", "Misc List Style - " + miscListStyle, "Misc List Style - " + style);
                settingsConfigurations();
                settingsMiscDText3.setText(miscListStyle);
                if(settingsMiscAListView != null){
                    miscAItems.clear();
                    miscAItems.notifyDataSetChanged();
                    settingsMiscAList();
                }
            }
            if(settingsMiscDInt_2 == 1) {
                if(homeListStyle.equals("Square"))
                    style = "Cylinder";
                if(homeListStyle.equals("Cylinder"))
                    style = "Hexagon";
                if(homeListStyle.equals("Hexagon"))
                    style = "Square";
                edit(this,  "Settings/Configurations", "Home List Style - " + homeListStyle, "Home List Style - " + style);
                settingsConfigurations();
                settingsMiscDText3.setText(homeListStyle);
                if(settingsHomeAListView != null){
                    homeAItems.clear();
                    homeAItems.notifyDataSetChanged();
                    settingsHomeAList();
                }
            }
        }
    }

    private void settingsMiscPress_10(){
        if(settingsMiscDInt_1 != 0){
            settingsMiscDInt_1 = 0;
            miscTabs();
        }
    }

    private void settingsMiscPress_11(){
        if(settingsMiscDInt_1 != 1){
            settingsMiscDInt_1 = 1;
            miscTabs();
        }
    }

    private void settingsMiscPress_12(){
        if(settingsMiscDInt_2 != 0){
            settingsMiscDInt_2 = 0;
            miscSwitches_Tint();
        }
    }

    private void settingsMiscPress_13(){
        if(settingsMiscDInt_2 != 1){
            settingsMiscDInt_2 = 1;
            miscSwitches_Tint();
        }
    }

    private void settingsMiscPress_14(){

    }

    private void settingsMiscPress_15(){
        settingsMiscLayout.removeView(settingsMiscEView);
        settingsMiscAView.setVisibility(View.VISIBLE);
    }

    private void settingsMiscPress_16(){
        edit(this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.origin);
        edit(this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.orange_3);
        edit(this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.white);
        edit(this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.black);
        restart(this);
    }

    private void settingsMiscPress_17(){
        settingsMiscLayout.removeView(settingsMiscFView);
        settingsMiscAView.setVisibility(View.VISIBLE);
    }

    private void settingsMiscPress_18(){
        if(settingsMiscFInt != 0){
            settingsMiscFInt = 0;
            miscFonts();
        }
    }

    private void settingsMiscPress_19(){
        if(settingsMiscFInt != 1){
            settingsMiscFInt = 1;
            miscFonts();
        }
    }

    private void settingsMiscPress_20(){
        if(settingsMiscFInt == 0)
            settingsMiscPress_Common_1("Font A Style - ", fontAStyle);
        if(settingsMiscFInt == 1)
            settingsMiscPress_Common_1("Font B Style - ", fontBStyle);
        restart(this);
    }

    private void settingsMiscPress_Common_1(String type, int style){
        if(style == Typeface.BOLD)
            edit(this,  "Fozin/Configurations", type + style, type + Typeface.ITALIC);
        if(style == Typeface.ITALIC)
            edit(this,  "Fozin/Configurations", type + style, type + Typeface.BOLD_ITALIC);
        if(style == Typeface.BOLD_ITALIC)
            edit(this,  "Fozin/Configurations", type + style, type + Typeface.NORMAL);
        if(style == Typeface.NORMAL)
            edit(this,  "Fozin/Configurations", type + style, type + Typeface.BOLD);
    }

    private void settingsMiscPress_21(){
        if(fontAMode.equals("SimpliC")){
            edit(this,  "Fozin/Configurations", "Font A Mode - " + fontAMode, "Font A Mode - Common");
        } else {
            edit(this,  "Fozin/Configurations", "Font A Mode - " + fontAMode, "Font A Mode - SimpliC");
        }
        restart(this);
    }

    private void settingsMiscPress_22(){
        edit(this,  "Fozin/Configurations", "Font A Mode - " + fontAMode, "Font A Mode - SimpliC");
        edit(this,  "Fozin/Configurations", "Font A Style - " + fontAStyle, "Font A Style - " + Typeface.BOLD);
        edit(this,  "Fozin/Configurations", "Font B Style - " + fontBStyle, "Font B Style - " + Typeface.NORMAL);
        restart(this);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscView;
    RelativeLayout settingsMiscLayout;
    private void settingsMiscView(){
        if(settingsMiscView == null){
            settingsMiscView = inflater.inflate(R.layout.settings_misc, null);
            settingsMiscLayout = settingsMiscView.findViewById(R.id.settings_misc);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_misc) == null){
            theNestSettingsLayout.addView(settingsMiscView);
            layoutParamsTypeC(this, settingsMiscLayout, new int[]{direction(5)}, direction(8), R.id.settings_edge_a, direction(7), R.id.settings_tooltip);
            setSize(this, settingsMiscLayout, size(2), size(2));
            setMargins(this, settingsMiscLayout, -40, 20, 20, 60);
            settingsEdgeAText.setText(textC(39));
            if(settingsMiscLayout.getChildCount() == 0){
                settingsMiscAView();
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscAView;
    RelativeLayout settingsMiscA;
    ListView settingsMiscAListView;
    ListTypeB miscAItems;
    private void settingsMiscAView(){
        if(settingsMiscAView == null){
            settingsMiscAView = inflater.inflate(R.layout.settings_misc_a, null);
            settingsMiscA = settingsMiscAView.findViewById(R.id.settings_misc_a);
            settingsMiscAListView = settingsMiscAView.findViewById(R.id.settings_misc_a_list_view);

            backgroundTypeC(this, settingsMiscA, background(3), tintA);
            settingsMiscAList();
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_a) == null){
            settingsMiscLayout.addView(settingsMiscAView);
            setSize(this, settingsMiscA, size(2), size(2));
        }
    }

    private void settingsMiscAList(){
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(roundedBitmap(drawableIcon(this, defaultApp(this), 60)));
        bitmaps.add(reduceBitmap(this, icon(13), 60));
        bitmaps.add(reduceBitmap(this, icon(42), 60));
        bitmaps.add(reduceBitmap(this, icon(15), 60));
        bitmaps.add(reduceBitmap(this, icon(1), 60));
        bitmaps.add(reduceBitmap(this, icon(16), 60));
        bitmaps.add(reduceBitmap(this, icon(14), 60));

        ArrayList<String> strings_a = new ArrayList<>();
        strings_a.add(textC(42));
        strings_a.add(textC(43));
        strings_a.add(textC(22));
        strings_a.add(textC(44));
        strings_a.add(textC(45));
        strings_a.add(textC(46));
        strings_a.add(textC(47));

        ArrayList<String> strings_b = new ArrayList<>();
        strings_b.add(textB(24));
        strings_b.add(textB(25));
        strings_b.add(textB(26));
        strings_b.add(textB(27));
        strings_b.add(textB(28));
        strings_b.add(textB(29));
        strings_b.add(textB(30));

        Handler settingsMiscAHandler = new Handler();
        Runnable settingsMiscARunnable = new Runnable() {
            @Override
            public void run() {
                if(miscListStyle.equals("Square")){
                    miscAItems = new ListTypeB(TheNest.this, R.layout.list_type_b, bitmaps, strings_a, strings_b, TheNest.this);
                }
                if(miscListStyle.equals("Cylinder")){
                    miscAItems = new ListTypeB(TheNest.this, R.layout.list_type_c, bitmaps, strings_a, strings_b, TheNest.this);
                }
                if(miscListStyle.equals("Hexagon")){
                    miscAItems = new ListTypeB(TheNest.this, R.layout.list_type_d, bitmaps, strings_a, strings_b, TheNest.this);
                }
                settingsMiscAListView.setAdapter(miscAItems);
            }
        };
        settingsMiscAHandler.postDelayed(settingsMiscARunnable, 100);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    @Override
    public void clicked(int mode) {
        if(mode == 0) {
            settingsMiscBView();
        }
        if(mode == 1) {
            settingsMiscCView();
        }
        if(mode == 2) {
            settingsMiscDView();
        }
        if(mode == 3) {
            settingsMiscEView();
        }
        if(mode == 4){
            settingsMiscFView();
        }
        settingsMiscAView.setVisibility(View.GONE);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscBView;
    RelativeLayout settingsMiscB, settingsMiscBFrame1, settingsMiscBFrame2, settingsMiscBFrame3, settingsMiscBFrame4;
    ImageView settingsMiscBIcon1, settingsMiscBIcon2, settingsMiscBIcon3, settingsMiscBIcon4, settingsMiscBAngle;
    TextView settingsMiscBText1, settingsMiscBText2;
    @SuppressLint({"WrongConstant", "ClickableViewAccessibility"})
    private void settingsMiscBView(){
        if(settingsMiscBView == null){
            settingsMiscBView = inflater.inflate(R.layout.settings_misc_b, null);
            settingsMiscB = settingsMiscBView.findViewById(R.id.settings_misc_b);
            settingsMiscBFrame1 = settingsMiscBView.findViewById(R.id.settings_misc_b_frame_1);
            settingsMiscBFrame2 = settingsMiscBView.findViewById(R.id.settings_misc_b_frame_2);
            settingsMiscBFrame3 = settingsMiscBView.findViewById(R.id.settings_misc_b_frame_3);
            settingsMiscBFrame4 = settingsMiscBView.findViewById(R.id.settings_misc_b_frame_4);
            settingsMiscBIcon1 = settingsMiscBView.findViewById(R.id.settings_misc_b_icon_1);
            settingsMiscBIcon2 = settingsMiscBView.findViewById(R.id.settings_misc_b_icon_2);
            settingsMiscBIcon3 = settingsMiscBView.findViewById(R.id.settings_misc_b_icon_3);
            settingsMiscBIcon4 = settingsMiscBView.findViewById(R.id.settings_misc_b_icon_4);
            settingsMiscBAngle = settingsMiscBView.findViewById(R.id.settings_misc_b_angle);
            settingsMiscBText1 = settingsMiscBView.findViewById(R.id.settings_misc_b_text_1);
            settingsMiscBText2 = settingsMiscBView.findViewById(R.id.settings_misc_b_text_2);

            backgroundTypeC(this, settingsMiscBFrame3, background(3), tintA);
            backgroundTypeC(this, settingsMiscBFrame4, background(4), tintA);

            imageTypeA(this, settingsMiscBAngle, drawable(2), tintA, 30);
            imageTypeA(this, settingsMiscBIcon1, icon(11), tintA, 50);
            imageTypeA(this, settingsMiscBIcon2, icon(12), tintA, 50);
            imageTypeA(this, settingsMiscBIcon3, icon(31), tintB, 50);
            imageTypeA(this, settingsMiscBIcon4, icon(33), tintA, 75);

            textType(this, settingsMiscBText1, "", tintB, fontAStyle);
            textType(this, settingsMiscBText2, "", tintB, fontBStyle);

            customTouchModeB(settingsMiscBIcon4, textC(48), 2, 2,0);
            customTouchModeB(settingsMiscBFrame1, "", 2, 2,2);
            customTouchModeB(settingsMiscBFrame2, "", 2, 2,3);
            customTouchModeB(settingsMiscBFrame4, textC(49), 2, 2, 1);
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_b) == null){
            settingsMiscLayout.addView(settingsMiscBView);
            layoutParamsTypeA(this, settingsMiscB, new int[]{direction(2), direction(3)});
            setSize(this, settingsMiscB, size(2), size(1));
            setMargins(this, settingsMiscB, 20, 20, 20, 20);
            setMargins(this, settingsMiscBAngle, 20, 0, 15, 0);
            miscResetMode();
        }
    }

    int settingsMiscBInt = 0;
    private void miscResetMode(){
        if(settingsMiscBInt == 0){
            settingsMiscBText1.setText(textC(50));
            settingsMiscBText2.setText(textB(31));
            buttonModeC(this, settingsMiscBFrame1, settingsMiscBIcon1,true);
            buttonModeC(this, settingsMiscBFrame2, settingsMiscBIcon2,false);
            layoutParamsTypeC(this, settingsMiscBAngle, new int[]{0}, direction(8), R.id.settings_misc_b_frame_1, direction(13), R.id.settings_misc_b_frame_1);
        }
        if(settingsMiscBInt == 1){
            settingsMiscBText1.setText(textC(51));
            settingsMiscBText2.setText(textB(32));
            buttonModeC(this, settingsMiscBFrame1, settingsMiscBIcon1, false);
            buttonModeC(this, settingsMiscBFrame2, settingsMiscBIcon2, true);
            layoutParamsTypeC(this, settingsMiscBAngle, new int[]{0}, direction(8), R.id.settings_misc_b_frame_2, direction(13), R.id.settings_misc_b_frame_2);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscCView;
    RelativeLayout settingsMiscC, settingsMiscCFrame1, settingsMiscCFrame2, settingsMiscCFrame3, settingsMiscCFrame4;
    ImageView settingsMiscCAngle, settingsMiscCCircle, settingsMiscCIcon1, settingsMiscCIcon2, settingsMiscCIcon3;
    TextView settingsMiscCText1, settingsMiscCText2;
    private void settingsMiscCView(){
        if(settingsMiscCView == null){
            settingsMiscCView = inflater.inflate(R.layout.settings_misc_c, null);
            settingsMiscC = settingsMiscCView.findViewById(R.id.settings_misc_c);
            settingsMiscCFrame1 = settingsMiscCView.findViewById(R.id.settings_misc_c_frame_1);
            settingsMiscCFrame2 = settingsMiscCView.findViewById(R.id.settings_misc_c_frame_2);
            settingsMiscCFrame3 = settingsMiscCView.findViewById(R.id.settings_misc_c_frame_3);
            settingsMiscCFrame4 = settingsMiscCView.findViewById(R.id.settings_misc_c_frame_4);
            settingsMiscCCircle = settingsMiscCView.findViewById(R.id.settings_misc_c_circle);
            settingsMiscCAngle = settingsMiscCView.findViewById(R.id.settings_misc_c_angle);
            settingsMiscCIcon1 = settingsMiscCView.findViewById(R.id.settings_misc_c_icon_1);
            settingsMiscCIcon2 = settingsMiscCView.findViewById(R.id.settings_misc_c_icon_2);
            settingsMiscCIcon3 = settingsMiscCView.findViewById(R.id.settings_misc_c_icon_3);
            settingsMiscCText1 = settingsMiscCView.findViewById(R.id.settings_misc_c_text_1);
            settingsMiscCText2 = settingsMiscCView.findViewById(R.id.settings_misc_c_text_2);

            backgroundTypeC(this, settingsMiscCFrame3, background(3), tintA);
            backgroundTypeA(this, settingsMiscCFrame4, background(7), ui, 3);

            imageTypeA(this, settingsMiscCAngle, drawable(2), tintA, 30);
            imageTypeA(this, settingsMiscCIcon1, icon(27), tintA, 50);
            imageTypeA(this, settingsMiscCIcon2, icon(28), tintA, 50);
            imageTypeA(this, settingsMiscCIcon3, icon(33), tintA, 75);

            textType(this, settingsMiscCText1, "", tintB, fontAStyle);
            textType(this, settingsMiscCText2, "", tintB, fontBStyle);

            customTouchModeB(settingsMiscCIcon3, textC(48), 2, 2, 4);
            customTouchModeB(settingsMiscCFrame1, "", 2, 2,6);
            customTouchModeB(settingsMiscCFrame2, "", 2, 2,7);
            customTouchModeB(settingsMiscCFrame4, "", 2, 2,5);
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_c) == null){
            settingsMiscLayout.addView(settingsMiscCView);
            layoutParamsTypeA(this, settingsMiscC, new int[]{direction(2), direction(3)});
            setSize(this, settingsMiscC, size(2), size(1));
            setMargins(this, settingsMiscC, 20, 20, 20, 20);
            setMargins(this, settingsMiscCAngle, 20, 0, 15, 0);
            miscBarsMode();
        }
    }

    int settingsMiscCInt = 0;
    private void miscBarsMode(){
        if(settingsMiscCInt == 0){
            settingsMiscCText1.setText(textC(52));
            settingsMiscCText2.setText(textB(33));
            if(statusBar.equals("Enabled")) {
                toggleMode(this, settingsMiscCCircle, true);
            } else {
                toggleMode(this, settingsMiscCCircle, false);
            }
            buttonModeC(this, settingsMiscCFrame1, settingsMiscCIcon1, true);
            buttonModeC(this, settingsMiscCFrame2, settingsMiscCIcon2, false);
            layoutParamsTypeC(this, settingsMiscCAngle, new int[]{0}, direction(8), R.id.settings_misc_c_frame_1, direction(13), R.id.settings_misc_c_frame_1);
        }
        if(settingsMiscCInt == 1){
            settingsMiscCText1.setText(textC(53));
            settingsMiscCText2.setText(textB(34));
            if (navigationBar.equals("Enabled")) {
                toggleMode(this, settingsMiscCCircle, true);
            } else {
                toggleMode(this, settingsMiscCCircle, false);
            }
            buttonModeC(this, settingsMiscCFrame1, settingsMiscCIcon1, false);
            buttonModeC(this, settingsMiscCFrame2, settingsMiscCIcon2, true);
            layoutParamsTypeC(this, settingsMiscCAngle, new int[]{0}, direction(8), R.id.settings_misc_c_frame_2, direction(13), R.id.settings_misc_c_frame_2);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscDView;
    RelativeLayout settingsMiscD, settingsMiscDFrame1, settingsMiscDFrame2, settingsMiscDFrame3, settingsMiscDFrame4,
            settingsMiscDFrame5;
    ImageView settingsMiscDAngle, settingsMiscDIcon1, settingsMiscDIcon2, settingsMiscDIcon3,
            settingsMiscDIcon4, settingsMiscDIcon5;
    TextView settingsMiscDText1, settingsMiscDText2, settingsMiscDText3, settingsMiscDText4;
    private void settingsMiscDView(){
        if(settingsMiscDView == null){
            settingsMiscDView = inflater.inflate(R.layout.settings_misc_d, null);
            settingsMiscD = settingsMiscDView.findViewById(R.id.settings_misc_d);
            settingsMiscDFrame1 = settingsMiscDView.findViewById(R.id.settings_misc_d_frame_1);
            settingsMiscDFrame2 = settingsMiscDView.findViewById(R.id.settings_misc_d_frame_2);
            settingsMiscDFrame3 = settingsMiscDView.findViewById(R.id.settings_misc_d_frame_3);
            settingsMiscDFrame4 = settingsMiscDView.findViewById(R.id.settings_misc_d_frame_4);
            settingsMiscDFrame5 = settingsMiscDView.findViewById(R.id.settings_misc_d_frame_5);
            settingsMiscDAngle = settingsMiscDView.findViewById(R.id.settings_misc_d_angle);
            settingsMiscDIcon1 = settingsMiscDView.findViewById(R.id.settings_misc_d_icon_1);
            settingsMiscDIcon2 = settingsMiscDView.findViewById(R.id.settings_misc_d_icon_2);
            settingsMiscDIcon3 = settingsMiscDView.findViewById(R.id.settings_misc_d_icon_3);
            settingsMiscDIcon4 = settingsMiscDView.findViewById(R.id.settings_misc_d_icon_4);
            settingsMiscDIcon5 = settingsMiscDView.findViewById(R.id.settings_misc_d_icon_5);
            settingsMiscDText1 = settingsMiscDView.findViewById(R.id.settings_misc_d_text_1);
            settingsMiscDText2 = settingsMiscDView.findViewById(R.id.settings_misc_d_text_2);
            settingsMiscDText3 = settingsMiscDView.findViewById(R.id.settings_misc_d_text_3);
            settingsMiscDText4 = settingsMiscDView.findViewById(R.id.settings_misc_d_text_4);

            backgroundTypeC(this, settingsMiscDFrame3, background(3), tintA);
            backgroundTypeA(this, settingsMiscDFrame4, background(7), tintA, 3);

            imageTypeA(this, settingsMiscDAngle, drawable(2), tintA, 30);
            imageTypeA(this, settingsMiscDIcon1, icon(3), tintA, 50);
            imageTypeA(this, settingsMiscDIcon2, icon(2), tintA, 50);
            imageTypeA(this, settingsMiscDIcon3, icon(33), tintA, 75);

            textType(this, settingsMiscDText1, "", tintB, fontAStyle);
            textType(this, settingsMiscDText2, "", tintB, fontBStyle);
            textType(this, settingsMiscDText3, "", tintA, fontBStyle);
            textType(this, settingsMiscDText4, "", tintA, fontBStyle);

            customTouchModeB(settingsMiscDIcon3, textC(48), 2, 2, 8);
            customTouchModeB(settingsMiscDFrame1, "", 2, 2, 10);
            customTouchModeB(settingsMiscDFrame2, "", 2, 2, 11);
            customTouchModeB(settingsMiscDFrame4, "", 2,2,9);
            customTouchModeB(settingsMiscDIcon4, "", 2, 2, 12);
            customTouchModeB(settingsMiscDIcon5, "", 2, 2, 13);
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_d) == null){
            settingsMiscLayout.addView(settingsMiscDView);
            layoutParamsTypeA(this, settingsMiscD, new int[]{direction(2), direction(3)});
            setSize(this, settingsMiscD, size(2), size(1));
            setMargins(this, settingsMiscD, 20, 20, 20, 20);
            setMargins(this, settingsMiscDAngle, 20, 0, 15, 0);
            miscTabs();
        }
    }

    int settingsMiscDInt_1 = 0;
    int settingsMiscDInt_2 = 0;
    private void miscTabs(){
        if(settingsMiscDInt_1 == 0){
            settingsMiscDText1.setText(textC(54));
            settingsMiscDText2.setText(textB(35));
            buttonModeC(this, settingsMiscDFrame1, settingsMiscDIcon1, true);
            buttonModeC(this, settingsMiscDFrame2, settingsMiscDIcon2, false);
            layoutParamsTypeC(this, settingsMiscDAngle, new int[]{0}, direction(8), R.id.settings_misc_d_frame_1, direction(13), R.id.settings_misc_d_frame_1);
            settingsMiscDFrame5.setVisibility(View.GONE);
            settingsMiscDText3.setText(settingsTab);
        }
        if(settingsMiscDInt_1 == 1){
            settingsMiscDText1.setText(textC(55));
            settingsMiscDText2.setText(textB(36));
            buttonModeC(this, settingsMiscDFrame1, settingsMiscDIcon1, false);
            buttonModeC(this, settingsMiscDFrame2, settingsMiscDIcon2, true);
            layoutParamsTypeC(this, settingsMiscDAngle, new int[]{0}, direction(8), R.id.settings_misc_d_frame_2, direction(13), R.id.settings_misc_d_frame_2);
            settingsMiscDFrame5.setVisibility(View.VISIBLE);
            miscSwitches_Tint();
        }
    }

    private void miscSwitches_Tint(){
        if(settingsMiscDInt_2 == 0){
            imageTypeB(this, settingsMiscDIcon4, background(6), ui);
            backgroundTypeA(this, settingsMiscDIcon5, background(7), ui, 3);
            settingsMiscDIcon5.setImageDrawable(null);
            settingsMiscDText3.setText(miscListStyle);
            settingsMiscDText4.setText("Misc");
        }
        if(settingsMiscDInt_2 == 1){
            backgroundTypeA(this, settingsMiscDIcon4, background(7), ui, 3);
            imageTypeB(this, settingsMiscDIcon5, background(6), ui);
            settingsMiscDIcon4.setImageDrawable(null);
            settingsMiscDText3.setText(homeListStyle);
            settingsMiscDText4.setText("Home");
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscEView;
    RelativeLayout settingsMiscE, settingsMiscEFrame1, settingsMiscEFrame2, settingsMiscEFrame3;
    ImageView settingsMiscEIcon1, settingsMiscEIcon2;
    TextView settingsMiscEText1, settingsMiscEText2;
    HorizontalScrollView settingsMiscEHorizontalView;
    LinearLayout settingsMiscEColors;
    @SuppressLint({"WrongConstant", "ClickableViewAccessibility"})
    private void settingsMiscEView(){
        if(settingsMiscEView == null){
            settingsMiscEView = inflater.inflate(R.layout.settings_misc_e, null);
            settingsMiscE = settingsMiscEView.findViewById(R.id.settings_misc_e);
            settingsMiscEFrame1 = settingsMiscEView.findViewById(R.id.settings_misc_e_frame_1);
            settingsMiscEFrame2 = settingsMiscEView.findViewById(R.id.settings_misc_e_frame_2);
            settingsMiscEFrame3 = settingsMiscEView.findViewById(R.id.settings_misc_e_frame_3);
            settingsMiscEIcon1 = settingsMiscEView.findViewById(R.id.settings_misc_e_icon_1);
            settingsMiscEIcon2 = settingsMiscEView.findViewById(R.id.settings_misc_e_icon_2);
            settingsMiscEText1 = settingsMiscEView.findViewById(R.id.settings_misc_e_text_1);
            settingsMiscEText2 = settingsMiscEView.findViewById(R.id.settings_misc_e_text_2);
            settingsMiscEHorizontalView = settingsMiscEView.findViewById(R.id.settings_misc_e_horizontal_view);
            settingsMiscEColors = settingsMiscEView.findViewById(R.id.settings_misc_e_colors);

            backgroundTypeC(this, settingsMiscEFrame1, background(3), tintA);
            backgroundTypeA(this, settingsMiscEFrame2, background(7), tintA, 3);
            backgroundTypeC(this, settingsMiscEFrame3, background(4), tintA);
            settingsMiscEFrame2.setVisibility(View.INVISIBLE);

            imageTypeA(this, settingsMiscEIcon1, icon(42), tintB, 50);
            imageTypeA(this, settingsMiscEIcon2, icon(33), tintA, 75);

            textType(this, settingsMiscEText1, textC(46), tintB, fontAStyle);
            textType(this, settingsMiscEText2, textB(37), tintB, fontBStyle);

            customTouchModeB(settingsMiscEIcon2, textC(45), 2, 2,15);
            customTouchModeB(settingsMiscEFrame3, textC(56), 2, 2,16);

            ArrayList<Bitmap> list = new ArrayList<>();
            list.add(reduceBitmap(this, icon(4), 50));
            list.add(reduceBitmap(this, icon(5), 50));
            list.add(reduceBitmap(this, icon(6), 50));
            list.add(reduceBitmap(this, icon(7), 50));
            list.add(reduceBitmap(this, icon(8), 50));
            Handler settingsMiscDHandler = new Handler();
            Runnable settingsMiscDRunnable = new Runnable() {
                @Override
                public void run() {
                    miscColors(list, settingsMiscEColors);
                    settingsMiscEFrame2.setVisibility(View.VISIBLE);
                }
            };
            settingsMiscDHandler.postDelayed(settingsMiscDRunnable, 100);

            if(background != R.color.origin || ui != R.color.orange_3 || tintA != R.color.white || tintB != R.color.black){
                settingsMiscEFrame3.setVisibility(View.VISIBLE);
            } else {
                settingsMiscEFrame3.setVisibility(View.GONE);
            }
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_e) == null){
            settingsMiscLayout.addView(settingsMiscEView);
            layoutParamsTypeA(this, settingsMiscE, new int[]{direction(2), direction(3)});
            setSize(this, settingsMiscE, size(2), size(1));
            setMargins(this, settingsMiscE, 20, 20, 20, 20);
        }
    }

    View colorTemplatesView;
    ImageView colorTemplatesIcon;
    @SuppressLint("ClickableViewAccessibility")
    private void miscColors(ArrayList<Bitmap> list, LinearLayout layout){
        for (int i = 0; i < list.size(); i++) {
            colorTemplatesView = inflater.inflate(R.layout.linear_type_b, layout, false);
            colorTemplatesIcon = colorTemplatesView.findViewById(R.id.linear_type_b_icon);
            colorTemplatesIcon.setImageBitmap(list.get(i));

            int finalI = i;
            colorTemplatesIcon.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        touchStart(view);
                        onTouchRunnable = new Runnable() {
                            @Override
                            public void run() {
                                touchVibrate(TheNest.this, view);
                            }
                        };
                        onTouchHandler.postDelayed(onTouchRunnable, 300);
                    }
                    if(event.getAction() == MotionEvent.ACTION_UP){
                        touchStop(view);
                        if((System.currentTimeMillis() - time) < 200){
                            if(finalI == 0){
                                edit(TheNest.this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.black);
                                edit(TheNest.this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.blue_1);
                                edit(TheNest.this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.white);
                                edit(TheNest.this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.origin);
                            }
                            if(finalI == 1){
                                edit(TheNest.this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.white);
                                edit(TheNest.this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.teal);
                                edit(TheNest.this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.black);
                                edit(TheNest.this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.white);
                            }
                            if(finalI == 2){
                                edit(TheNest.this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.grey);
                                edit(TheNest.this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.black);
                                edit(TheNest.this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.origin);
                                edit(TheNest.this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.white);
                            }
                            if(finalI == 3){
                                edit(TheNest.this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.yellow_3);
                                edit(TheNest.this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.red_2);
                                edit(TheNest.this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.origin);
                                edit(TheNest.this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.white);
                            }
                            if(finalI == 4){
                                edit(TheNest.this, "Fozin/Configurations", "Background - " + background, "Background - " + R.color.blue_1);
                                edit(TheNest.this, "Fozin/Configurations", "UI - " + ui, "UI - " + R.color.green_3);
                                edit(TheNest.this, "Fozin/Configurations", "Tint A - " + tintA, "Tint A - " + R.color.white);
                                edit(TheNest.this, "Fozin/Configurations", "Tint B - " + tintB, "Tint B - " + R.color.origin);
                            }
                            restart(TheNest.this);
                        }
                    }
                    touchEnd(event, view);
                    return true;
                }
            });
            layout.addView(colorTemplatesView);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsMiscFView;
    RelativeLayout settingsMiscF, settingsMiscFFrame1, settingsMiscFFrame2, settingsMiscFFrame3, settingsMiscFFrame4,
            settingsMiscFFrame5, settingsMiscFFrame6;
    ImageView settingsMiscFAngle, settingsMiscFIcon1, settingsMiscFIcon2, settingsMiscFIcon3, settingsMiscFIcon4;
    TextView settingsMiscFText1, settingsMiscFText2, settingsMiscFText3, settingsMiscFText4, settingsMiscFText5,
            settingsMiscFText6;
    private void settingsMiscFView(){
        if(settingsMiscFView == null){
            settingsMiscFView = inflater.inflate(R.layout.settings_misc_f, null);
            settingsMiscF = settingsMiscFView.findViewById(R.id.settings_misc_f);
            settingsMiscFFrame1 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_1);
            settingsMiscFFrame2 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_2);
            settingsMiscFFrame3 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_3);
            settingsMiscFFrame4 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_4);
            settingsMiscFFrame5 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_5);
            settingsMiscFFrame6 = settingsMiscFView.findViewById(R.id.settings_misc_f_frame_6);
            settingsMiscFAngle = settingsMiscFView.findViewById(R.id.settings_misc_f_angle);
            settingsMiscFIcon1 = settingsMiscFView.findViewById(R.id.settings_misc_f_icon_1);
            settingsMiscFIcon2 = settingsMiscFView.findViewById(R.id.settings_misc_f_icon_2);
            settingsMiscFIcon3 = settingsMiscFView.findViewById(R.id.settings_misc_f_icon_3);
            settingsMiscFIcon4 = settingsMiscFView.findViewById(R.id.settings_misc_f_icon_4);
            settingsMiscFText1 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_1);
            settingsMiscFText2 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_2);
            settingsMiscFText3 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_3);
            settingsMiscFText4 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_4);
            settingsMiscFText5 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_5);
            settingsMiscFText6 = settingsMiscFView.findViewById(R.id.settings_misc_f_text_6);

            backgroundTypeC(this, settingsMiscFFrame3, background(3), tintA);
            backgroundTypeA(this, settingsMiscFFrame4, background(8), tintA, 10);
            backgroundTypeA(this, settingsMiscFFrame5, background(8), tintA, 10);
            backgroundTypeC(this, settingsMiscFFrame6, background(4), tintA);

            imageTypeA(this, settingsMiscFAngle, drawable(2), tintA, 30);
            imageTypeA(this, settingsMiscFIcon1, icon(10), tintA, 50);
            imageTypeA(this, settingsMiscFIcon2, icon(9), tintA, 50);
            imageTypeA(this, settingsMiscFIcon3, icon(33), tintA, 75);
            imageTypeA(this, settingsMiscFIcon4, icon(42), tintB, 50);

            textType(this, settingsMiscFText1, "", tintB, fontAStyle);
            textType(this, settingsMiscFText2, "", tintB, fontBStyle);

            textType(this, settingsMiscFText3, textB(40), tintA, Typeface.BOLD);
            textType(this, settingsMiscFText4, "", tintA, fontBStyle);
            textType(this, settingsMiscFText5, textB(41), tintA, Typeface.BOLD);
            textType(this, settingsMiscFText6, "", tintA, fontBStyle);

            customTouchModeB(settingsMiscFIcon3, textC(48), 2, 2, 17);
            customTouchModeB(settingsMiscFFrame1, "", 2, 2, 18);
            customTouchModeB(settingsMiscFFrame2, "", 2, 2, 19);
            customTouchModeB(settingsMiscFFrame4, "", 2, 2, 20);
            customTouchModeB(settingsMiscFFrame5, "", 2, 2, 21);
            customTouchModeB(settingsMiscFFrame6, textC(56), 2, 2, 22);

            if(!fontAMode.equals("SimpliC") || fontAStyle != Typeface.BOLD || fontBStyle != Typeface.NORMAL){
                settingsMiscFFrame6.setVisibility(View.VISIBLE);
            } else {
                settingsMiscFFrame6.setVisibility(View.GONE);
            }
        }
        if(settingsMiscLayout.findViewById(R.id.settings_misc_f) == null){
            settingsMiscLayout.addView(settingsMiscFView);
            layoutParamsTypeA(this, settingsMiscF, new int[]{direction(2), direction(3)});
            setSize(this, settingsMiscF, size(2), size(1));
            setMargins(this, settingsMiscF, 20, 20, 20, 20);
            setMargins(this, settingsMiscFAngle, 20, 0, 15, 0);
            miscFonts();
        }
    }

    private int settingsMiscFInt = 0;
    private void miscFonts(){
        if(settingsMiscFInt == 0){
            settingsMiscFText1.setText(textC(57));
            settingsMiscFText2.setText(textB(38));
            buttonModeC(this, settingsMiscFFrame1, settingsMiscFIcon1, true);
            buttonModeC(this, settingsMiscFFrame2, settingsMiscFIcon2, false);
            layoutParamsTypeC(this, settingsMiscFAngle, new int[]{0}, direction(8), R.id.settings_misc_f_frame_1, direction(13), R.id.settings_misc_f_frame_1);
            settingsMiscFFrame5.setVisibility(View.VISIBLE);
            miscFontsCommon(fontAStyle);
            settingsMiscFText6.setText(textC(59));
        }
        if(settingsMiscFInt == 1){
            settingsMiscFText1.setText(textC(58));
            settingsMiscFText2.setText(textB(39));
            buttonModeC(this, settingsMiscFFrame1, settingsMiscFIcon1, false);
            buttonModeC(this, settingsMiscFFrame2, settingsMiscFIcon2, true);
            layoutParamsTypeC(this, settingsMiscFAngle, new int[]{0}, direction(8), R.id.settings_misc_f_frame_2, direction(13), R.id.settings_misc_f_frame_2);
            settingsMiscFFrame5.setVisibility(View.GONE);
            miscFontsCommon(fontBStyle);
        }
    }

    private void miscFontsCommon(int style){
        if(style == Typeface.BOLD)
            settingsMiscFText4.setText("Bold");
        if(style == Typeface.ITALIC)
            settingsMiscFText4.setText("Italic A");
        if(style == Typeface.BOLD_ITALIC)
            settingsMiscFText4.setText("Italic B");
        if(style == Typeface.NORMAL)
            settingsMiscFText4.setText("Normal");
    }

    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsDrawerPress_0(){
        settingsDrawerLayout.removeView(settingsDrawerAView);
        settingsDrawerB();
    }

    private void settingsDrawerPress_1(){
        settingsDrawerLayout.removeView(settingsDrawerBView);
        settingsDrawerLayout.addView(settingsDrawerAView);
    }

    private void settingsDrawerPress_2(){
        settingsDrawerBFrame1.setVisibility(View.INVISIBLE);
        settingsDrawerBFrame3.setVisibility(View.VISIBLE);
        imageTypeA(this, settingsDrawerBIcon3, icon(50), tintA, 40);
        settingsDrawerBText3.setText(textB(48));
        settingsDrawerBInt = 0;
    }

    private void settingsDrawerPress_3(){
        settingsDrawerBFrame1.setVisibility(View.VISIBLE);
        settingsDrawerBFrame3.setVisibility(View.GONE);
    }

    private void settingsDrawerPress_4(){
        if(settingsDrawerBInt == 0){
            if(fileExist(this, "List/Array - 03")){
                File hidden = new File(getFilesDir(), "List/Array - 03");
                hidden.delete();
            }
        }
        if(settingsDrawerBInt == 1){
            if(fileExist(this, "List/Array - 03")){
                edit(this, "List/Array - 03", settingsDrawerBString, "");
            }
        }
        hiddenApps();
        if(drawerAppsGridView != null)
            drawerTilesPress_0();
        settingsDrawerBFrame1.setVisibility(View.VISIBLE);
        settingsDrawerBFrame3.setVisibility(View.GONE);
    }

    private void settingsDrawerPress_5(){
        if(drawerGridStyle.equals("Tiles")){
            edit(this, "Drawer/Configurations", "Drawer Grid Style - " + drawerGridStyle, "Drawer Grid Style - Bubbles");
        }
        if(drawerGridStyle.equals("Bubbles")){
            edit(this, "Drawer/Configurations", "Drawer Grid Style - " + drawerGridStyle, "Drawer Grid Style - Tiles");
        }
        drawerConfigurations();
        currentOptions();

        if(drawerAppsGridView != null){
            drawerTilesPress_0();
            drawerGridStyle();
        }
    }

    private void settingsDrawerPress_6(){
        if(drawerSortingOrder.equals("Alphabetically")){
            edit(this, "Drawer/Configurations", "Drawer Sorting Order - " + drawerSortingOrder, "Drawer Sorting Order - Random");
        }
        if(drawerSortingOrder.equals("Random")){
            edit(this, "Drawer/Configurations", "Drawer Sorting Order - " + drawerSortingOrder, "Drawer Sorting Order - Alphabetically");
        }
        drawerConfigurations();
        currentOptions();
        if(drawerAppsGridView != null)
            drawerTilesPress_0();
    }

    private void settingsDrawerPress_7(){
        if(drawerBrowseMode.equals("[ NONE ]")){
            edit(this, "Drawer/Configurations", "Drawer Browse Mode - " + drawerBrowseMode, "Drawer Browse Mode - Index");
        }
        if(drawerBrowseMode.equals("Index")){
            edit(this, "Drawer/Configurations", "Drawer Browse Mode - " + drawerBrowseMode, "Drawer Browse Mode - [ NONE ]");
        }
        drawerConfigurations();
        currentOptions();
        if(drawerTilesFrame3 != null)
            drawerBrowseIndex();
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsDrawerView;
    RelativeLayout settingsDrawerLayout;
    private void settingsDrawer(){
        if(settingsDrawerView == null){
            settingsDrawerView = inflater.inflate(R.layout.settings_drawer, null);
            settingsDrawerLayout = settingsDrawerView.findViewById(R.id.settings_drawer);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_drawer) == null){
            theNestSettingsLayout.addView(settingsDrawerView);
            layoutParamsTypeC(this, settingsDrawerLayout, new int[]{direction(5)}, direction(8), R.id.settings_edge_a, direction(7), R.id.settings_tooltip);
            setSize(this, settingsDrawerLayout, size(2), size(2));
            setMargins(this, settingsDrawerLayout, -40, 20, 20, 60);
            settingsEdgeAText.setText(textC(41));
            if(settingsDrawerLayout.getChildCount() == 0){
                settingsDrawerAView();
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsDrawerAView;
    RelativeLayout settingsDrawerA, settingsDrawerAFrame1, settingsDrawerAFrame2, settingsDrawerAFrame3, settingsDrawerAFrame4,
            settingsDrawerAFrame5, settingsDrawerAFrame6, settingsDrawerAFrame7;
    ImageView settingsDrawerAIcon1, settingsDrawerADot1, settingsDrawerADot2, settingsDrawerADot3, settingsDrawerADot4,
            settingsDrawerADash1, settingsDrawerADash2;
    TextView settingsDrawerAText1, settingsDrawerAText2, settingsDrawerAText3, settingsDrawerAText4, settingsDrawerAText5,
            settingsDrawerAText6, settingsDrawerAText7, settingsDrawerAText8, settingsDrawerAText9, settingsDrawerAText10,
            settingsDrawerAText11, settingsDrawerALine1, settingsDrawerALine2, settingsDrawerALine3, settingsDrawerALine4,
            settingsDrawerALine5;
    ScrollView settingsDrawerAScrollView;
    private void settingsDrawerAView(){
        if(settingsDrawerAView == null){
            settingsDrawerAView = inflater.inflate(R.layout.settings_drawer_a, null);
            settingsDrawerA = settingsDrawerAView.findViewById(R.id.settings_drawer_a);
            settingsDrawerAScrollView = settingsDrawerAView.findViewById(R.id.settings_drawer_a_scroll_view);
            settingsDrawerAText1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_1);
            settingsDrawerAText2 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_2);
            settingsDrawerAText3 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_3);
            settingsDrawerAText4 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_4);
            settingsDrawerAText5 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_5);
            settingsDrawerAText6 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_6);
            settingsDrawerAText7 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_7);
            settingsDrawerAText8 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_8);
            settingsDrawerAText9 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_9);
            settingsDrawerAText10 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_10);
            settingsDrawerAText11 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_text_11);
            settingsDrawerALine1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_line_1);
            settingsDrawerALine2 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_line_2);
            settingsDrawerALine3 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_line_3);
            settingsDrawerALine4 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_line_4);
            settingsDrawerALine5 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_line_5);
            settingsDrawerAFrame1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_1);
            settingsDrawerAFrame2 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_2);
            settingsDrawerAFrame3 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_3);
            settingsDrawerAFrame4 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_4);
            settingsDrawerAFrame5 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_5);
            settingsDrawerAFrame6 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_6);
            settingsDrawerAFrame7 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_frame_7);
            settingsDrawerAIcon1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_icon_1);
            settingsDrawerADot1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dot_1);
            settingsDrawerADot2 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dot_2);
            settingsDrawerADot3 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dot_3);
            settingsDrawerADot4 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dot_4);
            settingsDrawerADash1 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dash_1);
            settingsDrawerADash2 = settingsDrawerAView.findViewById(R.id.settings_drawer_a_dash_2);

            backgroundTypeC(this, settingsDrawerA, background(3), tintA);
            backgroundTypeA(this, settingsDrawerAFrame2, background(9), tintB, 3);
            backgroundTypeA(this, settingsDrawerAFrame3, background(7), tintB, 3);
            backgroundTypeA(this, settingsDrawerAFrame4, background(8), tintB, 3);
            backgroundTypeA(this, settingsDrawerAFrame6, background(12), tintB, 3);

            imageTypeA(this, settingsDrawerAIcon1, icon(38), tintB, 60);
            imageTypeB(this, settingsDrawerADot1, background(4), ui);
            imageTypeB(this, settingsDrawerADot2, background(4), ui);
            imageTypeB(this, settingsDrawerADot3, background(4), ui);
            imageTypeB(this, settingsDrawerADot4, background(4), ui);
            imageTypeB(this, settingsDrawerADash1, background(6), ui);
            imageTypeB(this, settingsDrawerADash2, background(6), ui);

            textType(this, settingsDrawerAText1, textC(60), tintB, fontAStyle);
            textType(this, settingsDrawerAText2, textB(42), tintB, fontBStyle);
            textType(this, settingsDrawerAText3, textC(61), tintB, fontAStyle);
            textType(this, settingsDrawerAText4, textB(43), tintB, fontBStyle);
            textType(this, settingsDrawerAText5, "", tintB, fontBStyle);
            textType(this, settingsDrawerAText6, textC(62), tintB, fontAStyle);
            textType(this, settingsDrawerAText7, textB(44), tintB, fontBStyle);
            textType(this, settingsDrawerAText8, "", tintB, fontBStyle);
            textType(this, settingsDrawerAText9, textC(63), tintB, fontAStyle);
            textType(this, settingsDrawerAText10, textB(45), tintB, fontBStyle);
            textType(this, settingsDrawerAText11, "", tintB, fontBStyle);
            textType(this, settingsDrawerALine1, textA(13), tintB, fontBStyle);
            textType(this, settingsDrawerALine2, textA(13), tintB, fontBStyle);
            textType(this, settingsDrawerALine3, textA(9), tintB, fontBStyle);
            textType(this, settingsDrawerALine4, textA(9), tintB, fontBStyle);
            textType(this, settingsDrawerALine5,textA(13), tintB, fontBStyle);

            customTouchModeB(settingsDrawerAFrame2, textC(64), 2, 3, 0);
            customTouchModeB(settingsDrawerAFrame3, "", 2, 3, 5);
            customTouchModeB(settingsDrawerAFrame4, "", 2, 3, 6);
            customTouchModeB(settingsDrawerAFrame6, "", 2, 3, 7);

            drawerConfigurations();
        }
        if(settingsDrawerLayout.findViewById(R.id.settings_drawer_a) == null){
            settingsDrawerLayout.addView(settingsDrawerAView);
            setSize(this, settingsDrawerA, size(2), size(2));
            currentOptions();
        }
    }

    private void currentOptions(){
        if(drawerGridStyle.equals("Tiles")){
            settingsDrawerAText5.setText("Tiles");
            settingsDrawerADot1.setAlpha(1.0f);
            settingsDrawerADot2.setAlpha(.3f);
        }
        if(drawerGridStyle.equals("Bubbles")){
            settingsDrawerAText5.setText("Bubbles");
            settingsDrawerADot1.setAlpha(.3f);
            settingsDrawerADot2.setAlpha(1.0f);
        }
        if(drawerSortingOrder.equals("Alphabetically")){
            settingsDrawerAText8.setText("Alphabetically");
            settingsDrawerADash1.setAlpha(1.0f);
            settingsDrawerADash2.setAlpha(.3f);
        }
        if(drawerSortingOrder.equals("Random")){
            settingsDrawerAText8.setText("Random");
            settingsDrawerADash1.setAlpha(.3f);
            settingsDrawerADash2.setAlpha(1.0f);
        }
        if(drawerBrowseMode.equals("[ NONE ]")){
            settingsDrawerAText11.setText("None");
            settingsDrawerADot3.setAlpha(1.0f);
            settingsDrawerADot4.setAlpha(.3f);
        }
        if(drawerBrowseMode.equals("Index")){
            settingsDrawerAText11.setText("Index " + textA(14));
            settingsDrawerADot3.setAlpha(.3f);
            settingsDrawerADot4.setAlpha(1.0f);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsDrawerBView;
    RelativeLayout settingsDrawerB, settingsDrawerBFrame1, settingsDrawerBFrame2, settingsDrawerBFrame3, settingsDrawerBFrame4,
            settingsDrawerBFrame5;
    ImageView settingsDrawerBIcon1, settingsDrawerBIcon2, settingsDrawerBIcon3, settingsDrawerBIcon4;
    TextView settingsDrawerBText1, settingsDrawerBText2, settingsDrawerBText3;
    ListView settingsDrawerBListview;
    private void settingsDrawerB(){
        if(settingsDrawerBView == null){
            settingsDrawerBView = inflater.inflate(R.layout.settings_drawer_b, null);
            settingsDrawerB = settingsDrawerBView.findViewById(R.id.settings_drawer_b);
            settingsDrawerBFrame1 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_frame_1);
            settingsDrawerBFrame2 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_frame_2);
            settingsDrawerBFrame3 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_frame_3);
            settingsDrawerBFrame4 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_frame_4);
            settingsDrawerBFrame5 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_frame_5);
            settingsDrawerBText1 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_text_1);
            settingsDrawerBText2 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_text_2);
            settingsDrawerBText3 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_text_3);
            settingsDrawerBIcon1 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_icon_1);
            settingsDrawerBIcon2 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_icon_2);
            settingsDrawerBIcon3 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_icon_3);
            settingsDrawerBIcon4 = settingsDrawerBView.findViewById(R.id.settings_drawer_b_icon_4);
            settingsDrawerBListview = settingsDrawerBView.findViewById(R.id.settings_drawer_b_list_view);

            backgroundTypeC(this, settingsDrawerBFrame2, background(7), tintA);
            backgroundTypeA(this, settingsDrawerBFrame4, background(9), tintA, 3);
            settingsDrawerBFrame3.setVisibility(View.GONE);

            imageTypeA(this, settingsDrawerBIcon1, icon(32), tintB, 40);
            imageTypeA(this, settingsDrawerBIcon2, icon(33), tintA, 75);
            imageTypeA(this, settingsDrawerBIcon4, icon(31), tintA, 85);

            textType(this, settingsDrawerBText1, "", tintA, Typeface.BOLD);
            textType(this, settingsDrawerBText2, "", tintA, fontBStyle);
            textType(this, settingsDrawerBText3, "", tintA, Typeface.BOLD);

            customTouchModeB(settingsDrawerBIcon2, textC(48), 2, 3, 1);
            customTouchModeB(settingsDrawerBFrame4, "", 2, 3, 3);
            customTouchModeB(settingsDrawerBIcon4, textC(49), 2, 3, 4);
        }
        if(settingsDrawerLayout.findViewById(R.id.settings_drawer_b) == null){
            settingsDrawerLayout.addView(settingsDrawerBView);
            setSize(this, settingsDrawerB, size(2), size(2));
            setMargins(this, settingsDrawerB, 20, 20, 20, 20);
            hiddenApps();
        }
    }

    ListTypeC hiddenListItems;
    List<String> hiddenListArray;
    private void hiddenApps(){
        if(!settingsDrawerBString.isEmpty() && !isAppInstalled(this, settingsDrawerBString)){
            settingsDrawerBFrame1.setVisibility(View.VISIBLE);
            settingsDrawerBFrame3.setVisibility(View.GONE);
        }
        try {
            hiddenListArray.clear();
            hiddenListItems.clear();
        } catch (Exception e){}
        if(fileExist(this, "List/Array - 03")){
            hiddenListArray = read(this, "List/Array - 03");
            for (Iterator<String> iterator = hiddenListArray.iterator(); iterator.hasNext();) {
                String value = iterator.next();
                if (value.isEmpty() || !isAppInstalled(this, value)) {
                    iterator.remove();
                }
            }
            if(hiddenListArray.size() != 0){
                settingsDrawerBFrame2.setAlpha(1.0f);
                customTouchModeB(settingsDrawerBFrame2, textC(66), 2, 3, 2);
                settingsDrawerBText1.setText("••• " + hiddenListArray.size());
                settingsDrawerBText2.setText(textB(46));

                Handler settingsDrawerBHandler = new Handler();
                Runnable settingsDrawerBRunnable = new Runnable() {
                    @Override
                    public void run() {
                        hiddenListItems = new ListTypeC(TheNest.this, hiddenListArray, TheNest.this);
                        settingsDrawerBListview.setAdapter(hiddenListItems);
                    }
                };
                settingsDrawerBHandler.postDelayed(settingsDrawerBRunnable, 50);
            } else {
                if(fileExist(this, "List/Array - 03")){
                    File hidden = new File(getFilesDir(), "List/Array - 03");
                    hidden.delete();
                }
                hiddenApps();
            }
        } else {
            settingsDrawerBFrame1.setVisibility(View.VISIBLE);
            settingsDrawerBFrame3.setVisibility(View.GONE);
            settingsDrawerBFrame2.setAlpha(.5f);
            settingsDrawerBFrame2.setOnTouchListener(null);
            settingsDrawerBText1.setText(textC(65));
            settingsDrawerBText2.setText(textB(47));
        }
    }

    private int settingsDrawerBInt = 0;
    private String settingsDrawerBString = "";
    @Override
    public void hiddenApp(String current) {
        settingsDrawerBInt = 1;
        settingsDrawerBString = current;
        settingsDrawerBFrame1.setVisibility(View.INVISIBLE);
        settingsDrawerBFrame3.setVisibility(View.VISIBLE);
        switchTint(this, settingsDrawerBIcon3, R.color.transparent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settingsDrawerBIcon3.setImageBitmap(roundedBitmap(adaptiveIcon(this, current, 40)));
        } else {
            settingsDrawerBIcon3.setImageBitmap(roundedBitmap(drawableIcon(this, current, 40)));
        }
        String label = "";
        try {
            label = (String) getPackageManager().getApplicationInfo(current, 0).loadLabel(getPackageManager());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        settingsDrawerBText3.setText(label);
    }


    //---------- ---------- ---------- ---------- ---------- []
    //                                                       []
    //                                                       []
    //                                                       []
    //---------- ---------- ---------- ---------- ---------- []

    private void settingsHomePress_0(){
        settingsHomeLayout.removeView(settingsHomeBView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_1(){
        if(widgetState.equals("Enabled")) {
            edit(this, "Home/Configurations", "Widget State - " + widgetState, "Widget State - Disabled");
        } else {
            edit(this, "Home/Configurations", "Widget State - " + widgetState, "Widget State - Enabled");
        }
        settingsHomeWidgets();
        homeWIDGET();
        homeAppletPositions();
    }

    private void settingsHomePress_2(){
        if(settingsHomeBInt_a == 0){
            settingsHomeBInt_a = 1;
        } else {
            if (settingsHomeBInt_a == 1) {
                settingsHomeBInt_a = 0;
            }
        }
        settingsHomeWidgetsTabs();
        settingsHomeWidgetsLists();
    }

    private void settingsHomePress_3(){
        if(settingsHomeBFrame6.getVisibility() != View.VISIBLE){
            settingsHomeBFrame6.setVisibility(View.VISIBLE);
            settingsHomeBFrame1.setVisibility(View.INVISIBLE);
        } else {
            settingsHomeBFrame6.setVisibility(View.GONE);
            settingsHomeBFrame1.setVisibility(View.VISIBLE);
        }
        if(homeBItems == null)
            settingsHomeWidgetsLists();
    }

    private void settingsHomePress_4(){
        if(settingsHomeBInt_b == 0){
            edit(this, "Home/Configurations", "Widget Mode - " + widgetMode, "Widget Mode - SimpliC");
            if(settingsHomeBString_b.equals("Analog Clock")){
                edit(this, "Home/Configurations", "Widget Component - " + widgetComponent, "Widget Component - Clock 1");
            } else {
                edit(this, "Home/Configurations", "Widget Component - " + widgetComponent, "Widget Component - Clock 2");
            }
            homeConfigurations();
            homeWIDGET();
        } else {
            edit(this, "Home/Configurations", "Widget Mode - " + widgetMode, "Widget Mode - Device");
            homeWidgetInitiate();
        }
        settingsHomePress_5();
        touchTip(this, textC(20), 2);
    }

    private void settingsHomePress_5(){
        settingsHomeBFrame6.setVisibility(View.VISIBLE);
        settingsHomeBFrame7.setVisibility(View.GONE);
        settingsHomeBFrame3.setAlpha(1.0f);
        customTouchModeB(settingsHomeBFrame4, "", 2, 4, 2);
        customTouchModeB(settingsHomeBFrame5, "", 2, 4, 3);
    }

    private void settingsHomePress_6(){
        homeWidgetRemove();
        settingsHomePress_5();
        touchTip(this, textC(20), 2);
    }

    private void settingsHomePress_7(){
        settingsHomeLayout.removeView(settingsHomeCView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_8(){
        settingsHomeCEditText.setVisibility(View.VISIBLE);
        settingsHomeCText3.setVisibility(View.GONE);
        imageTypeA(this, settingsHomeCIcon1, icon(31), tintB, 50);
        customTouchModeB(settingsHomeCFrame2, textC(13), 2, 4, 9);
        backgroundTypeC(this, settingsHomeCFrame2, background(5), ui);
    }

    private void settingsHomePress_9(){
        settingsHomeC_CommonA();
        ((InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);

        edit(this, "Home/Configurations", "Applet Text - " + appletText, "Applet Text - " + settingsHomeCEditText.getText().toString().trim());
        appletText = settingsHomeCEditText.getText().toString().trim();
        settingsHomeC_CommonB();
    }

    private void settingsHomeC_CommonA(){
        settingsHomeCEditText.setVisibility(View.GONE);
        settingsHomeCText3.setVisibility(View.VISIBLE);
        imageTypeA(this, settingsHomeCIcon1, icon(45), tintA, 50);
        customTouchModeB(settingsHomeCFrame2, textC(14), 2, 4, 8);
        backgroundTypeA(this, settingsHomeCFrame2, background(5), tintA, 3);
    }

    private void settingsHomeC_CommonB(){
        homeAppletAText.setText(appletText);
        homeAppletText();
        settingsHomeApplet();
    }

    private void settingsHomePress_10(){
        if(settingsHomeCText3.getVisibility() != View.VISIBLE)
            settingsHomeC_CommonA();

        edit(this, "Home/Configurations", "Applet Text - " + appletText, "Applet Text - ∆×••⟨[ ]⟩");
        appletText = "∆×••⟨[ ]⟩";
        settingsHomeC_CommonB();
    }

    private void settingsHomePress_11(){
        settingsHomeLayout.removeView(settingsHomeDView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_12(){
        if(wallpaperState.equals("Enabled")) {
            edit(this, "Home/Configurations", "Wallpaper State - " + wallpaperState, "Wallpaper State - Disabled");
        } else {
            edit(this, "Home/Configurations", "Wallpaper State - " + wallpaperState, "Wallpaper State - Enabled");
        }
        settingsHomeWallpaper();
        homeWALLPAPER();
        homeCenterPositions();
    }

    private void settingsHomePress_13(){
        if(settingsHomeDInt == 0){
            settingsHomeDInt = 1;
        } else {
            if (settingsHomeDInt == 1) {
                settingsHomeDInt = 0;
            }
        }
        settingsHomeWallpaper_A();
        if(settingsHomeDFrame6.getVisibility() == View.VISIBLE)
            settingsHomeWallpaper_B();
    }

    private void settingsHomePress_14(){
        if(settingsHomeDFrame6.getVisibility() != View.VISIBLE){
            settingsHomeDFrame6.setVisibility(View.VISIBLE);
            settingsHomeDFrame1.setVisibility(View.INVISIBLE);
        } else {
            settingsHomeDFrame6.setVisibility(View.GONE);
            settingsHomeDFrame1.setVisibility(View.VISIBLE);
        }
        settingsHomeWallpaper_B();
    }

    private void settingsHomePress_15(){
        if(settingsHomeDInt == 0){
            edit(this, "Home/Configurations", "Wallpaper Mode - " + wallpaperMode, "Wallpaper Mode - SimpliC");
            edit(this, "Home/Configurations", "Wallpaper Component - " + wallpaperComponent, "Wallpaper Component - Blocks");
        } else {
            edit(this, "Home/Configurations", "Wallpaper Mode - " + wallpaperMode, "Wallpaper Mode - Device");
            edit(this, "Home/Configurations", "Wallpaper Component - " + wallpaperComponent, "Wallpaper Component - Unknown");
        }
        homeConfigurations();
        homeWALLPAPER();
        //settingsHomePress_14();
        settingsHomeWallpaper_B();
        touchTip(this, textC(20), 2);
    }

    private void settingsHomePress_16(){
        homeWallpaperRemove();
        //settingsHomePress_14();
        settingsHomeWallpaper_B();
        touchTip(this, textC(20), 2);
    }

    private void settingsHomePress_17(){
        settingsHomeLayout.removeView(settingsHomeEView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_18(){
        if(folderState.equals("Enabled")) {
            edit(this, "Home/Configurations", "Folder State - " + folderState, "Folder State - Disabled");
        } else {
            edit(this, "Home/Configurations", "Folder State - " + folderState, "Folder State - Enabled");
        }
        settingsHomeFolder();
        homeFolder_Flower();
        homeCenterPositions();
    }

    private void settingsHomePress_19(){
        settingsHomeE_CommonA();
        settingsHomeFolder_A();
    }

    private void settingsHomePress_20(){
        if(folderSortingOrder.equals("Alphabetically")){
            edit(this, "Home/Configurations", "Folder Sorting Order - "
                    + folderSortingOrder, "Folder Sorting Order - Random");
        } else {
            edit(this, "Home/Configurations", "Folder Sorting Order - "
                    + folderSortingOrder, "Folder Sorting Order - Alphabetically");
        }
        homeConfigurations();
        settingsHomeEText5.setText(folderSortingOrder);
        if(settingsHomeEListItems != null){
            if(folderSortingOrder.equals("Alphabetically")){
                Collections.sort(settingsHomeEArray, new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return appLabel(TheNest.this, a).compareTo(appLabel(TheNest.this, b));
                    }
                });
            } else {
                Collections.sort(settingsHomeEArray);
            }
            settingsHomeEListItems.notifyDataSetChanged();
        }
        if(folderListItems != null){
            if(folderSortingOrder.equals("Alphabetically")){
                Collections.sort(folderListArray, new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return appLabel(TheNest.this, a).compareTo(appLabel(TheNest.this, b));
                    }
                });
            } else {
                Collections.sort(folderListArray);
            }
            folderListItems.clear();
            folderListItems.addAll(folderListArray);
            folderListItems.notifyDataSetChanged();
        }
    }

    private void settingsHomePress_21(){
        settingsHomeE_CommonB();
    }

    private void settingsHomePress_22(){
        settingsHomeLayout.removeView(settingsHomeFView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_23(){
        if(statusState.equals("Enabled")) {
            edit(this, "Home/Configurations", "Status State - " + statusState, "Status State - Disabled");
        } else {
            edit(this, "Home/Configurations", "Status State - " + statusState, "Status State - Enabled");
        }
        settingsHomeStatus();
        homeStatus();
        homeCenterPositions();
    }

    private void settingsHomePress_24(){
        settingsHomeFFrame1.setVisibility(View.GONE);
        settingsHomeFFrame5.setVisibility(View.VISIBLE);
        settingsHomeStatus_A();
    }

    private void settingsHomePress_25(){
        settingsHomeFFrame1.setVisibility(View.VISIBLE);
        settingsHomeFFrame5.setVisibility(View.GONE);
    }

    private void settingsHomePress_26(){
        edit(this, "Home/Configurations", "Status Mode - " + statusMode, "Status Mode - " + settingsHomeFString);
        homeConfigurations();
        homeStatus();
        settingsHomeFFrame6.setVisibility(View.GONE);
        settingsHomeFListView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_27(){
        settingsHomeFFrame6.setVisibility(View.GONE);
        settingsHomeFListView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_28(){
        settingsHomeLayout.removeView(settingsHomeGView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_29(){
        String icon = "";
        if(drawerIcon.equals("BeeHive"))
            icon = "SimpliC";
        if(drawerIcon.equals("SimpliC"))
            icon = "BeeHive";
        edit(this, "Home/Configurations", "Drawer Icon - " + drawerIcon, "Drawer Icon - " + icon);
        settingsHomeDrawer();
        homeDrawerPresets(homeDrawerAIcon);
    }

    private void settingsHomePress_30(){
        String size = "";
        if(drawerSize.equals("A"))
            size = "B";
        if(drawerSize.equals("B"))
            size = "C";
        if(drawerSize.equals("C"))
            size = "D";
        if(drawerSize.equals("D"))
            size = "E";
        if(drawerSize.equals("E"))
            size = "A";
        edit(this, "Home/Configurations", "Drawer Size - " + drawerSize, "Drawer Size - " + size);
        settingsHomeDrawer();
        homeDrawerPresets(homeDrawerAIcon);
    }
    private void settingsHomePress_31(){
        float alpha = 0.0f;
        if(drawerAlpha == 1.0f)
            alpha = 0.0f;
        if(drawerAlpha == 0.0f)
            alpha = 0.5f;
        if(drawerAlpha == 0.5f)
            alpha = 1.0f;
        edit(this, "Home/Configurations", "Drawer Alpha - " + drawerAlpha, "Drawer Alpha - " + alpha);
        settingsHomeDrawer();
        homeDrawerPresets(homeDrawerAIcon);
    }
    private void settingsHomePress_32(){
        edit(this, "Home/Configurations", "Drawer Icon - " + drawerIcon, "Drawer Icon - BeeHive");
        edit(this, "Home/Configurations", "Drawer Size - " + drawerSize, "Drawer Size - C");
        edit(this, "Home/Configurations", "Drawer Alpha - " + drawerAlpha, "Drawer Alpha - 1.0");
        settingsHomeDrawer();
        homeDrawerPresets(homeDrawerAIcon);
    }

    private void settingsHomePress_33(){
        settingsHomeLayout.removeView(settingsHomeHView);
        settingsHomeAView.setVisibility(View.VISIBLE);
    }

    private void settingsHomePress_34(){
        if(shortcutState.equals("Enabled")) {
            edit(this, "Home/Configurations", "Shortcut State - " + shortcutState, "Shortcut State - Disabled");
        } else {
            edit(this, "Home/Configurations", "Shortcut State - " + shortcutState, "Shortcut State - Enabled");
        }
        settingsHomeShortcut();
        homeSHORTCUT();
    }

    private void settingsHomePress_35(){
        settingsHomeH_CommonA();
        settingsHomeShortcut_A();
    }

    private void settingsHomePress_36(){
        settingsHomeH_CommonB();
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeView;
    RelativeLayout settingsHomeLayout;
    private void settingsHome(){
        if(settingsHomeView == null){
            settingsHomeView = inflater.inflate(R.layout.settings_home, null);
            settingsHomeLayout = settingsHomeView.findViewById(R.id.settings_home);
        }
        if(theNestSettingsLayout.findViewById(R.id.settings_home) == null){
            theNestSettingsLayout.addView(settingsHomeView);
            layoutParamsTypeC(this, settingsHomeLayout, new int[]{direction(5)}, direction(8), R.id.settings_edge_a, direction(7), R.id.settings_tooltip);
            setSize(this, settingsHomeLayout, size(2), size(2));
            setMargins(this, settingsHomeLayout, -40, 20, 20, 60);
            settingsEdgeAText.setText(textC(40));
            if(settingsHomeLayout.getChildCount() == 0){
                settingsHomeAView();
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeAView;
    RelativeLayout settingsHomeA;
    ListView settingsHomeAListView;
    ListTypeD homeAItems;
    private void settingsHomeAView(){
        if(settingsHomeAView == null){
            settingsHomeAView = inflater.inflate(R.layout.settings_home_a, null);
            settingsHomeA = settingsHomeAView.findViewById(R.id.settings_home_a);
            settingsHomeAListView = settingsHomeAView.findViewById(R.id.settings_home_a_list_view);

            backgroundTypeC(this, settingsHomeA, background(3), tintA);
            settingsHomeAList();
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_a) == null){
            settingsHomeLayout.addView(settingsHomeAView);
            setSize(this, settingsHomeA, size(2), size(2));
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeAList(){
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(reduceBitmap(this, icon(46), 60));
        bitmaps.add(reduceBitmap(this, icon(51), 60));
        bitmaps.add(reduceBitmap(this, icon(47), 60));
        bitmaps.add(reduceBitmap(this, icon(37), 60));
        bitmaps.add(reduceBitmap(this, icon(44), 60));
        bitmaps.add(reduceBitmap(this, icon(36), 60));
        bitmaps.add(reduceBitmap(this, icon(52), 60));

        ArrayList<String> strings_a = new ArrayList<>();
        strings_a.add(textC(0));
        strings_a.add(textC(7));
        strings_a.add(textC(1));
        strings_a.add(textC(2));
        strings_a.add(textC(3));
        strings_a.add(textC(5));
        strings_a.add(textC(4));

        ArrayList<String> strings_b = new ArrayList<>();
        strings_b.add(textB(49));
        strings_b.add(textB(50));
        strings_b.add(textB(51));
        strings_b.add(textB(52));
        strings_b.add(textB(53));
        strings_b.add(textB(54));
        strings_b.add(textB(55));

        Handler settingsHomeAHandler = new Handler();
        Runnable settingsHomeARunnable = new Runnable() {
            @Override
            public void run() {
                if(homeListStyle.equals("Square")){
                    homeAItems = new ListTypeD(TheNest.this, R.layout.list_type_b, bitmaps, strings_a, strings_b, TheNest.this);
                }
                if(homeListStyle.equals("Cylinder")){
                    homeAItems = new ListTypeD(TheNest.this, R.layout.list_type_c, bitmaps, strings_a, strings_b, TheNest.this);
                }
                if(homeListStyle.equals("Hexagon")){
                    homeAItems = new ListTypeD(TheNest.this, R.layout.list_type_d, bitmaps, strings_a, strings_b, TheNest.this);
                }
                settingsHomeAListView.setAdapter(homeAItems);
            }
        };
        settingsHomeAHandler.postDelayed(settingsHomeARunnable, 100);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    @Override
    public void homeScreenOptions(int mode) {
        if(mode == 0)
            settingsHomeB();
        if(mode == 1)
            settingsHomeC();
        if(mode == 2)
            settingsHomeD();
        if(mode == 3)
            settingsHomeE();
        if(mode == 4)
            settingsHomeF();
        if(mode == 5)
            settingsHomeG();
        if(mode == 6)
            settingsHomeH();
        settingsHomeAView.setVisibility(View.GONE);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeBView;
    RelativeLayout settingsHomeB, settingsHomeBFrame1, settingsHomeBFrame2, settingsHomeBFrame3, settingsHomeBFrame4,
            settingsHomeBFrame5, settingsHomeBFrame6, settingsHomeBFrame7, settingsHomeBFrame8, settingsHomeBFrame9,
            settingsHomeBFrame10;
    TextView settingsHomeBLines, settingsHomeBText1, settingsHomeBText2, settingsHomeBText3, settingsHomeBText4,
            settingsHomeBText5, settingsHomeBText6;
    ImageView settingsHomeBImage, settingsHomeBCircle, settingsHomeBIcon1, settingsHomeBIcon2,
            settingsHomeBIcon3, settingsHomeBIcon4, settingsHomeBIcon5, settingsHomeBIcon6;
    ListView settingsHomeBListView;
    private void settingsHomeB(){
        if(settingsHomeBView == null){
            settingsHomeBView = inflater.inflate(R.layout.settings_home_b, null);
            settingsHomeB = settingsHomeBView.findViewById(R.id.settings_home_b);
            settingsHomeBCircle = settingsHomeBView.findViewById(R.id.settings_home_b_circle);
            settingsHomeBImage = settingsHomeBView.findViewById(R.id.settings_home_b_image);
            settingsHomeBIcon1 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_1);
            settingsHomeBIcon2 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_2);
            settingsHomeBIcon3 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_3);
            settingsHomeBIcon4 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_4);
            settingsHomeBIcon5 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_5);
            settingsHomeBIcon6 = settingsHomeBView.findViewById(R.id.settings_home_b_icon_6);
            settingsHomeBFrame1 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_1);
            settingsHomeBFrame2 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_2);
            settingsHomeBFrame3 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_3);
            settingsHomeBFrame4 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_4);
            settingsHomeBFrame5 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_5);
            settingsHomeBFrame6 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_6);
            settingsHomeBFrame7 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_7);
            settingsHomeBFrame8 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_8);
            settingsHomeBFrame9 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_9);
            settingsHomeBFrame10 = settingsHomeBView.findViewById(R.id.settings_home_b_frame_10);
            settingsHomeBText1 = settingsHomeBView.findViewById(R.id.settings_home_b_text_1);
            settingsHomeBText2 = settingsHomeBView.findViewById(R.id.settings_home_b_text_2);
            settingsHomeBText3 = settingsHomeBView.findViewById(R.id.settings_home_b_text_3);
            settingsHomeBText4 = settingsHomeBView.findViewById(R.id.settings_home_b_text_4);
            settingsHomeBText5 = settingsHomeBView.findViewById(R.id.settings_home_b_text_5);
            settingsHomeBText6 = settingsHomeBView.findViewById(R.id.settings_home_b_text_6);
            settingsHomeBLines = settingsHomeBView.findViewById(R.id.settings_home_b_lines);
            settingsHomeBListView = settingsHomeBView.findViewById(R.id.settings_home_b_list_view);

            backgroundTypeA(this, settingsHomeBFrame2, background(7), ui, 3);
            backgroundTypeA(this, settingsHomeBFrame4, background(5), tintA, 3);
            backgroundTypeC(this, settingsHomeBFrame5, background(3), tintA);
            backgroundTypeC(this, settingsHomeBFrame6, background(10), tintA);
            backgroundTypeC(this, settingsHomeBFrame7, background(3), tintA);
            backgroundTypeC(this, settingsHomeBFrame8, background(5), tintB);
            backgroundTypeC(this, settingsHomeBFrame9, background(5), tintB);
            backgroundTypeC(this, settingsHomeBFrame10, background(5), ui);

            imageTypeB(this, settingsHomeBCircle, background(4), ui);
            imageTypeA(this, settingsHomeBIcon2, icon(33), tintA, 75);
            imageTypeA(this, settingsHomeBIcon3, icon(31), tintA, 30);
            imageTypeA(this, settingsHomeBIcon4, icon(33), tintB, 65);
            imageTypeA(this, settingsHomeBIcon6, icon(48), tintA, 30);

            textType(this, settingsHomeBText1, textC(0), tintA, fontAStyle);
            textType(this, settingsHomeBText2, "", tintA, fontBStyle);
            textType(this, settingsHomeBText3, "", tintB, fontBStyle);
            textType(this, settingsHomeBText4, textB(60), tintA, fontBStyle);
            textType(this, settingsHomeBText5, "", tintB, fontAStyle);
            textType(this, settingsHomeBText6, "", tintB, fontBStyle);
            textType(this, settingsHomeBLines, textA(9), tintB, Typeface.BOLD);

            customTouchModeB(settingsHomeBIcon2, textC(48), 2, 4, 0);
            customTouchModeB(settingsHomeBIcon4, textC(48), 2, 4, 5);
            customTouchModeB(settingsHomeBFrame2, "", 2, 4, 1);
            customTouchModeB(settingsHomeBFrame4, "", 2, 4, 2);
            customTouchModeB(settingsHomeBFrame5, "", 2, 4, 3);
            customTouchModeB(settingsHomeBFrame9, textC(49), 2, 4, 4);
            customTouchModeB(settingsHomeBFrame10, textC(10), 2, 4, 6);

            settingsHomeBFrame6.setVisibility(View.GONE);
            settingsHomeBFrame7.setVisibility(View.GONE);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_b) == null){
            settingsHomeLayout.addView(settingsHomeBView);
            setSize(this, settingsHomeB, size(2), size(2));
            setMargins(this, settingsHomeB, 20, 20, 20, 20);
            settingsHomeWidgets();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeWidgets(){
        homeConfigurations();
        if(widgetState.equals("Enabled")) {
            toggleMode(this, settingsHomeBCircle, true);
            settingsHomeBFrame3.setVisibility(View.VISIBLE);
            settingsHomeBText4.setVisibility(View.VISIBLE);
            if(settingsHomeBFrame7.getVisibility() != View.VISIBLE){
                settingsHomeBFrame7.setVisibility(View.GONE);
                settingsHomeBFrame3.setAlpha(1.0f);
                customTouchModeB(settingsHomeBFrame4, "", 2, 4, 2);
                customTouchModeB(settingsHomeBFrame5, "", 2, 4, 3);
                if(settingsHomeBFrame6.getVisibility() != View.VISIBLE){
                    settingsHomeBFrame1.setVisibility(View.VISIBLE);
                    settingsHomeBFrame6.setVisibility(View.GONE);
                }
            }
            settingsHomeWidgetsTabs();
        } else {
            toggleMode(this, settingsHomeBCircle, false);
            settingsHomeBText2.setText(textB(56));
            settingsHomeBFrame1.setVisibility(View.VISIBLE);
            settingsHomeBFrame3.setVisibility(View.GONE);
            settingsHomeBText4.setVisibility(View.GONE);
            settingsHomeBFrame6.setVisibility(View.GONE);
            settingsHomeBFrame7.setVisibility(View.GONE);
            settingsHomeBFrame3.setAlpha(1.0f);
            customTouchModeB(settingsHomeBFrame4, "", 2, 4, 2);
            customTouchModeB(settingsHomeBFrame5, "", 2, 4, 3);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeWidgetsTabs(){
        settingsHomeBText2.setText(textB(57));
        if(settingsHomeBInt_a == 0){
            settingsHomeBText3.setText(textB(58));
            imageTypeA(this, settingsHomeBIcon1, icon(56), tintA, 65);
        }
        if(settingsHomeBInt_a == 1){
            settingsHomeBText3.setText(textB(59));
            imageTypeA(this, settingsHomeBIcon1, icon(55), tintA, 65);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    ListTypeE homeBItems;
    private void settingsHomeWidgetsLists(){
        if(homeWidgetManager == null)
            homeWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
        try {
            homeBItems.clear();
        } catch (Exception e){}
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        ArrayList<Drawable> drawables = new ArrayList<>();
        ArrayList<String> strings_a = new ArrayList<>();
        ArrayList<String> strings_b = new ArrayList<>();
        if(settingsHomeBInt_a == 0){
            bitmaps.add(reduceBitmap(this, icon(53), 50));
            bitmaps.add(reduceBitmap(this, icon(54), 50));
            drawables.add(new BitmapDrawable(getResources(), reduceBitmap(this, drawable(4),120)));
            drawables.add(new BitmapDrawable(getResources(), reduceBitmap(this, drawable(5),120)));
            strings_a.add(getPackageName());
            strings_a.add(getPackageName());
            strings_b.add("Analog Clock");
            strings_b.add("Simple Clock");

            homeBItems = new ListTypeE(this, bitmaps, drawables, strings_a, strings_b, settingsHomeBInt_a, this);
            settingsHomeBListView.setAdapter(homeBItems);
        }
        if(settingsHomeBInt_a == 1){
            Handler settingsHomeBHandler =  new Handler();
            Runnable settingsHomeBRunnable =  new Runnable() {
                @Override
                public void run() {
                    List<AppWidgetProviderInfo> widgetInfo = homeWidgetManager.getInstalledProviders();
                    for (AppWidgetProviderInfo info : widgetInfo) {
                        bitmaps.add(roundedBitmap(adaptiveIcon(TheNest.this, info.provider.getPackageName(), 40)));
                        drawables.add(info.loadPreviewImage(TheNest.this, 100));
                        strings_a.add(info.provider.getPackageName());
                        strings_b.add(info.loadLabel(getPackageManager()));
                    }
                    homeBItems = new ListTypeE(TheNest.this, bitmaps, drawables, strings_a, strings_b, settingsHomeBInt_a, TheNest.this);
                    settingsHomeBListView.setAdapter(homeBItems);
                }
            };
            settingsHomeBHandler.postDelayed(settingsHomeBRunnable, 50);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private String settingsHomeBString_a;
    private String settingsHomeBString_b;
    private int settingsHomeBInt_a;
    private int settingsHomeBInt_b;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void widget(String widgetPackage, String widgetModule, Bitmap widgetIcon, Drawable widgetPreview, int widgetMode) {
        settingsHomeBFrame6.setVisibility(View.GONE);
        settingsHomeBFrame7.setVisibility(View.VISIBLE);
        settingsHomeBFrame3.setAlpha(.5f);
        settingsHomeBFrame4.setOnTouchListener(null);
        settingsHomeBFrame5.setOnTouchListener(null);

        settingsHomeBString_a = widgetPackage;
        settingsHomeBString_b = widgetModule;
        settingsHomeBInt_b = widgetMode;

        settingsHomeBText5.setText(widgetModule);
        try {
            settingsHomeBText6.setText("By - " + getPackageManager().getApplicationInfo(settingsHomeBString_a, 0).loadLabel(getPackageManager()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        settingsHomeBIcon5.setImageBitmap(widgetIcon);
        settingsHomeBImage.setImageDrawable(widgetPreview);

        if(settingsHomeBInt_b == 0){
            switchTint(this, settingsHomeBIcon5, tintB);
        } else {
            switchTint(this, settingsHomeBIcon5, R.color.transparent);
        }

        settingsHomeBFrame9.setVisibility(View.VISIBLE);
        settingsHomeBFrame10.setVisibility(View.GONE);
        if(settingsHomeBInt_b == 0){
            if((settingsHomeBString_b.equals("Analog Clock") && widgetComponent.equals("Clock 1"))
                    || (settingsHomeBString_b.equals("Simple Clock") && widgetComponent.equals("Clock 2"))){
                settingsHomeBFrame9.setVisibility(View.INVISIBLE);
                settingsHomeBFrame10.setVisibility(View.VISIBLE);
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void homeWidgetInitiate(){
        if(homeWidgetManager == null)
            homeWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
        if(homeWidgetHost == null)
            homeWidgetHost = new AppWidgetHost(getApplicationContext(), 2062);

        List<AppWidgetProviderInfo> widgetInfo = homeWidgetManager.getInstalledProviders();
        for (AppWidgetProviderInfo info : widgetInfo) {
            if(info.provider.getPackageName().equals(settingsHomeBString_a)){
                edit(this, "Home/Configurations", "Widget Component - " + widgetComponent, "Widget Component - " + info.provider.getPackageName());
                if(info.loadLabel(getPackageManager()).equals(settingsHomeBString_b)){
                    int widget_ID = homeWidgetHost.allocateAppWidgetId();
                    edit(this, "Home/Configurations", "Widget ID - " + widgetID, "Widget ID - " + widget_ID);
                    widgetID = widget_ID;

                    if(info.configure != null){
                        Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_CONFIGURE);
                        intent.setComponent(info.configure);
                        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
                        homeWidgetManager.bindAppWidgetIdIfAllowed(widgetID, info.provider);
                        homeWidgetHost.startAppWidgetConfigureActivityForResult(this, widgetID, intent.getFlags(), 2062, null);
                        //startActivityForResult(intent, 2062);
                    } else {
                        widgetCommon(info);
                    }
                }
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private boolean settingsHomeBBoolean;
    private void widgetCommon(AppWidgetProviderInfo info) {
        homeConfigurations();
        if(homeWidgetLayout.findViewById(R.id.home_widget_b) == null)
            homeWIDGET();
        homeWidgetCommon(info);
        if(hostView != null) {
            hostView.removeAllViews();
            hostView = null;
        }
        homeWidgetResource.removeAllViews();
        settingsHomeBBoolean = true;
        /*Intent intent = new Intent(AppWidgetManager.ACTION_APPWIDGET_BIND);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetID);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_PROVIDER, info.provider);
        startActivityForResult(intent, 0);*/
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 2062) {
                createWidget(data);
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void createWidget(Intent data) {
        Bundle extras = data.getExtras();
        widgetID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, -1);
        List<AppWidgetProviderInfo> widgetInfo = homeWidgetManager.getInstalledProviders();
        for (AppWidgetProviderInfo info : widgetInfo) {
            if(info.provider.getPackageName().equals(settingsHomeBString_a)){
                if(info.loadLabel(getPackageManager()).matches(settingsHomeBString_b)){
                    if(info.configure != null){
                        widgetCommon(info);
                    }
                }
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeCView;
    RelativeLayout settingsHomeC, settingsHomeCFrame1, settingsHomeCFrame2, settingsHomeCFrame3, settingsHomeCFrame4;
    TextView settingsHomeCText1, settingsHomeCText2, settingsHomeCText3;
    ImageView settingsHomeCIcon1, settingsHomeCIcon2, settingsHomeCIcon3;
    EditText settingsHomeCEditText;
    private void settingsHomeC(){
        if(settingsHomeCView == null){
            settingsHomeCView = inflater.inflate(R.layout.settings_home_c, null);
            settingsHomeC = settingsHomeCView.findViewById(R.id.settings_home_c);
            settingsHomeCIcon1 = settingsHomeCView.findViewById(R.id.settings_home_c_icon_1);
            settingsHomeCIcon2 = settingsHomeCView.findViewById(R.id.settings_home_c_icon_2);
            settingsHomeCIcon3 = settingsHomeCView.findViewById(R.id.settings_home_c_icon_3);
            settingsHomeCFrame1 = settingsHomeCView.findViewById(R.id.settings_home_c_frame_1);
            settingsHomeCFrame2 = settingsHomeCView.findViewById(R.id.settings_home_c_frame_2);
            settingsHomeCFrame3 = settingsHomeCView.findViewById(R.id.settings_home_c_frame_3);
            settingsHomeCFrame4 = settingsHomeCView.findViewById(R.id.settings_home_c_frame_4);
            settingsHomeCText1 = settingsHomeCView.findViewById(R.id.settings_home_c_text_1);
            settingsHomeCText2 = settingsHomeCView.findViewById(R.id.settings_home_c_text_2);
            settingsHomeCText3 = settingsHomeCView.findViewById(R.id.settings_home_c_text_3);
            settingsHomeCEditText = settingsHomeCView.findViewById(R.id.settings_home_c_edittext);

            backgroundTypeA(this, settingsHomeCFrame3, background(5), tintA, 3);
            backgroundTypeC(this, settingsHomeCFrame4, background(3), tintA);

            imageTypeA(this, settingsHomeCIcon2, icon(42), tintA, 50);
            imageTypeA(this, settingsHomeCIcon3, icon(33), tintA, 75);

            textType(this, settingsHomeCText1, textC(7), tintA, fontAStyle);
            textType(this, settingsHomeCText2, textB(62), tintA, fontBStyle);
            textType(this, settingsHomeCText3, "", tintB, fontAStyle);

            customTypeB(this, settingsHomeCEditText, textA(6), tintB, fontBStyle);

            customTouchModeB(settingsHomeCIcon3, textC(48), 2, 4, 7);
            customTouchModeB(settingsHomeCFrame3, textC(22), 2, 4, 10);

            settingsHomeC_CommonA();
            settingsHomeApplet();
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_c) == null){
            settingsHomeLayout.addView(settingsHomeCView);
            setSize(this, settingsHomeC, size(2), size(2));
            setMargins(this, settingsHomeC, 20, 20, 20, 20);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeApplet(){
        settingsHomeCEditText.setText(appletText);
        settingsHomeCText3.setText(appletText);
        if(!appletText.equals("∆×••⟨[ ]⟩")){
            settingsHomeCFrame3.setVisibility(View.VISIBLE);
        } else {
            settingsHomeCFrame3.setVisibility(View.GONE);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeDView;
    RelativeLayout settingsHomeD, settingsHomeDFrame1, settingsHomeDFrame2, settingsHomeDFrame3, settingsHomeDFrame4,
            settingsHomeDFrame5, settingsHomeDFrame6, settingsHomeDFrame7;
    TextView settingsHomeDLines, settingsHomeDText1, settingsHomeDText2, settingsHomeDText3, settingsHomeDText4;
    ImageView settingsHomeDImage, settingsHomeDCircle, settingsHomeDIcon1, settingsHomeDIcon2, settingsHomeDIcon3;
    private void settingsHomeD(){
        if(settingsHomeDView == null){
            settingsHomeDView = inflater.inflate(R.layout.settings_home_d, null);
            settingsHomeD = settingsHomeDView.findViewById(R.id.settings_home_d);
            settingsHomeDCircle = settingsHomeDView.findViewById(R.id.settings_home_d_circle);
            settingsHomeDImage = settingsHomeDView.findViewById(R.id.settings_home_d_image);
            settingsHomeDIcon1 = settingsHomeDView.findViewById(R.id.settings_home_d_icon_1);
            settingsHomeDIcon2 = settingsHomeDView.findViewById(R.id.settings_home_d_icon_2);
            settingsHomeDIcon3 = settingsHomeDView.findViewById(R.id.settings_home_d_icon_3);
            settingsHomeDFrame1 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_1);
            settingsHomeDFrame2 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_2);
            settingsHomeDFrame3 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_3);
            settingsHomeDFrame4 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_4);
            settingsHomeDFrame5 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_5);
            settingsHomeDFrame6 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_6);
            settingsHomeDFrame7 = settingsHomeDView.findViewById(R.id.settings_home_d_frame_7);
            settingsHomeDText1 = settingsHomeDView.findViewById(R.id.settings_home_d_text_1);
            settingsHomeDText2 = settingsHomeDView.findViewById(R.id.settings_home_d_text_2);
            settingsHomeDText3 = settingsHomeDView.findViewById(R.id.settings_home_d_text_3);
            settingsHomeDText4 = settingsHomeDView.findViewById(R.id.settings_home_d_text_4);
            settingsHomeDLines = settingsHomeDView.findViewById(R.id.settings_home_d_lines);

            backgroundTypeA(this, settingsHomeDFrame2, background(7), ui, 3);
            backgroundTypeA(this, settingsHomeDFrame4, background(5), tintA, 3);
            backgroundTypeC(this, settingsHomeDFrame5, background(3), tintA);
            backgroundTypeC(this, settingsHomeDFrame6, background(10), tintA);

            imageTypeA(this, settingsHomeDImage, drawable(1), R.color.transparent, 70);
            imageTypeB(this, settingsHomeDCircle, background(4), ui);
            imageTypeA(this, settingsHomeDIcon1, icon(33), tintA, 75);

            textType(this, settingsHomeDText1, textC(1), tintA, fontAStyle);
            textType(this, settingsHomeDText2, "", tintA, fontBStyle);
            textType(this, settingsHomeDText3, "", tintB, fontBStyle);
            textType(this, settingsHomeDText4, "", tintA, fontBStyle);
            textType(this, settingsHomeDLines, textA(9), tintA, Typeface.BOLD);

            customTouchModeB(settingsHomeDIcon1, textC(48), 2, 4, 11);
            customTouchModeB(settingsHomeDFrame2, "", 2, 4, 12);
            customTouchModeB(settingsHomeDFrame4, "", 2, 4, 13);
            customTouchModeB(settingsHomeDFrame5, "", 2, 4, 14);

            settingsHomeDFrame6.setVisibility(View.GONE);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_d) == null){
            settingsHomeLayout.addView(settingsHomeDView);
            setSize(this, settingsHomeD, size(2), size(2));
            setMargins(this, settingsHomeD, 20, 20, 20, 20);
            settingsHomeWallpaper();
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeWallpaper(){
        homeConfigurations();
        if(wallpaperState.equals("Enabled")){
            toggleMode(this, settingsHomeDCircle, true);
            if(settingsHomeDFrame6.getVisibility() != View.VISIBLE){
                settingsHomeD_CommonB();
                settingsHomeWallpaper_A();
            }
        } else {
            toggleMode(this, settingsHomeDCircle, false);
            settingsHomeDText2.setText(textB(63));
            settingsHomeDFrame1.setVisibility(View.VISIBLE);
            settingsHomeDFrame3.setVisibility(View.GONE);
            settingsHomeDFrame6.setVisibility(View.GONE);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private int settingsHomeDInt;
    private void settingsHomeWallpaper_A(){
        settingsHomeDText2.setText(textB(64));
        if(settingsHomeDInt == 0){
            settingsHomeDText3.setText(textB(65));
            imageTypeA(this, settingsHomeDIcon2, icon(56), tintA, 65);
        }
        if(settingsHomeDInt == 1){
            settingsHomeDText3.setText(textB(66));
            imageTypeA(this, settingsHomeDIcon2, icon(55), tintA, 65);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    @SuppressLint("ClickableViewAccessibility")
    private void settingsHomeWallpaper_B(){
        if(settingsHomeDInt == 0){
            settingsHomeDText4.setText(textB(68));
            settingsHomeDImage.setVisibility(View.VISIBLE);
            if(wallpaperComponent.equals("Blocks")){
                imageTypeA(this, settingsHomeDIcon3, icon(48), tintB, 40);
                backgroundTypeC(this, settingsHomeDFrame7, background(4), ui);
                customTouchModeB(settingsHomeDFrame7, textC(10), 2, 4, 16);
            } else {
                settingsHomeD_CommonA();
            }
        }
        if(settingsHomeDInt == 1){
            settingsHomeDImage.setVisibility(View.GONE);
            settingsHomeD_CommonA();
            if(wallpaperMode.equals("Device")){
                settingsHomeDText4.setText(textB(69));
                settingsHomeDFrame7.setAlpha(.5f);
                settingsHomeDFrame7.setOnTouchListener(null);
            } else {
                settingsHomeDText4.setText(textB(67));
            }
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    private void settingsHomeD_CommonA(){
        settingsHomeDFrame7.setAlpha(1.0f);
        imageTypeA(this, settingsHomeDIcon3, icon(31), tintB, 40);
        backgroundTypeC(this, settingsHomeDFrame7, background(4), tintA);
        customTouchModeB(settingsHomeDFrame7, textC(49), 2, 4, 15);
    }

    private void settingsHomeD_CommonB(){
        settingsHomeDFrame1.setVisibility(View.VISIBLE);
        settingsHomeDFrame3.setVisibility(View.VISIBLE);
        settingsHomeDFrame6.setVisibility(View.GONE);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeEView;
    RelativeLayout settingsHomeE, settingsHomeEFrame1, settingsHomeEFrame2, settingsHomeEFrame3, settingsHomeEFrame4,
            settingsHomeEFrame5, settingsHomeEFrame6;
    TextView settingsHomeEText1, settingsHomeEText2, settingsHomeEText3, settingsHomeEText4, settingsHomeEText5;
    ImageView settingsHomeECircle, settingsHomeEIcon1, settingsHomeEIcon2, settingsHomeEIcon3;
    ListView settingsHomeEListView;
    private void settingsHomeE(){
        if(settingsHomeEView == null){
            settingsHomeEView = inflater.inflate(R.layout.settings_home_e, null);
            settingsHomeE = settingsHomeEView.findViewById(R.id.settings_home_e);
            settingsHomeECircle = settingsHomeEView.findViewById(R.id.settings_home_e_circle);
            settingsHomeEIcon1 = settingsHomeEView.findViewById(R.id.settings_home_e_icon_1);
            settingsHomeEIcon2 = settingsHomeEView.findViewById(R.id.settings_home_e_icon_2);
            settingsHomeEIcon3 = settingsHomeEView.findViewById(R.id.settings_home_e_icon_3);
            settingsHomeEFrame1 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_1);
            settingsHomeEFrame2 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_2);
            settingsHomeEFrame3 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_3);
            settingsHomeEFrame4 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_4);
            settingsHomeEFrame5 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_5);
            settingsHomeEFrame6 = settingsHomeEView.findViewById(R.id.settings_home_e_frame_6);
            settingsHomeEText1 = settingsHomeEView.findViewById(R.id.settings_home_e_text_1);
            settingsHomeEText2 = settingsHomeEView.findViewById(R.id.settings_home_e_text_2);
            settingsHomeEText3 = settingsHomeEView.findViewById(R.id.settings_home_e_text_3);
            settingsHomeEText4 = settingsHomeEView.findViewById(R.id.settings_home_e_text_4);
            settingsHomeEText5 = settingsHomeEView.findViewById(R.id.settings_home_e_text_5);
            settingsHomeEListView = settingsHomeEView.findViewById(R.id.settings_home_e_list_view);

            backgroundTypeA(this, settingsHomeEFrame2, background(7), ui, 3);
            backgroundTypeA(this, settingsHomeEFrame4, background(5), tintA, 3);
            backgroundTypeA(this, settingsHomeEFrame5, background(7), tintA, 10);
            backgroundTypeC(this, settingsHomeEFrame6, background(10), tintA);

            imageTypeB(this, settingsHomeECircle, background(4), ui);
            imageTypeA(this, settingsHomeEIcon1, icon(33), tintA, 75);
            imageTypeA(this, settingsHomeEIcon2, icon(57), tintA, 50);
            imageTypeA(this, settingsHomeEIcon3, icon(33), tintA, 65);

            textType(this, settingsHomeEText1, textC(2), tintA, fontAStyle);
            textType(this, settingsHomeEText2, "", tintA, fontBStyle);
            textType(this, settingsHomeEText3, textC(8), tintA, fontBStyle);
            textType(this, settingsHomeEText4, textB(72), tintA, fontBStyle);
            textType(this, settingsHomeEText5, folderSortingOrder, tintA, fontBStyle);

            customTouchModeB(settingsHomeEIcon1, textC(48), 2, 4, 17);
            customTouchModeB(settingsHomeEIcon3, textC(48), 2, 4, 21);
            customTouchModeB(settingsHomeEFrame2, "", 2, 4, 18);
            customTouchModeB(settingsHomeEFrame4, textC(68), 2, 4, 19);
            customTouchModeB(settingsHomeEFrame5, textC(62), 2, 4, 20);

            settingsHomeEFrame6.setVisibility(View.GONE);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_e) == null){
            settingsHomeLayout.addView(settingsHomeEView);
            setSize(this, settingsHomeE, size(2), size(2));
            setMargins(this, settingsHomeE, 20, 20, 20, 20);
            settingsHomeFolder();
        }
    }

    private void settingsHomeFolder(){
        homeConfigurations();
        if(folderState.equals("Enabled")){
            toggleMode(this, settingsHomeECircle, true);
            settingsHomeEText2.setText(textB(71));
            if(settingsHomeEFrame6.getVisibility() != View.VISIBLE){
                settingsHomeE_CommonB();
            } else {
                settingsHomeFolder_A();
            }
        } else {
            toggleMode(this, settingsHomeECircle, false);
            settingsHomeEText2.setText(textB(70));

            settingsHomeEFrame1.setVisibility(View.VISIBLE);
            settingsHomeEFrame3.setVisibility(View.GONE);
            settingsHomeEFrame6.setVisibility(View.GONE);
        }
    }

    ListTypeF settingsHomeEListItems;
    List<String> settingsHomeEArray;
    private void settingsHomeFolder_A(){
        Handler settingsHomeEHandler = new Handler();
        Runnable settingsHomeERunnable = new Runnable() {
            @Override
            public void run() {
                settingsHomeFolder_Branch();
            }
        };
        settingsHomeEHandler.postDelayed(settingsHomeERunnable, 100);
    }

    private void settingsHomeFolder_Branch(){
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = getPackageManager().queryIntentActivities(intent, PackageManager.GET_META_DATA);
        if(settingsHomeEInt == 0 || settingsHomeEInt != apps.size() || settingsHomeEBoolean){
            settingsHomeEInt = apps.size();
            settingsHomeEBoolean = false;
            if(folderSortingOrder.equals("Alphabetically")){
                Collections.sort(apps, new Comparator<ResolveInfo>() {
                    @Override
                    public int compare(ResolveInfo resolveInfo_1, ResolveInfo resolveInfo_2) {
                        return resolveInfo_1.loadLabel(getPackageManager()).toString().compareTo(resolveInfo_2.loadLabel(getPackageManager()).toString());
                    }
                });
            }
            for (ResolveInfo resolveInfo : apps) {
                if(fileExist(TheNest.this, "List/Array - 01")) {
                    List<String> readValues = read(TheNest.this, "List/Array - 01");
                    if(!readValues.contains(resolveInfo.activityInfo.packageName)){
                        settingsHomeE_CommonC(resolveInfo);
                    }
                } else {
                    settingsHomeE_CommonC(resolveInfo);
                }
            }
        }
    }

    private void settingsHomeE_CommonA(){
        settingsHomeEFrame1.setVisibility(View.GONE);
        settingsHomeEFrame3.setVisibility(View.GONE);
        settingsHomeEFrame6.setVisibility(View.VISIBLE);
    }

    private void settingsHomeE_CommonB(){
        settingsHomeEFrame1.setVisibility(View.VISIBLE);
        settingsHomeEFrame3.setVisibility(View.VISIBLE);
        settingsHomeEFrame6.setVisibility(View.GONE);
    }

    private void settingsHomeE_CommonC(ResolveInfo info){
        if(settingsHomeEArray == null)
            settingsHomeEArray = new ArrayList<>();

        if(!settingsHomeEArray.contains(info.activityInfo.packageName))
            settingsHomeEArray.add(info.activityInfo.packageName);

        if(settingsHomeEListView.getAdapter() != null){
            for(String app : settingsHomeEArray){
                if(!isAppInstalled(TheNest.this, app))
                    settingsHomeEArray.remove(app);
            }
            settingsHomeEListItems.notifyDataSetChanged();
        } else {
            settingsHomeEListItems = new ListTypeF(TheNest.this, settingsHomeEArray, TheNest.this);
            settingsHomeEListView.setAdapter(settingsHomeEListItems);
        }
    }

    private boolean settingsHomeEBoolean;
    private int settingsHomeEInt;
    @Override
    public void folder(String folderApp) {
        if(isAppInstalled(this, folderApp)){
            create(this, "List","/Array - 01", folderApp);
            touchTip(this, textC(20), 2);
        } else {
            touchTip(this, textC(67), 2);
        }
        settingsHomeEArray.remove(folderApp);
        settingsHomeEListItems.notifyDataSetChanged();
    }


    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeFView;
    RelativeLayout settingsHomeF, settingsHomeFFrame1, settingsHomeFFrame2, settingsHomeFFrame3, settingsHomeFFrame4,
            settingsHomeFFrame5, settingsHomeFFrame6, settingsHomeFFrame7;
    TextView settingsHomeFlines, settingsHomeFText1, settingsHomeFText2, settingsHomeFText3, settingsHomeFText4;
    ImageView settingsHomeFCircle, settingsHomeFIcon1, settingsHomeFIcon2, settingsHomeFIcon3, settingsHomeFIcon4,
            settingsHomeFIcon5;
    ListView settingsHomeFListView;
    private void settingsHomeF(){
        if(settingsHomeFView == null){
            settingsHomeFView = inflater.inflate(R.layout.settings_home_f, null);
            settingsHomeF = settingsHomeFView.findViewById(R.id.settings_home_f);
            settingsHomeFCircle = settingsHomeFView.findViewById(R.id.settings_home_f_circle);
            settingsHomeFIcon1 = settingsHomeFView.findViewById(R.id.settings_home_f_icon_1);
            settingsHomeFIcon2 = settingsHomeFView.findViewById(R.id.settings_home_f_icon_2);
            settingsHomeFIcon3 = settingsHomeFView.findViewById(R.id.settings_home_f_icon_3);
            settingsHomeFIcon4 = settingsHomeFView.findViewById(R.id.settings_home_f_icon_4);
            settingsHomeFIcon5 = settingsHomeFView.findViewById(R.id.settings_home_f_icon_5);
            settingsHomeFFrame1 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_1);
            settingsHomeFFrame2 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_2);
            settingsHomeFFrame3 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_3);
            settingsHomeFFrame4 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_4);
            settingsHomeFFrame5 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_5);
            settingsHomeFFrame6 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_6);
            settingsHomeFFrame7 = settingsHomeFView.findViewById(R.id.settings_home_f_frame_7);
            settingsHomeFText1 = settingsHomeFView.findViewById(R.id.settings_home_f_text_1);
            settingsHomeFText2 = settingsHomeFView.findViewById(R.id.settings_home_f_text_2);
            settingsHomeFText3 = settingsHomeFView.findViewById(R.id.settings_home_f_text_3);
            settingsHomeFText4 = settingsHomeFView.findViewById(R.id.settings_home_f_text_4);
            settingsHomeFlines = settingsHomeFView.findViewById(R.id.settings_home_f_lines);
            settingsHomeFListView = settingsHomeFView.findViewById(R.id.settings_home_f_list_view);

            backgroundTypeA(this, settingsHomeFFrame2, background(7), ui, 3);
            backgroundTypeA(this, settingsHomeFFrame4, background(5), tintA, 3);
            backgroundTypeC(this, settingsHomeFFrame5, background(10), tintA);
            backgroundTypeC(this, settingsHomeFFrame7, background(10), tintA);

            imageTypeB(this, settingsHomeFCircle, background(4), ui);
            imageTypeA(this, settingsHomeFIcon1, icon(33), tintA, 75);
            imageTypeA(this, settingsHomeFIcon2, icon(59), tintA, 50);
            imageTypeA(this, settingsHomeFIcon3, icon(33), tintA, 65);
            imageTypeA(this, settingsHomeFIcon5, icon(31), tintA, 65);

            textType(this, settingsHomeFText1, textC(3), tintA, fontAStyle);
            textType(this, settingsHomeFText2, "", tintA, fontBStyle);
            textType(this, settingsHomeFText3, textB(75), tintA, fontBStyle);
            textType(this, settingsHomeFText4, "", tintA, fontAStyle);
            textType(this, settingsHomeFlines, textA(9), tintA, Typeface.BOLD);

            customTouchModeB(settingsHomeFIcon1, textC(48), 2, 4, 22);
            customTouchModeB(settingsHomeFIcon3, textC(48), 2, 4, 25);
            customTouchModeB(settingsHomeFIcon5, textC(49), 2, 4, 26);
            customTouchModeB(settingsHomeFFrame2, "", 2, 4, 23);
            customTouchModeB(settingsHomeFFrame4, textC(69), 2, 4, 24);
            customTouchModeB(settingsHomeFFrame7, "", 2, 4, 27);

            settingsHomeFFrame5.setVisibility(View.GONE);
            settingsHomeFFrame6.setVisibility(View.GONE);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_f) == null){
            settingsHomeLayout.addView(settingsHomeFView);
            setSize(this, settingsHomeF, size(2), size(2));
            setMargins(this, settingsHomeF, 20, 20, 20, 20);
            settingsHomeStatus();
        }
    }

    private void settingsHomeStatus(){
        homeConfigurations();
        if(statusState.equals("Enabled")){
            toggleMode(this, settingsHomeFCircle, true);
            settingsHomeFText2.setText(textB(74));
            if(settingsHomeFFrame5.getVisibility() != View.VISIBLE){
                settingsHomeF_CommonA();
                settingsHomeFFrame4.setVisibility(View.VISIBLE);
            }
        } else {
            toggleMode(this, settingsHomeFCircle, false);
            settingsHomeFText2.setText(textB(73));
            settingsHomeF_CommonA();
            settingsHomeFFrame4.setVisibility(View.GONE);
        }
    }

    private void settingsHomeF_CommonA(){
        settingsHomeFFrame1.setVisibility(View.VISIBLE);
        settingsHomeFFrame5.setVisibility(View.GONE);
        if(settingsHomeFFrame6.getVisibility() != View.VISIBLE)
            settingsHomeFFrame6.setVisibility(View.GONE);
    }

    ListTypeG homeFItems;
    private void settingsHomeStatus_A(){
        if(homeFItems == null){
            ArrayList<Bitmap> bitmaps = new ArrayList<>();
            bitmaps.add(reduceBitmap(this, icon(58), 40));

            ArrayList<String> strings_a = new ArrayList<>();
            strings_a.add(textB(76));

            ArrayList<String> strings_b = new ArrayList<>();
            strings_b.add(textB(77));

            homeFItems = new ListTypeG(this, bitmaps, strings_a, strings_b, TheNest.this);
            settingsHomeFListView.setAdapter(homeFItems);
        }
    }

    private String settingsHomeFString;
    @Override
    public void status(Bitmap icon, String type) {
        settingsHomeFFrame6.setVisibility(View.VISIBLE);
        settingsHomeFIcon4.setImageBitmap(icon);
        if(statusMode.equals(type)){
            settingsHomeFText4.setText(textC(71));
            settingsHomeFString = "[ NONE ]";
        } else {
            settingsHomeFText4.setText(textC(70));
            settingsHomeFString = type;
        }
        settingsHomeFListView.setVisibility(View.INVISIBLE);
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeGView;
    RelativeLayout settingsHomeG, settingsHomeGFrame1, settingsHomeGFrame2, settingsHomeGFrame3, settingsHomeGFrame4,
            settingsHomeGFrame5, settingsHomeGFrame6;
    TextView settingsHomeGText1, settingsHomeGText2, settingsHomeGText3;
    ImageView settingsHomeGIcon1, settingsHomeGIcon2, settingsHomeGIcon3, settingsHomeGIcon4, settingsHomeGIcon5;
    private void settingsHomeG(){
        if(settingsHomeGView == null){
            settingsHomeGView = inflater.inflate(R.layout.settings_home_g, null);
            settingsHomeG = settingsHomeGView.findViewById(R.id.settings_home_g);
            settingsHomeGIcon1 = settingsHomeGView.findViewById(R.id.settings_home_g_icon_1);
            settingsHomeGIcon2 = settingsHomeGView.findViewById(R.id.settings_home_g_icon_2);
            settingsHomeGIcon3 = settingsHomeGView.findViewById(R.id.settings_home_g_icon_3);
            settingsHomeGIcon4 = settingsHomeGView.findViewById(R.id.settings_home_g_icon_4);
            settingsHomeGIcon5 = settingsHomeGView.findViewById(R.id.settings_home_g_icon_5);
            settingsHomeGFrame1 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_1);
            settingsHomeGFrame2 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_2);
            settingsHomeGFrame3 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_3);
            settingsHomeGFrame4 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_4);
            settingsHomeGFrame5 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_5);
            settingsHomeGFrame6 = settingsHomeGView.findViewById(R.id.settings_home_g_frame_6);
            settingsHomeGText1 = settingsHomeGView.findViewById(R.id.settings_home_g_text_1);
            settingsHomeGText2 = settingsHomeGView.findViewById(R.id.settings_home_g_text_2);
            settingsHomeGText3 = settingsHomeGView.findViewById(R.id.settings_home_g_text_3);

            backgroundTypeA(this, settingsHomeGFrame2, background(8), tintA, 3);
            backgroundTypeA(this, settingsHomeGFrame3, background(8), tintA, 3);
            backgroundTypeA(this, settingsHomeGFrame4, background(8), tintA, 3);
            backgroundTypeC(this, settingsHomeGFrame6, background(5), tintA);

            imageTypeA(this, settingsHomeGIcon2, icon(49), tintA, 40);
            imageTypeA(this, settingsHomeGIcon3, icon(60), tintA, 40);
            imageTypeA(this, settingsHomeGIcon4, icon(42), tintB, 50);
            imageTypeA(this, settingsHomeGIcon5, icon(33), tintA, 75);

            textType(this, settingsHomeGText1, textC(5), tintA, fontAStyle);
            textType(this, settingsHomeGText2, textB(78), tintA, fontBStyle);
            textType(this, settingsHomeGText3, "", tintA, fontBStyle);

            customTouchModeB(settingsHomeGIcon5, textC(48), 2, 4, 28);
            customTouchModeB(settingsHomeGFrame2, textC(74), 2, 4, 29);
            customTouchModeB(settingsHomeGFrame3, textC(73), 2, 4, 30);
            customTouchModeB(settingsHomeGFrame4, textC(72), 2, 4, 31);
            customTouchModeB(settingsHomeGFrame6, textC(22), 2, 4, 32);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_g) == null){
            settingsHomeLayout.addView(settingsHomeGView);
            setSize(this, settingsHomeG, size(2), size(2));
            setMargins(this, settingsHomeG, 20, 20, 20, 20);
            settingsHomeDrawer();
        }
    }

    private void settingsHomeDrawer(){
        homeConfigurations();
        homeDrawerPresets(settingsHomeGIcon1);
        settingsHomeGText3.setText(drawerIcon);
        if(!drawerIcon.equals("BeeHive") || !drawerSize.equals("C") || drawerAlpha != 1.0){
            settingsHomeGFrame6.setVisibility(View.VISIBLE);
        } else {
            settingsHomeGFrame6.setVisibility(View.GONE);
        }
    }

    // ---------- [] ---------- [] ---------- [] ---------- [] ---------- [] ---------- //

    View settingsHomeHView;
    RelativeLayout settingsHomeH, settingsHomeHFrame1, settingsHomeHFrame2, settingsHomeHFrame3, settingsHomeHFrame4,
            settingsHomeHFrame5;
    TextView settingsHomeHText1, settingsHomeHText2, settingsHomeHText3, settingsHomeHText4;
    ImageView settingsHomeHCircle, settingsHomeHIcon1, settingsHomeHIcon2, settingsHomeHIcon3;
    ListView settingsHomeHListView;
    private void settingsHomeH(){
        if(settingsHomeHView == null){
            settingsHomeHView = inflater.inflate(R.layout.settings_home_h, null);
            settingsHomeH = settingsHomeHView.findViewById(R.id.settings_home_h);
            settingsHomeHCircle = settingsHomeHView.findViewById(R.id.settings_home_h_circle);
            settingsHomeHIcon1 = settingsHomeHView.findViewById(R.id.settings_home_h_icon_1);
            settingsHomeHIcon2 = settingsHomeHView.findViewById(R.id.settings_home_h_icon_2);
            settingsHomeHIcon3 = settingsHomeHView.findViewById(R.id.settings_home_h_icon_3);
            settingsHomeHFrame1 = settingsHomeHView.findViewById(R.id.settings_home_h_frame_1);
            settingsHomeHFrame2 = settingsHomeHView.findViewById(R.id.settings_home_h_frame_2);
            settingsHomeHFrame3 = settingsHomeHView.findViewById(R.id.settings_home_h_frame_3);
            settingsHomeHFrame4 = settingsHomeHView.findViewById(R.id.settings_home_h_frame_4);
            settingsHomeHFrame5 = settingsHomeHView.findViewById(R.id.settings_home_h_frame_5);
            settingsHomeHText1 = settingsHomeHView.findViewById(R.id.settings_home_h_text_1);
            settingsHomeHText2 = settingsHomeHView.findViewById(R.id.settings_home_h_text_2);
            settingsHomeHText3 = settingsHomeHView.findViewById(R.id.settings_home_h_text_3);
            settingsHomeHText4 = settingsHomeHView.findViewById(R.id.settings_home_h_text_4);
            settingsHomeHListView = settingsHomeHView.findViewById(R.id.settings_home_h_list_view);

            backgroundTypeA(this, settingsHomeHFrame2, background(7), ui, 3);
            backgroundTypeA(this, settingsHomeHFrame4, background(5), tintA, 3);
            backgroundTypeC(this, settingsHomeHFrame5, background(10), tintA);

            imageTypeB(this, settingsHomeHCircle, background(4), ui);
            imageTypeA(this, settingsHomeHIcon1, icon(33), tintA, 75);
            imageTypeA(this, settingsHomeHIcon2, icon(57), tintA, 50);
            imageTypeA(this, settingsHomeHIcon3, icon(33), tintA, 65);

            textType(this, settingsHomeHText1, textC(4), tintA, fontAStyle);
            textType(this, settingsHomeHText2, "", tintA, fontBStyle);
            textType(this, settingsHomeHText3, textC(8), tintA, fontBStyle);
            textType(this, settingsHomeHText4, textB(81), tintA, fontBStyle);

            customTouchModeB(settingsHomeHIcon1, textC(48), 2, 4, 33);
            customTouchModeB(settingsHomeHIcon3, textC(48), 2, 4, 36);
            customTouchModeB(settingsHomeHFrame2, "", 2, 4, 34);
            customTouchModeB(settingsHomeHFrame4, textC(68), 2, 4, 35);

            settingsHomeHFrame5.setVisibility(View.GONE);
        }
        if(settingsHomeLayout.findViewById(R.id.settings_home_h) == null){
            settingsHomeLayout.addView(settingsHomeHView);
            setSize(this, settingsHomeH, size(2), size(2));
            setMargins(this, settingsHomeH, 20, 20, 20, 20);
            settingsHomeShortcut();
        }
    }

    private void settingsHomeShortcut(){
        homeConfigurations();
        if(shortcutState.equals("Enabled")){
            toggleMode(this, settingsHomeHCircle, true);
            settingsHomeHText2.setText(textB(80));
            if(settingsHomeHFrame5.getVisibility() != View.VISIBLE){
                settingsHomeH_CommonB();
            } else {
                settingsHomeShortcut_A();
            }
        } else {
            toggleMode(this, settingsHomeHCircle, false);
            settingsHomeHText2.setText(textB(79));

            settingsHomeHFrame1.setVisibility(View.VISIBLE);
            settingsHomeHFrame4.setVisibility(View.GONE);
            settingsHomeHFrame5.setVisibility(View.GONE);
        }
    }

    ListTypeH settingsHomeHListItems;
    List<String> settingsHomeHArray;
    private void settingsHomeShortcut_A(){
        Handler settingsHomeHHandler = new Handler();
        Runnable settingsHomeHRunnable = new Runnable() {
            @Override
            public void run() {
                settingsHomeShortcut_Branch();
            }
        };
        settingsHomeHHandler.postDelayed(settingsHomeHRunnable, 100);
    }

    private void settingsHomeShortcut_Branch(){
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = getPackageManager().queryIntentActivities(intent, PackageManager.GET_META_DATA);
        if(settingsHomeHInt == 0 || settingsHomeHInt != apps.size() || settingsHomeHBoolean){
            settingsHomeHInt = apps.size();
            settingsHomeHBoolean = false;
            for (ResolveInfo resolveInfo : apps) {
                if(fileExist(TheNest.this, "List/Array - 02")) {
                    List<String> readValues = read(TheNest.this, "List/Array - 02");
                    if(!readValues.contains(resolveInfo.activityInfo.packageName)){
                        settingsHomeH_CommonC(resolveInfo);
                    }
                } else {
                    settingsHomeH_CommonC(resolveInfo);
                }
            }
        }
    }

    private void settingsHomeH_CommonA(){
        settingsHomeHFrame1.setVisibility(View.GONE);
        settingsHomeHFrame5.setVisibility(View.VISIBLE);
    }

    private void settingsHomeH_CommonB(){
        settingsHomeHFrame1.setVisibility(View.VISIBLE);
        settingsHomeHFrame4.setVisibility(View.VISIBLE);
        settingsHomeHFrame5.setVisibility(View.GONE);
    }

    private void settingsHomeH_CommonC(ResolveInfo info){
        if(settingsHomeHArray == null)
            settingsHomeHArray = new ArrayList<>();

        if(!settingsHomeHArray.contains(info.activityInfo.packageName))
            settingsHomeHArray.add(info.activityInfo.packageName);

        if(settingsHomeHListView.getAdapter() != null){
            for(String app : settingsHomeHArray){
                if(!isAppInstalled(TheNest.this, app))
                    settingsHomeHArray.remove(app);
            }
            settingsHomeHListItems.notifyDataSetChanged();
        } else {
            settingsHomeHListItems = new ListTypeH(TheNest.this, settingsHomeHArray, TheNest.this);
            settingsHomeHListView.setAdapter(settingsHomeHListItems);
        }
    }

    private boolean settingsHomeHBoolean;
    private int settingsHomeHInt;
    @Override
    public void shortcut(String shortcut) {
        if(isAppInstalled(this, shortcut)){
            create(this, "List","/Array - 02", shortcut);
            touchTip(this, textC(20), 2);
        } else {
            touchTip(this, textC(67), 2);
        }
        settingsHomeHArray.remove(shortcut);
        settingsHomeHListItems.notifyDataSetChanged();
        if(homeShortcutB == null || homeShortcutLayout.findViewById(R.id.home_shortcut_b) == null) {
            homeShortcutLayout.removeAllViews();
            homeShortcutView2();
        }
    }
}