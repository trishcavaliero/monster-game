package gameinterfaces;

public class Monster extends Creature {
	
	private boolean isEnraged;
	private int enrageThreshold;

	public Monster(String name, String description, int hitPoints, int damage, int enrageThresh) {
		super(name, description, hitPoints, damage);
		enrageThreshold = enrageThresh;
		
	}

	public boolean canEnrage() {
		if (this.getHitPoints() < this.enrageThreshold && this.getHitPoints() > 0) {
			return true;
		}
		else { 
			return false;
			
		}
		
	}
	
	public void enrage() {
		if(this.canEnrage() == true) {
			this.setDamage(this.getDamage()*2);
			System.out.println(this.getName().toUpperCase() + "HAS BEEN ENRANGED!!!");
			isEnraged = true;
		isEnraged = false;
		}
	}
	
	public boolean getIsEnraged() {
		return isEnraged;
		
	
	
		
	}
	
	
}
