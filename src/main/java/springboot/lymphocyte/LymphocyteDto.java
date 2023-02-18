package springboot.lymphocyte;

import java.util.Objects;

public class LymphocyteDto {
    private Long id;
    private String type;
    private boolean identifiedInvader;

    public LymphocyteDto(Long id, String type, boolean identifiedInvader) {
        this.id = id;
        this.type = type;
        this.identifiedInvader = identifiedInvader;
    }

    public LymphocyteDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIdentifiedInvader() {
        return identifiedInvader;
    }

    public void setIdentifiedInvader(boolean identifiedInvader) {
        this.identifiedInvader = identifiedInvader;
    }

    @Override
    public String toString() {
        return "LymphocyteDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", identifiedInvader=" + identifiedInvader +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LymphocyteDto that = (LymphocyteDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
