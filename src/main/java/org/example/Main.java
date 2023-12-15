package org.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
//        Data [] arr = new Data[108794];
//        Data [] arr = new Data[108794];
//        CSVReader reader = null;
//        try{
//            radixSort rs = new radixSort();
//            String[] next_line;
//            int index =0;
//            // skip first line
//
//            for(int i=0;i<1;i++){
//                reader = new CSVReader(new FileReader(args[0]));
//                reader.readNext();
//                while((next_line = reader.readNext()) != null){
//                    arr[index] = new Data(Integer.parseInt(next_line[0]), next_line[1]);
//                    index++;
//                }
//            }
//            long diff = System.nanoTime(); // start timing
////            rs.radix_sort(arr, arr.length, 0);
////            rs.radix_sort(arr, arr.length, 1);
//
//            Arrays.sort(arr, new Comparator<Data>() {
//                @Override
//                public int compare(Data o1, Data o2) {
//                    return o1.id - o2.id;
//                }
//            });
//            Arrays.sort(arr, new Comparator<Data>() {
//                @Override
//                public int compare(Data o1, Data o2) {
//                    return o1.name.compareTo(o2.name);
//                }
//            }); // 6467ms
////            Arrays.parallelSort(arr, new Comparator<Data>() {
////                @Override
////                public int compare(Data o1, Data o2) {
////                    return o1.id - o2.id;
////                }
////            });
////            Arrays.parallelSort(arr, new Comparator<Data>() {
////                @Override
////                public int compare(Data o1, Data o2) {
////                    return o1.name.compareTo(o2.name);
////                }
////            }); // 8113ms
//            diff = System.nanoTime() - diff; // stop timing
////            rs.print(arr, arr.length);
//            System.out.printf("time : %d ms\n",diff / 1000000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        Test_case tc;
        boolean with_csv = true, is_shuffle = false;
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("\"test data level\", \"sort time\", \"parallel sort time\", \"data path\"");
        for(int i=0; i<1;i++){
            tc = new Test_case("./test_data_files/A-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/B-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/C-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/D-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/E-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/F-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/G-1.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/H-1(no order).csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/A-2.csv", (i==0)?1:i*10, 0, 7);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/B-2.csv", (i==0)?1:i*10, 0, 7);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/C-2.csv", (i==0)?1:i*10, 0, 5);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/D-2.csv", (i==0)?1:i*10, 0, 5);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/E-2.csv", (i==0)?1:i*10, 0, 27);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/F-2.csv", (i==0)?1:i*10, 0, 1);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/G-2(all fields).csv", (i==0)?1:i*10, 0, 7);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/G-2(default field).csv", (i==0)?1:i*10, 0, 5);
            tc.start(with_csv, is_shuffle);
            tc = new Test_case("./test_data_files/H-2(no order).csv", (i==0)?1:i*10, 0, 5);
            tc.start(with_csv, is_shuffle);
        }

    }
}