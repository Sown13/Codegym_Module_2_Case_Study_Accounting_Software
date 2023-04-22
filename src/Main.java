import manager.product.ProductQueue;
import manager.product.ProductQueueManager;
import model.product.Product;
import model.product.ProductEXPLimited;
import model.product.ProductEXPUnLimited;

public class Main {
    public static void main(String[] args) {

        ProductQueueManager list = new ProductQueueManager();

        Product p1 = new ProductEXPLimited("sp1");
        p1.setProductId("111");
        Product p2 = new ProductEXPLimited("sp1");
        p2.setProductId("222");
        Product p3 = new ProductEXPUnLimited("sp3");
        Product p4 = new ProductEXPUnLimited("sp4");
        Product p5 = new ProductEXPUnLimited("sp5");

        ProductQueue q1 = new ProductQueue(5,p1);
        ProductQueue q2 = new ProductQueue(6,p2);
        ProductQueue q3 = new ProductQueue(1,p3);
        ProductQueue q4 = new ProductQueue(0,p4);
        ProductQueue q5 = new ProductQueue(-5,p5);

        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        list.add(q5);
        list.add(q1);
        list.add(q1);
        list.display();
        list.edit();
        list.display();

    }
}