/**
 * 사용자 위치 입력 화면의 control 클래스
 *
 *
 *  <p>생성 후 사용 전에 반드시 {@link #initialize(LocationMapScreen, MapInformation, UserLocation)} 메소드를 호출할 것. </p>
 */
public class LocationControl {
    private LocationMapScreen locationMapScreen;
    private MapInformation mapInformation;
    private UserLocation userLocation;

    /**
     * 기본 생성자.
     */
    public LocationControl() {}

    /**
     * 의존성을 넣어주기 위한 초기화 메소드.
     * @param locationMapScreen
     * 위치 지도 화면
     * @param mapInformation
     * 지도 정보
     * @param userLocation
     * 사용자 위치 정보
     */
    public void initialize(LocationMapScreen locationMapScreen, MapInformation mapInformation, UserLocation userLocation) {
        this.locationMapScreen = locationMapScreen;
        this.mapInformation = mapInformation;
        this.userLocation = userLocation;
    }

    /**
     * 사용자의 입력인 올바른지 확인한 후 저장 후 위치 지도 화면을 보여준다.
     * @param latitude
     * 위도(문자열)
     * @param longitude
     * 경도(문자열)
     * @return
     * 위도와 경도 입력값에 문제가 있으면 false, 없으면 true.
     */
    public boolean checkLocationInput(String latitude, String longitude) {
        if (!validate(latitude) || !validate(longitude)) {
            return false;
        }

        double convertedLatitude = Double.parseDouble(latitude);
        double convertedLongitude = Double.parseDouble(longitude);

        if (!mapInformation.checkBoundary(new Location(convertedLatitude, convertedLongitude))) {
            return false;
        }

        userLocation.store(convertedLatitude, convertedLongitude);
        locationMapScreen.show(userLocation);
        return true;
    }

    private boolean validate(String value) {
        value.trim();
        if (value.matches(".*[^0-9.]+.*")) {
            return false;
        }
        if (value.codePoints().filter(ch -> ch == '.').count() >= 2) {
            return false;
        }
        if (!value.matches("[0-9]+(.[0-9]*)?")) {
            return false;
        }
        return true;
    }
}
