package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Korisnik on 23.4.2017..
 */
@DatabaseTable(tableName = "knjiga")
public class Knjiga {

    public static final String POLJE_NASLOV = "naslov";
    public static final String POLJE_BROJ_STRANA = "broj_strana";
    public static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NASLOV, canBeNull = false)
    private String naslov;
    @DatabaseField(columnName = POLJE_BROJ_STRANA, canBeNull = false)
    private int brojStrana;
    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA, canBeNull = false)
    private Date datumIzdavanja;
    private boolean prisutna;

    @ForeignCollectionField(foreignFieldName = "knjiga")
    private ForeignCollection<Oblast> oblast;

    public Knjiga(){}

    public Knjiga(String naslov, int brojStrana, Date datumIzdavanja) {
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datumIzdavanja = datumIzdavanja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public boolean isPrisutna() {
        return prisutna;
    }

    public void setPrisutna(boolean prisutna) {
        this.prisutna = prisutna;
    }

    public ForeignCollection<Oblast> getOblast() {
        return oblast;
    }

    public void setOblast(ForeignCollection<Oblast> oblast) {
        this.oblast = oblast;
    }

    @Override
    public String toString() {
        return "Knjiga (ID: " + id + ", naslov: " + naslov + ", broj strana: " + brojStrana + ", datum izdavanja: " + datumIzdavanja
                + ')';
    }
}
