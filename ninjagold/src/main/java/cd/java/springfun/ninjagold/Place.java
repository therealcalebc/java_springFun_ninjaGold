/**
 * 
 */
package cd.java.springfun.ninjagold;

import java.io.Serializable;

import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author ccomstock
 *
 */
@SessionAttributes("place")
public class Place implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3335383489822666151L;
	private String name;
	private Integer minGold;
	private Integer maxGold;
	
	public Place() {
		this("a place", 0, 0);
	}
	
	/**
	 * @param name the name to set
	 * @param minGold the value to set for minimum gold
	 * @param maxGold the value to set for maximum gold
	 */
	public Place(String name, int minGold, int maxGold) {
		this.name = name;
		this.minGold = minGold;
		this.maxGold = maxGold;
	}
	
	/**
	 * @return the name
	 */
	public String getName() { return this.name; }
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * @return the value of minimum gold
	 */
	public String getMinGold() { return this.minGold.toString(); }
	
	/**
	 * @param minGold the value to set for minimum gold
	 */
	public void setMinGold(String minGold) { this.minGold = Integer.parseInt(minGold); }
	
	/**
	 * @return the value of maximum gold
	 */
	public String getMaxGold() { return this.maxGold.toString(); }
	
	/**
	 * @param maxGold the value to set for maximum gold
	 */
	public void setMaxGold(String maxGold) { this.maxGold = Integer.parseInt(maxGold); }
	
	/**
	 * @return a random value between minGold and maxGold
	 */
	public int getGold() { return (int)Math.floor(Math.random() * (this.maxGold - this.minGold) + this.minGold); }
	
}
