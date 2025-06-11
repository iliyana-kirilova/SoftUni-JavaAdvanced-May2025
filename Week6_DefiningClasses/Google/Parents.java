package Week6_DefiningClasses.Google;

public class Parents {
    private String parentName;
    private String parenBirthday;

    public Parents(String parentName, String parenBirthday) {
        this.parentName = parentName;
        this.parenBirthday = parenBirthday;
    }

    @Override
    public String toString(){
        return String.format("%s %s", this.parentName, this.parenBirthday);
    }
}
