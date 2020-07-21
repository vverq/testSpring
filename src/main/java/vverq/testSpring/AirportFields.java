package vverq.testSpring;

public enum AirportFields {
    id,
    name,
    city,
    country,
    IATA,
    ICAO,
    latitude,
    longitude,
    altitude,
    timezone,
    DST,
    ianaTZ,
    type,
    source;

    public static AirportFields getFieldByName(String nameField) {
        switch (nameField) {
            case "id":
                return id;
            case "name":
                return name;
            case "city":
                return city;
            case "country":
                return country;
            case "IATA":
                return IATA;
            case "ICAO":
                return ICAO;
            case "latitude":
                return latitude;
            case "longitude":
                return longitude;
            case "altitude":
                return altitude;
            case "timezone":
                return timezone;
            case "DST":
                return DST;
            case "ianaTZ":
                return ianaTZ;
            case "type":
                return type;
            case "source":
                return source;
        }
        return null;
    }
}


