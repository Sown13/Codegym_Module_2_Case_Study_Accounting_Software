package service.product;

import model.product.Product;
import service.IGeneralManager;

public interface IProductManager extends IGeneralManager<Product> {
    void sortProductByPrice();

}
