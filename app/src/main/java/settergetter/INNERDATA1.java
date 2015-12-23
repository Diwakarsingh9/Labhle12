package settergetter;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 5/26/2015.
 */
public class INNERDATA1 {
    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("logo")
    public String logo;

    @SerializedName("mobile_no")
    public String mobile_no[];

    @SerializedName("phone_no")
    public String phone_no;

    @SerializedName("monthly_cost")
    public String monthly_cost;

    @SerializedName("daily_cost")
    public String daily_cost;

    @SerializedName("free_trial_classes")
    public String free_trial_classes;

    @SerializedName("year_of_esta")
    public String year_of_esta;

    @SerializedName("rating")
    public String rating;

    @SerializedName("latlong")
    public String latlong1[];

    @SerializedName("address")
    public String address;
}
