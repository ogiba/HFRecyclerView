package pl.ogiba.hfrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.HeaderViewListAdapter;

import pl.ogiba.hfrecyclerview.HFRecyclerView;

public class MainActivity extends AppCompatActivity {

    private HFRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.rv_header_footer);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(new DemoHFRecyclerAdapter());
    }
}
