package Home;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.MySqlConstant;

public class HomeDB {
	public static HomeDB getObject() {
        return new HomeDB();
    }

	public List<HomeVO> getCountAll() throws ClassNotFoundException, SQLException {
        List<HomeVO> members = new ArrayList<HomeVO>();
        Statement statement = MySqlConstant.getInstance().getCreatedStatement();
        String query = "SELECT(SELECT count(userName) FROM user ) AS user,(SELECT COUNT(projectId) FROM project) AS project,"
        		+ "(SELECT count(issueId) FROM projectissue) AS projectissue";
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()) {
            HomeVO project = new HomeVO();
            project.setuserName(rs.getInt(1));
            project.setprojectId(rs.getInt(2));
            project.setissueId(rs.getInt(3));
           
            members.add(project);
        }
        return members;
    }

}
