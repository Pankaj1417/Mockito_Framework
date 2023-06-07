package firstApplication;

import lombok.Data;

import java.util.List;

@Data
public class Portfolio {
    private final StockService stockService;
    private final List<Stock> stockList;
    public double getMarketValueOfStock(){
        double marketValue = 0;
        for (Stock currentStock : stockList){
            marketValue += currentStock.getStockQuantity()*stockService.getStockPrice(currentStock);
        }
        return marketValue;
    }
}
