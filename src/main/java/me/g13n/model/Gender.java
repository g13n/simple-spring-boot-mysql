package me.g13n.model;

public enum Gender {
  MALE("M"),
  FEMALE("F");

  Gender(String gender) {
    this.gender = gender;
  }

  public static Gender fromString(String gender) {
    if (gender != null) {
      for (Gender g : Gender.values()) {
        if (gender.equalsIgnoreCase(g.gender)) {
          return g;
        }
      }
    }

    throw new IllegalArgumentException();
  }

  private String gender;
}
