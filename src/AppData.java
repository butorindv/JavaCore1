import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {

    private String[] header;
    private int[][] data;
    private FileReader fileReader;


    public AppData(FileReader fileReader) {
        this.fileReader = fileReader;

    }

    public AppData(String headerString) {
        this.header = headerString.split(",");
        this.data = getData();
    }

    public String[] getHeader() {
        return header;
    }

    public String getHeaderString() {
        String str = "";
        for (int i = 0; i < getHeader().length; i++) {
            if (getHeader().length - 1 != i) {
                str += getHeader()[i] + ";";
            } else {
                str += getHeader()[i] + "\n";
            }
        }
        return str;
    }

    public int[][] getData() {
        return data;
    }


    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;

    }

    public String stringData() {
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (j != data.length - 1)
                    temp += data[i][j] + ";";
                else temp += data[i][j];
            }
            temp += "\n";
        }
        return temp;
    }

    public static void show2dArray(int[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            System.out.println(Arrays.toString(array2d[i]));
        }
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void readAll() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(getFileReader());
        ArrayList<String> tempList = new ArrayList<>();
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            tempList.add(str);
        }
        bufferedReader.close();
        getFileReader().close();
        String[][] arrStr = new String[tempList.size() - 1][];
        for (int i = 0; i < tempList.size(); i++) {
            if (i == 0) {
                this.header = tempList.get(i).split(";");
            } else {
                arrStr[i - 1] = tempList.get(i).split(";");
            }
        }
        this.data = new int[arrStr.length][arrStr[0].length];
        for (int a = 0; a < arrStr.length; a++) {
            for (int b = 0; b < arrStr[a].length; b++) {
                this.data[a][b] = Integer.parseInt(arrStr[a][b]);
            }
        }
    }
}










