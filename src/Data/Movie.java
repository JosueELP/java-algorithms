package Data;

public class Movie {
    private final String name;
    private final float score;

    public Movie(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }
}
