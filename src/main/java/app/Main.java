package app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Properties;


@SpringBootApplication
public class Main {

    private static final String APPLICATION_CONFIGURATION_FILE = "app.configuration.properties";

    public static void main(String[] args) {

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(APPLICATION_CONFIGURATION_FILE)) {
            Properties properties = new Properties();
            properties.load(input);

            // Decide app mode from file
            String mode = properties.getProperty("mode");

            if (mode.equals("web")) {
                SpringApplication.run(Main.class, args);
            }
        } catch (Exception ex) {
            System.out.println("Error at starting application...");
            ex.printStackTrace();
        }

        // Test implementation
//        User user = new User();
//        user.setName("Test");
//        user.setPassword("1234");
//        user.setSalary(22);
//        Address address = new Address();
//        address.setCity("Cluj-Napoca");
//        address.setStreet("Dorobantilor");
//        user.setAddress(address);
//
//        UserService userService = ServiceSinglePointAccess.getUserService();
//        User savedUser = userService.save(user);
//
//        Movie movie = new Movie();
//        movie.setName("Infinity War");
//        movie.setPrice(34.0);
//
//        MovieRepository movieRepository = RepositorySinglePointAccess.getMovieRepository();
//        Movie savedMovie = movieRepository.save(movie);
//
//        userService.createReservation(savedUser, savedMovie, new Date());
//        System.out.println(userService.findById(savedUser.getId()));
    }
}
