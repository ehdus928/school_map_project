import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 장소들을 저장하고 필요한 장소를 검색하는 클래스
 */
public class PlaceResource {
    /**
     * 저장하고 있는 장소들
     */
    public List<Place> places;

    /**
     * 테마에 해당하는 장소들을 조회
     * @param theme
     * 조회할 테마
     * @return
     * 테마에 해당하는 장소들
     */
    public Collection<Place> queryTheme(ThemeTag theme) {
        Collection<Place> results = new ArrayList<>();
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getThemeTags().contains(theme)) {
                results.add(places.get(i));
            }
        }
        return results;
    }

    public Collection<Place> queryConvenientFacilities(ConvenientFacilitiesTag convenientFacilitiesTag) {
        throw new UnsupportedOperationException();
    }

    /**
     * 데이터 파일에서 장소 목록을 읽어 내부 데이터를 초기화한다.
     */
    public void initialize() {
        places = new ArrayList<Place>();
        List<List<String>> list = CSV.readToList("데이터저장.csv");
        for(int i = 1; i < list.size(); i++) {
            List<String> line = list.get(i);
            String name = line.get(0);
            double latitude = Double.parseDouble(line.get(1));
            double longitude = Double.parseDouble(line.get(2));
            List<ThemeTag> themeTags = new ArrayList<>();
            if (Integer.parseInt(line.get(3)) == 1) {
                themeTags.add(ThemeTag.Exercise);
            }
            if (Integer.parseInt(line.get(4)) == 1) {
                themeTags.add(ThemeTag.Walk);
            }
            if (Integer.parseInt(line.get(5)) == 1) {
                themeTags.add(ThemeTag.Study);
            }
            if (Integer.parseInt(line.get(6)) == 1) {
                themeTags.add(ThemeTag.Meal);
            }
            Place place = new Place(name, new Location(latitude, longitude), themeTags, new ConvenientFacilitiesTag(line.get(7)));
            places.add(place);
        }
    }
}
