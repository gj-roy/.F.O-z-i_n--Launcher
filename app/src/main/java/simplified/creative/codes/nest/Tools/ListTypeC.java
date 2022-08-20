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

import java.util.List;

import static simplified.creative.codes.nest.TheNest.*;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class ListTypeC extends ArrayAdapter {
    private List<String> appName;
    private Activity context;

    public ListTypeC(Activity context, List<String> appName, AdapterCallback adapterCallback) {
        super(context, R.layout.list_type_e, appName);
        this.context = context;
        this.appName = appName;
        this.listTypeCCallback = adapterCallback;
    }

    AdapterCallback listTypeCCallback;
    public interface AdapterCallback{
        void hiddenApp(String current);
    }

    ViewHolder holder;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_type_e, null);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.list_type_e_icon);
            holder.name = convertView.findViewById(R.id.list_type_e_text);
            convertView.setTag(holder);

            backgroundTypeA(context, convertView, background(7), tintA, 3);
            textType(context, holder.name, "", tintA, fontBStyle);
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
                                touchVibrate(context, view);
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
                            if(isAppInstalled(context, appName.get(position))){
                                if(listTypeCCallback != null) {
                                    listTypeCCallback.hiddenApp(appName.get(position));
                                }
                            }
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