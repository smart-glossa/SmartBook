package Home;

import java.sql.SQLException;
import java.util.List;

public class HomeBL {

	public static HomeBL getObject() {
        return new HomeBL();
    }
    public List<HomeVO> getCountAll() throws ClassNotFoundException, SQLException {
        return HomeDB.getObject().getCountAll();
    }

}

