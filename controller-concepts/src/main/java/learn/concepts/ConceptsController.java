package learn.concepts;

import org.springframework.web.bind.annotation.*;

@RestController                   // 1
public class ConceptsController {

    @GetMapping("/")              // 2
    public String helloWorld() {
        return "Hello world.";    // 3
    }

    @GetMapping("/get")
    public void doGet() {
    }

    @GetMapping("/product/{name}/more/path")
    public String echo(@PathVariable String name) {
        return name;
    }

    @PostMapping("/post")
    public void doPost() {
    }

    @PostMapping("/add/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @PutMapping("/put")
    public void doPut() {
    }

    @DeleteMapping("/delete")
    public void doDelete() {
    }

    @RequestMapping(path = "/multi", method = {RequestMethod.OPTIONS, RequestMethod.TRACE})
    public void handleMultiple() {
    }

}
