import java.util.ArrayList;
import java.util.List;

public class P2for2016  {
    public static void main(String[] args){
        LogMessage lgm = new LogMessage("2222");
    }
}

class LogMessage{
    private String machineId;
    private String description;
    private List<LogMessage> messageList;
    public LogMessage(String message)
    {
        int colonIndex = message.indexOf(":");
        machineId = message.substring(0, colonIndex);
        description = message.substring(colonIndex + 1);
    }

    public String getMachineId(String machineId){
        return machineId;
    }

    public String getDescription(String description){
        return description;
    }

    public boolean containsWord(String keyword)
    {
        int keywordIndex = description.indexOf(keyword);

        while(keywordIndex != -1)
        {
            int beforeIndex = keywordIndex - 1;
            int afterIndex = keywordIndex + keyword.length();

            if((beforeIndex == -1 || description.substring(beforeIndex, beforeIndex + 1).equals(" ")) && (afterIndex == description.length() || description.substring(afterIndex, afterIndex + 1).equals(" "))) {
                return true;
            }else {

                keywordIndex = description.indexOf(keyword, keywordIndex + 1);
            }

        }

        return false;
    }

    public ArrayList<LogMessage> removeMessages(String keyword)
    {
        ArrayList<LogMessage> removedMessages = new ArrayList<>();


        for(int i = 0; i < messageList.size(); i++)
        {
            if(messageList.get(i).containsWord(keyword)) {
                removedMessages.add(messageList.remove(i));
                i--;
            }
        }

        return removedMessages;
    }

}