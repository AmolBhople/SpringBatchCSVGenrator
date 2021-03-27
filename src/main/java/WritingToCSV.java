import java.io.FileWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.opencsv.CSVWriter;
import org.apache.commons.lang3.RandomStringUtils;

public class WritingToCSV {
   public static void main(String args[]) throws Exception {


      for (int j = 1; j < 2; j++) {
         Date start1 = new Date();

         //Instantiating the CSVWriter class
         CSVWriter writer = new CSVWriter(new FileWriter("E://Codebase//CSVGenrator//user"+j+".csv"));
         //Writing data to a csv file
//         String line1[] = {"id", "name", "salary", "start_date", "dept"};
         String line1[] = new String[]{"id", "name", "dept", "salary"};

         //Writing data to the csv file
         writer.writeNext(line1);
         //Flushing data from writer to file
         writer.flush();
         Integer id = 1;
         for (int i = 0; i < 1000000; i++) {

            String name = RandomStringUtils.randomAlphabetic(6, 10);
            String uid = RandomStringUtils.randomAlphanumeric(25);
            String num = RandomStringUtils.randomNumeric(6);


            LocalDate start = LocalDate.of(1889, Month.OCTOBER, 14);
            LocalDate end = LocalDate.now();
            LocalDate randomDate = WritingToCSV.between(start, end);

//            String linex[] = {uid, name, num, randomDate.toString(), getDept()};
            String linex[] = {id.toString(), name, getDept(), num};
            writer.writeNext(linex);
            id++;
         }
         writer.flush();
         Date end = new Date();
         long l = end.getTime() - start1.getTime();
         System.out.println("time in milis for "+j+" = " + l);

         System.out.println("Data entered");
      }
   }

   public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
      long startEpochDay = startInclusive.toEpochDay();
      long endEpochDay = endExclusive.toEpochDay();
      long randomDay = ThreadLocalRandom
              .current()
              .nextLong(startEpochDay, endEpochDay);

      return LocalDate.ofEpochDay(randomDay);
   }


   public static String getDept(){

      List<String> list = new ArrayList<>();
      // add 5 element in ArrayList
      list.add("Operations");
      list.add("IT");
      list.add("MECH");
      list.add("HR");
      list.add("GBM");

      List<String> listCode = new ArrayList<>();
      listCode.add("001");
      listCode.add("002");
      listCode.add("003");
      Random rand = new Random();
       return listCode.get(rand.nextInt(listCode.size()));

   }
}