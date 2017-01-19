package querydsl.domains;

import com.google.common.collect.Sets;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_login")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "name",nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_login_phone",
            joinColumns = @JoinColumn(name = "user_login_fk"),
            indexes = @Index(columnList = "user_login_fk"),
            uniqueConstraints = @UniqueConstraint(columnNames = { "user_login_fk", "phone_number" }))
    private Set<Phone> phones = Sets.newHashSet();

    protected User() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.phones = builder.phones;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;

        private String name;

        private String email;

        private String password;

        private Set<Phone> phones;

        private Builder() {

        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withPhones (Set<Phone> phones) {
            this.phones = phones;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }
}
