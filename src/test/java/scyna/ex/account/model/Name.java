package scyna.ex.account.model;

public class Name {
    String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name create(String name) throws scyna.Error {
        if (name == null || name.length() == 0) {
            throw Error.BAD_NAME;
        }

        return new Name(name);
    }

    public String toString() {
        return value;
    }
}
