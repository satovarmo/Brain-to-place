
package braintoplace;

public class Fecha {
    private int dia, mes, ano;

    public Fecha(){
        this(1,1,2000);
    }
    public Fecha(int d, int m, int a){
        this.dia=d;
        this.mes=m;
        this.ano=a;
    }

    public void setDia(int d){
        this.dia=d;
    }
    public void setMes(int m){
        this.mes=m;
    }
    public void setAno(int a){
        this.ano=a;
    }

    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAno(){
        return this.ano;
    }

    public Fecha fechaMenor(Fecha f){
        if(this.ano<f.ano){
            return this;
        }else if(this.ano>f.ano){
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
        return this.dia+"/"+this.mes+"/"+this.ano;
    }

}
