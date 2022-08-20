package simplified.creative.codes.nest.Tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
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

public class ListTypeE extends ArrayAdapter {
    private Activity context;
    private List<Bitmap> bitmaps;
    private List<Drawable> drawables;
    private List<String> string_a;
    private List<String> string_b;
    private int mode;

    public ListTypeE(Activity context,
                     List<Bitmap> bitmaps,
                     List<Drawable> drawables,
                     List<String> string_a,
                     List<String> string_b,
                     int mode,
                     AdapterCallback adapterCallback) {
        super(context, R.layout.list_type_e, string_a);
        this.context = context;
        this.bitmaps = bitmaps;
        this.drawables = drawables;
        this.string_a = string_a;
        this.string_b = string_b;
        this.mode = mode;
        this.listTypeECallback = adapterCallback;
    }

    AdapterCallback listTypeECallback;
    public interface AdapterCallback{
        void widget(String widgetPackage, String widgetModule, Bitmap widgetIcon, Drawable widgetPreview, int widgetMode);
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

        holder.name.setText(string_b.get(position));
        holder.icon.setImageBitmap(bitmaps.get(position));
        if(mode == 0){
            switchTint(context, holder.icon, tintA);
        } else {
            switchTint(context, holder.icon, R.color.transparent);
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
                        listTypeECallback.widget(string_a.get(position), string_b.get(position), bitmaps.get(position), drawables.get(position), mode);
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