package manager.product;

import model.product.Product;
import manager.IGeneralManager;

public interface IProductManager<P> extends IGeneralManager<Product> {
    void sortProductByPrice();
    void searchProduct();
}
