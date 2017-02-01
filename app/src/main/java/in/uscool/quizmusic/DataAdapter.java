package in.uscool.quizmusic;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ujjawal on 31/1/17.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Model> dataSet;
    Context mContext;
    int total_types;
    public MediaPlayer mPlayer;
    private boolean fabStateVolume = false;
    public DataAdapter() {

    }

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {


        TextView txtType;
        CardView cardView;

        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.cardView = (CardView) itemView.findViewById(R.id.card_view);

        }

    }

   /* public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {


        TextView txtType;
        ImageView image;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.type);
            this.image = (ImageView) itemView.findViewById(R.id.background);

        }

    }
*/
    public static class AudioTypeViewHolder extends RecyclerView.ViewHolder {


        TextView txtType;
        FloatingActionButton fab;

        public AudioTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.text_view);
            this.fab = (FloatingActionButton) itemView.findViewById(R.id.fab);

        }

    }

    public DataAdapter(ArrayList<Model> data, Context context) {
        this.dataSet = data;
        this.mContext = context;
        total_types = dataSet.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_card, parent, false);
                return new TextTypeViewHolder(view);
   /*         case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_card, parent, false);
                return new ImageTypeViewHolder(view);*/
            case Model.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio_card, parent, false);
                return new AudioTypeViewHolder(view);
        }
        return null;


    }


    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.IMAGE_TYPE;
            case 2:
                return Model.AUDIO_TYPE;
            default:
                return -1;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        final Model object = dataSet.get(listPosition);
        if (object != null) {
            switch (object.type) {
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtType.setText(object.text);

                    break;
               /* case Model.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).txtType.setText(object.text);
                    ((ImageTypeViewHolder) holder).image.setImageResource(object.data);
                    break;*/
                case Model.AUDIO_TYPE:

                    ((AudioTypeViewHolder) holder).txtType.setText(object.text);


                    ((AudioTypeViewHolder) holder).fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (fabStateVolume) {
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.mipmap.volume);
                                fabStateVolume = false;

                            } else {
                                ((AudioTypeViewHolder) holder).fab.setImageResource(R.mipmap.mute);
                                fabStateVolume = true;
                            }
                        }
                    });


                    break;
            }
        }

    }

    public void stopmPlayer() {
        if(mPlayer != null) {
            mPlayer.stop();
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
