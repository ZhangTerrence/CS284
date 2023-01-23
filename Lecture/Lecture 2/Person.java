public class Person {
    private String givenName;
    private String familyName;
    private String IDNumber;
    private int birthYear = 1900;
    // Constants doesn't change. They are written all uppercase and denoted by final
    public static final int VOTE_AGE = 18;
    public static final int SENIOR_AGE = 65;

    // Getter
    public String getGivenName() {
        return givenName;
    }

    // Setter
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    // Constructor
    // If no constructor is written, the built-in default parameters will be automatically called
    public Person(String givenName, String familyName) {
        this.setGivenName(givenName);
        this.setFamilyName(familyName);
    }

    // Default constructor
    public Person() {
        givenName = "";
        familyName = "";
    }

    public boolean canVote(int year) {
        return (year - birthYear) >= VOTE_AGE;
    }

    public boolean isSenior(int year) {
        return (year - birthYear) >= SENIOR_AGE;
    }

    // The toString() method automatically prints object information with called from System.out.println()
    public String toString() {
        return "Given name: " + givenName + "\n" + "Family name: " + familyName + "\n" + "ID number: " + IDNumber + "\n" + "Year of birth: " + birthYear + "\n";
    }

    public boolean equals(Person p) {
        if (p == null) {
            return false;
        }
        else {
            return this.familyName.equals(p.getFamilyName());
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
    }
}

