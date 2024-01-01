/**
 * 위치 정보 클래스
 */
public class Location {
    private final double latitude;
    private final double longitude;

    /**
     * 기본 생성자.
     * @param latitude
     * 위도
     * @param longitude
     * 경도
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * 위도를 반환한다.
     * @return
     * 위도
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * 경도를 반환한다.
     * @return
     * 경도
     */
    public double getLongitude() {
        return longitude;
    }
}
