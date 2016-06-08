package recyclerviewdemo.doneet.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TranTPhuong on 6/8/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<ListItem> data;
    private LayoutInflater inflater;
    private ItemClickCallBack itemClickCallBack;

    public DataAdapter(Context context, List<ListItem> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setListData(ArrayList<ListItem> listData) {
        this.data.clear();
        this.data.addAll(listData);
    }

    public void setItemClickCallBack(final ItemClickCallBack itemClickCallBack) {
        this.itemClickCallBack = itemClickCallBack;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_row_item, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        ListItem item = data.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());

        if (item.isFavorite()) {
            holder.secondaryIcon.setImageResource(android.R.drawable.star_big_on);
        } else {
            holder.secondaryIcon.setImageResource(android.R.drawable.star_big_off);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ItemClickCallBack {
        void onItemClick(int position);

        void onIconClick(int position);
    }

    class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView subTitle;
        private ImageView icon;
        private ImageView secondaryIcon;
        private View container;

        public DataViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.text_view);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            subTitle = (TextView) itemView.findViewById(R.id.text_view_sub_title);
            secondaryIcon = (ImageView) itemView.findViewById(R.id.second_icon);
            container = itemView.findViewById(R.id.list_row_item);

            secondaryIcon.setOnClickListener(this);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.list_row_item) {
                itemClickCallBack.onItemClick(getAdapterPosition());
            } else {
                itemClickCallBack.onIconClick(getAdapterPosition());
            }
        }
    }
}
