package CaseStudy.entity;

import java.util.Date;

public class Booking {
    private static int count = 0;
    private int id;
    private Date Begin_Date;
    private Date End_Date;
    private int idCus;
    private String service_name;

    public Booking(int id, Date begin_Date, Date end_Date, int idCus, String service_name) {
        this.id = id;
        Begin_Date = begin_Date;
        End_Date = end_Date;
        this.idCus = idCus;
        this.service_name = service_name;
    }

    public int getId() {
        return id;
    }

    public Date getBegin_Date() {
        return Begin_Date;
    }

    public void setBegin_Date(Date begin_Date) {
        Begin_Date = begin_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
