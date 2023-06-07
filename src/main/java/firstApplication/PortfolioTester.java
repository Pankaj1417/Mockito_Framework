package firstApplication;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PortfolioTester {

//    Portfolio portfolio;
//    StockService stockService;
//    List<Stock> stocks;
//
//    public static void main(String[] args){
//        PortfolioTester portfolioTester = new PortfolioTester();
//        portfolioTester.setUp();
//        System.out.println(portfolioTester.testMarketValue()?"pass":"fail");
//    }
//
//    public void setUp(){
//
//        //Create the mock object of stock service
//        stockService = mock(StockService.class);
//
//         stocks = new ArrayList<Stock>();
//
//
//        portfolio = new Portfolio(stockService,stocks);
//    }
//
//    public boolean testMarketValue(){
//
//        //Creates a list of stocks to be added to the portfolio
//        Stock googleStock = new Stock("1","Google", 10);
//        Stock microsoftStock = new Stock("2","Microsoft",100);
//
//        stocks.add(googleStock);
//        stocks.add(microsoftStock);
//        //mock the behavior of stock service to return the value of various stocks
//        when(stockService.getPrice(googleStock)).thenReturn(50.00);
//        when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);
//
//        double marketValue = portfolio.getMarketValue();
//        return marketValue == 100500.0;
//    }
}