
package braintoplace;

public class Fecha {
    private int dia, mes, año;

    public Fecha(){
        this(1,1,2000);
    }
    public Fecha(int d, int m, int a){
        this.dia=d;
        this.mes=m;
        this.año=a;
    }

    public void setDia(int d){
        this.dia=d;
    }
    public void setMes(int m){
        this.mes=m;
    }
    public void setAño(int a){
        this.año=a;
    }

    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }

    public Fecha fechaMenor(Fecha f){
        if(this.año<f.año){
            return this;
        }else if(this.año>f.año){
            return f;
        }else{
            if(this.mes<f.mes){
                return this;
            }else if(this.mes>f.mes){
                return f;
            }else{
                if(this.dia<f.dia){
                    return this;
                }else{
                    return f;
                }
            }
        }
    }


    @Override
    public String toString(){
        return this.dia+"/"+this.mes+"/"+this.año;
    }

}
