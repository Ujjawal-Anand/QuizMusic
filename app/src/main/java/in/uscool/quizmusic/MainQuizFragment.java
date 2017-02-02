package in.uscool.quizmusic;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
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
    private MediaPlayer mPlayer;
    private boolean isPlaying = false;

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
        if(savedInstanceState == null) {
            setRecyclerView();
        }
    }

   @Override
    public void onDestroy() {
        super.onDestroy();
        stopMediaPlayer();
    }



    @Override
    public void onStart() {
        super.onStart();
    }

  private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager;
        ArrayList<Model> list= new ArrayList<>();
      list.add(new Model(Model.TEXT_TYPE, "Instruction- Touch on speaker icon to play/stop the music.", 0));
      list.add(new Model(Model.AUDIO_TYPE,"Quiz Start",R.raw.quiz_start, true));
        list.add(new Model(Model.AUDIO_TYPE,"Question Asking",R.raw.question_ask, false));
        list.add(new Model(Model.AUDIO_TYPE,"Right Answer",R.raw.right_answer, false));
        list.add(new Model(Model.AUDIO_TYPE,"Wrong Answer",R.raw.wrong_answer, false));
        list.add(new Model(Model.AUDIO_TYPE,"Question in Audience",R.raw.quiz_start, true));
      list.add(new Model(Model.TEXT_TYPE,"Hello. This app is created by Ujjawal Anand, contact me on 7631465569 or email me on ujjawalanand1729@gmail.com for any technical development work like website development, App development etc ",0));




      DataAdapter adapter = new DataAdapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
      
      setRecyclerViewClickListner(list);
    }

    public void setRecyclerViewClickListner(final ArrayList<Model> list) {
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(activity, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (position == 5) {
                    playMedia(list.get(position));
                } else if (position == 1) {
                    playMedia(list.get(position));

                } else if (position == 2) {
                    playMedia(list.get(position));

                } else if (position == 3) {
                    playMedia(list.get(position));
                }
                else if (position == 4) {
                    playMedia(list.get(position));
                }
            }
        }));
    }

    public void playMedia(Model object) {
        if (isPlaying) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
            isPlaying = false;
        } else {
            mPlayer = MediaPlayer.create(getContext(), object.data);
            mPlayer.setLooping(object.loop);
            mPlayer.start();
            isPlaying = true;
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                   stopMediaPlayer();
                }
            });
        }
    }
       public void stopMediaPlayer() {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
            isPlaying = false;
        }
    }
    }

