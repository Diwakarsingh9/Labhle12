package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 5/25/2015.
 */
public class Recivedfromapi {

    @SerializedName("result")
    public String result;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public List<INNERDATA1> data= new ArrayList<INNERDATA1>();

    @SerializedName("total_rec")
    public String total_rec;
}
