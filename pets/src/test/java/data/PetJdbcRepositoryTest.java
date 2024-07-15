package data;

import static org.junit.jupiter.api.Assertions.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

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

}