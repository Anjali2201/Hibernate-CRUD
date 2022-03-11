
package javaapplication9;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appoint")
public class appoint implements Serializable {
    
   

    @Column(name="UID")
    private int uid;
    
    @Column(name="DID")
    private int did;
    
    @Column(name="date")
    private String date;
    
    @Column(name="Time")
    private String time;
    
    @Id
    @Column(name="operation")
    private String oname;
    public appoint(){}
    
    
    
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
    public int getUId(){
        return uid;
    }
    public void setUId(int uid){
        this.uid=uid;
    }
    public String getdate(){
        return date;
    }
    public void setdate(String date){
        this.date=date;
    }
    public String gettime(){
        return time;
    }
    public void settime(String time){
        this.time=time;
    }
    
    public int getDId(){
        return did;
    }
    public void setDId(int did){
        this.did=did;
    }
    public String getOName(){
        return oname;
    }
    public void setOName(String oname){
        this.oname=oname;
    }
       
}
