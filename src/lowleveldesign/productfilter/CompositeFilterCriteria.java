package lowleveldesign.productfilter;

import java.util.List;

public class CompositeFilterCriteria implements FilterCriteria{

    List<FilterCriteria> filterCriterias;

    public CompositeFilterCriteria(List<FilterCriteria> filterCriterias){
        this.filterCriterias = filterCriterias;

    }

    @Override
    public boolean matches(Product product) {
        for(FilterCriteria filterCriteria: filterCriterias){
            if(!filterCriteria.matches(product)){
                return false;
            }
        }
        return true;
    }
}
