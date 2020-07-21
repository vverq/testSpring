package vverq.testSpring;


import com.opencsv.bean.CsvBindByPosition;
import org.springframework.cglib.core.internal.Function;

import java.util.HashMap;


public class Airport {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private String city;
    @CsvBindByPosition(position = 3)
    private String country;
    @CsvBindByPosition(position = 4)
    private String IATA;
    @CsvBindByPosition(position = 5)
    private String ICAO;
    @CsvBindByPosition(position = 6)
    private String latitude;
    @CsvBindByPosition(position = 7)
    private String longitude;
    @CsvBindByPosition(position = 8)
    private String altitude;
    @CsvBindByPosition(position = 9)
    private String timezone;
    @CsvBindByPosition(position = 10)
    private String DST;
    @CsvBindByPosition(position = 11)
    private String ianaTZ;
    @CsvBindByPosition(position = 12)
    private String type;
    @CsvBindByPosition(position = 13)
    private String source;

    private static HashMap<AirportFields, Function<Airport, String>> dick = new HashMap<>(){{
        put(AirportFields.id, x -> x.id);
        put(AirportFields.name, x -> x.name);
        put(AirportFields.city, x -> x.city);
        put(AirportFields.country, x->x.country);
        put(AirportFields.IATA, x->x.IATA);
        put(AirportFields.ICAO, x->x.ICAO);
        put(AirportFields.latitude, x->x.latitude);
        put(AirportFields.longitude, x->x.longitude);
        put(AirportFields.altitude, x->x.altitude);
        put(AirportFields.timezone, x->x.timezone);
        put(AirportFields.DST, x->x.DST);
        put(AirportFields.ianaTZ, x->x.ianaTZ);
        put(AirportFields.type, x->x.type);
        put(AirportFields.source, x->x.source);
    }};

    public String getFieldByName(String field) {
        return dick.get(AirportFields.getFieldByName(field)).apply(this);
    }

    public Airport() {

    }

    public Airport(
            String id, String name, String city, String country, String IATA, String ICAO,
            String latitude, String longitude, String altitude, String timezone, String DST,
            String ianaTZ, String type, String source) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.IATA = IATA;
        this.ICAO = ICAO;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
        this.DST = DST;
        this.ianaTZ = ianaTZ;
        this.type = type;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String IATA) {
        this.IATA = IATA;
    }

    public String getICAO() {
        return ICAO;
    }

    public void setICAO(String ICAO) {
        this.ICAO = ICAO;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String  getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getDST() {
        return DST;
    }

    public void setDST(String DST) {
        this.DST = DST;
    }

    public String getIanaTZ() {
        return ianaTZ;
    }

    public void setIanaTZ(String ianaTZ) {
        this.ianaTZ = ianaTZ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
