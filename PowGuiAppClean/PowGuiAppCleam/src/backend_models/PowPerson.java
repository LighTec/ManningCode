package backend_models;

/**
 * Another class to model the problem or situation your program solves
 * 
 * There should be no code here directly about painting graphics on the screen,
 * and no code here for directly handling user interaction.
 * 
 * All user interface related code must go in the frontend classes.
 * 
 * @author cheng
 */
public class PowPerson {

    private String name, rank;
    private int serial;
    private String gender;

    public PowPerson() {
        this.name = "";
        this.rank = "";
        this.serial = 0;
        this.gender = "";
    }
    
    public String getGender(){
        return this.gender;
    }
    public void setGender(String str){
        this.gender = str;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String str){
        this.name = str;
    }
    
    public String getRank(){
        return this.rank;
    }
    public void setRank(String str){
        this.rank = str;
    }
    
    public int getSerial(){
        return this.serial;
    }
    public void setSerial(int i){
        this.serial = i;
    }
    
    public String toString(){
        return this.getName();
    }
    
    public String getSaveString(){
        // Dan Taylor;Jr. Lt.;123

        String delimiter = ";";
        String str = this.name + delimiter + this.rank + delimiter + this.serial + delimiter + this.gender;
        return str;
    }
}
