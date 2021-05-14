import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;

public class Laptop {
    private String manufacturer;
    private String category;
    private Specifications specifications;
    private String type;

    public Laptop(String manufacturer, String category, String type) {
        this.manufacturer = manufacturer;
        this.category = category;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Document LaptopObject(){
        Document laptop = new Document()
                .append("Manufacturer", this.getManufacturer())
                .append("Category", this.getCategory())
                .append("Specifications", new BasicDBObject("Processor", this.specifications.getProcessor())
                        .append("Graphics Card", this.specifications.getGraphicsCard())
                        .append("Memory", this.specifications.getMemory())
                        .append(" Storage",  this.specifications.getStorage())
                        .append("Manufacture Year", this.specifications.getManufacturerYear()))
                .append("Type", this.getType());

        return laptop;
    }

    public static class Specifications{
        private String processor;
        private String graphicsCard;
        private String memory;
        private String storage;
        private String manufacturerYear;

        public Specifications(String processor, String graphicsCard, String memory, String storage, String manufacturer) {
            this.processor = processor;
            this.graphicsCard = graphicsCard;
            this.memory = memory;
            this.storage = storage;
            this.manufacturerYear = manufacturer;
        }

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public String getGraphicsCard() {
            return graphicsCard;
        }

        public void setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
        }

        public String getMemory() {
            return memory;
        }

        public void setMemory(String memory) {
            this.memory = memory;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getManufacturerYear() {
            return manufacturerYear;
        }

        public void setManufacturerYear(String manufacturerYear) {
            this.manufacturerYear = manufacturerYear;
        }
    }
}
