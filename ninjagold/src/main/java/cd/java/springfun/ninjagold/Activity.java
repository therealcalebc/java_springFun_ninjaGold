/**
 * 
 */
package cd.java.springfun.ninjagold;

/**
 * @author ccomstock
 *
 */
public class Activity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -333683523400592271L;
	private String color;
	private String message;
	
	public Activity() {
		this("Dark", "");
	}
	
	public Activity(String color, String message) {
		this.color = color;
		this.message = message;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
