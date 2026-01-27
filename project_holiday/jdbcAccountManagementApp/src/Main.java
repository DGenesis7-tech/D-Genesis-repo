import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/account_manager_db";
    String user = "root";
    String password = "Blessingokp080";
    try {
        Connection connection = DriverManager.getConnection(url, user, password);
        String createTable = """
                CREATE TABLE `account_manager_db`.`password` (
                  `id` INT NOT NULL,
                  `password` VARCHAR(255) NOT NULL,
                  `email` VARCHAR(45) NULL,
                  PRIMARY KEY (`id`));
                
                """;
        var statement = connection.prepareStatement(createTable);
        statement.executeUpdate();

    } catch (SQLException exception) {
        exception.printStackTrace();
    }
}
