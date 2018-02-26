package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.sql.Time;
import java.util.Date;


public class Tachograph {
    Table<Long, Integer, Integer> table;

    public Tachograph(){
        table = HashBasedTable.create();
    }

    public void addElement(Long ido, int position, int speed){
        table.put(ido, position, speed);
    }

    public int getCount(){
        return table.size();
    }
}