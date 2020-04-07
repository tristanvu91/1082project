

public class Player {
	
    public int life;
    public int ammo;
    public int shield;
    public int choice;

    
    
    
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

	
	public int rules () {
		
		if( this.shield == 0)
		{
			System.out.println("No Ammo to Shoot ... ");
			return 1;
		}		
		else if( this.ammo == 0)
		{
			System.out.println("No Ammo to Shoot ... ");
			return 2;
		}
		else if( this.ammo == 0 && this.shield == 0)
		{
			System.out.println("No Ammo to Shoot ... ");
			return 3;
		}
		
		return 0;
	}
		

}
