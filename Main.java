package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        String path="";//Enter the filepath of CSV file within double quotes
        Scanner s=new Scanner(System.in);
        double[] average=average();
        System.out.print("1.create".concat("\n")+"2.cgpa".concat("\n")+"3.class average".concat("\n")+"4.CGPA Differential".concat("\n"));
        int ch =s.nextInt();
        if (ch == 1) {
            System.out.println("Enter Roll No.");
            String rollno=s.next();
            System.out.println("Enter Name");
            String name=s.next();
            System.out.println("Enter Linear Algebra Marks.");
            double la_mark=s.nextDouble();
            System.out.println("Enter Data Structures Marks");
            double ds_mark=s.nextDouble();
            System.out.println("Enter Computer Architecture Marks");
            double ca_mark=s.nextDouble();
            System.out.println("Enter Discrete Structure Marks");
            double discrete_mark=s.nextDouble();
            System.out.println("Enter OOPS Marks");
            double oop_mark=s.nextDouble();
            System.out.println("Enter Economics Marks");
            double eco_mark=s.nextDouble();
            System.out.println("Enter Data Structure Lab Marks");
            double ds_lab_mark=s.nextDouble();
            System.out.println("Enter OOPS Lab Marks");
            double oop_lab_mark=s.nextDouble();
            System.out.println("Enter EVS Marks");
            double environment_mark=s.nextDouble();
            saverecord(path, rollno, name,la_mark,ds_mark,ca_mark, discrete_mark, oop_mark, eco_mark, ds_lab_mark,oop_lab_mark, environment_mark) ;
        }
        else if(ch==2){
            System.out.println("Enter Roll No.");
            String rno=s.next();
            System.out.println(cgpa(rno));
        }
        else if(ch==3){
            double maxvalue = average[0];
            double minvalue=average[0];
            int subjectmax = 0;
            int subjectmin=0;
            for(int i = 0; i < average.length; i++) {
                if(maxvalue < average[i])
                {
                    maxvalue = average[i];
                    subjectmax = i;
                }
            }
            for(int i = 0; i < average.length; i++) {
                if(minvalue > average[i])
                {
                    minvalue = average[i];
                    subjectmin = i;
                }
            }
            System.out.println("Average in Linear Algebra: "+average[0]);
            System.out.println("Average in Data Structures: "+average[1]);
            System.out.println("Average in Computer Architecture: "+average[2]);
            System.out.println("Average in Discrete Structures: "+average[3]);
            System.out.println("Average in OOPS: "+average[4]);
            System.out.println("Average in Economics: "+average[5]);
            System.out.println("Average in Data Structures Lab: "+average[6]);
            System.out.println("Average in OOPS Lab: "+average[7]);
            System.out.println("Average in EVS: "+average[8]);
            if(subjectmax==0) System.out.println("Best class average in Linear Algebra: "+average[0]);
            if(subjectmax==1) System.out.println("Best class average in Data Structure: "+average[1]);
            if(subjectmax==2) System.out.println("Best class average in Computer Architecture: "+average[2]);
            if(subjectmax==3) System.out.println("Best class average in Discrete Structures: "+average[3]);
            if(subjectmax==4) System.out.println("Best class average in OOPS: "+average[4]);
            if(subjectmax==5) System.out.println("Best class average in Economics: "+average[5]);
            if(subjectmax==6) System.out.println("Best class average in Data Structures Lab: "+average[6]);
            if(subjectmax==7) System.out.println("Best class average in OOPS Lab: "+average[7]);
            if(subjectmax==8) System.out.println("Best class average in EVS: "+average[8]);
            if(subjectmin==0) System.out.println("Worst class average in Linear Algebra: "+average[0]);
            if(subjectmin==1) System.out.println("Worst class average in Data Structure: "+average[1]);
            if(subjectmin==2) System.out.println("Worst class average in Computer Architecture: "+average[2]);
            if(subjectmin==3) System.out.println("Worst class average in Discrete Structures: "+average[3]);
            if(subjectmin==4) System.out.println("Worst class average in OOPS: "+average[4]);
            if(subjectmin==5) System.out.println("Worst class average in Economics: "+average[5]);
            if(subjectmin==6) System.out.println("Worst class average in Data Structures Lab: "+average[6]);
            if(subjectmin==7) System.out.println("Worst class average in OOPS Lab: "+average[7]);
            if(subjectmin==8) System.out.println("Worst class average in EVS: "+average[8]);
        }
        else if(ch==4){
            System.out.println("Enter Roll No.");
            String rollno=s.next();
            System.out.println("Student cgpa is "+cgpa_diff(rollno)+" than class Average cgpa");
        }

    }

    public static void saverecord(String path, String rollno, String name, double la_mark, double ds_mark,double ca_mark, double discrete_mark, double oop_mark, double eco_mark, double ds_lab_mark, double oop_lab_mark, double environment_mark) {
        try {
            FileWriter fw=new FileWriter(path,true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println(rollno+","+name+","+la_mark+","+ds_mark+","+ca_mark+","+discrete_mark+","+oop_mark+","+eco_mark+","+ds_lab_mark+","+oop_lab_mark+","+environment_mark);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static double cgpa(String rno){
        String path = "";//Enter the filepath of CSV file within double quotes
        String line = "";
        int count = 0;
        double cgpa=0;
        rno=rno.toUpperCase();
        int req_line;
        if(rno.substring(2, 6).equals("IZUS")){
            req_line=Integer.parseInt(rno.substring(6,9))+57;
        }
        else{
            req_line=Integer.parseInt(rno.substring(4,6))+3;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(count==req_line){
                    cgpa=((Double.valueOf(values[2])*3)+(Double.valueOf(values[3])*3)+(Double.valueOf(values[4])*3)+(Double.valueOf(values[5])*3)+(Double.valueOf(values[6])*3)+(Double.valueOf(values[7])*3)+(Double.valueOf(values[8])*3)+(Double.valueOf(values[9])*3)+(Double.valueOf(values[10])*3))/27;
                    System.out.println(line);

                }
                count+=1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cgpa;
    }
    public static double[] average(){
        String path = ""; //Enter the filepath of CSV file within double quotes
        String line = "";
        double[] ave=new double[9];
        Scanner sc = new Scanner(System.in);
        for(int i=2;i<=10;i++) {
            double sum = 0;
            int count = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    double mark = 0;
                    try {
                        mark = Double.parseDouble(values[i]);
                    } catch (NumberFormatException nfe) {
                        continue;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                    sum += mark;
                    count += 1;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ave[i-2]=sum/count;
        }
        return ave;

    }
    public static double cgpa_diff(String rollno){
        double[] average=average();
        double avg_cgpa=(average[0]*3+average[1]*3+average[2]*3+average[3]*3+average[4]*3+average[5]*3+average[6]*3+average[8]*3+average[8]*3)/27;
        double cgpa=cgpa(rollno);
        System.out.println("Average class cgpa: "+avg_cgpa);
        System.out.println("Student cgpa: "+cgpa);
        return (cgpa-avg_cgpa);
    }

}

