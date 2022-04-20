package nextstep.helloworld.jdbc.simpleinsert;

import java.util.HashMap;
import java.util.Map;
import nextstep.helloworld.jdbc.Customer;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SimpleInsertDao {
    private SimpleJdbcInsert insertActor;

    public SimpleInsertDao(DataSource dataSource) {
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    /**
     * Map + insertActor.executeAndReturnKey id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithMap(Customer customer) {
        Map<String, Object> parameters = new HashMap<>(2);
        parameters.put("first_name", customer.getFirstName());
        parameters.put("last_name", customer.getLastName());

        Long newId = insertActor.executeAndReturnKey(parameters).longValue();

        return new Customer(newId, customer.getFirstName(), customer.getLastName());
    }

    /**
     * SqlParameterSource + insertActor.executeAndReturnKey id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithBeanPropertySqlParameterSource(Customer customer) {
        SqlParameterSource paramSource = new MapSqlParameterSource(
                Map.of("first_name", customer.getFirstName(), "last_name", customer.getLastName()));

        Long newId = insertActor.executeAndReturnKey(paramSource).longValue();

        return new Customer(newId, customer.getFirstName(), customer.getLastName());
    }
}