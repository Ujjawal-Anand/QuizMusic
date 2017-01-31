package in.uscool.quizmusic;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

/**
 * Created by ujjawal on 31/1/17.
 */

public class BreakMusicFragment extends Fragment {

    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter chapterAdapter;
    private Activity activity;

    public static BreakMusicFragment newInstance() {
        return new BreakMusicFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler);
        RecyclerView.LayoutManager layoutManager;
        activity = getActivity();

        if (GRID_LAYOUT) {
            layoutManager = new GridLayoutManager(getActivity(), 2);
        } else {
            layoutManager = new LinearLayoutManager(getActivity());
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //Use this now
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());

//        chapterAdapter = new ChapterAdapter(chapterName);

        //chapterAdapter = new RecyclerViewMaterialAdapter();
//        recyclerView.setAdapter(chapterAdapter);
//        setRecyclerViewClickListner();

        /*{
            for (int i = 0; i < ITEM_COUNT; ++i) {
                mContentItems.add(new Object());
            }
            chapterAdapter.notifyDataSetChanged();
        }*/
        loadData();
    }

    private void loadData() {

    }

/*    public void setRecyclerViewClickListner() {
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(activity, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (chapterName.get(position).getId() == 0) {
                    Intent intent = new Intent(activity, FormulaActivity.class);
                    intent.putExtra("imagePath", "math/1");
                    intent.putExtra("textFilePath", "math/1.txt");
                    intent.putExtra("title", "Sets Relations And Functions");
                    startActivity(intent);
                } else if (chapterName.get(position).getId() == 1) {
                    Intent intent = new Intent(activity, FormulaActivity.class);
                    intent.putExtra("imagePath", "math/1");
                    intent.putExtra("textFilePath", "math/1.txt");
                    intent.putExtra("title", "Complex Number");
                    startActivity(intent);
                } else if (chapterName.get(position).getId() == 2) {
                    Intent intent = new Intent(activity, FormulaActivity.class);
                    intent.putExtra("imagePath", "math/2");
                    intent.putExtra("textFilePath", "math/2.txt");
                    intent.putExtra("title", "Quadratic Equation And Inequalities");
                    startActivity(intent);
                } else if (chapterName.get(position).getId() == 9) {
                    Intent intent = new Intent(activity, FormulaActivity.class);
                    intent.putExtra("imagePath", "math/9");
                    intent.putExtra("textFilePath", "math/9.txt");
                    intent.putExtra("title", "Differential Calculus");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(activity, FormulaActivity.class);
                    intent.putExtra("imagePath", "math/9");
                    intent.putExtra("textFilePath", "math/9.txt");
                    intent.putExtra("title", "Formula Not Available");
                    startActivity(intent);                }
            }
        }));
    }*/
}
