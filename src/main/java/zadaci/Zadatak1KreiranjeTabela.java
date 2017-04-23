package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Korisnik on 23.4.2017..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
            TableUtils.dropTable(conn, Oblast.class,true);
            TableUtils.dropTable(conn, Knjiga.class,true);

            TableUtils.createTable(conn, Knjiga.class);
            TableUtils.createTable(conn, Oblast.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } if (conn != null) {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
