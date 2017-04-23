package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Korisnik on 23.4.2017..
 */
public class Zadatak2DodavanjeVrednosti {
    static Dao<Knjiga,Integer> knjigaDao;
    static Dao<Oblast,Integer> oblastDao;
    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");
            knjigaDao = DaoManager.createDao(conn, Knjiga.class);
            oblastDao = DaoManager.createDao(conn, Oblast.class);

            Knjiga k1 = new Knjiga("Java programiranje", 650, new java.util.Date());
            knjigaDao.create(k1);

            Knjiga k2 = new Knjiga("Android programiranje", 500, new java.util.Date());
            knjigaDao.create(k2);

            Oblast o1 = new Oblast("Uvod", 2);
            o1.setKnjiga(k1);
            oblastDao.create(o1);

            Oblast o2 = new Oblast("Naredbe", 10);
            o2.setKnjiga(k1);
            oblastDao.create(o2);

            Oblast o3 = new Oblast("Artimeticki operatori", 20);
            o3.setKnjiga(k1);
            oblastDao.create(o3);

            Oblast o4 = new Oblast("Android operativni sistem", 2);
            o4.setKnjiga(k2);
            oblastDao.create(o4);

            Oblast o5 = new Oblast("Activity klasa", 30);
            o5.setKnjiga(k2);
            oblastDao.create(o5);

            List<Oblast> oblast = oblastDao.queryForAll();
            for (Oblast o: oblast)
                System.out.println("Oblast: " + o);

            List<Knjiga> knjiga = knjigaDao.queryForAll();
            for (Knjiga k:knjiga)
                System.out.println("Knjiga: " + k);

        } catch (SQLException e) {
            e.printStackTrace();
        }if (conn != null) {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
