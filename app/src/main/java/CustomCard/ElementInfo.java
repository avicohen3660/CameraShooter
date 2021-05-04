package CustomCard;

public class ElementInfo {

    private String elementName;
    private int elementPrice, elementUrlImage;

    public ElementInfo(String elementName, int elementPrice, int elementUrlImage) {
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

    public int getElementPrice() {
        return elementPrice;
    }

    public void setElementPrice(int elementPrice) {
        this.elementPrice = elementPrice;
    }

    public int getElementUrlImage() {
        return elementUrlImage;
    }

    public void setElementUrlImage(int elementUrlImage) {
        this.elementUrlImage = elementUrlImage;
    }
}
