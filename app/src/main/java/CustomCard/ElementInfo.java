package CustomCard;

public class ElementInfo {

    private String elementName, elementPrice, elementUrlImage;

    public ElementInfo(String elementName, String elementPrice, String elementUrlImage) {
        this.elementName = elementName;
        this.elementPrice = elementPrice;
        this.elementUrlImage = elementUrlImage;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementPrice() {
        return elementPrice;
    }

    public void setElementPrice(String elementPrice) {
        this.elementPrice = elementPrice;
    }

    public String getElementUrlImage() {
        return elementUrlImage;
    }

    public void setElementUrlImage(String elementUrlImage) {
        this.elementUrlImage = elementUrlImage;
    }
}
