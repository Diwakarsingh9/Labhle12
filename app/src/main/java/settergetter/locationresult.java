package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 6/2/2015.
 */
public class locationresult {
    @SerializedName("result")
    public String result;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public List<INNERDATA2> data= new ArrayList<INNERDATA2>();


}
