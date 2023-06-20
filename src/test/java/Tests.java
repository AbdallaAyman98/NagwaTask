import org.testng.annotations.Test;

public class Tests extends BaseTest{

    @Test
    public void textSample(){
        int actual = homePage.selectLanguage("en")
                .clickSearch()
                .searchLesson("addition")
                .clickLesson(3)
                .clickWorksheet()
                .getQuestionsCount();
        System.out.println("Number of questions displayed is: "+actual);
        //Assertions
    }

}
