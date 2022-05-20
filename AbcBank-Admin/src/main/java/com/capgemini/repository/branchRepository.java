package

com.capgemini.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.model.Branch;

public interface branchRepository extends MongoRepository<Branch, Integer> {

}
