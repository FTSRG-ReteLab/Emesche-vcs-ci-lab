package hu.bme.mit.train.sensor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TachographTest {

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	
    @Test
    public void Test() {
        Tachograph t = new Tachograph();
        long ido = dateobj.getTime();
        t.addElement(ido, 10, 10);
        t.addElement(ido, 30, 20);

        Assert.assertEquals(t.getCount(), 2);
    }
}