import java.io.File;
import java.io.RandomAccessFile;

public class Index {
    File indexFile = null;
    RandomAccessFile raf = null;
    byte[] header = null;

    public Index(String filename){
        indexFile = new File(filename);
        header = new byte[512];
        try {
            indexFile.createNewFile(); 
            //write file header
            raf = new RandomAccessFile(indexFile, "rw");
            String magic = "4337PRJ3";
            byte[] bytes = magic.getBytes("US-ASCII");
            for(int i = 0; i < magic.getBytes().length; i++){
                header[i] = bytes[i];
            }
            raf.seek(0);
            raf.write(header);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
