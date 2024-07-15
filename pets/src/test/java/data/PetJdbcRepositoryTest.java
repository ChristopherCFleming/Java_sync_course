package data;

import static org.junit.jupiter.api.Assertions.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import models.Pet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

class PetJdbcRepositoryTest {
    // 1. Dangerous initialization during construction
    private DataSource dataSource = initDataSource();

    private DataSource initDataSource() {
        MysqlDataSource result = new MysqlDataSource();
        // 2. connection string is:
        // [db-tech]:[db-vendor]://[host]:[port]/[database-name]
        result.setUrl("jdbc:mysql://localhost:3306/pets");
        // 3. username
        result.setUser("your-username-here");
        // 4. password
        result.setPassword("your-password-here");
        return result;
    }

    public List<Pet> findAll() {
        ArrayList<Pet> result = new ArrayList<>();

        final String sql = "select pet_id, `name`, `type` from pet;";

        // 1. try-with-resources
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             // 2. a Statement executes a SQL query
             ResultSet rs = statement.executeQuery(sql)) {

            // 3. Process a row at a time until there are no more.
            while (rs.next()) {
                Pet pet = new Pet();
                // 4. Column values are for the current row.
                pet.setPetId(rs.getInt("pet_id"));
                pet.setName(rs.getString("name"));
                pet.setType(rs.getString("type"));
                result.add(pet);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}