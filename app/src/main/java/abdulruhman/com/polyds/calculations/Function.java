package abdulruhman.com.polyds.calculations;

/**
 * Created by mac on 12/18/17.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {

    ArrayList<Polynomial> polys;

    public Function() {
        polys = new ArrayList<Polynomial>();

    }

    public Function(String x) {
        polys = new ArrayList<Polynomial>();
        ParseFunction(x);
        //  reduceFunc();
    }

    private void ParseFunction(String input) {
        String exp = input;

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(exp);
        int x = 0;
        while (matcher.find()) {
            x = x + 1;
            polys.add(new Polynomial(matcher.group(1)));
        }
    }

    public void reduceFunc() {
        ArrayList<Polynomial> result = new ArrayList<Polynomial>();
        for (int i = 0; i < this.getSize(); i++) {
            if (this.polys.get(i).getCo() != 0) {
                result.add(this.polys.get(i));
            }
        }
        this.polys = result;
    }

    public void correlateFunc() {
        ArrayList<Polynomial> result = new ArrayList<Polynomial>();
        Polynomial temp= new Polynomial();
        for (int i = 0; i < this.getSize(); i++) {
            int t= this.findPower(result,this.polys.get(i).getPower());
            if(t!=-1){
                float i1=result.get(t).getCo();
                float i2=this.polys.get(i).getCo();
                result.get(t).setCo(i1+i2);


            }else {
                temp = new Polynomial();
                temp.setCo(this.polys.get(i).getCo());
                temp.setPower(this.polys.get(i).getPower());
                result.add(temp);
                //   System.err.println(temp);
            }


        }
        this.polys=result;

    }
    public int findPower(float f){
        if(this.polys.isEmpty()){
            return -1;}
        for(int i = 0;i<this.getSize();i++){
            if(this.polys.get(i).getPower()==f){
                return i;
            }
        }

        return -1;
    }
    public int findPower(ArrayList <Polynomial> in ,float f){
        if(in.isEmpty()){
            return -1;

        }
        for(int i = 0;i<in.size();i++){
            if(in.get(i).getPower()==f){
                return i;
            }
        }

        return -1;
    }
    public Function addFunc(Function a) {

        Function result = new Function();
        result.polys.addAll(this.polys);
        result.polys.addAll(a.polys);
        result.correlateFunc();
        result.reduceFunc();
        return result;
    }

    public Function subFunc(Function a) {
        for (Polynomial x : a.polys) {
            x.setCo(x.getCo() * -1);
        }
        return this.addFunc(a);
    }

    public Function mulFunc(Function a) {
        Function result = new Function();
        for (Polynomial x : this.polys) {
            for (Polynomial y : a.polys) {
                Polynomial p = new Polynomial();
                p.setCo(x.getCo() * y.getCo());
                p.setPower(x.getPower() + y.getPower());
                result.polys.add(p);
            }
        }

        result.reduceFunc();
        result.correlateFunc();
        return result;
    }

    public Function divFunc(Function a) {
        Function result=new Function();
        result=this;

        for (Polynomial x : a.polys) {
            x.setPower(x.getPower() * -1);
        }
        a.reduceFunc();
        return result.mulFunc(a);
    }

    public float getDegree() {
        float max = this.polys.get(0).getPower();
        for (Polynomial x : polys) {
            if (x.getPower() >= max) {
                max = x.getPower();
            }
        }
        return max;
    }

    public float execute(float x) {
        float result = 0;
        for (Polynomial f : polys) {
            result += (f.getCo() * (Math.pow(x, f.getPower())));

        }
        return result;
    }

    public String toString() {
        this.reduceFunc();

        String result = "";
        for (Polynomial x : polys) {
            if (Math.signum(x.getCo()) == -1) {
                //  result += "-";
            } else if (Math.signum(x.getCo()) == 1) {
                // if(x.getCo()!=1 )
                if ((x.getCo() != 1 && this.polys.indexOf(x) != 0) || (x.getCo() == 1 && this.polys.indexOf(x) != 0)) {
                    result += "+";
                }
            }
            if (x.getPower() != 0) {
                if (x.getCo() == 1) {
                    result += "x";
                } else {
                    result += x.getCo() + "x";
                }

                if (x.getPower() != 1) {
                    result += "^" + x.getPower();

                }

            } else if (x.getPower() == 0) {
                result += x.getCo();
            }

        }
        if (result.trim().equals("")) {
            result = "0";
        }
        return result;
    }

    public int getSize() {
        return this.polys.size();
    }

    public void sortPolys() {
        Polynomial test = null;
        for (int i = 0; i < this.getSize() - 1; i++) {
            for (int j = i; j < this.getSize(); j++) {
                if (this.polys.get(i).getPower() <= this.polys.get(j).getPower()) {
                    System.out.println(j);

                    test = this.polys.get(i);
                    this.polys.set(i, this.polys.get(j));

                    //this.polys.set(j, test);
                }
            }
        }
    }
}
