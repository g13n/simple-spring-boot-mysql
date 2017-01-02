package me.g13n;

import me.g13n.model.Employee;
import me.g13n.model.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    LOGGER.info("Querying 10 employee records");
    jdbcTemplate.query("SELECT * FROM employees LIMIT " + NUM_RECORDS,
        (rs, rowNum) -> new Employee(rs.getInt("emp_no"),
            rs.getDate("birth_date"), rs.getString("first_name"),
            rs.getString("last_name"),
            Gender.fromString(rs.getString("gender")),
            rs.getDate("hire_date"))).
        forEach(employee -> LOGGER.info(employee.toString()));
  }

  @Autowired
  JdbcTemplate jdbcTemplate;

  public static final int NUM_RECORDS = 10;
  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
}
