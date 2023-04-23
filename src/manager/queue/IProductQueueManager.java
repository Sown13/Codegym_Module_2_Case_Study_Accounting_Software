package manager.queue;

import manager.IGeneralManager;

public interface IProductQueueManager extends IGeneralManager<ProductQueue> {
    void searchProduct();
}
