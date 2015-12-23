package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 6/10/2015.
 */
public class Receivedfromlocationapi22 {
    @SerializedName("result")
    public String result;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public List<INNERDATA322> data22= new ArrayList<INNERDATA322>();

    @SerializedName("total_rec")
    public String total_rec;
}
