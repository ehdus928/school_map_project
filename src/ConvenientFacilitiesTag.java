public class ConvenientFacilitiesTag {
    private String name;

    public ConvenientFacilitiesTag(String name) {
        this.name = name;
    }

    public static ConvenientFacilitiesTag nullTag() {
        return new ConvenientFacilitiesTag("");
    }

    public String getName() {
        return name;
    }
}