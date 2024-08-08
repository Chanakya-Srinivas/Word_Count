import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;

class ccwc{
    String fileName;
    char option;
    boolean flag;


    private void getByteCount(){
        try{
            InputStreamReader reader = fileName !=null ? new FileReader(fileName) :new InputStreamReader(System.in);
            int byteCount = 0;
            while(reader.read()!=-1) byteCount++;
            System.out.print("  " + byteCount);
        } catch(Exception e){
            System.out.println("File Not Found");
            flag = false;
        }
    }

    private void getNumLines(){
        try{
            BufferedReader reader = new BufferedReader(fileName !=null ?
            new FileReader(fileName) : new InputStreamReader(System.in));
            int lineCount = 0;
            while (reader.readLine() != null) lineCount++;
            reader.close();
            System.out.print("  " + lineCount);
        } catch(Exception e){
            System.out.println("File Not Found");
            flag = false;
        }
    }

    private void getWordCount(){
        try{
            BufferedReader reader = new BufferedReader(fileName !=null ?
            new FileReader(fileName) : new InputStreamReader(System.in));
            int wordCount = 0;
            String words=reader.readLine();
            while(words!=null){
                for(String word : words.split("\\s+")){
                    wordCount++;
                    if(word.length()==1 && !word.matches("[Aa-zZ]"))
                        wordCount--;
                }
                words=reader.readLine();
            }
            reader.close();
            System.out.print("  " + wordCount);
        } catch(Exception e){
            System.out.println("File Not Found");
            flag = false;
        }
    }

    public void getCharCount(){
        try{
            int charCount = 0;
            BufferedReader reader = new BufferedReader(fileName !=null ?
            new FileReader(fileName) : new InputStreamReader(System.in));
            while(reader.read()!=-1){
                charCount++;
            }
            reader.close();
            System.out.print("  " + charCount);
        } catch(Exception e){
            System.out.println("File Not Found");
            flag = false;
        }
    }

    public void getWLCCount(){
        try{
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;
            BufferedReader reader = new BufferedReader(fileName !=null ?
            new FileReader(fileName) : new InputStreamReader(System.in));
            String words=reader.readLine();
            while(words!=null){
                for(String word : words.split("\\s+")){
                    wordCount++;
                    if(word.length()==1 && !word.matches("[Aa-zZ]"))
                        wordCount--;
                }
                lineCount++;
                charCount+=words.length();
                words=reader.readLine();
            }
            reader.close();
            System.out.print("  " + lineCount + "  "+wordCount + "  " + charCount + "  ");
        } catch(Exception e){
            System.out.println("File Not Found");
            flag = false;
        }
    }

    public static void main(String[] args){
        ccwc wc = new ccwc();
        wc.flag = true;
        if(args.length==1 && args[0].charAt(0)!='-'){
            wc.option = '-';
            wc.fileName = args[0];
        } else{
            wc.option = args.length!=0?args[0].charAt(1):'-';
            wc.fileName = args.length<2 ? null: args[1];
        }
        switch(wc.option){
            case 'c': wc.getByteCount();
                break;
            case 'l': wc.getNumLines();
                break;
            case 'w': wc.getWordCount();
                break;
            case 'm': wc.getCharCount();
                break;
            case '-':wc.getWLCCount();
                break;
            default:System.out.println("No Such Option : "+wc.option);
                wc.flag = false;
                break;
        }
        if(wc.flag)
            System.out.println(wc.fileName);
    }
}