package simplified.creative.codes.nest.Tools;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import simplified.creative.codes.nest.R;

import java.util.ArrayList;
import java.util.List;

import static simplified.creative.codes.nest.TheNest.*;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class ListTypeA extends ArrayAdapter {
    private List<String> appName;
    private Activity context;

    public ListTypeA(Activity context, List<String> appName, AdapterCallback adapterCallback) {
        super(context, R.layout.list_type_a, appName);
        this.context = context;
        this.appName = appName;
        this.listTypeACallback = adapterCallback;
    }

    AdapterCallback listTypeACallback;
    public interface AdapterCallback{
        void homeFolder_Pores(String current);
    }

    public ArrayList<String> arrayItems(){
        return (ArrayList<String>) appName;
    }

    ViewHolder holder;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_type_a, null);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.list_type_a_icon);
            holder.name = convertView.findViewById(R.id.list_type_a_text);
            convertView.setTag(holder);

            backgroundTypeA(context, convertView, background(7), tintB, 3);
            textType(context, holder.name, "", tintB, fontBStyle);
            convertView.getBackground().setAlpha(0);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String label = "";
        try {
            label = (String) context.getPackageManager().getApplicationInfo(appName.get(position), 0).loadLabel(context.getPackageManager());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        holder.name.setText(label);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.icon.setImageBitmap(roundedBitmap(adaptiveIcon(context, appName.get(position), 30)));
        } else {
            holder.icon.setImageBitmap(roundedBitmap(drawableIcon(context, appName.get(position), 30)));
        }

        View finalConvertView = convertView;
        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    finalConvertView.getBackground().setAlpha(255);
                    try {
                        onTouchHandler.removeCallbacks(onTouchRunnable);
                    } catch (Exception e){}
                    time = (Long) System.currentTimeMillis();
                    onTouchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            if(event.getAction() != MotionEvent.ACTION_UP){
                                if(isAppInstalled(context, appName.get(position))){
                                    if(listTypeACallback != null) {
                                        listTypeACallback.homeFolder_Pores(appName.get(position));
                                    }
                                }
                                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                                } else {
                                    vibrator.vibrate(100);
                                }
                            }
                        }
                    };
                    onTouchHandler.postDelayed(onTouchRunnable, 300);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    finalConvertView.getBackground().setAlpha(0);
                    try {
                        onTouchHandler.removeCallbacks(onTouchRunnable);
                    } catch (Exception e){}
                    if((System.currentTimeMillis() - time) < 200){
                        if(isAppInstalled(context, appName.get(position))){
                            try {
                                Intent intent = context.getPackageManager().getLaunchIntentForPackage(appName.get(position));
                                context.startActivity(intent);
                            } catch (Exception e){}
                        }
                    }
                }
                if(event.getAction() == MotionEvent.ACTION_CANCEL){
                    finalConvertView.getBackground().setAlpha(0);
                    try {
                        onTouchHandler.removeCallbacks(onTouchRunnable);
                    } catch (Exception e){}
                }
                return true;
            }
        });

        return  convertView;
    }

    public static class ViewHolder{
        TextView name;
        ImageView icon;
    }
}