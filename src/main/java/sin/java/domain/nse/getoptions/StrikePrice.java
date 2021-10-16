
package sin.java.domain.nse.getoptions;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class StrikePrice {

    @SerializedName("CE")
    private CallOption cE;
    private String expiryDate;
    @SerializedName("PE")
    private PutOption pE;
    private Double strikePrice;
}
