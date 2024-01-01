import java.util.Collection;
import java.util.List;

/**
 * 장소를 나타내기 위한 클래스
 */
public class Place {
    private final String name;
    private final Location location;
    private final Collection<ThemeTag> themeTags;
    private final ConvenientFacilitiesTag convenientFacilitiesTag;

    /**
     * 기본 생성자.
     * @param name
     * 장소의 이름
     * @param location
     * 위치
     * @param themeTags
     * 속해 있는 테마 종류들
     * @param convenientFacilitiesTag
     * 속해 있는 편의시설 종류
     */
    public Place(String name, Location location, Collection<ThemeTag> themeTags, ConvenientFacilitiesTag convenientFacilitiesTag) {
        this.name = name;
        this.location = location;
        this.themeTags = themeTags;
        this.convenientFacilitiesTag = convenientFacilitiesTag;
    }

    /**
     * 장소의 이름을 반환한다.
     * @return
     * 장소의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 장소의 위치를 반환한다.
     * @return
     * 장소의 위치
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 장소가 속해 했는 테마 종류들을 반환한다.
     * @return
     * 속해 있는 테마 종류들
     */
    public Collection<ThemeTag> getThemeTags() {
        return themeTags;
    }

    /**
     * 장소가 속해 있는 편의 시설 종류를 반환한다.
     * @return
     * 속해 있는 편의 시설 종류
     */
    public ConvenientFacilitiesTag getConvenientFacilitiesTag() {
        return convenientFacilitiesTag;
    }
}
