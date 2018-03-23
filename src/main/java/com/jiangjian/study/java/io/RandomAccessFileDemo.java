package com.jiangjian.study.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public final static int PNUMLEN = 20;
    public final static int DESCLEN = 30;
    public final static int QUANLEN = 4;
    public final static int COSTLEN = 4;

    private final static int RECLEN = 2 * PNUMLEN + 2 * DESCLEN + QUANLEN + COSTLEN;

    private RandomAccessFile raf;

    public RandomAccessFileDemo(String raf) throws FileNotFoundException {
        this.raf = new RandomAccessFile(raf, "rw");
    }


    public void close() {
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int numRecs() throws IOException {
        return (int) (raf.length() / RECLEN);
    }

    public Part read() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < PNUMLEN; i++) {
            sb.append(raf.readChar());
        }
        String partnum = sb.toString().trim();
        sb.setLength(0);
        for (int i = 0; i < DESCLEN; i++) {
            sb.append(raf.readChar());
        }
        String partdesc = sb.toString().trim();
        int qty = raf.readInt();
        int ucost = raf.readInt();
        return new Part(partnum, partdesc, qty, ucost);
    }

    public void write(String partNum, String partDesc, int qty, int ucost) throws IOException {
        StringBuffer sb = new StringBuffer(partNum);
        if (sb.length() > PNUMLEN) {
            sb.setLength(PNUMLEN);
        } else {
            int length = PNUMLEN - sb.length();
            for (int i = 0; i < length; i++) {
                sb.append(" ");
            }
        }
        raf.writeChars(sb.toString());

        sb = new StringBuffer(partDesc);
        if (sb.length() > DESCLEN) {
            sb.setLength(DESCLEN);
        } else {
            int length = DESCLEN - sb.length();
            for (int i = 0; i < length; i++) {
                sb.append(" ");
            }
        }
        raf.writeChars(sb.toString());

        raf.writeInt(qty);
        raf.writeInt(ucost);
    }

    public Part select(int n) throws IOException {
        if (n < 0 || n >= numRecs()) {
            throw new IllegalStateException("n is wrong");
        }
        raf.seek(n * RECLEN);
        return read();
    }

    public void update(int recno, String partnum, String partdesc, int qty, int ucost) throws IOException {
        if (recno < 0 || recno >= numRecs()) {
            throw new IllegalStateException("n is wrong" + recno + "/" + numRecs());
        }
        raf.seek(recno * RECLEN);
        write(partnum, partdesc, qty, ucost);
    }

    public void append(String partnum, String partdesc, int qty, int ucost) throws IOException {
        raf.seek(raf.length());
        write(partnum, partdesc, qty, ucost);
    }

    static void dumpRecords(RandomAccessFileDemo pdb) throws IOException {
        for (int i = 0; i < pdb.numRecs(); i++) {
            Part part = pdb.select(i);
            System.out.print(format(part.getPartnum(), PNUMLEN, true));
            System.out.print(" | ");
            System.out.print(format(part.getDesc(), DESCLEN, true));
            System.out.print(" | ");
            System.out.print(format("" + part.getQty(), 10, false));
            System.out.print(" | ");
            String s = part.getQty() / 100 + "." + part.getUcost() %
            100;
            if (s.charAt(s.length() - 2) == '.') s += "0";
            System.out.println(format(s, 10, false));
        }
        System.out.println("Number of records = " + pdb.numRecs());
        System.out.println();
    }

    static String format(String value, int maxWidth, boolean leftAlign) {
        StringBuffer sb = new StringBuffer();
        int len = value.length();
        if (len > maxWidth) {
            len = maxWidth;
            value = value.substring(0, len);
        }
        if (leftAlign) {
            sb.append(value);
            for (int i = 0; i < maxWidth - len; i++)
                sb.append(" ");
        } else {
            for (int i = 0; i < maxWidth - len; i++)
                sb.append(" ");
            sb.append(value);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        RandomAccessFileDemo pdb = null;
        try {
            pdb = new RandomAccessFileDemo("parts.db");
            if (pdb.numRecs() == 0) {
// Populate the database with records.
                pdb.append("1-9009-3323-4x", "Wiper Blade Micro Edge", 30,
                        2468);
                pdb.append("1-3233-44923-7j", "Parking Brake Cable", 5, 1439);
                pdb.append("2-3399-6693-2m", "Halogen Bulb H4 55/60W", 22, 813);
                pdb.append("2-599-2029-6k", "Turbo Oil Line O-Ring ", 26, 155);
                pdb.append("3-1299-3299-9u", "Air Pump Electric", 9, 20200);
            }
            dumpRecords(pdb);
            pdb.update(1, "1-3233-44923-7j", "Parking Brake Cable", 5, 1995);
            dumpRecords(pdb);
        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            if (pdb != null)
                pdb.close();
        }
    }


    class Part {
        private String partnum;
        private String desc;
        private int qty;
        private int ucost;

        public Part(String partnum, String desc, int qty, int ucost) {
            this.partnum = partnum;
            this.desc = desc;
            this.qty = qty;
            this.ucost = ucost;
        }

        public String getPartnum() {
            return partnum;
        }

        public void setPartnum(String partnum) {
            this.partnum = partnum;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public int getUcost() {
            return ucost;
        }

        public void setUcost(int ucost) {
            this.ucost = ucost;
        }
    }
}
