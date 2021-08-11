package ch.gobothegeek.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "skel_user")
@Entity
public class User implements Serializable {
    @Id private String id; // user internal id
    private String login; // named used to log in
    private String password; // password (thx Captain Obvious)
    private Date registration; // date of registration
    private Date lastLogin; // date of last successful login
    private Boolean enabled; // true if account is enabled, false otherwise

    public User() { }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getRegistration() { return registration; }
    public void setRegistration(Date registration) { this.registration = registration; }

    public Date getLastLogin() { return lastLogin; }
    public void setLastLogin(Date lastLogin) { this.lastLogin = lastLogin; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastLogin=" + lastLogin +
                ", enabled=" + enabled +
                '}';
    }
}
