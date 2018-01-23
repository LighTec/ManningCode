/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemresourcegetter;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author kell-gigabyte
 */
public class SystemResourceGetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BigDecimal memFree;
        BigDecimal memTotal;
        BigDecimal Cpu;

        int MAXPIXEL = 1024; // the most that can be represented per segment

        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        //while(true){
        BigDecimal memory = new BigDecimal(bean.getTotalPhysicalMemorySize());
        memory = byteToByte(memory, 3);
        BigDecimal memoryFree = new BigDecimal(bean.getFreePhysicalMemorySize());
        memoryFree = byteToByte(memoryFree, 3);
        double CPUload;
        double CPUjava = bean.getProcessCpuLoad();

        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMaximumFractionDigits(3);
        fmt.setMinimumFractionDigits(3);

        memTotal = new BigDecimal(bean.getTotalPhysicalMemorySize());
        memFree = new BigDecimal(bean.getFreePhysicalMemorySize());
        Cpu = new BigDecimal(bean.getSystemCpuLoad());
        CPUload = Cpu.doubleValue();
        int CpuLoad = (int) (Cpu.doubleValue() * 1024);
        System.out.println(Cpu.doubleValue());
        int memLoad = (int) ((1 - (memFree.doubleValue() / memTotal.doubleValue())) * 1024);
        System.out.println("Calculated CPU: " + CpuLoad + ", and calculeted RAM: " + memLoad);
        //double memFree = memoryFree.doubleValue() / memory.doubleValue();

        System.out.println("Total Physical Memory: " + fmt.format(memory) + "GB, which " + fmt.format(memoryFree) + "GB is free.");
        // System.out.println("Meaning that " + fmt.format(memFree * 100) + "% is free.");
        System.out.println("CPU load: " + fmt.format(CPUload * 100) + "%, and " + fmt.format(CPUjava * 100) + "% is being used by this program.");
        // }
    }

    public static BigDecimal byteToByte(BigDecimal num, int times) {
        for (int i = 0; i < times; i++) {
            num = num.divide(new BigDecimal(1024));
        }
        return num;
    }

}
