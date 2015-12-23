package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 6/3/2015.
 */
public class Receivedfromlocationapi {
    @SerializedName("result")
    public String result;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public List<INNERDATA3> data= new ArrayList<INNERDATA3>();

    @SerializedName("total_rec")
    public String total_rec;
}
