import java.io.*;
import java.util.*;

public class PBL{

public static void Data(Queu q) {
    ArrayList<Crash> c = new ArrayList<Crash>(); // creating arrayList to sort the list
    try {
        BufferedReader br = new BufferedReader(new FileReader("ped_crashes.csv"));//using BufferedReader for reading the csv file
        br.readLine(); //skipping the first heading line
        String s;

        while((s=br.readLine())!=null){
            c.add(new Crash(s));
        }        //using arraylist for sorting purposes 
        c.sort(new Compareror());   //sorting data
        br.close();//closing the br so that it don't show errors
        int index = 0;
    while( index < c.size())  {
        q.add(c.get(index));       
        index++;
    }
    } 
    catch(Exception e){
        System.out.println("Not working");
    }
}
    public static void main(String[] args) {
        Queu q = new Queu();
        Data(q);
        // 3 weathers
        Queu Clear = new Queu();
        q.SearchWeather("Clear", Clear);
        Queu Snow = new Queu();
        q.SearchWeather("Snow", Snow);
        Queu Rain = new Queu();        
        q.SearchWeather("Rain", Rain);
        // Rain.Print();
       //7 days
        Queu Monday = new Queu();
        q.SearchDays("Monday", Monday);
        Queu Tuesday = new Queu();
        q.SearchDays("Tuesday", Tuesday);
        Queu Wednesday = new Queu();
        q.SearchDays("Wednesday",Wednesday);
        Queu Thrusday = new Queu();
        q.SearchDays("Thrusday", Thrusday);
        Queu Friday = new Queu();
        q.SearchDays("Friday",Friday);
        Queu Saturday = new Queu();
        q.SearchDays("Saturday",Saturday);
        Queu Sunday = new Queu();
        q.SearchDays("Sunday", Sunday);

        DeathCount(Monday,Tuesday,Wednesday,Thrusday,Friday,Saturday,Sunday);

        MonthCounter(Rain);

        BinarySearchTree hitAndRun = new BinarySearchTree();
        BinarySearchTree notHitAndRun = new BinarySearchTree();
        fillTree(hitAndRun,notHitAndRun,q);

        System.out.println("Most hit and run are: "+ hitAndRun.max());
        System.out.println("Least hit and run are: "+ hitAndRun.min());
        System.out.println("Most Not hit and run are: "+ notHitAndRun.max());
        System.out.println("Least Not hit and run are: "+ notHitAndRun.min());

        //postulate
        postulate(Monday,Tuesday,Saturday,Sunday);

    }
     public static void fillTree(BinarySearchTree hit_run,BinarySearchTree not_hit_run,Queu q){
        int[] hit = new int[12];
        String[] Months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0;i<Months.length;i++){
            hit[i] = q.MonthSearch(Months[i],"Hit-and-run");
        }
        int[] notHit= new int[12];
        for(int i=0;i<Months.length;i++){
            notHit[i] = q.MonthSearch(Months[i],"Not hit-and-run");
        }
        for (int i=0;i<Months.length;i++ ) {
            hit_run.insert(Months[i],hit[i]);
            not_hit_run.insert(Months[i],notHit[i]);
        }
    }
    
    public static void MonthCounter(Queu rain) {
        int[] months = new int [12];
        // int size = rain.size();
        String[] monthMap ={"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0;i<monthMap.length;i++){
            months[i] = rain.MonthSearch(monthMap[i]);
        }           

        // for(int i=0;i<size;i++){
        //     Crash s = rain.remove();
        //     if(s!=null){
        //     if(s.getMonth().equals("January"))
        //         months[0]+=1;
        //     if(s.getMonth().equals("February"))
        //         months[1]+=1;
        //     if(s.getMonth().equals("March"))
        //         months[2]+=1;
        //     if(s.getMonth().equals("April"))
        //         months[3]+=1;
        //     if(s.getMonth().equals("May"))
        //         months[4]+=1;
        //     if(s.getMonth().equals("June"))
        //         months[5]+=1;
        //     if(s.getMonth().equals("July"))
        //         months[6]+=1;
        //     if(s.getMonth().equals("August"))
        //         months[7]+=1;
        //     if(s.getMonth().equals("Septempber"))
        //         months[8]+=1;
        //     if(s.getMonth().equals("October"))
        //         months[9]+=1;
        //     if(s.getMonth().equals("November"))
        //         months[10]+=1;
        //     if(s.getMonth().equals("December"))
        //         months[11]+=1;
        //     }   
        // }
        // String[] monthMap ={"January","February","March","April","May","June","July","August","September","October","November","December"};
        
        System.out.println("The total number of monthly crashes in Rainy season");
        
        for(int i=0,j=0;i<months.length;i++,j++){
            System.out.println(monthMap[j]+" : "+months[i]);
        }
        
    }

    public static void DeathCount(Queu Monday, Queu Tuesday, Queu Wednesday, Queu Thrusday, Queu Friday, Queu Saturday,Queu Sunday) {
        int[] deadliest = {Monday.size(),Tuesday.size()   ,Wednesday.size()   ,Thrusday.size()   ,Friday.size()   ,Saturday.size()   ,Sunday.size()};
        int pos =0;
        int high=deadliest[0];
        for(int i=0;i<deadliest.length-1;i++){
            if(deadliest[i]<deadliest[i+1]){
            high= deadliest[i+1];
            pos = i+1;
            }
        }    
        switch (pos) {
            case 1:
            System.out.println("The deadliest day of all was: Tuesday \nand deaths were:"+high);                
                break;
        
            case 2:
            System.out.println("The deadliest day of all was: Wednesday \nand deaths were:"+high);
                break;
        
            case 3:
            System.out.println("The deadliest day of all was: Thrusday \nand deaths were:"+high);
                break;
        
            case 4:
            System.out.println("The deadliest day of all was: Friday \nand deaths were:"+high);
                break;
        
            case 5:
            System.out.println("The deadliest day of all was: Saturday \nand deaths were:"+high);
                break;
        
            case 6:
            System.out.println("The deadliest day of all was: Sunday \nand deaths were:"+high);
                break;
        
            default:
            System.out.println("The deadliest day of all was: Monday \nand deaths were:"+high);
                break;
        }
    }

    public static void postulate(Queu monday,Queu tuesday,Queu saturday,Queu sunday){
        int mondaytuesdaysCrashes=0,saturdaysundayCrashes=0;
        Queu[] queues={monday,tuesday,saturday,sunday};
        for(Queu q:queues){
            int size=q.size();
            for(int i=0;i<size;i++){
                String lightCondition=q.remove().getLight();
                if(lightCondition.equals("Dark lighted")){
                    if (monday.equals(q) && tuesday.equals(q)) mondaytuesdaysCrashes++;
                    else if (saturday.equals(q)&& sunday.equals(q)) saturdaysundayCrashes++;
                }
            }
        }
        System.out.println("So, the condition is: "+((mondaytuesdaysCrashes<saturdaysundayCrashes)?"True":"False"));

    }

}


class Compareror implements Comparator<Crash> {
    private static final Map<String, Integer> monthMap = new HashMap<>();
    
    static {
       
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
    }
    @Override
    public int compare(Crash d1, Crash d2) {
        if (d1.getYear() != d2.getYear()) {
            return d1.getYear() - d2.getYear();

        } 
        else if(d1.getMonth()!=d2.getMonth()){
            int monthValue1 = monthMap.get(d1.Month);
            int monthValue2 = monthMap.get(d2.Month);
            return Integer.compare(monthValue1, monthValue2);
        }
        else {
            return d1.getDate() - d2.getDate();
        }
    }
}