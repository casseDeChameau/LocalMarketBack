package lab.local_market_app._Domain;

import lab.local_market_app.security.domain.Authority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    //:::::::::::::::::::::::::::::::::::::::::::           VARIABLES        :::::::::::::::::::::::::::::::::::::::::::::://

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")*/
   /* @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)*/
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
//    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
//    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
//    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
//    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
//    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "ENABLED")
    private Boolean enabled = true;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
//    @NotNull
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;


    //============================================        CONSTRUCTORS        =======================================================//

    public User(){}

    public User(@NotNull @Size(min = 4, max = 50) String username,
                @NotNull @Size(min = 4, max = 100) String password,
                @NotNull @Size(min = 4, max = 50) String firstname,
                @NotNull @Size(min = 4, max = 50) String lastname,
                @NotNull @Size(min = 4, max = 50) String email,
                @NotNull Boolean enabled,
                @NotNull Date lastPasswordResetDate,
                List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }

    //CONTRUCTOR USED CURRENTLY TO REGISTER
    public User(String username, String password){
        this.username=username;
        this.password=password;
    }


    //CONTRUCTOR USED CURRENTLY TO REGISTER
    public User(String username, String password, Long id){
        this.username=username;
        this.password=password;
        this.id = id;
    }


    //..............................................        METHODS     .........................................................//




    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     GETSET      >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}