package simplified.creative.codes.nest.Tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import simplified.creative.codes.nest.R;

import java.util.List;

import static simplified.creative.codes.nest.TheNest.fontBStyle;
import static simplified.creative.codes.nest.TheNest.tintA;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class ListTypeH extends ArrayAdapter {
    private Activity context;
    private List<String> strings;

    public ListTypeH(Activity context, List<String> strings, AdapterCallback adapterCallback) {
        super(context, R.layout.list_type_e, strings);
        this.context = context;
        this.strings = strings;
        this.listTypeHCallback = adapterCallback;
    }

    AdapterCallback listTypeHCallback;
    public interface AdapterCallback{
        void shortcut(String shortcut);
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

        appName(context, holder.name, strings.get(position));
        appIcon(context, holder.icon, strings.get(position), 30);

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
                        listTypeHCallback.shortcut(strings.get(position));
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