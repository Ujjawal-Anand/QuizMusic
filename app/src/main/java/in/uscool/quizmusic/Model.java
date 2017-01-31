package in.uscool.quizmusic;

/**
 * Created by ujjawal on 31/1/17.
 */

public class Model {
    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;
    public static final int AUDIO_TYPE=2;

    public int type;
    public int data;
    public String text;
    public boolean loop=true;



    public Model(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;

    }

    public Model(int type, String text, int data, boolean loop) {
        this.type = type;
        this.text = text;
        this.data = data;
        this.loop = loop;
    }
}
