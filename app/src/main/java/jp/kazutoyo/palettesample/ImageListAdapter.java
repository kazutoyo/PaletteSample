package jp.kazutoyo.palettesample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import jp.kazutoyo.palettesample.R;

/**
 * Created by kazutoyo on 2014/10/29.
 */
public class ImageListAdapter extends ArrayAdapter<Drawable> {

    private LayoutInflater layoutInflater_;

    public ImageListAdapter(Context context, int textViewResourceId, List<Drawable> objects) {
        super(context, textViewResourceId, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        private ImageView imageView;

        public ViewHolder(View view) {
            imageView = (ImageView)view.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        Drawable drawable = (Drawable)getItem(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater_.inflate(R.layout.image_list_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.imageView.setImageDrawable(drawable);

        return convertView;
    }
}