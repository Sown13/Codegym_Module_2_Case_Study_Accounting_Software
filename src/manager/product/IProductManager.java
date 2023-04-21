package manager.product;

import model.product.Product;
import manager.IGeneralManager;

public interface IProductManager extends IGeneralManager<Product> {
    void sortProductByPrice();

}
