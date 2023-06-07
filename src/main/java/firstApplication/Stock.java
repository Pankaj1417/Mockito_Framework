package firstApplication;

import lombok.Data;

@Data
public class Stock {
    private final int stockId;
    private final String stockName;
    private final int stockQuantity;
}
