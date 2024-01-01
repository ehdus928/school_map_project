import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 위치 지도 화면
 *
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드 호출해야 한다.
 */
public class LocationMapScreen {
    private JFrame frameMain;
    private JPanel panelMain;
    private JButton buttonReturn;
    private JButton buttonOk;
    private JPanel panelMap;
    private ImagePanel map;
    private MenuScreen menuScreen;

    /**
     * 기본 생성자
     */
    public LocationMapScreen() {}

    /**
     * 화면을 보여준다. userLocation의 위치에 마커를 표시한다.
     * @param userLocation
     * 사용자 위치
     */
    public void show(UserLocation userLocation) {
        if (map != null) {
            panelMap.remove(map);
        }
        map = MapInformation.addMapImage(panelMap);
        MapInformation.addMarkerImage(map, userLocation.getUserLocation());
        frameMain.pack();
        frameMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameMain.setVisible(true);

    }

    private void addListeners() {
        buttonReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        buttonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
    }

    /**
     * 위존성 주입을 위한 초기화 메소드
     * @param menuScreen
     * 메뉴 화면
     */
    public void initialize(MenuScreen menuScreen) {
        this.frameMain = new JFrame("사용자 위치 확인");
        this.menuScreen = menuScreen;

        frameMain.setContentPane(this.panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();

        addListeners();
    }
}
