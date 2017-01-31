package in.uscool.quizmusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ujjawal on 31/1/17.
 */

public class MainQuizFragment extends Fragment {

    static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter chapterAdapter;
    private Activity activity;

    public static MainQuizFragment newInstance() {
        return new MainQuizFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler);
        activity = getActivity();
        setRecyclerView();


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

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager;
        ArrayList<Model> list= new ArrayList<>();
        list.add(new Model(Model.TEXT_TYPE,"Hello. This app is created by Ujjawal Anand, contact me on 7631465569 or emailme on ujjawalanand1729@gmail.com for any technical development work like website development, App development etc ",0));
        list.add(new Model(Model.AUDIO_TYPE,"Quiz Start",R.raw.quiz_start, true));
        list.add(new Model(Model.AUDIO_TYPE,"Quiz background music",R.raw.quiz_background, true));
        list.add(new Model(Model.AUDIO_TYPE,"Question Asking",R.raw.question_ask, false));
        list.add(new Model(Model.AUDIO_TYPE,"Right Answer",R.raw.right_answer, false));
        list.add(new Model(Model.AUDIO_TYPE,"Wrong Answer",R.raw.wrong_answer, false));


        DataAdapter adapter = new DataAdapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}
