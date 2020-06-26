package app.entity;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/16 11:31
 */
public class Admin {
    private String admin_id;
    private String admin_pwd;
    private String admin_name;
    private String admin_phone;
    private String admin_email;
    private String admin_location;
    private String admin_role_id;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_location() {
        return admin_location;
    }

    public void setAdmin_location(String admin_location) {
        this.admin_location = admin_location;
    }

    public String getAdmin_role_id() {
        return admin_role_id;
    }

    public void setAdmin_role_id(String admin_role_id) {
        this.admin_role_id = admin_role_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                ", admin_email='" + admin_email + '\'' +
                ", admin_location='" + admin_location + '\'' +
                ", admin_role_id='" + admin_role_id + '\'' +
                ", role=" + role.toString() +
                '}';
    }
}

