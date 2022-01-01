import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LogicTest {

    @Test
    void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("asa   hdfhfd fnfn       ghfhh");
        list.add("    fdsa rjfk   jrdfd");
        list.add("hgf 1223    r   ");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("asa hdfhfd fnfn ghfhh");
        answer.add(" fdsa rjfk jrdfd");
        answer.add("hgf 1223 r ");
        Assertions.assertEquals(Logic.spacesBeforeAndAfterPunctuationMarks(Logic.deleteMultipleSpaces(list)), answer);
    }

    @Test
    void test2(){
        ArrayList<String> list = new ArrayList<>();
        list.add("       fhgf fhhfhj   !");
        list.add("hjgfjh       jdf");
        ArrayList<String> answer = new ArrayList<>();
        answer.add(" fhgf fhhfhj!");
        answer.add("hjgfjh jdf");
        Assertions.assertEquals(Logic.spacesBeforeAndAfterPunctuationMarks(Logic.deleteMultipleSpaces(list)), answer);
    }

    @Test
    void test3(){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("a");
        Assertions.assertEquals(Logic.spacesBeforeAndAfterPunctuationMarks(Logic.deleteMultipleSpaces(list)), answer);
    }
    @Test
    void test4(){
        ArrayList<String> list = new ArrayList<>();
        list.add("fgfgf   .abc");
        list.add("vbhgdhg  ?bfdbfddf,bhfhjh");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("fgfgf. abc");
        answer.add("vbhgdhg? bfdbfddf, bhfhjh");
        Assertions.assertEquals(Logic.spacesBeforeAndAfterPunctuationMarks(Logic.deleteMultipleSpaces(list)), answer);
    }
}