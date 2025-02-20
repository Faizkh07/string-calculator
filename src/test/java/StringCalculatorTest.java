import org.example.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {


    StringCalculator stringCalculator;

    @BeforeEach
    public void getInstance(){
        stringCalculator = new StringCalculator();
    }

//    @AfterEach
//    public void destroy(){
//        stringCalculator = null;
//    }

    @Test
    public void get_zero_for_empty_string_number(){
        Assertions.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void get_a_number_for_single_string(){
        Assertions.assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void get_sum_of_two_numbers(){
        Assertions.assertEquals(5, stringCalculator.add("2,3"));
    }

    @Test
    public void get_sum_of_multiple_numbers(){
        Assertions.assertEquals(10, stringCalculator.add("3,2,4,1"));
    }

    @Test
    public void get_sum_for_newLine(){
        Assertions.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void test_for_negative_numbers(){
        try {
            stringCalculator.add("1,-2,-3,4");
        }catch (IllegalArgumentException e){
            Assertions.assertEquals(e.getMessage(), "Negative numbers not allowed: -2,-3");
        }
    }

    @Test
    public void test_for_other_delimeters(){
        Assertions.assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
    //$

    @Test
    public void test_for_dollar_multiple(){
        Assertions.assertEquals(6, stringCalculator.add("//@\n3@2"));
    }

    @Test
    public void test_for_dollar_multiple_numbers(){
        Assertions.assertEquals(60, stringCalculator.add("//@\n3@2@10@"));
    }
}
