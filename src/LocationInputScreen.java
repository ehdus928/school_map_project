import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 사용자 위치 입력 화면
 *
 * 생성 후 사용하기 전에 반드시 {@link #initialize} 메소드 호출해야 한다.
 */
public class LocationInputScreen {
    private JFrame frameMain;
    private JPanel panelMain;
    private JTextField textFieldLatitude;
    private JTextField textFieldLongitude;
    private JButton buttonSkip;
    private JButton buttonOk;
    private LocationControl locationControl;
    private MenuScreen menuScreen;

    /**
     * 기본 생성자
     */
    public LocationInputScreen() { }

    /**
     * 화면을 보이게 한다.
     */
    public void show() {

        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
        frameMain.setBounds(400,200,500,300);
    }

    private void addListeners() {
        buttonSkip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
        buttonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (locationControl.checkLocationInput(textFieldLatitude.getText(), textFieldLongitude.getText())) {
                    frameMain.setVisible(false);
                    return;
                }
                JOptionPane.showMessageDialog(frameMain, "위치 입력 값이 잘못되어있습니다.");
            }
        });
    }

    /**
     * 의존성 주입을 위한 초기화 메소드
     * @param locationControl
     * 위치 입력 화면의 control
     * @param menuScreen
     * 메뉴 화면
     */
    public void initialize(LocationControl locationControl, MenuScreen menuScreen) {
        this.frameMain = new JFrame("사용자 위치 입력");
        this.locationControl = locationControl;
        this.menuScreen = menuScreen;

        frameMain.setContentPane(this.panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();

        addListeners();
    }
}
