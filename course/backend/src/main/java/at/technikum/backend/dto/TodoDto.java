package at.technikum.backend.dto;

public class TodoDto {


    private String name;

    public TodoDto() {
    }

    public TodoDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
