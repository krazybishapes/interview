package Rippling;

import java.util.*;

public class CurrencyConversion {

    static class Rate{
        String from;
        String to;
        double rates;

        public Rate(String from, String to, double rates){
            this.from = from;
            this.to = to;
            this.rates = rates;
        }
    }

    static class Exchange{
        String currency;
        double conversionRate;

        public Exchange(String currency, double conversionRate){
            this.currency = currency;
            this.conversionRate =conversionRate;
        }
    }

    public static void main(String[] args) {
        //Rates: ['USD', 'JPY', 110] ['USD', 'AUD', 1.45] ['JPY', 'GBP', 0.0070]
        // To/From currency ['GBP', 'AUD']
        // Find the rate for the 'To/From' curency. In this case, the correct result is 1.89.

        //USD-[JPY = 110],[AUD-1.45]
        //JPY-USD = 1/110, GBP-0.0070
        //AUD-USD 1/1.45
        //GBP-JPY 1/0.0070

        //GBP->JPY->USD->AUD = 1/0.0070 * 1/110 * 1.45 ~1.88

        //create graph

        List<Rate> rates = new ArrayList<>();
        Rate rate1 = new Rate("USD","JPY", 110);
        Rate rate2 = new Rate("USD","AUD", 1.45);
        Rate rate3 = new Rate("JPY","GBP", 0.0070);
        rates.add(rate1);
        rates.add(rate2);
        rates.add(rate3);

        Map<String, List<Exchange>> graph = createGraph(rates);

        double result = findConversionRate(graph,"GBP", "AUD");

        System.out.println(result);



    }

    private static Map<String, List<Exchange>> createGraph(List<Rate> rates){
        Map<String, List<Exchange>> graph = new HashMap<>();
        for(Rate rate: rates){
            String from = rate.from;
            String to = rate.to;
            double converionsRate = rate.rates;

            graph.computeIfAbsent(from,k-> new ArrayList<>());
            graph.computeIfAbsent(to,k-> new ArrayList<>());

            graph.get(from).add(new Exchange(to, converionsRate));
            graph.get(to).add(new Exchange(from, 1.00/converionsRate));
        }
        return graph;
    }


    public static double findConversionRate(Map<String, List<Exchange>> graph, String src, String dest){

        return dfs(graph, new HashSet<>(),1.0, src,dest);
    }

    private static double dfs(Map<String, List<Exchange>> graph, Set<String> visited, double product, String src, String dest){

        if(src.equals(dest)){
            return product;
        }

        visited.add(src);

        for(Exchange exchange: graph.get(src)){

            String to = exchange.currency;

            if(!visited.contains(to)){
                //System.out.println(src + " "+ to);
                double rate = exchange.conversionRate;
                return dfs(graph, visited, product* rate, to, dest);
            }
        }

        return -1.0;

    }


}
