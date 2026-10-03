import java.util.Objects;

public abstract class Shape {
    private final String id;
    private Renderer implementation;

    protected Shape(String id, Renderer implementation) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Shape ID must not be blank");
        }
        this.id = id;
        this.implementation = Objects.requireNonNull(implementation, "implementation");
    }

    public final String getId() {
        return id;
    }

    public final void setImplementation(Renderer implementation) {
        this.implementation = Objects.requireNonNull(implementation, "implementation");
    }

    protected final Renderer renderer() {
        return implementation;
    }

    public abstract String execute();
}
