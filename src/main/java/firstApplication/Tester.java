package firstApplication;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Tester {
    Portfolio portfolio;
    StockService stockService;
    List<Stock> stocks;
    public void setup(){
        stockService = mock(StockService.class);
        stocks = new ArrayList<>();
        portfolio = new Portfolio(stockService,stocks);
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.setup();
        System.out.println(tester.testMarketValuePassing()?"pass":"fail");
        System.out.println(tester.testMarketValueFailing()?"pass":"fail");
    }

    private boolean testMarketValuePassing() {
        Stock s1 = new Stock(1,"Google",20);
        Stock s2 = new Stock(2,"Amazon",10);
        stocks.add(s1);
        stocks.add(s2);
        when(stockService.getStockPrice(s1)).thenReturn(50.00);
        when(stockService.getStockPrice(s2)).thenReturn(100.00);
        return portfolio.getMarketValueOfStock() == 2000.00;
    }
    private boolean testMarketValueFailing() {
        Stock s1 = new Stock(1,"Google",20);
        Stock s2 = new Stock(2,"Amazon",10);
        stocks.add(s1);
        stocks.add(s2);
        when(stockService.getStockPrice(s1)).thenReturn(5.00);
        when(stockService.getStockPrice(s2)).thenReturn(100.00);
        return portfolio.getMarketValueOfStock() == 2000.00;
    }
}
