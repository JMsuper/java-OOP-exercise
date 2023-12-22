package academy.pocu.comp2500.assignment2;

public class HashClass {
    private int id;
    private String name;
    public HashClass(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals() method call!");
        if(this == obj){
            return true;
        }
        if(!(obj instanceof HashClass)){
            return false;
        }

        HashClass other = (HashClass) obj;
        return id == other.id && name.equals(((HashClass) obj).name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode() method call!");
        return this.id;
    }
}
