
package os_project2;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OS_Project2 {

    
    public static void main(String[] args) {
        
      
         //createWindow();
         System.out.println("Enter the Diractory");
         Scanner input = new Scanner(System.in);
         String p = input.nextLine();
         File filePath = new File(p);
         File fileList[] =filePath.listFiles();
         
         int numOfThreads =fileList.length;
         Thread[] threads = new Thread[numOfThreads];
         
         final int filePerThread = fileList.length /numOfThreads ;
         for(int t=0 ; t<numOfThreads ;t++){
             final int thread =t ;
             threads[t]= new Thread(){
                 public void run(){
                     try {
                         runThread(fileList , numOfThreads , thread ,filePerThread);
                     } catch (FileNotFoundException ex) {
                         Logger.getLogger(OS_Project2.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (IOException ex) {
                         Logger.getLogger(OS_Project2.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }

                 
             };
             
         }
         
         for(Thread t1 :threads)
             t1.start();
         
      
    }
    
    
     private static void runThread(File[] fileList, int numOfThreads, int thread, int filePerThread) throws FileNotFoundException, IOException {
         List<File> inFiles=new ArrayList<> ();
         for (int i =thread*filePerThread; i <(thread+1)*filePerThread ; i++) {
             
             inFiles.add(fileList[i]);
             
             
             
             
             
         }
                  
         for(File file:inFiles){
              String path =file.getPath(); 
             // if(file.getName().contains("file_1")){
                  System.err.println("File Name : " + file.getName());
                  int numberOfWord=Words(path);
                  System.out.println("The number of words : "+numberOfWord +" in "+file.getName() );  
                  int u= NumOfYou(path);
                  System.out.println("The number of'you'  : "+u+" in "+file.getName());
                  int is= NumOfIs(path) ;
                  System.out.println("The number of 'is'  : "+is+" in "+file.getName() );
                  int are=NumOfAre(path);
                  System.out.println("The number of 'are' : "+are+" in "+file.getName());
                  String Short=ShortestWord (path);
                  System.out.println("The shortest word   : "+"'"+Short+"'" +" in "+file.getName());
                  String Long=LongestWord(path);
                  System.out.println("The longest word    : "+"'"+Long+"'"+" in "+file.getName());                  
                  System.out.println("------------------------------------------");
        //      }
               
          
             
             String s =getString (file);
            // String  num_of_Word=numberOfWord(s ,file);
                                     
//             String Short=ShortestWord (path);
//             System.out.println("The shortest word in file " + file.getName() + " is "+"'"+Short+"'");
//             String Long=LongestWord(path);
//             System.out.println("The longest word in file " + file.getName() + " is "+"'"+Long+"'");
          //    int numberOfWord=Words(path);
            //  System.out.println("The number of words in file " +file.getName()+ " is " +numberOfWord);
//             int u= Find_Number_Of_You(path);
//             System.out.println("Number of 'you' in File " +file.getName() +" = " +u);
//             int is= Find_Number_Of_Is(path) ;
//             System.out.println("Number of 'is' in File " +file.getName() +" = " +is);
//             int are= Find_Number_Of_You(path);
//             System.out.println("Number of 'are' in File " +file.getName() +" = " +are);
             
             
        //     System.out.println("Processing "+file.getName()+"FilePathe is : "+file.getAbsolutePath() + "inThread Num : "+Thread.currentThread().getName());
         }
         
         
 }                
    

        
  public static String getString (File filee){
       try {
            File file = new File(filee.getAbsolutePath());    //creates a new file instance  
            FileReader fr = new FileReader(file);   //reads the file  
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream  
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters  
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);      //appends line to string buffer  
                sb.append("\n");     //line feed   
            }
            fr.close(); 
           return sb.toString() ;
            //closes the stream and release the resources  
            //System.out.println("Contents of File: ");
          // System.out.println(sb.toString());   //returns a string that textually represents the object  
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       
        return null ;
      
      
  }
  
  
  
  public static int NumOfYou(String path) throws IOException {

        //
        File file = new File(path);
        //
        Scanner sc = new Scanner(file);
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int NumberOfYou = 0;
        //
        while ((line = bufferedReader.readLine()) != null) {
            //
            while(sc.hasNext()){
                String s = "you";
                if(sc.next().equals(s)){
                    NumberOfYou ++;
                    
                }
            }
        }
        //
        return NumberOfYou;
       
    }

    //        
    public static int NumOfIs(String path) throws IOException {
 File file = new File(path);
        //
        Scanner sc = new Scanner(file);
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int NumberOfIs = 0;
        //
        while ((line = bufferedReader.readLine()) != null) {
            //
            while(sc.hasNext()){
                String s = "is";
                if(sc.next().equals(s)){
                    NumberOfIs ++;
                    
                }
            }
        }
        //
        return NumberOfIs;

    }

    //        
    public static int NumOfAre(String path) throws IOException {

        File file = new File(path);
        //
        Scanner sc = new Scanner(file);
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int NumberOfAre = 0;
        //
        while ((line = bufferedReader.readLine()) != null) {
            //
            while(sc.hasNext()){
                String s = "are";
                if(sc.next().equals(s)){
                    NumberOfAre ++;
                    
                }
            }
        }
        //
        return NumberOfAre;
  
  
  
   
}
    
     public static String LongestWord(String path) throws IOException {
          File file = new File(path);
        //
        Scanner sc = new Scanner(file);
        //
        String LongestWord = sc.next();
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        //
        while ((line = bufferedReader.readLine()) != null) {
            //
            String current;
            while (sc.hasNext()) {
                current = sc.next();
                if (current.length() > LongestWord.length()) {
                    LongestWord = current;
                }
            }
        }
        //
        return LongestWord;
    }

    private static String ShortestWord(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        //
        Scanner sc = new Scanner(file);
        //
        String ShortestWord = sc.next();
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        //
        while ((line = bufferedReader.readLine()) != null) {
            //
            String current;
            while (sc.hasNext()) {
                current = sc.next();
                if (current.length() < ShortestWord.length()) {
                    ShortestWord = current;
                }
            }
        }
        //
        return ShortestWord;
    }

    private static int Words(String path) throws FileNotFoundException, IOException {
       
        //
        File file = new File(path);
        //
        FileInputStream fileInputStream = new FileInputStream(file);
        //
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int paraCount=0;
        int wordCount =0;
        int whiteSpaceCount =0 ;
        int sentenceCount =0 ;
        //
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                paraCount += 1;
            } else {
                String words[] = line.split("\\s+");
                wordCount += words.length;
                whiteSpaceCount += wordCount - 1;
                String sentence[] = line.split("[!?.:]+");
                sentenceCount += sentence.length;
            }
        }
        //
        return wordCount;
    }

       
     
    

       
    
}



