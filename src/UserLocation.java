/**
 * 사용자 위치를 저장하는 클래스
 */
public class UserLocation {
    private Location location;

    /**
     * 기본 생성자
     */
    public UserLocation() {
        this.location = null;
    }

    /**
     * 사용자의 위치를 반환한다.
     * @return
     * 사용자의 위치. 저장된 위치가 없다면 null을 반환한다.
     */
    public Location getUserLocation() {
        return location;
    }

    /**
     * 사용자의 위치를 저장한다.
     * @param latitude
     * 사용자의 위도
     * @param longitude
     * 사용자의 경도
     */
    public void store(double latitude, double longitude) {
        this.location = new Location(latitude, longitude);
    }

    /**
     * 다른 control 클래스와 일관성을 맞추기 위한 임시 메소드
     */
    public void initialize() {
    }
}
