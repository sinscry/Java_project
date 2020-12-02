package f_json.pojo;

public class Person {
    private String pname;
    private String password;
    private Integer page;
    //省略setter和getter方法

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPname() {
        return pname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPage() {
        return page;
    }
}