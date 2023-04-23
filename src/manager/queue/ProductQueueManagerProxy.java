package manager.queue;

import model.user.Role;

public class ProductQueueManagerProxy implements IProductQueueManager{
    private final Role role;
    private final ProductQueueManager realProductQueueManager = new ProductQueueManager();
    public ProductQueueManagerProxy(Role userRole){
        this.role = userRole;
    }

    @Override
    public void add(ProductQueue productQueue) {
        switch (this.role){
            case ADMIN,STOREKEEPER -> realProductQueueManager.add(productQueue);
            case ACCOUNTANT,SALE_STAFF -> System.out.println("Unauthorized!");
        }
    }

    @Override
    public void remove() {
        switch (this.role){
            case ADMIN,STOREKEEPER -> realProductQueueManager.remove();
            case ACCOUNTANT,SALE_STAFF -> System.out.println("Unauthorized!");
        }
    }

    @Override
    public void edit() {
        switch (this.role){
            case ADMIN,STOREKEEPER -> realProductQueueManager.edit();
            case ACCOUNTANT,SALE_STAFF -> System.out.println("Unauthorized!");
        }
    }

    @Override
    public void display() {
        realProductQueueManager.display();
    }

    @Override
    public void searchProduct() {
        realProductQueueManager.searchProduct();
    }
}
