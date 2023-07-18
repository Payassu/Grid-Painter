package org.academiadecodigo.heroisDoVar;
import java.io.*;

public class DataSaver {

    public String readFile(String filePath) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        String result = "";

        for(int i = 0; i < Grid.ROWS; i++){
            line = bufferedReader.readLine();
            String[] lineArr = line.split("");
            for(int j = 0; j < Grid.COLS; j++){
                if (lineArr[j].equals("1")) {
                Grid.grid[j][i].draw();
                Grid.grid[j][i].setColor(Cursor.cursor.getColor());
                Grid.grid[j][i].fill();
                Grid.grid[j][i].setPainted(true);
                }
            }
        }

        bufferedReader.close();
        return result;
    }

    public void writeFile(String filePath) throws IOException{

        FileWriter writer = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for(int i = 0; i < Grid.ROWS; i++){
            for(int j = 0; j < Grid.COLS; j++){
                if (!Grid.grid[j][i].isPainted()) {
                    bufferedWriter.write("0");
                } else{
                    bufferedWriter.write("1");
                }
            }
            bufferedWriter.write("\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

}