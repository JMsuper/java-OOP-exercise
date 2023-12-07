package org.example;

import java.util.ArrayList;

public class ListItem {
    private String sentence;
    private ArrayList<ListItem> subItemList;
    private char separator;

    public ListItem(String sentence){
        this(sentence,'*');
    }

    public ListItem(String sentence, char separator){
        this(sentence,separator,new ArrayList<>());
    }

    public ListItem(String sentence, char separator, ArrayList<ListItem> subItemList){
        this.sentence = sentence;
        this.separator = separator;
        this.subItemList = subItemList;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%c %s%s",this.separator,this.sentence,System.lineSeparator()));
        for(ListItem listItem : subItemList){
            sb.append(listItem.toString(1));
        }
        return sb.toString();
    }

    private String toString(int depth){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%c %s%s",
                makeForwardSpaceTo(depth),this.separator,this.sentence,System.lineSeparator()));
        int newDepth = depth + 1;
        for(ListItem listItem : subItemList){
            sb.append(listItem.toString(newDepth));
        }
        return sb.toString();
    }

    private String makeForwardSpaceTo(int depth){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < depth ; i++){
            sb.append("    ");
        }
        return sb.toString();
    }

    public void addSublistItem(ListItem listItem){
        subItemList.add(listItem);
    }

    public void removeSublistItem(int index){
        if(subItemList.size() == 0){
            return;
        }
        if(index > -1 && index < subItemList.size()){
            subItemList.remove(index);
        }
    }
}
