import java.util.ArrayList;
import java.util.Collection;

/**
 * 테마 선택 화면과 지도 화면을 제어하는 control 클래스
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드 호출
 */
public class ThemeControl {
    private ThemeMapScreen themeMapScreen;
    private UserLocation userLocation;
    private PlaceResource placeResource;

    /**
     * 의존성 주입을 위한 초기화 메소드
     * @param themeMapScreen
     * 테마 지도 화면
     * @param userLocation
     * 사용자 위치 화면
     * @param placeResource
     * 장소 조회를 위한 장소 정보
     */
    public void initialize(ThemeMapScreen themeMapScreen, UserLocation userLocation, PlaceResource placeResource) {
        this.themeMapScreen = themeMapScreen;
        this.userLocation = userLocation;
        this.placeResource = placeResource;
    }

    /**
     * 선택한 테마에 맞게 테마 지도 화면을 보여줌.
     * @param themeTag
     * 선택한 테마
     */
    public void selectTheme(ThemeTag themeTag) {
        themeMapScreen.show(userLocation, themeTag, placeResource.queryTheme(themeTag));
    }
}
