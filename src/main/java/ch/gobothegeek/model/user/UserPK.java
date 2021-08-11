package ch.gobothegeek.model.user;

import java.io.Serializable;
import java.util.Objects;

public class UserPK implements Serializable {
    private String id;

    public UserPK() { }

    public UserPK(String id) { this.id = id; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPK userPK = (UserPK) o;
        return Objects.equals(id, userPK.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserPK{" +
                "id='" + id + '\'' +
                '}';
    }
}
