package service.product;

import model.product.Product;
import service.IGeneralManager;

public interface IProductManager<P> extends IGeneralManager<Product> {
    void sortProductByPrice();
    void searchProduct();
}
