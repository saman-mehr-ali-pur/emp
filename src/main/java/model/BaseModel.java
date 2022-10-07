package model;

import java.time.ZonedDateTime;

public abstract class BaseModel {
    private int id;
    private ZonedDateTime createdDate;

    public BaseModel() {
        setCreatedDate(ZonedDateTime.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

}
