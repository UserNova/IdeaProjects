package ext;
import dao.IDao;

public class DaoImplV2 implements IDao{



    @Override
    public double getValue() {
        System.out.println("NEW");
        double data =33;
        return data;
    }
}
