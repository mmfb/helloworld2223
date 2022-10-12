package pt.iade.HelloWorld.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/java/tester/")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);
    @GetMapping(path = "/author", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Sending the author of this code");
        String name = "Miguel Bugalho";
        int number = 40001654;
        
        String res = "";
        
        res += "Done by "+name+" with number "+number+"\n";

        return res;
    }   


    @GetMapping(path = "/access/{student}/{covid}",
             produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent,
                @PathVariable("covid") boolean hasCovid) {
        
        return (isStudent && !hasCovid);
    }

    private double grades[] = {10.5, 12, 14.5};
    private String ucs[] = {"FP","POO","BD"};

    @GetMapping(path = "/grades/average",
             produces= MediaType.APPLICATION_JSON_VALUE)
    public double getAverage() {
        double sum = 0;

        for (double grade : grades) {
            sum += grade;
        }
        /* 
        for (int i = 0; i < grades.length; i++) {
            double grade = grades[i];
            sum += grade;
        }
         */
        
        return sum/grades.length;
    }

    @GetMapping(path = "/units/{name}/grade",
             produces= MediaType.APPLICATION_JSON_VALUE)
    public double getGradeByUnitName(@PathVariable("name") String name) {
        for (int i = 0; i < ucs.length; i++) {
            if (ucs[i].equals(name)) {
                return grades[i];
            }
        }
        return -1;
    }






}
