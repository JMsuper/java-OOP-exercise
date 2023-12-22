package pattern.builder;

public class EmployeeBuilder {
    private final Integer id;
    private Integer age;
    private Integer startingYear;
    private String firstName;
    private String lastName;

    public EmployeeBuilder(int id){
        this.id = id;
    }

    public EmployeeBuilder withAge(int age){
        this.age = age;
        return this;
    }

    public EmployeeBuilder withStaringYear(int startingYear){
        this.startingYear = startingYear;
        return this;
    }

    public EmployeeBuilder withName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        return this;
    }


    public Employ build(){
        if(age != null && startingYear != null && !firstName.isEmpty() && !lastName.isEmpty()){
            return new Employ(id,age,startingYear,firstName,lastName);
        }
        return null;
    }
}
