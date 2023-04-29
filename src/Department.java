import java.util.Objects;

public class Department {

    public String name;
    public String email;
    public int workersCount;

    public Department(String name, String email, int workersCount) {
        this.name = name;
        this.email = email;
        this.workersCount = workersCount;
    }

    @Override
    public String toString() {
        return String.format("Department named %s", this.name);
    }

    // equals by workerCounts
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Department that)) return false;
        return workersCount == that.workersCount;
    }
}
