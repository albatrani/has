import java.util.ArrayList;
import java.util.List;

public class LightingControlTransaction {
	
	private ControlLightingTransactionType type;
	private List<LightingControlAction> lcas = new ArrayList<>();
	
	public LightingControlTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void addLightControlAction(HouseSection hs, LightStatus action){
		LightingControlAction lca = new LightingControlAction(hs, action);
		lcas.add(lca);
	}
	
	public TransactionStatus complete(){
		
		for (LightingControlAction lca : lcas) {
			if (!lca.process()){
				return TransactionStatus.Failed;
			}
			
		}
		
		return TransactionStatus.Successful;
		
	}

}
