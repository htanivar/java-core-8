
package sin.java.domain.nse.getoptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PutOption {

    private Double askPrice;
    private String askQty;
    private String bidQty;
    private Double bidprice;
    private String change;
    private String changeinOpenInterest;
    private String expiryDate;
    private String identifier;
    private String impliedVolatility;
    private Double lastPrice;
    private String openInterest;
    private String pChange;
    private String pchangeinOpenInterest;
    private Double strikePrice;
    private String totOI;
    private String totVol;
    private String totalBuyQuantity;
    private String totalSellQuantity;
    private String totalTradedVolume;
    private String underlying;
    private String underlyingValue;
    private LocalDateTime timestamp;
}
