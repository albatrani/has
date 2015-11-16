import java.util.ArrayList;
import java.util.List;

/*
 * LightingControlTransaction represents the whole cycle of control lighting instance.
 * The class captures the list of HouseSections and their desired light action to be 
 * performed (modeled as LightingControlAction object). 
 */
public class LightingControlTransaction {

    private LightingControlTransactionType type;
    private List<LightingControlAction> lcas;

    public LightingControlTransaction() {
        type = LightingControlTransactionType.CUSTOM_LIGHTS_SELECTION;
        lcas = new ArrayList<>();
    }

    /*
     * Adds the user light control action for a house section and stores it in the list of
     * selected house sections
     */
    public void addLightControlAction(HouseSection hs, LightStatus action) {
        LightingControlAction lca = new LightingControlAction(hs, action);

        // check that the house section to be added is unique (no duplicates allowed)
        if (lcas.contains(lca)) {
            throw new IllegalArgumentException(
                    "The HouseSection supplied is already selected!");
        } else {
            // otherwise it's safe to added it
            lcas.add(lca);
        }
    }

    /*
     * Executes the lighting control transaction by processing every light control action
     * object in the list. Returns if the transaction was successful or failed.
     */
    public TransactionStatus complete() {
        for (LightingControlAction lca : lcas) {
            if (!lca.process()) {
                return TransactionStatus.FAILED;
            }
        }
        return TransactionStatus.SUCCESSFUL;
    }

    public List<LightingControlAction> getLcas() {
        return this.lcas;
    }

    public LightingControlTransactionType getType() {
        return type;
    }

    public void setType(LightingControlTransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String
                .format("Lighting Control Transaction with user selections as:%n"));
        for (LightingControlAction lca : lcas) {
            builder.append(String.format("   %s%n", lca.toString()));
        }
        return builder.toString();
    }
}
