package javaapplication9;

import java.util.List;
import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Crudo {

    public static void main(String[] args) {

        Configuration c = new Configuration();
        c.configure();
        SessionFactory sf = c.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
////
//        admin u = new admin();
//        u.setId(13);
//        u.setName("Anjali Kushwaha");
//        s.save(u);
//        
//        admin u1 = new admin();
//        u1.setId(12);
//        u1.setName("Dr.Peter");
//        s.save(u1);
//
//        admin u2 = new admin();
//        u2.setId(11);
//        u2.setName("Dr.Hiya Khakkhar");
//        s.save(u2);
////
//        appoint a1 = new appoint();
//       // a1.setId(1);
//        a1.setDId(11);
//        a1.setUId(13);
//        a1.setOName("Ear");
//        a1.setdate("13/02/2020");
//        a1.settime("3 P.M");
//        s.save(a1);
//        
//        appoint a3 = new appoint();
//       // a3.setId(3);
//        a3.setDId(12);
//        a3.setUId(13);
//        a3.setOName("Leg");
//        a3.setdate("14/02/2020");
//        a3.settime("4 P.M");
//        s.save(a3);
//
//        appoint a2 = new appoint();
//       // a2.setId(2);
//        a2.setDId(11);
//        a2.setUId(13);
//        a2.setOName("Eye");
//        a2.setdate("14/02/2020");
//        a2.settime("4 P.M");
//        s.save(a2);
        //READ
        System.out.println("*********************************************************************");
        System.out.println("                  HOSPITAL LOGIN PANEL!");
        System.out.println("*********************************************************************");
        System.out.println("\nARE YOU A:?\n    1.PATIENTS\n    2.DOCTORS");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            if (choice == 1) {
                try {
                    System.out.println("Patient User ID:");

                    int id = sc.nextInt();   //101
                    admin a = (admin) s.get(admin.class, id);
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("\nPATIENT DETAILS:\nPatient ID: " + a.getId() + "\nPatient NAME: " + a.getName());
                    System.out.println("---------------------------------------------------------------");
                    int ch;

                    System.out.println("\nDO YOU WANT TO:\n   1.Check Appointments\n   2.Book Appointments:");
                    ch = sc.nextInt();
                    if (ch == 1) {
                        Query query2 = s.createQuery("from appoint where uid=:eid");
                        query2.setParameter("eid", (id));
                        List<appoint> list2 = query2.list();
                        System.out.println("\nAppointment Details:");
                        for (appoint ap : list2) {
                            System.out.println("---------------------------------------------------------------");
                            System.out.println("\nAppointment for:"
                                    + ap.getOName() + "\nAppointed Doctor ID: " + ap.getDId() + "\nTime: "
                                    + ap.gettime() + "\nDate: " + ap.getdate());
                        }
                    }

                    if (ch == 2) {
                        System.out.println("ENTER APPOINTMENT DETAILS:\nAppointment for:");
                        String af = sc.next();
                        System.out.println("Doctor ID:");
                        int ad = sc.nextInt();
                        System.out.println("Time:");
                        String at = sc.next();
                        System.out.println("Date:");
                        String ada = sc.next();
                    // Query query6 = select max(cat.weight) from Cat cat;
                        //  Query query6 = s.createQuery("from appoint where id=:del");
                        //int nid = 0;
                        for (int i = 0; i < 1; i++) {
                            // nid++;
                            appoint a4 = new appoint();
                            // a3.setId(nid);
                            a4.setDId(ad);
                            a4.setUId(id);
                            a4.setOName(af);
                            a4.setdate(ada);
                            a4.settime(at);
                            s.save(a4);
                            System.out.println("Appointment Succesfully Booked");
                            System.out.println("\nAppointmnet Details:"+"\nAppointment for:"
                                    + a4.getOName() + "\nAppointed Doctor ID: " + a4.getDId() + "\nTime: "
                                    + a4.gettime() + "\nDate: " + a4.getdate());
                            
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid patient ID: "+e);
                }
            }
                if (choice == 2) {
                    try{
                    System.out.println("Doctor User ID:");
                    int id = sc.nextInt();
                    admin a = (admin) s.get(admin.class, id);
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("\nDoctor ID:" + a.getId() + "\nDoctor NAME:" + a.getName());
                    System.out.println("---------------------------------------------------------------");

                    Query query3 = s.createQuery("from appoint where did=:eid");
                    query3.setParameter("eid", (id));
                    List<appoint> list3 = query3.list();
                    System.out.println("\nAppointment Details:");
                    for (appoint ap3 : list3) {
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("\nAppointment for:"
                                + ap3.getOName() + "\nPATIENT ID: " + ap3.getUId() + "\nTime: "
                                + ap3.gettime() + "\nDate: " + ap3.getdate());
                    }
                    System.out.println("\nDO YOU WANT TO DELETE APPOINTMENT:\n   1.Yes\n   2.No:");
                    int ch2 = sc.nextInt();
                    if (ch2 == 1) {
                        System.out.println("Enter Appointment Name:");
                        String op = sc.next();
                        String hql = "from appoint where operation like :op";
                        Query query = s.createQuery(hql);
                        query.setParameter("op", "%" + op + "%");
                        List<appoint> listProducts = query.list();
                        for (appoint aP : listProducts) {
                            
                            System.out.println("\nAppointment for:"
                                + aP.getOName() + "\nPATIENT ID: " + aP.getUId() + "\nTime: "
                                + aP.gettime() + "\nDate: " + aP.getdate());
                            System.out.println("Are you sure you want to delete this appointment?\n");
                            String ans=sc.next();
                           if(ans.equals("yes")){
                               s.delete(aP);
                               System.out.println("\nAppointment Deleted succesfully:");
                           }
                           else{
                               System.out.println("Appointment Deletetion Unsuccesfully:");
                           }   
                        }

                        // 
                    }
                }
                    catch (Exception e) {
                    System.out.println("Invalid patient ID: "+e);
                }
        }
            
        }catch (Exception e) {
            System.out.println(e + " Invalid User");
        }

            //UPDATE
            t.commit();
            s.close();
            sf.close();
            System.out.println(" Done!");
        }
    }
