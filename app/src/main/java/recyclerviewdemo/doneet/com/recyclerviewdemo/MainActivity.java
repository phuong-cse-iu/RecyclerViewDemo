package recyclerviewdemo.doneet.com.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataAdapter.ItemClickCallBack {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = (ArrayList) Data.getListData();

        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DataAdapter(this, Data.getListData());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallBack(this);
    }

    @Override
    public void onItemClick(int position) {
        ListItem item = (ListItem) listData.get(position);
        Intent i = new Intent(this, DetailsActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_QUOTE, item.getTitle());
        extras.putString(EXTRA_ATTR, item.getSubTitle());
        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }

    @Override
    public void onIconClick(int position) {
        ListItem item = (ListItem) listData.get(position);

        if (item.isFavorite()) {
            item.setFavorite(false);
        } else {
            item.setFavorite(true);
        }

        // pass new data to adapter and update
        adapter.setListData(listData);
        adapter.notifyDataSetChanged();
    }
}
