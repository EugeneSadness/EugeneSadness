package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Market {
    public static void main(String[] args){
        Package pack1 = new Package("Cola", 0.2);
        Package pack2 = new Package("Lays", 0.1);
        Package pack3 = new Package("Big Package", 0.6);
        PackedWeightGoods prod1 = new PackedWeightGoods(pack2, 0.5, "Lays", "tasty chips");
        PackedWeightGoods prod2 = new PackedWeightGoods(pack2, 0.5, "Lays", "tasty chips");
        PackedPieceGoods prod3 = new PackedPieceGoods(pack1, 5, 0.4, "Cola", "good drink");
        PackedWeightGoods prod4 = new PackedWeightGoods(pack1, 0.4, "Cola", "good drink");
        Packable[] set = new Packable[4];
        set[0] = prod1;
        set[1] = prod2;
        set[2] = prod3;
        set[3] = prod4;
        //PackedSetGoods comb = new PackedSetGoods(pack3, set);
    }
}

class Label {
    private String title;

    Label(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(title, label.title);
    }


    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Label{" +
                "title='" + title + '\'' +
                '}';
    }
}

    class Product extends Label {
        private String description;

        public Product(String title, String description) {
            super(title);
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public int hashCode() {
            return Objects.hash(description.hashCode(), super.getTitle());
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() == obj.getClass()) {
                Product that = (Product) obj;
                return ((this.getTitle() == that.getTitle()) & this.description == that.description);
            }
            return false;
        }

        @Override
        public String toString() {
            return "Product{" + "title= " + super.getTitle() +
                    " description='" + description + '\'' +
                    '}';
        }

    }

    class Package extends Label {
        private double weightOfPackage;

        Package(String title, double weight) {
            super(title);
            this.weightOfPackage = weight;
        }

        public double getWeightOfPackage() {
            return weightOfPackage;
        }

        public void setWeightOfPackage(int weight) {
            this.weightOfPackage = weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), weightOfPackage);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Package aPackage = (Package) o;
            return Double.compare(aPackage.weightOfPackage, weightOfPackage) == 0;
        }

        @Override
        public String toString() {
            return "Package{" + "title = " + super.getTitle() +
                    " weightOfPackage=" + weightOfPackage +
                    '}';
        }
    }

    class WeightGoods extends Product {
        public WeightGoods(String title, String description) {
            super(title, description);
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() == obj.getClass()) {
                WeightGoods that = (WeightGoods) obj;
                return (this.getTitle() == that.getTitle() & this.getDescription() == that.getDescription());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode());
        }

        @Override
        public String toString() {
            return "Product{" + "title= " + super.getTitle() +
                    " description='" + super.getDescription() + '\'' +
                    '}';
        }
    }

    class PieceGoods extends Product {
        private double weightOfPiece;

        public PieceGoods(double weight, String title, String description) {
            super(title, description);
            this.weightOfPiece = weight;
        }

        public double getWeightOfPiece() {
            return weightOfPiece;
        }

        public void setWeightOfPiece(int weightOfPiece) {
            this.weightOfPiece = weightOfPiece;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            PieceGoods that = (PieceGoods) o;
            return (this.getTitle() == that.getTitle() &
                    this.getDescription() == that.getDescription() &
                    this.getWeightOfPiece() == that.getWeightOfPiece());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), weightOfPiece);
        }

        @Override
        public String toString() {
            return "PieceGoods{" + " title=" + getTitle() + " description=" + getDescription() +
                    " weightOfPiece=" + weightOfPiece +
                    '}';
        }
    }

    interface Packable {

        double getNetWeight();
        String getTitle();
    }

    class PackedWeightGoods extends WeightGoods implements Packable {
        private Package pack;
        private double weight;

        PackedWeightGoods(Package pack, double weight, String title, String decription) {
            super(title, decription);
            this.pack = pack;
            this.weight = weight;
        }

        public double getNetWeight() {
            return weight;
        }

        public double getGrossWeight() {
            return weight + pack.getWeightOfPackage();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            PackedWeightGoods that = (PackedWeightGoods) o;
            return (getTitle() == that.getTitle() &&
                    getDescription() == that.getDescription() &&
                    getNetWeight() == that.getNetWeight() &&
                    Objects.equals(pack, that.pack));
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), pack.hashCode(), weight);
        }

        @Override
        public String toString() {
            return "PackedWeightGoods{" + " title" + getTitle() + " desription" + getDescription() +
                    " pack title=" + pack.getTitle() + " pack weight=" + pack.getWeightOfPackage() +
                    ", weight=" + weight +
                    '}';
        }
    }

    class PackedPieceGoods extends PieceGoods implements Packable {
        private Package pack;
        private double amount;

        PackedPieceGoods(Package pack, int amount, double weight, String title, String description) {
            super(weight, title, description);
            this.pack = pack;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        public double getNetWeight() {
            return super.getWeightOfPiece() * amount;
        }

        public double getGrossWeight() {
            return pack.getWeightOfPackage() + getNetWeight();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            PackedPieceGoods that = (PackedPieceGoods) o;
            return (getTitle() == that.getTitle() &&
                    getDescription() == that.getDescription() &&
                    getAmount() == that.getAmount() &&
                    getNetWeight() == that.getNetWeight() &&
                    Objects.equals(pack, that.pack));
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), pack.hashCode(), amount);
        }

        @Override
        public String toString() {
            return "PackedPieceGoods{" + "product title=" + getTitle() +
                    "pack title=" + pack.getTitle() + "pack weight=" + pack.getWeightOfPackage() +
                    ", amount=" + amount + " GrossWeight=" + getGrossWeight() +
                    '}';
        }
    }

    class PackedSetGoods implements Packable {
        private ArrayList<Packable> set = new ArrayList<Packable>();
        private Package pack;

        PackedSetGoods(Package pack, ArrayList<Packable> set) {
            for(Object el: set)
                if(el.getClass() == PackedSetGoods.class)
                    for(Object l: ((PackedSetGoods) el).getSet()) {
                        if (l.getClass() == PackedWeightGoods.class)
                            this.set.add((PackedWeightGoods) l);
                        else if (l.getClass() == PackedPieceGoods.class)
                            this.set.add((PackedPieceGoods)l);
                    }
                else
                    if (el.getClass() == PackedWeightGoods.class)
                        this.set.add((PackedWeightGoods) el);
                    else if (el.getClass() == PackedPieceGoods.class)
                        this.set.add((PackedPieceGoods)el);
            this.pack = pack;
        }

        public Package getPack() {
            return pack;
        }

        public ArrayList<Packable> getSet() {
            return set;
        }

        public double getNetWeight() {
            double setWeight = 0;
            for (Object el : set) {
                if (el.getClass() == PackedWeightGoods.class)
                    setWeight += ((PackedWeightGoods) el).getGrossWeight();
                else if (el.getClass() == PackedPieceGoods.class)
                    setWeight += ((PackedPieceGoods) el).getGrossWeight();
            }
            return setWeight;
        }

        public double getGrossWeight() {
            return getNetWeight() + pack.getWeightOfPackage();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PackedSetGoods that = (PackedSetGoods) o;
            for (int i = 0; i < set.size(); i++)
                if(getSet().get(i).getClass() != that.getSet().get(i).getClass())
                    return false;
            return  that.getSet().equals(getSet()) && Objects.equals(pack, that.pack);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(pack);
            for(Packable el: getSet())
                result = 31 * el.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "PackedSetGoods{" +
                    "set=" + getSet().toString() +
                    ", pack=" + pack +
                    '}';
        }

        public String getTitle(){
            return pack.getTitle();
        }
    }


    class ConsignmentOfGoods {
    private ArrayList<Packable> consigment = new ArrayList<Packable>();
    String description;

    ConsignmentOfGoods(String description, Object ...obs) throws IllegalArgumentException{
        for(Object o: obs) {
            if (o.getClass() == PackedSetGoods.class) {
                for (Packable el : ((PackedSetGoods) o).getSet())
                    if(el.getClass() == PackedPieceGoods.class)
                        consigment.add((PackedPieceGoods)el);
                    else if(el.getClass() == PackedWeightGoods.class)
                        consigment.add((PackedWeightGoods)el);
            }
            else if(o.getClass() == PackedPieceGoods.class)
                consigment.add((PackedPieceGoods)o);
            else if(o.getClass() == PackedWeightGoods.class)
                consigment.add((PackedWeightGoods)o);
            else
                throw new IllegalArgumentException("Uncorrect type of parametr");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Packable> getSet() {
        return consigment;
    }

    public double getNetWeight() {
        double setWeight = 0;
        for (Object o : consigment) {
            if (o.getClass() == PackedPieceGoods.class)
                setWeight += ((PackedPieceGoods) o).getGrossWeight();
            else if (o.getClass() == PackedWeightGoods.class) {
                setWeight += ((PackedWeightGoods)o).getGrossWeight();
            }
            else if (o.getClass() == PackedSetGoods.class)
                setWeight += ((PackedSetGoods) o).getGrossWeight();
        }
        return setWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsignmentOfGoods that = (ConsignmentOfGoods)o;
        if (getSet().size() != ((ConsignmentOfGoods) o).getSet().size()) return false;
        for(int i = 0; i < getSet().size(); i++) {
            if (getSet().get(i).hashCode() == that.getSet().get(i).hashCode())
                if (getSet().get(i).getClass() != PackedPieceGoods.class)
                    return false;
        }
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        for(Packable o: consigment){
            result += 31 * result + o.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return "ConsignmentOfGoods{" +
                "set=" + Arrays.toString(consigment.toArray()) +
                ", description='" + description + '\'' +
                '}';
    }
}