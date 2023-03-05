import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
class LinkedQueue {
    class Crashes {
        int crashYear, crashDay, speedLimit;
        String timeOfDay, crashMonth, dayOfWeek, lightCondition, weatherCondition, crashIntersection, crashHitAndRun;
        public Crashes(int crashYear,
        String crashMonth, 
        int crashDay, 
        String timeOfDay, 
        String dayOfWeek, 
        String crashIntersection,
        String crashHitAndRun, 
        String lightCondition, 
        String weatherCondition, 
        int speedLimit) 
        {
            this.crashYear = crashYear;
            this.speedLimit = speedLimit;
            this.crashDay = crashDay;
            this.dayOfWeek = dayOfWeek;
            this.timeOfDay = timeOfDay;
            this.crashMonth = crashMonth;
            this.lightCondition = lightCondition;
            this.weatherCondition = weatherCondition;
            this.crashIntersection = crashIntersection;
            this.crashHitAndRun = crashHitAndRun;
        }
//        public String toString() {
//            return crashYear+" "+crashMonth+" "+crashDay;
//        }}
 }
    //outer class->
    String fileLocation="./ped_crashes.csv";
    BufferedReader read;
    String line="";
    Queue<Crashes> queue=new LinkedList<>();

    public void  formMainQueue() throws IOException {
        // Read Csv File;
      /*
        try {
            read=new BufferedReader(new FileReader(fileLocation));
            read.readLine();
            while ((line=read.readLine())!=null){
                String[] data = line.split(",");
//             for (String p:data){
//                 System.out.print(p+" ");
//             }}
//                int crashYear,String crashMonth,int crashDay ,String timeOfDay,String dayOfWeek,String crashIntersection,
//                        String crashHitAndRun,String lightCondition,String weatherCondition,int speedLimit


        Crashes c=new Crashes(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],
                data[7],data[8],Integer.parseInt(data[9]));
             queue.add(c);}



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            read.close();
        }*/

        try  {
            BufferedReader br = new BufferedReader(new FileReader(fileLocation));
            br.readLine();
            String[] data = new String[10];
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                if(isNumber(data[0])&&isNumber(data[9])){
		Crashes newData = new Crashes(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],data[5],data[6],
               data[7],data[8],Integer.parseInt(data[9]));
               queue.add(newData);
		}
            }
            Arrays.toString(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print the data in the queue
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
	public static boolean isNumber(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

    public static void main(String[] args) throws IOException {
     LinkedQueue q=new LinkedQueue();
     q.formMainQueue();
    }

}
