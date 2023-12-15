package org.example;

public class Data {
    int id;
    String name;
    String[] value;
    Data(int id, String name) {
        this.id = id;
        this.name = name;

        // construct value arr
        this.value = new String[2];
        this.value[0] = Integer.toString(id);
        this.value[1] = name;
    }
    Data(String [] value, int id_index, int name_index){
        this.value = value;
        this.id = Integer.parseInt(this.value[id_index]);
        this.name = this.value[name_index];
    }
    public void show_all_in_value(){
        for(String i: value){
            System.out.println(i);
        }
    }
}
