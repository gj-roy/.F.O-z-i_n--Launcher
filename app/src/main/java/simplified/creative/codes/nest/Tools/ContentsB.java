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
import android.widget.RelativeLayout;
import android.widget.TextView;
import simplified.creative.codes.nest.R;

import java.util.List;

import static simplified.creative.codes.nest.TheNest.*;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class ContentsB extends ArrayAdapter {
    private Activity context;
    private int layout;
    private List<Bitmap> bitmap;
    private List<String> string_a;
    private List<String> string_b;

    public ContentsB(Activity context, int layout, List<Bitmap> bitmap, List<String> string_a, List<String> string_b, AdapterCallback adapterCallback) {
        super(context, layout, string_a);
        this.layout = layout;
        this.context = context;
        this.bitmap = bitmap;
        this.string_a = string_a;
        this.string_b = string_b;
        this.listTypeDCallback = adapterCallback;
    }

    AdapterCallback listTypeDCallback;
    public interface AdapterCallback{
        void homeScreenOptions(int mode);
    }

    private ViewHolder holder;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            if(layout == R.layout.list_style_a){
                holder.icon = convertView.findViewById(R.id.list_style_a_icon);
                holder.text_1 = convertView.findViewById(R.id.list_style_a_text_1);
                holder.text_2 = convertView.findViewById(R.id.list_style_a_text_2);
                holder.frame_1 = convertView.findViewById(R.id.list_style_a_frame_1);
                holder.frame_2 = convertView.findViewById(R.id.list_style_a_frame_2);
                backgroundTypeA(context, holder.frame_1, background(10), tintB, 3);
                backgroundTypeC(context, holder.frame_2, background(3), tintB);
                textType(context, holder.text_1, "", tintB, fontAStyle);
                textType(context, holder.text_2, "", tintB, fontBStyle);
            }
            if(layout == R.layout.list_style_b){
                holder.icon = convertView.findViewById(R.id.list_style_b_icon);
                holder.text_1 = convertView.findViewById(R.id.list_style_b_text_1);
                holder.text_2 = convertView.findViewById(R.id.list_style_b_text_2);
                holder.frame_1 = convertView.findViewById(R.id.list_style_b_frame_1);
                holder.frame_2 = convertView.findViewById(R.id.list_style_b_frame_2);
                backgroundTypeC(context, holder.frame_1, background(4), tintB);
                backgroundTypeA(context, holder.frame_2, background(7), tintB, 3);
                textType(context, holder.text_1, "", tintB, fontAStyle);
                textType(context, holder.text_2, "", tintB, fontBStyle);
            }
            if(layout == R.layout.list_style_c){
                holder.icon = convertView.findViewById(R.id.list_style_c_icon);
                holder.text_1 = convertView.findViewById(R.id.list_style_c_text_1);
                holder.text_2 = convertView.findViewById(R.id.list_style_c_text_2);
                holder.frame_1 = convertView.findViewById(R.id.list_style_c_frame);
                holder.line_1 = convertView.findViewById(R.id.list_style_c_line_1);
                holder.line_2 = convertView.findViewById(R.id.list_style_c_line_2);
                holder.line_3 = convertView.findViewById(R.id.list_style_c_line_3);
                backgroundTypeB(context, holder.frame_1, background(1), tintB, 70);
                textType(context, holder.text_1, "", tintB, fontAStyle);
                textType(context, holder.text_2, "", tintB, fontBStyle);
                imageTypeB(context, holder.line_1, background(6), tintB);
                imageTypeB(context, holder.line_2, background(6), tintB);
                imageTypeB(context, holder.line_3, background(6), tintB);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text_1.setText(string_a.get(position));
        holder.icon.setImageBitmap(bitmap.get(position));
        holder.text_2.setText(string_b.get(position));
        switchTint(context, holder.icon, tintA);

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
                        if(listTypeDCallback != null) {
                            listTypeDCallback.homeScreenOptions(position);
                        }
                    }
                }
                touchEnd(event, view);
                return true;
            }
        });

        return  convertView;
    }

    private class ViewHolder{
        ImageView icon, line_1, line_2, line_3;
        TextView text_1, text_2;
        RelativeLayout frame_1, frame_2;
    }
}