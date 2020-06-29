package app.entity;

/**
 * @Description TO-Do
 * @Author DDQ
 * @Date 2020/6/29 1:16
 */
public class Password {
    private String newPassword;
    private String oldPassword;
    private String repetition;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    @Override
    public String toString() {
        return "PasswordModify{" +
                "newPassword='" + newPassword + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", repetition='" + repetition + '\'' +
                '}';
    }
}
