package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 6/9/2015.
 */
public class Receivedfromspecificgyms {
    @SerializedName("result")
    public String result;

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public INNERDATA4 inner_4 = new INNERDATA4();
}
