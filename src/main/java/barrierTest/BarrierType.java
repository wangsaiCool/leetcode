package barrierTest;

/**
 * Created by WangSai on 2023/5/31
 */
public enum BarrierType {

    GalleryApi("galleryApi"),
    AppBackUpApi("appBackUpApi"),
    SmsApi("smsApi"),
    PhoneCallApi("phoneCallApi"),
    ContactApi("contactApi"),

    Default("default"),
    ;

    private final String barrierType;

    BarrierType(String barrierType) {
        this.barrierType = barrierType;
    }

    public String getBarrierType() {
        return barrierType;
    }

    public static BarrierType findByValue(String value) {
        switch (value) {
            case "galleryApi":
                return GalleryApi;
            case "appBackUpApi":
                return AppBackUpApi;
            case "smsApi":
                return SmsApi;
            case "phoneCallApi":
                return PhoneCallApi;
            case "contactApi":
                return ContactApi;
            default:
                return Default;
        }
    }
}
