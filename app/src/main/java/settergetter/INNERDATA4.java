package settergetter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saifi45 on 6/9/2015.
 */
public class INNERDATA4 {



    @SerializedName("phone_no")
    public String phone_no;

    @SerializedName("mobile_no")
        public String mobile_no[];

    @SerializedName("workout_gender")
    public String workout_gender;


    @SerializedName("address")
    public String address;

    @SerializedName("year_of_established")
    public String year_of_established;

    @SerializedName("members_per_sessions")
    public String members_per_sessions;

    @SerializedName("trainers_per_session")
    public String trainers_per_session;

    @SerializedName("total_trainers")
    public String total_trainers[];

    @SerializedName("activities")
    public List<ActivityListView> activities= new ArrayList<ActivityListView>();

   @SerializedName("budget")
    public INNERDATA5 inner_5= new INNERDATA5();

    @SerializedName("timing")
    public INNERDATA6 inner_6= new INNERDATA6();

    @SerializedName("vitals_tracked")
    public INNERDATA7 inner_7 = new INNERDATA7();

    @SerializedName("person_name")
    public TRAINERSDETAILS trainersdetails = new TRAINERSDETAILS();
}
