package learn.concepts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                   // 1
public class ConceptsController {

    @GetMapping("/")              // 2
    public String helloWorld() {
        return "Hello world.";    // 3
    }

    @GetMapping("/get")
    public List<String> doGet() {
        return List.of("apple", "orange", "pear", "grape");
    }

    @GetMapping("/product/{name}/more/path")
    public String echo(@PathVariable String name) {
        return name;
    }

    @PostMapping("/post")
    public Pet doPost(@RequestBody Pet pet) {
        return pet;
    }

    @PostMapping("/add/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @PostMapping("/urlencoded")
    public void readFromBody(String name, int age, boolean likesCookies) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Likes Cookies?: " + likesCookies);
    }

    @PutMapping("/put")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void doPut(@RequestBody Pet pet) {
        // do some work
    }

    @DeleteMapping("/delete")
    public void doDelete() {
    }

    @RequestMapping(path = "/multi", method = {RequestMethod.OPTIONS, RequestMethod.TRACE})
    public void handleMultiple() {
    }



}
