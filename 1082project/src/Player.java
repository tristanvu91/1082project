
public class Player {
	
    private int life;
    private int ammo;
    private int shield;


    public Player(int life, int ammo, int shield) 

    {
        super();
        this.life = 3;
        this.ammo = 0;
        this.shield = 0;
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

	
	
	

}
