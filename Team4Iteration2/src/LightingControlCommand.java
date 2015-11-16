public abstract class LightingControlCommand implements ICommand {

    protected HouseSection section;

    protected LightingControlCommand(HouseSection hs) {
        section = hs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LightingControlCommand)) {
            return false;
        }

        LightingControlCommand other = (LightingControlCommand) obj;
        return this.section.getName().equals(other.section.getName());
    }

    @Override
    public int hashCode() {
        return section.getName().hashCode();
    }

    public HouseSection getSection() {
        return section;
    }
}
