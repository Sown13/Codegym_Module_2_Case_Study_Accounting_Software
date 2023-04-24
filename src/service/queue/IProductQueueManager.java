package service.queue;

import service.IGeneralManager;

public interface IProductQueueManager extends IGeneralManager<ProductQueue> {
    void searchProduct();

}
