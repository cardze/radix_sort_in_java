package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test_case {
    String data_path;
    Data [] arr;
    CSVReader reader=null;
    long exec_time_on_sort=0, exec_time_on_parallel=0;
    int test_data_level; // 10 ~ 1000
    int data_size;
    int id_index, name_index;
    Test_case(String data_path, int test_data_level, int id_index, int name_index){
        this.data_path = data_path;
        this.test_data_level = test_data_level;
        this.id_index = id_index;
        this.name_index = name_index;
        int counter = 0; // for counting the number of rows in data
        try {
            reader = new CSVReader(new FileReader(data_path));
            reader.readNext();
            while((reader.readNext()) != null){
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.data_size = counter;
    }
    public void reset_test_arr() throws IOException {
        arr = new Data[data_size*test_data_level];
        String[] next_line;
        int index =0;
        for(int i=0;i<test_data_level;i++){
            // used as rewind
            reader = new CSVReader(new FileReader(data_path));
            // skip first line
            if(reader.readNext()!=null)
                while((next_line = reader.readNext()) != null){
                    // reader read one line and append one data into data array
                    arr[index] = new Data(next_line, this.id_index, this.name_index);
                    index++;
                }
        }
    }

    public void shuffle_the_data(){
        List<Data> DataList = Arrays.asList(this.arr);
        Collections.shuffle(DataList);
        DataList.toArray(this.arr);
    }

    public void do_the_sort(){
        // mimic the sorting process of postgresql
        Arrays.sort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.id - o2.id;
            }
        });
        Arrays.sort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
    public void do_the_parallelSort(){
        Arrays.parallelSort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.id - o2.id;
            }
        });
        Arrays.parallelSort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    public void printArr(int begin, int end){
        if(begin<0 || end >= data_size*test_data_level){
            System.out.println("Your input is out of range.");
            return;
        }
        for(int i = begin;i<end;i++){
            System.out.println("id: "+this.arr[i].id+" name: "+this.arr[i].name);
        }
    }
    public void print(){
        System.out.println("test data level : "+test_data_level+"\n\tsort time : \t\t\t"+exec_time_on_sort/1000000+"ms\n\tparallel sort time : \t"+exec_time_on_parallel/1000000+"ms");
    }
    public void print_debug_info(){
        System.out.println("Data size : "+this.data_size);
    }
    public void print_csv_format(){
        System.out.println(test_data_level+",\""+exec_time_on_sort+"ns\",\""+exec_time_on_parallel+"ns\",\""+data_path+"\"");
    }
    public void start(boolean with_csv, boolean is_shuffle) throws IOException {
//        this.print_debug_info();
        this.reset_test_arr();
        if(is_shuffle) this.shuffle_the_data();
        exec_time_on_sort = System.nanoTime();
        this.do_the_sort();
        exec_time_on_sort = System.nanoTime() - exec_time_on_sort;
        exec_time_on_parallel = System.nanoTime();
        this.do_the_parallelSort();
        exec_time_on_parallel = System.nanoTime() -exec_time_on_parallel;
        if(with_csv)this.print_csv_format();
        else print();
    }
}
