package abdulruhman.com.polyds.calculations;

/**
 * Created by mac on 12/18/17.
 */

public class Polynomial {

    private float co = 0, power = 0;

    Polynomial() {

    }

    public Polynomial(String x) {
        ParsePolynomial(x);
    }

    private void ParsePolynomial(String x) {

        x=x.trim();
        //System.out.println(x);
        if (x.contains("x")) {
            //  x.indexOf("x");
            if (x.indexOf("x") == 0 ||(x.indexOf("x") == 1&&x.charAt(0)=='+') ) {
                this.co = 1;
            }else if (x.indexOf("x") == 0 ||(x.indexOf("x") == 1&&x.charAt(0)=='-') ) {
                this.co = -1;
            }
            else if (x.indexOf("x") != 0 ) {
                if(x.charAt(1)!='x')
                    co = Float.parseFloat(x.substring(0, x.indexOf("x")));

            }
            if(x.contains("^")){
                power=Float.parseFloat(x.substring(x.indexOf("^")+1,x.length()));
            }else {
                power=1;
            }
        }else{
            power=0;
            co=Float.parseFloat(x);
        }

    }

    /**
     * @return the co
     */
    public float getCo() {
        return co;
    }

    /**
     * @param co the co to set
     */
    public void setCo(float co) {
        this.co = co;
    }

    /**
     * @return the power
     */
    public float getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(float power) {
        this.power = power;
    }
    public String toString(){
        return this.co+"x^"+this.power;
    }

}
