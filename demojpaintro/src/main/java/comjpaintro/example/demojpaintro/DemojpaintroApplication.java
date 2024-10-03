package comjpaintro.example.demojpaintro;

import comjpaintro.example.demojpaintro.Entities.Users;
import comjpaintro.example.demojpaintro.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

=======
>>>>>>> 52e0e814aba8e2f5f69e64b660f6f369f00d4170
@SpringBootApplication
public class DemojpaintroApplication {

	public static void main(String[] args) {

//		SpringApplication.run(DemojpaintroApplication.class, args);
		ApplicationContext context = SpringApplication.run(DemojpaintroApplication.class, args);
		UserRepository userRepository =  context.getBean(UserRepository.class);    // making bean

<<<<<<< HEAD
//		1. saving single entry at a time
		Users user = new Users();
		user.setId(1);
		user.setName("hariOm");
		user.setCity("mirzapur");

//		Users user1 = userRepository.save(user);
//		System.out.println(user1);
//
//		System.out.println("user-details");
//		System.out.println(user);




//		2. saving multiple entries at a time
//		Users user1 = new Users();;
//		user1.setId(1);
//		user1.setName("avinash");
//		user1.setCity("Gurgaon");
//		user1.setStatus("backend-developer");
//		Users user2 = new Users();;
//		user2.setId(2);
//		user2.setName("rahul");
//		user2.setStatus("neta");
//		user2.setCity("prayagRaj");
//
//		List<Users>result = List.of(user1,user2);            // List.of comes in JAVA-9
//		Iterable<Users>iteratedUsers = userRepository.saveAll(result);
//
//		iteratedUsers.forEach(eachuser ->{
//			System.out.println(eachuser);
//		});






//		3. update the user
		Optional<Users>optional = userRepository.findById(2);
		Users usernew = optional.get();
		System.out.println("before chage : " + usernew);
		usernew.setName("Rahul Tiwari Pali");
		userRepository.save(usernew);        // it creates new entry if no user exists and if there is user exists then it onlyupdate it.

		System.out.println("after change : " + usernew);






//		4.
//		i)  get one user
//		Optional<Users>optional = userRepository.findById(2);
//		Users usernew = optional.get();

//		ii) get all users
		Iterable<Users>allUsers = userRepository.findAll();
		allUsers.forEach(u->{
			System.out.println(u);
		});

		

=======
		Users user = new Users();
		user.setId(2);
		user.setName("ram");
		user.setCity("everywhere");

		Users user1 = userRepository.save(user);
		System.out.println(user1);

		System.out.println("user-details");
		System.out.println(user);
>>>>>>> 52e0e814aba8e2f5f69e64b660f6f369f00d4170
	}





}