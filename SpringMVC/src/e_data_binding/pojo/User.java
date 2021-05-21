package e_data_binding.pojo;

public class User {
    private String userName;
    private String[] hobby; // 兴趣爱好
    private String[] friends; // 朋友
    private String carrer;
    private String houseRegister;
    private String remark;

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void setHouseRegister(String houseRegister) {
        this.houseRegister = houseRegister;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarrer() {
        return carrer;
    }

    public String getHouseRegister() {
        return houseRegister;
    }

    public String getRemark() {
        return remark;
    }

    public String getUserName() {
        return userName;
    }

    public String[] getFriends() {
        return friends;
    }

    public String[] getHobby() {
        return hobby;
    }
}
