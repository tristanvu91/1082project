
public class Player {
	//instance variable
    public int life;
    public int ammo;
    public int shield;
    public int choice;

    //no argument constructor
    public Player() {
		this.life = 3;
		this.ammo = 3;
		this.shield = 3;
		this.choice = 0;
	}


	public int getLife() {
        return life;
    }


    public void setLife(int life) {
        this.life = life;
    }


    public int getAmmo() {
        return ammo;
    }


    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }


    public int getShield() {
        return shield;
    }


    public void setShield(int shield) {
        this.shield = shield;
    }

	
    public int getChoice() {
		return choice;
	}



	public void setChoice(int choice) {
		this.choice = choice;
	}

	/**
	 * @return this method returns an integer (0-4) for when shield or ammo reaches 0
	 */
	public int rules () {		
		if( this.ammo == 0 && this.shield == 0)		// ammmo and shield = 0
		{
			return 1;
		}		
		else if( this.ammo == 0)		//ammo = 0
		{
			return 2;
		}
		else if(this.shield == 0)		//shield = 0
		{
			return 3;
		}		
		return 0;		//ammo and shield != 0
	}
		

}