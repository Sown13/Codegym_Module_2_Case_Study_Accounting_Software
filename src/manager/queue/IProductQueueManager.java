package manager.queue;

import manager.IGeneralManager;

import java.util.List;

public interface IProductQueueManager extends IGeneralManager<ProductQueue> {
    void searchProduct();

}
