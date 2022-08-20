package simplified.creative.codes.nest.Tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import simplified.creative.codes.nest.R;

import java.util.ArrayList;

import static simplified.creative.codes.nest.TheNest.*;
import static simplified.creative.codes.nest.Tools.Methods.*;

public class GridTypeA extends ArrayAdapter<GridItemsA> {
    Context context;
    int layout;
    ArrayList<GridItemsA> arrayList;

    public GridTypeA(Context context, int layout,
                     ArrayList<GridItemsA> arrayList,
                     AdapterCallback adapterCallback) {
        super(context, layout, arrayList);
        this.layout = layout;
        this.context = context;
        this.arrayList = arrayList;
        this.gridTypeACallback = adapterCallback;
    }

    AdapterCallback gridTypeACallback;
    public interface AdapterCallback{
        void onItemPressed(String current, int position);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridHolder holder;
        GridItemsA gridItemsA = arrayList.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(drawerGridStyle.equals("Tiles")){
                convertView = inflater.inflate(R.layout.grid_type_a, null);
            }
            if(drawerGridStyle.equals("Bubbles")){
                convertView = inflater.inflate(R.layout.grid_type_b, null);
            }

            holder = new GridHolder();
            if(drawerGridStyle.equals("Tiles")){
                holder.frame = convertView.findViewById(R.id.grid_type_a_frame);
                holder.label = convertView.findViewById(R.id.grid_type_a_text);
                holder.icon = convertView.findViewById(R.id.grid_type_a_icon);
                backgroundTypeA(context, holder.frame, background(8), tintA, 3);
            }
            if(drawerGridStyle.equals("Bubbles")){
                holder.frame = convertView.findViewById(R.id.grid_type_b);
                holder.icon = convertView.findViewById(R.id.grid_type_b_icon);
                backgroundTypeA(context, holder.frame, background(5), tintA, 3);
            }
            convertView.setTag(holder);
        } else {
            holder = (GridHolder) convertView.getTag();
        }

        if(holder.label != null)
            textType(context, holder.label, gridItemsA.getLabel(), tintA, fontBStyle);

        holder.icon.setImageBitmap(gridItemsA.getIcon());

        holder.frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    touchStart(view);
                    onTouchRunnable = new Runnable() {
                        @Override
                        public void run() {
                            if(event.getAction() != MotionEvent.ACTION_UP){
                                if(isAppInstalled(context, gridItemsA.getAppPackage())){
                                    if(gridTypeACallback != null) {
                                        gridTypeACallback.onItemPressed(gridItemsA.getAppPackage(), position);
                                    }
                                }
                                touchVibrate(context, view);
                            }
                        }
                    };
                    onTouchHandler.postDelayed(onTouchRunnable, 300);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    touchStop(view);
                    if((System.currentTimeMillis() - time) < 200){
                        if(isAppInstalled(context, gridItemsA.getAppPackage())){
                            try {
                                Intent intent = context.getPackageManager().getLaunchIntentForPackage(gridItemsA.getAppPackage());
                                context.startActivity(intent);
                            } catch (Exception e){}
                        } else {

                        }
                    }
                }
                touchEnd(event, view);
                return true;
            }
        });
        return convertView;
    }

    static class GridHolder {
        RelativeLayout frame;
        TextView label;
        ImageView icon;
    }
}
