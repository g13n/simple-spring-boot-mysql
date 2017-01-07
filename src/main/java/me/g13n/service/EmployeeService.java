package me.g13n.service;

import com.google.common.collect.ImmutableList;
import java.util.stream.Collectors;
import me.g13n.Application;
import me.g13n.domain.Employee;
import me.g13n.domain.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  public ImmutableList<Employee> list() {
    return jdbcTemplate
        .query("SELECT * FROM employees LIMIT " + NUM_RECORDS,
            (rs, rowNum) -> new Employee(rs.getInt("emp_no"),
                rs.getDate("birth_date"), rs.getString("first_name"),
                rs.getString("last_name"),
                Gender.fromString(rs.getString("gender")),
                rs.getDate("hire_date"))).
            stream()
        .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
  }

  protected static final int NUM_RECORDS = 10;

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;
}
