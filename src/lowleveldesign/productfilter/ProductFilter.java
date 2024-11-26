package lowleveldesign.productfilter;

import java.util.ArrayList;
import java.util.List;

public class ProductFilter {

    public List<Product> applyFilter(List<Product> products, List<FilterCriteria> filterCriterias){

        List<Product> productList = new ArrayList<>();
        for(Product product: products){
            for(FilterCriteria filterCriteria: filterCriterias){
                if(filterCriteria.matches(product)){
                    productList.add(product);
                }
            }
        }
        return productList;

    }
}
