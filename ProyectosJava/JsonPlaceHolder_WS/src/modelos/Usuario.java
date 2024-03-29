package modelos;

import java.util.Map;

public class Usuario 
{
    private int id;
    private String name;
    private String  username;
    private String email;
    private Direccion address;
    private String phone;
    private String website;
    private Map<String, String> company;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Direccion getAddress() {
        return address;
    }
    public void setAddress(Direccion address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public Map<String, String> getCompany() {
        return company;
    }
    public void setCompany(Map<String, String> company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + "]";
    }


}
