import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class java1 {
    public static void Main(String[] args){
        ArrayList<String> names=new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("d");
        names.add("e");
        names.add("f");
        names.add("g");
        names.add("h");
        names.add("i");
        names.add("j");
        names.add("k");
        names.add("l");
        names.add("m");
        names.add("n");
        names.add("o");
        names.add("p");
        names.add("q");
        names.add("r");
        names.add("s");
        names.add("t");
        names.add("w");
        names.add("v");
        names.add("x");
        names.add("y");
        names.add("z");
        names.add("bb");
        names.add("bc");
        names.add("bd");
        names.add("be");
        names.add("bf");
        names.add("bg");
        names.add("bh");
        names.add("bi");
        names.add("bj");
        names.add("bk");
        names.add("bl");



        int maxpergroupmembers=6;
        int numberofgroups=7;
        Collections.shuffle(names);


        List<List<String>>groups=new ArrayList<>();
        for (int i=0;i<numberofgroups;i++) {
            groups.add(new ArrayList<>());
        }
        int groupIndex=0;
        for(String name:names) {
            while (groups.get(groupIndex).size() == maxpergroupmembers) {
                groupIndex = (groupIndex + 1) % numberofgroups;
            }
            groups.get(groupIndex).add(name);
            groupIndex = (groupIndex + 1) % numberofgroups;
        }
            for(int i=0;i<groups.size();i++){
                System.out.println("group"+(i+1)+":"+groups.get(i));
            }
        }
    }

