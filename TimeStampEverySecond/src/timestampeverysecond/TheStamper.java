/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timestampeverysecond;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kell-gigabyte
 */
public class TheStamper implements Runnable{
    @Override
    public void run() {
        String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}
