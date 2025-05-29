/*
package Rippling;

import java.util.*;

public class CurrencyExchange {

    class Exchange{
        String to;
        double rate;

        public Exchange(String to, double rate){
            this.to = to;
            this.rate = rate;
        }
    }

    public boolean isProfitableExchange(Map<String, List<Exchange>> graph, String start){

        Map<String, Double> profit = new HashMap<>();
        Set<String> currencies = graph.keySet();
        for(String currency: currencies){
            profit.put(currency,Double.MIN_VALUE);
        }

        profit.put(start,0.0);
        for(int i=0;i< graph.size();i++){
            for(String from: currencies){
                for(Exchange exchange: graph.get(from)){
                    String to = exchange.to;
                    Double rate = Math.log(exchange.rate);
                    if(profit.get(from)+rate > profit.get(to)){
                        profit.put(to, profit.get(from)+rate);
                    }
                }
            }
        }

        profit.forEach((k,v)->{
            System.out.println(k + " "+ v);
        });

        for(String from: currencies){
            for(Exchange exchange: graph.get(from)){
                String to = exchange.to;
                Double rate = Math.log(exchange.rate);
                if(profit.get(from)+rate > profit.get(to)){
                    return true;
                }
            }
        }

    return false;

    }

    public static void main(String[] args) {
        CurrencyExchange ce = new CurrencyExchange();

        Map<String, List<CurrencyExchange.Exchange>> graph = new HashMap<>();

        // Example: USD → EUR → GBP → USD (cycle with product > 1)
        CurrencyExchange.Exchange usdToEur = ce.new Exchange("EUR", 0.9);
        CurrencyExchange.Exchange eurToGbp = ce.new Exchange("GBP", 0.9);
        CurrencyExchange.Exchange gbpToUsd = ce.new Exchange("USD", 1.3);

        graph.put("USD", Arrays.asList(usdToEur));
        graph.put("EUR", Arrays.asList(eurToGbp));
        graph.put("GBP", Arrays.asList(gbpToUsd));

        boolean result = ce.isProfitableExchange(graph, "USD");
        System.out.println("Is profitable arbitrage possible? " + result);
    }

}
*/
