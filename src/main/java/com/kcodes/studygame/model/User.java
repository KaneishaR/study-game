package com.kcodes.studygame.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Table(name = "user")
@Entity
public class User  implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @OneToMany(mappedBy = "user")
    private Set<Game> gameSet;

    public User() {
    }

    public User(Integer id, String username, Set<Game> gameSet) {
        this.id = id;
        this.username = username;
        this.gameSet = gameSet;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Game> getGameSet() {
        return gameSet;
    }

    public void setGameSet(Set<Game> gameSet) {
        this.gameSet = gameSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getUsername().equals(user.getUsername()) && Objects.equals(getGameSet(), user.getGameSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getGameSet());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gameSet=" + gameSet +
                '}';
    }
}
