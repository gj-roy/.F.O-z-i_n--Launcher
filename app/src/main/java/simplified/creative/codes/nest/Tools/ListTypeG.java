package simplified.creative.codes.nest.Tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import simplified.creative.codes.nest.R;

import java.util.List;

import static simplified.creative.codes.nest.TheNest.*;
import static simplified.creative.codes.nest.Tools.Methods.background;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class ListTypeG extends ArrayAdapter {
    private Activity context;
    private List<Bitmap> bitmaps;
    private List<String> strings_a;
    private List<String> strings_b;

    public ListTypeG(Activity context,
                     List<Bitmap> bitmaps,
                     List<String> strings_a,
                     List<String> strings_b,
                     AdapterCallback adapterCallback) {
        super(context, R.layout.list_type_e, strings_a);
        this.context = context;
        this.bitmaps = bitmaps;
        this.strings_a = strings_a;
        this.strings_b = strings_b;
        this.listTypeGCallback = adapterCallback;
    }

    AdapterCallback listTypeGCallback;
    public interface AdapterCallback{
        void status(Bitmap icon, String type);
    }

    ViewHolder holder;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_type_f, null);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.list_type_f_icon);
            holder.text1 = convertView.findViewById(R.id.list_type_f_text_1);
            holder.text2 = convertView.findViewById(R.id.list_type_f_text_2);
            convertView.setTag(holder);

            backgroundTypeC(context, convertView, background(3), tintA);
            textType(context, holder.text1, "", tintB, fontAStyle);
            textType(context, holder.text2, "", tintB, fontBStyle);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageBitmap(bitmaps.get(position));
        switchTint(context, holder.icon, tintB);
        holder.text1.setText(strings_a.get(position));
        holder.text2.setText(strings_b.get(position));

        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchStart(view);
                    onTouchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            touchVibrate(context, view);
                        }
                    };
                    onTouchHandler.postDelayed(onTouchRunnable, 300);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    touchStop(view);
                    if((System.currentTimeMillis() - time) < 200){
                        listTypeGCallback.status(bitmaps.get(position), strings_a.get(position));
                    }
                }
                touchEnd(event, view);
                return true;
            }
        });

        return  convertView;
    }

    public static class ViewHolder{
        TextView text1, text2;
        ImageView icon;
    }
}