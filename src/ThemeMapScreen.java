import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * 테마 지도 화면
 *
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드를 호출해야 한다.
 */
public class ThemeMapScreen {
    private JFrame frameMain;
    private JPanel panelMain;
    private JButton buttonOk;
    private JList listPlaces;
    private JPanel panelMap;
    private JLabel labelTitle;
    private ImagePanel map;
    private ThemeScreen themeScreen;

    /**
     * 기본 생성자
     */
    public ThemeMapScreen() {}

    /**
     * 화면을 보이게 한다.
     * @param user
     * 사용자 위치 정보
     * @param themeTag
     * 선택된 테마 종류
     * @param places
     * 표시할 장소 목록
     */
    public void show(UserLocation user, ThemeTag themeTag, Collection<Place> places) {
        frameMain = new JFrame("THEME");
        frameMain.setContentPane(panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        String title = "선택하신 테마는 ";
        switch (themeTag) {
            case Meal :
                title += "식사";
                break;
            case Walk :
                title += "산책";
                break;
            case Study :
                title += "스터디";
                break;
            case Exercise :
                title += "운동";
                break;
        }
        title += " 입니다.";
        labelTitle.setText(title);
        if (map != null) {
            panelMap.remove(map);
        }
        map = MapInformation.addMapImage(panelMap);
        Vector<String> locationNames = new Vector<>();
        Iterator<Place> iterator = places.iterator();
        while (iterator.hasNext()) {
            Place place = iterator.next();
            MapInformation.addMarkerImage(map, place.getLocation());
            locationNames.add(place.getName() + " " + place.getConvenientFacilitiesTag().getName());
        }
        listPlaces.setListData(locationNames);

        if (user.getUserLocation() != null) {
            MapInformation.addMarkerImage(map, user.getUserLocation());
        }

        frameMain.pack();
        frameMain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameMain.setVisible(true);

    }

    /**
     * 의존성 주입을 위한 초기화 메소드
     * @param themeScreen
     * 테마 선택 화면
     */
    public void initialize(ThemeScreen themeScreen) {
        this.themeScreen = themeScreen;

        addListeners();
    }

    private void addListeners() {
        buttonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeScreen.show();
            }
        });
    }
}
