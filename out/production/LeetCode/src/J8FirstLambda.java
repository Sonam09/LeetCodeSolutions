import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class J8FirstLambda {
    public static void main(String args[]) {
        /*FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };*/

        FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".java");
         File dir = new File("src");
         File[] files = dir.listFiles(filterLambda);

         for (File f : files) {
              System.out.println(f.getName());
         }
    }
}
