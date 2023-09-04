import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Downloads";
        File file = new File(path);

        FolderSizeCalculator folderSizeCalculator = new FolderSizeCalculator(file);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long size = forkJoinPool.invoke(folderSizeCalculator);
        System.out.println(size);



    }

    public static long getFolderSize(File folder){
        if(folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for(File file : files){
            sum += getFolderSize(file);
        }
        return sum;
    }
}
