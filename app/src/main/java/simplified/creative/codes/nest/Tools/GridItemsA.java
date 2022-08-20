package simplified.creative.codes.nest.Tools;

import android.graphics.Bitmap;

public class GridItemsA {

    Bitmap icon;
    String label;
    String appPackage;

    public GridItemsA(Bitmap icon, String label, String appPackage) {
        super();
        this.icon = icon;
        this.label = label;
        this.appPackage = appPackage;
    }
    public Bitmap getIcon() {
        return icon;
    }
    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getAppPackage() {
        return appPackage;
    }
    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }
}
