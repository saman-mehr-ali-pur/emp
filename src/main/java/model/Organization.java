package model;

public class Organization extends BaseModel {
    private String name;
    private String code;

    public Organization(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    
}
