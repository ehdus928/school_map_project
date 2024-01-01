import javax.swing.*;
import java.awt.*;

/**
 * 지도 정보 클래스
 *
 * 생성 후 사용 전에 반드시 {@link #initialize()} 메소드를 호출해야 한다.
 */
public class MapInformation {
    private static Location topLeftCorner = new Location(35.182890, 126.895623);
    private static Location bottomRightCorner = new Location(35.172066,126.914912);

    /**
     * 생성자.
     */
    public MapInformation() {
    }

    /**
     * panelMap에 지도 이미지가 있는 ImagePanel을 추가한다.
     * @param panelMap
     * 지도 이미지을 추가할 JPanel
     * @return
     * 추가한 ImagePanel 객체
     */
    public static ImagePanel addMapImage(JPanel panelMap) {
        ImagePanel map = new ImagePanel("Map.png");
        map.setLayout(null);
        panelMap.add(map, BorderLayout.CENTER);
        return map;
    }

    /**
     * map 이미지 패널의 location 위치에 마커 이미지 패널을 추가한다.
     * @param map
     * 마커 이미지 패널을 추가할 지도 ImagePanel
     * @param location
     * 마커 이미지 패널을 추가할 위치(위도, 경도 기준)
     */
    public static void addMarkerImage(ImagePanel map, Location location) {
        ImagePanel marker = new ImagePanel("Marker.png");
        map.add(marker);
        Insets insets = map.getInsets();
        int left = (int)Math.round((location.getLongitude() - topLeftCorner.getLongitude()) / (bottomRightCorner.getLongitude() - topLeftCorner.getLongitude()) * map.getWidth());
        int top = (int)Math.round((location.getLatitude() - bottomRightCorner.getLatitude()) / (topLeftCorner.getLatitude() - bottomRightCorner.getLatitude()) * map.getHeight());
        marker.setBounds(left + insets.left, map.getHeight() - top, marker.getWidth(), marker.getHeight());
    }

    /**
     * 해당 위치가 지도의 표현 범위 안에 있는 지를 확인한다.
     * @param location
     * 확인할 위치
     * @return
     * 지도 내부에 있다면 true, 아니면 false
     */
    public boolean checkBoundary(Location location) {
        return !(location.getLatitude() > topLeftCorner.getLatitude()
        || location.getLongitude() < topLeftCorner.getLongitude()
        || location.getLatitude() < bottomRightCorner.getLatitude()
        || location.getLongitude() > bottomRightCorner.getLongitude());
    }

    /**
     * 의존성을 넣어주기 위한 초기화 메소드.
     */
    public void initialize() {
    }
}
