package enums;

public enum Labels {	
	BINARY_TREE_EMPTY("Tree is Empty");

	private String label;
	
	Labels(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
