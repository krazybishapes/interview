package lowleveldesign.productfilter;

public class PriceCriteria implements FilterCriteria{

    private double minPrice;
    private double maxPrice;

    public PriceCriteria(double minPrice,double maxPrice){
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
    @Override
    public boolean matches(Product product) {

        if(product.getPrice()>=minPrice && product.getPrice()<maxPrice){
            return true;
        }
        return false;
    }
}
