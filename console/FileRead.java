package console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {
	public static void hasThreadTxt(File file) {
		try{
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inputStreamReader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	System.out.println(line);
            	Thread.sleep(100);
            }
            bufReader.close();
        }catch(IOException e){
            System.out.println("파일 입출력 오류");
        } catch (InterruptedException e) {
			e.printStackTrace();
        }
		
	}
	
	public static void hasNotThreadTxt(File file) {
		try{
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inputStreamReader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	System.out.println(line);

            }
            bufReader.close();
        }
		catch(IOException e){
            System.out.println("파일 입출력 오류");
        }
	}
}
