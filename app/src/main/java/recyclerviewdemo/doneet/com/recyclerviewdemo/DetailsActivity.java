package recyclerviewdemo.doneet.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        TextView lblQuote = (TextView) findViewById(R.id.lbl_quote_text);
        lblQuote.setText(extras.getString(EXTRA_QUOTE));

        TextView lblQuoteAttr = (TextView) findViewById(R.id.lbl_quote_attribution);
        lblQuoteAttr.setText(extras.getString(EXTRA_ATTR));
    }
}
