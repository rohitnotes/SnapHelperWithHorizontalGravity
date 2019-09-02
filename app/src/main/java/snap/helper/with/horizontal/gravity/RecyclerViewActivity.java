package snap.helper.with.horizontal.gravity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.widget.Toast;
import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView centerSnapRecyclerView,startSnapRecyclerView,endSnapRecyclerView;

    private ArrayList<RecyclerViewItemModel> recyclerViewItemModelArrayList;
    private RecyclerViewAdapterHorizontal recyclerViewAdapterHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        createData();
        setRecyclerViewItem();
    }

    private void initView()
    {
        centerSnapRecyclerView  =   findViewById(R.id.centerSnapRecyclerView);
        startSnapRecyclerView   =   findViewById(R.id.startSnapRecyclerView);
        endSnapRecyclerView     =   findViewById(R.id.endSnapRecyclerView);
    }

    private void createData()
    {
        recyclerViewItemModelArrayList = new ArrayList<>();
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("WhatsApp", R.drawable.ic_whatsapp));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Skype", R.drawable.ic_skype));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Facebook", R.drawable.ic_facebook));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Google+", R.drawable.ic_gplus));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Instagram", R.drawable.ic_instagram));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("LinkedIn", R.drawable.ic_linkedin));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Quora", R.drawable.ic_quora));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Twitter", R.drawable.ic_twitter));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Tumblr", R.drawable.ic_tumblr));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Email", R.drawable.ic_email));
        recyclerViewItemModelArrayList.add(new RecyclerViewItemModel("Gallery", R.drawable.ic_gallery));
    }

    private void setRecyclerViewItem()
    {
        centerSnap();
        startSnap();
        endSnap();
    }

    private void centerSnap()
    {
        centerSnapRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        centerSnapRecyclerView.setHasFixedSize(true);
        centerSnapRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * Default Center
         */
        SnapHelper snapHelperCenterDefault = new LinearSnapHelper();
        snapHelperCenterDefault.attachToRecyclerView(centerSnapRecyclerView);

        recyclerViewAdapterHorizontal =new RecyclerViewAdapterHorizontal(RecyclerViewActivity.this,recyclerViewItemModelArrayList);
        centerSnapRecyclerView.setAdapter(recyclerViewAdapterHorizontal);
    }

    private void startSnap()
    {
        startSnapRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        startSnapRecyclerView.setHasFixedSize(true);
        startSnapRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * Gravity.START
         */
        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
        snapHelperStart.attachToRecyclerView(startSnapRecyclerView);

        recyclerViewAdapterHorizontal =new RecyclerViewAdapterHorizontal(RecyclerViewActivity.this,recyclerViewItemModelArrayList);
        startSnapRecyclerView.setAdapter(recyclerViewAdapterHorizontal);
    }

    private void endSnap()
    {
        endSnapRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        endSnapRecyclerView.setHasFixedSize(true);
        endSnapRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * Gravity.END
         */
        SnapHelper snapHelperEnd = new GravitySnapHelper(Gravity.END);
        snapHelperEnd.attachToRecyclerView(endSnapRecyclerView);

        recyclerViewAdapterHorizontal =new RecyclerViewAdapterHorizontal(RecyclerViewActivity.this,recyclerViewItemModelArrayList);
        endSnapRecyclerView.setAdapter(recyclerViewAdapterHorizontal);
    }
}