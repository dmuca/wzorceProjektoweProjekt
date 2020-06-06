package pl.com.muca.apartment;

public final class Room {
  private final String name;

  private final double width;
  private final double length;
  private final double height;

  private Room(Builder builder) {
    this.width = builder.width;
    this.length = builder.length;
    this.height = builder.height;
    this.name = builder.name;
  }

  public String getName() {
    return name;
  }

  public double getWidth() {
    return width;
  }

  public double getLength() {
    return length;
  }

  public double getHeight() {
    return height;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private double width;
    private double length;
    private double height;
    private String name;

    private Builder() {}

    public Room build() {
      return new Room(this);
    }

    public Builder setWidth(double width) {
      this.width = width;
      return this;
    }

    public Builder setLength(double length) {
      this.length = length;
      return this;
    }

    public Builder setHeight(double height) {
      this.height = height;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }
  }
}
