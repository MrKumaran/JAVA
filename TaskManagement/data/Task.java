package Learning.TaskManagement.data;

import java.util.Date;

public class Task {
    private final int id;
    private final String name;
    private final String description;
    private final Date dueDate;

    Task(Builder builder){
        this.id = builder.id;
        this.name = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public static class Builder{
        private int id;
        private String title;
        private String description;
        private Date dueDate = null;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.title = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDueDate(Date date){
            dueDate = date;
            return this;
        }

        public Task build(){
            return new Task(this);
        }
    }

}
