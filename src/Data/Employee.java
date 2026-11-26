package Data;

public class Employee {
    public String name;
    public String lastname;
    public String jobRole;
    public float salary;
    public boolean isActive;
    public Address address;
    private final String[] hobbies;
    private final Movie[] favoriteMovies;

    public Employee(String name,
                    String lastname,
                    String jobRole,
                    float salary,
                    boolean isActive,
                    Address address,
                    String[] hobbies,
                    Movie[] movies) {
        this.name = name;
        this.lastname = lastname;
        this.jobRole = jobRole;
        this.salary = salary;
        this.isActive = isActive;
        this.address = address;
        this.hobbies= hobbies;
        this.favoriteMovies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
