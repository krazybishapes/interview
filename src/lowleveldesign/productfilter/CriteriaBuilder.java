package lowleveldesign.productfilter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaBuilder{

    private List<FilterCriteria> filterCriterias = new ArrayList<>();

    public CriteriaBuilder withPriceRange(double minPrice, double maxPrice){
         filterCriterias.add(new PriceCriteria(minPrice, maxPrice));
         return this;
    }

    public CompositeFilterCriteria build(){
        return new CompositeFilterCriteria(filterCriterias);
    }
}
