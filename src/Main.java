/**
 * 메인 클래스.
 */
public class Main {
    /**
     * 진입점(Entry Point).
     * 어플리케이션에 필요한 인스턴스를 생성하고, 의존성을 주입해준다.
     * 초기화면을 실행한다.
     * @param args
     * 아무런 역할을 하지 않는다.
     */
    public static void main(String[] args) {
        LocationInputScreen locationInputScreen = new LocationInputScreen();
        LocationMapScreen locationMapScreen = new LocationMapScreen();
        MenuScreen menuScreen = new MenuScreen();
        ThemeMapScreen themeMapScreen = new ThemeMapScreen();
        ThemeScreen themeScreen = new ThemeScreen();

        LocationControl locationControl = new LocationControl();
        MapInformation mapInformation = new MapInformation();
        ThemeControl themeControl = new ThemeControl();
        PlaceResource placeResource = new PlaceResource();

        UserLocation userLocation = new UserLocation();

        locationInputScreen.initialize(locationControl, menuScreen);
        locationMapScreen.initialize(menuScreen);
        menuScreen.initialize(locationInputScreen, themeScreen);
        themeMapScreen.initialize(themeScreen);
        themeScreen.initialize(menuScreen, themeControl);

        locationControl.initialize(locationMapScreen, mapInformation, userLocation);
        mapInformation.initialize();
        themeControl.initialize(themeMapScreen, userLocation, placeResource);
        placeResource.initialize();

        userLocation.initialize();

        locationInputScreen.show();
    }
}
