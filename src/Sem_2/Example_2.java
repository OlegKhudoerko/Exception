package Sem_2;
import java.io.*;
import java.util.Arrays;


//📔 Запишите в файл следующие строки:
//        Анна=4
//        Елена=5
//        Марина=6
//        Владимир=?
//        Константин=?
//        Иван=4
//        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный.
//        В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?,
//        заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный
//        от числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
public class Example_2 {
    public static char [][] workWithFile(){
        try(FileReader reader = new FileReader("src/Sem_2/test.txt"))
        {
            char [][] array = new char[7][30];
            char[] buf = new char[256];
            int c;
            int i=0;
            while((c = reader.read(buf))>0){
                if(c < 256){
                    buf = Arrays.copyOf(buf, c + 1);
                }
                buf[buf.length - 1] = ' ';
                for (int j = 0; j < c + 1; j++) {
                    int k = 0;
                    while ((int)buf[j] != 13 && j != c) {
                        System.out.print(buf[j]);
                        array[i][k] = buf[j];
                        if (i==3 && buf[j]=='?'){
                            array[i][k]='8';
                        }
                        if (i==4 && buf[j]=='?'){
                            array[i][k]='1';
                            array[i][k+1]='0';
                            k++;
                        }
                        k++;
                        j++;
                    }
                    System.out.println();

                    i++;
                    j++;
                }
                i++;
            }
            return array;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return new char[][]{};
    }
    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("2.txt", false))
        {
            for(char[] i : workWithFile()){
                System.out.println();
                for(char j : i){
                    if(j == '\0'){
                        writer.append('\n');
                        break;
                    }
                    System.out.print(j);
                    writer.append(j);
                }

            }

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}