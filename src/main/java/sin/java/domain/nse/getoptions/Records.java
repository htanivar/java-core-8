
package sin.java.domain.nse.getoptions;

import lombok.Data;

import java.util.List;

@Data
public class Records {

    private List<StrikePrice> data;
    private List<String> expiryDates;
}
